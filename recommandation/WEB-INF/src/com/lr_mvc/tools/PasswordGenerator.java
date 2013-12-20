package com.lr_mvc.tools;

/**
 * calsse de gestion du password
 * @author root
 * @version
 */
public class PasswordGenerator {
	/**
	 * attribut de caractéres possibles dans un password
	 */
	private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	/**
	 * generation d'un password de longueur length
	 * @param length
	 * @return password
	 */
	public static String generatePassword(int length){
		String password = "";
		for(int i = 0; i< length; i++){
			int random = (int)(Math.random() * (chars.length()-1));
			password += chars.charAt(random);
		}
		return password;
	}

}
