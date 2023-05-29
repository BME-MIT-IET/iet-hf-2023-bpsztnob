# Manuális tesztek
Use-casek alapján készített manuális tesztek:

### Steal Materials
- Lépések:
  1. Első virológusnak egy raktár mezőre kell lépnie.
  2. Első virológusnak fel kell vennie egy anyagot.
  3. Második virológusnak egy labor mezőre kell lépnie.
  4. Második virológusnak meg kell tanulnia a genetikus kódot.
  5. Második virológusnak egy raktár mezőre kell lépnie.
  6. Második virológusnak fel kell vennie a szükséges anyagokat.
  7. Második virológusnak el kell készítenie a bénító inaktív ágenst.
  8. Második virológusnak találkoznia kell az első virológussal.
  9. Második virológusnak rá kell kennie az inaktív ágenst az első virológusra.
  10. Második virológusnak el kell lopni az anyagot az első virológustól
- Teszt eredménye: sikeres, a második virológushoz kerül az anyag.

### Steal Equipment
- Lépések:
  1. Első virológus egy óvóhelyre kell lépnie.
  2. Első virológus fel kell vennie egy felszerelést.
  3. Második virológusnak egy labor mezőre kell lépnie.
  4. Második virológusnak meg kell tanulnia a genetikus kódot.
  5. Második virológusnak egy raktár mezőre kell lépnie.
  6. Második virológusnak fel kell vennie a szükséges anyagokat.
  7. Második virológusnak el kell készítenie a bénító inaktív ágenst.
  8. Második virológusnak találkoznia kell az első virológussal.
  9. Második virológusnak rá kell kennie az inaktív ágenst az első virológusra.
  10. Második virológusnak el kell lopni a felszerelést az első virológustól
- Teszt eredménye: sikeres, a második virológushoz kerül a felszerelés.

### Infect

- Lépések:
  1. A virológusnak egy labor mezőre kell lépnie.
  2. A virológusnak meg kell tanulnia a genetikus kódot.
  3. A virológusnak egy raktár mezőre kell lépnie.
  4. A virológusnak fel kell vennie a szükséges anyagokat.
  5. A virológusnak el kell készítenie az inaktív ágenst.
  6. A virológusnak találkoznia kell egy másik virológussal.
  7. A virológusnak rá kell kennie az inaktív ágenst a másik virológusra.
- Teszt eredménye: sikeres, a virológusnak sikerült rákennie az inaktív ágenst.

### Can't Steal Equipment

- Lépések:
  1. Az első virológusnak egy óvóhelyre kell lépnie.
  2. Az első virológusnak fel kell vennie egy felszerelést.
  3. A második virológusnak találkoznia kell az első virológussal.
  4. A második virológusnak meg kell próbálnia ellopnia a felszerelést.
- Teszt eredménye: sikeres, a virológusnak nem sikerült ellopnia a felszerelést.

### Can't Steal Materials

- Lépések:
  1. Az első virológusnak egy raktárra kell lépnie.
  2. Az első virológusnak fel kell vennie anyagot.
  3. A második virológusnak találkoznia kell az első virológussal.
  4. A második virológusnak meg kell próbálnia ellopnia az anyagot.
- Teszt eredménye: sikeres, a virológusnak nem sikerült ellopnia a felszerelést.

### Move

- Lépések:
  1. A virológusnak nem szabad bénulva lennie.
  2. A virológus ha vitustáncol akkor nem biztos, hogy a kívánt mezőre lép.
  3. A virológus ha medvetáncol akkor nem biztos, hogy a megadott mezőre fog lépni.
  4. A virológuson ha nincs mozgást befolyásoló ágens akkor átlép a másik mezőre.
- Teszt eredménye: Sikeres! A virológus átlép a mezőre.

### InsufficientMaterialsForInactiveAgent

- Lépések:
  1. A virológusnak egy labor mezőre kell lépnie.
  2. A virológusnak meg kell tanulnia az ott található ágenst.
  3. A virológusnak anyagokat kell gyűjtenie az ágens készítéséhez.
  4. A virológus megpróbálja elkészíteni az ágenst.
- Teszt eredménye: A virológus nem fogja tudni elkészíteni az ágenst mert nincs elegendő alapanyaga.

### MakeInactiveAgent

- Lépések:
  1. A virológus egy labormezőre lép.
  2. A virológus megtanul egy ott található ágens genetikai kódját.
  3. A virológus nyersanyagot gyűjt az ágens elkészítéséhez.
  4. A virológus elkészíti az ágenst amikor van elegendő nyersanyaga.
  5. A virológus megpróbálja elkészíteni az ágenst.
- Teszt eredménye: A virológus elkészíti az ágenst, az alapanyagok elvonásra kerülnek tőle.

### DropMaterials

- Lépések:
  1. A virológus összegyűjt néhány alapanyagot.
  2. A virológusnak egy lerakóhelyre kell lépnie.
  3. A virológus eldobja a nála található alapanyagokat.
- Teszt eredménye: A virológus sikeresen eldobja az alapanyagokat.

## PickupMaterials
 - Lépések:
    1. A virológust egy raktár mezőre kell mozgatni
    2. Ha az első körben odaért, várnia kell egy kört, hogy a raktárban legyen anyag
    3. A virológusnak fel kell vennie az anyagot
 - Teszt eredménye: Sikeres, a virológusnak sikerült felvennie az anyagot.

## PickupEquipment
 - Lépések:
    1. A virológust egy óvóhely mezőre kell mozgatni
    2. A virológusnak fel kell vennie a felszerelést, amit itt talál
 - Teszt eredménye: Sikeres, a virológusnak sikerült felvennie a tárgyat

## GeneticCodeIsAlreadyLearnt
 - Lépések: 
    1. A virológust egy olyan labor mezőre kell mozgatni, ami nem fertőzött
    2. A virológusnak meg kell tanulnia a genetikus kódot
    3. A virológusnak várnia kell egy kört
    4. A virológusnak meg kell tanulnia a genetikus kódot
 - Teszt eredménye: Sikeres, a virológus nem tudta mégegyszer megtanulni a már ismert kódot

 ## LearnGeneticCode
  - Lépések:
     1. A virológust egy olyan labor mezőre kell mozgatni, ami nem fertőzött
    2. A virológusnak meg kell tanulnia a genetikus kódot
 - Teszt eredménye: Sikeres, a virológus megtanulta a genetikus kódot