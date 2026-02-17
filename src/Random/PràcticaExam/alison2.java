package Random.PràcticaExam;

import java.util.*;

public class alison2 {

    public static void main(String[] args) {
        List<String> fitxatges = List.of("Joan", "Anna", "Marc", "Joan", "Elena", "Anna", "Marc");

// 1. Crea un HashSet de Strings anomenat 'unics'.
        Set<String> unics = new HashSet<>(Set.copyOf(fitxatges));
        System.out.println(unics);

// 2. Afegeix tots els noms de la llista 'fitxatges' al Set.
// 3. Comprova si "Marc" ja és dins del Set.
        boolean esta = unics.contains("Marc");
        System.out.println(esta);
// 4. Imprimeix la mida del Set per saber quants treballadors hi ha sense repetir.
        System.out.println(unics.size());
    }
}
