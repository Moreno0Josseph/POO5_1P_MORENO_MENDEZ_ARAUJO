package com.pooespol.Interfaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La clase EscribirArchivo proporciona métodos para escribir contenido en un archivo.
 */
public class EscribirArchivo {

    /**
     * Escribe el contenido en el archivo especificado por la ruta.
     *
     * @param ruta      La ruta del archivo donde se escribirá el contenido.
     * @param contenido El contenido que se escribirá en el archivo.
     */
    public static void escribirEnArchivo(String ruta, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(contenido);
            System.out.println("\nEl archivo ha sido escrito correctamente en " + ruta);
        } catch (IOException e) {
            System.err.println("\nError al escribir en el archivo: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    /**
     * Método principal para probar la escritura en archivos.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        String ruta = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Usuarios.txt";
        String rutaRevisor = "C:\\Users\\PeterRafa\\OneDrive - Universidad de Guayaquil\\Documentos\\PROYECTO_COLABORATIVO\\POO5_1P_MORENO_MENDEZ_ARAUJO\\Revisores.txt";
        String contenido = "Luis,Ponce,hivoraraujo6@gmail.com,luisp,666,REVISOR|Pedro,Martínez,pmartinez@espol.edu.ec,pemar,987,EDITOR|Belen,Murillo,jlmorenos04@gmail.com,belenm,777,REVISOR"; // casos de prueba
        String datosRevisores = "Luis,Ponce,hivoraraujo6@gmail.com,10,luisp,123|Belen,Murillo,jlmorenos04@gmail.com,41,belenm,777";
        escribirEnArchivo(ruta, contenido);             // Creando archivo Usuarios.txt con los datos de los usuarios.
        escribirEnArchivo(rutaRevisor, datosRevisores); // Creando archivo Revisores.txt con los datos de los revisores.
    }
}
