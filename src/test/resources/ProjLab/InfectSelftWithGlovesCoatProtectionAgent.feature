Feature: InfectSelftWithGlovesCoatProtectionAgent

  Scenario: InfectSelftWithGlovesCoatProtectionAgent
    Given that everything is reset
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "GlovesEquipment"
    Then I should be told "GlovesEquipment objektum sikeresen létrehozva."
    Given object "CoatEquipment"
    Then I should be told "CoatEquipment objektum sikeresen létrehozva."
    Given object "ProtectionAgent"
    Then I should be told "ProtectionAgent objektum sikeresen létrehozva."
    Given object "StunInactiveAgent"
    Then I should be told "StunInactiveAgent objektum sikeresen létrehozva."
    Given I infect virologist "Virologist1" with "ProtectionAgent1"
    Then I should be told "Virológus sikeresen megfertőzve."
    Given I added "GlovesEquipment1" to "Virologist1"
    Then I should be told "Felszerelés sikeresen hozzáadva."
    Given I added "CoatEquipment1" to "Virologist1"
    Then I should be told "Felszerelés sikeresen hozzáadva."
    Given I added to "Virologist1" virologist "StunInactiveAgent1" inactive ganet
    Then I should be told "Inaktív ágens sikeresen hozzáadva."
    Given Virologist "Virologist1" infects virologist "Virologist1" with agent "StunInactiveAgent1"
    Then I should be told "Inaktív ágens kenése sikeres."
    Given I list what "agents" objects are on "Virologist1"
    Then I should be told "ProtectionAgent1\nStunAgent1"