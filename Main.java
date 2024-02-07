import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Color darkGray = Color.decode("#1e293b");
    UIManager.put("OptionPane.background", darkGray);
    UIManager.put("Panel.background", darkGray);
    UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 20));
    UIManager.put("OptionPane.messageForeground", Color.WHITE);
    UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
    UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 20));
    Icon questionIcon = new ImageIcon("assets/Question.png");
    Icon informationIcon = new ImageIcon("assets/Information.png");
    Icon errorIcon = new ImageIcon("assets/Error.png");
    UIManager.put("OptionPane.questionIcon", questionIcon);
    UIManager.put("OptionPane.errorIcon", errorIcon);
    UIManager.put("OptionPane.informationIcon", informationIcon);
    UIManager.put("Button.font", new Font("Arial", Font.BOLD, 20));
    UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 20));

    ArrayList<Alumno> alumnos = new ArrayList<>();
    boolean continuar = true;

    while (continuar) {
      String numeroDeControl = JOptionPane.showInputDialog("Ingrese el número de control:");
      String nombre = InputValidator.validateString("Ingrese el nombre:");
      String apellidoPaterno = InputValidator.validateString("Ingrese el apellido paterno:");
      String apellidoMaterno = InputValidator.validateString("Ingrese el apellido materno:");
      char genero = InputValidator.validateGender("Ingrese el género (M/F):");
      int edad = InputValidator.validateAge("Ingrese la edad:");

      alumnos.add(new Alumno(nombre, edad, genero, numeroDeControl, apellidoPaterno, apellidoMaterno));
      JOptionPane.showMessageDialog(null,
          "Alumno Guardado con los siguientes datos:\n" + alumnos.get(alumnos.size() - 1).toString());

      int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro estudiante?", "Agregar Estudiante",
          JOptionPane.YES_NO_OPTION);
      if (opcion == JOptionPane.NO_OPTION) {
        continuar = false;
      }
    }
  }
}
