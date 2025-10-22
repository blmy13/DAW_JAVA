/*
 Un centre numèric és un nombre que separa una llista d’enters (començant en 1) en
dos grups de números, les sumes dels quals són iguals. El primer centre numèric és
el 6, el qual separa la llista (1-8) en els grups (1,2,3,4,5) i (7,8) les sumes de les
quals són iguals a 15. El segon centre numèric és el 35, que separa la llista (1 a 49)
en els grups (1 a 34) i (36 a 49) les sumes de les quals són iguals a 595. Escriviu un
programa que calculi els centres numèrics entre 1 i n (número entrat per l’usuari).
 */
package While;

import java.util.Scanner;

public class Extra2 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        int inicial = 1;
        int sumaAbans = 0;
        int sumaDespres = 0;
        boolean trobat = false;

        for (int i = 1; i < num; i++) {

            while (inicial < i) {

                sumaAbans += inicial;
                inicial++;
            }

            while (!trobat) {

                int numSeguent = i + 1;
                sumaDespres += i + 1;
                numSeguent++;
                if (sumaDespres == sumaAbans) {
                    trobat = true;
                }

            }
            
            String resultat = trobat ? "El número " + i + " és un centre numèric." : "El número " + i + " no és un centre numèric.";
            System.out.println(resultat);
        }

    }

}
