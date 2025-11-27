package Herencia_i_Polimorfisme.Examen;

import java.time.LocalDate;

public class ExamenEscrit extends Examen {

    private double nota;

    public ExamenEscrit(double nota, LocalDate data) {
        super(data);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "ExamenEscrit: " + data;

    }

    @Override
    public boolean aprova() throws IllegalArgumentException {

        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota ha d'estar entre 0 i 10");
        }

        return nota >= 5;

    }

}
