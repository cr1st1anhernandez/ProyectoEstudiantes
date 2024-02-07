import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class InputValidator {
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
