package Reps.SistemaPagaments.DAO;


import Reps.SistemaPagaments.Entitats.Transaccio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TransaccioFitxerDAO implements TransaccioDAO {

    @Override
    public void guardarTransaccio(Transaccio t) throws PersistenciaException { //true -> append, permet afegir text sense esborrar
        try (PrintWriter out = new PrintWriter(new FileWriter("transaccions_completades.txt", true))) {
            out.printf(" >> Transacció OK: %10.2f€ processada correctament.%n", t.getImportTransaccio());
        } catch (IOException e) {
            throw new PersistenciaException(" >> ERROR: No s'ha pogut accedir al disc per guardar la transacció.");
        }
    }
}
