import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender
{
  public static void mailsent(String emailid,String key)
		{
  	  final String mailFrom = "projectsystem21@gmail.com";//"projectotpdetail@gmail.com";
		
		final String password = "ujhrlmnhbgbosgyk";//"qejkgxfenzjyzopo";
	
		final String to = emailid;
		
	Properties props = new Properties();
  	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,new javax.mail.Authenticator() 
	{
	  protected PasswordAuthentication getPasswordAuthentication() 
	  {
		return new PasswordAuthentication(mailFrom, password);
	  }
	});

	try 
	{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mailFrom));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
		message.setSubject("Password Key For Decode");
		message.setText("Dear User,"+ "\n\n Your Security Key is:   "+key);
		Transport.send(message);
		System.out.println("Email Send");
	} 
	catch (MessagingException e) 
	{
		throw new RuntimeException(e);
	}
  }
}	















/*import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender
{
  public static void mailsent(String emailid,String key)
  {
    final String username = "sharesystem2019@gmail.com";
	final String password = "share@123";
	final String to = emailid;

	Properties props = new Properties();
  	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,new javax.mail.Authenticator() 
	{
	  protected PasswordAuthentication getPasswordAuthentication() 
	  {
		return new PasswordAuthentication(username, password);
	  }
	});

	try 
	{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
		message.setSubject("Password Key For Decode");
		message.setText("Dear User,"+ "\n\n Your Security Key is:   "+key);
		Transport.send(message);
		System.out.println("Email Send");
	} 
	catch (MessagingException e) 
	{
		throw new RuntimeException(e);
	}
  }
}
*/	