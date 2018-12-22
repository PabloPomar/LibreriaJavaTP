
package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Emailer {
	
	public static Emailer instance;
	
	private Properties props;
	
	public static Emailer getInstance() throws IOException{
		if (instance==null){
			instance=new Emailer();
		}
		return instance;
	}
	
	private Emailer() throws IOException {
		
	
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.username", "testeodemailjavatp@gmail.com");
		props.put("mail.password","testeo1234");
		
		
	}
	
	public void send(String to, String subject, String body){

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				//return new PasswordAuthentication(username, password);
				return new PasswordAuthentication(props.getProperty("mail.username"), props.getProperty("mail.password"));
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to)); //"El mail al que queremos enviar"
			message.setSubject(subject); //"El motivo del mensaje"
			message.setText(body); //"El cuerpo del mensaje"

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}