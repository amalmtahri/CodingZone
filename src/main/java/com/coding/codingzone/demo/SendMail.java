package com.coding.codingzone.demo;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {


    public static void send(String to,String msg) throws MessagingException {
       /* Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        final String myEmail = "codingzone.youcode@gmail.com";
        final String password = "codingzone123";

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myEmail, password);
                    }
                });

        Message sendMsg = prepareMessage(session,myEmail,to,msg);
        Transport.send(sendMsg);
        System.out.println("Message envoyeés avec succes !!");
        */
        final String username = "codingzone.youcode@gmail.com";
        final String password = "codingzone123";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    private static Message prepareMessage(Session session, String myEmail , String  to ,String message){

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(myEmail));
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            msg.setSubject("Welcome to YCInsurrance ");
            msg.setContent("<table>" +
                    "    <tr>" +
                    "        <td class=>" +message+
                    "            <table>" +
                    "                <tr>" +
                    "                    <td align='center' class='masthead'>" +
                    "                        <h1>Welcome to CodingZone</h1>" +
                    "</table>", "text/html; charset=utf-8");
            //msg.setText("Hello "+c.getFirstName() +  " "+c.getLastName()+ " \n We're excites to have you get started \n If you have any questions,just reply to this email \n \n YCteam  ");
            return  msg;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  null;
    }
}

