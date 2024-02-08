import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    public static void guardadoArrayList(ArrayList<Alumno> listaAlumnos, String nombreLista) {
        try (PrintWriter archivoEscrito = new PrintWriter(new FileWriter(nombreLista))) {
            for (Alumno alumno : listaAlumnos) {
                archivoEscrito.println(alumno.getNombre() + "," + alumno.getApellidoPaterno() + ","
                        + alumno.getApellidoMaterno()
                        + "," + alumno.getNumeroDeControl() + "," + alumno.getEdad() + "," + alumno.getGenero());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
