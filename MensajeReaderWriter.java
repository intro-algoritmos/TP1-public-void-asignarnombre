
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;


public class MensajeReaderWriter {
    
    public static void writeMensaje(Mensaje msg, String fileName) throws IOException {
        if (msg == null) throw new IllegalArgumentException("mensaje nulo");
        if (fileName == null) throw new IllegalArgumentException("nombre de archivo nulo");
        if ((new File(fileName)).isFile()) {
            throw new IllegalArgumentException("Archivo ya existe");
        }
        else {
            BufferedWriter file = new BufferedWriter (new FileWriter(fileName));
            for (int i = 0; i < msg.cantLineas(); i++) {
                file.write(msg.obtenerLinea(i));
                file.newLine();
            }
            file.close();
        }
    }
    
    public static Mensaje readMensaje(String fileName) throws IOException, java.io.FileNotFoundException {
        if (fileName == null) throw new IllegalArgumentException("nombre de archivo nulo");
        if (!(new File(fileName)).isFile()) {
            throw new IllegalArgumentException("No existe el archivo");
        }
        else {
            Mensaje resultado = new Mensaje();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                resultado.agregarLinea(line);
                line = reader.readLine();
            }
            reader.close();
            return resultado;
        }
    }
    
    public static void writeIntArray(int[] array, String fileName) throws IOException {
        if (array == null) throw new IllegalArgumentException("Arreglo nulo");
        if (fileName == null) throw new IllegalArgumentException("nombre de archivo nulo");
        if ((new File(fileName)).isFile()) {
            throw new IllegalArgumentException("Archivo ya existe");
        }
        else {
            BufferedWriter file = new BufferedWriter (new FileWriter(fileName));
            file.write(Arrays.toString(array));
            file.close();
        }
    }
    
    public static String readIntArray(String fileName) throws IOException {
        if (fileName == null) throw new IllegalArgumentException("nombre de archivo nulo");
        if (!(new File(fileName)).isFile()) {
            throw new IllegalArgumentException("No existe el archivo");
        }
        else {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();
            return line;
        }
    }
    
    
}