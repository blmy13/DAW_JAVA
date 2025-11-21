package Herencia_i_Polimorfisme.ExAbstracta;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        //Creació Treballadors
        TreballadorAssalariat treballadorAss1 = new TreballadorAssalariat(350.00, "Jean", "Carlo", "007");
        TreballadorPerHores treballadorHrs1 = new TreballadorPerHores(8.00, 40, "Jose María", "Pinto", "008");
        TreballadorPerComissio treballadorCom1 = new TreballadorPerComissio(28.00, 65.95, "Isaac", "Cuenca", "009");
        TreballadorBaseMesComissio treballadorBmc1 = new TreballadorBaseMesComissio(300.00, 20, 49.99, "Manolo", "Lama", "013");
        
        //Afegir Treballadors ArrayList
        ArrayList<Treballador> treballadors = new ArrayList<>();
        treballadors.add(treballadorBmc1);
        treballadors.add(treballadorCom1);
        treballadors.add(treballadorHrs1);
        treballadors.add(treballadorAss1);
        
        //Mostra informacio
        for (Treballador t : treballadors) {
            t.informacio();
        }
    }

}
