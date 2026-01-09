package Excepcions.Ex1;

public class Producte {

    private final String nom;
    private final double preu; //ha de ser superior a 0
    private final int quantitat; //ha de ser superior a 0

    public Producte(String nom, double preu, int quantitat) throws DadaInvalidaException {
        this.nom = nom;
        if (preu < 0) {
            throw new DadaInvalidaException("El preu ha de ser superior a 0");
        } else {
            this.preu = preu;
        }
        if (quantitat < 0) {
            throw new DadaInvalidaException("La quantitat ha de ser superior a 0");
        } else {
            this.quantitat = quantitat;
        }
    }

    public double calcularTotal() {
        return preu * quantitat;
    }

    @Override
    public String toString() {
        return "Producte: " + "nom=" + nom + ", preu=" + preu + ", quantitat=" + quantitat + '}';
    }

}
