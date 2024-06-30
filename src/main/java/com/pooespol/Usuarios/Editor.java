package com.pooespol.Usuarios;

import com.pooespol.Interfaz.Articulo;

public class Editor extends Usuario {

    private String journal;

    public Editor(String nombre, String apellido, String correo, String journal) {
        super(nombre, apellido, correo,TipoUsuario.EDITOR);
        this.journal = journal;
    }

    public void publicarArticulo(Articulo articulo) {
        // Implementación para publicar un artículo en el journal
        // Aquí podrías realizar operaciones relacionadas con la publicación del artículo
    }

    public boolean tomaDecision() {
        // Implementación para tomar la decisión de publicar un artículo
        // Aquí debes implementar la lógica real para evaluar si el artículo debe ser publicado
        return true; // Ejemplo simple, debe implementarse la lógica real
    }

    // Getter y Setter específico para journal
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
}
