package model.paagbi.model.klaseak;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "hiriak")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hiriak {

    @XmlElement(name = "hiria")
    private List<Hiria> hiriak = new ArrayList<>();

    public Hiriak() {
    }

    public List<Hiria> getHiriak() {
        return hiriak;
    }

    public void setHiriak(List<Hiria> hiriak) {
        this.hiriak = hiriak;
    }
}
