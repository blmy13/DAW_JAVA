package Genèrics.ExInventari;

public class Electrodomèstic implements Producte {
    
    private final String id;
    private final String nom;
    private final double preu;
    private final String marca;

    public Electrodomèstic(String id, String nom, double preu, String marca) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.marca = marca;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public double getPreu() {
        return preu;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Electrodomèstic: " + "ID: " + id + " || Nom: " + nom + " || Preu: " + preu + "€ || Marca: " + marca;
    }

}
