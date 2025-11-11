package Mètodes_i_Classes.ExFacturació;

public class Client {

    private String nom, nif, telefon;

    public Client(String nom, String nif, String telefon) {

        this.nom = nom;
        this.nif = nif;
        this.telefon = telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNom() {
        return nom;
    }

    public String getNif() {
        return nif;
    }

    public String getTelefon() {
        return telefon;
    }

}
