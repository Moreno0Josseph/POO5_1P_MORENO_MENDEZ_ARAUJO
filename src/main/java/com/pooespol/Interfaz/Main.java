package com.pooespol.Interfaz;

import com.pooespol.Transacciones.EnviarCorreo;
import com.pooespol.Usuarios.*;
import com.pooespol.Interfaz.*;
import java.util.Scanner;

public class Main {

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
        System.out.print("Ingrese el código del artículo: ");
        String codigo = scanner.nextLine();
        Articulo articulo = new Articulo(titulo, resumen, autor, codigo);

        editorial.someterArticulo(articulo, autor, rev1, rev2); // somete el Articulo y envía correo a los revisores

    }

    private static Usuario iniciarSesion(Editorial editorial, Scanner scanner) {
        System.out.print("\nIngrese su usuario: ");
        String user = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        Usuario usuarioValidado = editorial.validarUsuario(user, contraseña);
        if (usuarioValidado != null){
            System.out.println("\n-----------Bienvenido "+usuarioValidado.getApellido()+" "+usuarioValidado.getNombre()+"--------------");
            return usuarioValidado;
        }else{
            System.out.println("\nUsuario no encontrado o contraseña incorrecta.");
            return null;
        }
    
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

    private static Editor crearEditor(String datos) {
        String[] campos = datos.split(",");
        if (campos.length == 6) {
            String nombre = campos[0];
            String apellido = campos[1];
            String correo = campos[2];
            String usuario = campos[3];
            String contraseña = campos[4];
            return new Editor(nombre, apellido, correo, usuario, contraseña);
        }
        return null;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Editorial editorial = new Editorial();

        //Creación y vaciar los archivos de revisiones
        Archivo archivoComentarios = new Archivo();
        Archivo archivoRespuestas = new Archivo();
        archivoComentarios.vaciarArchivoComentarios();
        archivoRespuestas.vaciarArchivoRespuestas();

        //generando los revisores
        String contenido = LeerArchivo.leerDesdeArchivo("revisores.txt");
        if (!contenido.isEmpty()) {
            String[] revisorDatos = contenido.split("\\|");
            if (revisorDatos.length >= 2) {  // Asegurar que haya al menos dos revisores
                Revisor revisor1 = crearRevisor(revisorDatos[0]);
                editorial.agregarUsuario(revisor1);
                Revisor revisor2 = crearRevisor(revisorDatos[1]);
                editorial.agregarUsuario(revisor2);
            }
        }

        //generando al editor
        String contenidoGenerarEditor = LeerArchivo.leerDesdeArchivo("Usuarios.txt");
        if (!contenidoGenerarEditor.isEmpty()) {
            String[] editorDatos = contenidoGenerarEditor.split("\\|");
            if (editorDatos.length >= 2) { 
                Editor edMain = crearEditor(editorDatos[1]);
                editorial.agregarUsuario(edMain);
            }
        }

        
        while(true){
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Someter artículo");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir\n");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            if(scanner.hasNextInt()){
                opcion += scanner.nextInt();
                scanner.nextLine();  // Consume la línea
            }else{
                System.out.println("Formato invalido de dato");
            } 

            //DownCasting de usuarios de la Editorial
            Revisor rev1 = (Revisor) editorial.obtenerUsuarios().get(0);
            Revisor rev2 = (Revisor) editorial.obtenerUsuarios().get(1);
            Editor ed = (Editor) editorial.obtenerUsuarios().get(2);

            //creacion archivo Comentarios
            archivoComentarios.crearArchivoComentarios();

            //creación archivo Respuestas
            archivoRespuestas.crearArchivoRespuestas();

            switch (opcion){
                 
                case 1:
                    
                    // Lógica para someter un artículo
                    someterArticulo(editorial, scanner, rev1, rev2);
                    System.out.println("\n-----------------------------------------------------------------------------------\n");
                    break;

                case 2:
                    //Lógica para iniciar sesión
                    Usuario usuarioValidado = iniciarSesion(editorial, scanner);
                    if(usuarioValidado instanceof Revisor){
                        Revisor rev = (Revisor) usuarioValidado;
                        System.out.println("\nTiene un articulo por revisar.");
                        System.out.println("\n"+editorial.obtenerArticulos().get(0).toString());

                        //generar comentario
                        String comentario = rev.comentarSobreArticulo(scanner);

                        //escritura en el archivoComentarios
                        String userRev = rev.getUser();
                        archivoComentarios.escribirAlArchivoComentarios(comentario, editorial.obtenerArticulos().get(0).getCodigo(), userRev);

                        //toma de decisión
                        int decisionMain = rev.decidirSobreArticulo(scanner);

                        //escribir decisión en archivoDecisión
                        String decisionEnString = String.valueOf(decisionMain);
                        archivoRespuestas.escribirAlArchivoComentarios(decisionEnString, editorial.obtenerArticulos().get(0).getCodigo(), userRev);
                        System.out.println("\n-----------------------------------------------------------------------------------\n");
                    }else if(usuarioValidado instanceof Editor){
                        Editor edValidado = (Editor) usuarioValidado;
                        System.out.println("Ingrese el código del articulo a revisar: ");
                        String codigo = scanner.nextLine();
                        String codigoArticuloEditorial = editorial.obtenerArticulos().get(0).getCodigo();
                        if(codigo.equals(codigoArticuloEditorial)){
                            archivoRespuestas.revisionArchivoObtenerRespuesta(archivoRespuestas, archivoComentarios, edValidado, editorial);
                        }else{
                            System.out.println("\nEste código no pertenece a algún articulo de nuestra Editorial.\n");
                        }
                        System.out.println("\n-----------------------------------------------------------------------------------\n");
                        
                    }
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
            opcion = 0;
            
        }
    }
}