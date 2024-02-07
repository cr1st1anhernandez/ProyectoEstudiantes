import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.Font;

public class Main {
  public static void main(String[] args) {
    UIManager.put("OptionPane.background", java.awt.Color.lightGray);
    UIManager.put("Panel.background", java.awt.Color.lightGray);
    UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
    ArrayList<Alumno> alumnos = new ArrayList<>();
    boolean continuar = true;

    while (continuar) {
      int i = 0;
      String numeroDeControl = JOptionPane.showInputDialog("Ingrese el número de control:");
      String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
      String apellidoPaterno = JOptionPane.showInputDialog("Ingrese el apellido paterno:");
      String apellidoMaterno = JOptionPane.showInputDialog("Ingrese el apellido materno:");
      int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));

      alumnos.add(new Alumno(nombre, edad, 'M', numeroDeControl, apellidoPaterno, apellidoMaterno));
      JOptionPane.showMessageDialog(null, "Alumno Guardado con los siguientes datos:\n" + alumnos.get(i).toString());
      int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro estudiante?", "Agregar Estudiante",
          JOptionPane.YES_NO_OPTION);
      if (opcion == JOptionPane.NO_OPTION) {
        continuar = false;
      }
      i++;
    }
  }
}
