package Mètodes_i_Classes.ExFacturació;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private int idFactura;
    Date data;
    private double total;
    private Client client;
    ArrayList<Linia> linies;

    public Factura(int idFactura, Date data, Client client) {

        this.idFactura = idFactura;
        this.data = data;
        this.total = 0;
        linies = new ArrayList<>();
        this.client = client;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public Date getData() {
        return data;
    }

    public double getTotal() {
        return total;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Linia> getLinies() {
        return linies;
    }

    public void afegirLiniaFactura(Linia linia) {

        linies.add(linia);
        total += linia.calculTotal();
        linia.getProducte().setStock((int) (linia.getProducte().getStock()-linia.getQuantitat()));

    }

}
