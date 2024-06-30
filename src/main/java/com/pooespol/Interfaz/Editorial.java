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

    public TipoUsuario validarUsuario(ArrayList<String> nombreApellido) {
        // Aquí falta la lógica para validar realmente al usuario en la base de datos.
        // Por ahora, se creará un usuario ficticio.
        Usuario user = new Usuario("Miguel", "Bastos", "mb@homail.com", TipoUsuario.AUTOR);
        return user.getTipoUsuario();
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
}

