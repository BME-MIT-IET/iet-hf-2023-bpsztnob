# Cucumber keretrendszer és tesztek megírása

A Cucumber függőséget beleírtuk a pom.xml-be. A keretrendszerhez szükséges lépésdefinícókat a StepDefinitions.java fájlba írtuk. Létezik egy Then lépés, amiben a kapott értéket hasonlítjuk össze a várt értékkel, a többi lépés pedig a program use case-eit implementálja.

## Tesztesetek

### MovingToNeighbourTile

- Ebben a tesztesetben a virológus átmegy egy szomszédos mezőre.
- Az elvárt eredmény: a virológus átkerült egy másik mezőre.

### InfectSelftWithGlovesCoatProtectionAgent

- Ebben a tesztesetben a virológus saját magát próbálja megfertőzni bénítóágenssel úgy hogy van egy kesztyűje, köpenye és saját magára kente a védőágenst.
- Az elvárt eredmény: a kenés sikeres.

### MakingAmnesiaAgent

- Ebben a tesztesetben a virológus elkészít egy amnéziaágenst a szükséges anyagokkal.
- Az elvárt eredmény: az ágens elkészítése sikeres.

### PickupEquipmentWhileStunned

- Ebben a tesztesetben a virológusnak meg kell próbálnia felvenni egy felszerelést úgy, hogy le van bénulva.
- Az elvárt eredmény: a virológus nem tudja felvenni a felszerelést.

### PickupMaterialWhileFull

- Ebben a tesztesetben a virológusnak meg kell próbálnia felvenni anyagot úgy, hogy tele van a zsebe anyagokkal.
- Az elvárt eredmény: a virológus nem tudja felvenni az anyagot.

### StealFromStunnedVirologistMaterials

- Ebben a tesztesetben a virológus el kell lopnia anyagot egy másik lebénult virológustól.
- Az elvárt eredmény: a virológus sikeresen ellopta az anyagot.

### UsingAgentOnNotProtectedVirologist

- Ebben a tesztesetben a virológus ráken egy inaktív ágenst egy másik védtelen virológusra.
- Az elvárt eredmény: a virológus sikeresen rákente az inaktív ágenst a másik virológusra.

### UsingAgentOnVirologistWithProtectionAgent

- Ebben a tesztesetben a virológus megpróbál rákenni egy inaktív ágenst egy másik virológusra, akin egy védőágens van.
- Az elvárt eredmény: a virológus sikeresen rákente az inaktív ágenst a másik virológusra, de a védőágens nem marad rajta az ágens.
