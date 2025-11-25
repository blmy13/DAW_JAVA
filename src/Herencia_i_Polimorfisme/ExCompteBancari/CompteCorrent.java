package Herencia_i_Polimorfisme.ExCompteBancari;

public class CompteCorrent extends CompteBancari {

    private boolean xecsEmesos;

    public CompteCorrent(boolean xecsEmesos, String numCompte, double saldo) {
        super(numCompte, saldo);
        this.xecsEmesos = xecsEmesos;
    }

    public CompteCorrent(boolean xecsEmesos, String numCompte) {
        super(numCompte);
        this.xecsEmesos = xecsEmesos;
    }

    public final boolean isXecsEmesos() {
        return xecsEmesos;
    }

    public final void setXecsEmesos(boolean xecsEmesos) {
        this.xecsEmesos = xecsEmesos;
    }

    @Override
    public String toString() {
        String xecs = xecsEmesos ? "L'usuari ha demanat xecs." : "L'usuari no ha demanat xecs.";
        return super.toString() + (this.getClass().getSimpleName()  + xecs);
        
       
    }

}
