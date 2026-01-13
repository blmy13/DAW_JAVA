package Genèrics.ExInventari;

import java.util.ArrayList;

public class Inventari<T extends Producte> {

    ArrayList<T> productes = new ArrayList<>();

    public void afegirProducte(T t) throws IllegalArgumentException {

        boolean repetit = false;
        int i = 0;
        while (!repetit && i <= productes.size()) {
            if (t.getId().equals(productes.get(i).getId())) {
                repetit = true;
                if (repetit) {
                    throw new IllegalArgumentException "Error; estàs intentant afegir un producte repetit"; 
                }
            }
            i++;

        }
    }

    public void consultarProducte(T t) {

    }
}
