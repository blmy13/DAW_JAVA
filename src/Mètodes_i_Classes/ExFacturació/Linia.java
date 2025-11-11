package Mètodes_i_Classes.ExFacturació;

public class Linia {

    private int numeroLinia;
    private double total;
    private Factura factura;
    private Producte producte;

    public Linia(int numeroLinia, Factura factura, Producte producte, double total) {

        this.numeroLinia = numeroLinia;
        this.total = total;
        this.factura = factura;
        this.producte = producte;

    }

    public int getNumeroLinia() {
        return numeroLinia;
    }

    public double getTotal() {
        return total;
    }

    public Factura getFactura() {
        return factura;
    }

    public Producte getProducte() {
        return producte;
    }

}
