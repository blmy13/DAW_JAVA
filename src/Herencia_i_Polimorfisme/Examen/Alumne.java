package Herencia_i_Polimorfisme.Examen;

import java.util.ArrayList;

public class Alumne {

    private final String nom;
    private final String dni;
    private final String cognom;
    private final ArrayList<Examen> examens = new ArrayList<>();

    public Alumne(String dni, String cognom, String nom) {
        this.nom = nom;
        this.dni = dni;
        this.cognom = cognom;
    }

    public String getNom() {
        return nom;
    }

    public boolean aprova() {
        boolean aprovat = true;
        for (Examen e : examens) {
            if (!e.aprova()) {
                aprovat = false;
            }
        }
        return aprovat;
    }

    public String getDni() {
        return dni;
    }

    public String getCognom() {
        return cognom;
    }

    public ArrayList<Examen> getExamens() {
        return examens;
    }

    public void agregarExamen(Examen examen) {
        examens.add(examen);
    }

    @Override
    public String toString() {
        return "DNI = " + dni + ", cognom = " + cognom + ", nom = " + nom + "\n";
    }

}
