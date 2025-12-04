package Herencia_i_Polimorfisme.ExEspai;

import java.time.LocalDate;

public class AvaluacioPsicologica implements NivellEstablilitat, Qualificable {

    private final LocalDate data;
    private final String nivellEstabilitat;

    public AvaluacioPsicologica(LocalDate data, String nivellEstabilitat) {
        this.data = data;
        this.nivellEstabilitat = nivellEstabilitat;
    }

    public LocalDate getData() {
        return data;
    }

    public String getNivellEstabilitat() {
        return nivellEstabilitat;
    }

    @Override
    public boolean esQualificat() {
        return this.nivellEstabilitat.equals(EXCEL_LENT) || this.nivellEstabilitat.equals(ACCEPTABLE);
    }
}
