package Files.RandomAccesFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el nom del fitxer:");
        String nomF = sc.nextLine();

        try (RandomAccessFile raf = new RandomAccessFile(nomF, "rw")) {
            boolean exit = false;

            while (!exit) {
                mostrarContingut(raf);

                System.out.println("Introdueix la comanda que vols executar (a, d, x)");
                String comanda = sc.nextLine().trim().toLowerCase();

                switch (comanda) {
                    case "a":
                        System.out.println("Valor a afegir:");
                        int valor = sc.nextInt();
                        afegirValor(raf, valor);
                        break;

                    case "d":
                        System.out.println("Posició a eliminar:");
                        long posicio = sc.nextLong();
                        eliminarValor(raf, posicio);

                    case "x":
                        exit = true;
                        System.out.println("Programa finalitzat");
                        break;

                    default:
                        System.out.println("Comanda no vàlida");
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    public static void eliminarValor(RandomAccessFile raf, long posicio) throws IOException {
        long numElements = raf.length() / 4;

        if (posicio < 0 || posicio >= numElements) {
            System.out.println("Error: No hi ha cap valor en aquesta posició.");

            for (long i = posicio + 1; i < numElements; i++) {
                raf.seek(i * 4);
                int numDesplacat = raf.readInt();

                raf.seek((i - 1) * 4);
                raf.writeInt(numDesplacat);
            }
            raf.setLength(raf.length() - 4);
        }
    }

    public static void afegirValor(RandomAccessFile raf, int valor) throws IOException {
        raf.seek(raf.length());
        raf.writeInt(valor);
    }

    public static void mostrarContingut(RandomAccessFile raf) throws IOException {
        raf.seek(0);

        long numElements = raf.length() / 4;

        if (numElements == 0) {
            System.out.println("Fitxer buit");
        } else {
            System.out.println("Contingut del fitxer:");

            for (long i = 0; i < numElements; i++) {
                System.out.println(raf.readInt() + "\t");
                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
            if (numElements % 10 != 0) {
                System.out.println();
            }
        }
    }
}
