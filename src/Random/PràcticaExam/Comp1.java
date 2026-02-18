package Random.PràcticaExam;

import java.util.*;

public class Comp1 {

    static class Producte {
        private final String nom;
        private final double preu;

        public Producte(String nom, double preu) {
            this.nom = nom;
            this.preu = preu;
        }

        public String getNom() {
            return nom;
        }

        public double getPreu() {
            return preu;
        }

        @Override
        public String toString() {
            return "Producte{" +
                    "nom='" + nom + '\'' +
                    ", preu=" + preu +
                    '}';
        }
    }
    @FunctionalInterface
    interface Descomptable {
        double aplicar(double preu);
    }

    @FunctionalInterface
    interface Validador {
        boolean valida(Producte p);
    }

    public static void main(String[] args) {
        List<Producte> productes = new ArrayList<>(List.of(
                new Producte("iPhone", 899.66),
                new Producte("Manolo", 13.66),
                new Producte("Taula", 53.55)
        ));

        Comparator<Producte> criteri = Comparator.comparingDouble(Producte::getPreu).thenComparing(Producte::getNom);
        productes.sort(criteri);
        System.out.println(productes);

        Descomptable desc20 = (preu) -> preu * 0.8;

        for (Producte p : productes) {
            double preuNou = desc20.aplicar(p.getPreu());
            System.out.println("El nouu preu de " + p.getNom() + " és " + preuNou);
        }

        Validador v = p -> p.getPreu() > 50;

        for (Producte p : productes) {
            if (v.valida(p)) {
                System.out.println("ADMÈS: " + p.getNom());
            }
        }
    }
}