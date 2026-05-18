package Reps.SistemaPagaments.Entitats;

import Reps.Botiga.Pocio;
import Reps.SistemaPagaments.DAO.TransaccioDAO;
import Reps.SistemaPagaments.Entitats.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransaccioTest {
    @Test
    public void testCreacioTransaccioCorrecta() {
        //arrange
        EstrategiaPagament mockPayPal = new PagamentPaypal("test@gmail.com");

        //act
        Transaccio t = new Transaccio(150.50, mockPayPal);

        //assert
        assertEquals(150.50, t.getImportTransaccio(), "L'import de la transacció hauria de ser 150.50");
        assertNotNull(t.getEstrategia(),"L'estratègia de pagament no hauria de ser nul·la");

    }
    @Test
    public void testCreacioTransaccioIncorrectaLlançaExcepcio() {
        // 1. Arrange
        EstrategiaPagament mockPayPal = new PagamentPaypal("test1@gmail.com");

        // 2 & 3. Act & Assert
        Exception excepcio = assertThrows(IllegalArgumentException.class, () -> {
            Transaccio t = new Transaccio(-40.0, mockPayPal);
        });

        assertEquals("L'import no pot ser negatiu", excepcio.getMessage());
    }

    @Test
    public void testProcessamentPagamentCridaAlDao() throws Exception{
        //1. Arrange dao fals --> processador + injecció
        TransaccioDAO mockDao = mock(TransaccioDAO.class);
        EstrategiaPagament mockPaypal = new PagamentPaypal("test_mockito@gmail.com");
        ProcessadorPagaments processador = new ProcessadorPagaments(mockPaypal, mockDao);
        Transaccio transaccioProva = new Transaccio(100.0, mockPaypal);
        //act
        processador.executarCompra(transaccioProva);
        //assert
        verify(mockDao, times(1)).guardarTransaccio(transaccioProva);

    }

    @Test
    public void testExecutarCompraAmbImportInvalidLlançaExcepcio() throws Exception {
        //1. Arrange
        TransaccioDAO mockDao = mock(TransaccioDAO.class);
        EstrategiaPagament mockPaypal = new PagamentPaypal("test2_mockito@gmail.com");
        ProcessadorPagaments processador = new ProcessadorPagaments(mockPaypal, mockDao);

        Transaccio transaccioInvalida = new Transaccio(0.0, mockPaypal);
        //2.Act i assert
        assertThrows(PagamentInvalidException.class, () -> {
           processador.executarCompra(transaccioInvalida);
        });
        //assert extra
        verify(mockDao, never()).guardarTransaccio(any());

    }

}