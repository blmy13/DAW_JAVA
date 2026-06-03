package DB.Hospital;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pacient implements Serializable {
    @Id
    private String dni;
    private String nom;
    private int edat;

    @ManyToMany
    private List<Metge> metges = new ArrayList<>();

    public Pacient() {
    }

    public Pacient(String dni, String nom, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public List<Metge> getMetges() {
        return metges;
    }

    public void setMetges(List<Metge> metges) {
        this.metges = metges;
    }

    @Override
    public String toString() {
        return String.format("<< PACIENT %-9s | NOM: %-20s | EDAT: %3d anys >>",
                this.dni, this.nom, this.edat);
    }
}
