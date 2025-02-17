/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.m_email_scheduling.main.spring.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Felipe Gutierrez
 *
 */

//@Service
//@Configuration
@Component
@EnableAsync
public class EmailService {

	@Autowired
	private MailSender mailSender;

	public void send(String from, String to, String subject, String message) {
		sendEmail(from,to,subject,message);
	}
	
	@Async
	public void sendAsync(String from, String to, String subject, String message) {
		sendEmail(from,to,subject,message);
	}
	
	private void sendEmail(String from, String to, String subject, String message){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailSender.send(mailMessage);	
	}
}
