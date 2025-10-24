/*
Escriviu un programa que mostri tots els números de tres dígits que siguin iguals a
la suma dels cubs dels seus dígits. Solució: 153, 370, 371, 407
 */
package While;

public class Extra11 {

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

            if (num == (d3 * d3 * d3) + (d2 * d2 * d2) + (d1 * d1 * d1)) 
                System.out.println(num);

            num++;

            }
        }

    }
