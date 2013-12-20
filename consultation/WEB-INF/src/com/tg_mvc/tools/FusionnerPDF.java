package com.tg_mvc.tools;

import java.io.File;
import java.util.ArrayList;

/**
 * classe des getion des pdfs
 * @author root
 *
 */
public class FusionnerPDF {
	
	
	/**
	 * fusion de 2 ou plusieurs pdfs
	 * @param pdfsPath
	 * @param ciblePath
	 * @param lienPDFBox
	 */
	public static boolean fusionnerAvecPDFBox(ArrayList<String> pdfsPath, String ciblePath, String lienPDFBox){
        String sources = "";
        for(String s : pdfsPath)
                sources += s+" ";
        String cmd = "java -jar "+lienPDFBox+" PDFMerger "+sources+" "+ciblePath;
        System.out.print(cmd);
        Runtime run = Runtime.getRuntime();
        Process p;
        try {
                p = run.exec(cmd);
                p.waitFor();

        } catch (Exception e) {
        	System.err.print(e.toString());
        }
        
        if(!new File(ciblePath).exists())
        	return false;
        
        return true;
	}

	
	
	public static void fusionnerAvecGs(ArrayList<String> pdfsPath, String ciblePath){
		String sources = "";
		for(String s : pdfsPath)
			sources += s+" ";
		String cmd = "gs -dBATCH -dNOPAUSE -q -sDEVICE=pdfwrite -sOutputFile=" + ciblePath + " "+ sources;
		System.out.print(cmd);
		Runtime run = Runtime.getRuntime();
		Process p;
		try {
			p = run.exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * copier un pdf
	 * @param pdfsPath
	 * @param ciblePath
	 */
	public static void Copier(ArrayList<String> pdfsPath, String ciblePath){
		String sources = "";
		for(String s : pdfsPath)
			sources += s+" ";
		String cmd = "cp "+sources+" "+ciblePath;
		System.out.print(cmd);
		Runtime run = Runtime.getRuntime();
		Process p;
		try {
			p = run.exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
