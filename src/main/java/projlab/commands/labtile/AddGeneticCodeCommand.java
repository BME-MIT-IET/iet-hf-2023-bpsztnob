package projlab.commands.labtile;

import projlab.Prototype;
import projlab.commands.ICommand;
import projlab.geneticcode.GeneticCode;
import projlab.tile.LabTile;

/**
 * Beállítja azt, hogy melyik genetikai kódot lehet megtanulni az adott laboron.
 */
public class AddGeneticCodeCommand implements ICommand {
    @Override
    public void run(String[] args) {
        String objectName = args[0];
        LabTile tile = (LabTile) Prototype.getObjects().get(objectName);

        String codeName = args[2];
        GeneticCode code = (GeneticCode) Prototype.getObjects().get(codeName);
        tile.addGeneticCode(code);
        System.out.println("Genetikai kód sikeresen hozzáadva.");
    }
}
