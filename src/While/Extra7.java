package While;

/**
 * Es diu que dos números són primers bessons si ambdós són primers i estan
 * separats per una distància de 2. Per exemple : {3,5}, {5,7}, {11,13},{17,19}.
 * Construïu un programa que donat un rang de 1 a n, sent n entrada pel
 * programa, determini els primers bessons que hi ha en aquest rang.
 */
import java.util.Scanner;

public class Extra7 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix el rang");
        int rang = tec.nextInt();
        int num = 2;
        boolean num1Primer = true;
        boolean num2Primer = true;
        int numBesso = num + 2;

        while (num <= rang) {

            if (rang % num == 0) {
                num1Primer = false;

            } else {
                
                num1Primer = true;
                while (numBesso <= rang) {
                    
                    if (numBesso % rang == 0) {
                        num2Primer = false;
                    } else {
                        num2Primer = true;
                    }
                    numBesso++;
                }
                
            }
        num++;                                
        }
        if (num1Primer && num2Primer) {
            System.out.println("Els números " + num + " i" + numBesso + " són bessons.");
        }
    }

}
