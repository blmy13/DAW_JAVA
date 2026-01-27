package ExAlumnes;

class Alumne {
    private final String nom;
    private final String cognoms;
    private final String nif;
    private final int edat;
    private final double nota;

    public Alumne(String nom, String cognoms, String nif, int edat, double nota) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.nif = nif;
        this.edat = edat;
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
