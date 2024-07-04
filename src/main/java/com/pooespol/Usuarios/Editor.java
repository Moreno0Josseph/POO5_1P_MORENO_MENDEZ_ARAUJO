package com.pooespol.Usuarios;

public class Editor extends Usuario {
    public Editor(String nombre, String apellido, String correo, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
    }

    @Override
    public String generarCorreo() {
        return "Estimado Editor " + getNombre() + ",\n\nTiene nuevos artículos para revisar.\n\nSaludos,\nEditorial";
    }

    @Override
    public void decidirSobreArticulo() {
        // Implementar la lógica para que el editor registre la decisión final sobre el artículo
        System.out.println("Registrando la decisión final sobre el artículo...");
    }
}

