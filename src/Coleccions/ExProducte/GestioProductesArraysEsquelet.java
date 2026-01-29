package Coleccions.ExProducte;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GestioProductesArraysEsquelet {

    // TODO: defineix aquí com a constants els comparadors necessaris
    public static final Comparator<Producte> PREU_ASC = Comparator.comparingInt(Producte::getPreu);
    public static final Comparator<Producte> PREU_DESC = Comparator.comparingInt(Producte::getPreu).reversed();
    public static final Comparator<Producte> PREU_NOM = Comparator.comparingInt(Producte::getPreu).thenComparing(Producte::getNom);

    public static void main(String[] args) {

        Producte[] productes = {
                new Producte("Ratolí", 15),
                new Producte("Teclat", 25),
                new Producte("Pantalla", 150),
                new Producte("Altaveus", 25),
                new Producte("Càmera", 80),
                new Producte("USB", 15)
        };

        // TODO: crea una còpia completa de l'array inicial
        Producte[] copia = Arrays.copyOf(productes, productes.length);
        Scanner lector = new Scanner(System.in);
        int opcio = -1;

        while (opcio != 0) {

            mostrarMenu();
            opcio = llegirEnter(lector, "Opció: ");

            switch (opcio) {

                case 1:
                    // TODO: mostra tots els productes
                    mostrar(productes);
                    break;

                case 2:
                    // TODO: ordena per preu ascendent
                    Arrays.sort(productes, PREU_ASC);

                    break;
                case 3:
                    // TODO: ordena per preu descendent
                    Arrays.sort(productes, PREU_DESC);
                    break;

                case 4:
                    // TODO: ordena per preu i, en cas d’empat, per nom
                    Arrays.sort(productes, PREU_NOM);
                    break;

                case 5:
                    // TODO: demana N i copia els N primers productes
                    System.out.println("Quants productes vols copiar?");
                    int n = lector.nextInt();
                    Producte[] nPrimers = Arrays.copyOfRange(productes, 0, n);
                    mostrar(nPrimers);
                    break;

                case 6:
                    // TODO: demana inici i fi i copia el rang
                    System.out.println("Introdueix l'inici:");
                    int e = lector.nextInt();
                    System.out.println("Introdueix el final:");
                    int f = lector.nextInt();
                    Producte[] rang = Arrays.copyOfRange(productes, e, f);
                    break;

                case 7:
                    // TODO: compara l'array actual amb la còpia inicial
                    String missatge = Arrays.equals(productes, copia) ? "Son iguals" : "No son iguals";
                    System.out.println(missatge);
                    break;

                case 8:
                    // TODO: omple tot l’array amb un producte "BUIT (0€)"
                    Arrays.fill(productes, new Producte("Buit", 0));
                    break;

                case 9:
                    // TODO:
                    // Usa Arrays.setAll per:
                    // - mantenir el nom original
                    // - assignar un nou preu segons l’índex (10, 20, 30, ...)
                    Arrays.setAll(productes, i -> new Producte(productes[i].getNom(), (i + 1) * 10));
                    break;

                case 10:
                    // TODO:
                    // - ordena l’array pel mateix criteri
                    // - demana un preu
                    // - cerca amb Arrays.binarySearch
                    Arrays.sort(productes, PREU_ASC);
                    int preuCerca = llegirEnter(lector, "Quin preu busques? ");
                    int posicio = Arrays.binarySearch(productes, new Producte("", preuCerca), PREU_ASC);

                    if (posicio >= 0) {
                        System.out.println("Trobat a la posició: " + posicio);
                    } else {
                        System.out.println("No s'ha trobat cap producte amb aquest preu.");
                    }
                    break;

                case 0:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }
        }

    }

    // --- MÈTODES D’AJUDA ---
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRODUCTES ---");
        System.out.println("1. Mostrar productes");
        System.out.println("2. Ordenar per preu ascendent");
        System.out.println("3. Ordenar per preu descendent");
        System.out.println("4. Ordenar per preu i nom");
        System.out.println("5. Copiar N primers");
        System.out.println("6. Copiar un rang");
        System.out.println("7. Comparar amb còpia inicial");
        System.out.println("8. Omplir amb producte buit");
        System.out.println("9. Actualitzar preus amb setAll");
        System.out.println("10. Cercar per preu");
        System.out.println("0. Sortir");
    }

    private static void mostrar(Producte[] productes) {
        System.out.println(Arrays.toString(productes));
    }

    private static int llegirEnter(Scanner sc, String missatge) {
        System.out.print(missatge);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Introdueix un enter. " + missatge);
        }
        return sc.nextInt();
    }
}
