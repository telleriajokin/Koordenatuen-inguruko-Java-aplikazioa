package paagbi.model.klaseak;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Koordenatuak {

    private double latitudea;
    private double longitudea;

    public Koordenatuak() {
    }

    public Koordenatuak(double latitudea,
                        double longitudea) {

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