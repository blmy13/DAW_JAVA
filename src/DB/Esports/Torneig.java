package DB.Esports;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Torneig implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String nom;
    private double premi;

    @ManyToMany
    private List<Equip> equips = new ArrayList<>();//propietari(m auxiliar)

    public Torneig() {
    }

    public Torneig(String nom, double premi) {
        this.nom = nom;
        this.premi = premi;
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

    public double getPremi() {
        return premi;
    }

    public void setPremi(double premi) {
        this.premi = premi;
    }

    public List<Equip> getEquips() {
        return equips;
    }

    public void setEquips(List<Equip> equips) {
        this.equips = equips;
    }

    public void afegirEquip(Equip e) {
        equips.add(e);
        e.getTorneigs().add(this);
    }

    @Override
    public String toString() {
        return "Torneig{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", premi=" + premi +
                '}';
    }
}
