package Llistes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex4 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("dhg", "djaghkjah", "djjdj", "a", "dg", "fff"));
        Iterator<String> it = strings.iterator();
        
        while (it.hasNext()) {
            String cadena = it.next();
            if (cadena.length() > 4) {
                it.remove();
            }
        }
        
        strings.removeIf(cadena -> cadena.length() < 4); 
    }

}
