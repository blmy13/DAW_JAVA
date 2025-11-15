package Mètodes_i_Classes.PracticaT2;

import java.util.ArrayList;

public class Usuari {

    private final String id;
    private double credit;
    private final ArrayList<Licitacio> litAcceptades = new ArrayList<>();
    private final ArrayList<Subhasta> subGuanyades = new ArrayList<>();
    private final ArrayList<Subhasta> subPropietat = new ArrayList<>();
    public Usuari(String id, double credit) {
        this.id = id;
        this.credit = credit;
    }

    public ArrayList<Licitacio> getLitAcceptades() {
        return litAcceptades;
    }

    public ArrayList<Subhasta> getSubGuanyades() {
        return subGuanyades;
    }

    public ArrayList<Subhasta> getSubPropietat() {
        return subPropietat;
    }

    public String getId() {
        return id;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void afegirLicitacio(Licitacio licitacio) {
        litAcceptades.add(licitacio);
    }
    public void afegirSubhastaGuanyada(Subhasta subhasta) {
        subGuanyades.add(subhasta);
    }
    public void afegirSubhastaEnPropietat(Subhasta subhasta) {
        subPropietat.add(subhasta);
        System.out.println("L'usuari amb ID: " + this.id + " ha creat una subhasta.");
    }
    public void mostrarUsuari() {
        System.out.println("Usuari amb ID: " + this.id);
        System.out.print("  - Propietari de (" + this.subPropietat.size() + "): ");
        if (this.subPropietat.isEmpty()) {
            System.out.println("Cap subhasta en propietat.");
        } else {
            for (Subhasta s : this.subPropietat) {
                System.out.print("[" + s.getArticle() + "] ");
            }
            System.out.println();
        }
        System.out.print("  - Guanyador de (" + this.subGuanyades.size() + "): ");
        if (this.subGuanyades.isEmpty()) {
            System.out.println("Cap subhasta guanyada.");
        } else {
            for (Subhasta s : this.subGuanyades) {
                System.out.print("[" + s.getArticle() + "] ");
            }
            System.out.println();
        }
        System.out.println("  - Licitacions Acceptades (" + this.litAcceptades.size() + "):");
        if (this.litAcceptades.isEmpty()) {
            System.out.println("    Cap licitació acceptada.");
        } else {
            for (Licitacio l : this.litAcceptades) {
                System.out.println("    -> Producte: " + l.getSubhasta().getArticle() + ", Quantitat: " + l.getQuantitat() + "€");
            }
        }
    }

}
