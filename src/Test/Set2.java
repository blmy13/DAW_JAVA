package Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Set2 {
    public static void main(String[] args) {
        List<String> noms = List.of("Geese", "Whitearmor", "Noé", "Ecco2k", "Ecco2k");

        Set<String> nomsNoDup = new HashSet<>(noms);
        System.out.println("Tamanys de la llista: " + noms.size());
        System.out.println("Tamany del HashSet: " + nomsNoDup.size());//1 menys, Sets no admeten dupes
    }
}
