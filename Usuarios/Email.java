//package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuarios;

import PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuario;

public class Email{
    private String fecha_subida;
    private String hora;
    private String mensaje;
    private Usuario destinatario;
    private Usuario emisor;

    public Email(String fecha_subida, String hora, String mensaje, Usuario destinatario, Usuario emisor){
        this.fecha_subida = fecha_subida;
        this.hora = hora;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.emisor = emisor;
    }

    //getters and setters
    public String getFecha_Subida(){
        return fecha_subida;
    }

    public void setFecha_Subida(String fecha_subida){
        this.fecha_subida = fecha_subida;
    }

    public String getHora(){
        return hora;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public Usuario getDestinatario(){
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario){
        this.destinatario = destinatario;
    }

    public Usuario getEmisor(){
        return emisor;
    }

    public void setEmisor(Usuario emisor){
        this.emisor = emisor;
    }

}