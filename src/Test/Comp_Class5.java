package Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class canco implements Comparable<canco> {
    private final String nom;
    private final int plays;

    public canco(String nom, int plays) {
        this.nom = nom;
        this.plays = plays;
    }

    public String getNom() {
        return nom;
    }

    public int getPlays() {
        return plays;
    }

    @Override
    public String toString() {
        return String.format("NOM: %-15s  ||  PLAYS: %-7d%n", nom, plays);
    }


    @Override
    public int compareTo(canco o) {
        return Integer.compare(this.plays, o.plays);
    }
}

public class Comp_Class5 {
    public static void main(String[] args) {

        List<canco> playlist = new java.util.ArrayList<>(List.of(new canco("Could be Us", 85642), new canco("Au Pays du Cocaine", 765115), new canco("Ophelia", 126444)));
        Collections.sort(playlist);
        System.out.println(playlist);
        //Ordre alfabètic
        Comparator<canco> comparator = Comparator.comparing(canco::getNom);
        playlist.sort(comparator);
        System.out.println(playlist);
        //Ordre longitud títol
        playlist.sort(new Comparator<canco>() {
            @Override
            public int compare(canco o1, canco o2) {
                return o1.getNom().length() - o2.getNom().length();
            }
        });
        System.out.println(playlist);

    }
}
