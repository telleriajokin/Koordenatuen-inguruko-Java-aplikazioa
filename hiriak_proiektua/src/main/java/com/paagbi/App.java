package com.paagbi;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            CSVKudeatzailea.sortuCSV();
        } catch (IOException e) {
            System.out.println("Errorea fitxategia sortzean.");
            return;
        }

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
            Hiria hiria = new Hiria(sc);

            CSVKudeatzailea.gehituHiria(hiria);

            System.out.println("Hiria ondo gorde da.");

        } catch (Exception e) {

            System.out.println("Errorea datuak sartzean.");
            sc.nextLine();
        }
    }

    private static void erakutsiHiriak() {

        System.out.println("Oraindik ez dago implementatuta.");
    }

    private static void jolastu(Scanner sc) {

        System.out.println("Oraindik ez dago implementatuta.");
    }
}
