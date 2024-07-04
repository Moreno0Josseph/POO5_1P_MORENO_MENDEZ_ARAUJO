package com.pooespol.Interfaz;
import com.pooespol.Usuarios.*;

public class Articulo {
    private String titulo;
    private String resumen;
    private Autor autor;

    public Articulo(String titulo, String resumen, Autor autor) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "titulo='" + titulo + '\'' +
                ", resumen='" + resumen + '\'' +
                ", autor=" + autor +
                '}';
    }
}

