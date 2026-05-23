package Reps.MotorAntifrau.Test;

import Reps.MotorAntifrau.Entitats.TipusTransaccio;
import Reps.MotorAntifrau.Entitats.Transaccio;
import Reps.MotorAntifrau.Persistencia.TransaccioDAO;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TransaccioDAOTest {

    @Test
    public void testGuardarTransaccionsBatch_ExecutaTotElLotCorrectament() throws SQLException {

        // 1. ARRANGE
        // A. Mocks interfícies JDBC
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockPstmt = mock(PreparedStatement.class);

        // B. instruccions mock connexió
        when(mockConn.prepareStatement(anyString())).thenReturn(mockPstmt);

        // C. instanciar dao amb connexió falsa
        TransaccioDAO dao = new TransaccioDAO(mockConn);

        // D. llista de prova
        List<Transaccio> transaccionsProva = List.of(
                new Transaccio(100.0, "Andorra", TipusTransaccio.TARGETA),
                new Transaccio(250.0, "França", TipusTransaccio.TRANSFERENCIA)
        );

        // 2. ACT
        dao.guardarTransaccionsBatch(transaccionsProva);

        // 3. ASSERT
        // A. Verifica AutoCommit desactivat
        verify(mockConn, times(1)).setAutoCommit(false);
        // B. Verifica que el PreparedStatement ha afegit al lot 2 vegades
        verify(mockPstmt, times(2)).addBatch();
        // C. Verifica que s'ha executat el lot massiu (executeBatch) EXACTAMENT 1 vegada
        verify(mockPstmt, times(1)).executeBatch();
        // D. Verifica que s'ha fet el commit final EXACTAMENT 1 vegada
        verify(mockConn, times(1)).commit();
        // E. (Opcional) Verifica que NO s'ha cridat mai el mètode rollback()
        verify(mockConn, never()).rollback();
    }
}
