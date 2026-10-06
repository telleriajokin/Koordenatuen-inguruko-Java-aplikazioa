package com.paagbi;

public class Hiria {

    private String izena;
    private double latitudea;
    private double longitudea;

    public Hiria(String izena, double latitudea, double longitudea) {
        this.izena = izena;
        this.latitudea = latitudea;
        this.longitudea = longitudea;
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
