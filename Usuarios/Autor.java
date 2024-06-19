
package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuarios;
import PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Interfaz.Articulo;
public class Autor {
    private String nombre;
    private String codigoUnico;
    private String apellido;
    private String correo;


    public void someterArticulo(Articulo articulo){

    }


    //Gettes and Setters
    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    private String institucion;
    private String campo_de_investigacion;

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
    public String getInstitucion() {
        return institucion;
    }
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    public String getCampo_de_investigacion() {
        return campo_de_investigacion;
    }
    public void setCampo_de_investigacion(String campo_de_investigacion) {
        this.campo_de_investigacion = campo_de_investigacion;
    }
}
