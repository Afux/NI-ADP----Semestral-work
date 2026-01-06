package cz.cvut.fit.niadp.mvcgame.memento;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

import java.io.*;
import java.util.Stack;

public class CareTaker {
    private final Stack<Object> mementos = new Stack<Object>();
    private IGameModel model;
    private int maxSaveSlots = MvcGameConfig.MAX_SNAPSHOT_SAVE_SLOTS;
    private String filePrefix = MvcGameConfig.SNAPSHOT_FILE_PREFIX;
    private static int nextSaveSlot = 1;

    private CareTaker() {}

    private static class SingletonHolder {
        private static final CareTaker INSTANCE = new CareTaker();
    }

    public static CareTaker getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setModel(IGameModel model) {
        this.model = model;
    }

    public void createMemento() {
        String fileName = filePrefix + nextSaveSlot;
        if (model != null) {
            saveSnapshotToFile(fileName);
            System.out.println("Snapshot Created");
            //mementos.add(model.createMemento());

        }
    }
    public void restoreMemento() {
        int loadSlot=(nextSaveSlot-1) >= 1 ? (nextSaveSlot-1) : maxSaveSlots;
        String fileName = filePrefix + loadSlot;
        File f = new File(fileName);
        if (model != null && f.exists()) {
            loadSnapshotFromFile(fileName);
            System.out.println("Snapshot restored");

           // model.setMemento(mementos.pop());
        }
    }

    public void saveSnapshotToFile(String filePath) {
        if (model == null) return;

        Object memento = model.createMemento();
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(memento);
            nextSaveSlot = (nextSaveSlot >= maxSaveSlots) ? 1 : (nextSaveSlot +1);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void loadSnapshotFromFile(String filePath) {
        if (model == null) return;
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
             Object memento = in.readObject();
             model.setMemento(memento);
             nextSaveSlot = (nextSaveSlot <= 1) ? maxSaveSlots : (nextSaveSlot -1);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
