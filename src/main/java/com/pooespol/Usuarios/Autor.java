package com.pooespol.Usuarios;

public class Autor {
    private String nombre;
    private String apellido;
    private String correo;
    private String afiliacion;
    private String departamento;

    public Autor(String nombre, String apellido, String correo, String afiliacion, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.afiliacion = afiliacion;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String generarCorreoSubidaArticulo() {
        return "Estimado " + getNombre() + ",\n\nGracias por someter su artículo.\n\nSaludos,\nEditorial";
    }

    public String generarCorreoArticuloAceptado(){
        return "Estimado " + getNombre() + ",\n\nSu articulo ha sido aceptado.\n\nSaludos,\nEditorial";
    }

    public String generarCorreoArticuloRechazadp(){
        return "Estimado " + getNombre() + ",\n\nSu articulo ha sido rechazado.\n\nSaludos,\nEditorial";
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", afiliacion='" + afiliacion + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}

