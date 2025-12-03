package Herencia_i_Polimorfisme.ExVoluntari;

public class Arc extends ArmaAtac {

    public Arc() {
        super(1.15);
    }

    @Override
    public void activarAtac(Personatge personatge) {
        personatge.setAtacArquer(true);
    }
}
