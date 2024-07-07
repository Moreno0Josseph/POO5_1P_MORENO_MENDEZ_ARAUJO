package com.pooespol.Usuarios;

public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String user;
    private String contraseña;

    public Usuario(String nombre, String apellido, String correo, String user, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.user = user;
        this.contraseña = contraseña;
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

    public String getUser() {
        return user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public abstract String generarCorreo();

    public abstract int decidirSobreArticulo();
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
