package Test.Exam;

public class Estadistica {
    private String nom;
    private int valor; // 0..10

    public Estadistica(String nom, int valor) {
        this.nom = nom;
        this.valor = valor;
    }

    public String getNom() {
        return nom;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nom + ": " + valor;
    }
}
