
package Mètodes_i_Classes.ExBiblio;

import java.util.ArrayList;

public class Usuari {

    String nom, identificador;
    ArrayList<Llibre> llibresEnPrestec;

    public Usuari(String nom, String identificador) {
        this.nom = nom;
        this.identificador = identificador;
        llibresEnPrestec = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Llibre> getLlibresEnPrestec() {
        return llibresEnPrestec;
    }

    public void agafarLlibre(Llibre llibre) {
        llibresEnPrestec.add(llibre);
    }

    public void retornarLlibre(Llibre llibre) {
        llibresEnPrestec.remove(llibre);
    }
}


