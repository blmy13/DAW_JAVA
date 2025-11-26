package Herencia_i_Polimorfisme.ExCompteBancari;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Creacio Objectes
        CompteCorrent cCorrent1 = new CompteCorrent(true, "468-655-999", 884612.78);
        CompteCorrent cCorrent2 = new CompteCorrent(false, "468-655-999");
        CompteEstalvis cEstalvis1 = new CompteEstalvis(0.02, "827-993-152", 2023714.89);
        CompteEstalvis cEstalvis2 = new CompteEstalvis(0.02, "747-943-552");
        CompteRentable cRentable1 = new CompteRentable(0.02, "588-328-451", 7845551.23);
        CompteRentable cRentable2 = new CompteRentable(0.02, "578-114-514");
        CompteCredit cCredit1 = new CompteCredit(true, "227-419-772", 12451333.02);
        CompteCredit cCredit2 = new CompteCredit(false, "444-952-736");

        ArrayList<CompteBancari> comptes = new ArrayList<>();
        
        comptes.add(cCorrent1);
        comptes.add(cCorrent2);
        comptes.add(cEstalvis1);
        comptes.add(cEstalvis2);
        comptes.add(cRentable1);
        comptes.add(cRentable2);
        comptes.add(cCredit1);
        comptes.add(cCredit2);
        
        //Mostrar Info
        for (CompteBancari c : comptes) {
            System.out.println(c);
        }
    }

}
