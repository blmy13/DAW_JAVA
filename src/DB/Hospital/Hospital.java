package DB.Hospital;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String ciutat;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST)
    private List<Metge> metges = new ArrayList<>();

    public Hospital() {
    }

    public Hospital(String ciutat, String nom) {
        this.ciutat = ciutat;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public List<Metge> getMetges() {
        return metges;
    }

    public void setMetges(List<Metge> metges) {
        this.metges = metges;
    }
    public void afegirMetge(Metge m) {
        metges.add(m);
        m.setHospital(this);
    }

    @Override
    public String toString() {
        return String.format("<< HOSPITAL %-3d | NOM: %-25s | CIUTAT: %-15s >>",
                this.id, this.nom, this.ciutat);
    }
}
