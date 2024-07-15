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
        //enviarCorreoARevisores(articulo, rev1, rev2);
        System.out.println("\nArtículo sometido con éxito por " + autor.getNombre() + " " + autor.getApellido());

        //se guarda los articulos en un archivo txt "articulosDeEditorial"
        String ruta = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\ArticulosDeEditorial.txt";
        String datosArticulo = articulo.getTitulo()+","+articulo.getResumen()+","+autor.getNombre()+","+autor.getApellido()+","+autor.getCorreo()+","+articulo.getCodigo()+"|";
        EscribirArchivo.escribirEnArchivo(ruta, datosArticulo); 

        //Enviando el correo a los revisores
        enviarCorreoARevisores(articulo, rev1, rev2);
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