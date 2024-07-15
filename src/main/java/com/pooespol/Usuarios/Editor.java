package com.pooespol.Usuarios;

import com.pooespol.Interfaz.*;
import java.util.Scanner;

/**
 * La clase Editor representa a un editor que es un tipo de usuario.
 * Hereda de la clase Usuario y proporciona implementaciones específicas para un editor.
 */
public class Editor extends Usuario {

    /**
     * Crea un nuevo editor con los detalles especificados.
     *
     * @param nombre       El nombre del editor.
     * @param apellido     El apellido del editor.
     * @param correo       El correo electrónico del editor.
     * @param user         El nombre de usuario del editor.
     * @param contraseña   La contraseña del editor.
     */
    public Editor(String nombre, String apellido, String correo, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
    }

    /**
     * Genera un correo para notificar al editor sobre nuevos artículos para revisar.
     *
     * @param art El artículo que necesita ser revisado.
     * @return Un mensaje de correo en formato de cadena.
     */
    @Override
    public String generarCorreo(Articulo art) {
        return "Estimado Editor " + getNombre() + ",\n\nTiene nuevos artículos para revisar.\n" + art.toString() + "\n\nSaludos,\nEditorial.";
    }

    /**
     * Solicita al editor que tome una decisión sobre la aceptación de un artículo.
     * 
     * @param entrada El objeto Scanner para leer la entrada del usuario.
     * @return Un entero que representa la decisión del editor: 1 para aceptar el artículo, 0 para rechazarlo.
     */
    @Override
    public int decidirSobreArticulo(Scanner entrada) {
        System.out.print("Ingrese 1 para aceptar el artículo o 0 para rechazarlo:  ");
        int decision = 0;
        if (entrada.hasNextInt()) {
            decision += entrada.nextInt();
            if (decision == 1) {
                System.out.println("El artículo ha sido aceptado!");
            } else if (decision == 0) {
                System.out.println("El artículo ha sido rechazado.");
            }
        } else {
            System.out.println("Formato invalido de dato");
        }
        return decision;
    }
}
