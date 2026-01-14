package Genèrics.ExInventari;

import java.util.ArrayList;

public class Inventari<T extends Producte> {

    ArrayList<T> productes = new ArrayList<>();

    public void afegirProducte(T t) throws IllegalArgumentException {

        boolean repetit = false;
        int i = 0;
        while (!repetit && i < productes.size()) {
            if (t.getId().equals(productes.get(i).getId())) {
                repetit = true;
            }

            i++;

        }
        if (repetit) {
            throw new IllegalArgumentException("Error; estàs intentant afegir un producte repetit");

        }
    }

    public T consultarProducte(String id) throws IllegalArgumentException {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < productes.size()) {
            if (id.equals(productes.get(i).getId())) {
                trobat = true;
            }
            i++;
        }
        if (trobat) {
            return productes.get(i);
        } else {
            throw new IllegalArgumentException("Error; no s'ha trobat el producte que busques.");
        }

    }

    public void eliminar(String id) {

        T producte = consultarProducte(id);
        productes.remove(producte);

    }

    public void mostrarTots() {
        for (T t : productes) {
            System.out.println(t);
        }
    }
}
