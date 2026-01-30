package Streams.Exercicis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramaAlumnes {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList();
        vehicles.add(new Vehicle("1111AAA", Model.BMW, 10000));
        vehicles.add(new Vehicle("2222BBB", Model.AUDI, 20000));
        vehicles.add(new Vehicle("3333CCC", Model.OPEL, 30000));
        vehicles.add(new Vehicle("4444DDD", Model.BMW, 100000));
        vehicles.add(new Vehicle("5555EEE", Model.AUDI, 200000));
        vehicles.add(new Vehicle("6666FFF", Model.OPEL, 300000));
        vehicles.add(new Vehicle("7777GGG", Model.CITROEN, 0));

        /*
         Crea una llista d'enters que tingui el doble dels quilòmetres 
         de cada cotxe i imprimeix el resultat. 
         A continuació crea una altre llista que 
         contingui els quilòmetres i mostra el resultat
         */
        List<Integer> km = vehicles.stream()
                .map(p -> p.getQuilometres() * 2)
                .collect(Collectors.toList());

        /*
        Crea una llista de Vehicle que només contingui els AUDI i mostra el 
        resultat
         */
        List<Vehicle> audi = vehicles.stream()
                .filter(v -> v.getModel().equals(Model.AUDI))
                .collect(Collectors.toList());
        System.out.println(audi);

        /*
         Crea una llista amb els vehicles ordenats per quilòmetres
         Mostra el resultat
         */
        List<Vehicle> vehicles1 = vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getQuilometres))
                .collect(Collectors.toList());
        System.out.println(vehicles1);

        /*
        Mostra el model dels cotxes sense repeticio. Has de crear una llista
        de models
         */
        List<Model> models = vehicles.stream()
                .map(p -> p.getModel())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(models);

        /*
        Crea una llista de 5 vehicles i mostra-la
         */
        List<Vehicle> cinc = vehicles.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(cinc);
        /*
        Agrupa els vehicles per model en un Map i mostra el resultat
         */
        Map<Model, List<Vehicle>> mapaModel = vehicles.stream()
                .collect(Collectors.groupingBy(p -> p.getModel()));
        System.out.println(mapaModel);
    }
}
