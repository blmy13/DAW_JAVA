package Herencia_i_Polimorfisme.ExVoluntari;

public class Espasa extends ArmaAtac {

    public Espasa() {
        super(1.40);
    }

    @Override
    public void activarAtac(Personatge personatge) {
        personatge.setAtacCosACos(true);
    }
}
