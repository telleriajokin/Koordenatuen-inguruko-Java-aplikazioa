package paagbi.model.klaseak;

import java.util.Scanner;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Hiria {

    private String izena;

    private Koordenatuak koordenatuak;

    public Hiria() {
    }

    public Hiria(String izena,
                 Koordenatuak koordenatuak) {

        this.izena = izena;
        this.koordenatuak = koordenatuak;
    }

    public Hiria (Scanner scan) {
        System.out.print("Hiriaren izena: ");
        izena = scan.nextLine();
        koordenatuak = new Koordenatuak(scan);
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public Koordenatuak getKoordenatuak() {
        return koordenatuak;
    }

    public void setKoordenatuak(Koordenatuak koordenatuak) {
        this.koordenatuak = koordenatuak;
    }
}

/*Así el flujo queda en cascada: new Hiria(scan) pregunta el nombre, 
llama a new Koordenatuak(scan), que pregunta latitud y longitud, y 
el objeto resultante se guarda en el campo. Y como se reutiliza el 
mismo Scanner, no hay problemas con el buffer de entrada. Esto escala 
igual si más adelante Koordenatuak tuviera otra clase dentro.

Un detalle para JAXB: con XmlAccessType.FIELD, los nombres de los 
elementos XML salen de los nombres de los campos. En tu estructura 
aparece koordenatua y altitudea, pero en el código los campos son 
koordenatuak y latitudea. Si el XML real usa los nombres de la estructura, 
tendrás que indicarlo con @XmlElement(name = "...") en esos campos, o decidir 
cuál de los dos nombres es el correcto. Si quieres, dime cuál es el XML de 
referencia y lo miramos. */