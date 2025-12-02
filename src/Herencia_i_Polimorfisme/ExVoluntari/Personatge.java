package Herencia_i_Polimorfisme.ExVoluntari;

import java.util.ArrayList;

public abstract class Personatge implements Armable {

    private double puntsVida, puntsAtac;
    private boolean proteccioArquer, proteccioCosACos, atacArquer, atacCosACos;
    ArrayList<Armable> armes = new ArrayList();

    public Personatge(double puntsVida, double puntsAtac, boolean proteccioArquer, boolean proteccioCosACos, boolean atacArquer, boolean atacCosACos) {
        this.puntsVida = puntsVida;
        this.puntsAtac = puntsAtac;
        this.proteccioArquer = proteccioArquer;
        this.proteccioCosACos = proteccioCosACos;
        this.atacArquer = atacArquer;
        this.atacCosACos = atacCosACos;
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
        equiparPersonatge(this);
    }
    }

    
}
