package Reps.Negoci.Entitats;

import Reps.Negoci.Persistència.ProducteDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;

public class ProducteDAOtxt implements ProducteDAO {

    @Override
    public void guardarInventari(List<Producte> productes) {
        File f = new File("inventari.txt");
        try (Formatter fr = new Formatter(f)) {
            for (Producte p : productes) {
                fr.format("%s%n", p.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
