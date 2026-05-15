package Reps.SistemaPagaments.Entitats;

public class PagamentTargeta implements EstrategiaPagament {
    private String numeroTargeta;
    private String titular;

    public PagamentTargeta(String numeroTargeta, String titular) {
        if (numeroTargeta == null || numeroTargeta.isBlank() || titular == null || titular.isBlank()) {
            throw new TargetaInvalidaException(" >> ERROR: Targeta no vàlida");
        }
        this.numeroTargeta = numeroTargeta;
        this.titular = titular;
    }

    public String getNumeroTargeta() {
        return numeroTargeta;
    }

    public void setNumeroTargeta(String numeroTargeta) {
        this.numeroTargeta = numeroTargeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return String.format(" >> PAGAMENT: Nº TARGETA: %-10s | TITULAR: -20s ", this.numeroTargeta, this.titular);
    }

    private String obtenirTargetaOculta() {
        String ultimsQuatre = this.numeroTargeta.substring(this.numeroTargeta.length() - 4);
        return "*".repeat(this.numeroTargeta.length() - 4) + ultimsQuatre;
    }

    @Override
    public void processarPagament(double quantitat) throws PagamentInvalidException {
        System.out.println("Cobrant " + quantitat + "€ a la targeta " + obtenirTargetaOculta());
    }
}
