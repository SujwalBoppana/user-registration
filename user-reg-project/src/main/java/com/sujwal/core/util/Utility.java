package com.sujwal.core.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class Utility {
	
	public static String template = "<!DOCTYPE html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "<head>\r\n"
			+ "    <meta charset=\"UTF-8\">\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "    <title>User Registration Confirmation</title>\r\n"
			+ "</head>\r\n"
			+ "<body style=\"font-family: Arial, sans-serif;\">\r\n"
			+ "\r\n"
			+ "    <table style=\"max-width: 600px; margin: 0 auto; padding: 20px;\">\r\n"
			+ "        <tr>\r\n"
			+ "            <td>\r\n"
			+ "                <h2 style=\"color: #333;\">Welcome to Our Platform!</h2>\r\n"
			+ "                <p>Dear {{userName}},</p>\r\n"
			+ "                <p>Thank you for registering with us. Your account has been successfully created.</p>\r\n"
			+ "                <p>Here are your registration details:</p>\r\n"
			+ "                <ul>\r\n"
			+ "                    <li><strong>Username:</strong> {{userName}} </li>\r\n"
			+ "                    <li><strong>Email:</strong> {{email}} </li>\r\n"
			+ "                </ul>\r\n"
			+ "                <p>If you did not sign up for an account, please ignore this email.</p>\r\n"
			+ "                <p>Thank you for choosing our platform!</p>\r\n"
			+ "            </td>\r\n"
			+ "        </tr>\r\n"
			+ "        <tr>\r\n"
			+ "            <td style=\"padding-top: 20px; text-align: center; background-color: #f4f4f4;\">\r\n"
			+ "                <p style=\"color: #777;\">If you have any questions or need assistance, please contact us at javateamtest401@gmail.com.</p>\r\n"
			+ "            </td>\r\n"
			+ "        </tr>\r\n"
			+ "    </table>\r\n"
			+ "\r\n"
			+ "</body>\r\n"
			+ "</html>\r\n"
			+ "";

	public static void SendEmail(String userName,String email) {
		final String username = "test@gmail.com";
		final String password = "Test";
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.authmail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", 587);
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.port", 587);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("javateamtest401@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("User Registration");
			message.setContent(template.replace("{{userName}}", userName).replace("{{email}}", email),"text/html; charset=utf-8");
//			message.setText("This is a test email sent using JavaMail API.");
			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		SendEmail("Sujwal","test@gmail.com");
	}
}
