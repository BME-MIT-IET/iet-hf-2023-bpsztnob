package ProjLab;

import io.cucumber.java.en.*;
import projlab.Prototype;
import projlab.Steppable;
import projlab.Timer;
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
import projlab.util.Constants;
import projlab.util.CustomRandom;
import projlab.util.LearnGeneticCodeEnum;
import projlab.util.MoveEnum;
import projlab.util.PickupEquipmentEnum;
import projlab.util.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static projlab.util.Util.getKeyByValue;

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

    @Given("that everything is reset")
    public void clear_objects() {
        Prototype.clearObjects();
    }

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

    @Given("I list what {string} objects are on {string}")
    public void list_virologists(String objectType, String virologist) {
        actualAnswer = "";
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        switch (objectType) {
            case "agents":
                ArrayList<Agent> agents = v.getActiveAgents();
                for (Agent agent : agents) {
                    String key = getKeyByValue(Prototype.getObjects(), agent);
                    actualAnswer += key + "\n";
                }
                break;
            case "equipment":
                ArrayList<Equipment> equipment = v.getEquipment();
                for (Equipment e : equipment) {
                    String key = getKeyByValue(Prototype.getObjects(), e);
                    actualAnswer += key + "\n";
                }
                break;
            case "geneticCode":
                ArrayList<GeneticCode> geneticCodes = v.getGeneticCodes();
                for (GeneticCode geneticCode : geneticCodes) {
                    String key = getKeyByValue(Prototype.getObjects(), geneticCode);
                    actualAnswer += key + "\n";
                }
                break;
            case "materials":
                ArrayList<Material> materials = v.getMaterials();
                for (Material material : materials) {
                    String key = getKeyByValue(Prototype.getObjects(), material);
                    actualAnswer += key + "\n";
                }
                break;
            case "inactiveagents":
                ArrayList<InactiveAgent> inactiveAgents = v.getInactiveAgents();
                for (InactiveAgent inactiveAgent : inactiveAgents) {
                    String key = getKeyByValue(Prototype.getObjects(), inactiveAgent);
                    actualAnswer += key + "\n";
                }
                break;
            default:
                return;
        }
    }

    @Given("I add object {string} to steppables")
    public void infect_virologist(String objectName) {
        Steppable steppable = (Steppable) Prototype.getObjects().get(objectName);

        if (!Objects.isNull(steppable)) {
            Timer.instance().addSteppable(steppable);
        }
        actualAnswer = (objectName + " hozzáadva a léptethető objektumokhoz.");
    }

    @Given("I list everything")
    public void list_everything() {
        Prototype.getObjects().forEach((key, value) -> actualAnswer += key + "\n");
    }

    @Given("randomization is set to {string}")
    public void set_randomization(String boolValue) {
        if (boolValue.equals("true")) {
            CustomRandom.setRandomness(true);
            actualAnswer = ("Véletlenszerűség sikeresen átállítva true állapotba.");
        } else if (boolValue.equals("false")) {
            CustomRandom.setRandomness(false);
            actualAnswer = ("Véletlenszerűség sikeresen átállítva false állapotba.");
        }
    }

    @Given("that timer ticks")
    public void timer_tick() {
        java.util.ArrayList<Steppable> steppables = Timer.instance().getSteppables();
        java.util.HashMap<String, Object> objects = Prototype.getObjects();
        for (Steppable s : steppables) {
            String objectKey = Util.getKeyByValue(objects, s);
            if (!Objects.isNull(objectKey)) {
                actualAnswer += (objectKey + " léptetve.\n");
                s.step();
            }
        }
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

    @Given("I added to StorageTile {string} {string} materials")
    public void add_materials_to_storage_tile(String tileName, String materialss) {
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

    @Given("I removed {string} materials from {string}")
    public void dump_materials_virologist(String materialss, String objectName) {
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        ArrayList<Material> materials = new ArrayList<>();
        List<String> materialNames = Arrays.asList(materialss.split(" "));
        for (String names : materialNames) {
            Material material = (Material) Prototype.getObjects().get(names);
            if (!Objects.isNull(material)) {
                materials.add(material);
            }
        }

        if (v.dumpMaterials(materials)) {
            actualAnswer = "Anyagok leadása sikeres.";
        } else {
            actualAnswer = "Anyagok leadása sikertelen.";
        }
    }

    @Given("Virologist {string} infects virologist {string} with agent {string}")
    public void virologist_infects_virologist(String infecter, String infected, String agent) {
        String objectName = infecter;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String targetName = infected;
        Virologist target = (Virologist) Prototype.getObjects().get(targetName);

        String inactiveAgentName = agent;
        InactiveAgent inactiveAgent = (InactiveAgent) Prototype.getObjects().get(inactiveAgentName);

        if (v.infectVirologistWith(inactiveAgent, target)) {
            actualAnswer = "Inaktív ágens kenése sikeres.";
        } else {
            actualAnswer = "Inaktív ágens kenése sikertelen.";
        }
    }

    @Given("Virologist {string} is dead")
    public void is_dead(String virologist) {
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        if (v.isDead()) {
            actualAnswer = "Halott.";
        } else {
            actualAnswer = "Nem halott.";
        }
    }

    @Given("Virologist {string} learns genetic code")
    public void learn_genetic_code(String virologistName) {
        String objectName = virologistName;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        LearnGeneticCodeEnum status = v.learnGeneticCode();

        switch (status) {
            case SUCCESSFUL:
                actualAnswer = "Genetikai kód sikeresen megtanulva.";
                break;
            case FAILED:
                actualAnswer = "Genetikai kód megtanulása sikertelen.";
                break;
            case ALREADY_LEARNT:
                actualAnswer = "Genetikai kód már meg volt tanulva.";
                break;
        }
    }

    @Given("Virologist {string} makes inactive agent {string}")
    public void make_inactive_agent(String virologistName, String codeName) {
        String objectName = virologistName;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String geneticCodeName = codeName;
        GeneticCode geneticCode = (GeneticCode) Prototype.getObjects().get(geneticCodeName);

        if (v.makeInactiveAgent(geneticCode)) {
            actualAnswer = "Inaktív ágens készítése sikeres.";
        } else {
            actualAnswer = "Inaktív ágens készítése sikertelen.";
        }
    }

    @Given("Virologist {string} moves to Tile {string}")
    public void move(String virologist, String t) {
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        String tileName = t;
        Tile tile = (Tile) Prototype.getObjects().get(tileName);

        MoveEnum status = v.move(tile);
        switch (status) {
            case SUCCESFUL:
                actualAnswer = Constants.MOVING + tileName + Constants.TO_TILE_SUCCESS;
                break;
            case FAILED:
                actualAnswer = Constants.MOVING + tileName + Constants.TO_TILE_FAILED;
                break;
            case RANDOM_TILE:
                actualAnswer = Constants.MOVING + tileName + Constants.TO_TILE_FAILED_RANDOM;
                break;
        }
    }

    @Given("Virologist {string} picks up equipment")
    public void pickup_equipment(String virologist) {
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);

        PickupEquipmentEnum status = v.pickupEquipment();
        switch (status) {
            case SUCCESFUL:
                actualAnswer = "Felszerelés felvétele sikeres.";
                break;
            case FAILED:
                actualAnswer = "Felszerelés felvétele sikertelen.";
                break;
            case EMPTY:
                actualAnswer = "Nincs a mezőn felszerelés.";
                break;
            case FULL:
                actualAnswer = "Túl sok felszerelése van a virológusnak.";
                break;
        }
    }

    @Given("Virologist {string} picks up materials {string}")
    public void pickup_materials(String virologist, String materialsString) {
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
            actualAnswer = "Anyagok felvétele sikeres.";
        } else {
            actualAnswer = "Anyagok felvétele sikertelen.";
        }
    }

    @Given("Virologist {string} removes their equipment {string}")
    public void remove_equipment(String virologist, String equipmentString) {
        String objectName = virologist;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        String equipmentName = equipmentString;
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);
        v.removeEquipment(equipment);

        actualAnswer = "Felszerelés eltávolítva.";
    }

    @Given("Virologist {string} steals from another Virologist {string} an equipment {string}")
    public void steal_equipment(String virologist1String, String virologsist2String, String equipmentString) {
        String virologist1Name = virologist1String;
        Virologist v1 = (Virologist) Prototype.getObjects().get(virologist1Name);
        String virologist2Name = virologsist2String;
        Virologist v2 = (Virologist) Prototype.getObjects().get(virologist2Name);
        String equipmentName = equipmentString;
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);

        boolean steal = v1.stealEquipment(v2, equipment);
        if (steal) {
            actualAnswer = "Felszerelés ellopása sikeres.";
        } else {
            actualAnswer = "Felszerelés ellopása sikertelen.";
        }
    }

    @Given("Virologist {string} steals from another Virologist {string} some materials {string}")
    public void steal_materials(String virologist1String, String virologist2String, String materialsString) {
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
            actualAnswer = "Anyagok ellopása sikeres.";
        } else {
            actualAnswer = "Anyagok ellopása sikertelen.";
        }
    }

    @Given("Virologist {string} uses on another Virologist{string} an equipment {string}")
    public void use_equipment(String virologist1String, String virologist2String, String equipmentString) {
        String objectName = virologist1String;
        Virologist v = (Virologist) Prototype.getObjects().get(objectName);
        String targetName = virologist2String;
        Virologist target = (Virologist) Prototype.getObjects().get(targetName);
        String equipmentName = equipmentString;
        Equipment equipment = (Equipment) Prototype.getObjects().get(equipmentName);

        v.useEquipment(target, equipment);
        actualAnswer = "Felszerelés használva.";
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer.trim().replace("\\n", "\n"), actualAnswer.trim());
    }

}