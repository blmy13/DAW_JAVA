package Herencia_i_Polimorfisme.ExEmpleats;

public class EmpleatTempsParcial extends Empleat {
    
    private final double salariHora;
    private final int horesTreballades;

    public EmpleatTempsParcial(String nom, String id, int horesTreballades, double salariHora) {
        super(nom, id);
        this.salariHora = salariHora;
        this.horesTreballades = horesTreballades;
    }

    public double getSalariHora() {
        return salariHora;
    }

    public int getHoresTreballades() {
        return horesTreballades;
    }
    
    @Override
    public double calcularSalari(Empleat empleat) {
        double salari = this.horesTreballades * this.salariHora;
        return salari;
    }

}
