package Reps.RPG.Arsenal;

public class Arma {
    private String nom;
    private double danyBase;

    public Arma(String nom, double danyBase) {

        if ((nom == null || nom.isBlank()) || (danyBase < 0 || danyBase > 100)) {
            throw new ArmaInvalidaException("Error al crear l'arma.");
        }
        this.nom = nom;
        this.danyBase = danyBase;
    }

    public String getNom() {
        return nom;
    }

    public double getDanyBase() {
        return danyBase;
    }
}
