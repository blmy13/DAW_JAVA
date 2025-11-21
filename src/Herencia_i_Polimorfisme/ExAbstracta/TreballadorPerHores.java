package Herencia_i_Polimorfisme.ExAbstracta;

public class TreballadorPerHores extends Treballador {

    private final double sou;
    private final double hores;

    public TreballadorPerHores(double sou, double hores, String nom, String cognom, String nss) {
        super(nom, cognom, nss);
        this.sou = sou;
        this.hores = hores;
    }

    public double getSou() {
        return sou;
    }

    public double getHores() {
        return hores;
    }
    
    @Override
    public void informacio() {
        super.informacio();
        System.out.println("- Sou del Treballador: \n" + sou + "€");
        System.out.println("- Hores Treballades: \n" + hores + ".");
    }

    @Override
    public double ingressos() {
        if (getHores() <= 40) {
            return getSou() * getHores();
        } else {
            return 40 * getSou() + (getHores() - 40) * getSou() * 1.5;
        }

    }

}
