package While;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        int d, suma = 0;

        while (num != 0) {

            num = num / 10;
            suma++;
        }
        System.out.println("El nombre que has introduït té " + suma + " digits.");
    }

}
