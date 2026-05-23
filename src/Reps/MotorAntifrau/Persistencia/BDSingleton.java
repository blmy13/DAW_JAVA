package Reps.MotorAntifrau.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDSingleton {
    private static Connection instance;

    private BDSingleton(){}

    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/motor_antifrau";
            instance = DriverManager.getConnection(url, "root","");
            System.out.println(">> BBDD: Connexió establerta amb èxit");
        }
        return instance;
    }
}
