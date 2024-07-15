package com.pooespol.Interfaz;

import java.io.*;
import java.util.Scanner;

import com.pooespol.Transacciones.EnviarCorreo;
import com.pooespol.Usuarios.*;
 
public class Archivo {

    File archivo;
    Scanner entrada = new Scanner(System.in);

    public void crearArchivoComentarios(){
        archivo = new File("ComentariosDeArticulo.txt");
        try{
            if(archivo.createNewFile()){
                System.out.println("Archivo creado con exito.");

            }else{
                //System.out.println("Error aL crear el archivo "+archivo);
            }
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }

    public void crearArchivoRespuestas(){
        archivo = new File("RespuestasDeArticulo.txt");
        try{
            if(archivo.createNewFile()){
                System.out.println("Archivo creado con exito.");

            }else{
                //System.out.println("Error aL crear el archivo "+archivo);
            }
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }

    public void eliminarArchivo(){
            if(archivo.delete()){
                System.out.println("Archivo Cometarios eliminado con éxito.");

            }else{
                System.out.println("Error al eliminar el archivo Comentarios");
            }
    }

    public void escribirAlArchivoComentarios(String comentario, String codigo,String userRevisor){
        try{
            FileWriter escritura = new FileWriter(archivo.getAbsoluteFile(),true);
            BufferedWriter bWriter = new BufferedWriter(escritura);
            bWriter.write(comentario+","+codigo+","+userRevisor+"|");
            bWriter.close();
            
            System.out.println("Texto añadido a Comentarios con éxito");
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }


    //metodo para vaciar el archivo Comentarios
    public void vaciarArchivoComentarios(){
        try(FileOutputStream fos = new FileOutputStream("ComentariosDeArticulo.txt",false)){}
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //metodo para vaciar el archivo Respuestas
    public void vaciarArchivoRespuestas(){
        try(FileOutputStream fos = new FileOutputStream("RespuestasDeArticulo.txt",false)){}
        catch(IOException e){
            e.printStackTrace();
        }
    }
/* 
    //metodo para vaciar el archivo ArchivoDeEditorial
    public void vaciarArchivoEditorial(){
        try(FileOutputStream fos = new FileOutputStream("ArticulosDeEditorial.txt",false)){}
        catch(IOException e){
            e.printStackTrace();
        }
    }
*/

    //Metodo para revisar leer los datos del archivoRespuestas y comentarios
    public void revisionArchivoObtenerRespuesta(Archivo archivoRespuestas,Archivo archivoComentarios,Editor editor,Editorial editorial){

        
        String resultado = null;
        //BufferedReader lectura = new BufferedReader(lector);
        try (BufferedReader lectura = new BufferedReader(new FileReader("RespuestasDeArticulo.txt"))) {
            String linea;
            StringBuilder contenidoRespuestas = new StringBuilder();
            while ((linea = lectura.readLine()) != null) {
                String[] respuestasDatos = linea.split("|");
                for (String dato: respuestasDatos){
                    contenidoRespuestas.append(dato);
                }
            }
            resultado = contenidoRespuestas.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String respuestaUno = null;
        String respuestaDos = null;

        String[] campos = resultado.split("\\|"); 
        String[] elementosUno = campos[0].split(",");
        respuestaUno = elementosUno[0];

        String[] elementosDos = campos[1].split(",");
        respuestaDos = elementosDos[0];
//----------------------------------------------------------------------------------------------
        String comentarios = null;
        //BufferedReader lectura = new BufferedReader(lector);
        try (BufferedReader lectura = new BufferedReader(new FileReader("ComentariosDeArticulo.txt"))) {
            String linea;
            StringBuilder contenidoRespuestas = new StringBuilder();
            while ((linea = lectura.readLine()) != null) {
                String[] respuestasDatos = linea.split("|");
                for (String dato: respuestasDatos){
                    contenidoRespuestas.append(dato);
                }
            }
            comentarios = contenidoRespuestas.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String comentarioUno = null;
        String comentarioDos = null;

        String[] campos2 = comentarios.split("\\|"); 
        String[] elementosComentarioUno = campos2[0].split(",");
        comentarioUno = elementosComentarioUno[0];

        String[] elementosComentarioDos = campos2[1].split(",");
        comentarioDos = elementosComentarioDos[0];


        //.----------------------------------


        if(respuestaUno.equals(respuestaDos)){
            Articulo articulo = editorial.obtenerArticulos().get(0);
            String asunto = "RESPUESTA SOBRE LA ACEPTACiÓN DE SU ARTiCULO";

            if(respuestaUno.equals("0")){
                System.out.println("\nLos dos revisores han rechazado el articulo");
                System.out.println(articulo.toString());
                System.out.println();

                //proceso de enviar correo
                String mensajeParaCorreo = "Estimado "+articulo.getAutor().getApellido()+" "+articulo.getAutor().getNombre()+" le informamos que su articulo.\n "+articulo.toString()+" ha sido rechazado"+ "\n\n" +"Los comentarios de los revisores son: \n"+
                "Revisor 1: "+comentarioUno+"\n"+"Revisor 2: "+comentarioDos+"\n"+"Saludos,\nEditorial";
                EnviarCorreo.enviarCorreo(articulo.getAutor().getCorreo(), asunto, mensajeParaCorreo);
                System.out.println("Se acaba de enviar el correo al autor del articulo.");

            }else if(respuestaUno.equals("1")){
                System.out.println("\nLos dos revisores han aceptado el articulo");
                System.out.println(articulo.toString());
                System.out.println();

                //proceso de enviar correo
                String mensajeParaCorreo = "Estimado "+articulo.getAutor().getApellido()+" "+articulo.getAutor().getNombre()+" le informamos que su articulo "+articulo.toString()+" ha sido aceptado. ¡Felicidades!"+ "\n\n"+"Los comentarios de los revisores son: \n"+
                "Revisor 1: "+comentarioUno+"\n"+"Revisor 2: "+comentarioDos+"\n"+"Saludos,\nEditorial";
                EnviarCorreo.enviarCorreo(articulo.getAutor().getCorreo(), asunto, mensajeParaCorreo);
                System.out.println("Se acaba de enviar el correo al autor del articulo.");
            }else{
                System.out.println("Fallas en Editorial. Lo estamos resolviendo");
            }
        }else if(!respuestaUno.equals(respuestaDos)){
            System.out.println("\nLos revisores no se han puesto de acuerdo si aceptar o rechazar este articulo. Requieren tu decisión.\n");
            Articulo articulo = editorial.obtenerArticulos().get(0);
            
            String asunto = "RESPUESTA SOBRE LA ACEPTACiÓN DE SU ARTiCULO\n";

            int decision = editor.decidirSobreArticulo(entrada);

            if(decision==1){
                
                System.out.println();

                //proceso de enviar correo
                String mensajeParaCorreo = "Estimado "+articulo.getAutor().getApellido()+" "+articulo.getAutor().getNombre()+" le informamos que su articulo "+articulo.toString()+" ha sido aceptado. ¡Felicidades!"+ "\n\n"+"Los comentarios de los revisores son: \n"+
                "Revisor 1: "+comentarioUno+"\n"+"Revisor 2: "+comentarioDos+"\n"+"Saludos,\nEditorial";


                EnviarCorreo.enviarCorreo(articulo.getAutor().getCorreo(), asunto, mensajeParaCorreo);
                System.out.println("Se acaba de enviar el correo al autor del articulo.");
            }else if(decision==0){
                
                System.out.println();

                //proceso de enviar correo
                String mensajeParaCorreo = "Estimado "+articulo.getAutor().getApellido()+" "+articulo.getAutor().getNombre()+" le informamos que su articulo.\n "+articulo.toString()+" ha sido rechazado"+ "\n\n" +"Los comentarios de los revisores son: \n"+
                "Revisor 1: "+comentarioUno+"\n"+"Revisor 2: "+comentarioDos+"\n"+"Saludos,\nEditorial";

                EnviarCorreo.enviarCorreo(articulo.getAutor().getCorreo(), asunto, mensajeParaCorreo);
                System.out.println("Se acaba de enviar el correo al autor del articulo.");
            }
        }else{
            System.out.println();
        }
    
    }
}