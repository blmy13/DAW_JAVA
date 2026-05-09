package Reps.Negoci.Main;

import Reps.Negoci.Persistència.Entitats.ProducteInvalidException;
import Reps.Negoci.Entitats.Producte;
import Reps.Negoci.Entitats.ProducteDAOtxt;
import Reps.Negoci.Persistència.ProducteDAOJDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        String fi = "FI";
        List<Producte> inventari = new ArrayList<>();

        while (running) {
            System.out.println("Nom del producte:");
            String nom = sc.nextLine();
            if (nom.equalsIgnoreCase(fi)) {
                break;
            }
            System.out.println("Preu del producte:");
            double preu = sc.nextDouble();
            sc.nextLine();

            try {
                Producte p = new Producte(nom, preu);
                System.out.println("Producte instanciat");
                inventari.add(p);
                System.out.println("Producte afegit a l'inventari");

            } catch (ProducteInvalidException e){
                System.out.println(e.getMessage());
            }
        }
        ProducteDAOJDBC dao = new ProducteDAOJDBC();
        dao.guardarInventari(inventari);

        List<Producte> inventariRecuperat = dao.recuperarInventari();

        System.out.println("\n>>> Inventari <<<");
        inventariRecuperat.forEach(p -> System.out.println(p.toString()));

    }
}
