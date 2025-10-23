package While;

/*
 * Es diu que dos números són primers bessons si ambdós són primers i estan
 * separats per una distància de 2. Per exemple: {3,5}, {5,7}, {11,13}, {17,19}.
 * Construïu un programa que donat un rang d'1 a n, sent n entrada pel
 * programa, determini els primers bessons que hi ha en aquest rang.
 */
import java.util.Scanner;

public class Extra7 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix el rang");
        int rang = tec.nextInt();
        int num = 3;

        while (num <= rang - 2) {

            int numBesso = num + 2;

            boolean num1Primer = true;
            int divisor1 = 2;

            while (divisor1 <= num / 2 && num1Primer) {
                if (num % divisor1 == 0) {
                    num1Primer = false;
                }
                divisor1++;
            }

            if (num1Primer) {

                boolean num2Primer = true;
                int divisor2 = 2;

                while (divisor2 <= numBesso / 2 && num2Primer) {
                    if (numBesso % divisor2 == 0) {
                        num2Primer = false;
                    }
                    divisor2++;
                }

                if (num2Primer) {
                    System.out.println("{" + num + " i " + numBesso + "} són bessons.");
                }
            }
            num++;
        }
    }
}
