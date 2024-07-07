package com.pooespol.Usuarios;

import java.util.Scanner;

public class Editor extends Usuario {
    public Editor(String nombre, String apellido, String correo, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
    }

    @Override
    public String generarCorreo() {
        return "Estimado Editor " + getNombre() + ",\n\nTiene nuevos artículos para revisar.\n\nSaludos,\nEditorial";
    }

    @Override
    public int decidirSobreArticulo() {
        // Implementar la lógica para que el editor registre la decisión final sobre el artículo
       
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Proporcionando comentarios y decisión sobre el artículo...");
        System.out.print("Ingrese 1 para aceptar el artículo o 0 para rechazarlo:  ");;
        int decision = entrada.nextInt();
        if(decision == 1){                                           //Está aceptando el articulo     
            System.out.println("El artículo ha sido aceptado!");
            System.out.println("Registrando la decisión final sobre el artículo...");
        }else if (decision ==0){                                    //Está rechazando el articulo 
            System.out.println("El artículo ha sido rechazado.");
            System.out.println("Registrando la decisión final sobre el artículo...");
        }
        return decision;

    }
}

