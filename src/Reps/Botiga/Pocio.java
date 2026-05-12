package Reps.Botiga;

public class Pocio implements Venda {
    private String nom;
    private double preuBase;
    private int puntsCuracio;

    public Pocio(String nom, double preuBase, int puntsCuracio) {
        this.nom = nom;
        this.preuBase = preuBase;
        this.puntsCuracio = puntsCuracio;
    }


    @Override
    public double getPreu() {
        return this.preuBase;
    }

    @Override
    public String getNomArticle() {
        return this.nom + " (Cura: " + this.puntsCuracio + "HP";
    }

    @Override
    public void aplicarDescompte(double percentatge) {
        double descompte = this.preuBase * (percentatge / 100.0);
        this.preuBase -= descompte;
    }
}
