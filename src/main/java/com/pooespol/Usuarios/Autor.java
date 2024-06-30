package com.pooespol.Usuarios;
import com.pooespol.Interfaz.*;
import java.util.ArrayList;
public class Autor {
    private String nombre;
    private String codigoUnico;
    private String apellido;
    private String correo;
    private String institucion;
    private String campo_de_investigacion;



    public Autor(String nombre, String codigoUnico, String apellido, String correo, String institucion,
            String campo_de_investigacion) {
        this.nombre = nombre;
        this.codigoUnico = codigoUnico;
        this.apellido = apellido;
        this.correo = correo;
        this.institucion = institucion;
        this.campo_de_investigacion = campo_de_investigacion;
    }




    public void someterArticulo(Articulo articulo){

    }


    public void  almacenar_archivo(String archivo) {
        // Implementación del método
    }

    


    public ArrayList<Revisor> someter_revision(boolean articulo) {
        
        // Implementación del método
        return null;
    }





    //Gettes and Setters
    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    
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
