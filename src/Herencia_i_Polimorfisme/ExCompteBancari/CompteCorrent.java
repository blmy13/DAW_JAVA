package Herencia_i_Polimorfisme.ExCompteBancari;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompteCorrent that = (CompteCorrent) o;
        return xecsEmesos == that.xecsEmesos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xecsEmesos);
    }
}
