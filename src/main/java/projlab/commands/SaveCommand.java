package projlab.commands;

import projlab.Prototype;
import projlab.Timer;

import java.io.*;

/**
 * Elmenti a program állapotát a megadott fájlba.
 */
public class SaveCommand implements ICommand {
    @Override
    public void run(String[] args) {
        
        try(FileOutputStream fileOut = new FileOutputStream(args[0]); ObjectOutputStream out = new ObjectOutputStream(fileOut)) { 
            out.writeObject(Prototype.getObjects());
            out.writeObject(Timer.instance().getSteppables());
            System.out.println("Állapot sikeresen elmentve a " + args[0] + " fájlba.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
