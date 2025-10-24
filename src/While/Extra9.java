/*
Escriviu un programa que generi els 20 primers números que en descompondre’ls en
factors primers només apareguin els números 2, 3 i 5.
 */
package While;

import java.util.Scanner;

public class Extra9 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        int num = 2;
        int contNum = 0;
        boolean descomposable = true;
        int div = 2;

        while (contNum <= 20) {

            int aux = num;
            descomposable = true;
            while (aux > 1 && descomposable) {

                if (aux % 2 == 0) {
                    aux = aux / 2;
                } else if (aux % 3 == 0) {
                    aux = aux / 3;
                } else if (aux % 5 == 0) {
                    aux = aux / 5;
                } else {
                    descomposable = false;
                }

            }
            if (descomposable) {
                System.out.println(num);
                contNum++;
            }
            num++;
        }

    }
}
