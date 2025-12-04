package Herencia_i_Polimorfisme.ExEspai;

import java.time.LocalDate;

public class SimuladorTecnic implements Qualificable {

    private final LocalDate data;
    private final int nota;

    public SimuladorTecnic(int nota, LocalDate data) {
        this.nota = nota;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public boolean esQualificat() {
        return nota >= 80;
    }
}
