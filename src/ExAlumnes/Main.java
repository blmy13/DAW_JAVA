package ExAlumnes;

class Alumne {
    private  String nom;
    private  String cognoms;
    private  String nif;
    private  int edat;
    private  double nota;

    public Alumne(String nom, String cognoms, String nif, int edat, double nota) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.nif = nif;
        this.edat = edat;
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
     
    
}

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("=== MENÚ ====");
        System.out.println("Introdueix el nom de l'alumne");
        System.out.println("Introdueix el cognom del l'alumne");
        
    }
    
}
