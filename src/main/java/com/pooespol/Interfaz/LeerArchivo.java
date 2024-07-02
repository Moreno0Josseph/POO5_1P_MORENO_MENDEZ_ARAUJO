package com.pooespol.Interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    public static String leerDesdeArchivo(String ruta) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
        return contenido.toString();
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Usuarios.txt";

        String contenido = leerDesdeArchivo(ruta);
        System.out.println("Contenido del archivo:\n" + contenido);
    }
}
