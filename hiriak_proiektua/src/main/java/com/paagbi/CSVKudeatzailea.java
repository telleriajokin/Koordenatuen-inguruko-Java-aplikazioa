package com.paagbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CSVKudeatzailea {

    private static final String FITXATEGIA = "hiriak.csv";

    public static void sortuCSV() throws IOException {

        Path path = Paths.get(FITXATEGIA);

        if (!Files.exists(path)) {

            Files.write(
                    path,
                    "Hiria;Latitudea;Longitudea\r\n".getBytes(StandardCharsets.UTF_8), // irakurtzeko karaktere
                                                                                       // ez-ohikoak
                    StandardOpenOption.CREATE);
        }
    }

    public static void gehituHiria(Hiria hiria) throws IOException {

        Path path = Paths.get(FITXATEGIA);

        String lerroa = hiria.getIzena() + ";" +
                hiria.getLatitudea() + ";" +
                hiria.getLongitudea() + "\r\n";

        Files.write(
                path,
                lerroa.getBytes(StandardCharsets.UTF_8), // irakurtzeko karaktere ez-ohikoak
                StandardOpenOption.APPEND);
    }

    public static List<Hiria> irakurriGuztiak() throws IOException {
        List<Hiria> hiriak = new ArrayList<>();
        Path path = Paths.get(FITXATEGIA);

        if (!Files.exists(path)) {
            return hiriak;
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            br.readLine(); // goiburua (cabecera) baztertu

            String lerroa;
            while ((lerroa = br.readLine()) != null) {
                if (lerroa.trim().isEmpty()) {
                    continue; // lerro hutsa
                }

                String[] zatiak = lerroa.split(";");
                if (zatiak.length != 3) {
                    System.out.println("Lerro okerra, saltatzen: " + lerroa);
                    continue;
                }

                try {
                    String izena = zatiak[0].trim();
                    String latitudea = zatiak[1].trim();
                    String longitudea = zatiak[2].trim();
                    hiriak.add(new Hiria(izena, latitudea, longitudea));
                } catch (NumberFormatException e) {
                    System.out.println("Zenbaki okerra, saltatzen: " + lerroa);
                }
            }
        }
        return hiriak;
    }
}
