package projlab.commands;

import projlab.Prototype;
import projlab.Steppable;
import projlab.Timer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Betölti a fájlban lévő állapotot.
 */
public class LoadCommand implements ICommand {
    @Override
    public void run(String[] args) {
        try (FileInputStream fileIn = new FileInputStream(args[0]);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Prototype.setObjects((LinkedHashMap<String, Object>) in.readObject());
            Timer.instance().setSteppables((ArrayList<Steppable>) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
