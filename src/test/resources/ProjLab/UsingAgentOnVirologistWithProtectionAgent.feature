Feature: UsingAgentOnVirologistWithProtectionAgent

    Scenario:UsingAgentOnVirologistWithProtectionAgent
    Given that everything is reset
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "ProtectionAgent"
    Then I should be told "ProtectionAgent objektum sikeresen létrehozva."
    Given object "StunInactiveAgent"
    Then I should be told "StunInactiveAgent objektum sikeresen létrehozva."
    Given I infect virologist "Virologist2" with "ProtectionAgent1"
    Then I should be told "Virológus sikeresen megfertőzve."
    Given I added to "Virologist1" virologist "StunInactiveAgent1" inactive ganet
    Then I should be told "Inaktív ágens sikeresen hozzáadva."
    Given Virologist "Virologist1" infects virologist "Virologist2" with agent "StunInactiveAgent1"
    Then I should be told "Inaktív ágens kenése sikeres."
    Given I list what "agents" objects are on "Virologist2"
    Then I should be told "ProtectionAgent1"