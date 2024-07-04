package com.pooespol.Interfaz;

import com.pooespol.Usuarios.*;
import com.pooespol.Usuarios.*;
import com.pooespol.Interfaz.*;
import java.util.ArrayList;
import java.util.List;

public class Editorial {
    private List<Usuario> usuarios;
    private List<Articulo> articulos;

    public Editorial() {
        usuarios = new ArrayList<>();
        articulos = new ArrayList<>();
        cargarUsuariosDesdeArchivo("C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Usuarios.txt");
    }

    private void cargarUsuariosDesdeArchivo(String rutaArchivo) {
        String contenido = LeerArchivo.leerDesdeArchivo(rutaArchivo);
        String[] usuariosArray = contenido.split("\\|");
        for (String usuario : usuariosArray) {
            String[] dato = usuario.split(",");
            String nombre = dato[0];
            String apellido = dato[1];
            String correo = dato[2];
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(dato[3]);
            String usuarioUser = dato[4];
            String usuarioContraseña = dato[5];

            switch (tipoUsuario) {
                case EDITOR:
                    usuarios.add(new Editor(nombre, apellido, correo, usuarioUser, usuarioContraseña));
                    break;
                case REVISOR:
                    usuarios.add(new Revisor(nombre, apellido, correo, 0, usuarioUser, usuarioContraseña));
                    break;
            }
        }
    }

    // Método para validar el usuario
    public Usuario validarUsuario(String user, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }

    // Método para someter un artículo
    public void someterArticulo(Articulo articulo, Autor autor) {
        articulo.setAutor(autor);
        articulos.add(articulo);
        enviarCorreoARevisores(articulo);
        System.out.println("Artículo sometido con éxito por " + autor.getNombre() + " " + autor.getApellido());
    }

    private void enviarCorreoARevisores(Articulo articulo) {
        int asignados = 0;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Revisor && asignados < 2) {
                Revisor revisor = (Revisor) usuario;
                System.out.println(revisor.generarCorreo());
                // Enviar correo (simulado)
                asignados++;
            }
        }
    }

    // Obtener todos los artículos
    public List<Articulo> obtenerArticulos() {
        return articulos;
    }

    // Agregar un usuario a la lista de usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Obtener la lista de usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}

