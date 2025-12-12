package Taules_i_Matrius;

/*
Fes un programa que, donat una taula de 10 enters ( introduïts per codi),
generi un diagrama de barres que representi el seus valors. Les barres aniran
d’esquerra a dreta i estaran formades per asteriscos. Per exemple, si els tres
primers elements de la taula són 2-3-4, la part corresponent del diagrama de
barres serà:

        **
        ***
        ****
*/

public class Ex4 {

    public static void main(String[] args) {

        int[] taula = {4, 8, 12, 16, 20, 24, 28, 32};

        for (int k : taula) {
            for (int j = 0; j < k; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
