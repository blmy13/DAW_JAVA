package Reps.SistemaPagaments.Persistencia;

import Reps.SistemaPagaments.DAO.PersistenciaException;
import Reps.SistemaPagaments.DAO.TransaccioDAO;
import Reps.SistemaPagaments.Entitats.Transaccio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaccioDAOMySQL implements TransaccioDAO {
    // Credencials per defecte de XAMPP
    private static final String URL = "jdbc:mysql://localhost:3306/pagaments_db";
    private static final String USUARI = "root";
    private static final String PASSWORD = "";

    @Override
    public void guardarTransaccio(Transaccio t) {
        try (Connection connexio = DriverManager.getConnection(URL, USUARI, PASSWORD)) {

            String sql = "INSERT INTO transaccions (import, estat) VALUES (?, ?)";
            PreparedStatement ps = connexio.prepareStatement(sql);

            ps.setDouble(1, t.getImportTransaccio());
            ps.setString(2, "EXIT");

            ps.executeUpdate();
            System.out.println(">> [BBDD] Transacció de " + t.getImportTransaccio() + " guardada a MySQL.");

        } catch (Exception e) {
            System.out.println(">> [BBDD Error] No s'ha pogut guardar: " + e.getMessage());
        }
    }

    @Override
    public List<Transaccio> obtenirTransaccions() throws PersistenciaException {
        List<Transaccio> llista = new ArrayList<>();
        String sql = "SELECT import FROM transaccions";

        try (Connection con = ConnexioBDSingleton.getInstancia().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                double quantitat = rs.getDouble("import");
                Transaccio t = new Transaccio(quantitat, null);
                llista.add(t);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error en llegir les transaccions de la BD: " + e.getMessage());
        }
        return llista;
    }
}

