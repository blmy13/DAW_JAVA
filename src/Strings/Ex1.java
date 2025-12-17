/*
L‟última lletra del DNI pot calcular-se a partir del seus números. Per a això
només has de dividir el número per 23 i quedar-te amb la resta. Fes un programa
per calcular la lletra d‟un DNI.
 */
package Strings;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un DNI:");
        int dni = tec.nextInt();
        int num = dni % 23;

        String taula = "TRWAGMYFPDXBNJZSQVHLCKE";
        System.out.println("La lletra del teu DNI és : " + taula.charAt(num));

    }

}
