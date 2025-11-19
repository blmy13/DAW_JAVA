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
    public double calcularSalari() {
        return this.horesTreballades * this.salariHora;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();
        System.out.print("Salari: " + calcularSalari() + "€\n");
        System.out.println("Tipus: Temps parcial");
    }

}
