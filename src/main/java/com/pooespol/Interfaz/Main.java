package com.pooespol.Interfaz;

import com.pooespol.Transacciones.EnviarCorreo;
import com.pooespol.Usuarios.Autor;
import com.pooespol.Usuarios.Editor;
import com.pooespol.Usuarios.Revisor;
import com.pooespol.Usuarios.Usuario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editorial editorial = new Editorial();
        Scanner scanner = new Scanner(System.in);

        // Revisores del archivo revisores.txt
        Revisor revisor1 = null;
        Revisor revisor2 = null;

        String contenido = LeerArchivo.leerDesdeArchivo("revisores.txt");
        if (!contenido.isEmpty()) {
            String[] revisorDatos = contenido.split("\\|");
            if (revisorDatos.length >= 2) {  // Asegurar que haya al menos dos revisores
                revisor1 = crearRevisor(revisorDatos[0]);
                revisor2 = crearRevisor(revisorDatos[1]);
            }
        }

        // Verificar si se han cargado correctamente los revisores
        if (revisor1 != null && revisor2 != null) {
            // Ejecutar la lógica de decisión sobre el artículo solo si hay revisores disponibles
            int decisionRevisor1;
            int decisionRevisor2;
            System.out.println("************ REVISOR 1 ************");
            decisionRevisor1 = revisor1.decidirSobreArticulo();
            System.out.println("************ REVISOR 2 ************");
            decisionRevisor2 = revisor2.decidirSobreArticulo();

            // Evaluar las decisiones de los revisores
            if (decisionRevisor1 == 1 && decisionRevisor2 == 1) {  // Ambos revisores aceptan el artículo
                System.out.println("Su artículo ha sido aceptado!");
                System.out.println("Generando comentarios de los revisores...");
                revisor1.GenerarComentario(contenido);  // Los revisores ingresan sus comentarios
                revisor2.GenerarComentario(contenido);
            } else {  // Al menos uno de los revisores rechaza el artículo
                System.out.println("Su artículo ha sido rechazado!");
                revisor1.GenerarComentario("Su artículo ha sido rechazado!" + contenido);
                revisor2.GenerarComentario("Su artículo ha sido rechazado!" + contenido);
            }

            // Escribir los comentarios en un archivo
            escribirComentariosEnArchivo("Datosrevision.txt", revisor1, revisor2);

        } else {
            System.out.println("No se pudieron crear los revisores. Verifica el archivo revisores.txt");
        }

        // Mostrar el menú principal
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Someter artículo");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume la línea

            switch (opcion) {
                case 1:
                    // Lógica para someter un artículo
                    someterArticulo(editorial, scanner, revisor1, revisor2);
                    break;

                case 2:
                    // Lógica para iniciar sesión
                    iniciarSesion(editorial, scanner);
                    break;

                case 3:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void someterArticulo(Editorial editorial, Scanner scanner, Revisor rev1, Revisor rev2) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su afiliación: ");
        String afiliacion = scanner.nextLine();
        System.out.print("Ingrese su departamento: ");
        String departamento = scanner.nextLine();
        Autor autor = new Autor(nombre, apellido, correo, afiliacion, departamento);

        System.out.print("Ingrese el título del artículo: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el resumen del artículo: ");
        String resumen = scanner.nextLine();
        Articulo articulo = new Articulo(titulo, resumen, autor);

        editorial.someterArticulo(articulo, autor, rev1, rev2); // somete el Articulo y envía correo a los revisores
    }

    private static void iniciarSesion(Editorial editorial, Scanner scanner) {
        System.out.print("Ingrese su usuario: ");
        String user = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        Usuario usuarioValidado = editorial.validarUsuario(user, contraseña);

        if (usuarioValidado != null) {
            System.out.println("Usuario validado: " + usuarioValidado.toString());

            if (usuarioValidado instanceof Revisor) {
                ((Revisor) usuarioValidado).decidirSobreArticulo();
            } else if (usuarioValidado instanceof Editor) {
                ((Editor) usuarioValidado).decidirSobreArticulo();
            }
        } else {
            System.out.println("Usuario no encontrado o contraseña incorrecta.");
        }
    }

    private static void escribirComentariosEnArchivo(String nombreArchivo, Revisor rev1, Revisor rev2) {
        // Implementa la lógica para escribir los comentarios en un archivo si es necesario
        // Puedes usar FileWriter u otra clase adecuada para escribir en archivos
        // Ejemplo básico:
        // FileWriter writer = new FileWriter(nombreArchivo);
        // writer.write(rev1.getComentario() + "\n");
        // writer.write(rev2.getComentario() + "\n");
        // writer.close();
    }

    private static Revisor crearRevisor(String datos) {
        String[] campos = datos.split(",");
        if (campos.length == 6) {
            String nombre = campos[0];
            String apellido = campos[1];
            String correo = campos[2];
            int experiencia = Integer.parseInt(campos[3]);
            String usuario = campos[4];
            String contraseña = campos[5];
            return new Revisor(nombre, apellido, correo, experiencia, usuario, contraseña);
        }
        return null;
    }
}