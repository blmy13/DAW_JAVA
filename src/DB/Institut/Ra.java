package DB.Institut;

import javax.persistence.*;

@Entity
public class Ra {
    @Id @GeneratedValue
    private Long id;

    private int numeroRA;
    private String nom;
    private int durada;
    private double pes;

    @ManyToOne
    private Modul modul;

    public Ra() {}

    public Ra(int numeroRA, String nom, int durada, double pes, Modul modul) {
        this.numeroRA = numeroRA;
        this.nom = nom;
        this.durada = durada;
        this.pes = pes;
        this.modul = modul;
    }

    public Long getId() { return id; }

    public int getNumeroRA() { return numeroRA; }
    public void setNumeroRA(int numeroRA) { this.numeroRA = numeroRA; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getDurada() { return durada; }
    public void setDurada(int durada) { this.durada = durada; }

    public double getPes() { return pes; }
    public void setPes(double pes) { this.pes = pes; }

    public Modul getModul() { return modul; }
    public void setModul(Modul modul) { this.modul = modul; }
}
