package Reps.SistemaPagaments.Entitats;

public class Transaccio {
    private double importTransaccio;
    private  EstrategiaPagament estrategia;

    public Transaccio(double importTransaccio, EstrategiaPagament estrategia) {
        this.importTransaccio = importTransaccio;
        this.estrategia = estrategia;
    }

    public double getImportTransaccio() {
        return importTransaccio;
    }

    public EstrategiaPagament getEstrategia() {
        return estrategia;
    }
}
