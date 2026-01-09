package cz.cvut.fit.niadp.mvcgame.memento;

import java.io.*;

public class FileManager {

    public void saveObjectToAFile(String filePath, Object object) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public Object loadObjectFromFile(String filePath) {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Object memento = in.readObject();
            return memento;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Object();
    }
}