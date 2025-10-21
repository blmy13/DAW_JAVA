package While;

//programa que llegeixi un número i indiqui si tots els dígits són parells.
import java.util.Scanner;

public class Ex12 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        int d;
        boolean totsParells = false;
        int numD = 0;
        int digParells = 0;

        while (num > 0) {

            d = num % 10;

            numD++;

            if (d % 2 == 0) {

                digParells++;
            }

            num = num / 10;

        }
        if (numD == digParells) {
            totsParells = true;
        }
        System.out.println(totsParells ? "Tots els dígits del número que has introduït són parells." : "No tots els dígits són parells");

    }

}
