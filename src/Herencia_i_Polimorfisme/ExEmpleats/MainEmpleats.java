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

        //Assignació Empleats a Projectes
        projecte1.afegirEmpleat(empleat1);
        projecte1.afegirEmpleat(empleat3);

        projecte2.afegirEmpleat(empleat2);
        projecte2.afegirEmpleat(empleat4);

        //Mostra informació empleats
        System.out.println("\tDetalls de tots els empleats:\n");
        empleat1.mostrarInformacio();
        empleat2.mostrarInformacio();
        empleat3.mostrarInformacio();
        empleat4.mostrarInformacio();

        //Suma Salari Empleats
        System.out.println("\nSalari total de tots els empleats: " + (empleat1.calcularSalari() + empleat2.calcularSalari() + empleat3.calcularSalari() + empleat4.calcularSalari()) + "€\n");

        //Mostra Informació d'Empleat a cada Projecte
        System.out.println("\tEmpleats assignats a cada projecte:\n");;
        System.out.println("Empleats assignats al projecte: " + projecte1.getNom() + ":\n");
        projecte1.mostrarEmpleat();
        System.out.println("Empleats assignats al projecte: " + projecte2.getNom()+ ":\n");
        projecte2.mostrarEmpleat();
    }

}
