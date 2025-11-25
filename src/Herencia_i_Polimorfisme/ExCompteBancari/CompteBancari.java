package Herencia_i_Polimorfisme.ExCompteBancari;

import java.util.Objects;

public abstract class CompteBancari {

    private final String numCompte;
    private double saldo;
    private static final double qttInicial = 10000.00;

    public CompteBancari(String numCompte, double saldo) {
        this.numCompte = numCompte;
        this.saldo = saldo;     
    }

    public CompteBancari(String numCompte) {
        this.numCompte = numCompte;
        saldo = qttInicial;
    }

    public String toString() {
        return "CompteBancari{" + "numCompte=" + numCompte + ", saldo=" + saldo + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompteBancari that = (CompteBancari) o;
        return Double.compare(saldo, that.saldo) == 0 && Objects.equals(numCompte, that.numCompte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCompte, saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getQttInicial() {
        return qttInicial;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double imposicio(double x) {
        return saldo + x;
    }
    public double getFondosDisponibles() {
        return this.saldo;
    }

    public double reintegre(double x) {
        double saldoFinal;
        saldoFinal = saldo - x;
        if (saldoFinal < 0) {
            System.out.println("ERROR: La quantitat que es vol retirar supera el saldo disponible.");
        }
        return saldoFinal;
    }

}
