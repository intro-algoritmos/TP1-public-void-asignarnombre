import java.util.ArrayList;

/**
 * Clase Mensaje: representa un mensaje en formato texto. 
 * El texto está almacenado en una lista de strings, donde cada
 * elemento de la lista representa una línea (renglón) del mensaje.
 * Ninguna línea excede los 80 caracteres (81 considerando el fin de
 * línea implícito al final de cada línea). Los mensajes sólo
 * contienen caracteres ASCII (es decir, el código ASCII de cada 
 * caracter del mensaje es menor a 128).
 * 
 * @author Agustin Morosi, Pablo Zucchi, Ulises Leguizamon, JoaquinPelays, Bautista Rodriguez
 * @version 02/06/2024
 */

public class Mensaje {
    
    /**
     * Longitud máxima de línea del mensaje
     */
    
    public static final int LONG_MAX_LINEA = 80; 

    /**
     * líneas del mensaje
     * Este campo es una lista que contiene las líneas del mensaje.
     * Cada línea es un elemento del ArrayList de tipo String.
     */
    private ArrayList<String> lineas; 

    /**
     * Constructor por defecto de la clase Mensaje().
     * Crea un mensaje vacío inicializando el ArrayList del campo líneas.
     */
    public Mensaje() {
        lineas = new ArrayList<String>();
    }

    /**
     * Retorna la cantidad de líneas del mensaje.
     * @return cantidad de líneas del mensaje.
     */
    public int cantLineas() {
        return lineas.size();
    }
    
    /**
     * Agrega una nueva línea al final del mensaje.
     * Precondición: la línea a agregar no debe ser null,
     * sólo puede contener caracteres ASCII, y 
     * su longitud debe ser menor o igual a 80.
     * Postcondición: la línea 'linea' se agrega al final 
     * de la lista de líneas.
     * @param linea es la línea a agregar.
     */
    public void agregarLinea(String linea) {
        if (linea == null) 
            throw new IllegalArgumentException("La línea a agregar no debe ser null.");
            
        if (linea.length() > LONG_MAX_LINEA)
            throw new IllegalArgumentException("Longitud inválida. La línea no debe tener más de 80 caracteres.");
            
        if (!esAscii(linea)) 
            throw new IllegalArgumentException("La línea a agregar contiene caracteres no ASCII.");
            
        lineas.add(linea); 
    }
    
    /**
     * Agrega una nueva línea al mensaje, en una posición específica.
     * Precondición: la línea a agregar no debe ser null,
     * sólo puede contener caracteres ASCII, y 
     * su longitud debe ser menor o igual a 80.
     * La posición debe estar entre 0 y la cantidad de líneas del mensaje.
     * Postcondición: la línea 'linea' se agrega a la lista de líneas, en la posición indicada.
     * @param linea es la línea a agregar.
     * @param pos es la posición en la cual se desea agregar la línea.
     */
    public void agregarLinea(int pos, String linea) {
        if (linea == null) 
            throw new IllegalArgumentException("La línea a agregar no debe ser null.");
            
        if (linea.length() > LONG_MAX_LINEA) 
            throw new IllegalArgumentException("Longitud inválida. La línea no debe tener más de 80 caracteres.");
            
        if (!esAscii(linea)) 
            throw new IllegalArgumentException("La línea a agregar contiene caracteres no ASCII.");
            
        if (pos < 0 || pos > lineas.size()) 
            throw new IllegalArgumentException("Posición inválida. Debe estar entre 0 y " + lineas.size());
            
        lineas.add(pos, linea); 
    }
    
    /**
     * Elimina la línea de una posición determinada del mensaje.
     * Precondición: pos debe estar entre cero y longitud (número de líneas) menos uno del mensaje.
     * @param pos es la posición (índice) de la línea a eliminar.
     */
    public void eliminarLinea(int pos) {
        if (pos < 0 || pos >= cantLineas())
            throw new IllegalArgumentException("Posición inválida. No existe línea con esa posición.");
            
        lineas.remove(pos); 
    }
    
    /**
     * Retorna la línea de una posición determinada del mensaje.
     * Precondición: pos debe estar entre cero y longitud (número de líneas) menos uno del mensaje.
     * @param pos es la posición (índice) de la línea a retornar.
     * @return la línea en la posición (índice) indicada.
     */
    public String obtenerLinea(int pos) {
        if (pos < 0 || pos >= cantLineas()) 
            throw new IllegalArgumentException("Posición inválida. No existe línea con esa posición.");
        return lineas.get(pos);
    }
    
    /**
     * Comprueba si una cadena está compuesta exclusivamente de caracteres ASCII.
     * Los caracteres ASCII tienen código entre 0 y 127.
     * Precondición: la línea a chequear no debe ser null.
     * @param linea es la línea a chequear.
     * @return true si la cadena 'linea' está compuesta exclusivamente de caracteres ASCII.
     */
    public boolean esAscii(String linea) { 
        if (linea == null) 
            throw new IllegalArgumentException("La línea a chequear no debe ser null.");
        boolean esAscii = true; 
        for (int i = 0; i < linea.length() && esAscii; i++) { 
            if (linea.charAt(i) > 127) {
                esAscii = false;
            }
        }
        return esAscii;     
    }   
    
     /**
     * Comprueba si un mensaje es igual a otro mensaje.
     * Un mensaje es igual a otro si tiene el mismo número de líneas, y cada
     * línea de cada mensaje coincide.
     * Precondición: otro debe ser distinto de null.
     * @param otro es el mensaje con el cual comparar el mensaje actual.
     * @return true ssi el mensaje es igual a otro (el parámetro).
     */
    public boolean equals(Mensaje otro) {
        if (otro == null) {     
        return false; 
        }
        if (this.cantLineas() != otro.cantLineas()) { //Se compara la cantidad de líneas en el objeto actual (this) con el otro
        return false; 
        }
        for (int i = 0; i < this.cantLineas(); i++) { 
            if (!this.obtenerLinea(i).equals(otro.obtenerLinea(i))) { 
            //actual (this.obtenerLinea(i)) con la línea i del otro mensaje (otro.obtenerLinea(i)). mediante el metodo equals
            return false;
            }
        }
        return true;
    }
    
    /**
     * Genera una representación de cadena de caracteres del mensaje completo.
     * @return una cadena conteniendo el mensaje completo.
     */
    public String toString()
    {
        String result = ""; 
        for (String linea: lineas) { 
            result = result + linea + "\n"; 
        }
        return result;
    }
    
    
    /**
     * Invariante de clase Mensaje. Chequea que la lista no sea nula, y todas sus líneas
     * cumplan con las restricciones de longitud y contenido.
     * @return true si el mensaje no es nulo, ninguna de sus líneas es nula, y todas son 
     * ASCII, de hasta 80 caracteres.
     */
    public boolean repOK() {
        if (lineas == null) 
            return false;
        else {
            boolean ok = true; 
            for (int i = 0; i < lineas.size() && ok; i++) { 
                String corriente = lineas.get(i); 
                if (corriente == null || !esAscii(corriente) || corriente.length() > LONG_MAX_LINEA) {
                    ok = false;
                }
            }
            return ok;
        }
    }
}