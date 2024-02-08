import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Persistencia {

    public static void guardadoArrayList(ArrayList<Alumno> listaAlumnos, String nombreLista) {

        LocalDateTime fechaActual = LocalDateTime.now();
        String fechaFormat = fechaActual.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String archivoFecha = nombreLista + "_" + fechaFormat + ".txt";
        try (PrintWriter archivoEscrito = new PrintWriter(new FileWriter(archivoFecha))) {
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
