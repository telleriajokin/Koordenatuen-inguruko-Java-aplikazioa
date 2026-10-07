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
        //falta koordenatuak jasotzea
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