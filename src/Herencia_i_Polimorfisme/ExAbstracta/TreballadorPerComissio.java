package Herencia_i_Polimorfisme.ExAbstracta;


public class TreballadorPerComissio extends Treballador {

    private final double vendesBrutes;
    private final double tarifaComissio;

    public TreballadorPerComissio(double vendesBrutes, double tarifaComissio, String nom, String cognom, String nss) {
        super(nom, cognom, nss);
        this.vendesBrutes = vendesBrutes;
        this.tarifaComissio = tarifaComissio;
    }

    public double getVendesBrutes() {
        return vendesBrutes;
    }

    public double getTarifaComissio() {
        return tarifaComissio;
    }

    @Override
    public void informacio() {
        super.informacio();
        System.out.println("- Vendes brutes del Treballador: \n\t" + vendesBrutes);
        System.out.println("- Comissio de Tarifa del Treballador: \n\t" + tarifaComissio);
    }

    @Override
    public double ingressos() {
        return vendesBrutes * tarifaComissio;
    }
}
