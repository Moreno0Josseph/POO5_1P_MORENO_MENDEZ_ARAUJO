package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuarios;
import PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Interfaz.Articulo;

public class Editor extends Usuario{
    
    private String journal;



    
    public Editor(String nombre, String apellido, String correo, String journal) {
        super(nombre, apellido, correo);
        this.journal = journal;
    }









    public void publicarArticulo(Articulo articulo){

    }



    public boolean toma_decision() {  // Si se sube publica o no el articulo
        return true;
        // Implementación del método
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
