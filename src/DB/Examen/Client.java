package DB.Examen;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    private String dni;
    private String nom;
    private int edat;
    private String correu;

    @ManyToMany
    private List<Activitat> activitats = new ArrayList<>();

    public Client() {
    }

    public Client(String dni, String nom, int edat, String correu) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
        this.correu = correu;
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

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public List<Activitat> getActivitats() {
        return activitats;
    }

    public void afegirActivitat(Activitat a) {
        activitats.add(a);
        a.getClients().add(this);
    }

    @Override
    public String toString() {
        return String.format("CLIENT: %-12s | NOM: %-15s | EDAT: %-3d | CORREU: %-20s",
                this.dni, this.nom, this.edat, this.correu);
    }
}
