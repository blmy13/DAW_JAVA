package Random.PràcticaExam;

import java.util.*;

public class Iterator1 {
    public static void main(String[] args) {
        List<Integer> punts = new ArrayList<>(List.of(10, -5, 20, -1, 30));
        Iterator<Integer> it = punts.iterator();
        while (it.hasNext()) {
            if (it.next() < 0) {
                it.remove();
            }
        }
        System.out.println(punts);
        //punts.removeIf(p -> p < 0);
        //System.out.println(punts);
    }
}
