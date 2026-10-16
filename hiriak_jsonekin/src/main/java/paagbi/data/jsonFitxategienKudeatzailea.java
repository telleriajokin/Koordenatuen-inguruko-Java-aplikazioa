package paagbi.data;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import jakarta.json.stream.JsonGenerator;
import paagbi.models.Herria;

public class jsonFitxategienKudeatzailea {

    // Zehazten dau json fitxategiaren kokapena
    private static final Path FITXATEGIA = Path.of("data/herriak_kordenatu.json");

    //Json herriak_kordenatu fitxategiaren data lista batetan gordetzen dau. Metodo hau programaren zutabea da, prozesu danetarako behar dena.
    public List<Herria> Kargatu() {
        //objetuen (herriak) lista sortzen dau, datu guztiak gorde eta gero bueltauko dana.
        List<Herria> lista = new ArrayList<>();

        // fitxategia existitzen ez bada, lista hutsa bueltatzeko
        if (!Files.exists(FITXATEGIA)) {
            return lista; // primera ejecución: lista vacía
        }

        //saiatuko da fitxategiaren datuak lista batetara pasatzen
        try (Reader fr = Files.newBufferedReader(FITXATEGIA); JsonReader reader = Json.createReader(fr)) {

            //fitxategia irakurri eta JsonArray-a sortzen dau
            JsonArray array = reader.readArray();

            // json fitxategia objetuz objetu pasatu lista batera
            for (JsonObject obj : array.getValuesAs(JsonObject.class)) {
                String izena = obj.getString("izena");
                double lat = obj.getJsonNumber("latitudea").doubleValue();
                double lon = obj.getJsonNumber("longitudea").doubleValue();

                lista.add(new Herria(izena, lat, lon));
            }
        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzean: " + e.getMessage());
        }

        return lista;
    }

    //Pasatutako lista Json herriak_kordenatu fitxategian idazten ditu
    public void gorde(List<Herria> lista) {

        //JsonArray inmutableak direnez, eta herriak gehitze joan behar direnez, arrayBuilder bat sortzen dau.
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        //listan dauden herriak banan banan idazten ditu arrayBuilder-ean
        for (Herria h : lista) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("izena", h.getIzena())
                    .add("latitudea", h.getLatitudea())
                    .add("longitudea", h.getLongitudea()));
        }

        //esandako karpeta sortzen dela sihurtatzen du, bestela sortuko dau
        try {
            Files.createDirectories(FITXATEGIA.getParent());

            //saituko da fitxategia esandako helbidean bilatzen, ez aurkitzekotan idatzeko dau
            try (Writer fw = Files.newBufferedWriter(FITXATEGIA); //fw da "kanala" karaktereak fitxeruan idezteko
                    JsonWriter writer = Json.createWriterFactory( //json idazleak sortuko ditu
                            Map.of(JsonGenerator.PRETTY_PRINTING, true)).createWriter(fw)) {

                writer.writeArray(arrayBuilder.build()); //hemen idazten da arrayBuilder-etik json fitxategira
            }
        } catch (IOException e) {
            System.out.println("Errorea fitxategia idaztean: " + e.getMessage());
        }
    }

    //objetu berria Json herriak_kordenatu fitxategian idazten du.
    public void gehitu(Herria h) {
        //dauden datu guztiak lista batetan gordetzen ditu
        List<Herria> lista = Kargatu();
        //pasatutako datu berria listara gehitzen du
        lista.add(h);
        //lista json fitxategian gordetzen du.
        gorde(lista);
    }

    
}
