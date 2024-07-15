package com.pooespol.Usuarios;

/**
 * La clase Autor representa a un autor con su información personal y profesional.
 */
public class Autor {
    private String nombre;
    private String apellido;
    private String correo;
    private String afiliacion;
    private String departamento;

    /**
     * Crea un nuevo autor con los detalles especificados.
     *
     * @param nombre       El nombre del autor.
     * @param apellido     El apellido del autor.
     * @param correo       El correo electrónico del autor.
     * @param afiliacion   La afiliación del autor.
     * @param departamento El departamento del autor.
     */
    public Autor(String nombre, String apellido, String correo, String afiliacion, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.afiliacion = afiliacion;
        this.departamento = departamento;
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del autor.
     *
     * @return El apellido del autor.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el correo electrónico del autor.
     *
     * @return El correo electrónico del autor.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene la afiliación del autor.
     *
     * @return La afiliación del autor.
     */
    public String getAfiliacion() {
        return afiliacion;
    }

    /**
     * Obtiene el departamento del autor.
     *
     * @return El departamento del autor.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Genera un correo de confirmación de subida de artículo.
     *
     * @return El correo de confirmación de subida de artículo.
     */
    public String generarCorreoSubidaArticulo() {
        return "Estimado " + getNombre() + ",\n\nGracias por someter su artículo.\n\nSaludos,\nEditorial";
    }

    /**
     * Genera un correo de aceptación de artículo.
     *
     * @return El correo de aceptación de artículo.
     */
    public String generarCorreoArticuloAceptado() {
        return "Estimado " + getNombre() + ",\n\nSu articulo ha sido aceptado.\n\nSaludos,\nEditorial";
    }

    /**
     * Genera un correo de rechazo de artículo.
     *
     * @return El correo de rechazo de artículo.
     */
    public String generarCorreoArticuloRechazadp() {
        return "Estimado " + getNombre() + ",\n\nSu articulo ha sido rechazado.\n\nSaludos,\nEditorial";
    }

    /**
     * Devuelve una representación en forma de cadena del autor.
     *
     * @return Una cadena que representa al autor.
     */
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
