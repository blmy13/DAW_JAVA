package Files.RandomAccesFile.Lluitadors;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class CrearFitxerLluitadors {

    private static final int MIDA_NOM = 20;
    private static final int MIDA_LLUITADOR = (MIDA_NOM * 2) + (5 * 4) + 8;

    static class Lluitador {

        String nom;
        double poder;
        int vida;
        int atac;
        int defensa;
        int velocitat;
        int victories;

        Lluitador(String nom, double poder, int vida, int atac, int defensa, int velocitat, int victories) {
            this.nom = nom;
            this.poder = poder;
            this.vida = vida;
            this.atac = atac;
            this.defensa = defensa;
            this.velocitat = velocitat;
            this.victories = victories;
        }
    }

    public static int mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- MENÚ --");
        System.out.println("1. VEURE TOTS ELS LLUITADORS");
        System.out.println("2. MODIFICAR VIDA D'UN LLUITADOR");
        System.out.println("3. MODIFICAR VICTÒRIES D'UN LLUITADOR");
        System.out.println("4. SIMULAR UN COMBAT");
        System.out.println("SELECCIONA UNA OPCIÓ:");
        int tria = sc.nextInt();

        return tria;
    }

    public static void mostrarLluitadors() {
        try (RandomAccessFile raf = new RandomAccessFile("lluitadors.dat", "r")) {
            raf.seek(0);

            long numLinies = raf.length() / MIDA_LLUITADOR;

            System.out.printf("%-20s %-5s %-5s %-5s %-10s %-10s %-10s%n", "LLUITADOR", "PODER", "VIDA", "ATAC", "DEFENSA", "VELOCITAT", "VICTORIES");
            System.out.printf("%s%n", "-".repeat(71));

            for (long i = 0; i < numLinies; i++) {
                String nomLlegit = "";
                for (int c = 0; c < MIDA_NOM; c++) {
                    nomLlegit += raf.readChar();
                }
                double poder = raf.readDouble();
                int vida = raf.readInt();
                int atac = raf.readInt();
                int defensa = raf.readInt();
                int velocitat = raf.readInt();
                int victories = raf.readInt();

                System.out.printf("%-20s %-5.2f %-5d %-5d %6d %12d %10d%n", nomLlegit.trim(), poder, vida, atac, defensa, velocitat, victories);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void modificarVida(int index, int vidaNova) {
        try (RandomAccessFile raf = new RandomAccessFile("lluitadors.dat", "rw")) {
            long iniciVida = (MIDA_NOM * 2) + 8;

            raf.seek((long) index * MIDA_LLUITADOR + iniciVida);
            raf.writeInt(vidaNova);
            System.out.println("Vida actualitzada amb èxit.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void modificarVictories(int index, int victories) {
        try (RandomAccessFile raf = new RandomAccessFile("lluitadors.dat", "rw")) {
            long iniciVictories = (MIDA_LLUITADOR - 4);

            raf.seek((long) index * MIDA_LLUITADOR + iniciVictories);
            raf.writeInt(victories);
            System.out.println("Victòries actualitzades amb èxit.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Lluitador llegirLluitador(int index) {
        Lluitador lluitador = null;
        try (RandomAccessFile raf = new RandomAccessFile("lluitadors.dat", "r")) {
            raf.seek((long) MIDA_LLUITADOR * index);
            String nomLlegit = "";

            for (int c = 0; c < MIDA_NOM; c++) {
                nomLlegit += raf.readChar();
            }
            String nom = nomLlegit.trim();
            double poder = raf.readDouble();
            int vida = raf.readInt();
            int atac = raf.readInt();
            int defensa = raf.readInt();
            int velocitat = raf.readInt();
            int victories = raf.readInt();

            lluitador = new Lluitador(nom, poder, vida, atac, defensa, velocitat, victories);

        } catch (IOException e) {
            System.out.println(e);
        }
        return lluitador;
    }

    public static void simularCombat(int index1, int index2) {
        Lluitador p1 = llegirLluitador(index1);
        Lluitador p2 = llegirLluitador(index2);
        Random rand = new Random();

        Lluitador atacant = null;
        Lluitador defensor = null;

        if (p1.velocitat > p2.velocitat) {
            atacant = p1;
            defensor = p2;
        } else if (p1.velocitat < p2.velocitat) {
            atacant = p2;
            defensor = p1;
        } else {
           if (rand.nextBoolean()) {
               atacant = p1;
               defensor = p2;
           } else {
               atacant = p2;
               defensor = p1;
           }
        }
        System.out.println("COMENÇA " + atacant.nom);


        while (atacant.vida > 0 && defensor.vida > 0) {
            int dany = Math.max(1, (int) ((atacant.atac + atacant.poder * 0.1) - defensor.defensa + rand.nextInt(11) - 5));
            defensor.vida -= dany;
            System.out.println(atacant.nom + " ataca a " + defensor.nom + " causant " + dany + " de dany.");

            Lluitador temp = atacant;
            atacant = defensor;
            defensor = temp;
        }
        System.out.println("-- COMBAT FINALITZAT --");
        if (p1.vida > 0) {
            System.out.println("El guanyador és " + p1.nom + "!");
            modificarVictories(index1, p1.victories + 1);
            modificarVida(index1, p1.vida);
            modificarVida(index2, 0);
        } else {
            System.out.println("El guanyador és " + p2.nom + "!");
            modificarVictories(index1, p2.victories + 1);
            modificarVida(index1, p2.vida);
            modificarVida(index1, 0);
        }

    }

    public static void escriureLluitador(RandomAccessFile fitxer, long index, Lluitador lluitador) throws IOException {
        fitxer.seek(index * MIDA_LLUITADOR);
        // Escriure nom amb mida fixa
        String nomFix = (lluitador.nom + " ".repeat(MIDA_NOM)).substring(0, MIDA_NOM); // exactament 'mida' caràcters
        fitxer.writeChars(nomFix);
        fitxer.writeDouble(lluitador.poder);
        fitxer.writeInt(lluitador.vida);
        fitxer.writeInt(lluitador.atac);
        fitxer.writeInt(lluitador.defensa);
        fitxer.writeInt(lluitador.velocitat);
        fitxer.writeInt(lluitador.victories);
    }

    public static void main(String[] args) {
        Lluitador[] lluitadors = {
                new Lluitador("Goku", 99.5, 1000, 120, 80, 90, 0),
                new Lluitador("Vegeta", 97.3, 980, 115, 85, 85, 0),
                new Lluitador("Frieza", 95.0, 950, 130, 70, 95, 0),
                new Lluitador("Gohan", 94.2, 970, 110, 75, 88, 0),
                new Lluitador("Piccolo", 90.0, 1100, 100, 90, 80, 0),
                new Lluitador("Cell", 92.5, 1050, 125, 78, 87, 0),
                new Lluitador("Majin Buu", 91.0, 1200, 140, 65, 75, 0),
                new Lluitador("Trunks", 89.8, 940, 108, 82, 86, 0),
                new Lluitador("Broly", 98.0, 1100, 150, 95, 70, 0),
                new Lluitador("Pollito Pio", 88.5, 930, 105, 80, 89, 0)
        };

        // Ordenar per poder (de més fort a menys fort)
        Arrays.sort(lluitadors, Comparator.comparingDouble(l -> -l.poder));

        // Escriure lluitadors ordenats al fitxer
        try (RandomAccessFile fitxer = new RandomAccessFile("lluitadors.dat", "rw")) {
            for (int i = 0; i < lluitadors.length; i++) {
                escriureLluitador(fitxer, i, lluitadors[i]);
            }
            System.out.println("Fitxer lluitadors.dat creat i ordenat per poder!");
        } catch (IOException e) {
            System.out.println(e);
        }
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            int tria = mostrarMenu();
            switch (tria) {
                case 1:
                    mostrarLluitadors();
                    break;

                case 2:
                    System.out.println("INDEX DEL JUGADOR A MODIFICAR");
                    int index = sc.nextInt();
                    System.out.println("NOU VALOR VIDA");
                    int vida = sc.nextInt();

                    modificarVida(index, vida);
                    break;

                case 3:
                    System.out.println("INDEX DEL JUGADOR A MODIFICAR");
                    index = sc.nextInt();
                    System.out.println("NOU VALOR VICTÒRIES");
                    int victories = sc.nextInt();

                    modificarVictories(index, victories);
                    break;

                case 4:
                    System.out.println("INDEX DEL PRIMER LLUITADOR");
                    int index1 = sc.nextInt();
                    System.out.println("INDEX DEL SEGON LLUITADOR");
                    int index2 = sc.nextInt();
                    simularCombat(index1, index2);
                    break;

                case 5:
                    exit = true;

                    System.out.println("PROGRAMA FINALITZAT");
                    break;

                default:
                    System.out.println("OPCIÓ NO VÀLIDA");
            }
        }


    }
}
