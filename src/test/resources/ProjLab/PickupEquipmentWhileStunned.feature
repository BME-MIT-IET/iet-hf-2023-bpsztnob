Feature: PickupEquipmentWhileStunned

    Scenario: PickupEquipmentWhileStunned
    Given that everything is reset
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "ShelterTile"
    Then I should be told "ShelterTile objektum sikeresen létrehozva."
    Given object "BackpackEquipment"
    Then I should be told "BackpackEquipment objektum sikeresen létrehozva."
    Given object "StunAgent"
    Then I should be told "StunAgent objektum sikeresen létrehozva."
    Given Virologist "Virologist1" moves to Tile "ShelterTile1"
    Then I should be told "Mozgás ShelterTile1 mezőre sikeres."
    Given I added to "ShelterTile1" a "BackpackEquipment1" equipment
    Then I should be told "Felszerelés sikeresen hozzáadva."
    Given I infect virologist "Virologist1" with "StunAgent1"
    Then I should be told "Virológus sikeresen megfertőzve."
    Given Virologist "Virologist1" picks up equipment
    Then I should be told "Felszerelés felvétele sikertelen."
