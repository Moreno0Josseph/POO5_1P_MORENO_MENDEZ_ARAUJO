package com.pooespol.Usuarios;
import java.util.Scanner;
import com.pooespol.Interfaz.*;

/**
 * La clase Revisor representa a un revisor que es un tipo de usuario.
 * Hereda de la clase Usuario y proporciona implementaciones específicas para un revisor.
 */
public class Revisor extends Usuario {
    private int experiencia;

    /**
     * Crea un nuevo revisor con los detalles especificados.
     *
     * @param nombre       El nombre del revisor.
     * @param apellido     El apellido del revisor.
     * @param correo       El correo electrónico del revisor.
     * @param experiencia  Los años de experiencia del revisor.
     * @param user         El nombre de usuario del revisor.
     * @param contraseña   La contraseña del revisor.
     */
    public Revisor(String nombre, String apellido, String correo, int experiencia, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
        this.experiencia = experiencia;
    }

    /**
     * Obtiene los años de experiencia del revisor.
     *
     * @return Los años de experiencia del revisor.
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Genera un correo para notificar al revisor sobre un nuevo artículo asignado para revisar.
     *
     * @param art El artículo que necesita ser revisado.
     * @return Un mensaje de correo en formato de cadena.
     */
    @Override
    public String generarCorreo(Articulo art) {
        return "Estimado Revisor " + getNombre() + ", se le ha asignado un nuevo artículo para revisar.\n" + art.toString() + "\n\nSaludos,\nEditorial.";
    }

    /**
     * Solicita al revisor que proporcione comentarios sobre un artículo.
     *
     * @param entrada El objeto Scanner para leer la entrada del usuario.
     * @return Los comentarios del revisor en formato de cadena.
     */
    public String comentarSobreArticulo(Scanner entrada) {
        // Implementar la lógica para que el revisor proporcione comentarios
        System.out.print("Ingrese sus comentarios sobre el articulo: ");
        String comentario = entrada.nextLine();
        return comentario;
    }

    /**
     * Solicita al revisor que tome una decisión sobre la aceptación de un artículo.
     *
     * @param entrada El objeto Scanner para leer la entrada del usuario.
     * @return Un entero que representa la decisión del revisor: 1 para aceptar el artículo, 0 para rechazarlo.
     */
    @Override
    public int decidirSobreArticulo(Scanner entrada) {
        // El revisor da su decisión final sobre la aceptación del artículo
        System.out.print("\nIngrese 1 para aceptar el artículo o 0 para rechazarlo:  ");
        int decision = 0;
        if (entrada.hasNextInt()) {
            decision += entrada.nextInt();
            if (decision == 1) { // Está aceptando el artículo
                System.out.println("\nEl artículo ha sido aceptado!\n");
            } else if (decision == 0) { // Está rechazando el artículo
                System.out.println("\nEl artículo ha sido rechazado.\n");
            }
        } else {
            System.out.println("\nFormato invalido de dato\n");
        }
        return decision;
    }

    /**
     * Devuelve una representación en forma de cadena del revisor.
     *
     * @return Una cadena que representa al revisor.
     */
    @Override
    public String toString() {
        return super.toString() +
                "Experiencia=" + experiencia + "\n";
    }

    /**
     * Guarda el comentario del revisor sobre un artículo en un archivo.
     *
     * @param comentario El comentario del revisor.
     * @param articulo   El artículo sobre el que se comenta.
     */
    public void guardarComentario(String comentario, Articulo articulo) {
        String rutaComentarios = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Comentarios.txt";
        String contenido = articulo.getTitulo() + "," + articulo.getAutor().getNombre() + "," + articulo.getAutor().getApellido() + "," + articulo.getCodigo() + "," + comentario + "|";
        EscribirArchivo.escribirEnArchivo(rutaComentarios, contenido);
    }
}

