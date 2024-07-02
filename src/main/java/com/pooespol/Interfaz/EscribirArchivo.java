package com.pooespol.Interfaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo {

    public static void escribirEnArchivo(String ruta, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(contenido);
            System.out.println("El archivo ha sido escrito correctamente en " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Usuarios.txt";
        String contenido = "Joseph,Moreno,jlmoreno@espol.edu.ec,AUTOR|Luis,Ponce,lponce@espol.edu.ec,REVISOR|Pedro,Martínez,pmartinez@espol.edu.ec,EDITOR";//casos de prueba

        escribirEnArchivo(ruta, contenido);
    }
}

