package DB.Alumne;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name= "Alumne.findAll", query = "SELECT * FROM Alumne al")
@NamedQuery(name = "Alumne.findByName", query = "SELECT * FROM Alumne al WHERE al.nom = :nom")
//consulta multiple retorna array d'obj

@Entity
public class Alumne implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private int edat;
    private double notaFinal;
    
    public Alumne(){
    }

    public Alumne(Long id, String nom, int edat, double notaFinal) {
        this.id = id;
        this.nom = nom;
        this.edat = edat;
        this.notaFinal = notaFinal;
    }
    
    
    
}
