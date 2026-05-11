package Reps.RPG.Main;

import Reps.RPG.Arsenal.Arma;
import Reps.RPG.Personatge.Boss;
import Reps.RPG.Personatge.Mag;
import Reps.RPG.Personatge.Personatge;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Personatge> dungeon = new ArrayList<>(List.of(new Personatge("Enric"), new Mag("Alison"), new Personatge("Marc"), new Boss("Samus Zero")));
        Mag mochi = new Mag("Mochi");
        int torn = 1;
        String a = "-";

        Arma arma = new Arma("Oathkeeper", 75.00);
        Arma arma1 = new Arma("Paralyzer", 20.0);
        mochi.equiparArma(arma);
        System.out.println("Mochi ha equipat " + arma.getNom());
        dungeon.get(3).equiparArma(arma1);
        System.out.println(dungeon.get(3).getNom() + " ha equipat " + arma1.getNom());
        dungeon.get(0).equiparArma(new Arma("Glock", 20.0));
        System.out.println(dungeon.get(0).getNom() + " ha equipat Glock");
        dungeon.get(2).equiparArma(new Arma("Bat", 25.0));
        System.out.println(dungeon.get(2).getNom() + " ha equipat Bat");
        System.out.println("Alison apareix...");

        while (!dungeon.isEmpty() && mochi.getHp() > 0) {
            Personatge enemicActual = dungeon.get(0);
            boolean finalitzat = false;
            finalitzat = enemicActual.getHp() == 0;

            System.out.println("\n\t\tCOMBAT");
            System.out.printf("%s%n", a.repeat(63));
            String armaEnemic = (enemicActual.getArma() == null) ? "No Arma" : enemicActual.getArma().getNom();
            System.out.printf("<< PARTICIPANT 1: %-10s | HP: %-5.2f | ARMA: %-10s >>%n", mochi.getNom(), mochi.getHp(), mochi.getArma().getNom());
            System.out.printf("<< PARTICIPANT 2: %-10s | HP: %-5.2f | ARMA: %-10s >>%n", enemicActual.getNom(), enemicActual.getHp(), armaEnemic);
            System.out.printf("%s%n", a.repeat(63));

            while (!finalitzat) {
                System.out.println("\n\t\t>>> Torn " + torn + " <<<");
                System.out.println(mochi.getNom() + " ataca!");
                double danyReal = 0;
                if (mochi.getMana() > 10) {
                    danyReal = mochi.llançarEncanteri(enemicActual);
                } else {
                    danyReal = mochi.atacar(enemicActual);
                }
                if (danyReal > 0) {
                    System.out.println(enemicActual.getNom() + " perd " + danyReal + " HP!");
                }

                if (enemicActual.getHp() == 0) {
                    System.out.println("\n" + enemicActual.getNom() + " ha mort!! " + mochi.getNom() + " és el guanyador!");
                    System.out.println("Mochi beu una misteriosa poció i restaura 40HP!!");
                    mochi.guanyarExp(50);
                    mochi.curar(40);
                    finalitzat = true;
                    dungeon.remove(0);
                    break;
                }
                System.out.println("\n" + enemicActual.getNom() + " ataca!");
                danyReal = 0;

                if (enemicActual instanceof Mag enemicMag) {

                    if (enemicMag.getMana() > 10) {
                        danyReal = enemicMag.llançarEncanteri(mochi);
                    } else {
                        danyReal = enemicMag.atacar(mochi);
                    }
                } else if (enemicActual instanceof Boss enemicBoss) {
                    danyReal = enemicBoss.atacar(mochi);
                } else {
                    danyReal = enemicActual.atacar(mochi);
                }

                System.out.println(mochi.getNom() + " perd " + danyReal + "HP!!");

                if (mochi.getHp() == 0) {
                    System.out.println("\n" + mochi.getNom() + " ha mort!! " + enemicActual.getNom() + " és el guanyador!");
                    finalitzat = true;
                }
                torn++;
            }
        }

        if (mochi.getHp() > 0) {
            System.out.println("\n <<< Mochi ha netejat el nivell!! >>>");
        } else {
            System.out.println("\n <<< GAME OVER!!! Mochi ha estat derrotat >>>");
        }

    }
}
