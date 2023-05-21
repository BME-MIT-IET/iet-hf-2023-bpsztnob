# SonarCloud code elemzés

## Bugs
- Kihelyeztük a random objektumot osztályváltozóba.
- Stream fileok bezárása try-with-resources alkalmazásával.
- Funkcionális hiba javítása(remove helyett removeAll).
- Steppable interface Serializable lett.

## Code smells
### Major
-Fölösleges változók törlése
-Privát kontruktorok hozzáadása a csak statikus függvényekkel rendelkező osztályokhoz
-Virológus GetAgents metódus törlése (ugyanazt csinálta, mint a getActiveAgents)
-@Override hozzáadása öröklés esetén
-Runtime exceptionök felülírása (mostantól hiba esetén a konzolra ír a program)
-ArrayList és JList típusok megadása
-ViewPanel iterator az utolsó elemnél történő fölösleges léptetésének eltűntetése
-InactiveAgent konstruktora protected (fölöslegesen public)
-ShelterTile getEquipment() egyik lokális változóját átneveztem, hogy ne rejtse el az osztály attribútumát
-Pár helyen az volt a hiba, hogy bool változók if ágakon belüli értékadását nem vette figyelembe, ezek nem hibák, tehát nem javítottam
