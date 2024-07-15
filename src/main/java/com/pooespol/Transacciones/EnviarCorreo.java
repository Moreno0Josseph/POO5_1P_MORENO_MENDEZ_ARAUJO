package com.pooespol.Transacciones;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * La clase EnviarCorreo proporciona métodos para enviar correos electrónicos utilizando
 * las propiedades configuradas en un archivo de configuración.
 */
public class EnviarCorreo {

    /**
     * Carga las propiedades del archivo de configuración.
     *
     * @return Un objeto Properties con las propiedades cargadas o null si ocurre un error.
     */
    private static Properties cargarPropiedades() {
        Properties prop = new Properties();
        try (InputStream input = EnviarCorreo.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("No se pudo encontrar el archivo config.properties");
                return null;
            }
            prop.load(input);
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo de configuración: " + ex.getMessage());
            ex.printStackTrace();
        }
        return prop;
    }

    /**
     * Envía un correo electrónico al destinatario especificado con el asunto y contenido dados.
     *
     * @param destinatario La dirección de correo electrónico del destinatario.
     * @param asunto       El asunto del correo electrónico.
     * @param contenido    El contenido del correo electrónico.
     */
    public static void enviarCorreo(String destinatario, String asunto, String contenido) {
        Properties prop = cargarPropiedades();
        if (prop == null) return;

        // Configuración de las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Obtener las credenciales desde el archivo de propiedades
        final String username = prop.getProperty("email.username");
        final String password = prop.getProperty("email.password");

        // Crear una sesión con las propiedades y la autenticación
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            message.setSubject(asunto);
            message.setText(contenido);

            // Enviar el correo
            Transport.send(message);

            System.out.println("Correo enviado exitosamente a " + destinatario);

        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo a " + destinatario + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
