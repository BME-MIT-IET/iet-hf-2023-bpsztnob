package projlab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * A tesztesetek kiválasztásáért és a futtatott függvények kiiratásáért felelős.
 */
public class Skeleton {
    private static boolean skeletonMode = false;
    /**
     * A teszteseteket eltároló LinkedHashMap.
     */
    private static LinkedHashMap<String, Runnable> testCases = new LinkedHashMap<>();
    /**
     * Megmondja, hogy mennyire legyen beljebb identálva a függvényhívások.
     */
    private static int numberOfTabs = 0;

    public static void setSkeletonMode(boolean _skeletonMode) {
        skeletonMode = _skeletonMode;
    }

    /**
     * Megnöveli az identálást.
     */
    public static void increaseTabs() {
        numberOfTabs++;
    }

    /**
     * Csökkenti az identálást.
     */
    public static void decreaseTabs() {
        numberOfTabs--;
    }

    /**
     * Kiiratja a paraméterben megadott függvényhívást identálva.
     *
     * @param text a függvényhívás szöveges formában
     */
    public static void printWithTabs(String text) {
        if (skeletonMode) {
            for (int i = 0; i < numberOfTabs; i++) {
                System.out.print('\t');
            }
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        skeletonMode = true;

        testCases.put("MakingStunAgent", TestCases::makingStunAgent);
        testCases.put("MakingDancingAgent", TestCases::makingDancingAgent);
        testCases.put("MakingProtectionAgent", TestCases::makingProtectionAgent);
        testCases.put("MakingAmnesiaAgent", TestCases::makingAmnesiaAgent);

        testCases.put("MovingToNeighbourTile", TestCases::movingToNeighbourTile);
        testCases.put("MovingWhileStunned", TestCases::movingWhileStunned);
        testCases.put("MovingWhileDancing", TestCases::movingWhileDancing);
        testCases.put("MovingToNotNeighbourTile", TestCases::movingToNotNeighbourTile);

        testCases.put("LearningNewGeneticCodeWhileStunned", TestCases::learningNewGeneticCodeWhileStunned);
        testCases.put("LearningNewGeneticCode", TestCases::learningNewGeneticCode);
        testCases.put("LearningOldGeneticCode", TestCases::learningOldGeneticCode);
        testCases.put("LearningNewGeneticCodeAndWinningTheGame", TestCases::learningNewGeneticCodeAndWinningTheGame);

        testCases.put("PickupMaterialWhileStunned", TestCases::pickupMaterialWhileStunned);
        testCases.put("PickupMaterialFromNonStorageTile", TestCases::pickupMaterialFromNonStorageTile);
        testCases.put("PickupMaterialFromLoadedStorage", TestCases::pickupMaterialFromLoadedStorage);
        testCases.put("PickupMaterialWhileFull", TestCases::pickupMaterialWhileFull);
        testCases.put("PickupMaterialWhileFullAndBackpackNotFull",
                TestCases::pickupMaterialWhileFullAndBackpackNotFull);
        testCases.put("PickupMaterialWhileFullAndBackpackIsFull", TestCases::pickupMaterialWhileFullAndBackpackIsFull);

        testCases.put("PickupEquipmentWhileStunned", TestCases::pickupEquipmentWhileStunned);
        testCases.put("PickupEquipmentFromNoneShelterTile", TestCases::pickupEquipmentFromNoneShelterTile);
        testCases.put("PickupEquipmentFromEmptyShelter", TestCases::pickupEquipmentFromEmptyShelter);
        testCases.put("PickupGlovesEquipmentFromShelter", TestCases::pickupGlovesEquipmentFromShelter);
        testCases.put("PickupCoatEquipmentFromShelter", TestCases::pickupCoatEquipmentFromShelter);
        testCases.put("PickupBackpackEquipmentFromShelter", TestCases::pickupBackpackEquipmentFromShelter);
        testCases.put("PickupEquipmentWhileFull", TestCases::pickupEquipmentWhileFull);

        testCases.put("InfectSelfWithGlovesCoatProtectionAgent", TestCases::infectSelfWithGlovesCoatProtectionAgent);
        testCases.put("InfectWhileStunned", TestCases::infectWhileStunned);

        testCases.put("StealFromNonStunnedVirologist", TestCases::stealFromNonStunnedVirologist);
        testCases.put("StealWhileStunned", TestCases::stealWhileStunned);
        testCases.put("StealFromStunnedVirologistMaterials", TestCases::stealFromStunnedVirologistMaterials);
        testCases.put("StealFromStunnedVirologistMaterialsWhileFull",
                TestCases::stealFromStunnedVirologistMaterialsWhileFull);
        testCases.put("StealFromStunnedVirologistCoat", TestCases::stealFromStunnedVirologistCoat);
        testCases.put("StealFromStunnedVirologistBackpackNoMaterial",
                TestCases::stealFromStunnedVirologistBackpackNoMaterial);
        testCases.put("StealFromStunnedVirologistBackpackWithMaterials",
                TestCases::stealFromStunnedVirologistBackpackWithMaterials);
        testCases.put("StealFromStunnedVirologistBackpackWithMaterialsFullEquipment",
                TestCases::stealFromStunnedVirologistBackpackWithMaterialsFullEquipment);

        // Kenés bénultan
        testCases.put("StunnedVirologistUsingStunAgent", TestCases::stunnedVirologistUsingStunAgent);
        testCases.put("StunnedVirologistUsingProtectionAgent", TestCases::stunnedVirologistUsingProtectionAgent);
        testCases.put("StunnedVirologistUsingDancingAgent", TestCases::stunnedVirologistUsingDancingAgent);
        testCases.put("StunnedVirologistUsingAmnesiaAgent", TestCases::stunnedVirologistUsingAmnesiaAgent);

        // Kenés védtelen virológusra
        testCases.put("UsingStunAgentOnNotProtectedVirologist", TestCases::usingStunAgentOnNotProtectedVirologist);
        testCases.put("UsingProtectionAgentOnNotProtectedVirologist",
                TestCases::usingProtectionAgentOnNotProtectedVirologist);
        testCases.put("UsingDancingAgentOnNotProtectedVirologist",
                TestCases::usingDancingAgentOnNotProtectedVirologist);
        testCases.put("UsingAmnesiaAgentOnNotProtectedVirologist",
                TestCases::usingAmnesiaAgentOnNotProtectedVirologist);

        // Kenés köpennyel rendelkező virológusra
        testCases.put("UsingStunAgentOnVirologistWithCoat", TestCases::usingStunAgentOnVirologistWithCoat);
        testCases.put("UsingProtectionAgentOnVirologistWithCoat", TestCases::usingProtectionAgentOnVirologistWithCoat);
        testCases.put("UsingDancingAgentOnVirologistWithCoat", TestCases::usingDancingAgentOnVirologistWithCoat);
        testCases.put("UsingAmnesiaAgentOnVirologistWithCoat", TestCases::usingAmnesiaAgentOnVirologistWithCoat);

        // Kenés védő ágenssel rendelkező virológusra
        testCases.put("UsingStunAgentOnVirologistWithProtectionAgent",
                TestCases::usingStunAgentOnVirologistWithProtectionAgent);
        testCases.put("UsingProtectionAgentOnVirologistWithProtectionAgent",
                TestCases::usingProtectionAgentOnVirologistWithProtectionAgent);
        testCases.put("UsingDancingAgentOnVirologistWithProtectionAgent",
                TestCases::usingDancingAgentOnVirologistWithProtectionAgent);
        testCases.put("UsingAmnesiaAgentOnVirologistWithProtectionAgent",
                TestCases::usingAmnesiaAgentOnVirologistWithProtectionAgent);

        // Kenés kesztyűvel rendelkező virológusra
        testCases.put("UsingStunAgentOnVirologistWithGloves", TestCases::usingStunAgentOnVirologistWithGloves);
        testCases.put("UsingProtectionAgentOnVirologistWithGloves",
                TestCases::usingProtectionAgentOnVirologistWithGloves);
        testCases.put("UsingDancingAgentOnVirologistWithGloves", TestCases::usingDancingAgentOnVirologistWithGloves);
        testCases.put("UsingAmnesiaAgentOnVirologistWithGloves", TestCases::usingAmnesiaAgentOnVirologistWithGloves);

        // Kenés köpennyel és kesztyűvel rendelkező virológusra
        testCases.put("UsingStunAgentOnVirologistWithGlovesAndCoat",
                TestCases::usingStunAgentOnVirologistWithGlovesAndCoat);
        testCases.put("UsingProtectionAgentOnVirologistWithGlovesAndCoat",
                TestCases::usingProtectionAgentOnVirologistWithGlovesAndCoat);
        testCases.put("UsingDancingAgentOnVirologistWithGlovesAndCoat",
                TestCases::usingDancingAgentOnVirologistWithGlovesAndCoat);
        testCases.put("UsingAmnesiaAgentOnVirologistWithGlovesAndCoat",
                TestCases::usingAmnesiaAgentOnVirologistWithGlovesAndCoat);

        // Kenés kesztyűvel egy kesztyűvel rendelkező virológusra
        testCases.put("UsingStunAgentWithGlovesOnVirologistWithGloves",
                TestCases::usingStunAgentWithGlovesOnVirologistWithGloves);
        testCases.put("UsingProtectionAgentWithGlovesOnVirologistWithGloves",
                TestCases::usingProtectionAgentWithGlovesOnVirologistWithGloves);
        testCases.put("UsingDancingAgentWithGlovesOnVirologistWithGloves",
                TestCases::usingDancingAgentWithGlovesOnVirologistWithGloves);
        testCases.put("UsingAmnesiaAgentWithGlovesOnVirologistWithGloves",
                TestCases::usingAmnesiaAgentWithGlovesOnVirologistWithGloves);

        // Kenés köpennyel egy kesztyűvel rendelkező virológusra
        testCases.put("UsingStunAgentWithCoatOnVirologistWithGloves",
                TestCases::usingStunAgentWithCoatOnVirologistWithGloves);
        testCases.put("UsingProtectionAgentWithCoatOnVirologistWithGloves",
                TestCases::usingProtectionAgentWithCoatOnVirologistWithGloves);
        testCases.put("UsingDancingAgentWithCoatOnVirologistWithGloves",
                TestCases::usingDancingAgentWithCoatOnVirologistWithGloves);
        testCases.put("UsingAmnesiaAgentWithCoatOnVirologistWithGloves",
                TestCases::usingAmnesiaAgentWithCoatOnVirologistWithGloves);

        // Kenés védő rajtam védő ágenssel egy kesztyűvel rendelkező virológusra
        testCases.put("UsingStunAgentWithProtectionAgentOnMyselfOnVirologistWithGloves",
                TestCases::usingStunAgentWithProtectionAgentOnMyselfOnVirologistWithGloves);
        testCases.put("UsingProtectionAgentWithProtectionAgentOnMyselfOnVirologistWithGloves",
                TestCases::usingProtectionAgentWithProtectionAgentOnMyselfOnVirologistWithGloves);
        testCases.put("UsingDancingAgentWithProtectionAgentOnMyselfOnVirologistWithGloves",
                TestCases::usingDancingAgentWithProtectionAgentOnMyselfOnVirologistWithGloves);
        testCases.put("UsingAmnesiaAgentWithProtectionAgentOnMyselfOnVirologistWithGloves",
                TestCases::usingAmnesiaAgentWithProtectionAgentOnMyselfOnVirologistWithGloves);

        testCases.put("ProtectionAgentStep", TestCases::protectionAgentStep);
        testCases.put("DancingAgentStep", TestCases::dancingAgentStep);
        testCases.put("StunAgentStep", TestCases::stunAgentStep);
        testCases.put("AmnesiaAgentStep", TestCases::amnesiaAgentStep);
        testCases.put("StorageTileStep", TestCases::storageTileStep);
        testCases.put("VirologistDropMaterials", TestCases::virologistDropMaterials);
        testCases.put("PickupAxe", TestCases::pickupAxe);
        testCases.put("DropEquipment", TestCases::dropEquipment);

        ArrayList<String> keys = new ArrayList<>(testCases.keySet());

        while (true) {
            // Kilistázás
            System.out.println("-1. Exit");
            System.out.println("0. Run all testcases");
            for (int i = 0; i < keys.size(); i++) {
                System.out.println((i + 1) + ". " + keys.get(i));
            }

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (1 <= choice && choice <= keys.size()) {
                runTestCase(keys.get(choice - 1));
            } else if (choice == 0) {
                for (String key : keys) {
                    runTestCase(key);
                }
            } else if (choice == -1) {
                break;
            }

            System.out.println("Press Enter to continue.");
            try {
                System.in.read();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void runTestCase(String testCaseKey) {
        System.out.println("--------------------");
        System.out.println(testCaseKey);
        System.out.println("--------------------");
        testCases.get(testCaseKey).run();
        System.out.println();
        System.out.println();
    }
}
