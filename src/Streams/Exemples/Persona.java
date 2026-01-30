package Streams.Exemples;

enum Sexe {
    HOME, DONA
}

public class Persona {

    private String nom;
    private String cognom;
    private String email;
    private Sexe sexe;
    private int edat;

    public Persona(String nom, String cognom, String email, Sexe sexe, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.email = email;
        this.sexe = sexe;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", cognom=" + cognom + ", email=" + email + ", sexe=" + sexe + ", edat=" + edat + '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
}
