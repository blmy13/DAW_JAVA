package Reps.RPG.Personatge;

public class Mag extends Personatge {
    private int mana = 50;
    private int manaMax = 50;

    public Mag(String nom) {
        super(nom);
    }

    public int getMana() {
        return mana;
    }

    public double llançarEncanteri(Personatge enemic) {
        if (mana > 10) {
            mana -= 10;
            enemic.rebreDany(40);
            System.out.println(this.getNom() + " llença un encanteri!!");
            return 40.0;
        } else {
            return 0.0;
        }
    }

    @Override
    protected void pujarNivell() {
        super.pujarNivell();
        this.manaMax += 20;
        this.mana = this.manaMax;
        System.out.println("El manà de " + this.getNom() + " augmenta a " + this.manaMax + " i es restaura!!");
    }
}
