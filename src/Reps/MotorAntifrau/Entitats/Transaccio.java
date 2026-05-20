package Reps.MotorAntifrau.Entitats;

import Reps.MotorAntifrau.Excepcions.TransaccioInvalidaException;

public class Transaccio {
    private double importTransaccio;
    private String paisOrigen;

    public Transaccio(double importTransaccio, String paisOrigen) {
        if (paisOrigen == null || paisOrigen.isBlank() || importTransaccio < 0) {
            throw new TransaccioInvalidaException(" >> ERROR: Les dades introduïdes no són vàlides.");
        }
        this.importTransaccio = importTransaccio;
        this.paisOrigen = paisOrigen;
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

    @Override
    public String toString() {
        return String.format("<< TRANSACCIÓ --- | IMPORT: %-8.2f | PAÍS D'ORIGEN: %-12s", this.importTransaccio, this.paisOrigen);
    }

}
