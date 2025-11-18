package Mètodes_i_Classes.PracticaT2;

import java.util.ArrayList;

public class Subhasta {

    private final Usuari propietari;
    private final String article;
    private boolean tancada;
    private boolean oberta;
    private boolean executada;
    private final ArrayList<Licitacio> licitacions = new ArrayList<>();

    public Subhasta(Usuari propietari, String article) {
        this.propietari = propietari;
        this.article = article;
    }

    public Usuari getUsuari() {
        return propietari;
    }

    public String getArticle() {
        return article;
    }

    public boolean isOberta() {
        return oberta;
    }

    public void setOberta(boolean oberta) {
        this.oberta = oberta;
    }

    public boolean isTancada() {
        return tancada;
    }

    public boolean isExecutada() {
        return executada;
    }

    public void setExecutada(boolean executada) {
        this.executada = executada;
    }

    public void tancarSubhasta(Subhasta subhasta) {
        tancada = true;
        System.out.println("Subhasta tancada.");
    }


    public Licitacio getLicitacioMax() {
        if (licitacions.isEmpty()) {
            return null;
        }
        return licitacions.get(licitacions.size() - 1);
    }

    public void licitar(Usuari usuari, double quantitat) {

        Licitacio novaLicitacio = new Licitacio(this, usuari, quantitat);
        boolean licitacioAcceptada = true;

        if (this.tancada) {
            System.out.println("ERROR: No es pot licitar, subhasta tancada.");
            licitacioAcceptada = false;
        }
        if (novaLicitacio.getUsuari().getCredit() < (novaLicitacio.getQuantitat())) {
            System.out.println("ERROR: Crèdit insuficient.");
            licitacioAcceptada = false;
        }
        if (usuari.equals(this.propietari)) {
            System.out.println("ERROR: L'usuari és el propietari de la subhasta.");
            licitacioAcceptada = false;
        }
        Licitacio major = this.getLicitacioMax();
        double minQuantitat = (major == null) ? 0.0 : major.getQuantitat();
        if (quantitat <= minQuantitat) {
            System.out.println("ERROR: La quantitat ha de ser major que " + minQuantitat + "€.");
            licitacioAcceptada = false;
        }
        if (licitacioAcceptada) {
            licitacions.add(novaLicitacio);
            usuari.afegirLicitacio(novaLicitacio);
            System.out.println("Licitació acceptada.");
        }
    }

    public void licitarNoQuantitat(Usuari usuari) {
        Licitacio max = this.getLicitacioMax();
        double quantitatBase = 0.0;
        if (max != null) {
            quantitatBase = max.getQuantitat();
        } else {
            quantitatBase = 0.0;
        }
        double novaQuantitatBase = quantitatBase + 1;
        licitar(usuari, novaQuantitatBase);
    }

    public void executar(Subhasta subhasta) {

        if (!this.tancada) {
            System.out.println("ERROR: No es pot executar la subhasta. No està tancada.");
        }
        if (this.executada) {
            System.out.println("ERROR: No es pot executar la subhasta. Ja està executada.");
        }
        Licitacio licitacioGuanyadora = this.getLicitacioMax();
        if (licitacioGuanyadora != null) {

            Usuari guanyador = licitacioGuanyadora.getUsuari();
            double importGuanyador = licitacioGuanyadora.getQuantitat();
            double nouCreditGuanyador = guanyador.getCredit() - importGuanyador;
            guanyador.setCredit(nouCreditGuanyador);

            Usuari venedor = this.propietari;
            double nouCreditPropietari = propietari.getCredit() + importGuanyador;
            propietari.setCredit(nouCreditPropietari);

            guanyador.afegirSubhastaGuanyada(this);
            this.executada = true;

            System.out.println("Subhasta executada, l'ID del guanyador és: " + guanyador.getId() + " i s'emporta l'article: " + this.article + " per: " + importGuanyador + "€.");
        }
    }
}
