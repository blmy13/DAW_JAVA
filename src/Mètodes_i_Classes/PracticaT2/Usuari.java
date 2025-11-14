package Mètodes_i_Classes.PracticaT2;

public class Usuari {

    private String id;
    private double credit;

    public Usuari(String id, double credit) {
        this.id = id;
        this.credit = credit;
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

}
