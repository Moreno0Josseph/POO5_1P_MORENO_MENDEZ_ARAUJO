package com.pooespol.Usuarios;

public class Revisor extends Usuario {
    private int experiencia;

    public Revisor(String nombre, String apellido, String correo, int experiencia, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public String generarCorreo() {
        return "Estimado Revisor " + getNombre() + ",\n\nSe le ha asignado un nuevo artículo para revisar.\n\nSaludos,\nEditorial";
    }

    @Override
    public void decidirSobreArticulo() {
        // Implementar la lógica para que el revisor proporcione comentarios y una decisión
        System.out.println("Proporcionando comentarios y decisión sobre el artículo...");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", experiencia=" + experiencia +
                '}';
    }
}

