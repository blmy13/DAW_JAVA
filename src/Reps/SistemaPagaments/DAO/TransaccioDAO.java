package Reps.SistemaPagaments.DAO;

import Reps.SistemaPagaments.Entitats.Transaccio;

import java.util.List;

public interface TransaccioDAO {
    void guardarTransaccio(Transaccio t) throws PersistenciaException;
    List<Transaccio> obtenirTransaccions() throws PersistenciaException;
}
