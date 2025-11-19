package Herencia_i_Polimorfisme.ExEmpleats;

public class EmpleatTempsComplet extends Empleat{
    
    private final double salariMensual;

    public EmpleatTempsComplet(String nom, String id, double salariMensual) {
        
        super(nom, id);
        this.salariMensual = salariMensual;
    }

    public double getSalariMensual() {
        return salariMensual;
    }

    @Override
    public double calcularSalari() {
        this.getSalariMensual();
        return salariMensual;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();
        System.out.print("Salari: " + this.salariMensual + "€\n");
        System.out.println("Tipus: Temps complet" );
    }
}
