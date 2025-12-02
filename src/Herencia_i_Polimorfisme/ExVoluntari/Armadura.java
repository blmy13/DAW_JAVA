package Herencia_i_Polimorfisme.ExVoluntari;


public class Armadura extends ArmaDefensa implements Armable {

    public Armadura(double percentatgeVida) {
        super(percentatgeVida = 1.5);
    }
    
    public void activarProteccio(Personatge personatge) {
        personatge.setProteccioCosACos(true);
    }
}
