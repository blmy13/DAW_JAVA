package Exam_Test;

//Una línia horitzontal la definim per les dues coordenades x dels dos extrems. Un punt es troba a la mateixa línia horitzontal i l’establim amb la seva coordenada x.
//El programa llegirà tres números, els dos primers seran els extrems de la línia (no tenen perquè estar ordenats) i el tercer serà la coordenada del punt.
//El programa ha de respondre si el punt està dins la línia i la distància a l’extrem més proper.

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        int ext1, ext2, val, punt;

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix el primer extrem: ");
        ext1 = tec.nextInt();

        System.out.println("Introdueix el segon extrem: ");
        ext2 = tec.nextInt();

        System.out.println("Introdueix el punt: ");
        punt = tec.nextInt();

        if (ext2 < ext1) {
            val = ext1;
            ext1 = ext2;
            ext2 = val;
        }

        if (punt <= ext1) {
            System.out.println("El punt no es troba entre els dos extrems. ");
            System.out.println("La distància entre el punt i l'extrem esquerra és: " + (ext1 - punt));
        } else if (punt >= ext2) {
            System.out.println("El punt no es troba entre els dos extrems. ");
            System.out.println("La distància entre el punt i l'extrem dret és: " + (punt - ext2));
        } else {
            val = punt - ext1;
            System.out.println("Està dins.");
            if (val < (ext2 - punt)) {
                System.out.println("La distància entre el punt i l'extrem esquerra és " + val);
            } else if (val > (ext2 - punt)) {
                val = ext2 - punt;
                System.out.println("La distància entre el punt i l'extrem dret és " + val);
            } else {
                System.out.println("El punt està al mig de la línia. ");
            }
            System.out.print(ext1);
            for (int i = ext1 + 1; i < ext2; i++) {
                if (i == punt) {
                    System.out.print(punt);
                } else {
                    System.out.print("-");
                }
            }
            System.out.print(ext2);

        }
    }
}
