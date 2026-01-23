package Llistes;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> nombres = new ArrayList<>(List.of(2, 4, 5, 8, 10, 15));
        System.out.println("Llista inicial: " + nombres);

        nombres.replaceAll(n -> n * 3);
        System.out.println("Llista triplicada: " + nombres);

        nombres.removeIf(n -> n >= 10 && n <= 20);
        System.out.println("Llista final: " + nombres);
    }
    
}
