package Test;
//inicialitzar una matriu 2D d'enters i sumar-ne tots els elements recorrent les files i columnes.
public class Matriu {
    public static void main(String[] args) {

        int[][] num = {{4, 8, 9}, {8, 7, 4}};
        int suma = 0;

        for (int[] ints : num) {
            for (int j = 0; j < ints.length; j++) {
                suma += ints[j];
            }
        }
        System.out.println("Suma dels elements de la matriu: " + suma);
        
    }
}
