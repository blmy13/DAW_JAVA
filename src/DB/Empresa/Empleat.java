package DB.Empresa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empleat implements Serializable {
    @Id
    private String dni;
    private String nom;
    private double salari;

    @ManyToOne
    private Departament departament;

    @ManyToMany(mappedBy = "empleats")
    private List<Projecte> projectes = new ArrayList<>();

    public Empleat() {}

    public Empleat(String dni, String nom, double salari) {
        this.dni = dni;
        this.nom = nom;
        this.salari = salari;
    }

    public void afegirProjecte(Projecte p) {
        this.projectes.add(p);
        p.getEmpleats().add(this);
    }

    public String getDni() { return dni; }
    public String getNom() { return nom; }
    public double getSalari() { return salari; }
    public Departament getDepartament() { return departament; }
    public void setDepartament(Departament departament) { this.departament = departament; }
    public List<Projecte> getProjectes() { return projectes; }

    @Override
    public String toString() {
        long depId = (departament != null) ? departament.getId() : 0;
        return String.format("<< EMPLEAT: %-9s | NOM: %-10s | SALARI: %9.2f | DEPARTAMENT: %-3d >>",
                this.dni, this.nom, this.salari, depId);
    }
}