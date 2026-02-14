package Files;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File directoriActual = new File(System.getProperty("user.dir"));
        boolean finalitzat = false;

        while (!finalitzat) {
            System.out.print("\n" + directoriActual.getAbsolutePath() + " > ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] inputs = input.split(" ", 2);
            String comanda = inputs[0].toLowerCase();

            switch (comanda) {
                case "cd":
                    if (inputs.length < 2) {
                        System.out.println("Error: indica el nom de la carpeta.");
                    } else {
                        directoriActual = canviarDirectori(directoriActual, inputs[1]);
                    }
                    break;
                case "dir":
                    llistarContingut(directoriActual);
                    break;
                case "del":
                    if (inputs.length < 2) {
                        System.out.println("Error: indica el fitxer a esborrar.");
                    } else {
                        esborrarFitxer(directoriActual, inputs[1]);
                    }
                    break;
                case "prop":
                    if (inputs.length < 2) {
                        System.out.println("Error: indica el fitxer per a les propietats.");
                    } else {
                        mostrarPropietats(directoriActual, inputs[1]);
                    }
                    break;
                case "fi":
                    finalitzat = true;
                    System.out.println("Programa finalitzat.");
                    break;
                default:
                    System.out.println("Error: comanda no vàlida.");
            }
        }
        sc.close();
    }

    private static File canviarDirectori(File actual, String desti) {
        if (desti.equals("..")) {
            File pare = actual.getParentFile();
            return (pare != null) ? pare : actual;
        } else {
            File novaCarpeta = new File(actual, desti);
            if (novaCarpeta.exists() && novaCarpeta.isDirectory()) {
                return novaCarpeta;
            } else {
                System.out.println("Error: Carpeta inexistent.");
                return actual;
            }
        }
    }

    private static void llistarContingut(File actual) {
        String[] llista = actual.list();
        if (llista != null) {
            for (String s : llista) {
                File f = new File(actual, s);
                String tipus = f.isDirectory() ? "[DIR]" : "     ";
                System.out.println(tipus + " " + s);
            }
        }
    }

    private static void esborrarFitxer(File actual, String nom) {
        File f = new File(actual, nom);
        if (f.exists() && f.isFile()) {
            if (f.delete()) {
                System.out.println("El fitxer s'ha esborrat correctament.");
            } else {
                System.out.println("Error: no s'ha pogut esborrar.");
            }
        } else {
            System.out.println("Error: el fitxer no existeix o és un directori.");
        }
    }

    private static void mostrarPropietats(File actual, String nom) {
        File f = new File(actual, nom);
        if (f.exists()) {
            System.out.println("Propietats de: " + f.getName());
            System.out.println("- Mida: " + f.length() + " bytes");
            System.out.println("- Última modificació: " + new Date(f.lastModified()));
        } else {
            System.out.println("Error: el fitxer no existeix.");
        }
    }
}