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
        String rutaRevisor = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Revisores.txt";
        String contenido = "Luis,Ponce,hivoraraujo6@gmail.com,luisp,666,REVISOR|Pedro,Martínez,pmartinez@espol.edu.ec,pemar,987,EDITOR|Belen,Murillo,jlmorenos04@gmail.com,belenm,777,REVISOR";//casos de prueba
        String datosRevisores = "Luis,Ponce,hivoraraujo6@gmail.com,10,luisp,123|Belen,Murillo,jlmorenos04@gmail.com,41,belenm,777";
        escribirEnArchivo(ruta, contenido);             // Creando archivo Usuarios.txt con los datos de los usuarios.
        escribirEnArchivo(rutaRevisor,datosRevisores); // Creando archivo Revisores.txt con los datos de los revisores.

    }
}
