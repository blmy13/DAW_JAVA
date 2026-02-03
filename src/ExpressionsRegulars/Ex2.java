package ExpressionsRegulars;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix usuari");
        String user = sc.nextLine();
        System.out.println((user.matches("([A-Z])\\w{2,14}") ? "Usuari vàlid" : "Usuari no vàlid")); 
    }
}
