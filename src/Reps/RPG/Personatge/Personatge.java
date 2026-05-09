package Reps.RPG.Personatge;

import Reps.RPG.Arsenal.Arma;

import java.util.Random;

public class Personatge {

    private String nom;
    private int nivell = 1;
    private double hp = 100.0;
    private double hpMax = 100.0;
    private Arma arma;

    public Personatge(String nom) {

        if (nom == null || nom.isBlank()) {
            throw new PersonatgeInvalidException("Error: Nom no vàlid");
        }
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public double getHp() {
        return hp;
    }

    public void rebreDany(double quantitat) {
        this.hp = Math.max(this.hp - quantitat, 0);
    }

    public void curar(double quantitat) {
       this.hp = Math.min(this.hp + quantitat, this.hpMax);
    }

    public Arma getArma() {
        return arma;
    }

    public void equiparArma(Arma novaArma) {
        this.arma = novaArma;
        System.out.println(this.nom + " ha equipat: " + arma.getNom());
    }
    public double atacar(Personatge enemic) {
        double danyBase = (this.arma == null) ? 5 : arma.getDanyBase();

        Random dau = new Random();
        int roll = dau.nextInt(100);
        if (roll < 15) {
            System.out.println(">> " + this.nom + " intenta atacar però falla!!");
            return 0.0;
        } else if (roll < 35) {
            double critic = danyBase * 2;
            System.out.println(">> " + this.nom + " ha aconseguit un cop crític!!");
            enemic.rebreDany(critic);
            return critic;
        } else {
            System.out.println(">> " + this.nom + " encerta el cop!");
            enemic.rebreDany(danyBase);
            return danyBase;
        }
    }
}
