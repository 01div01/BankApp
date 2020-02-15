package CONTROLLER;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendMail extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
			String emailid=request.getParameter("emailid");
			
			System.out.println(emailid);
			HttpSession hs=request.getSession(true);
			hs.setAttribute("emailid",emailid);
			System.out.println( hs.getAttribute("emailid")+"1jhkjfhjhfjhjhjj");
			String fromEmail="divcrb3@gmail.com"; //sender's mail id.
			String pwd="iloveu.maa";		//sender's mail pwd.
			String toEmail=emailid;  //reciever's mail id.
			
			
			
			String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
			String msg="http://localhost:5001/BANKAPP/Changefp.jsp"; //mail body
			
			//Creating Session Object
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
	
			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
					return new PasswordAuthentication(fromEmail, pwd);
					
				}
			});
			
	
			
			//Composing the Mail
			try {
			Message mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			mesg.setSubject(subject);  
			mesg.setText(msg);  
			
			//Sending the Mail
			Transport.send(mesg);
			System.out.println("Mail Sent!!");
			}
			catch(Exception e)
			{
				System.out.println("some mail problem");
			}
		
	}
}
	