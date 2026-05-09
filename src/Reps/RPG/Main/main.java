package Reps.RPG.Main;

import Reps.RPG.Arsenal.Arma;
import Reps.RPG.Personatge.Personatge;

public class main {
    public static void main(String[] args) {
        Personatge mochi = new Personatge("Mochi");
        Personatge enemic = new Personatge("Samus Zero");
        boolean finalitzat = mochi.getHp() == 0 || enemic.getHp() == 0;
        int torn = 1;
        String a = "-";

        Arma arma = new Arma("Oathkeeper", 75.00);
        Arma arma1 = new Arma("Paralyzer", 20.0);
        mochi.equiparArma(arma);
        enemic.equiparArma(arma1);

        System.out.println("\n\t\tCOMBAT");
        System.out.printf("%s%n", a.repeat(63));
        System.out.printf("<< PARTICIPANT 1: %-10s | HP: %-5.2f | ARMA: %-10s >>%n", mochi.getNom(), mochi.getHp(), mochi.getArma().getNom());
        System.out.printf("<< PARTICIPANT 2: %-10s | HP: %-5.2f | ARMA: %-10s >>%n", enemic.getNom(), enemic.getHp(), enemic.getArma().getNom());
        System.out.printf("%s%n", a.repeat(63));

        while(!finalitzat) {
            System.out.println("\n\t\t>>> Torn " + torn + " <<<");
            System.out.println(mochi.getNom() + " ataca!");
            double danyReal = mochi.atacar(enemic);
            if (danyReal > 0) {
                System.out.println(enemic.getNom() + " perd " +danyReal + " HP!");
            }

            if (enemic.getHp() == 0) {
                System.out.println("\n" + enemic.getNom() + " ha mort!! " + mochi.getNom() +" és el guanyador!");
                finalitzat = true;
                break;
            }
            System.out.println("\n" + enemic.getNom() + " ataca!");
            danyReal = enemic.atacar(mochi);
            if (danyReal > 0) {
                System.out.println(mochi.getNom() + " perd " + danyReal + " HP!");
            }

            if (mochi.getHp() == 0) {
                System.out.println("\n" + mochi.getNom() + " ha mort!! " + enemic.getNom() + " és el guanyador!");
                finalitzat = true;
            }
            torn++;
        }
    }
}
