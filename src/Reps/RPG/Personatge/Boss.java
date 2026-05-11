package Reps.RPG.Personatge;

import Reps.RPG.Arsenal.Arma;

public class Boss extends Personatge {

    public Boss(String nom) {
        super(nom);
        this.hpMax = 300;
        this.hp = this.hpMax;
    }

    @Override
    public double atacar(Personatge enemic) {
        System.out.println("!!!" + this.getNom() + " prepara un ATAC DEVASTADOR!!!");
        Arma armaOriginal = this.getArma();

        if (armaOriginal != null) {
            this.equiparArma(new Arma(armaOriginal.getNom() + " (Sobrecàrrega)", armaOriginal.getDanyBase() * 2));
        } else {
            this.equiparArma(new Arma("Impacte Còsmic", 60.0));
        }
        double danyReal = super.atacar(enemic);
        this.equiparArma(armaOriginal);

        return danyReal;
    }

}
