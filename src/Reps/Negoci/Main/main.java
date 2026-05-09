package Reps.Negoci.Main;

import Reps.Negoci.Persistència.Entitats.ProducteInvalidException;
import Reps.Negoci.Entitats.Producte;
import Reps.Negoci.Entitats.ProducteDAOtxt;
import Reps.Negoci.Persistència.ProducteDAOJDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        String fi = "FI";
        List<Producte> inventari = new ArrayList<>();

        //Principi OCP(o) -- es poden afegir tantes lambdes com sigui necessari
        Producte bicicleta = new Producte("Bicicleta", 150.00);

        double preuMeitat = bicicleta.getPreuFinal(p -> p / 2);
        double preuInflacio = bicicleta.getPreuFinal(p -> p * 1.05);

        System.out.println("Preu Bicicleta: " + bicicleta.getPreu() + "€");
        System.out.println("Preu Black Friday: " + preuMeitat + "€");
        System.out.println("Preu Inflació: " + preuInflacio);

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
        Thread filSecundari = new Thread(() -> {
            try {
                ProducteDAOJDBC dao = new ProducteDAOJDBC();
                System.out.println("Actualitzant inventari a la base de dades.");
                Thread.sleep(3000);//simulació latència
                dao.guardarInventari(inventari);
                System.out.println("Base de dades actualitzada");

                List<Producte> inventariRecuperat = dao.recuperarInventari();

                System.out.println("\n>>> Inventari <<<");
                inventariRecuperat.forEach(p -> System.out.println(p.toString()));

                List<Producte> productesCars = Utilitats.filtrar(inventariRecuperat, p -> p.getPreu() > 50);
                List<Producte> productesR = Utilitats.filtrar(inventariRecuperat, p -> p.getNom().startsWith("R"));

            } catch (InterruptedException e) {
                System.out.println("Error en el procés s'actualització: " + e.getMessage());
            }
        });
        filSecundari.start();;

        System.out.println("S'està processant la informació en segon pla.");

    }
    class Utilitats {
        static <T> List<T> filtrar(List<T> llista, Predicate<T> condicio) {
            return llista.stream().filter(condicio).toList();
        }
    }
}
