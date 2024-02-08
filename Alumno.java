public class Alumno {
  private String nombre;
  private int edad;
  private char genero;
  private String numeroDeControl;
  private String apellidoPaterno;
  private String apellidoMaterno;

  public Alumno(String nombre, int edad, char genero, String numeroDeControl, String apellidoPaterno,
      String apellidoMaterno) {
    this.nombre = nombre;
    this.genero = genero;
    this.edad = edad;
    this.numeroDeControl = numeroDeControl;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setGenero(char genero) {
    this.genero = genero;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setNumeroDeControl(String numeroDeControl) {
    this.numeroDeControl = numeroDeControl;
  }

  public int getEdad() {
    return edad;
  }

  public char getGenero() {
    return genero;
  }

  public String getNombre() {
    return nombre;
  }

  public String getNumeroDeControl() {
    return numeroDeControl;
  }

  // Se te paso esto :) pero ya lo corregi //
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public String toString() {
    return "Número de control: " + numeroDeControl + "\nNombre: " + nombre + "\nApellido paterno: " + apellidoPaterno
        + "\nApellido materno: " + apellidoMaterno + "\nGénero: " + genero + "\nEdad: " + edad;
  }
}
