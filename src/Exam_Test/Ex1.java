package Exam_Test;

import java.util.Scanner;

/* Demana un nombre enter positiu per teclat. Si és senar el multipliquem per 3 i li sumem 1. Si és parell el dividim per 2. Repetim aquest procés amb el nou valor acabant quan el número és 1.
Exemple: N = 22. 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1. El programa ha de dir la quantitat de números que s'han generat (16 en aquest cas). */

public class Ex1 {
    public static void main(String[] args) {

        int n, count = 0;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un nombre enter positiu: ");
        n = tec.nextInt();

        if (n <= 0) {
            System.out.println("El nombre ha de ser positiu.");
        } else {

            count = 1;

            int current_n = n;

            System.out.print("Seqüència generada: " + current_n);

            while (current_n != 1) {

                if (current_n % 2 == 0) {

                    current_n = current_n / 2;
                } else {

                    current_n = 3 * current_n + 1;
                }


                count++;

                // Mostrem el següent pas
                System.out.print(" -> " + current_n);

            }

            System.out.println("\n---");
            System.out.println("La quantitat de nombres generats (incloent N) és: " + count);

        }

        tec.close();
    }
}
