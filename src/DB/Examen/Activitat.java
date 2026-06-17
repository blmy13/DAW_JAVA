package DB.Examen;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Activitat implements Serializable {
    @Id
    private String nom;
    private String nivell;
    private int places;

    @ManyToMany(mappedBy = "activitats")
    private List<Client> clients = new ArrayList<>();

    public Activitat() {
    }

    public Activitat(String nom, String nivell, int places) {
        this.nom = nom;
        if (nivell != null && (nivell.equalsIgnoreCase("inicial") ||
                nivell.equalsIgnoreCase("mitjà") ||
                nivell.equalsIgnoreCase("avançat"))) {
            this.nivell = nivell.toLowerCase();
        } else {
            throw new NivellNoValidException(">> ERROR: Nivell no vàlid.");
        }
        this.places = places;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return String.format("   >> ACTIVITAT: %-12s | NIVELL: %-8s | PLACES: %-3d",
                this.nom, this.nivell, this.places);
    }
}
