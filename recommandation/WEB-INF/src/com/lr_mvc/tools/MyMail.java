package com.lr_mvc.tools;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * classe de getion des mails
 * @author root
 * @version 1.0
 */
public class MyMail {
	
	/**
	 * verifie si le mail passé en parametre est conforme au format du mail
	 * @param mail
	 * @return boolean
	 */
	public static boolean isMail(String mail){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		Matcher m = p.matcher(mail.toUpperCase());
		return m.matches();
	}
	
	/**
	 * envoie du mail, et retourne vrai si l'envoie est effectuer, faux sinon 
	 * @param sender
	 * @param getter
	 * @param host
	 * @param hostServer
	 * @param messageText
	 * @param subject
	 * @return resultat
	 */
	public static boolean sendMail(String sender, String getter, String host, String hostServer, String messageText, String subject){
		boolean result = false;
		Properties properties = System.getProperties();
		properties.setProperty(hostServer, host);
		Session mailSession = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(getter));
			message.setSubject(subject);
			message.setText(messageText);
			// Send message
			Transport.send(message);
			result = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return result;
	}
	

}
