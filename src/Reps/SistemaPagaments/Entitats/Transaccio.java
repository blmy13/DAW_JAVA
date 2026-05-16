package Reps.SistemaPagaments.Entitats;

public class Transaccio {
    private double importTransaccio;
    private EstrategiaPagament estrategia;

    public Transaccio(double importTransaccio, EstrategiaPagament estrategia) {
        this.importTransaccio = importTransaccio;
        this.estrategia = estrategia;
    }

    public double getImportTransaccio() {
        return importTransaccio;
    }

    @Override
    public String toString() {
        return String.format("Transacció [Import: %.2f€, Mètode: %s]", this.importTransaccio, this.estrategia.getClass().getSimpleName());
    }

    public EstrategiaPagament getEstrategia() {
        return estrategia;
    }
}
