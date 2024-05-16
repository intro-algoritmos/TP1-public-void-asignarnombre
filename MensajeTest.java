
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
public class MensajeTest
{

    
    @Test
    public void testConstructor() {
        Mensaje msg = new Mensaje();
        
        assertEquals(0, msg.cantLineas());
        assertTrue(msg.repOK());
    }
    
    @Test
    public void agregaLineaValida() {
        Mensaje msg = new Mensaje();
        String linea = "Hola, que tal";
        
        msg.agregarLinea(linea);
        
        assertEquals(1, msg.cantLineas());
        assertTrue(msg.repOK());
    }
    
    @Test
    public void agregaDosLineasValidas() {
        Mensaje msg = new Mensaje();
        String linea = "Hola";
        String linea2 = "que tal";
        
        msg.agregarLinea(linea);
        msg.agregarLinea(linea2);
        
        assertEquals(2, msg.cantLineas());
        assertEquals(linea2, msg.obtenerLinea(1));
        assertTrue(msg.repOK());
    }
    

    @Test
    public void agregaLineaNull() {
        Mensaje msg = new Mensaje();
        String linea = null;
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.agregarLinea(linea),
           "Se espera que se lance excepción IllegalArgumentException");
    }

    @Test
    public void agregaLineaNoAscii() {
        Mensaje msg = new Mensaje();
        String linea = Character.toString((char) 150);
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.agregarLinea(linea),
           "Se espera que se lance excepción IllegalArgumentException");
    }

    @Test
    public void agregaLineaMuyLarga() {
        Mensaje msg = new Mensaje();
        char[] array = new char[100];
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.agregarLinea(new String(array)),
           "Se espera que se lance excepción IllegalArgumentException");
    }

    @Test
    public void agregaLineaPosValida() {
        Mensaje msg = new Mensaje();
        String linea = "Hola, que tal";
        
        msg.agregarLinea(0, linea);
        
        assertEquals(1, msg.cantLineas());
        assertTrue(msg.repOK());
    }

    @Test
    public void agregaLineaPosNull() {
        Mensaje msg = new Mensaje();
        String linea = null;
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.agregarLinea(0, linea),
           "Se espera que se lance excepción IllegalArgumentException");
    }

    @Test
    public void agregaLineaPosNoAscii() {
        Mensaje msg = new Mensaje();
        String linea = Character.toString((char) 150);
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.agregarLinea(0, linea),
           "Se espera que se lance excepción IllegalArgumentException");
    }

    @Test
    public void agregaLineaPosMuyLarga() {
        Mensaje msg = new Mensaje();
        char[] array = new char[100];
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.agregarLinea(0, new String(array)),
           "Se espera que se lance excepción IllegalArgumentException");
    }
    
    @Test
    public void eliminaLineaPosValida() {
        Mensaje msg = new Mensaje();
        String linea = "Hola, que tal";
        msg.agregarLinea(0, linea);
        
        msg.eliminarLinea(0);
        
        assertEquals(0, msg.cantLineas());
        assertTrue(msg.repOK());
    }

    @Test
    public void eliminaLineaMsgVariasLineas() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("hola");
        msg.agregarLinea("que tal");
        
        msg.eliminarLinea(1);
        
        assertEquals(1, msg.cantLineas());
        assertTrue(msg.repOK());     
    }

    @Test
    public void eliminaLineaMensajeVacio() {
        Mensaje msg = new Mensaje();
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.eliminarLinea(0),
           "Se espera que se lance excepción IllegalArgumentException");
    }

    @Test
    public void eliminarLineaPosNegativa() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("buenas!");
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.eliminarLinea(-1),
           "Se espera que se lance excepción IllegalArgumentException");
    }
    
    @Test
    public void eliminaLineaPosInvalidaPositiva() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("");
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.eliminarLinea(1),
           "Se espera que se lance excepción IllegalArgumentException");
    }
    
    @Test
    public void equalsMensajesIguales() {
        Mensaje msg1 = new Mensaje();
        msg1.agregarLinea("hola");
        msg1.agregarLinea("que tal");
        
        Mensaje msg2 = new Mensaje();
        msg2.agregarLinea(0, "que tal");
        msg2.agregarLinea(0, "hola");
                
        assertTrue(msg1.equals(msg2));
        assertTrue(msg2.equals(msg1));  
    }

    @Test
    public void equalsMensajesDistintos() {
        Mensaje msg1 = new Mensaje();
        msg1.agregarLinea("hola");
        msg1.agregarLinea("que tal");
        
        Mensaje msg2 = new Mensaje();
        msg2.agregarLinea(0, "que tal");
        msg2.agregarLinea(1, "hola");
                
        assertFalse(msg1.equals(msg2));
        assertFalse(msg2.equals(msg1));  
    }

    
    @Test
    public void equalsMensajeNulo() {
        Mensaje msg = new Mensaje();
        
        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> msg.equals(null),
           "Se espera que se lance excepción IllegalArgumentException");
    } 
    
    @Test
    public void toStringVacio() {
        Mensaje msg = new Mensaje();
        
        String result = msg.toString();
        
        assertEquals("", result);
    }

    @Test
    public void toStringUnaLinea() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("hola");
        
        String result = msg.toString();
        
        assertEquals("hola\n", result);
    }
    
    @Test
    public void toStringDosLineas() {
        Mensaje msg = new Mensaje();
        msg.agregarLinea("hola");
        msg.agregarLinea("chau");

        
        String result = msg.toString();
        
        assertEquals("hola\nchau\n", result);
    }
    
}
