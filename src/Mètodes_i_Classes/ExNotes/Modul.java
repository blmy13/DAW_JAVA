package Mètodes_i_Classes.ExNotes;

public class Modul {
    
    private int codi, curs;
    private String nom;

    public Modul(int codi, String nom, int curs) {
        this.codi = codi;
        this.nom = nom;
        this.curs = curs;
    }

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public int getCurs() {
        return curs;
    }
    
    
    
}
