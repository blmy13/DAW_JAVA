package Mètodes_i_Classes;

import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Usuari> usuaris;
    ArrayList<Llibre> llibres;

    public Biblioteca() {

        usuaris = new ArrayList<>();
        llibres = new ArrayList<>();
    }

    public ArrayList<Usuari> getUsuaris() {
        return usuaris;
    }

    public ArrayList<Llibre> getLlibres() {
        return llibres;
    }

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
        System.out.println("S'ha afegit el llibre '" + llibre.titol + "' a la biblioteca.");
    }

    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    public void mostrarLlibresPerCategoria(String categoria) {
        for (Llibre llibre : llibres) {
            if (llibre.getCategoria().equals(categoria)) {
                System.out.println(llibre);
            }
        }
    }

    public Llibre cercarLlibrePerTitol (String titol) {
        for (Llibre llibre: llibres) {
            if (llibre.getTitol().equals(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public void prestarLlibre (String titol, Usuari usuari) {
        Llibre llibre = cercarLlibrePerTitol(titol);
        if (llibre != null) {
            if (!llibre.isPrestec()) {
                llibre.prestar();
                usuari.agafarLlibre(llibre);
            }
        }
    }

    public void retornarLlibre (String titol, Usuari usuari) {
        Llibre llibre = cercarLlibrePerTitol(titol);
        if (llibre != null) {
            if (llibre.isPrestec()) {
                llibre.retornar();
                usuari.retornarLlibre(llibre);
            }
        }
    }

}
