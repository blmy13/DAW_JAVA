package Excepcions.Ex1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaDeCompres {

    public static void mostrarCarret(ArrayList<Producte> productes) {
        if (productes.isEmpty()) {
            System.out.println("El carret està buit!");
        } else {
            for (Producte p : productes) {
                System.out.println(p);
            }
        }
    }

    public static void afegirProducte(ArrayList<Producte> productes, Scanner tec) {
        boolean funciona = true;
        try {
            System.out.println("Introdueix el nom del producte:");
            String nom = tec.nextLine();

            System.out.println("Introdueix el preu del producte:");
            double preu = tec.nextDouble();

            System.out.println("Introdueix la quantitat:");
            int quantitat = tec.nextInt();
            tec.nextLine();

            Producte p = new Producte(nom, preu, quantitat);
            productes.add(p);
            System.out.println("Producte afegit correctament.");

        } catch (InputMismatchException f) {
            System.out.println("Error: Dada numèrica no vàlida.");
            tec.nextLine();
            funciona = false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            funciona = false;
        } finally {
            System.out.println(funciona ? "Operació completada amb èxit." : "Operació no completada");
        }
    }

    public static void main(String[] args) {
        ArrayList<Producte> productes = new ArrayList<>();
        Scanner tec = new Scanner(System.in);
        boolean finalitzat = false;

        while (!finalitzat) {
            System.out.println("\n--MENÚ--\n1. Afegir Producte al carret\n2. Mostrar Carret\n3. Sortir\nSelecciona una opció (1 - 3)");

            try {
                int tria = tec.nextInt();
                tec.nextLine();

                switch (tria) {
                    case 1 ->
                        afegirProducte(productes, tec);
                    case 2 ->
                        mostrarCarret(productes);
                    case 3 -> {
                        finalitzat = true;
                        System.out.println("--Programa Finalitzat--");
                    }
                    default ->
                        System.out.println("Opció no vàlida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introdueix un número vàlid.");
                tec.nextLine();
            }
        }
        tec.close();
    }
}
