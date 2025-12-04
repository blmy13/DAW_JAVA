package Herencia_i_Polimorfisme.ExEspai;

import java.util.ArrayList;

public class Candidat {

    private final String id, cognom, nom;
    ArrayList<Qualificable> proves = new ArrayList<>();

    public Candidat(String id, String cognom, String nom,  ArrayList<Qualificable> proves) {
        this.id = id;
        this.cognom = cognom;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public String getCognom() {
        return cognom;
    }

    public String getNom() {
        return nom;
    }

    public boolean estaQualificat() {
        boolean aprovat =  true;
        for (Qualificable p : proves) {
            if (!p.esQualificat()) {
                aprovat = false;
            }
        }
        return aprovat;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id='" + id + '\'' +
                ", cognom='" + cognom + '\'' +
                ", nom='" + nom + '\'' +
                ", proves=" + proves +
                '}';
    }
}
