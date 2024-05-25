package main.java.com.project.httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailHandler extends BaseHandler {
    @Override
    protected void handleDelete(HttpExchange exchange) throws IOException {

    }

    @Override
    protected void handlePut(HttpExchange exchange) throws IOException {

    }

    @Override
    protected void handlePost(HttpExchange exchange) throws IOException {

    }

    @Override
    protected void handleGet(HttpExchange exchange) throws IOException {
        String response;
        int statusCode =200;

        // hardcoding email
        String clientEmail = "dparab@simplit.in";

        // sending email
        try{
            sendMail(clientEmail);
            response = "Successfully sent.";
            sendResponse(exchange,response,statusCode);
        }catch(MessagingException e){
            e.printStackTrace();
            response = "Error ending email to the client.";
            statusCode = 500;
            sendResponse(exchange,response,statusCode);
        }

    }

    private void sendMail(String clientEmail) throws MessagingException{
        // SMTP settings
        String hostName = "smtp.gmail.com";
        String portNumber = "587";
        String username = "digveshparab123@gmail.com";
        String password = "fgyetdgmucrfbyyb";

        String from = "digveshparab123@gmail.com";

        // email properties
        Properties props = new Properties(); // creating properties object
        // This indicates the SMTP server requires authentication
        // when set to true means the client (application connecting to server) must provide username and password
        props.put("mail.smtp.auth","true");
        // this enables starttls meaning it takes existing insecure connection and upgrades it to a secure one using SSL/TLS
        // it ensure the email communication is encrypted
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", hostName); // specify the hostname of the SMTP server that will be used
        props.put("mail.smtp.port", portNumber); // set the port number where the SMTP will be listening 587 - TLS/STARTTLS

        // creating session
        // new Authenticator() {...} is an anonymous inner class that extends Authenticator class to provide authentication information
        Session session = Session.getInstance(props,new Authenticator(){
            @Override
            // creates and returns a PasswordAuthentication object initialized with the provided username and password.
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });

        // create message
        Message message = new MimeMessage(session);
        // InternetAddress represent email addressed according to internet standards
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO,InternetAddress.parse(clientEmail)[0]);
        message.setSubject("Test Email");
        message.setText("Hello client nice to meet you.");

        // Send message
        Transport.send(message);
    }
}
