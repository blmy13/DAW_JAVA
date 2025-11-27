package Herencia_i_Polimorfisme.Examen;

import java.time.LocalDate;

public class ExamenOral extends Examen implements NivellSatisfaccio {

    private String nivellSatisfaccio;

    public ExamenOral(String nivellSatisfaccio, LocalDate data) {
        super(data);
        this.nivellSatisfaccio = nivellSatisfaccio;
    }

    public String getNivellSatisfaccio() {
        return nivellSatisfaccio;
    }

    public void setNivellSatisfaccio(String nivellSatisfaccio) {
        this.nivellSatisfaccio = nivellSatisfaccio;
    }

    @Override
    public String toString() {
        return "ExamenOral: " + data;
    }

    @Override
    public boolean aprova() {
        return this.nivellSatisfaccio.equals(SUFICIENT) || this.nivellSatisfaccio.equals(EXCELENT);
    }

}
