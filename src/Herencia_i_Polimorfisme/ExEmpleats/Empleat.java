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
    
    
    public double calcularSalari() {
        return 0.00;
    }
    
    public void mostrarInformacio() {
        System.out.print("ID: " + this.id + ", " + "Nom: " + this.nom + ", ");
    }
}
