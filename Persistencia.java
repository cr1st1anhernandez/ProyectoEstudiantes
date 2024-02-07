import java.io.*;

public class Persistencia {

    public void guardar(Alumno alumno, String nombreArchivo) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            archivo.writeObject(alumno);
            System.out.println("Archivo guardado correctamente...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
