package Herencia_i_Polimorfisme.ExAbstracta;

public abstract class Treballador {

    private final String nom;
    private final String cognom;
    private final String nss;

    public Treballador(String nom, String cognom, String nss) {
        this.nom = nom;
        this.cognom = cognom;
        this.nss = nss;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getNss() {
        return nss;
    }

    public void informacio() {
        System.out.println("- Nom del Treballador: \n\t" + this.getNom() + " " + this.getCognom());
        System.out.println("- Número de Seguretat Social del Treballador: \n\t" + this.getNss());
    }

    public abstract double ingressos();

}
