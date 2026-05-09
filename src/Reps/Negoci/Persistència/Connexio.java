package Reps.Negoci.Persistència;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {
    final static String url = "jdbc:mysql://localhost:3306/inventari_db";
    final static String usuari = "root";
    final static String pwd = "";
    static Connection con = null;

    private Connexio() {}

    static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(url, usuari, pwd);
        }
        return con;
    }
}
