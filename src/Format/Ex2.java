package Format;

class Producte {

    private final String nom;
    private final double preu;
    private final int unitats;
    private double total;

    public Producte(String nom, double preu, int unitats) {
        this.nom = nom;
        this.preu = preu;
        this.unitats = unitats;
        total = preu * unitats;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public int getUnitats() {
        return unitats;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return String.format("%-10s %20s %15s %15s", nom, preu, unitats, total );
    }
}
public class Ex2 {
    public static void main(String[] args) {

        Producte p1 = new Producte("Ordinador", 1200.50, 10);
        Producte p2 = new Producte("Tauleta", 350.75, 25);
        Producte p3 = new Producte("Telèfon", 999.99, 15);

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %20s %15s %15s%n", "Producte", "Preu Unitari", "Unitats", "Total");
        System.out.println("---------------------------------------------------------------");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-42s %20.2f", "TOTAL VENUT:", p1.getTotal() + p2.getTotal() + p3.getTotal());

    }
}
