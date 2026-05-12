package Reps.Botiga;

public class Espasa implements Venda {
    private String nom;
    private double preuBase;
    private int danyAtac;

    public Espasa(String nom, double preuBase, int danyAtac) {
        this.nom = nom;
        this.preuBase = preuBase;
        this.danyAtac = danyAtac;
    }

    @Override
    public double getPreu() {
        return this.preuBase;
    }

    @Override
    public String getNomArticle() {
        return this.nom + " fa: " + this.danyAtac + " de dany";
    }

    @Override
    public void aplicarDescompte(double percentatge) {
        double descompte = this.preuBase * (percentatge / 100.0);
        this.preuBase -= descompte;
    }
}
