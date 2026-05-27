package DB.Empresa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departament implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String nom;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.PERSIST)
    private List<Empleat> empleats = new ArrayList<>();

    public Departament() {}

    public Departament(String nom) { // No demanem l'ID
        this.nom = nom;
    }

    public void afegirEmpleat(Empleat e) {
        this.empleats.add(e);
        e.setDepartament(this);
    }

    public long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public List<Empleat> getEmpleats() { return empleats; }

    @Override
    public String toString() {
        return String.format("<< DEPARTAMENT: %-3d | NOM: %-10s >>", this.id, this.nom);
    }
}