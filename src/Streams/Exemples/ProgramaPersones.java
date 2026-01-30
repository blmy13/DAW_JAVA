package Streams.Exemples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProgramaPersones {

    public static void main(String[] args) {
        List<Persona> persones = new ArrayList();
        persones.add(new Persona("Alice", "Brown", "alice@gmail.com",
                Sexe.DONA, 26));
        persones.add(new Persona("Bob", "Young", "bob@gmail.com",
                Sexe.HOME, 12));
        persones.add(new Persona("Carol", "Hill", "carol@gmail.com",
                Sexe.DONA, 23));
        persones.add(new Persona("David", "Green", "david@gmail.com",
                Sexe.HOME, 39));
        persones.add(new Persona("Eric", "Young", "eric@gmail.com",
                Sexe.HOME, 26));
        persones.add(new Persona("Frank", "Thompson", "frank@gmail.com",
                Sexe.HOME, 33));
        persones.add(new Persona("Gibb", "Brown", "gibb@gmail.com",
                Sexe.HOME, 27));
        persones.add(new Persona("Henry", "Baker", "henry@gmail.com",
                Sexe.HOME, 30));
        persones.add(new Persona("Isabell", "Hill", "isabell@gmail.com",
                Sexe.DONA, 22));
        persones.add(new Persona("Jane", "Canela", "jane@gmail.com",
                Sexe.DONA, 24));
        
        //OPERACIONS INTERMITGES
        
        
        persones.stream() // imprimeix persones
                .sorted(Comparator.comparingInt(Persona::getEdat))
                .forEach(s -> System.out.println(s + " "));

        persones.stream() //imprimeix edats
                .mapToInt(p -> p.getEdat())
                .distinct() // no repetits
                .sorted()
                .limit(4) //nomes mostra 4
                .forEach(s -> System.out.println(s + " "));

        persones.stream() //imprimeix els dos últims, se salta els anteriors
                .sorted(Comparator.comparingInt(Persona::getEdat))
                .mapToInt(p -> p.getEdat())
                .skip(persones.size() - 2)
                .forEach(s -> System.out.println(s + " "));

        persones.stream() //filtra els que compleixen la condició
                .filter(e -> e.getSexe() == Sexe.HOME)
                .forEach(s -> System.out.println(s + " "));
        
        //OPERACIONS TERMINALS
        
        boolean totHOmes = persones.stream().allMatch(p -> p.getSexe().equals(Sexe.HOME)); //comprova si tots son homes. També existeix noneMatch()
        boolean gmail = persones.stream().allMatch(p -> p.getEmail().endsWith("@gmail.com")); //si tots tenen gmail
        List<String> llistaCorreus = persones.stream().map(p -> p.getEmail()).collect(Collectors.toList()); //acumula correus en una llista
        
        persones.stream() //torna n elements
                .map(p -> p.getSexe().equals(Sexe.HOME))
                .count();
        
        //OPERACIONS OPCIONALS
        
        Optional<Persona> min = persones.stream() //el mateix amb max
                .filter(p -> p.getSexe().equals(Sexe.DONA))
                .min(Comparator.comparingInt(Persona::getEdat));
        if (min.isPresent()) {
            Persona joveneta = min.get();
        }

    }

}
