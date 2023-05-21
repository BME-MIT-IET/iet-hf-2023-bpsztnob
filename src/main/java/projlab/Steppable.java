package projlab;

import java.io.Serializable;

/**
 * Egy interfész, ami minden olyan dolgot reprezentál, amely időben lépni tud.
 */
public interface Steppable extends Serializable{
    /**
     * Az adott lépésben végrehajtandó művelet.
     */
    public void step();
}
