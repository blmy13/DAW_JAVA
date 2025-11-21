package Herencia_i_Polimorfisme.ExAbstracta;

public class TreballadorBaseMesComissio extends TreballadorPerComissio {

    private final double souBase;

    public TreballadorBaseMesComissio(double souBase, double vendesBrutes, double tarifaComissio, String nom, String cognom, String nss) {
        super(vendesBrutes, tarifaComissio, nom, cognom, nss);
        this.souBase = souBase;
    }

    @Override
    public void informacio() {
        super.informacio();
        System.out.println("Sou base del Treballador: \n" + souBase + "€");
    }

    @Override
    public double ingressos() {
        return super.ingressos() + souBase;
    }

}
