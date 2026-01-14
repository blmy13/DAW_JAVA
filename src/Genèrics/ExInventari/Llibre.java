package Genèrics.ExInventari;


public class Llibre implements Producte {
    
    private final String id;
    private final String nom;
    private final double preu;
    private final String autor;

    public Llibre(String id, String nom, double preu, String autor) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Llibre{" + "id=" + id + ", nom=" + nom + ", preu=" + preu + ", autor=" + autor + '}';
    }
    
    
    
    
}
