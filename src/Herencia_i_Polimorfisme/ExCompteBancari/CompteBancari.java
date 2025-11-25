package Herencia_i_Polimorfisme.ExCompteBancari;

public abstract class CompteBancari {

    private final String numCompte;
    private double saldo;
    private static double qttInicial = 100.00;

    public CompteBancari(String numCompte, double saldo) {
        this.numCompte = numCompte;
        this.saldo = saldo;     
    }

    public CompteBancari(String numCompte) {
        this.numCompte = numCompte;
    }

    public String toString() {
        return "CompteBancari{" + "numCompte=" + numCompte + ", saldo=" + saldo + '}';
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
        double saldoFinal;
        saldoFinal = saldo + x;
        return saldoFinal;
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
