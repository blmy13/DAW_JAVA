package Herencia_i_Polimorfisme.ExVoluntari;

public abstract class ArmaDefensa implements Armable{
    
    private final double percentatgeVida;

    public ArmaDefensa(double percentatgeVida) {
        this.percentatgeVida = percentatgeVida;
    }
         
    @Override
    public void equiparPersonatge(Personatge personatge) {
        personatge.setPuntsVida(personatge.getPuntsVida() * percentatgeVida);
        activarProteccio(personatge);
        
    }
         
    public void activarProteccio(Personatge personatge) {
        
    }
    
}
