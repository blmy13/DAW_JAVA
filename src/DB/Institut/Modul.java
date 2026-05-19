package DB.Institut;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Modul {

    @Id
    private int numeroM;
    private String nom;
    private int durada;

    public Modul(int numeroM, String nom, int durada) {
        this.numeroM = numeroM;
        this.nom = nom;
        this.durada = durada;
    }

    public int getNumeroM() {
        return numeroM;
    }

    public void setNumeroM(int numeroM) {
        this.numeroM = numeroM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    @Override
    public String toString() {
        return String.format(" << MÒDUL: %-8s | CODI: %-6d | DURADA: %-3d >> %n", this.nom, this.numeroM, this.durada);
    }

}
