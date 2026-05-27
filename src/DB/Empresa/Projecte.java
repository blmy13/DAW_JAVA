package DB.Empresa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projecte implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String nomProjecte;
    private double pressupost;

    @ManyToMany
    private List<Empleat> empleats = new ArrayList<>();

    public Projecte() {}

    public Projecte(String nomProjecte, double pressupost) {
        this.nomProjecte = nomProjecte;
        this.pressupost = pressupost;
    }

    public long getId() { return id; }
    public String getNomProjecte() { return nomProjecte; }
    public void setNomProjecte(String nomProjecte) { this.nomProjecte = nomProjecte; }
    public double getPressupost() { return pressupost; }
    public void setPressupost(double pressupost) { this.pressupost = pressupost; }
    public List<Empleat> getEmpleats() { return empleats; }

    @Override
    public String toString() {
        return String.format("<< PROJECTE %-3d: NOM: %-15s | PRESSUPOST: %9.2f >>",
                this.id, this.nomProjecte, this.pressupost);
    }
}