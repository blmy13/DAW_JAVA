package While;

import java.util.Scanner;

//Determina el número de dígits més grans que 5.

public class Ex6 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        int d, major5 = 0;

        while (num > 0){

            d = num % 10;
            if (d > 5){
                System.out.println("El dígit " + d + " és més gran que 5.");
                major5++;
            }
            num = num / 10;
        }
        System.out.println("Hi ha " + major5 + " dígits majors que 5.");

    }
}
