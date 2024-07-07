package com.pooespol.Interfaz;

import com.pooespol.Transacciones.EnviarCorreo;
import com.pooespol.Usuarios.*;
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
            if (dato.length >= 6) {
                String nombre = dato[0].trim();
                String apellido = dato[1].trim();
                String correo = dato[2].trim();
                TipoUsuario tipoUsuario;
                try {
                    tipoUsuario = TipoUsuario.valueOf(dato[5].trim());
                } catch (IllegalArgumentException e) {
                    System.err.println("Tipo de usuario inválido: " + dato[5]);
                    continue;
                }
                String usuarioUser = "";
                String usuarioContraseña = "";

                if (dato.length >= 6 && tipoUsuario != TipoUsuario.AUTOR) {
                    usuarioUser = dato[3].trim();
                    usuarioContraseña = dato[4].trim();
                }

                switch (tipoUsuario) {
                    case EDITOR:
                        usuarios.add(new Editor(nombre, apellido, correo, usuarioUser, usuarioContraseña));
                        break;
                    case REVISOR:
                        int experiencia = Integer.parseInt(dato[4].trim());
                        usuarios.add(new Revisor(nombre, apellido, correo, experiencia, usuarioUser, usuarioContraseña));
                        break;
                    default:
                        System.err.println("Tipo de usuario no soportado: " + tipoUsuario);
                        break;
                }
            } else {
                System.err.println("Datos incompletos para el usuario: " + usuario);
            }
        }
    }

    // Método para validar el usuario
    public Usuario validarUsuario(String user, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Editor || usuario instanceof Revisor) {
                if (usuario.getUser().equals(user) && usuario.getContraseña().equals(contraseña)) {
                    return usuario;
                }
            }
        }
        return null; // Usuario no encontrado o contraseña incorrecta
    }

    // Método para someter un artículo
    public void someterArticulo(Articulo articulo, Autor autor, Revisor rev1, Revisor rev2) {
        articulo.setAutor(autor);
        articulos.add(articulo);
        enviarCorreoARevisores(articulo, rev1, rev2);
        System.out.println("Artículo sometido con éxito por " + autor.getNombre() + " " + autor.getApellido());
    }

    void enviarCorreoARevisores(Articulo articulo, Revisor rev1, Revisor rev2) {
        String mensaje = "Se le ha asignado un nuevo artículo para revisar:\n\n" +
                         "Título: " + articulo.getTitulo() + "\n" +
                         "Resumen: " + articulo.getResumen() + "\n\n" +
                         "Saludos,\nEditorial";
        
        EnviarCorreo.enviarCorreo(rev1.getCorreo(), "Nuevo artículo para revisar", mensaje);
        EnviarCorreo.enviarCorreo(rev2.getCorreo(), "Nuevo artículo para revisar", mensaje);
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



