package com.pooespol.Interfaz;
import com.pooespol.Usuarios.*;

/**
 * La clase Articulo representa un artículo con un título, resumen, autor y código.
 */
public class Articulo {
    private String titulo;
    private String resumen;
    private Autor autor;
    private String codigo;

    /**
     * Crea un nuevo artículo con los detalles especificados.
     *
     * @param titulo  El título del artículo.
     * @param resumen  El resumen del artículo.
     * @param autor  El autor del artículo.
     * @param codigo  El código del artículo.
     */
    public Articulo(String titulo, String resumen, Autor autor, String codigo) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.codigo = codigo;
    }

    /**
     * Obtiene el título del artículo.
     *
     * @return El título del artículo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del artículo.
     *
     * @param titulo El nuevo título del artículo.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el código del artículo.
     *
     * @return El código del artículo.
     */
    public String getCodigo(){
        return codigo;
    }

    /**
     * Establece el código del artículo.
     *
     * @param codigo El nuevo código del artículo.
     */
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    /**
     * Obtiene el resumen del artículo.
     *
     * @return El resumen del artículo.
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Establece el resumen del artículo.
     *
     * @param resumen El nuevo resumen del artículo.
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * Obtiene el autor del artículo.
     *
     * @return El autor del artículo.
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * Establece el autor del artículo.
     *
     * @param autor El nuevo autor del artículo.
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * Devuelve una representación en forma de cadena del artículo.
     *
     * @return Una cadena que representa el artículo.
     */
    @Override
    public String toString() {
        return "Articulo de Titulo = " + titulo + "\n" +
                "Autor = " + autor.getNombre() + " " + autor.getApellido() + "\n" + "Codigo = " + codigo + "\n";
    }
}
