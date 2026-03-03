package Test.Exam2;

import java.util.*;

class Categoria {

    private final String nom;
    private final int puntuacio;

    public Categoria(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    public String getNom() {
        return nom;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    @Override
    public String toString() {
        return nom + ": " + puntuacio;
    }
}

class Videojoc {

    private final String titol;
    private final int id;
    private Categoria[] categories = new Categoria[3];

    public Videojoc(String titol, int id) {
        this.titol = titol;
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public int getId() {
        return id;
    }

    public Categoria[] getCategories() {
        return categories;
    }

    public void setCategories(Categoria[] categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Títol: %-15s | %s, %s, %s",
                id, titol, categories[0], categories[1], categories[2]);
    }
}

public class ExamenVideojocs {

    public static void main(String[] args) {
        List<Videojoc> cataleg = creaLlistaVideojocs();
        System.out.println("=== Llista inicial de Videojocs ===");
        cataleg.forEach(System.out::println);
        System.out.println("===================================\n");

        // Aquí anirem cridant els mètodes a mesura que els resolguis
        // Per l'Exercici 0, farem servir aquest array de prova:
        String[] jocsProva = {"Zelda", "Assassin's Creed", "Mario Kart", "Halo", "GTA V"};
        // ex0(jocsProva);
        System.out.println(Arrays.toString(ex0(jocsProva)));
        ex6(cataleg, v -> v.getTitol().startsWith("Z"));
        

    }

    // ====== Generació de dades del control ======
    public static List<Videojoc> creaLlistaVideojocs() {
        final String[] titols = {"Zelda", "Mario", "Elden Ring", "Halo", "Portal", "Tetris", "FIFA", "Minecraft", "Doom", "Hades"};
        final int[] ids = {101, 204, 305, 408, 510, 612, 715, 820, 925, 999};

        Random r = new Random();
        List<Videojoc> llista = new ArrayList<>(titols.length);

        for (int i = 0; i < titols.length; i++) {
            Videojoc v = new Videojoc(titols[i], ids[i]);
            v.setCategories(new Categoria[]{
                new Categoria("Gràfics", r.nextInt(101)),
                new Categoria("Jugabilitat", r.nextInt(101)),
                new Categoria("So", r.nextInt(101))
            });
            llista.add(v);
        }
        return llista;
    }

    // ====== Exercicis (Per completar) ======
    public static String[] ex0(String[] titols) {
        String[] videojocs = Arrays.copyOf(titols, titols.length);
        for (int i = 0; i < titols.length; i++) {
            videojocs[i] = videojocs[i].replaceAll("[aA]", "X");
        }
        Arrays.sort(videojocs, Comparator.reverseOrder());
        return videojocs;
    }

    public static void ex1(List<Videojoc> cataleg) {
        // Implementa aquí l'Exercici 1
        cataleg.sort(Comparator.comparing((Videojoc p) -> p.getCategories()[0].getPuntuacio()).thenComparing(Videojoc::getId).reversed());
    }

    public static void ex2(List<Videojoc> cataleg) {
        // Implementa aquí l'Exercici 2
        cataleg.removeIf(p -> p.getCategories()[1].getPuntuacio() < 50);
    }

    public static List<Integer> ex3(List<Videojoc> cataleg) {
        // Implementa aquí l'Exercici 3
        List<Integer> so = cataleg.stream()
                .map(p -> p.getCategories()[2].getPuntuacio())
                .map(r -> r > 50 ? r - 5 : r)
                .toList();
        return so;
    }

    public static void ex4(List<Videojoc> cataleg) {
        // Implementa aquí l'Exercici 4
        Map<Integer, Videojoc> jocs = new HashMap<>();
        for (Videojoc v : cataleg) {
            jocs.put(v.getId(), v);
        }
        jocs.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }

    public static void ex5(List<Videojoc> cataleg) {
        // Implementa aquí l'Exercici 5
        Set<Videojoc> jocs = new TreeSet<>(Comparator.comparingInt((Videojoc p) -> p.getTitol().length()).thenComparing(Videojoc::getId));
        jocs.addAll(cataleg);
        jocs.stream()
                .filter(p -> p.getCategories()[0].getPuntuacio() >= 75 && p.getCategories()[1].getPuntuacio() >= 75 && p.getCategories()[2].getPuntuacio() >= 75)
                .forEach(System.out::println);
    }

    // Per a l'Exercici 6, recorda crear la interfície Filtre<T> i el mètode ex6
    public static void ex6(List<Videojoc> cataleg, Filtre<Videojoc> filtre) {
        for (Videojoc v : cataleg) {
            if (filtre.aplicar(v)) {
                System.out.println("Títol: " + v.getTitol());
            }
        }

    }

    @FunctionalInterface
    interface Filtre<T> {

        boolean aplicar(T t);
    }
}
