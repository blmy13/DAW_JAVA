package Herencia_i_Polimorfisme.Examen;

import java.time.LocalDate;

public abstract class Examen implements Aprovable {

    LocalDate data;

    public Examen(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}
