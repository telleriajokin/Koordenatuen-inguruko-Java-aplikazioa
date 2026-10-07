package paagbi;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import paagbi.model.Hiria;
import paagbi.model.Hiria.HiriDatuak;

public class App {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int aukera;

        do {

            System.out.println("\n===== KOORDENATUEN JOKOA =====");
            System.out.println("1. Hiri berria gehitu");
            System.out.println("2. Hiri guztiak erakutsi");
            System.out.println("3. Jolastu");
            System.out.println("4. Irten");
            System.out.print("Aukeratu aukera bat: ");

            aukera = sc.nextInt();
            sc.nextLine();

            switch (aukera) {

                case 1:
                    gehituHiria(sc);
                    break;

                case 2:
                    erakutsiHiriak();
                    break;

                case 3:
                    jolastu(sc);
                    break;

                case 4:
                    System.out.println("Agur!");
                    break;

                default:
                    System.out.println("Aukera ez da zuzena.");
            }

        } while (aukera != 4);

        sc.close();
    }

    private static void gehituHiria(Scanner sc) {

        try {
            HiriDatuak hiria = new HiriDatuak(sc);

            /*Unmarshal metodoa deitu behar*/

            System.out.println("Hiria ondo gorde da.");

        } catch (Exception e) {

            System.out.println("Errorea datuak sartzean.");
            sc.nextLine();
        }
    }

    private static void erakutsiHiriak() throws IOException {

        // List<Hiria> hiriak = ;
        //marshal metodoa deitu behar

        /* hau geratu leike
         * if (hiriak.isEmpty()) {
         * System.out.println("Ez dago daturik.");
         * } else {
         * for (Hiria h : hiriak) {
         * System.out.println(h.getIzena() + " (" + h.getLatitudea() + ", " +
         * h.getLongitudea() + ")");
         * }
         * }
         */
    }

    private static void jolastu(Scanner sc) {

        /*try {

            List<Hiria> hiriak = CSVKudeatzailea.irakurriGuztiak(); marshal metodoa deitu

            if (hiriak.isEmpty()) {
                System.out.println("Ez dago hiriarik gordeta.");
                return;
            }

            int puntuazioa = 0;

            for (int i = 0; i < 5; i++) {

                int ausazkoPos = (int) (Math.random() * hiriak.size());
                Hiria hiria = hiriak.get(ausazkoPos);

                System.out.println("\nGaldera " + (i + 1));
                System.out.println("Latitudea: " + hiria.getLatitudea());
                System.out.println("Longitudea: " + hiria.getLongitudea());

                System.out.print("Zein hiria da? ");
                String erantzuna = sc.nextLine();

                if (erantzuna.equalsIgnoreCase(hiria.getIzena())) {
                    System.out.println("Zuzena!");
                    puntuazioa++;
                } else {
                    System.out.println("Okerra! Erantzun zuzena: " + hiria.getIzena());
                }
            }

            System.out.println("\nAmaiera!");
            System.out.println("Puntuazioa: " + puntuazioa + "/5");

        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzean.");
        }*/
    }
}
