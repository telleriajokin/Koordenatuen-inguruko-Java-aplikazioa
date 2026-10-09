package paagbi.model.unmarshal;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import paagbi.model.klaseak.Hiriak;

import java.io.File;

public class unmarshal {

    private static final String FITXATEGIA = "hiriak.xml";

    public static Hiriak irakurri() {

        try {

            File file = new File(FITXATEGIA);

            if (!file.exists()) {
                return new Hiriak();
            }

            JAXBContext context =
                    JAXBContext.newInstance(Hiriak.class);

            Unmarshaller unmarshaller =
                    context.createUnmarshaller();

            return (Hiriak) unmarshaller.unmarshal(file);

        } catch (Exception e) {

            System.out.println(
                    "Errorea XML irakurtzean: "
                            + e.getMessage()
            );

            return new Hiriak();
        }
    }
}