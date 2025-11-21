package Herencia_i_Polimorfisme.ExAbstracta;


public class TreballadorAssalariat extends Treballador {
    
    private double souSetmanal;

    public TreballadorAssalariat(double souSetmanal, String nom, String cognom, String nss) {
        super(nom, cognom, nss);
        this.souSetmanal = souSetmanal;
    }

    public double getSouSetmanal() {
        return souSetmanal;
    }

    @Override
    public void informacio() {
        super.informacio();
        System.out.println("- Sou Setmanal del Treballador:\n" + souSetmanal + "€");
    }
    
    @Override
    public double ingressos() {
        return souSetmanal;
    }
    
}
