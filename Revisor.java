package com.pooespol;

public class Revisor {
    private String nombre;
    private String apellido;
    private String correo;
    private String especialidad;
    private int articulosRevisados;


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
