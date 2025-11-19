package Herencia_i_Polimorfisme.ExEmpleats;

public class MainEmpleats {

    public static void main(String[] args) {

        //Creació Empleats
        EmpleatTempsParcial empleat1 = new EmpleatTempsParcial("Cleopatra", "001", 60, 8.00);
        EmpleatTempsParcial empleat2 = new EmpleatTempsParcial("Josefina", "002", 45, 6.00);
        
        EmpleatTempsComplet empleat3 = new EmpleatTempsComplet("Marcel", "003", 1600.00);
        EmpleatTempsComplet empleat4 = new EmpleatTempsComplet("Carles", "004", 1400.00);
        
        //Creació Projectes
        Projecte projecte1 = new Projecte("Destrucció hàbitat local");
        Projecte projecte2 = new Projecte("Deforestació massiva");
    }

}
