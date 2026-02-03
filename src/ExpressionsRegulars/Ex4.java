package ExpressionsRegulars;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introdueix la matrícula");
        String matricula = sc.nextLine();
        System.out.println((matricula.matches("\\d{4}[A-Z]{3}") ? "Matrícula vàlida" : "Matrícula no vàlida"));
    }
}
