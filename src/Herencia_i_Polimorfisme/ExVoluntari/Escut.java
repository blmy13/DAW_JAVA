package Herencia_i_Polimorfisme.ExVoluntari;

public class Escut extends ArmaDefensa {

    public Escut(double percentatgeVida) {
        super(percentatgeVida = 1.10);
    }
    
    @Override
    public void activarProteccio(Personatge personatge) {
        personatge.setProteccioArquer(true);
    }
}
