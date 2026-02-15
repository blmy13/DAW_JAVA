package Random.PràcticaExam;

import java.util.*;

public class Colec1 {
    public static void main(String[] args) {

        //Afegir element índex concret
        List<String> gent = new ArrayList<>(List.of("Anna", "Pere"));
        gent.add(1, "Manolo");

        //Duplicats HashSet (no es poden afegir elements duplicats)
        Set<Integer> num = new HashSet<>(Set.of(1, 2));

        num.add(1);
        num.add(1);
        System.out.println(num.size());

        //HashMap (mapes poden gestionar claus inexisents amb valors per defecte)
        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("Pomes", 10);
        System.out.println(stock.getOrDefault("Peres", 9));
    }
}
