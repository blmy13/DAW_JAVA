package Test.Exam;

import java.util.Arrays;

public class Jugador {
    private String nom;
    private int dorsal;
    private Estadistica[] estadistiques = new Estadistica[3];
    // 0 -> punts, 1 -> assistències, 2 -> rebots

    public Jugador(String nom, int dorsal) {
        this.nom = nom;
        this.dorsal = dorsal;
    }

    public String getNom() {
        return nom;
    }

    public int getDorsal() {
        return dorsal;
    }

    public Estadistica[] getEstadistiques() {
        return estadistiques;
    }

    public void setEstadistiques(Estadistica[] estadistiques) {
        this.estadistiques = estadistiques;
    }

    @Override
    public String toString() {
        return nom + " (" + dorsal + ") " + Arrays.toString(estadistiques);
    }
}
