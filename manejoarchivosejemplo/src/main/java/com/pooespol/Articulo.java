package com.pooespol;

import java.util.ArrayList;

public class Articulo {
    private String codigoUnico;
    private String titulo;
    private String resumen;
    private String contenido;
    private ArrayList <String> palabrasClaves = new ArrayList<String> ();
    
    //Getters and Setters
    public String getCodigoUnico() {
        return codigoUnico;
    }
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
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
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public ArrayList<String> getPalabrasClaves() {
        return palabrasClaves;
    }
    public void setPalabrasClaves(ArrayList<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
   
    
}
