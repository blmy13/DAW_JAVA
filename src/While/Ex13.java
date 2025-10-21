package While;

//programa que vagi llegint números positius (per finalitzar -1) i indiqui
//si cada valor és més gran que l'anterior.
import java.util.Scanner;

public class Ex13 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número. (-1 per acabar)");
        int num = tec.nextInt();
        int numNext = num;

        while (numNext != -1 && numNext <= num) {

            num = numNext;
            System.out.println("Introdueix el següent número.");
            numNext = tec.nextInt();

        }

        if (numNext > num) {
            System.out.println("El número: " + numNext + " és més gran que el número: " + num);
        } else {
            System.out.println("Programa finalitzat.");
        }
    }
}
