package While;

//Demana números i mostra els números seguits l'un de l'altre en parella. Per exemple si la seqüència de números és: 7 10 11 23
//4 5 8 10 11 12 -1, mostrarà: 10 11, 4 5, 10 11, 11 12

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número. (-1 per acabar)");
        int num = tec.nextInt();

        int numSeguent;

        while (num != -1) {

            System.out.println("Introdueix un altre número");
            numSeguent = tec.nextInt();

            if (numSeguent - num == 1) {
                System.out.print(+num + " " + numSeguent + ",");
            }
            num = numSeguent;
        }
    }
}
