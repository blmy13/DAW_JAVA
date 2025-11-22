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

        //Mostra informacio i Augment de Sou
        for (Treballador t : treballadors) {
            if (t instanceof TreballadorBaseMesComissio treballadorAugment) { //no fa falta casting
                double souActual = treballadorAugment.getSouBase();
                double nouSou = souActual * 1.10;
            }
            t.informacio();
        }

        //Mostra tipus d'Empleat
        for (Treballador q : treballadors) {
            if (q instanceof TreballadorAssalariat) {
                System.out.println(q.getNom() + " " + q.getCognom() + ": Treballador Assalariat.");
            } else if (q instanceof TreballadorBaseMesComissio) {
                System.out.println(q.getNom() + " " + q.getCognom() + ": Treballador per Comissió amb sou base.");
            } else if (q instanceof TreballadorPerComissio) {
                System.out.println(q.getNom() + " " + q.getCognom() + ": Treballador per Comissió.");
            } else if (q instanceof TreballadorPerHores) {
                System.out.println(q.getNom() + " " + q.getCognom() + ": Treballador per Hores.");
            }


        }
    }

}
