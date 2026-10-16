# Hiriak_jsonekin

Java (Maven) kontsola-aplikazioa, herriak eta haien koordenatuak kudeatzen ditu. Datuak JSON fitxategi batetan gordetzen dira, JSON-P (Jakarta JSON) erabiliz eta Parsson inplementazioarekin. Horretaz aparte, Jolas bat du, zeinetan koordenatuetatik abiatuta herriaren izena asmatu behar da.

## Funtzionalitateak

Programak menu bat erakusten du aukera hauekin:

| Aukera | Ekintza |
|--------|---------|
| 1 | **Datuak sartu**: Herri baten izena, latitudea eta longitudea eskatzen ditu eta JSON fitxategian gordetzen du. |
| 2 | **Datu guztiak erakutsi**: JSON fitxategia irakurri eta gordetako herri guztiak erakusten ditu. |
| 3 | **Jolastu**: Ausazko herri baten koordenatuak erakusten ditu eta bere izena asmatu behar da. 5 galdera dira, eta amaieran puntuazioa erakusten da. |
| 0 | **Irten**: programatik irteten da. |

## Baldintzak

- Java 25 (`pom.xml` fitxategian konfiguratuta, `maven.compiler.source` eta `maven.compiler.target` bidez)
- Maven 3.x

## Dependentziak

| Liburutegia | Bertsioa | Zertarako |
|-------------|----------|-----------|
| `jakarta.json:jakarta.json-api` | 2.1.3 | JSON-P APIa (interfazeak) |
| `org.eclipse.parsson:parsson` | 1.1.9 | JSON-P inplementazioa |
| `junit:junit` | 4.11 | Testak (`test` esparrua) |

## Proiektuaren egitura

```
hiriak_jsonekin/
├── pom.xml
├── README.md
├── data/
│   └── herriak_kordenatu.json      # lehen herria gordetzean sortzen da
└── src/
    ├── main/java/paagbi/
    │   ├── App.java                # sarrera-puntua, menua abiarazten du soilik
    │   ├── Menu.java               # menua eta aukeraren irakurketa
    │   ├── Jolasa.java             # jolasa
    │   ├── models/
    │   │   └── Herria.java         # objetuaren klasea
    │   └── data/
    │       └── jsonFitxategienKudeatzailea.java   # JSON fitxategia irakurri eta idazten du
    └── test/java/paagbi/
        └── AppTest.java
```

### Klase bakoitzak zer egiten duen

- **`App`**: `main` metodoa du eta `Menu` sortzen du.
- **`Menu`**: aukerak erakusten ditu, hautaketa jasotzen du eta kudeatzaileari edo jolasari deitzen dio. Ez du JSON-ekin lanik eiten.
- **`Herria`**: herri bat irudikatzen du. Eraikitzaile batek balioak jasotzen ditu, eta besteak `Scanner` bat jasotzen du eta datuak kontsolatik galdetzen ditu. Dezimalak puntuarekin zein komarekin onartzen ditu.
- **`jsonFitxategienKudeatzailea`**: fitxategirako sarbide bakarra.
  - `Kargatu()` JSON fitxategia irakurri eta `List<Herria>` bat itzultzen du. Fitxategia oraindik existitzen ez bada, zerrenda hutsa itzultzen du.
  - `gorde(List<Herria>)` zerrenda JSON formatura pasatzen du eta fitxategi osoa berridazten du.
  - `gehitu(Herria)` zerrenda kargatu, herria gehitu eta berriro gordetzen du.
- **`Jolasa`**: herrien zerrenda eta menuaren `Scanner`-a jasotzen ditu, eta jolasa daramatza.

## JSON fitxategiaren formatua

`data/herriak_kordenatu.json` fitxategiak objektuen array bat dauka. Koordenatuak zenbaki gisa gordetzen dira:

```json
[
  {
    "izena": "Eibar",
    "latitudea": 43.18,
    "longitudea": -2.47
  }
]
```

Fitxategia osorik berridazten da herri bat gehitzen den bakoitzean, JSON batek ez baitu CSV batek bezala amaieran lerro bat gehitzen uzten. Horregatik, `gehitu` metodoak lehenengo dena kargatu, elementu berria gehitu eta berriro gordetzen du.


## Erabilera adibidea

```
--- MENUA ---
1. Datuak sartu
2. Datu guztiak erakutsi
3. Jolastu
0. Irten
Aukeratu: 1
Hiriaren izena: Eibar
Hiriaren latitudea: 43.18
Hiriaren longitudea: -2.47
Gordeta!
```

## Oharrak

- Latitudea edo longitudea zenbaki ez bada, herria ez da gordetzen eta abisu bat erakusten da.
- Herri gutxi gordeta badaude, galderak errepika daitezke jolasean, galdera bakoitza zerrendatik ausaz aukeratzen baita.