package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Interfaz;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Main {
    public static void main(String[] args) {
        // Cargar propiedades desde el archivo config.properties
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("email_sender\\src\\main\\resources\\config.properties")) {
            // Cargar las propiedades
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

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
                    InternetAddress.parse("pgudino@espol.edu.ec, paulmgp2002@hotmail.com")
            );
            message.setSubject("Ayudantía");
            message.setText("Hola, soy Paul Gudino y estoy enviando este correo desde Java!");

            // Enviar el correo
            Transport.send(message);

            System.out.println("Correo enviado exitosamente!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
