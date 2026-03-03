package Test.Exam3;

import java.util.*;
import java.util.stream.Collectors;

class Llibre {
    private final String titol;
    private final String genere;
    private final int anyPublicacio;
    private final double preu;

    public Llibre(String titol, String genere, int anyPublicacio, double preu) {
        this.titol = titol;
        this.genere = genere;
        this.anyPublicacio = anyPublicacio;
        this.preu = preu;
    }

    public String getTitol() {
        return titol;
    }

    public String getGenere() {
        return genere;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return String.format("Títol: %-18s | Gènere: %-10s | Any: %d | Preu: %5.2f€",
                titol, genere, anyPublicacio, preu);
    }
}

public class ExamenLlibres {
    public static void main(String[] args) {
        List<Llibre> cataleg = creaLlistaLlibres();
        System.out.println("=== Llista inicial de Llibres ===");
        cataleg.forEach(System.out::println);
        System.out.println("=================================\n");

        String[] llibresProva = {"Dune", "It", "Fundació", "1984", "El Hobbit", "Neuromant"};

        // --- PROVES DELS EXERCICIS (Descomenta per provar) ---

        // System.out.println("--- EXERCICI 0 ---");
        // System.out.println(Arrays.toString(ex0(llibresProva)));

        // System.out.println("\n--- EXERCICI 1 ---");
        // ex1(cataleg);
        // cataleg.forEach(System.out::println);

        // System.out.println("\n--- EXERCICI 2 ---");
        // ex2(cataleg);
        // cataleg.forEach(System.out::println);

        // System.out.println("\n--- EXERCICI 3 ---");
        // List<String> formatats = ex3(cataleg);
        // formatats.forEach(System.out::println);

        // System.out.println("\n--- EXERCICI 4 ---");
        // ex4(cataleg);

        // System.out.println("\n--- EXERCICI 5 ---");
        // ex5(cataleg);

        // System.out.println("\n--- EXERCICI 6 ---");
        int totalCaros = ex6(cataleg, p -> p.getPreu() > 20);
        System.out.println("Total de llibres de més de 20€: " + totalCaros);
    }

    // ====== Generació de dades ======
    public static List<Llibre> creaLlistaLlibres() {
        return new ArrayList<>(Arrays.asList(
                new Llibre("El Quixot", "Clàssic", 1605, 15.50),
                new Llibre("Dune", "Ficció", 1965, 22.90),
                new Llibre("Dràcula", "Terror", 1897, 12.00),
                new Llibre("Fundació", "Ficció", 1951, 19.99),
                new Llibre("It", "Terror", 1986, 25.00),
                new Llibre("1984", "Ficció", 1949, 14.50),
                new Llibre("El Marcià", "Ficció", 2011, 21.00),
                new Llibre("Pàtria", "Drama", 2016, 18.00),
                new Llibre("Sapiens", "Història", 2011, 24.50),
                new Llibre("L'Odissea", "Clàssic", -800, 10.00)
        ));
    }

    // ====== Exercicis (Per completar) ======

    public static String[] ex0(String[] titols) {
        // TODO: Majúscules, més de 5 lletres, ordenats alfabèticament.

        return Arrays.stream(titols)
                .filter(t -> t.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);

    }

    public static void ex1(List<Llibre> cataleg) {
        // TODO: Ordenar per gènere, després preu, després any (descendent).
        cataleg.sort(
                Comparator.comparing(Llibre::getGenere)
                        .thenComparing(Llibre::getPreu)
                        .thenComparing(Comparator.comparingInt(Llibre::getAnyPublicacio).reversed())
        );
    }

    public static void ex2(List<Llibre> cataleg) {
        // TODO: Eliminar anteriors a 2000 i més barats de 15€.
        cataleg.removeIf(p -> p.getAnyPublicacio() < 2000 && p.getPreu() < 15);
    }

    public static List<String> ex3(List<Llibre> cataleg) {
        // TODO: Títol + Preu, només gènere "Ficció".
        return cataleg.stream()
                .filter(p -> p.getGenere().equals("Ficció"))
                .map(p -> p.getTitol() + " - " + p.getPreu() + "€")
                .collect(Collectors.toList());
    }

    public static void ex4(List<Llibre> cataleg) {
        // TODO: Map<String, Llibre>, imprimir llibres ordenats per títol alfabèticament.
        Map<String, Llibre> llibres = new HashMap<>();

        for (Llibre l : cataleg) {
            llibres.put(l.getTitol(), l);
        }
        llibres.values().stream()
                .sorted(Comparator.comparing(Llibre::getTitol))
                .forEach(System.out::println);
    }

    public static void ex5(List<Llibre> cataleg) {
        // TODO: TreeSet per preu descendent, imprimir els publicats >= 2010.
        Set<Llibre> llibres = new TreeSet<>(Comparator.comparing(Llibre::getPreu).reversed());
        llibres.addAll(cataleg);

        llibres.stream()
                .filter(p -> p.getAnyPublicacio() >= 2010)
                .forEach(System.out::println);
    }

    public static int ex6(List<Llibre> cataleg, Criteri<Llibre> criteri) {
        // TODO: Comptar quants llibres compleixen el criteri.
        int cont = 0;
        for (Llibre l : cataleg) {
            if (criteri.test(l)) {
                cont++;
            }
        }
        return cont;
    }

    // Interfície per a l'Exercici 6
    @FunctionalInterface
    interface Criteri<T> {
        boolean test(T t);
    }
}
