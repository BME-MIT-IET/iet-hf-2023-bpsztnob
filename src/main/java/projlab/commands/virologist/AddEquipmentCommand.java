package projlab.commands.virologist;

import projlab.Prototype;
import projlab.Virologist;
import projlab.commands.ICommand;
import projlab.equipment.Equipment;

/**
 * Hozzáadja a megadott felszerelést a virológushoz
 */
public class AddEquipmentCommand implements ICommand {
    @Override
    public void run(String[] args) {
        String objectName = args[0];
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String equipmentName = args[2];
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);

        v.addEquipment(equipment);
        System.out.println("Felszerelés sikeresen hozzáadva.");
    }
}
