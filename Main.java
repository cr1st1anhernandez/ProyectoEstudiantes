import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
      String nombre = validateString("Ingrese el nombre:");
      String apellidoPaterno = validateString("Ingrese el apellido paterno:");
      String apellidoMaterno = validateString("Ingrese el apellido materno:");
      char genero = validateGender("Ingrese el género (M/F):");
      int edad = validateAge("Ingrese la edad:");

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

  public static String validateString(String mensaje) {
    String nombre;
    do {
      nombre = JOptionPane.showInputDialog(mensaje);
      if (!Pattern.matches("[a-zA-Z]+", nombre)) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor válido (solo letras).", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (!Pattern.matches("[a-zA-Z]+", nombre));
    return nombre;
  }

  public static int validateAge(String mensaje) {
    int edad;
    do {
      try {
        edad = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        if (edad <= 0) {
          JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad válida (mayor que cero).", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad válida (número entero).", "Error",
            JOptionPane.ERROR_MESSAGE);
        edad = -1;
      }
    } while (edad <= 0);
    return edad;
  }

  public static char validateGender(String mensaje) {
    char genero;
    do {
      String entrada = JOptionPane.showInputDialog(mensaje);
      if (entrada.length() != 1 || (entrada.charAt(0) != 'M' && entrada.charAt(0) != 'F')) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un género válido (M o F).", "Error",
            JOptionPane.ERROR_MESSAGE);
        genero = '\0';
      } else {
        genero = entrada.charAt(0);
      }
    } while (genero == '\0');
    return genero;
  }
}
