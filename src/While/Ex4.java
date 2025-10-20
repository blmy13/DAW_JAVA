package While;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        int multiple = 0;

        while (num != -1 && num / 5 != 0) {
            num = multiple;
            multiple++;

        }
        System.out.println("El número múltiple de 5 és: " + multiple);
    }

}
