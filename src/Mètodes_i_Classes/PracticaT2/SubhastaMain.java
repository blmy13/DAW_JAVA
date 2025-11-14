package Mètodes_i_Classes.PracticaT2;

public class SubhastaMain {

    public static void main(String[] args) {

        //Creació Usuaris
        Usuari Joan = new Usuari("24869412Q", 100.00);
        Usuari Pere = new Usuari("93712864N", 150.00);
        Usuari Enric = new Usuari("91732846F", 300.00);
        
        //Creació Subhasta
        Subhasta subhasta1 = new Subhasta(Joan, "Telèfon Mòbil");
    }

}
