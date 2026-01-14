package Genèrics.ExInventari;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        boolean finalitzat = false;
        Inventari<Llibre> InventariLlibres = new Inventari<>();
        Inventari<Electrodomèstic> InventariElectrodomestics = new Inventari<>();

        while (!finalitzat) {
            System.out.println("--- MENÚ ---\n1. Afegir Llibre\n2. Afegir Electrodomèstic\n3. Mostrar tots els Llibres\n4. Mostrar tots els electrodomèstics\n5. Consultar producte per ID\n6. Eliminar producte per ID\n7. Sortir\nSelecciona una opció:");
            
            boolean funciona = true;
            String missatge = "";
            
            try {
                int tria = tec.nextInt();
                tec.nextLine(); 

                switch (tria) {
                    case 1:
                        try {
                            System.out.println("ID del llibre: ");
                            String id = tec.nextLine();
                            System.out.println("Títol del llibre: ");
                            String titol = tec.nextLine();
                            System.out.println("Preu del llibre: ");
                            double preu = tec.nextDouble();
                            tec.nextLine(); 
                            System.out.println("Autor:");
                            String autor = tec.nextLine();
                            
                            Llibre llibre1 = new Llibre(id, titol, preu, autor);
                            InventariLlibres.afegirProducte(llibre1);
                        } catch (Exception e) {
                            funciona = false;
                        } finally {
                            missatge = funciona ? "El llibre s'ha afegit correctament." : "El llibre no s'ha pogut afegir";
                            System.out.println(missatge);
                        }
                        break;

                    case 2:
                        try {
                            System.out.println("ID de l'electrodomèstic: ");
                            String id = tec.nextLine();
                            System.out.println("Nom de l'electrodomèstic: ");
                            String nom = tec.nextLine();
                            System.out.println("Preu de l'electrodomèstic: ");
                            double preu = tec.nextDouble();
                            tec.nextLine(); 
                            System.out.println("Marca:");
                            String marca = tec.nextLine();
                            
                            Electrodomèstic ele1 = new Electrodomèstic(id, nom, preu, marca);
                            InventariElectrodomestics.afegirProducte(ele1);
                        } catch (Exception e) {
                            funciona = false;
                        } finally {
                            missatge = funciona ? "L'electrodomèstic s'ha afegit correctament." : "L'electrodomèstic no s'ha pogut afegir";
                            System.out.println(missatge);
                        }
                        break;

                    case 3:
                        InventariLlibres.mostrarTots();
                        break;
                        
                    case 4:
                        InventariElectrodomestics.mostrarTots();
                        break;

                    case 5:
                        System.out.println("Introdueix l'ID del producte que vols buscar:");
                        String idBusca = tec.nextLine();
                        try {
                            System.out.println(InventariLlibres.consultarProducte(idBusca));
                        } catch (IllegalArgumentException e) {
                            try {
                                System.out.println(InventariElectrodomestics.consultarProducte(idBusca));
                            } catch (IllegalArgumentException f) {
                                funciona = false;
                            }
                        } finally {
                            if (!funciona) System.out.println("El producte amb ID: " + idBusca + " no s'ha trobat.");
                        }
                        break;

                    case 6:
                        System.out.println("Introdueix l'ID del producte que vols eliminar:");
                        String idElim = tec.nextLine();
                        try {
                            InventariLlibres.eliminar(idElim);
                        } catch (IllegalArgumentException g) {
                            try {
                                InventariElectrodomestics.eliminar(idElim);
                            } catch (IllegalArgumentException h) {
                                funciona = false;
                            }
                        } finally {
                            missatge = funciona ? "El producte s'ha eliminat correctament" : "El producte no es troba a l'inventari";
                            System.out.println(missatge);
                        }
                        break;

                    case 7:
                        System.out.println("Programa finalitzat.");
                        finalitzat = true;
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Introdueix un número vàlid.");
                tec.nextLine(); 
            }
        }
        tec.close();
    }
}