package Herencia_i_Polimorfisme.ExEmpleats;

import java.util.ArrayList;

public class Projecte {
    
    private final String nom;
    ArrayList<Empleat> empleats = new ArrayList<>();

    public Projecte(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Empleat> getEmpleats() {
        return empleats;
    }
    
    public void afegirEmpleat(Empleat empleat) {
        empleats.add(empleat);
    }
    
    public void mostrarEmpleat() {
        for (Empleat e : empleats) {
            //mostrar atributs usuaris
        }
        
        
    }
    
}
