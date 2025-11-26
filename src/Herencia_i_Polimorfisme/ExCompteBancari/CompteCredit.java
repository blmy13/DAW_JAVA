package Herencia_i_Polimorfisme.ExCompteBancari;

public class CompteCredit extends CompteCorrent {

    private static double credit = 50000.00;

    public CompteCredit(boolean xecsEmesos, String numCompte, double saldo) {
        super(xecsEmesos, numCompte, saldo);
    }

    public CompteCredit(boolean xecsEmesos, String numCompte) {
        super(xecsEmesos, numCompte);
    }

    @Override
    public double getFondosDisponibles() {
        return super.getFondosDisponibles() + credit;
    }

    public static double getCredit() {
        return credit;
    }

    public static void setCredit(double credit) {
        CompteCredit.credit = credit;
    }

    @Override
    public String toString() {
        return super.toString() + "El credit és de: " + credit;
    }

    @Override
    public void reintegre(double x) {

        double saldoTotal = getFondosDisponibles();
        if (saldoTotal < x) {
            System.out.println("ERROR: La quantitat que es vol retirar supera el saldo disponible.");
        } else {
            this.setSaldo(this.getSaldo() - x);
        }

    }
}
