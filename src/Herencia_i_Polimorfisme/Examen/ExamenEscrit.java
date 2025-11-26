package Herencia_i_Polimorfisme.Examen;

import java.time.LocalDate;

public class ExamenEscrit extends Examen {

    private int nota;

    public ExamenEscrit(int nota, LocalDate data) {
        super(data);
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean aprova() throws IllegalArgumentException {

        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota ha d'estar entre 0 i 10");
        }

        return nota >= 5;

    }

}
