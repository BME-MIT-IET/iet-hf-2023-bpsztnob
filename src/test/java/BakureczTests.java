
import projlab.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BakureczTests {
    static String newLine = "\r\n";

    @BeforeAll
    static void checkOS() {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            newLine = "\r\n";
        } else {
            newLine = "\n";
        }
    }

    /**
     * Bénító ágens készítése amikor megvan a genetikai kód és a szükséges anyagok
     * is.
     */
    @Test
    void MakingStunAgent() {
        String input = "Create Virologist" + newLine +
                "Create StunGeneticCode" + newLine +
                "Command Virologist1 AddGeneticCode StunGeneticCode1" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Command Virologist1 AddMaterials AminoAcidMaterial1 AminoAcidMaterial2 NucleotideMaterial1 NucleotideMaterial2 NucleotideMaterial3 NucleotideMaterial4"
                + newLine +
                "Command Virologist1 MakeInactiveAgent StunGeneticCode1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "StunGeneticCode objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "Anyagok sikeresen hozzáadva." + newLine +
                "Inaktív ágens készítése sikeres.", byteArrayOutputStream.toString().trim());
    }

    /**
     * Vitustánc ágens készítése amikor megvan a genetikai kód és a szükséges
     * anyagok is.
     */
    @Test
    void MakingDancingAgent() {
        String input = "Create Virologist" + newLine +
                "Create DancingGeneticCode" + newLine +
                "Command Virologist1 AddGeneticCode DancingGeneticCode1" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Command Virologist1 AddMaterials AminoAcidMaterial1 NucleotideMaterial1 NucleotideMaterial2 NucleotideMaterial3"
                + newLine +
                "Command Virologist1 MakeInactiveAgent DancingGeneticCode1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "DancingGeneticCode objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "Anyagok sikeresen hozzáadva." + newLine +
                "Inaktív ágens készítése sikeres.", byteArrayOutputStream.toString().trim());
    }

    /**
     * Védő ágens készítése amikor megvan a genetikai kód és a szükséges anyagok is.
     */
    @Test
    void MakingProtectionAgent() {
        String input = "Create Virologist" + newLine +
                "Create ProtectionGeneticCode" + newLine +
                "Command Virologist1 AddGeneticCode ProtectionGeneticCode1" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Command Virologist1 AddMaterials AminoAcidMaterial1 AminoAcidMaterial2 AminoAcidMaterial3 AminoAcidMaterial4 AminoAcidMaterial5 AminoAcidMaterial6 AminoAcidMaterial7"
                + newLine +
                "Command Virologist1 MakeInactiveAgent ProtectionGeneticCode1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "ProtectionGeneticCode objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "Anyagok sikeresen hozzáadva." + newLine +
                "Inaktív ágens készítése sikeres.", byteArrayOutputStream.toString().trim());
    }

    /**
     * Amnézia ágens készítése amikor megvan a genetikai kód és a szükséges anyagok
     * is.
     */
    @Test
    void MakingAmnesiaAgent() {
        String input = "Create Virologist" + newLine +
                "Create AmnesiaGeneticCode" + newLine +
                "Command Virologist1 AddGeneticCode AmnesiaGeneticCode1" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create AminoAcidMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Create NucleotideMaterial" + newLine +
                "Command Virologist1 AddMaterials AminoAcidMaterial1 AminoAcidMaterial2 AminoAcidMaterial3 AminoAcidMaterial4 AminoAcidMaterial5 NucleotideMaterial1 NucleotideMaterial2 NucleotideMaterial3 NucleotideMaterial4 NucleotideMaterial5"
                + newLine +
                "Command Virologist1 MakeInactiveAgent AmnesiaGeneticCode1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "AmnesiaGeneticCode objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "AminoAcidMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "NucleotideMaterial objektum sikeresen létrehozva." + newLine +
                "Anyagok sikeresen hozzáadva." + newLine +
                "Inaktív ágens készítése sikeres.", byteArrayOutputStream.toString().trim());
    }

    /**
     * A virológus egy mezőről egy azzal szomszédosra lép.
     */
    @Test
    void MovingToNeighbourTile() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create DumpsterTile" + newLine +
                "Command LabTile1 AddNeighbours LabTile1 DumpsterTile1" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command Virologist1 Move DumpsterTile1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "DumpsterTile objektum sikeresen létrehozva." + newLine +
                "Szomszéd sikeresen hozzáadva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Mozgás DumpsterTile1 mezőre sikeres.", byteArrayOutputStream.toString().trim());
    }

    /**
     * A bénított virológus egy mezőről egy azzal szomszédosra próbál lépni.
     */
    @Test
    void MovingWhileStunned() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create DumpsterTile" + newLine +
                "Create StunAgent" + newLine +
                "Command LabTile1 AddNeighbours LabTile1 DumpsterTile1" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command StunAgent1 Infect Virologist1" + newLine +
                "Command Virologist1 Move DumpsterTile1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "DumpsterTile objektum sikeresen létrehozva." + newLine +
                "StunAgent objektum sikeresen létrehozva." + newLine +
                "Szomszéd sikeresen hozzáadva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Virológus sikeresen megfertőzve." + newLine +
                "Mozgás DumpsterTile1 mezőre sikertelen.", byteArrayOutputStream.toString().trim());
    }

    /**
     * A vitustáncoló virológus egy mezőről egy azzal szomszédosra próbál lépni.
     */
    @Test
    void MovingWhileDancing() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create DumpsterTile" + newLine +
                "Create DancingAgent" + newLine +
                "Command LabTile1 AddNeighbours LabTile1 DumpsterTile1" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command DancingAgent1 Infect Virologist1" + newLine +
                "Command Virologist1 Move DumpsterTile1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "DumpsterTile objektum sikeresen létrehozva." + newLine +
                "DancingAgent objektum sikeresen létrehozva." + newLine +
                "Szomszéd sikeresen hozzáadva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Virológus sikeresen megfertőzve." + newLine +
                "Mozgás DumpsterTile1 mezőre sikertelen. Véletlenszerű mozgás.",
                byteArrayOutputStream.toString().trim());
    }

    /**
     * A virológus egy mezőről egy azzal nem szomszédosra próbál lépni.
     */
    @Test
    void MovingToNotNeighbourTile() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create DumpsterTile" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command Virologist1 Move DumpsterTile1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "DumpsterTile objektum sikeresen létrehozva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Mozgás DumpsterTile1 mezőre sikertelen.", byteArrayOutputStream.toString().trim());
    }

    /**
     * A virológus megtanul egy új genetikai kódot miközben le van bénítva.
     */
    @Test
    void LearningGeneticCodeWhileStunned() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create ProtectionGeneticCode" + newLine +
                "Create StunAgent" + newLine +
                "Command LabTile1 AddGeneticCode ProtectionGeneticCode1" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command StunAgent1 Infect Virologist1" + newLine +
                "Command Virologist1 LearnGeneticCode";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "ProtectionGeneticCode objektum sikeresen létrehozva." + newLine +
                "StunAgent objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Virológus sikeresen megfertőzve." + newLine +
                "Genetikai kód megtanulása sikertelen.", byteArrayOutputStream.toString().trim());
    }

    /**
     * A virológus megtanul egy új genetikai kódot.
     */
    @Test
    void LearningNewGeneticCode() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create ProtectionGeneticCode" + newLine +
                "Command LabTile1 AddGeneticCode ProtectionGeneticCode1" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command Virologist1 LearnGeneticCode\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "ProtectionGeneticCode objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Genetikai kód sikeresen megtanulva.", byteArrayOutputStream.toString().trim());
    }

    /**
     * A virológus megpróbál megtanulni egy régi genetikai kódot.
     */
    @Test
    void LearningOldGeneticCode() {
        String input = "Create Virologist" + newLine +
                "Create LabTile" + newLine +
                "Create ProtectionGeneticCode" + newLine +
                "Command LabTile1 AddGeneticCode ProtectionGeneticCode1" + newLine +
                "Command Virologist1 Move LabTile1" + newLine +
                "Command Virologist1 AddGeneticCode ProtectionGeneticCode1" + newLine +
                "Command Virologist1 LearnGeneticCode";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Prototype.main(new String[] {});

        Assertions.assertEquals("Virologist objektum sikeresen létrehozva." + newLine +
                "LabTile objektum sikeresen létrehozva." + newLine +
                "ProtectionGeneticCode objektum sikeresen létrehozva." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "Mozgás LabTile1 mezőre sikeres." + newLine +
                "Genetikai kód sikeresen hozzáadva." + newLine +
                "Genetikai kód már meg volt tanulva.", byteArrayOutputStream.toString().trim());
    }
}
