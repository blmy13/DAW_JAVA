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
                throw new IllegalArgumentException("Error; estàs intentant afegir un producte repetit");
            }
            i++;
        }
        productes.add(t);
    }

    public Producte consultarProducte(String id) throws IllegalArgumentException {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < productes.size()) {
            if (id.equals(productes.get(i).getId())) {
                trobat = true;
                return (productes.get(i));
            }
            i++;
        }
        throw new IllegalArgumentException("Error; el producte no s'ha trobat");

    }

    public void eliminarProducte(String id) throws IllegalArgumentException {
        consultarProducte(id);
        productes.remove(id);
    }
    public void mostrarTots() {
        for  (T t : productes) {
            System.out.println(t);
        }
    }
}
