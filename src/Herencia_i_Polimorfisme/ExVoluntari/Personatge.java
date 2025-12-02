package Herencia_i_Polimorfisme.ExVoluntari;

import java.util.ArrayList;

public class Personatge {

    private double puntsVida, puntsAtac;
    private boolean proteccioArquer = false;
    private boolean proteccioCosACos = false;
    private boolean atacArquer = false;
    private boolean atacCosACos = false;
    ArrayList<Armable> armes = new ArrayList<>();

    public Personatge(double puntsVida, double puntsAtac) {
        this.puntsVida = puntsVida;
        this.puntsAtac = puntsAtac;
    }

    public void setPuntsVida(double puntsVida) {
        this.puntsVida = puntsVida;
    }

    public void setPuntsAtac(double puntsAtac) {
        this.puntsAtac = puntsAtac;
    }

    public void setProteccioArquer(boolean proteccioArquer) {
        this.proteccioArquer = proteccioArquer;
    }

    public void setProteccioCosACos(boolean proteccioCosACos) {
        this.proteccioCosACos = proteccioCosACos;
    }

    public void setAtacArquer(boolean atacArquer) {
        this.atacArquer = atacArquer;
    }

    public void setAtacCosACos(boolean atacCosACos) {
        this.atacCosACos = atacCosACos;
    }

    public void afegirArma(Armable a) {
        armes.add(a);
    }

    public double getPuntsVida() {
        return puntsVida;
    }

    public double getPuntsAtac() {
        return puntsAtac;
    }

    public boolean isProteccioArquer() {
        return proteccioArquer;
    }

    public boolean isProteccioCosACos() {
        return proteccioCosACos;
    }

    public boolean isAtacArquer() {
        return atacArquer;
    }

    public boolean isAtacCosACos() {
        return atacCosACos;
    }

    public ArrayList<Armable> getArmes() {
        return armes;
    }

    public void equipar() {
        for (Armable a : armes) {
            a.equiparPersonatge(this);
        }
    }

}
