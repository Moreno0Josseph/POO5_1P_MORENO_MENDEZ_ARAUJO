package com.pooespol.Usuarios;

/**
 * La clase Email representa un correo electrónico con detalles sobre la fecha y hora de envío,
 * el mensaje, el destinatario y el emisor.
 */
public class Email {
    private String fecha_subida;
    private String hora;
    private String mensaje;
    private Usuario destinatario;
    private Usuario emisor;

    /**
     * Crea un nuevo correo electrónico con los detalles especificados.
     *
     * @param fecha_subida La fecha en que se subió el correo.
     * @param hora         La hora en que se envió el correo.
     * @param mensaje      El contenido del mensaje del correo.
     * @param destinatario El destinatario del correo.
     * @param emisor       El emisor del correo.
     */
    public Email(String fecha_subida, String hora, String mensaje, Usuario destinatario, Usuario emisor) {
        this.fecha_subida = fecha_subida;
        this.hora = hora;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.emisor = emisor;
    }

    /**
     * Obtiene la fecha en que se subió el correo.
     *
     * @return La fecha en que se subió el correo.
     */
    public String getFecha_subida() {
        return fecha_subida;
    }

    /**
     * Establece la fecha en que se subió el correo.
     *
     * @param fecha_subida La nueva fecha en que se subió el correo.
     */
    public void setFecha_subida(String fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    /**
     * Obtiene la hora en que se envió el correo.
     *
     * @return La hora en que se envió el correo.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora en que se envió el correo.
     *
     * @param hora La nueva hora en que se envió el correo.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el contenido del mensaje del correo.
     *
     * @return El contenido del mensaje del correo.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el contenido del mensaje del correo.
     *
     * @param mensaje El nuevo contenido del mensaje del correo.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el destinatario del correo.
     *
     * @return El destinatario del correo.
     */
    public Usuario getDestinatario() {
        return destinatario;
    }

    /**
     * Establece el destinatario del correo.
     *
     * @param destinatario El nuevo destinatario del correo.
     */
    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Obtiene el emisor del correo.
     *
     * @return El emisor del correo.
     */
    public Usuario getEmisor() {
        return emisor;
    }

    /**
     * Establece el emisor del correo.
     *
     * @param emisor El nuevo emisor del correo.
     */
    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }
}
