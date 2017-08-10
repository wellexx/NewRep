package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.MissingPathVariableException;

@Controller
public class MailController {
	SendMail sendMail;
	MailParam parametri;
	protected static final Logger logger = Logger.getLogger("MailController");
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST) 
	 
	public String getMail(@RequestParam String mailAddress, String mailSubject,String mailContent, @ModelAttribute MailParam mailParm) { 
	    parametri= new MailParam();

		parametri.setMailAddress(mailAddress); 
		parametri.setMailSubject(mailSubject);
		parametri.setMailContent(mailContent);
		
		//sendMail= new SendMail(parametri);
		sendMail= new SendMail(parametri);
		//sendMail.sendMail(parametri);
		
		String vrijednost = parametri.getMailContent();
		//String vrijednost1 = parametri.getMailContent();
		//String vrijednost2 = parametri.getMailSubject();
		
		if(vrijednost=="") {
			logger.info("Nema");
		}else {
			//logger.info(vrijednost);
			//logger.info(vrijednost1);
			//logger.info(vrijednost2);
			logger.info("Ima");
		}
		
		return "Smjesteno"; 

	}
	
	
}
