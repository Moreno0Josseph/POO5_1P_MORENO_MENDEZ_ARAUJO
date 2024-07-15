package com.pooespol.Interfaz;
import com.pooespol.Usuarios.*;

public class Articulo {
    private String titulo;
    private String resumen;
    private Autor autor;
    private String codigo;

    public Articulo(String titulo, String resumen, Autor autor, String codigo) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
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
        return "Articulo de Titulo = " + titulo + "\n" +
                "Autor = " + autor.getNombre() +" "+autor.getApellido() + "\n" + "Codigo = " + codigo + "\n";
                
    }
}

