package com.paagbi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CSVKudeatzailea {

    private static final String FITXATEGIA = "hiriak.csv";

    public static void sortuCSV() throws IOException {

        Path path = Paths.get(FITXATEGIA);

        if (!Files.exists(path)) {

            Files.write(
                    path,
                    "Hiria,Latitudea,Longitudea\n".getBytes(),
                    StandardOpenOption.CREATE
            );
        }
    }

    public static void gehituHiria(Hiria hiria) throws IOException {

        Path path = Paths.get(FITXATEGIA);

        String lerroa =
                hiria.getIzena() + "," +
                hiria.getLatitudea() + "," +
                hiria.getLongitudea() + "\n";

        Files.write(
                path,
                lerroa.getBytes(),
                StandardOpenOption.APPEND
        );
    }
}
