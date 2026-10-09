package paagbi.model.marshal;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import paagbi.model.klaseak.Hiriak;

import java.io.File;

public class marshal {

    private static final String FITXATEGIA = "hiriak.xml";

    public static void gorde(Hiriak hiriak) {

        try {

            JAXBContext context =
                    JAXBContext.newInstance(Hiriak.class);

            Marshaller marshaller =
                    context.createMarshaller();

            marshaller.setProperty(
                    Marshaller.JAXB_FORMATTED_OUTPUT,
                    true
            );

            marshaller.marshal(
                    hiriak,
                    new File(FITXATEGIA)
            );

        } catch (Exception e) {

            System.out.println(
                    "Errorea XML gordetzean: "
                            + e.getMessage()
            );
        }
    }
}
