package DB.Institut;

import javax.persistence.*;

@Entity
public class Nota {
    @Id @GeneratedValue
    private Long id;

    private double nota;

    @ManyToOne
    private Alumne alumne;

    @ManyToOne
    private Ra ra;

    public Nota() {}

    public Nota(double nota, Alumne alumne, Ra ra) {
        this.nota = nota;
        this.alumne = alumne;
        this.ra = ra;
    }

    public Long getId() { return id; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public Alumne getAlumne() { return alumne; }
    public void setAlumne(Alumne alumne) { this.alumne = alumne; }

    public Ra getRa() { return ra; }
    public void setRa(Ra ra) { this.ra = ra; }
}