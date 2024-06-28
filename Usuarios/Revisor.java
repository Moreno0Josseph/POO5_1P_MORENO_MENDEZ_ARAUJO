package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuarios;
import PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Interfaz.Articulo;

public class Revisor extends Usuario{
    private String especialidad;
    private int articulosRevisados;


    public Revisor(String nombre, String apellido, String correo, String especialidad, int articulosRevisados) {
        super(nombre, apellido, correo);
        this.especialidad = especialidad;
        this.articulosRevisados = articulosRevisados;
    }





    public boolean revisarArticulo(Articulo articulo){ //Acepta o rechaza el articulo sometido

        return true;
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getArticulosRevisados() {
        return articulosRevisados;
    }
    public void setArticulosRevisados(int articulosRevisados) {
        this.articulosRevisados = articulosRevisados;
    }
}
