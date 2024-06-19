package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuarios;
import PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Interfaz.Articulo;

public class Editor {
    private String nombre;
    private String apellido;
    private String correo;
    private String journal;

    public void publicarArticulo(Articulo articulo){

    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
}
