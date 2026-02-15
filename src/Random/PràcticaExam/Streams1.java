package Random.PràcticaExam;

import java.util.*;
import java.util.stream.Collectors;

public class Streams1 {
    public static void main(String[] args) {
        List<String> gent = new ArrayList<>(List.of("Anna", "Pere", "Manolo", "Andreu"));


        //Comencen per A
        List<String> aInicial = gent.stream()
                .filter(x -> x.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(aInicial);

        //Llista amb longitud de cada nom
        List<Integer> longitud = gent.stream()
                .map(String::length)
                .toList();
        System.out.println(longitud);

        //Ordenar invers alfabet
        List<String> alfabet = gent.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(alfabet);

        //Comprovar si algú es diu Pere
        boolean match = gent.stream().anyMatch(x -> x.equals("Pere"));
        System.out.println(match);
    }
}
