import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main{

    public static void main(String[] args) {
        
        String to = "test@test.com";
        String from = "nassim.hadjarab@test.com";
        String email_subject = "jenkins pipeline";
        String email_body = "Hey\n\nThis is email is sent automatically after after a successful jenkins build.";
        
        //mailtrap credentials, consider using yours
        final String username = "fb74efbe07abce";
        final String password = "25e4e96a185b63";
        String host = "smtp.mailtrap.io";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");
        
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(email_subject);
            message.setText(email_body);
        
            Transport.send(message);

            System.out.println("E-mail sent successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}        
