package Herencia_i_Polimorfisme.ExCompteBancari;

public class CompteRentable extends CompteEstalvis implements Rentable{

    public CompteRentable(double tipusInteres, String numCompte, double saldo) {
        super(tipusInteres, numCompte, saldo);
    }

    public CompteRentable(double tipusInteres, String numCompte) {
        super(tipusInteres, numCompte);
    }

    @Override
    public double bonus() {
        double bonus = 0.0;
        if (this.getSaldo() > MAX_LIMIT) {
            bonus = calculaInteres() * 0.3;
        }
        else if (this.getSaldo() > MID_LIMIT) {
            bonus = calculaInteres() * 0.2;
        }
        else if (this.getSaldo() > MIN_LIMIT) {
            bonus = calculaInteres() * 0.1;
        }
        return bonus;
    }
    
    @Override
    public String toString() {
        return super.toString() + "El bonus del compte és de: " + bonus();
    }

    @Override
    public void capitalitzaInteres() {
        this.setSaldo(calculaInteres() + this.getSaldo() + bonus());
    }
}
