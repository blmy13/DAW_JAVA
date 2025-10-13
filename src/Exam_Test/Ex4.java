package Exam_Test;

//Al introduïr un nombre per teclat el programa ha d'escriure el seu primer divisor!=num && 1.

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        int num;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número. ");
        num = tec.nextInt();

        if (num < 2) {
            System.out.println("El número ha de ser més gran o igual que 2 per tenir divisors diferents a 1 i ell mateix.");
            tec.close();
            return;
        }

        int primerDiv = -1;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                primerDiv = i;
                break;

            }
        }

        if (primerDiv != -1) {
            System.out.println("El primer divisor del número " + num + " és: " + primerDiv);
        } else {
            System.out.println("El número que has introduït és primer.");
        }
        tec.close();


    }
}
