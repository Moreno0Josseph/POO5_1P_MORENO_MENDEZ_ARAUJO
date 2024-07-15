package com.pooespol.Usuarios;
import java.util.Scanner;
import com.pooespol.Interfaz.*;

/**
 * La clase abstracta Usuario representa un usuario con su información personal.
 * Proporciona métodos para obtener la información del usuario y métodos abstractos para generar correos y tomar decisiones sobre artículos.
 */
public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String user;
    private String contraseña;

    /**
     * Crea un nuevo usuario con los detalles especificados.
     *
     * @param nombre       El nombre del usuario.
     * @param apellido     El apellido del usuario.
     * @param correo       El correo electrónico del usuario.
     * @param user         El nombre de usuario.
     * @param contraseña   La contraseña del usuario.
     */
    public Usuario(String nombre, String apellido, String correo, String user, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.user = user;
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUser() {
        return user;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Genera un correo para notificar sobre un artículo.
     *
     * @param art El artículo relacionado con el correo.
     * @return Un mensaje de correo en formato de cadena.
     */
    public abstract String generarCorreo(Articulo art);

    /**
     * Solicita al usuario que tome una decisión sobre la aceptación de un artículo.
     *
     * @param entrada El objeto Scanner para leer la entrada del usuario.
     * @return Un entero que representa la decisión del usuario.
     */
    public abstract int decidirSobreArticulo(Scanner entrada);
    
    /**
     * Devuelve una representación en forma de cadena del usuario.
     *
     * @return Una cadena que representa al usuario.
     */
    @Override
    public String toString() {
        return "Usuario, con Nombre = " + nombre + '\n' +
                "Apellido = " + apellido + '\n' +
                "Correo = " + correo + '\n' +
                "User = " + user + '\n';
    }
}
