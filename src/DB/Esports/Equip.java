package DB.Esports;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equip implements Serializable {
    @Id
    private String nom;
    private String pais;
    private double pressupost;

    @OneToMany(mappedBy = "equip", cascade = CascadeType.PERSIST)
    private List<Jugador> jugadors = new ArrayList<>();

    @ManyToMany(mappedBy = "equips")
    private List<Torneig> torneigs = new ArrayList<>();

    public Equip() {
    }

    public Equip(String nom, String pais, double pressupost) {
        this.nom = nom;
        this.pais = pais;
        this.pressupost = pressupost;
    }

    public List<Torneig> getTorneigs() {
        return torneigs;
    }

    public void setTorneigs(List<Torneig> torneigs) {
        this.torneigs = torneigs;
    }

    public List<Jugador> getJugadors() {
        return jugadors;
    }

    public void setJugadors(List<Jugador> jugadors) {
        this.jugadors = jugadors;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPressupost() {
        return pressupost;
    }

    public void setPressupost(double pressupost) {
        this.pressupost = pressupost;
    }

    public void afegirJugador(Jugador j) {
        jugadors.add(j);
        j.setEquip(this);
    }

    @Override
    public String toString() {
        return "Equip{" +
                "nom='" + nom + '\'' +
                ", pais='" + pais + '\'' +
                ", pressupost=" + pressupost +
                '}';
    }
}
