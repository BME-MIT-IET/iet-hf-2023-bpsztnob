Feature: MovingToNeighbourTile

  Scenario: MovingToNeighbourTile
    Given that everything is reset
    Given object "Virologist"
    Then I should be told "Virologist objektum sikeresen létrehozva."
    Given object "LabTile"
    Then I should be told "LabTile objektum sikeresen létrehozva."
    Given object "DumpsterTile"
    Then I should be told "DumpsterTile objektum sikeresen létrehozva."
    Given I add to "LabTile1" its neighbours "LabTile1 DumpsterTile1"
    Then I should be told "Szomszéd sikeresen hozzáadva."
    Given Virologist "Virologist1" moves to Tile "LabTile1"
    Then I should be told "Mozgás LabTile1 mezőre sikeres."
    Given Virologist "Virologist1" moves to Tile "DumpsterTile1"
    Then I should be told "Mozgás DumpsterTile1 mezőre sikeres."