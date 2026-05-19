package DB.Institut;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ra implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private int numeroRA;
    private Modul modul;
    private int durada;
    private double pes;

    public Ra(int numeroRA, String par, int durada, double pes, Modul modul) {
        this.id = id;
        this.numeroRA = numeroRA;
        this.modul = modul;
        this.durada = durada;
        this.pes = pes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroRA() {
        return numeroRA;
    }

    public void setNumeroRA(int numeroRA) {
        this.numeroRA = numeroRA;
    }

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    @Override
    public String toString() {
        return String.format("<< RA: %-3d | NÚMERO RA: %-4d | MÒDUL: %-8s | DURADA: %-3d | PES: %-5.2f >> %n", this.id, this.numeroRA, modul.getNom(), this.durada, this.pes);
    }

}
