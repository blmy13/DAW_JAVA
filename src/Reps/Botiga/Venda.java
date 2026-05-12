package Reps.Botiga;

public interface Venda {
    double getPreu();
    String getNomArticle();
    void aplicarDescompte(double percentatge);
}
