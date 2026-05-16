package Reps.SistemaPagaments.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioBDSingleton {
    private final String url = "jdbc:mysql://localhost:3306/transaccions_db";
    private final String usuari = "root";
    private final String pwd = "";

    private static ConnexioBDSingleton instancia;
    private Connection con;

    private ConnexioBDSingleton() throws SQLException {
        System.out.println(" >> INFO: Obrint connexió física amb la base de dades...");
        this.con = DriverManager.getConnection(url, usuari, pwd);
    }

    public static ConnexioBDSingleton getInstancia() throws SQLException {
        if (instancia == null || instancia.getConnection().isClosed()) {
            instancia = new ConnexioBDSingleton();
        }
        return instancia;
    }

    public Connection getConnection() {
        return this.con;
    }
}