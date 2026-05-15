package Reps.SistemaPagaments.Main;

import Reps.SistemaPagaments.Entitats.*;
import Reps.SistemaPagaments.DAO.*;
import java.util.List;

public class ProcessadorMain {
    public static void main(String[] args) {
        TransaccioDAO fitxerDao = new TransaccioFitxerDAO();

        EstrategiaPagament paypal = new PagamentPaypal("anacleto666@gmail.com");
        EstrategiaPagament targeta = new PagamentTargeta("7845666612478144", "J.W. Anacleto");

        ProcessadorPagaments pp = new ProcessadorPagaments(paypal, fitxerDao);

        // 1.
        try {
            Transaccio compraUnica = new Transaccio(100, targeta);
            pp.executarCompra(compraUnica);
            System.out.println("Compra individual realitzada amb èxit.");
        } catch (PagamentInvalidException | PersistenciaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\n--- INICIANT PROCESSAMENT PER LOTS ---");

        List<Transaccio> lotPagaments = List.of(
                new Transaccio(-50, paypal),
                new Transaccio(750, targeta),
                new Transaccio(444, paypal),
                new Transaccio(-87, targeta)
        );

        lotPagaments.forEach(t -> {
            try {
                pp.executarCompra(t);
                System.out.printf(" >> OK: S'han processat %.2f€%n", t.getImportTransaccio());
            } catch (PagamentInvalidException e) {
                System.out.println(" >> ERROR DE NEGOCI: " + e.getMessage());
            } catch (PersistenciaException e) {
                System.out.println(" >> ERROR CRÍTIC DE DISC: " + e.getMessage());
            }
        });
    }
}