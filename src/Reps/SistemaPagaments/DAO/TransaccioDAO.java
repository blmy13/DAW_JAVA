package Reps.SistemaPagaments.DAO;

import Reps.SistemaPagaments.Entitats.Transaccio;

public interface TransaccioDAO {
    void guardarTransaccio(Transaccio t) throws PersistenciaException;
}
