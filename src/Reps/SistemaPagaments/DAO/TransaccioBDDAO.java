package Reps.SistemaPagaments.DAO;

import Reps.SistemaPagaments.Entitats.EstrategiaPagament;
import Reps.SistemaPagaments.Entitats.PagamentPaypal;
import Reps.SistemaPagaments.Entitats.PagamentTargeta;
import Reps.SistemaPagaments.Entitats.Transaccio;
import Reps.SistemaPagaments.Persistencia.ConnexioBDSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaccioBDDAO implements TransaccioDAO {
    @Override
    public void guardarTransaccio(Transaccio t) throws PersistenciaException {
        String sql = "INSERT INTO transaccions (import, tipus_pagament, dades_pagament) VALUES (?, ?, ?)";

        try {
            Connection con = ConnexioBDSingleton.getInstancia().getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                String dadesCrues = t.getEstrategia().obtenirDadesPersistencia();
                String[] parts = dadesCrues.split(";", 2);
                String tipus = parts[0];
                String dades = parts[1];

                pstmt.setDouble(1, t.getImportTransaccio());
                pstmt.setString(2, tipus);
                pstmt.setString(3, dades);

                pstmt.executeUpdate();
                System.out.println(" >> OK: Transacció guardada a MySQL correctament.");
            }

        } catch (SQLException e) {
            throw new PersistenciaException(" >> ERROR: No s'ha pogut guardar a la BD: " + e.getMessage());
        }
    }

    @Override
    public List<Transaccio> obtenirTransaccions() throws PersistenciaException {
        String sql = "SELECT * FROM transaccions";
        List<Transaccio> historial = new ArrayList<>();

        try {
            Connection con = ConnexioBDSingleton.getInstancia().getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    double importTx = rs.getDouble("import");
                    String tipus = rs.getString("tipus_pagament");
                    String dades = rs.getString("dades_pagament");

                    Transaccio t = getTransaccio(tipus, dades, importTx);
                    historial.add(t);
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException(" >> ERROR: No s'ha pogut llegir l'historial de la BD: " + e.getMessage());
        }

        return historial;
    }

    private static Transaccio getTransaccio(String tipus, String dades, double importTx) {
        EstrategiaPagament estrategia = null;

        if (tipus.equals("PAYPAL")) {
            estrategia = new PagamentPaypal(dades);
        } else if (tipus.equals("TARGETA")) {
            String[] partsTargeta = dades.split(";");
            estrategia = new PagamentTargeta(partsTargeta[0], partsTargeta[1]);
        }

        return new Transaccio(importTx, estrategia);
    }
}





