package Herencia_i_Polimorfisme.ExAbstracta;

public class TreballadorBaseMesComissio extends TreballadorPerComissio {

    private double souBase;

    public TreballadorBaseMesComissio(double souBase, double vendesBrutes, double tarifaComissio, String nom, String cognom, String nss) {
        super(vendesBrutes, tarifaComissio, nom, cognom, nss);
        this.souBase = souBase;
    }

    public double getSouBase() {
        return souBase;
    }

    public void setSouBase(double souBase) {
        this.souBase = souBase;
    }

    @Override
    public void informacio() {
        super.informacio();
        System.out.println("- Sou base del Treballador: \n\t" + souBase + "€");
    }

    @Override
    public double ingressos() {
        return super.ingressos() + souBase;
    }

}
