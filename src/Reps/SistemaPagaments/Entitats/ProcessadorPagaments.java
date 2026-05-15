package Reps.SistemaPagaments.Entitats;

import Reps.SistemaPagaments.DAO.PersistenciaException;
import Reps.SistemaPagaments.DAO.TransaccioDAO;

public class ProcessadorPagaments {
    //depèn de l'abstracció (interfície)
    private EstrategiaPagament estrategia;
    private final TransaccioDAO dao;

    //injecció per constructor(no pot existir processador sense estrategia)
    public ProcessadorPagaments(EstrategiaPagament estrategia, TransaccioDAO dao) {
        this.estrategia = estrategia;
        this.dao = dao;
    }

    //setter permet canviar estrategia
    public void setEstrategia(EstrategiaPagament estrategia){
        this.estrategia = estrategia;
    }

    public void executarCompra(Transaccio t) throws PagamentInvalidException, PersistenciaException {
        if (t.getImportTransaccio() <= 0) {
            throw new PagamentInvalidException(" >> ERROR: Import de transacció invàlid.");
        }
        t.getEstrategia().processarPagament(t.getImportTransaccio());
        dao.guardarTransaccio(t);
    }


}
