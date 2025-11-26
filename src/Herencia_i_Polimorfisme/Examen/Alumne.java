package Herencia_i_Polimorfisme.Examen;

import java.util.ArrayList;

public class Alumne {

    private final String nom;
    private final String dni;
    private final String cognom;
    private final ArrayList<Examen> examens = new ArrayList<>();

    public Alumne(String nom, String dni, String cognom) {
        this.nom = nom;
        this.dni = dni;
        this.cognom = cognom;
    }

    public String getNom() {
        return nom;
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

    @Override
    public String toString() {
        return "Alumne{DNI = " + dni + ", cognom = " + cognom + ", nom = " + nom + "\nexamens = " + examens + '}';
    }
    
    
    
    
    
    

}
