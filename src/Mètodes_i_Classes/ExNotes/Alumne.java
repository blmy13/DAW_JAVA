package Mètodes_i_Classes.ExNotes;

public class Alumne {
    
    private String dni, nom;
    private int edat;

    public Alumne(String dni, String nom, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
    
    
    
}
