package Reps.Negoci.Entitats;

import java.util.function.UnaryOperator;

public class Producte {
    private String nom;
    private double preu;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Producte(String nom, double preu) {
        if (nom == null || nom.isBlank()) {
            throw new Reps.Negoci.Persistència.Entitats.ProducteInvalidException("Error: el nom no pot estar buit");
        }
        if (preu < 0) {
            throw new Reps.Negoci.Persistència.Entitats.ProducteInvalidException("Error: El preu no pot ser un valor negatiu");
        }
        this.nom = nom;
        this.preu = preu;
    }
    //principi OCP
    public double getPreuFinal(UnaryOperator<Double> estrategia) {
        return estrategia.apply(preu);
    }

    @Override
    public String toString() {
        return String.format("Producte: %-15s || Preu: %6.2f €", nom, preu);
    }
}
