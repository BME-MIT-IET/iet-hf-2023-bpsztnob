Feature: StealFromStunnedVirologistMaterials

  Scenario: StealFromStunnedVirologistMaterials
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "AminoAcidMaterial"
    Then I should be told "AminoAcidMaterial objektum sikeresen létrehozva."
    Given object "StunAgent"
    Then I should be told "StunAgent objektum sikeresen létrehozva."
    Given I added "AminoAcidMaterial1" materials to "Virologist2"
    Then I should be told "Anyagok sikeresen hozzáadva."
    Given I infect virologist "Virologist2" with "StunAgent1"
    Then I should be told "Virológus sikeresen megfertőzve."
    Given Virologist "Virologist1" steals from another Virologist "Virologist2" some materials "AminoAcidMaterial1"
    Then I should be told "Anyagok ellopása sikeres."