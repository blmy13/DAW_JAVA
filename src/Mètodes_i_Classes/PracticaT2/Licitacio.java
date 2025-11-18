package Mètodes_i_Classes.PracticaT2;

public class Licitacio {
    
    private final Subhasta subhasta;
    private final Usuari usuari;
    private final double quantitat;

    public Licitacio(Subhasta subhasta, Usuari usuari, double quantitat) {
        this.subhasta = subhasta;
        this.usuari = usuari;
        this.quantitat = quantitat;
    }

    public Subhasta getSubhasta() {
        return subhasta;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public double getQuantitat() {
        return quantitat;
    }
}
