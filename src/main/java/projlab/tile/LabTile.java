package projlab.tile;

import projlab.Skeleton;
import projlab.geneticcode.GeneticCode;
import projlab.util.Constants;

import java.io.Serializable;

/**
 * A labor mezőben tudják megtanulni a genetikai kódokat a virológusok, amelyek
 * a játék megnyeréséhez kellenek.
 */
public class LabTile extends Tile implements Serializable {
    /**
     * A labor mezőn megtanulható genetikai kód.
     */
    private GeneticCode code = null;

    /**
     * LabTile ctor
     */
    public LabTile() {
        super();
    }

    /**
     * Visszaadja a laborban található genetikai kódot.
     *
     * @return a laborban található genetikai kód.
     */
    @Override
    public GeneticCode learnGeneticCode() {
        Skeleton.printWithTabs("LabTile.learnGeneticCode(): GeneticCode");
        Skeleton.increaseTabs();
        if (code != null) {
            Skeleton.printWithTabs("if (code != null): true");
            Skeleton.increaseTabs();
            GeneticCode clone = code.clone();

            Skeleton.printWithTabs("return clone");
            Skeleton.decreaseTabs();
            Skeleton.decreaseTabs();
            return clone;
        }
        Skeleton.printWithTabs("return null");
        Skeleton.decreaseTabs();
        return null;
    }

    /**
     * A paraméterként kapott genetikai kódot hozzáadja a mezőhőz.
     *
     * @param geneticCode az a genetikai kód, amelyet hozzá kell adni a mezőhőz.
     */
    public void addGeneticCode(GeneticCode geneticCode) {
        Skeleton.printWithTabs("LabTile.addGeneticCode(geneticCode)");
        Skeleton.increaseTabs();

        if (code == null) {
            code = geneticCode;
        }

        Skeleton.printWithTabs(Constants.RETURN);
        Skeleton.decreaseTabs();
    }
}
