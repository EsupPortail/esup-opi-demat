package com.de_mvc.controller;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.MimetypesFileTypeMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;

/**
 * servlet de telechargement des fichier + verification de longueur et mimeType + mise à jour de la base des données
 * @author root
 * @version 1.0
 */
public class Uploading_servlet extends AbstractServlets{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;

	/*
	 * private String filePath; private int maxFileSize = 50 * 1024; private int
	 * maxMemSize = 4 * 1024; private File file;
	 */

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = request.getSession(false);
		String numDossier = session.getAttribute("numDossier").toString();
		String idUsr = session.getAttribute("idUsr").toString();
		String idCmi = session.getAttribute("idCmi").toString();
		String codeEtape = session.getAttribute("codeEtape").toString();
		String codeVet = session.getAttribute("codeVet").toString();
		String lienDossier = getServletContext().getInitParameter("lienDossier");
		ArrayList<String> listFichierTelecharge = new ArrayList<String>();
		
		isMultipart = ServletFileUpload.isMultipartContent(request);
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/

		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);
			List fileItems2 = fileItems;
			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			Iterator i2 = fileItems2.iterator();

			long fileSizeMax = Long.parseLong(getServletContext().getInitParameter("tailleMaxFichier").trim());// en octet

			int nbErr = 0;
			ArrayList<String> listFileErrorType = new ArrayList<String>();
			ArrayList<String> listFileErrorTailleMax = new ArrayList<String>();
			ArrayList<String> listFileErrorTailleMin = new ArrayList<String>();
			
			// parcourir la liste des noms des formulaires, et verifier s'il
			// respectent les conditions
			while (i2.hasNext()) {
				FileItem item = (FileItem) i2.next();
				// verifier si le typer de formulaire est != de fichier
				if (item.isFormField()) {
					//String fieldName = item.getFieldName().replaceAll("-", " ");
					
				} else {
					// fullFile c'est le file complet
					File fullFile = new File(item.getName().toString());
					String extention = "."
							+ fullFile.getName().substring(
									fullFile.getName().lastIndexOf(".") + 1)
									.toLowerCase();
					boolean estVide = false;
					// s'il etait vide
					if (fullFile.getName().equals("")) {
						estVide = true;
					} else {

						if (!estVide) {
							// obtenir le mime de ficher
							String mimeType = new MimetypesFileTypeMap().getContentType(fullFile).toLowerCase();
							/*if (!((mimeType.equals("application/octet-stream") && (extention.equals(".pdf") || extention.equals(".doc") || extention.equals(".odt") || extention.equals(".docx") || extention.equals(".xls") || extention.equals(".xlsx")))
									|| (mimeType.equals("application/rtf") && extention.equals(".rtf"))
									|| (mimeType.equals("image/jpeg") && (extention.equals(".jpeg") || extention.equals(".jpg")))
									|| mimeType.equals("image/gif") && extention.equals(".gif"))) {
								listFileErrorType.add(fullFile.getName());
								nbErr++;
							}*/
							if (!((mimeType.equals("application/octet-stream") && (extention.equals(".pdf") || extention.equals(".xls"))))) {
									listFileErrorType.add(fullFile.getName());
									nbErr++;
							}
						}
					}

					// tester si le fichier a bien ete dans le formulaire,
					// pour eviter les item vides
					if (!fullFile.getName().equals("")) {
						// obtenir la taille !!!!(la taille doit etre obtenue a
						// partir du item, car java considere fullFile ouvert
						// donc fullFile.lengh() renvoie 0)
						long taille = item.getSize();
						// out.print(taille);
						// si la taile du file est > fileSizeMax
						if (taille > fileSizeMax) {
							listFileErrorTailleMax.add(fullFile.getName());
							nbErr++;
						}
						
						//si la taille du fichier = 0
						if (taille == 0) {
							listFileErrorTailleMin.add(fullFile.getName());
							nbErr++;
						}
					}
					
				}
				
			}
			if (nbErr > 0) {
				request.setAttribute("listFileErrorType", listFileErrorType);
				request.setAttribute("listFileErrorTailleMax", listFileErrorTailleMax);
				request.setAttribute("listFileErrorTailleMin", listFileErrorTailleMin);
				request.setAttribute("fileSizeMax", fileSizeMax);
				request.getRequestDispatcher("uploadError.jsp").forward(request, response);
				return;
			}

			int nbFiles = 0;
			boolean noItemUploaded = true;
			while (i.hasNext()) {
				FileItem item = (FileItem) i.next();
				String fieldName = item.getFieldName().toString();
				// verifier si le typer de formulaire est != de fichier
				if (item.isFormField()) {
					 
				} else {
					// fullFile c'est le file complet
					File fullFile = new File(item.getName().toString());
					// tester si le fichier est bien etait dans le formulaire,
					// pour eviter les item vides
					if (!fullFile.getName().equals("")) {
						nbFiles++;
						// obtenir le mime de ficher
						String mimeType = new MimetypesFileTypeMap().getContentType(fullFile);
						// créer Dossier/ dans le repertoire actuel (dans
						// notre cas upload_servlet/webapps)
						File repertoire = new File(lienDossier + codeEtape + "-" + codeVet + "/" + numDossier + "/");
						if (!repertoire.exists())
							repertoire.mkdirs();

						String extention = "." + fullFile.getName().substring(fullFile.getName().lastIndexOf(".") + 1).toLowerCase();

						File savedFile = new File(repertoire, fieldName.substring(fieldName.indexOf("=") + 1) + extention);
						
						/********************************* connection à la bdd ******************************/
						Metier metier = new Metier(prop);
						metier.connexion();

						/********************************* obtenir le idNom du fichier ***********************************/
						String idNom = metier.getIdNom(fieldName.substring(fieldName.indexOf("=") + 1));

						// supprimer le fichier de meme type pour le remplacer
						// (par exemple un cv, par le nv cv)
						String[] tabExtentions = { ".pdf", ".xls"};
						for (int j = 0; j < tabExtentions.length; j++) {
							if (new File(repertoire + "/" + fieldName.substring(fieldName.indexOf("=") + 1) + tabExtentions[j]).exists()) {

								/************************** suppression du fichier de la bdd ***************************/
								// suppression physique
								if(new File(repertoire + "/" + fieldName.substring(fieldName .indexOf("=") + 1) + tabExtentions[j]).delete())
									metier.delFile(idNom, idCmi, idUsr);
							}
						}

						/******************************** ajout à la bdd **************************/
						
						
						metier.insertFile(idUsr, idCmi, idNom, repertoire.toString(), fieldName.substring(fieldName.indexOf("=") + 1), extention);
						
						// enregitrer
						item.write(savedFile);
						
						listFichierTelecharge.add(fieldName.substring(0, fieldName.indexOf("=")).toString());
						
						
						/******************************** conversion : annulee **************************/
/*
						//transformation
						String cmd1 = "";
						String file1 = repertoire + "/" + fieldName.substring(fieldName.indexOf("=") + 1) + extention;
						String file2 = file1.substring(0, file1.lastIndexOf('.'));
						// Thread.currentThread().sleep(1000);
						// supprimer les doc, docx, odt, rtf , car c'est deja
						// enregistré sous format de pdf
						if (extention.toLowerCase().equals(".odt")
								|| extention.toLowerCase().equals(".doc")
								|| extention.toLowerCase().equals(".docx")
								|| extention.toLowerCase().equals(".rtf")) {

							cmd1 = "java -jar " + prop.getProperty("lienJodConverter") + " "
									+ file1 + " " + file2 + ".pdf";
							
						} else {
							if(!(extention.toLowerCase().equals(".xls") || extention.toLowerCase().equals(".xlsx"))) {
								cmd1 = "convert "
									+ file1 + " " + file2 + ".pdf";
							}
						}
						//supprimer le type initial si != de pdf
						if(!(extention.toLowerCase().equals(".pdf")
							|| extention.toLowerCase().equals(".xls")	
							|| extention.toLowerCase().equals(".xlsx"))){
							Runtime runtime1 = Runtime.getRuntime();
							Process process1 = null;
							process1 = runtime1.exec(cmd1);
							while (!new File(file2 + ".pdf").exists()) ;
							// suppression
							new File(repertoire + "/" + fieldName.substring(fieldName.indexOf("=") + 1) + extention).delete();
						}
*/						
						
						metier.deconnexion();
					}
				}

			}
			if (nbFiles == 0 && noItemUploaded) {
				request.getRequestDispatcher("noFile.jsp").forward(request, response);
				return;
			}
		} catch (Exception ex) {
			
		}
		Collections.sort(listFichierTelecharge);
		request.setAttribute("listFichierTelecharge", listFichierTelecharge);
		request.getRequestDispatcher("fichiersTelecharges.jsp").forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");
	}

}
