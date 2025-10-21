package While;

//Llegir números i dir si tots són parells.

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();

        boolean parell = true;

        while (num != -1) {


            if (num % 2 != 0) {
                parell = false;
            }

            System.out.println("Introdueix el següent número.");
            num = tec.nextInt();
        }


        System.out.println(parell ? "Tots els números que has introduït són parells" : "No tots els números introduïts són parells.");
    }
}
