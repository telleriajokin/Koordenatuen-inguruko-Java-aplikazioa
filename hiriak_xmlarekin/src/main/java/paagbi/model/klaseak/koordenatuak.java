package paagbi.model.klaseak;

import java.util.Scanner;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Koordenatuak {

    private String latitudea;
    private String longitudea;

    public Koordenatuak() {
    }

    public Koordenatuak(Scanner scan) {
        System.out.print("Hiriaren latitudea: ");
        latitudea = scan.nextLine();
        System.out.print("Hiriaren longitudea: ");
        longitudea = scan.nextLine();
    }

    public Koordenatuak(String latitudea,
                        String longitudea) {

        this.latitudea = latitudea;
        this.longitudea = longitudea;
    }

    public String getLatitudea() {
        return latitudea;
    }

    public void setLatitudea(String latitudea) {
        this.latitudea = latitudea;
    }

    public String getLongitudea() {
        return longitudea;
    }

    public void setLongitudea(String longitudea) {
        this.longitudea = longitudea;
    }
}