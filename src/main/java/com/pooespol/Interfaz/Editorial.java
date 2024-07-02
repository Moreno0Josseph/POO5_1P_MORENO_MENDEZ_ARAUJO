package com.pooespol.Interfaz;

import java.util.ArrayList;
import java.util.Scanner;
import com.pooespol.Usuarios.TipoUsuario;
import com.pooespol.Usuarios.Usuario;

public class Editorial {
    private Usuario usuario;

    public Editorial() {
        System.out.println("Bienvenido a la Editorial POO - GRUPO 2");
    }

    public ArrayList<String> iniciarSesion() {
        ArrayList<String> nombreApellido = new ArrayList<>();
        System.out.println("Por favor ingrese su nombre: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        nombreApellido.add(nombre);
        System.out.println("Por favor, ingrese su apellido: ");
        String apellido = sc.nextLine();
        nombreApellido.add(apellido);

        return nombreApellido;
    }

    public Usuario validarUsuario(ArrayList<String> nombreApellido) {
        String contenido = LeerArchivo.leerDesdeArchivo("C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Usuarios.txt");
        String[] usuarios = contenido.split("\\|");
        for (String usuario : usuarios) {
            String[] dato = usuario.split(",");
            String nombre = dato[0];
            String apellido = dato[1];
            String correo = dato[2];
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(dato[3]);

            if (nombre.equals(nombreApellido.get(0)) && apellido.equals(nombreApellido.get(1))) {
                System.out.println("El usuario está dentro de la base de datos.");
                return new Usuario(nombre, apellido, correo, tipoUsuario);
            }
        }

        return null; // Usuario no encontrado
    }

    public void mostrarMenu(Usuario user) {
        if (user.getTipoUsuario() == TipoUsuario.AUTOR) {
            System.out.println("Bienvenido: " + user.toString());
            // Aquí se muestra lo que el autor usará en el editorial.
        } else {
            System.out.println("Bienvenido, este es el menú de " + user.getTipoUsuario().toString());
            // Aquí se muestra lo que usarán el Revisor o Editor.
        }
    }

    public static void main(String[] args) {
        Editorial editorial = new Editorial();
        ArrayList<String> nombreApellido = editorial.iniciarSesion();
        Usuario usuario = editorial.validarUsuario(nombreApellido);

        if (usuario != null) { // el usuario sí se encuentra en la base de datos.
            editorial.mostrarMenu(usuario);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
}

