package Herencia_i_Polimorfisme.ExCompteBancari;

import java.util.Objects;

public class CompteEstalvis extends CompteBancari {
    
    private static final double tipusInteres = 0.02;
    private double interes;

    public CompteEstalvis(double tipusInteres, String numCompte, double saldo) {
        super(numCompte, saldo);
        
    }

    public CompteEstalvis(double tipusInteres, String numCompte) {
        super(numCompte);
        
    }

    public final double getTipusInteres() {
        return tipusInteres;
    }
    
    @Override
    public String toString() {
        return super.toString() + (this.getClass().getSimpleName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompteEstalvis that = (CompteEstalvis) o;
        return Double.compare(interes, that.interes) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interes);
    }

    public final double calculaInteres() {
        return this.getSaldo() * tipusInteres;
    }
    
    public void capitalitzaInteres() {
        this.setSaldo(calculaInteres() + this.getSaldo());
    }
    
    
}
