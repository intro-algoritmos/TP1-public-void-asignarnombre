
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests de unidad para la clase Mensaje
 *
 * @author N. Aguirre
 * @version 0.1
 */
public class GRADING_MensajesTest
{
    
    private static final int NUM_MENSAJES_TEST = 99;
    
    @Test
    public void agregaLineaValida() throws java.io.IOException {
        for (int i = 0; i < NUM_MENSAJES_TEST; i++) {
            String fileName = "msgs/mensaje" + i + ".txt";
            Mensaje msg = MensajeReaderWriter.readMensaje(fileName);
            int lineasMsg = msg.cantLineas();
            String linea = "Hola, que tal";
        
            msg.agregarLinea(linea);
 
            assertEquals(1 + lineasMsg, msg.cantLineas());
            assertTrue(msg.repOK());
        }        
    }
    
    @Test
    public void agregaDosLineasValidas() throws java.io.IOException {
        for (int i = 0; i < NUM_MENSAJES_TEST; i++) {
            String fileName = "msgs/mensaje" + i + ".txt";
            Mensaje msg = MensajeReaderWriter.readMensaje(fileName);
            int lineasMsg = msg.cantLineas();
            String linea = "Hola";
            String linea2 = "que tal";
        
            msg.agregarLinea(linea);
            msg.agregarLinea(linea2);        
 
            assertEquals(2 + lineasMsg, msg.cantLineas());
            assertEquals(linea, msg.obtenerLinea(lineasMsg));
            assertEquals(linea2, msg.obtenerLinea(lineasMsg + 1));
            assertTrue(msg.repOK());
        }     
    }

    @Test
    public void agregaLineaPosValida() throws java.io.IOException {
        for (int i = 0; i < NUM_MENSAJES_TEST; i++) {
            String fileName = "msgs/mensaje" + i + ".txt";
            Mensaje msg = MensajeReaderWriter.readMensaje(fileName);
            int lineasMsg = msg.cantLineas();
            String linea = "Hola que tal";
            
            for (int j = 0; j <= lineasMsg; j++) {
                msg.agregarLinea(j, linea);
                
                assertEquals(1 + lineasMsg, msg.cantLineas());
                assertEquals(linea, msg.obtenerLinea(j));
                assertTrue(msg.repOK());
                
                msg.eliminarLinea(j);
            }
        }
    }

    @Test
    public void equalsMensajesDistintos() throws java.io.IOException {
        for (int i = 0; i < NUM_MENSAJES_TEST; i++) {
            for (int j = i + 1; j < NUM_MENSAJES_TEST; j++) {
                String fileNameI = "msgs/mensaje" + i + ".txt";
                Mensaje msg1 = MensajeReaderWriter.readMensaje(fileNameI);
                String fileNameJ = "msgs/mensaje" + j + ".txt";
                Mensaje msg2 = MensajeReaderWriter.readMensaje(fileNameJ);
                
                assertFalse(msg1.equals(msg2));
                assertFalse(msg2.equals(msg1)); 
            }
        }  
    }

    @Test
    public void equalsMensajesIguales() throws java.io.IOException {
        for (int i = 0; i < NUM_MENSAJES_TEST; i++) {
            String fileName = "msgs/mensaje" + i + ".txt";
            Mensaje msg1 = MensajeReaderWriter.readMensaje(fileName);
            Mensaje msg2 = MensajeReaderWriter.readMensaje(fileName);
                
            assertTrue(msg1.equals(msg2));
            assertTrue(msg2.equals(msg1)); 
        }
    }      
    
}
