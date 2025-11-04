package Random;

import java.util.Scanner;

public class Mètode1 {

    public static int[] diesMes(int x, int y, int z, int p) {

        boolean bisext;
        int diesMes;

        while (p > 0) {
            bisext = ((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0);
            switch (x) {
                case 4, 6, 9, 11 -> diesMes = 30;
                case 2 -> diesMes = bisext ? 29 : 28;
                default -> diesMes = 31;
            }
            z++;
            p--;
            if (z > diesMes) {
                z = 1;
                x++;
            }
                if (x > 12) {
                    x = 1;
                    y++;
                }
        }
        int[] dataFinal = {z, x, y};
        return dataFinal;
    }

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix el dia actual: ");
        int dia = tec.nextInt();
        System.out.println("Introdueix el mes actual: ");
        int mes = tec.nextInt();
        System.out.println("Introdueix l'any actual: ");
        int any = tec.nextInt();
        System.out.println("Introdueix quants dies vols afegir a la data actual: ");
        int diesPlus = tec.nextInt();

        if (dia > 31 || dia < 1 || mes > 12 || mes < 1) {
            System.out.println("Data no vàlida.");
        }

        int[] dataFinal = diesMes(mes, any, dia, diesPlus);
        int diaF = dataFinal[0];
        int mesF = dataFinal[1];
        int anyF = dataFinal[2];

        System.out.println("La data final és: " + diaF + "/" + mesF + "/" + anyF);
    }
}
