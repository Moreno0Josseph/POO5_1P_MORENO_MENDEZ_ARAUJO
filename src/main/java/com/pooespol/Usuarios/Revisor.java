package com.pooespol.Usuarios;
import java.util.Scanner;
import com.pooespol.Interfaz.*;

public class Revisor extends Usuario {
    private int experiencia;

    public Revisor(String nombre, String apellido, String correo, int experiencia, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public String generarCorreo(Articulo art) {
        return "Estimado Revisor " + getNombre() + ", se le ha asignado un nuevo artículo para revisar.\n"+ art.toString()+"\n\n"+"Saludos,\nEditorial.";
    }

    public String comentarSobreArticulo(Scanner entrada){
        // Implementar la lógica para que el revisor proporcione comentarios
        System.out.print("Ingrese sus comentarios sobre el articulo: ");
        String comentario = entrada.nextLine();

        return comentario;
    }


    @Override
    public int decidirSobreArticulo(Scanner entrada) {
        
        //El revisor da su decisión final sobre la aceptación del articulo
        System.out.print("\nIngrese 1 para aceptar el artículo o 0 para rechazarlo:  ");
        int decision = 0;
        if(entrada.hasNextInt()){
            decision += entrada.nextInt();
            
            if(decision == 1){                                  //Está aceptando el articulo
                System.out.println("\nEl artículo ha sido aceptado!\n");
                
                
            }else if (decision == 0){                            //Está rechazando el articulo
                System.out.println("\nEl artículo ha sido rechazado.\n");
                
            }
        }else{
            System.out.println("\nFormato invalido de dato\n");
        }
        return decision;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Experiencia=" + experiencia + "\n";
    }

    
    public void guardarComentario(String comentario,Articulo articulo){
        String rutaComentarios= "C:\\Users\\USER\\Downloads\\POO\\PROYECTO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Comentarios.txt";
        String contenido = articulo.getTitulo()+","+articulo.getAutor().getNombre()+","+articulo.getAutor().getApellido()+","+articulo.getCodigo()+","+comentario+"|";
        EscribirArchivo.escribirEnArchivo(rutaComentarios, contenido);
    }
}

