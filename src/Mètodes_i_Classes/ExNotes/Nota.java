package Mètodes_i_Classes.ExNotes;

public class Nota {
    
    private Modul modul;
    private Alumne alumne;
    private double nota;

    public Nota(Modul modul, Alumne alumne, double nota) {
        this.modul = modul;
        this.alumne = alumne;
        this.nota = nota;
    }

    public Modul getModul() {
        return modul;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
}
