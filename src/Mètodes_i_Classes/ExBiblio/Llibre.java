
package Mètodes_i_Classes.ExBiblio;

public class Llibre {

    String titol, autor, categoria;
    boolean prestec;
    double valoracio;
    int totalValoracions, anyPublicacio, nombreValoracions;

    public Llibre(String titol, String autor, int anyPublicacio, String categoria) {

        this.autor = autor;
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
        this.categoria = categoria;
        prestec = false;
        totalValoracions = 0;
        nombreValoracions = 0;
        valoracio = 0;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNombreValoracions() {
        return nombreValoracions;
    }

    public void setNombreValoracions(int nombreValoracions) {
        this.nombreValoracions = nombreValoracions;
    }

    public int getTotalValoracions() {
        return totalValoracions;
    }

    public void setTotalValoracions(int totalValoracions) {
        this.totalValoracions = totalValoracions;
    }

    public double getValoracio() {
        return valoracio;
    }

    public void setValoracio(double valoracio) {
        this.valoracio = valoracio;
    }

    public boolean isPrestec() {
        return prestec;
    }

    public void setPrestec(boolean prestec) {
        this.prestec = prestec;
    }

    public void afegirValoracio(int novaValoracio) {

        nombreValoracions++;
        totalValoracions += novaValoracio;
        valoracio = (double) totalValoracions / nombreValoracions;
    }

    public void prestar() {
        prestec = true;
    }

    public void retornar() {
        prestec = false;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "titol='" + titol + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", anyPublicacio=" + anyPublicacio +
                '}';
    }
}
