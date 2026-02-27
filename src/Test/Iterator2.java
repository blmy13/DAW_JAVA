package Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator2 {
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();

        noms.add("Sassafras");
        noms.add("Caetano Veloso");
        noms.add("Saint Etienne");
        noms.add("Nav");

        Iterator<String> it = noms.iterator();

        while (it.hasNext()) {
            if (it.next().length() < 4) {
                it.remove();
            }
        }
    }
}
