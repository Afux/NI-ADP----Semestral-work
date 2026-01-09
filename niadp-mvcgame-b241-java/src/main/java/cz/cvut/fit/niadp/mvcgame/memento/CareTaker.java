package cz.cvut.fit.niadp.mvcgame.memento;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameResources;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

import java.io.File;
import java.util.Stack;

public class CareTaker {
    private final Stack<Object> mementos = new Stack<Object>();
    private IGameModel model;
    private final int maxSaveSlots = MvcGameConfig.MAX_SNAPSHOT_SAVE_SLOTS;
    private final String filePath = MvcGameResources.SNAPSHOTS_STORAGE + MvcGameConfig.SNAPSHOT_FILE_PREFIX;

    private static int nextSaveSlot = 1;
    FileManager manager = new FileManager();

    private CareTaker() {
    }

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
        if (model != null) {
            Object memento = model.createMemento();
            manager.saveObjectToAFile(filePath + nextSaveSlot, memento);
            nextSaveSlot = (nextSaveSlot >= maxSaveSlots) ? 1 : (nextSaveSlot + 1);
        }
    }

    public void restoreMemento() {
        int loadSlot = (nextSaveSlot - 1) >= 1 ? (nextSaveSlot - 1) : maxSaveSlots;
        File f = new File(filePath + loadSlot);
        if (model != null && f.exists()) {
            Object memento = manager.loadObjectFromFile(filePath + loadSlot);
            model.setMemento(memento);

            nextSaveSlot = (nextSaveSlot <= 1) ? maxSaveSlots : (nextSaveSlot - 1);
        }
    }


}
