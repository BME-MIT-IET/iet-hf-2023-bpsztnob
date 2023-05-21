# SonarCloud code elemzés

## Bugs
- Kihelyeztük a random objektumot osztályváltozóba.
- Stream fileok bezárása try-with-resources alkalmazásával.
- Funkcionális hiba javítása(remove helyett removeAll).
- Steppable interface Serializable lett.

## Security hotspots
- Random helyett SecureRandom használata.
- StackTrace kiiratás helyett csak az exception üzenetét íratjuk ki.