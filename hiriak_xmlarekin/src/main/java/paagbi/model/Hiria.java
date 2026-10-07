package paagbi.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@XmlRootElement(name = "hiriak")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hiria {

    @XmlElement(name = "hiria")
    private List<HiriDatuak> hiriak = new ArrayList<>();

    public Hiria() {
    }

    public List<HiriDatuak> getHiriak() {
        return hiriak;
    }

    public void setHiriak(List<HiriDatuak> hiriak) {
        this.hiriak = hiriak;
    }

    public void gehituHiria(HiriDatuak hiria) {
        hiriak.add(hiria);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class HiriDatuak {

        private String izena;

        private Koordenatuak koordenatuak;

        public HiriDatuak() {
        }

        public HiriDatuak(
                String izena,
                double latitudea,
                double longitudea
        ) {
            this.izena = izena;
            this.koordenatuak = new Koordenatuak(
                    latitudea,
                    longitudea
            );
        }

        public HiriDatuak(Scanner sc) {
            System.out.print("Hiriaren izena: ");
            this.izena = sc.nextLine();

            System.out.print("Latitudea: ");
            double latitudea = sc.nextDouble();

            System.out.print("Longitudea: ");
            double longitudea = sc.nextDouble();
            sc.nextLine();

            this.koordenatuak = new Koordenatuak(
                    latitudea,
                    longitudea
            );
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

        public double getLatitudea() {
            return koordenatuak.getLatitudea();
        }

        public double getLongitudea() {
            return koordenatuak.getLongitudea();
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Koordenatuak {

        private double latitudea;
        private double longitudea;

        public Koordenatuak() {
        }

        public Koordenatuak(
                double latitudea,
                double longitudea
        ) {
            this.latitudea = latitudea;
            this.longitudea = longitudea;
        }

        public double getLatitudea() {
            return latitudea;
        }

        public void setLatitudea(double latitudea) {
            this.latitudea = latitudea;
        }

        public double getLongitudea() {
            return longitudea;
        }

        public void setLongitudea(double longitudea) {
            this.longitudea = longitudea;
        }
    }
}