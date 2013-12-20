package com.tg_mvc.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * classe de getion des mails
 * @author root
 * @version 1.0
 */
public class MyMail{
	
	
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
	

}
