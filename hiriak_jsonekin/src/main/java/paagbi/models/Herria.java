package paagbi.models;

import java.util.Scanner;

public class Herria {
    private String izena;
    private Double latitudea;
    private Double longitudea;

    //Eraikitzaileak
    public Herria(String izena, Double latitudea, Double longitudea) {
        this.izena = izena;
        this.latitudea = latitudea;
        this.longitudea = longitudea;
    }

    public Herria(Scanner scan) {
        setIzena(scan);
        setLatitudea(scan);
        setLongitudea(scan);
    }

    //Izena SET/GET
    public void setIzena(Scanner scan) {
        System.out.print("Hiriaren izena: ");
        izena = scan.nextLine();
    }

    public String getIzena() {
        return izena;
    }

    // Latitudea SET/GET
    public void setLatitudea(Scanner scan) {
        System.out.print("Hiriaren latitudea: ");
        latitudea = Double.parseDouble(scan.nextLine().trim().replace(',', '.')); // seguruagoa da nextLine eta
                                                                                  // parseDouble eitea, ez egoteko linea
                                                                                  // hutsik
    }

    public Double getLatitudea() {
        return latitudea;
    }

    //Longitudea SET/GET
    public void setLongitudea(Scanner scan) {
        System.out.print("Hiriaren longitudea: ");
        longitudea = Double.parseDouble(scan.nextLine().trim().replace(',', '.'));// replace aldatzen ditu komak
                                                                                  // puntutara, balio bixak onartzeko
    }

    public Double getLongitudea() {
        return longitudea;
    }

    //hau beharrezkoa da datuak eraskuterako orduan "formateaututa" ikusteko, politago egoteko
    @Override
    public String toString() {
        return izena + " (" + latitudea + ", " + longitudea + ")";
    }
}