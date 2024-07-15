package com.pooespol.Usuarios;
import java.util.Scanner;

import com.pooespol.Interfaz.*;

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

    public abstract String generarCorreo(Articulo art);

    public abstract int decidirSobreArticulo(Scanner entrada);
    
    @Override
    public String toString() {
        return "Usuario, con Nombre = " + nombre + '\n' +
                "Apellido = " + apellido + '\n' +
                "Correo = " + correo + '\n' +
                "User = " + user + '\n';
    }
}
