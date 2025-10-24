/*
Escriviu un programa que mostri tots els números de tres xifres que compleixen que
cada una de les xifres és més gran que les que té més a l’esquerra. Per exemple :
123, 248,....
 */
package While;

public class Extra10 {

    public static void main(String[] args) {

        int num = 100;
        int aux = 0;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;

        while (num < 1000) {

            aux = num;

            d1 = aux / 100;
            d2 = (aux / 10) % 10;
            d3 = aux % 10;

            if ((d1 < d2) && d2 < d3) {
                System.out.println(num);
            }
            num++;
        }
    }

}
