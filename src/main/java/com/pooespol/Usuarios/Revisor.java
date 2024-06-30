package com.pooespol.Usuarios;

import com.pooespol.Interfaz.Articulo;

public class Revisor extends Usuario {
    private String especialidad;
    private int articulosRevisados;

    public Revisor(String nombre, String apellido, String correo, String especialidad, int articulosRevisados, TipoUsuario tipoUsuario) {
        super(nombre, apellido, correo, tipoUsuario);
        this.especialidad = especialidad;
        this.articulosRevisados = articulosRevisados;
    }

    public boolean revisarArticulo(Articulo articulo) {
        // Implementa la lógica real para revisar el artículo
        // Por ahora, se devuelve true como ejemplo
        return true;
    }

    // Getters y Setters
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
