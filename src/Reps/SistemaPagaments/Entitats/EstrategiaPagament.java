package Reps.SistemaPagaments.Entitats;

public interface EstrategiaPagament {
    void processarPagament(double quantitat) throws PagamentInvalidException;
}
