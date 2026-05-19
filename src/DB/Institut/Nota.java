
package DB.Institut;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nota implements Serializable {
    @Id
    @GeneratedValue
    private Alumne alumne;
    private Ra ra;
    private double nota;

    public Nota(double nota, Alumne alumne, Ra ra) {
        this.alumne = alumne;
        this.ra = ra;
        this.nota = nota;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }


    public Ra getRa() {
        return ra;
    }

    public void setRa(Ra ra) {
        this.ra = ra;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("<< ALUMNE: %-8s | RA: -8s | NOTA: -%4.2f >> %n", alumne.getDniA(), ra.getNumeroRA(), this.nota);
    }
    
    
}
