package Herencia_i_Polimorfisme.Examen;

import java.time.LocalDate;

public class ExamenOral extends Examen implements NivellSatisfaccio {
    
    private double nota;

    public ExamenOral(double nota, LocalDate data) {
        super(data);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
    
}

