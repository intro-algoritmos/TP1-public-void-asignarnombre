
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
/**
 * Tests de unidad para las clases CodificadorMensajes
 * y DecodificadorMensajes
 */
public class GRADING_CodificadorDecodificadorTest
{
    
    private static final int NUM_MENSAJES_TEST = 99;
    
    @Test
    public void testMensajeSimple() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("hola");
        CodificadorMensajes cod = new CodificadorMensajes(msg);
        cod.codificarMensaje();
        assertEquals(3, cod.obtenerCodigoEncripcion().length);
        int[] expected = {4, 2, 0};
        assertEquals(0, java.util.Arrays.compare(expected,cod.obtenerCodigoEncripcion()));
    }
    
    
    @Test
    public void testMensajeCompuesto() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("hola");
        msg.agregarLinea("que tal");
        msg.agregarLinea("todo bien");
        CodificadorMensajes cod = new CodificadorMensajes(msg);
        cod.codificarMensaje();
        
        DecodificadorMensajes decod = new DecodificadorMensajes(cod.obtenerMensajeCodificado(), cod.obtenerCodigoEncripcion());
        decod.decodificarMensaje();
        Mensaje msg2 = decod.obtenerMensajeDecodificado();
        assertTrue(msg2.equals(msg));
    }
    
    @Test
    public void testMensajes() throws java.io.IOException {
        for (int i = 0; i < NUM_MENSAJES_TEST; i++) {
            String msgName = "msgs/mensaje" + i + ".txt";
            Mensaje msg = MensajeReaderWriter.readMensaje(msgName);
            String codeName = "msgs/encriptionCode" + i + ".txt";
            String code = MensajeReaderWriter.readIntArray(codeName);
            CodificadorMensajes cod = new CodificadorMensajes(msg);
            cod.codificarMensaje();
            assertEquals(code, Arrays.toString(cod.obtenerCodigoEncripcion()));
        
            DecodificadorMensajes decod = new DecodificadorMensajes(cod.obtenerMensajeCodificado(), cod.obtenerCodigoEncripcion());
            decod.decodificarMensaje();
            Mensaje msg2 = decod.obtenerMensajeDecodificado();
            assertTrue(msg2.equals(msg));
        }
    }
    
}
