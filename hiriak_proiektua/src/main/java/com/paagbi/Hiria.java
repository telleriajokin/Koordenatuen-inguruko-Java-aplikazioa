package com.paagbi;

import java.util.Scanner;

public class Hiria {

    private String izena;
    private String latitudea;
    private String longitudea;

    public Hiria(String izena, String latitudea, String longitudea) {
        this.izena = izena;
        this.latitudea = latitudea;
        this.longitudea = longitudea;
    }

    public Hiria(Scanner scan) {
        setIzena(scan);
        setLatitudea(scan);
        setLongitudea(scan);
    }

    public void setIzena(Scanner scan) {
        System.out.print("Hiriaren izena: ");
        izena = scan.nextLine();
    }

    public void setLatitudea(Scanner scan) {
        System.out.print("Hiriaren latitudea: ");
        latitudea = scan.nextLine();
    }

    public void setLongitudea(Scanner scan) {
        System.out.print("Hiriaren longitudea: ");
        longitudea = scan.nextLine();
    }

    public String getIzena() {
        return izena;
    }

    public String getLatitudea() {
        return latitudea;
    }

    public String getLongitudea() {
        return longitudea;
    }

    @Override
    public String toString() {
        return izena + " (" + latitudea + ", " + longitudea + ")";
    }
}
