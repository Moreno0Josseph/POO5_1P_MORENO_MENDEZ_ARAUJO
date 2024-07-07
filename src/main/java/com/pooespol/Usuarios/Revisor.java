package com.pooespol.Usuarios;
import java.util.Scanner;

import com.pooespol.Interfaz.EscribirArchivo;
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
    public String generarCorreo() {
        return "Estimado Revisor " + getNombre() + ",Se le ha asignado un nuevo artículo para revisar.\n\nSaludos,\nEditorial.";
    }

    @Override
    public int decidirSobreArticulo() {
        // Implementar la lógica para que el revisor proporcione comentarios y una decisión
        Scanner entrada = new Scanner(System.in);
        

        System.out.println("Proporcionando comentarios y decisión sobre el artículo...");
        System.out.print("Ingrese 1 para aceptar el artículo o 0 para rechazarlo:  ");;
        int decision = entrada.nextInt();
        if(decision == 1){                                  //Está aceptando el articulo
            System.out.println("El artículo ha sido aceptado!");
            
            
        }else if (decision ==0){                            //Está rechazando el articulo
            System.out.println("El artículo ha sido rechazado.");
            
        }
        return decision;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", experiencia=" + experiencia +
                '}';
    }
    public  String GenerarComentario(String comentario){
        String rutaComentarios= "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Datosrevision.txt";
        EscribirArchivo.escribirEnArchivo(rutaComentarios, comentario);
        return comentario;
    }
}

