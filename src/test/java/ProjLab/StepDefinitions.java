package ProjLab;

import io.cucumber.java.en.*;
import projlab.Prototype;
import projlab.Virologist;
import projlab.agent.Agent;
import projlab.agent.AmnesiaAgent;
import projlab.agent.BearDeezNutsInYourMouthAgent;
import projlab.agent.DancingAgent;
import projlab.agent.ProtectionAgent;
import projlab.agent.StunAgent;
import projlab.equipment.AxeEquipment;
import projlab.equipment.BackpackEquipment;
import projlab.equipment.CoatEquipment;
import projlab.equipment.Equipment;
import projlab.equipment.GlovesEquipment;
import projlab.geneticcode.AmnesiaGeneticCode;
import projlab.geneticcode.DancingGeneticCode;
import projlab.geneticcode.GeneticCode;
import projlab.geneticcode.ProtectionGeneticCode;
import projlab.geneticcode.StunGeneticCode;
import projlab.inactiveagent.AmnesiaInactiveAgent;
import projlab.inactiveagent.DancingInactiveAgent;
import projlab.inactiveagent.InactiveAgent;
import projlab.inactiveagent.ProtectionInactiveAgent;
import projlab.inactiveagent.StunInactiveAgent;
import projlab.material.AminoAcidMaterial;
import projlab.material.NucleotideMaterial;
import projlab.tile.DumpsterTile;
import projlab.tile.InfectiousLabTile;
import projlab.tile.LabTile;
import projlab.tile.ShelterTile;
import projlab.tile.StorageTile;
import projlab.tile.Tile;
import projlab.util.LearnGeneticCodeEnum;
import projlab.util.MoveEnum;
import projlab.util.PickupEquipmentEnum;
import projlab.util.Constants;
import projlab.material.Material;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    String actualAnswer = "";

    private String[] allowedClasses = { "AmnesiaAgent", "BearDeezNutsInYourMouthAgent", "DancingAgent",
            "ProtectionAgent", "StunAgent",
            "AxeEquipment", "BackpackEquipment", "CoatEquipment", "GlovesEquipment",
            "AmnesiaGeneticCode", "DancingGeneticCode", "ProtectionGeneticCode", "StunGeneticCode",
            "AmnesiaInactiveAgent", "DancingInactiveAgent", "ProtectionInactiveAgent", "StunInactiveAgent",
            "AminoAcidMaterial", "NucleotideMaterial",
            "DumpsterTile", "LabTile", "ShelterTile", "StorageTile", "InfectiousLabTile", "Tile",
            "Virologist" };

    @Given("object {string}")
    public void create_object(String objectName) {
        if (Arrays.asList(allowedClasses).contains(objectName)) {
            actualAnswer = objectName + " objektum sikeresen létrehozva.";

            switch (objectName) {
                case "AmnesiaAgent":
                    new AmnesiaAgent();
                    break;
                case "BearDeezNutsInYourMouthAgent":
                    new BearDeezNutsInYourMouthAgent();
                    break;
                case "DancingAgent":
                    new DancingAgent();
                    break;
                case "ProtectionAgent":
                    new ProtectionAgent();
                    break;
                case "StunAgent":
                    new StunAgent();
                    break;
                case "AxeEquipment":
                    new AxeEquipment();
                    break;
                case "BackpackEquipment":
                    new BackpackEquipment();
                    break;
                case "CoatEquipment":
                    new CoatEquipment();
                    break;
                case "GlovesEquipment":
                    new GlovesEquipment();
                    break;
                case "AmnesiaGeneticCode":
                    new AmnesiaGeneticCode();
                    break;
                case "ProtectionGeneticCode":
                    new ProtectionGeneticCode();
                    break;
                case "StunGeneticCode":
                    new StunGeneticCode();
                    break;
                case "DancingGeneticCode":
                    new DancingGeneticCode();
                    break;
                case "AmnesiaInactiveAgent":
                    new AmnesiaInactiveAgent(null);
                    break;
                case "DancingInactiveAgent":
                    new DancingInactiveAgent(null);
                    break;
                case "ProtectionInactiveAgent":
                    new ProtectionInactiveAgent(null);
                    break;
                case "StunInactiveAgent":
                    new StunInactiveAgent(null);
                    break;
                case "AminoAcidMaterial":
                    new AminoAcidMaterial();
                    break;
                case "NucleotideMaterial":
                    new NucleotideMaterial();
                    break;
                case "Tile":
                    new Tile();
                    break;
                case "DumpsterTile":
                    new DumpsterTile();
                    break;
                case "LabTile":
                    new LabTile();
                    break;
                case "ShelterTile":
                    new ShelterTile();
                    break;
                case "StorageTile":
                    new StorageTile();
                    break;
                case "InfectiousLabTile":
                    new InfectiousLabTile();
                    break;
                case "Virologist":
                    new Virologist();
                    break;
                default:
                    return;
            }
        }
    }

    @Given("I infect virologist {string} with {string}")
    public void infect_virologist(String virologistName, String agentName) {
        Agent agent = (Agent) Prototype.getObjects().get(agentName);
        Virologist v1 = (Virologist) Prototype.getObjects().get(virologistName);
        v1.getInfected(agent, null);
        actualAnswer = "Virológus sikeresen megfertőzve.";
    }

    @Given("Virologist {string} infects virologist {string} with agent {string}")
    public void virologist_infects_virologist(String infecter, String infected, String agent){
        String objectName = infecter;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String targetName = infected;
        Virologist target = (Virologist) Prototype.getObjects().get(targetName);

        String inactiveAgentName = agent;
        InactiveAgent inactiveAgent = (InactiveAgent) Prototype.getObjects().get(inactiveAgentName);

        if (v.infectVirologistWith(inactiveAgent, target)) {
            actualAnswer ="Inaktív ágens kenése sikeres.";
        } else {
            actualAnswer = "Inaktív ágens kenése sikertelen.";
        }
    }

    @Given("Virologist {string} is dead")
    public void is_dead(String virologist){
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        if (v.isDead()) {
            actualAnswer="Halott.";
        } else {
            actualAnswer="Nem halott.";
        }
    }

    @Given("Virologist {string} learns genetic code")
    public void learn_genetic_code(String virologistName){
        String objectName = virologistName;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        LearnGeneticCodeEnum status = v.learnGeneticCode();

        switch (status) {
            case SUCCESSFUL:
                actualAnswer="Genetikai kód sikeresen megtanulva.";
                break;
            case FAILED:
                actualAnswer="Genetikai kód megtanulása sikertelen.";
                break;
            case ALREADY_LEARNT:
                actualAnswer="Genetikai kód már meg volt tanulva.";
                break;
        }
    }

    @Given("Virologist {string} makes inactive agent {string}")
    public void make_inactive_agent(String virologistName, String codeName){
        String objectName = virologistName;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String geneticCodeName = codeName;
        GeneticCode geneticCode = (GeneticCode) Prototype.getObjects().get(geneticCodeName);

        if (v.makeInactiveAgent(geneticCode)) {
            actualAnswer="Inaktív ágens készítése sikeres.";
        } else {
            actualAnswer="Inaktív ágens készítése sikertelen.";
        }
    }

    @Given("Virologist {string} moves to Tile {string}")
    public void move(String virologist, String t){
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String tileName = t;
        Tile tile = (Tile) Prototype.getObjects().get(tileName);

        MoveEnum status = v.move(tile);
        switch (status) {
            case SUCCESFUL:
                actualAnswer= Constants.MOVING + tileName + Constants.TO_TILE_SUCCESS;
                break;
            case FAILED:
                actualAnswer= Constants.MOVING + tileName + Constants.TO_TILE_FAILED;
                break;
            case RANDOM_TILE:
                actualAnswer= Constants.MOVING + tileName + Constants.TO_TILE_FAILED_RANDOM;
                break;
        }
    }

    @Given("Virologist {string} picks up equipment")
    public void pickup_equipment(String virologist){
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        PickupEquipmentEnum status = v.pickupEquipment();
        switch (status) {
            case SUCCESFUL:
                actualAnswer="Felszerelés felvétele sikeres.";
                break;
            case FAILED:
                actualAnswer="Felszerelés felvétele sikertelen.";
                break;
            case EMPTY:
                actualAnswer="Nincs a mezőn felszerelés.";
                break;
            case FULL:
                actualAnswer="Túl sok felszerelése van a virológusnak.";
                break;
        }
    }


    @Given("Virologist {string} picks up materials {string}")
    public void pickup_materials(String virologist, String materialsString){
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        ArrayList<Material> materials = new ArrayList<>();
        List<String> materialNames = Arrays.asList(materialsString.split(" "));
        for (String names : materialNames) {
            Material material = (Material) Prototype.getObjects().get(names);
            if (!Objects.isNull(material)) {
                materials.add(material);
            }
        }

        if (v.pickupMaterials(materials)) {
            actualAnswer="Anyagok felvétele sikeres.";
        } else {
            actualAnswer="Anyagok felvétele sikertelen.";
        }
    }

    @Given("Virologist {string} removes their equipment {string}")
    public void remove_equipment(String virologist, String equipmentString){
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        String equipmentName = equipmentString;
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);
        v.removeEquipment(equipment);

        actualAnswer = "Felszerelés eltávolítva.";
    }

    @Given("Virologist {string} steals from another Virologist {string} an equipment {string}")
    public void steal_equipment(String virologist1String, String virologsist2String, String equipmentString){
        String virologist1Name = virologist1String;
        Virologist v1 = (Virologist) Prototype.getObjects().get(virologist1Name);
        String virologist2Name = virologsist2String;
        Virologist v2 = (Virologist) Prototype.getObjects().get(virologist2Name);
        String equipmentName = equipmentString;
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);


        boolean steal = v1.stealEquipment(v2, equipment);
        if (steal) {
            actualAnswer="Felszerelés ellopása sikeres.";
        } else {
            actualAnswer ="Felszerelés ellopása sikertelen.";
        }
    }

    @Given("Virologist {string} steals from another Virologist {string} some materials {string}")
    public void steal_materials(String virologist1String, String virologist2String, String materialsString){
        String objectName = virologist1String;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        Virologist target = (Virologist) Prototype.getObjects().get(virologist2String);

        ArrayList<Material> materials = new ArrayList<>();
        List<String> materialNames = Arrays.asList(materialsString.split(" "));
        for (String names : materialNames) {
            Material material = (Material) Prototype.getObjects().get(names);
            if (!Objects.isNull(material)) {
                materials.add(material);
            }
        }

        if (v.stealMaterials(target, materials)) {
            actualAnswer="Anyagok ellopása sikeres.";
        } else {
            actualAnswer="Anyagok ellopása sikertelen.";
        }
    }

    @Given("Virologist {string} uses on another Virologist{string} an equipment {string}")
    public void use_equipment(String virologist1String, String virologist2String, String equipmentString){
        String objectName = virologist1String;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        String targetName = virologist2String;
        Virologist target = (Virologist) Prototype.getObjects().get(targetName);
        String equipmentName = equipmentString;
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);

        v.useEquipment(target, equipment);
        actualAnswer="Felszerelés használva.";
    }

    

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
