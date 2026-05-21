package Reps.MotorAntifrau.Entitats;

import Reps.MotorAntifrau.Excepcions.TransaccioInvalidaException;

public class Transaccio {
    private double importTransaccio;
    private String paisOrigen;
    private TipusTransaccio tipus;

    public Transaccio(double importTransaccio, String paisOrigen, TipusTransaccio tipus) {
        if (paisOrigen == null || paisOrigen.isBlank() || importTransaccio < 0) {
            throw new TransaccioInvalidaException(" >> ERROR: Les dades introduïdes no són vàlides.");
        }
        this.importTransaccio = importTransaccio;
        this.paisOrigen = paisOrigen;
        this.tipus = tipus;

    }

    public double getImportTransaccio() {
        return importTransaccio;
    }

    public void setImportTransaccio(double importTransaccio) {
        this.importTransaccio = importTransaccio;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public TipusTransaccio getTipus() {
        return tipus;
    }

    public void setTipus(TipusTransaccio tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return String.format("<< TRANSACCIÓ --- | IMPORT: %-8.2f | PAÍS D'ORIGEN: %-12s | TIPUS: %-12s >>%n", this.importTransaccio, this.paisOrigen, tipus);
    }

}
