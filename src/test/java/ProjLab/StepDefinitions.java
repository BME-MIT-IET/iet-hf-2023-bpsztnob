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
import projlab.material.Material;
import projlab.material.NucleotideMaterial;
import projlab.tile.DumpsterTile;
import projlab.tile.InfectiousLabTile;
import projlab.tile.LabTile;
import projlab.tile.ShelterTile;
import projlab.tile.StorageTile;
import projlab.tile.Tile;
import projlab.util.Util;

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

    @Given("I added {string} genetic code to {string}")
    public void add_genetic_code(String objectName, String codeName) {
        LabTile tile = (LabTile) Prototype.getObjects().get(objectName);
        GeneticCode code = (GeneticCode) Prototype.getObjects().get(codeName);
        tile.addGeneticCode(code);
        actualAnswer = "Genetikai kód sikeresen hozzáadva.";
    }

    @Given("I added to {string} a {string} equipment")
    public void add_equipment(String tileName, String equipmentName) {
        ShelterTile shelterTile = (ShelterTile) Prototype.getObjects().get(tileName);
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);
        shelterTile.addEquipment(equipment);
        actualAnswer = "Felszerelés sikeresen hozzáadva.";
    }

    @Given("I added {string} a {string} material from {string} materials")
    public void add_materials_to_storage_tile(String tileName, String equipmentName, String materialss) {
        StorageTile storageTile = (StorageTile) Prototype.getObjects().get(tileName);
        ArrayList<Material> materials = new ArrayList<>();
        List<String> materialNames = Arrays.asList(materialss.split(" "));
        for (int i = 0; i < materialNames.size(); i++) {
            Material temp = (Material) Prototype.getObjects().get(materialNames.get(i));
            if (!Objects.isNull(temp)) {
                materials.add(materials.size(), temp);
            }
        }
        storageTile.addMaterial(materials);
        actualAnswer = "Anyagok sikeresen hozzáadva.";
    }

    @Given("I list {string} materials")
    public void list_materials(String tileName) {
        StorageTile storageTile = (StorageTile) Prototype.getObjects().get(tileName);
        ArrayList<Material> materials = storageTile.getMaterials();
        for (Material material : materials) {
            String key = Util.getKeyByValue(Prototype.getObjects(), material);
            actualAnswer += key;
        }
        actualAnswer += "\n";
    }

    @Given("I add to {string} its neighbours {string}")
    public void add_neighbours(String objectName, String neighbourss) {
        Tile tile = (Tile) Prototype.getObjects().get(objectName);

        ArrayList<Tile> neighbours = new ArrayList<>();
        List<String> tileNames = Arrays.asList(neighbourss.split(" "));
        for (String name : tileNames) {
            Tile neighbour = (Tile) Prototype.getObjects().get(name);
            if (!Objects.isNull(neighbour)) {
                neighbours.add(neighbour);
            }
        }

        tile.addNeighbours(neighbours);
        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(tile);
        for (Tile neighbour : neighbours) {
            neighbour.addNeighbours(temp);
        }

        actualAnswer = "Szomszéd sikeresen hozzáadva.";
    }

    @Given("I removed neighbours {string} from tile {string}")
    public void remove_neighbours(String neighbourss, String objectName) {
        Tile tile = (Tile) Prototype.getObjects().get(objectName);

        ArrayList<Tile> neighbours = new ArrayList<>();
        List<String> tileNames = Arrays.asList(neighbourss.split(" "));
        for (String tileName : tileNames) {
            Tile neighbour = (Tile) Prototype.getObjects().get(tileName);
            if (!Objects.isNull(neighbour)) {
                neighbours.add(neighbour);
            }
        }
        tile.removeNeighbours(neighbours);
        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(tile);
        for (Tile neighbour : neighbours) {
            neighbour.removeNeighbours(temp);
        }
        actualAnswer = "Szomszéd sikeresen eltávolítva.";
    }

    @Given("I added {string} to {string}")
    public void add_equipment_virologist(String equipmentName, String objectName) {
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);
        v.addEquipment(equipment);
        actualAnswer = "Felszerelés sikeresen hozzáadva.";
    }

    @Given("I added to {string} virologist {string} genetic code")
    public void add_genetic_code_virologist(String objectName, String geneticCodeName) {
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        GeneticCode geneticCode = (GeneticCode) Prototype.getObjects().get(geneticCodeName);

        v.addGeneticCode(geneticCode);
        actualAnswer = "Genetikai kód sikeresen hozzáadva.";
    }

    @Given("I added to {string} virologist {string} inactive ganet")
    public void add_inactive_agent_virologist(String objectName, String inactiveAgentName) {
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        InactiveAgent inactiveAgent = (InactiveAgent) Prototype.getObjects().get(inactiveAgentName);

        v.addInactiveAgent(inactiveAgent);
        actualAnswer = "Inaktív ágens sikeresen hozzáadva.";
    }

    @Given("I added {string} materials to {string}")
    public void add_materials_virologist(String materialss, String objectName) {
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        ArrayList<Material> materials = new ArrayList<>();
        List<String> materialNames = Arrays.asList(materialss.split(" "));
        for (String names : materialNames) {
            Material material = (Material) Prototype.getObjects().get(names);
            if (!Objects.isNull(material)) {
                materials.add(material);
            }
        }

        v.addMaterials(materials);
        actualAnswer = "Anyagok sikeresen hozzáadva.";
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
