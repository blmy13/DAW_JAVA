/*
Trobar i mostrar tots els números de quatre xifres que compleixen la condició de
què la suma de les xifres en posició senar és igual a les xifres en posició parell. Per
exemple : 8217
 */
package While;

public class Extra1 {

    public static void main(String[] args) {

        int num = 1000;
        int num2;
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0;

        while (num < 10000) {

            d4 = num % 10;
            d3 = (num / 10) % 10;
            d2 = (num / 100) % 10;
            d1 = num / 1000;

            int sumaParell = d1 + d3;
            int sumaSenar = d2 + d4;

            if (sumaParell == sumaSenar) {
                System.out.println("En el número: " + num + " es compleix la condició.");
            }
            num++;
        }
    }
}
