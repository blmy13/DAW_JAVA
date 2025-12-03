package Herencia_i_Polimorfisme.ExVoluntari;


public class Armadura extends ArmaDefensa  {

    public Armadura() {
        super(1.5);
    }
    
    public void activarProteccio(Personatge personatge) {
        personatge.setProteccioCosACos(true);
    }
}
