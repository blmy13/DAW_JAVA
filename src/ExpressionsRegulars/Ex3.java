package ExpressionsRegulars;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introdueix número de telèfon");
        String num = sc.nextLine();
        System.out.println((num.matches("(\\+34 )?6\\d{2} \\d{3} \\d{3}") ? "Número vàlid" : "Número no vàlid"));
    }
}
