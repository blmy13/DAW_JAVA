package Reps.Analitzador;

public class Videojoc {
    private String titol;
    private String plataforma;
    private double vendesMilions;

    public Videojoc(String titol, String plataforma, double vendesMilions) {
        this.titol = titol;
        this.plataforma = plataforma;
        this.vendesMilions = vendesMilions;
    }

    public String getTitol() { return titol; }
    public String getPlataforma() { return plataforma; }
    public double getVendesMilions() { return vendesMilions; }

    @Override
    public String toString() {
        return titol + " (" + plataforma + ") - " + vendesMilions + "M venuts";
    }
}
