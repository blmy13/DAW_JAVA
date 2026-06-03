package DB.Hospital;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Metge implements Serializable {
    @Id
    private String numColegiat;
    private String nom;
    private String especialitat;

    @ManyToOne
    private Hospital hospital;

    @ManyToMany(mappedBy = "metges")
    private List<Pacient> pacients = new ArrayList<>();

    public Metge() {
    }

    public Metge(String numColegiat, String nom, String especialitat) {
        this.numColegiat = numColegiat;
        this.nom = nom;
        this.especialitat = especialitat;
    }

    public String getNumColegiat() {
        return numColegiat;
    }

    public void setNumColegiat(String numColegiat) {
        this.numColegiat = numColegiat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void afegirPacient(Pacient p) {
        pacients.add(p);
        p.getMetges().add(this);
    }

    @Override
    public String toString() {
        return String.format("<< METGE %-5s | NOM: %-20s | ESPECIALITAT: %-15s >>",
                this.numColegiat, this.nom, this.especialitat);
    }
}
