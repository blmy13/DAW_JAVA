package Reps.Negoci.Persistència;


import Reps.Negoci.Entitats.Producte;

import java.util.List;

public interface ProducteDAO {
    void guardarInventari(List<Producte> productes);
}
