/*
Genera un programa que encripti una cadena de caràcters. Per exemple :
“avadakedavra” encriptat es “bwbeblfebwsb” i el mètode d‟encriptació és
canviar un caràcter pel seu successor a l‟abecedari (el successor de „z‟ és „a‟).
 */
package Strings;

public class Ex2 {

    public static void main(String[] args) {
        String missatge = "pasta amb pesto";
        String abecedari = "abcdefghijklmnoprstuvwxyz";
        String resultat = "";

        for (int i = 0; i < missatge.length(); i++) {
            char lletraActual = missatge.charAt(i);

            int posicio = abecedari.indexOf(lletraActual);

            if (posicio != -1) {
                int seguentPosicio = (posicio + 1) % abecedari.length();
                resultat += abecedari.charAt(seguentPosicio);
            } else {
                resultat += lletraActual;
            }
        }

        System.out.println("Missatge original: " + missatge);
        System.out.println("Missatge encriptat: " + resultat);

    }
}
