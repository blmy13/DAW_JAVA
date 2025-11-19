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
    public double calcularSalari(Empleat empleat) {
        this.getSalariMensual();
        return salariMensual;
    }
    
}
