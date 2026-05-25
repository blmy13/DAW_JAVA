package DB.Institut;

import DB.Institut.Modul;
import DB.Institut.Nota;

import javax.persistence.*;
import java.util.List;

@Entity
public class Alumne {
    @Id
    private String dniA;
    private String nom;
    private int edat;

    @OneToMany(mappedBy = "alumne", cascade = CascadeType.ALL)
    private List<Nota> notes;

    public Alumne() {}

    public Alumne(String dniA, String nom, int edat) {
        this.dniA = dniA;
        this.nom = nom;
        this.edat = edat;
    }

    public double calcularNotaFinalModul(Modul modul) {
        if (notes == null || notes.isEmpty()) return 0.0;

        return notes.stream()
                .filter(n -> n.getRa().getModul().getNumeroM() == modul.getNumeroM())
                .mapToDouble(n -> n.getNota() * n.getRa().getPes() / 100.0)
                .sum();
    }

    public String getDniA() { return dniA; }
    public void setDniA(String dniA) { this.dniA = dniA; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getEdat() { return edat; }
    public void setEdat(int edat) { this.edat = edat; }

    public List<Nota> getNotes() { return notes; }
    public void setNotes(List<Nota> notes) { this.notes = notes; }
}
