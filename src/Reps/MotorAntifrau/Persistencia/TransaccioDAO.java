package Reps.MotorAntifrau.Persistencia;

import Reps.MotorAntifrau.Entitats.Transaccio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransaccioDAO {
    private Connection con;

    public TransaccioDAO(Connection connexio) {
        this.con = connexio;
    }

    public void guardarTransaccionsBatch(List<Transaccio> valides) {
        String sql = "INSERT INTO pagaments_legitims (import, pais, tipus) VALUES (?, ?, ?)";

        try {
            // 1. desactivar auto commit
            con.setAutoCommit(false);

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                // 2. Iterar transaccions vàlides
                for (Transaccio t : valides) {
                    // 3. Omple els paràmetres del PreparedStatement (els 3 interrogants)
                    pstmt.setDouble(1, t.getImportTransaccio());
                    pstmt.setString(2, t.getPaisOrigen());
                    pstmt.setString(3, String.valueOf(t.getTipus()));

                    // 4. afegir al batch
                    pstmt.addBatch();
                }
                // 5. executar batch
                pstmt.executeBatch();
                // 6. commit final
                con.commit();
                System.out.println(">> BBDD: S'han guardat " + valides.size() + " transaccions correctament.");
            }

        } catch (SQLException e) {
            System.err.println(">> ERROR CRÍTIC BBDD: Falla en la inserció. Executant ROLLBACK...");
            // 7. si hi ha errors --> rollback
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    System.err.println(">> ERROR FATAL: No s'ha pogut fer el rollback.");
                }
            }
        } finally {
            // 8. restaura auto-commit i tancar connexió (Bona pràctica)
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}