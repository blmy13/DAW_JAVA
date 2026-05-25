package DB.Institut;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modul {
    @Id
    private int numeroM;
    private String nom;
    private int durada;

    @OneToMany(mappedBy = "modul", cascade = CascadeType.ALL)
    private List<Ra> ras;

    public Modul() {}

    public Modul(int numeroM, String nom, int durada) {
        this.numeroM = numeroM;
        this.nom = nom;
        this.durada = durada;
    }

    public int getNumeroM() { return numeroM; }
    public void setNumeroM(int numeroM) { this.numeroM = numeroM; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getDurada() { return durada; }
    public void setDurada(int durada) { this.durada = durada; }

    public List<Ra> getRas() { return ras; }
    public void setRas(List<Ra> ras) { this.ras = ras; }
}
