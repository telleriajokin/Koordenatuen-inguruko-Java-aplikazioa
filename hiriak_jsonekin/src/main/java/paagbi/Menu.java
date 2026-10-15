package paagbi;

import java.util.List;
import java.util.Scanner;

import paagbi.data.jsonFitxategienKudeatzailea;
import paagbi.models.Herria;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final jsonFitxategienKudeatzailea kudeatzailea = new jsonFitxategienKudeatzailea();

    public void hasi() {
        int aukera;
        do {
            System.out.println("\n--- MENUA ---");
            System.out.println("1. Datuak sartu");
            System.out.println("2. Datu guztiak erakutsi");
            System.out.println("3. Jolastu");
            System.out.println("0. Irten");
            System.out.print("Aukeratu: ");

            try {
                aukera = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                aukera = -1;
            }

            switch (aukera) {
                case 1 -> herriaSartu();
                case 2 -> datuakErakutsi();
                case 3 -> new Jolasa(kudeatzailea.Kargatu(), sc).jolastu();
                case 0 -> System.out.println("Agur!");
                default -> System.out.println("Aukera okerra.");
            }
        } while (aukera != 0);
    }

    private void herriaSartu() {
    try {
        kudeatzailea.gehitu(new Herria(sc));
        System.out.println("Gordeta!");
    } catch (NumberFormatException e) {
        System.out.println("Koordenatu okerra, ez da gorde.");
    }
}

    private void datuakErakutsi() {
        List<Herria> lista = kudeatzailea.Kargatu();
        if (lista.isEmpty()) {
            System.out.println("Ez dago daturik.");
            return;
        }
        for (Herria h : lista) {
            System.out.println(h);
        }
    }
}
