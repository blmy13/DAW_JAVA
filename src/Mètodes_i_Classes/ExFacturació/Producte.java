package Mètodes_i_Classes.ExFacturació;

public class Producte {

    private String id, nom;
    private double preu;
    private double stock;

    public Producte(String id, String nom, double preu, double stock) {

        this.id = id;
        this.nom = nom;
        this.preu = 0.0;
        this.stock = 0;

    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public double getStock() {
        return stock;
    }

}
