package Llistes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Persona {

    private final String nom;
    private final int edat;
    private final int telefon;

    public Persona(String nom, int edat, int telefon) {
        this.nom = nom;
        this.edat = edat;
        this.telefon = telefon;
    }

    public static void main(String[] args) {

        Persona persona1 = new Persona("Joan", 64, 608958665);
        ArrayList<Persona> persones = new ArrayList<>();
        long inici = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            persones.add(0, persona1);

        }
        for (int i = 1; i <= 50000; i++) {
            persones.remove(0);
        }
        long fi = System.nanoTime();

        long resultat = (fi - inici) / 1000000;
        System.out.println(resultat + " segons");

        LinkedList<Persona> persones1 = new LinkedList<>();
        long inici1 = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            persones1.add(0, persona1);
        }
        for (int i = 1; i <= 50000; i++) {
            persones1.remove(0);
        }
        long fi1 = System.nanoTime();
        long resultat1 = (fi1 - inici1) / 1000000;
        System.out.println(resultat1 + " segons");
        
        //EX2
        Persona[] taula = new Persona[10];
        for (int i = 0; i < taula.length; i++) {
            taula[i] = persona1;
        }
        List<Persona> llista = new ArrayList<>(Arrays.asList(taula));
        List<Persona> subllista = llista.subList(2, 5);
        subllista.clear();
    }
}
