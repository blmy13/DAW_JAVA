package DB.Alumne;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name= "Alumne.findAll", query = "SELECT al FROM Alumne al")
@NamedQuery(name = "Alumne.findByName", query = "SELECT al FROM Alumne al WHERE al.nom = :nom")
//consulta multiple retorna array d'obj

@Entity
public class Alumne1 implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private int edat;
    private double notaFinal;
    
    public Alumne1(){
    }

    public Alumne1(Long id, String nom, int edat, double notaFinal) {
        this.id = id;
        this.nom = nom;
        this.edat = edat;
        this.notaFinal = notaFinal;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | ALUMNE: %-12s | EDAT: %-2d | NOTA FINAL: %-4.2f%n", this.id, this.nom, this.edat, this.notaFinal);
    }
}
