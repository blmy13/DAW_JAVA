package Random.PràcticaExam;

import java.util.*;

public class Colec2 {

    public static void main(String[] args) {
        Map<String, Double> notes = new HashMap<>(Map.of("Marc", 8.5, "Laia", 4.0, "Pau", 9.0));

        //Afegir un punt Laia
        notes.put("Laia", 5.0);

        //Recorregut EntrySet
        for (Map.Entry<String, Double> alumne : notes.entrySet()) {
            String nom = alumne.getKey();
            Double nota = alumne.getValue();

            System.out.println(nom + " té un " + nota);
        }

        //Llista a partir de les claus d'un HashMap
        List<String> claus2 = List.copyOf(notes.keySet());
    }
}
