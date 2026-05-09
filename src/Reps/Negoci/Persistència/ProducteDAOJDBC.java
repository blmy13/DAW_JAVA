package Reps.Negoci.Persistència;

import Reps.Negoci.Entitats.Producte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducteDAOJDBC implements ProducteDAO {
    @Override
    public void guardarInventari(List<Producte> productes) {
        String sql = "INSERT INTO productes (nom, preu) VALUES (?, ?)";
        try (Connection con = Connexio.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            for (Producte p : productes) {
                pstmt.setString(1, p.getNom());
                pstmt.setDouble(2, p.getPreu());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Producte> recuperarInventari() {
        String sql = "SELECT * FROM productes";
        List<Producte> inventari = new ArrayList<>();

        try (Connection con = Connexio.getConnection(); PreparedStatement pstmt = con .prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Producte p = new Producte(rs.getString("nom"), rs.getDouble("preu"));
                inventari.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventari;
    }
}
