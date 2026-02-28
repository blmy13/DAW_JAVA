package Test.Exam;

import java.util.*;

public class CreaJugadors {
    public static void main(String[] args) {
        List<Jugador> equip = creaLlistaEquips();
        System.out.println("=== Llista inicial ===");
        equip.forEach(System.out::println);

        //Implementació Interfície
        ex6(equip, p -> p.getEstadistiques()[0].getValor());

    }

    // ====== Generació de dades del control ======
    public static List<Jugador> creaLlistaEquips() {
        final String[] noms = {"Laia", "Jordi", "Núria", "Pau", "Aina", "Marc", "Ivet", "Pol", "Berta", "Oriol"};
        final int[] dorsals = {4, 7, 9, 11, 13, 18, 21, 23, 30, 34};

        Random r = new Random();
        List<Jugador> equip = new ArrayList<>(noms.length);

        for (int i = 0; i < noms.length; i++) {
            Jugador j = new Jugador(noms[i], dorsals[i]);
            j.setEstadistiques(new Estadistica[]{
                    new Estadistica("Punts", r.nextInt(11)),
                    new Estadistica("Assistències", r.nextInt(11)),
                    new Estadistica("Rebots", r.nextInt(11))
            });
            equip.add(j);
        }
        return equip;
    }

    // ====== Exercicis ======

    public static String[] ex0(String[] paraules) {
        String[] noms = Arrays.copyOf(paraules, paraules.length);
        String invers = "";
        for (int i = 0; i < noms.length; i++) {
            invers = "";
            for (int j = noms[i].length() - 1; j >= 0; j--) {
                invers = invers + noms[i].charAt(j);
            }
            noms[i] = invers;
        }
        Arrays.sort(noms, Comparator.comparing(String::length));

        return noms;
    }

    public static void ex1(List<Jugador> equip) {
        equip.sort(Comparator.comparingInt((Jugador p) -> p.getEstadistiques()[0].getValor()).reversed().thenComparing(Jugador::getDorsal));
    }

    public static void ex2(List<Jugador> equip) {
        equip.removeIf(p -> p.getEstadistiques()[1].getValor() < 5);
    }

    public static List<Integer> ex3(List<Jugador> equip) {
        return equip.stream()
                .map(p -> p.getEstadistiques()[2].getValor())
                .map(r -> r < 10 ? r + 1 : r)
                .toList();
    }

    public static void ex4(List<Jugador> equip) {
        Map<Integer, Jugador> jugadors = new HashMap<>();
        for (Jugador j : equip) {
            jugadors.put(j.getDorsal(), j);
        }
        jugadors.keySet().stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void ex5(List<Jugador> equip) {
        Set<Jugador> jugadors = new TreeSet<>(Comparator.comparing(Jugador::getNom).thenComparing(Jugador::getDorsal));
        jugadors.addAll(equip);

        jugadors.stream()
                .filter(p -> p.getEstadistiques()[0].getValor() >= 5 && p.getEstadistiques()[1].getValor() >= 5 && p.getEstadistiques()[2].getValor() >= 5)
                .forEach(System.out::println);
    }

    public static void ex6(List<Jugador> equip, Prova<Jugador> prova) {
        for (Jugador j : equip) {
            System.out.println(j.getNom() + " - Puntuació: " + prova.aplicar(j));
        }
    }

    @FunctionalInterface
    interface Prova<T>{
        int aplicar(T gen);
    }
}
