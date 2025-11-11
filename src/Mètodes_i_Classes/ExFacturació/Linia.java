package Mètodes_i_Classes.ExFacturació;

public class Linia {

    private int numeroLinia;
    private int quantitat;
    private Factura factura;
    private Producte producte;
    private double total;

    public Linia(int numeroLinia, Factura factura, Producte producte, int quantitat) {

        this.numeroLinia = numeroLinia;
        this.quantitat = quantitat;
        this.factura = factura;
        this.producte = producte;
        total = 0.0;

    }

    public int getNumeroLinia() {
        return numeroLinia;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public Factura getFactura() {
        return factura;
    }

    public Producte getProducte() {
        return producte;
    }

    public double getTotal() {
        return total;
    }

    public double calculTotal() {
        total = producte.getPreu() * quantitat;
        return total;
    }

}
