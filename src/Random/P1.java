package Random;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix la mida del diamant.");
        int mida = tec.nextInt();
        System.out.println("Introdueix el número de nivells");
        int nivell = tec.nextInt();
        
        //NIVELLS   
        for (int l = 1; l <= nivell; l++) {
            for (int h = 1; h < nivell; h++) {

                //FIGURA PART SUPERIOR
                for (int i = 1; i <= mida; i++) {
                    for (int j = 1; j <= mida - i; j++) {
                        System.out.print(" ");
                    }
                    int ampladaFila = 2 * i - 1;
                    for (int k = 1; k <= ampladaFila; k++) {
                        if (k == 1 || k == ampladaFila) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                //FIGURA PART INFERIOR
                for (int i = mida - 1; i >= 1; i--) {
                    for (int j = 1; j <= mida - i; j++) {
                        System.out.print(" ");
                    }
                    int ampladaFila = 2 * i - 1;
                    for (int k = 1; k <= ampladaFila; k++) {
                        if (k == 1 || k == ampladaFila) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
