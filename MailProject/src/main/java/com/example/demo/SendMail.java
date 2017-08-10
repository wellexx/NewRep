package com.example.demo;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
*/
public class SendMail {
	 
	
	private MailSender mailSender;

 
	public SendMail(){
		
	}
	
	public SendMail(MailParam parametri) {
		ApplicationContext context =
	             new ClassPathXmlApplicationContext("spring-gmail.xml");

		SendMail mm = (SendMail) context.getBean("SendMail");
	    /*    
		mm.sendMail("from@no-spam.com",
	    		   "to@no-spam.com",
	    		   "Testing123",
	    		   "Testing only \n\n Hello Spring Email Sender");
	      */
		
		parametri.setMailAddress(parametri.getMailAddress()); 
		parametri.setMailSubject(parametri.getMailSubject());
		parametri.setMailContent(parametri.getMailContent());
		mm.sendMail( parametri);
		
	}
/*	
	public SendMail(MailParam parametri){
	 
		try {
			MimeMessage message= sender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(message);
			
			helper.setTo(parametri.getMailAddress());
			helper.setText(parametri.getMailContent());
			helper.setSubject(parametri.getMailSubject());
			
			System.out.println("Poslao:"+parametri.getMailAddress());
			sender.send(message);
		
		}catch(Exception ex) {
			System.out.print(	ex.toString());
		}
	}
	*/ 
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(MailParam parametri) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("vedran.spiric@gmail.com");
		message.setTo(parametri.getMailAddress());
		message.setSubject(parametri.getMailSubject());
		message.setText(parametri.getMailContent());
		mailSender.send(message);
	}
    
}
