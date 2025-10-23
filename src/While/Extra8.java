package While;
/*
Es diu que dos números són amics si la suma dels divisors d’un donen com a
resultat el valor de l’altre i viceversa. Construïu un programa que determini si dos
números n1i n2 entrats per teclat són amics o no.
 */

import java.util.Scanner;

public class Extra8 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int n1 = tec.nextInt();
        System.out.println("Introdueix l'altre número.");
        int n2 = tec.nextInt();

        int sumaD1 = 0;
        int sumaD2 = 0;

        int div1 = 1;
        int div2 = 1;

        while (div1 <= n1 / 2) {
            if (n1 % div1 == 0) {
                sumaD1 += div1;
            }
            div1++;
        }
        while (div2 <= n2 / 2) {
            if (n2 % div2 == 0) {
                sumaD2 += div2;
            }
            div2++;
        }
        if (sumaD2 == n1 && sumaD1 == n2) {
            System.out.println(n1 + " i" + n2 + " són números amics.");
        }

    }
}
