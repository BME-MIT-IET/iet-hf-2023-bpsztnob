Feature: InfectSelftWithGlovesCoatProtectionAgent

  Scenario: InfectSelftWithGlovesCoatProtectionAgent
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