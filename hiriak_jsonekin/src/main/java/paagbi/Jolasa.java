package paagbi;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import paagbi.models.Herria;

public class Jolasa {
    private final List<Herria> lista;
    private final Scanner sc;

    public Jolasa(List<Herria> lista, Scanner sc) {
        this.lista = lista;
        this.sc = sc;
    }

    public void jolastu() {
        //Ezin dela jolastu azaldu, fitxategia hutsik badago
        if (lista.isEmpty()) {
            System.out.println("Ez dago herririk jolasteko. Sartu datuak lehenik.");
            return;
        }

        int puntuak = 0; //puntuazioa
        for (int i = 0; i < 5; i++) { //bost "ronda"
            //era aleatorioan herria aukeratu
            Herria h = lista.get(new Random().nextInt(lista.size()));

            //Galdera erakutzi
            System.out.println("\nGaldera " + (i + 1));
            System.out.println("Koordenatuak: " + h.getLatitudea() + ", " + h.getLongitudea());
            System.out.print("Zein hiri da? ");
            //erantzuna batu
            String erantzuna = sc.nextLine().trim();

            //konprobaketa: ondo ala txarto?
            if (erantzuna.equalsIgnoreCase(h.getIzena())) {
                System.out.println("Zuzena!");
                puntuak++;
            } else {
                System.out.println("Oker. Erantzuna: " + h.getIzena());
            }
        }
        //Amaiera
        System.out.println("\nAmaiera!");
        System.out.println("Puntuazioa: " + puntuak + "/5");
    }
}
