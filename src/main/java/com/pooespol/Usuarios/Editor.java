package com.pooespol.Usuarios;

import com.pooespol.Interfaz.*;
import java.util.Scanner;

public class Editor extends Usuario {
    public Editor(String nombre, String apellido, String correo, String user, String contraseña) {
        super(nombre, apellido, correo, user, contraseña);
    }

    @Override
    public String generarCorreo(Articulo art) {
        return "Estimado Editor " + getNombre() + ",\n\nTiene nuevos artículos para revisar.\n"+ art.toString()+"\n\n"+"Saludos,\nEditorial.";
    }

    @Override
    public int decidirSobreArticulo(Scanner entrada) {
        //Scanner entrada = new Scanner(System.in);
        
        //El revisor da su decisión final sobre la aceptación del articulo
        System.out.print("Ingrese 1 para aceptar el artículo o 0 para rechazarlo:  ");
        int decision = 0;
        if(entrada.hasNextInt()){
            decision += entrada.nextInt();
            
            if(decision == 1){                                  //Está aceptando el articulo
                System.out.println("El artículo ha sido aceptado!");
                
                
            }else if (decision == 0){                            //Está rechazando el articulo
                System.out.println("El artículo ha sido rechazado.");
                
            }
        }else{
            System.out.println("Formato invalido de dato");
            
        }
        
        return decision;
    }
}

