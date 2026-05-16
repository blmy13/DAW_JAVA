package Reps.SistemaPagaments.Main;

import Reps.SistemaPagaments.Entitats.*;
import Reps.SistemaPagaments.DAO.*;
import java.util.List;

public class ProcessadorMain {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   SISTEMA DE PAGAMENTS BANCARIS v2.0");
        System.out.println("==========================================\n");

        // --- FASE 1: INICIALITZACIÓ I INJECCIÓ DE DEPENDÈNCIES ---
        // Liskov:  canviant aquesta línia el programa passa d'usar TXT a MySQL.
        TransaccioDAO dao = new TransaccioBDDAO();

        EstrategiaPagament paypal = new PagamentPaypal("anacleto666@gmail.com");
        EstrategiaPagament targeta = new PagamentTargeta("7845666612478144", "J.W. Anacleto");

        // Injectem el motor de persistència al processador
        ProcessadorPagaments pp = new ProcessadorPagaments(paypal, dao);

        // --- FASE 2: LECTURA I RECUPERACIÓ DE L'ESTAT ---
        System.out.println("<<< HISTORIAL DE TRANSACCIONS >>>");
        try {
            List<Transaccio> transaccions = dao.obtenirTransaccions();
            if (transaccions.isEmpty()) {
                System.out.println(" > No s'ha registrat cap transacció prèvia.");
            } else {
                transaccions.forEach(System.out::println);
            }
        } catch (PersistenciaException e) {
            System.err.println(" > ALERTA: No s'ha pogut carregar l'historial: " + e.getMessage());
        }

        // --- FASE 3: EXECUCIÓ INDIVIDUAL ---
        System.out.println("\n<<< PROCESSANT COMPRA INDIVIDUAL >>>");
        try {
            Transaccio compraUnica = new Transaccio(100, targeta);
            pp.executarCompra(compraUnica);
            System.out.println(" > ÈXIT: Compra individual completada i guardada.");
        } catch (PagamentInvalidException | PersistenciaException e) {
            System.err.println(" > ERROR: " + e.getMessage());
        }

        // --- FASE 4: PROCESSAMENT PER LOTS (BATCH RESILIENT) ---
        System.out.println("\n<<< INICIANT PROCESSAMENT PER LOTS (BATCH) >>>");
        List<Transaccio> lotPagaments = List.of(
                new Transaccio(-50, paypal),  // Transacció fraudulenta
                new Transaccio(750, targeta), // Transacció OK
                new Transaccio(444, paypal),  // Transacció OK
                new Transaccio(-87, targeta)  // Transacció fraudulenta
        );

        lotPagaments.forEach(t -> {
            try {
                pp.executarCompra(t);
                System.out.printf(" > OK: S'han processat %.2f€ correctament.%n", t.getImportTransaccio());
            } catch (PagamentInvalidException e) {
                System.out.println(" > ERROR DE NEGOCI: " + e.getMessage());
            } catch (PersistenciaException e) {
                System.out.println(" > ERROR CRÍTIC DE DISC/BD: " + e.getMessage());
            }
        });

        System.out.println("\n==========================================");
        System.out.println("             FI DEL PROCÈS");
        System.out.println("==========================================");
    }
}