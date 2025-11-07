package Mètodes_i_Classes.ExBiblio;

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
        System.out.println("S'ha afegit l'usuari '" + usuari.nom + "' amb ID " + usuari.identificador + ".");
    }

    public void mostrarLlibresPerCategoria(String categoria) {
        for (Llibre llibre : llibres) {
            if (llibre.getCategoria().equals(categoria)) {
                System.out.println("Llibres de la categoria: " + llibre.categoria);
                System.out.println(llibre.titol + " de " + llibre.autor + ".");
            }
        }
    }

    public Llibre cercarLlibrePerTitol(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equals(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public void prestarLlibre(String titol, Usuari usuari) {
        Llibre llibre = cercarLlibrePerTitol(titol);
        if (llibre != null) {
            if (!llibre.isPrestec()) {
                llibre.prestar();
                usuari.agafarLlibre(llibre);
                llibre.setPrestec(true);
                System.out.println("El llibre '" + llibre.titol + "' ha estat prestat a " + usuari.nom + ".");
            }
        }
    }

    public void retornarLlibre(String titol, Usuari usuari) {
        Llibre llibre = cercarLlibrePerTitol(titol);
        if (llibre != null) {
            if (llibre.isPrestec()) {
                llibre.retornar();
                usuari.retornarLlibre(llibre);
                llibre.setPrestec(false);
                System.out.println(usuari.nom + " ha retornat el llibre " + llibre.titol + ".");
            }
        }
    }

    public void mostrarLlibresEnPrestec() {
        System.out.print("Els llibres en préstec són: ");
        for (Llibre llibre : llibres) {
            if (llibre.isPrestec()) {
                System.out.print(llibre.titol + ", ");
            }
        }
        System.out.println("");

    }

    public void mostrarLlibresDispobibles() {
        System.out.print("Els llibres disponibles són: ");
        for (Llibre llibre : llibres) {
            if (!llibre.isPrestec()) {
                System.out.print(llibre.titol + ", ");
            }
        }
        System.out.println("");
    }

}
