/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.handler;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bcorrales
 */
public class Correo {
    
    private static final String Username = "bryanulacit@gmail.com";
    private static final String PassWord = "Ulacit123";
    private static String Mensaje = "", Para = "", Asunto = "", Nombre = "", Cédula = "", Telefono = "";

    public static String getMensaje() {
        return Mensaje;
    }

    public static void setMensaje(String Mensaje) {
        Correo.Mensaje = Mensaje;
    }

    public static String getPara() {
        return Para;
    }

    public static void setPara(String Para) {
        Correo.Para = Para;
    }

    public static String getAsunto() {
        return Asunto;
    }

    public static void setAsunto(String Asunto) {
        Correo.Asunto = Asunto;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        Correo.Nombre = Nombre;
    }

    public static String getCédula() {
        return Cédula;
    }

    public static void setCédula(String Cédula) {
        Correo.Cédula = Cédula;
    }

    public static String getTelefono() {
        return Telefono;
    }

    public static void setTelefono(String Telefono) {
        Correo.Telefono = Telefono;
    }
    
    
    
    public static void EnviarCorreo(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Para));
            message.setSubject(Asunto);
            message.setText(Mensaje);
            Transport.send(message);
            System.out.println("Mensaje enviado");
        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
