package Random.PràcticaExam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map1 {
    public static void main(String[] args) {
        List<String> fruites = List.of("poma", "pera", "poma", "taronja", "pera", "poma");
        Map<String, Integer> recompte = new HashMap<>();

        for (String f : fruites) {
            // 1. Si la fruita ja està al map, suma-li 1 al valor actual.
            // 2. Si no hi és, afegeix-la amb valor 1.
            int quantitatActual = recompte.getOrDefault(f, 0);
            recompte.put(f, quantitatActual + 1);
        }
    }
}
