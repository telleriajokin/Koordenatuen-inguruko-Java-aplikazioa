# Koordenatuen Jokoa

## Deskribapena

Proiektu honen helburua erabiltzailea leku desberdinen koordenatu geografikoekin trebatzea da.

Programak hiriak eta haien koordenatuak CSV fitxategi batean gordetzeko aukera ematen du. Ondoren, erabiltzaileak joko batean saiatu beharko da azmatzen zein hiriaren koordenatuak dira erakusten direnak.

Proiektua Java Maven erabiliz garatu da.

---

## Funtzionalitateak

### 1. Hiri berria gehitu

Erabiltzaileak datu hauek sartu beharko ditu:

- Hiriaren izena
- Latitudea
- Longitudea

Datuak `hiriak.csv` fitxategian gordeko dira.

```text
Sartu hiriaren izena: Donostia
Sartu latitudea: 43.3183
Sartu longitudea: -1.9812

Hiria ondo gorde da.
```

### 2. Hiri guztiak erakutsi

Programak CSV fitxategian gordetako hiri guztiak erakutsiko ditu.

```text
Bilbao (43.2630, -2.9350)
Donostia (43.3183, -1.9812)
Gasteiz (42.8467, -2.6716)
Iruña (42.8125, -1.6458)
```

### 3. Jolastu

Programak CSV fitxategitik ausaz hiri bat aukeratuko du eta haren koordenatuak erakutsiko ditu. Erabiltzaileak zein hiriarenak diren asmatu beharko ditu.

```text
Koordenatuak: 43.3183, -1.9812

Zein hiria da?
Donostia

Zuzena!
```

Erantzuna okerra bada:

```text
Ez da zuzena.
Erantzun zuzena: Donostia
```

### 4. Programatik irten

Aukera honen bidez programa amaituko da.

---

## Programaren menua

```text
========================
    KOORDENATUEN JOKOA
========================

1. Hiri berria gehitu
2. Hiri guztiak erakutsi
3. Jolastu
4. Irten

Aukeratu aukera bat:
```

---

## CSV fitxategiaren formatua

Hirien datuak `hiriak.csv` fitxategian gordeko dira.

```csv
Hiria;Latitudea;Longitudea
Bilbao;43.2630;-2.9350
Donostia;43.3183;-1.9812
Gasteiz;42.8467;-2.6716
Iruna;42.8125;-1.6458
```

CSV fitxategiko lerro bakoitzak hiri baten izena, latitudea eta longitudea gordeko ditu. Datuak puntu-koma bidez banatuko dira.

---

## Proiektuaren egitura

```text
hiriak_proiektua/
├── src/
│   ├── Main.java
│   ├── Hiria.java
│   └── CSVKudeatzailea.java
├── hiriak.csv
└── README.md
```

### Main.java

Programaren menu nagusia eta erabiltzailearekiko interakzioa kudeatuko ditu.

### Hiria.java

Hiri bakoitzaren datuak gordetzeko erabiliko den klasea izango da.

```java
private String izena;
private String latitudea;
private String longitudea;
```

### CSVKudeatzailea.java

CSV fitxategiarekin lotutako eragiketak kudeatuko ditu:

- CSV fitxategia sortzea
- Hiriak fitxategian gordetzea
- Hiriak fitxategitik irakurtzea
- Hiri guztiak zerrenda batean kargatzea

---

## Erabilitako Java klaseak

Fitxategiak kudeatzeko:

```java
Path
Paths
Files
BufferedReader
StandardCharsets
StandardOpenOption
IOException
```

Beste funtzionalitateetarako:

```java
ArrayList
List
Scanner
```

---

## Balidazioak

Programak egoera hauek kontrolatuko ditu:

- CSV fitxategia existitzen ez bada, automatikoki sortzea
- Hiriaren izena hutsik ez egotea
- Jolasten hasi aurretik CSV fitxategian hiriak egotea

---

## Etorkizuneko hobekuntzak

- Menuko aukera zuzena aukeratzea
- Hiri bera behin baino gehiagotan ez gordetzea
- Galdera kopurua aukeratzea
- Hiriak ezabatzea edo aldatzea
- Zailtasun mailak gehitzea
- Emaitzak beste CSV fitxategi batean gordetzea
- Hiriaren izena emanda koordenatuak asmatzeko joko mota gehitzea

---

## Ondorioa

Proiektu honen bidez Java-ko klaseak, objektuak, menuak, begiztak, zerrendak, salbuespenen kudeaketa eta CSV fitxategien irakurketa eta idazketa landu dira.