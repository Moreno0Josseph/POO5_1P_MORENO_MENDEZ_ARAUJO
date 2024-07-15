package com.pooespol.Interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * La clase LeerArchivo proporciona métodos para leer contenido desde un archivo.
 */
public class LeerArchivo {
   
    /**
     * Lee el contenido de un archivo especificado por la ruta.
     *
     * @param rutaArchivo La ruta del archivo que se va a leer.
     * @return Una cadena con el contenido del archivo, donde cada línea está separada por el carácter '|'.
     */
    public static String leerDesdeArchivo(String rutaArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("|");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }
}
