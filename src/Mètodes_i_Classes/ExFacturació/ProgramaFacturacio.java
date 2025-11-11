package Mètodes_i_Classes.ExFacturació;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProgramaFacturacio {

    public static void main(String[] args) {
        // Crear clients
        Client client1 = new Client("12345678A", "Ramon Canela", "123456789");

        // Crear productes
        Producte producte1 = new Producte("P001", "Producte A", 10.0, 50);
        Producte producte2 = new Producte("P002", "Producte B", 20.0, 30);

        // Crear factura
        Factura factura1 = new Factura(1, new Date(), client1);

        // Crear línies de factura
        Linia linia1 = new Linia(1, factura1, producte1, 2); // 2 unitats de Producte A
        Linia linia2 = new Linia(2, factura1, producte2, 3); // 3 unitats de Producte B

        // Afegir línies a la factura
        factura1.afegirLiniaFactura(linia1);
        factura1.afegirLiniaFactura(linia2);

        // Mostrar la factura
        System.out.println("Factura número: " + factura1.getIdFactura());

        SimpleDateFormat formatCatala = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale.forLanguageTag("ca-ES"));

        String dataEnCatala = formatCatala.format(factura1.getData());
        System.out.println("Data: " + dataEnCatala);
        System.out.println("Client: " + factura1.getClient().getNom() + " (NIF: " + factura1.getClient().getNif() + ")");
        System.out.println("Línies de la factura:");

        for (Linia linia : factura1.getLinies()) {
            System.out.println(" Línia " + linia.getNumeroLinia() + ": " + linia.getProducte().getNom()
                    + " - Quantitat: " + linia.getTotal() / linia.getProducte().getPreu()
                    + " - Total: " + linia.getTotal());
        }

        System.out.println("Total de la factura: " + factura1.getTotal());
    }
}
