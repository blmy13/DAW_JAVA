package Taules;

/*
Fes un programa que llegeixi les notes obtingudes pels alumnes d’una
assignatura. La introducció de dades finalitzarà amb la introducció de -1. El
programa a continuació ha de treure per pantalla la nota mitjana del grup.
Considereu, utilitzant una constant, que el nombre màxim d’alumnes és 30.
*/
import java.util.Scanner;

public class Ex6 {

    private static final int MAX_ALUMNES = 30;

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        int[] notes = new int[MAX_ALUMNES];
        int suma = 0;
        double mitja = 0.0;

        System.out.println("Introdueix la primera nota: ");
        notes[0] = tec.nextInt();


    }
}
