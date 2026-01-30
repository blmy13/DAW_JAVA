package Streams.Exercicis;

enum Model {
    BMW,
    AUDI,
    OPEL,
    HONDA,
    CITROEN
}

public class Vehicle {

    private String matricula;
    private Model model;
    private int quilometres;

    public Vehicle(String matricula, Model model, int quilometres) {
        this.matricula = matricula;
        this.model = model;
        this.quilometres = quilometres;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getQuilometres() {
        return quilometres;
    }

    public void setQuilometres(int quilometres) {
        this.quilometres = quilometres;
    }

    @Override
    public String toString() {
        return "[" + matricula + "," + model + "," + quilometres + ']';
    }

}
