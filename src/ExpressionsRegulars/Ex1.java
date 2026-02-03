package ExpressionsRegulars;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean finalitzat = false;

        while (!finalitzat) {
            System.out.println("Introdueix codi postal");
            String codi = sc.nextLine();
            System.out.println((codi.matches("([0-4][0-9]|[5][0-2])\\d{3}") ? "Codi postal vàlid" : "Codi postal no vàlid"));
            if (codi.equals("1")) {
                finalitzat = true;
            }

        }

    }
}
