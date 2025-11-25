package Herencia_i_Polimorfisme.ExCompteBancari;

public class CompteEstalvis extends CompteBancari {
    
    private static double tipusInteres=0.02;

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
    
    public final double calculaInteres() {
        
        
    }
    
    public void capitalitzaInteres() {
        
    }
    
    
}
