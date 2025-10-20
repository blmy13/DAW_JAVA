package While;

//Programa que vagi llegint notes (per finalitzar -1) i indiqui si hi ha
//com a mínim tres suspesos.

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        int numSuspes = 0;
        System.out.println("Introdueix una nota:");
        double nota = tec.nextDouble();

        while (nota != -1){
            if (nota < 5){
                numSuspes++;
            }
            System.out.println("Introdueix la següent nota:");
            nota = tec.nextDouble();
        }
        System.out.println(numSuspes >= 3 ? "El nombre de suspesos és: " + numSuspes : "No hi ha més de tres suspesos. N'hi ha: " + numSuspes);
    }
}
