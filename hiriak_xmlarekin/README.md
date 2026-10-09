# Koordenatuen Jokoa XML-rekin

## Deskribapena

Proiektu honen helburua erabiltzailea leku desberdinen koordenatu geografikoekin trebatzea da.

Programak hiriak eta haien koordenatuak XML fitxategi batean gordetzeko aukera ematen du. Ondoren, erabiltzaileak joko batean saiatu beharko da azmatzen zein hiriaren koordenatuak diren erakusten direnak.

Proiektua Java Maven erabiliz garatu da.

---

## Funtzionalitateak

### 1. Hiri berria gehitu

Erabiltzaileak datu hauek sartu beharko ditu:

- Hiriaren izena
- Latitudea
- Longitudea

Datuak `hiriak.xml` fitxategian gordeko dira.

Sartu hiriaren izena: Donostia
Sartu latitudea: 43.3183
Sartu longitudea: -1.9812

Hiria ondo gorde da.

### 2. Hiri guztiak erakutsi

Programak XML fitxategian gordetako hiri guztiak erakutsiko ditu.

Bilbao (43.2630, -2.9350)
Donostia (43.3183, -1.9812)
Gasteiz (42.8467, -2.6716)
Iruña (42.8125, -1.6458)

### 3. Jolastu

Programak XML fitxategitik ausaz hiri bat aukeratuko du eta haren koordenatuak erakutsiko ditu. Erabiltzaileak zein hiriarenak diren asmatu beharko ditu.

Koordenatuak: 43.3183, -1.9812

Zein hiria da?
Donostia

Zuzena!

Erantzuna okerra bada:

Ez da zuzena.
Erantzun zuzena: Donostia

### 4. Programatik irten

Aukera honen bidez programa amaituko da.

---

## Programaren menua

========================
    KOORDENATUEN JOKOA
========================

1. Hiri berria gehitu
2. Hiri guztiak erakutsi
3. Jolastu
4. Irten

Aukeratu aukera bat:

---

## XML fitxategiaren formatua

Hirien datuak `hiriak.xml` fitxategian gordeko dira.

<?xml version="1.0" encoding="UTF-8"?>

<hiriak>

    <hiria>
        <izena>Bilbao</izena>

        <koordenatuak>
            <latitudea>43.2630</latitudea>
            <longitudea>-2.9350</longitudea>
        </koordenatuak>

    </hiria>

    <hiria>
        <izena>Donostia</izena>

        <koordenatuak>
            <latitudea>43.3183</latitudea>
            <longitudea>-1.9812</longitudea>
        </koordenatuak>

    </hiria>

</hiriak>

XML fitxategiko hiri bakoitzak bere izena eta koordenatuak gordetzen ditu nodo anidatuen bidez.

---

## Proiektuaren egitura

hiriak_xmlarekin/
├── src/
│   └── main/
│       └── java/
│           └── paagbi/
│
│               ├── model/
│               │
│               ├── Hiriak.java
│               ├── Hiria.java
│               └── Koordenatuak.java
│
│               ├── marshal/
│               │   └── marshal.java
│
│               ├── unmarshal/
│               │   └── unmarshal.java
│
│               └── App.java
│
├── hiriak.xml
├── pom.xml
└── README.md
```

### App.java

Programaren menu nagusia eta erabiltzailearekiko interakzioa kudeatuko ditu.

### Hiriak.java

XML fitxategiaren erroko elementua izango da eta hiri guztien zerrenda gordeko du.

private List<Hiria> hiriak;

### Hiria.java

Hiri bakoitzaren informazioa gordeko du.

private String izena;
private Koordenatuak koordenatuak;

### Koordenatuak.java

Koordenatu geografikoak gordeko ditu.

private double latitudea;
private double longitudea;

### marshal.java

Java objektuak XML fitxategi bihurtzeko erabiliko da.

### unmarshal.java

XML fitxategitik Java objektuak sortzeko erabiliko da.

---

## Erabilitako Java klaseak

XML fitxategiak kudeatzeko:

JAXBContext
Marshaller
Unmarshaller
@XmlRootElement
@XmlElement
@XmlAccessorType
@XmlAccessType

Beste funtzionalitateetarako:

ArrayList
List
Scanner
Random

---

## Balidazioak

Programak egoera hauek kontrolatuko ditu:

- XML fitxategia existitzen ez bada, automatikoki sortzea
- Hiriaren izena hutsik ez egotea
- Jolasten hasi aurretik XML fitxategian hiriak egotea

---

## Etorkizuneko hobekuntzak

- Menuko aukera zuzena aukeratzea
- Hiri bera behin baino gehiagotan ez gordetzea
- Galdera kopurua aukeratzea
- Hiriak ezabatzea edo aldatzea
- Zailtasun mailak gehitzea
- Emaitzak beste XML fitxategi batean gordetzea
- Hiriaren izena emanda koordenatuak asmatzeko joko mota gehitzea

---

## Ondorioa

Proiektu honen bidez Java-ko klaseak, objektuak, menuak, begiztak, zerrendak, salbuespenen kudeaketa eta XML fitxategien irakurketa eta idazketa landu dira. Gainera, JAXB erabiliz Marshal eta Unmarshal teknikak erabili dira Java objektuak eta XML dokumentuak elkarren artean bihurtzeko.