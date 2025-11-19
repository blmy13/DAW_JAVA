package Herencia_i_Polimorfisme.ExEmpleats;

public class Empleat {
    
    private final String nom, id;

    public Empleat(String nom, String id) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getId() {
        return id;
    }
    
    
    public double calcularSalari(Empleat empleat) {
        double salari = 0.00;
        return salari;
    }
    
    public void mostrarEmpleat(Empleat empleat) {
        
    }
}
