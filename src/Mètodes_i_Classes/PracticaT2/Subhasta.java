package Mètodes_i_Classes.PracticaT2;

import java.util.ArrayList;

public class Subhasta {

    private Usuari usuari;
    private String article;
    ArrayList<Licitacio> licitacions = new ArrayList<>();

    public Subhasta(Usuari usuari, String article) {
        this.usuari = usuari;
        this.article = article;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public String getArticle() {
        return article;
    }

    public void licitarSubhasta(Usuari usuari, double quantitat) {

        boolean licitacioAcceptada = false;
        if (licitacio.getUsuari().getCredit() >= licitacio.getQuantitat()) {
            licitacioAcceptada = true;
        } else {
            System.out.println("Crèdit insuficient.");
        }
            if (usuari.equals(licitacio.getUsuari())) {
                licitacioAcceptada = true;
            } else {
                System.out.println("L'usuari és propietari de la licitació.");
            }
                if () {
                    
                } else {
                    System.out.println("La quantitat és menor que l'anterior.");
                }
        if (licitacioAcceptada) {
            licitacions.add(Licitacio);
        }

    }
}
