package com.pooespol.Interfaz;

import com.pooespol.Transacciones.*;
import com.pooespol.Usuarios.*;
import com.pooespol.Interfaz.*;
import com.pooespol.Interfaz.Articulo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editorial editorial = new Editorial();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Someter artículo");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume la linea

            switch (opcion) {
                case 1:
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

                    editorial.someterArticulo(articulo, autor);
                    break;

                case 2:
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
                    break;

                case 3:
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
}

