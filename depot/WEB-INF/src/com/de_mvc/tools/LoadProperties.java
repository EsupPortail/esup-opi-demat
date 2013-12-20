package com.de_mvc.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * classe de getion des properties
 * @author root
 * @version 1.0
 */
public class LoadProperties{
	

	/**
	 * obtenir les properties à partir du path de fichier dans l'attribut filename
	 * @param filename
	 * @return properties
	 */
	public static Properties load(String filename) {
		Properties properties = new Properties();
		
		File file = new File(filename);
		FileInputStream input;
		try {
			input = new FileInputStream(file);
			try{
				try {
					properties.load(input);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally { 
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;

	}

}
