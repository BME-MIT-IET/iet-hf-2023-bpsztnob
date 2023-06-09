package projlab.tile;

import projlab.Skeleton;
import projlab.Steppable;
import projlab.equipment.Equipment;
import projlab.util.Constants;

import java.io.Serializable;

/**
 * Az óvóhely mezőn találhatóak a felszerelések.
 */
public class ShelterTile extends Tile implements Steppable, Serializable {
    /**
     * A felszerelés, ami a mezőn generálódik.
     */
    private Equipment equipmentRespawning;
    /**
     * A felszerelés, ami az adott pillanatban található.
     */
    private Equipment equipment;
    /**
     * A felszerelés újragenerálásához hátralévő idő.
     */
    private int counter;
    /**
     * A felszerelés újragenerálásának ideje.
     */
    private static final int RESPAWN_TIME = 3;

    /**
     * ShelterTile ctor
     */
    public ShelterTile() {
        super();
        counter = RESPAWN_TIME;
    }

    /**
     * Visszaadja a mezőn található felszerelést.
     *
     * @return a mezőn található felszerelés.
     */
    @Override
    public Equipment getEquipment() {
        Skeleton.printWithTabs("ShelterTile.getEquipment(): Equipment");
        Skeleton.increaseTabs();

        Equipment equipment1 = this.equipment;
        this.equipment = null;

        Skeleton.printWithTabs("return equipment");
        Skeleton.decreaseTabs();
        return equipment1;
    }

    /**
     * Hozzáadja a mezőhőz a paraméterül kapott felszerelést, ha a mezőn még nincs
     * felszerelés.
     *
     * @param equipment a felszerelés, amelyet hozzá kell adni a mezőhőz.
     */
    public void addEquipment(Equipment equipment) {
        Skeleton.printWithTabs("ShelterTile.addEquipment(equipment)");
        Skeleton.increaseTabs();

        if (this.equipmentRespawning == null) {
            this.equipmentRespawning = equipment;
            this.equipment = equipmentRespawning.clone();
        }

        Skeleton.printWithTabs(Constants.RETURN);
        Skeleton.decreaseTabs();
    }

    /**
     * Számláló értékét csökkenti eggyel. Ha eléri a 0-t, akkor létrehoz egy új
     * felszerelést, majd visszaállítja a számlálót eredeti értékére.
     */
    public void step() {
        Skeleton.printWithTabs("ShelterTile.step()");
        Skeleton.increaseTabs();

        if (counter <= 0 && equipment == null) {
            Skeleton.printWithTabs("if (counter <= 0 && equipment == null) : true");
            Skeleton.increaseTabs();

            equipment = equipmentRespawning.clone();
            counter = RESPAWN_TIME;

            Skeleton.decreaseTabs();
        } else {
            counter--;
        }

        Skeleton.printWithTabs(Constants.RETURN);
        Skeleton.decreaseTabs();
    }
}
