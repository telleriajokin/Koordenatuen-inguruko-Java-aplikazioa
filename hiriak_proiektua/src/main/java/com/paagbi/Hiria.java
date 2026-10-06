package com.paagbi;

import java.util.Scanner;

public class Hiria {

    private String izena;
    private double latitudea;
    private double longitudea;

    public Hiria(String izena, double latitudea, double longitudea) {
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
        System.out.println("Hiriaren izena: ");
        izena = scan.nextLine();
    }

    public void setLatitudea(Scanner scan) {
        System.out.println("Hiriaren latitudea: ");
        latitudea = scan.nextInt();
    }

    public void setLongitudea(Scanner scan) {
        System.out.println("Hiriaren longitudea: ");
        longitudea = scan.nextInt();
    }

    public String getIzena() {
        return izena;
    }

    public double getLatitudea() {
        return latitudea;
    }

    public double getLongitudea() {
        return longitudea;
    }

    @Override
    public String toString() {
        return izena + " (" + latitudea + ", " + longitudea + ")";
    }
}
