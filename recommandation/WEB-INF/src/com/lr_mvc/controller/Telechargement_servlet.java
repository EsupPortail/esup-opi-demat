package com.lr_mvc.controller;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
 
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lr_mvc.metier.Metier;
import com.lr_mvc.tools.LoadProperties;
import com.lr_mvc.tools.MyMail;


/**
 * servlet de telechargement du fichier et redirection vers telechargement.jsp
 * @author root
 *
 */
public class Telechargement_servlet extends AbstractServlets{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 0;
	private int maxMemSize = 4 * 1024;
	private File file;


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		maxFileSize = Integer.parseInt(getServletContext().getInitParameter("tailleMaxFichier").trim());// en octet
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		filePath = prop.getProperty("dossierTelechargement").trim();
		
		Metier metier = new Metier(prop);
		metier.connexion();
		
		HttpSession session = request.getSession(false);
		
		String nomRef = session.getAttribute("nomRef").toString();
		String prenomRef = session.getAttribute("prenomRef").toString();
		String adresseMail = session.getAttribute("adresseMail").toString();
		
		
		/*******************get parametres***********************/
		
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
//		if (!isMultipart) {
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Servlet upload</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<p>No file uploaded</p>");
//			out.println("</body>");
//			out.println("</html>");
//			return;
//		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// Message de feedBack
		String msg;

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Servlet upload</title>");
//			out.println("</head>");
//			out.println("<body>");
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					//String contentType = fi.getContentType();
					//boolean isInMemory = fi.isInMemory();
					int sizeInBytes = (int) fi.getSize();
					//out.print("<br>ici : "+fieldName+fileName+contentType+isInMemory+sizeInBytes);
					
					
					String idUsr = fieldName.substring(0, fieldName.indexOf("_"));
					String idRef = fieldName.substring(fieldName.indexOf("_")+1);
					Date maDateAvecFormat=new Date();
					SimpleDateFormat dateStandard = new SimpleDateFormat("yyyy-MM-dd");
					String date = dateStandard.format(maDateAvecFormat);
					String extention = fileName.substring(fileName.lastIndexOf(".")+1);
					//out.print("->"+idUsr+"---"+idRef+"----"+date+"<-");
					
					
					
					File repertoire = new File(filePath);
					
					if (!repertoire.exists()){
						repertoire.mkdirs();
					}
					
					if(sizeInBytes > maxFileSize){
						msg = prop.getProperty("bigFile");
						metier.deconnexion();
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("telechargement.jsp").forward(request, response);
						break;
					}
					
					if(fileName.equals("")){
						msg = prop.getProperty("noFile");
						metier.deconnexion();
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("telechargement.jsp").forward(request, response);
						break;
					}
					
					
					
					
					
					
					String fileNewName = idRef+"_"+idUsr+"_"+date+"."+extention;
					file = new File(filePath + fileNewName);
					
					String mimeType = new MimetypesFileTypeMap().getContentType(file).toLowerCase();
					if (!(extention.toLowerCase().equals("pdf")) && mimeType.equals("application/octet-stream")){
						msg = prop.getProperty("typeFile");
						metier.deconnexion();
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("telechargement.jsp").forward(request, response);
						break;
					}
					
					// Write the file
					fi.write(file);
//					out.println("Uploaded Filename: " + fileName + "<br>");
					
					
					//Transforme (doc, docx, odt, rtf) on PDF + insert in bdd
					if (extention.toLowerCase().equals("odt")
							|| extention.toLowerCase().equals("doc")
							|| extention.toLowerCase().equals("docx")
							|| extention.toLowerCase().equals("rtf")) {
						String CopieFile = filePath + fileNewName.substring(0, file.getName().lastIndexOf('.'))+".pdf";
//						out.print("<br><br>"+filePath + fileNewName);
//						out.print("<br><br>"+CopieFile);

						String cmd1 = "java -jar " + prop.getProperty("lienJodConverter") + " "
								+ filePath + fileNewName + " " + CopieFile;
						Runtime runtime1 = Runtime.getRuntime();
						Process process1 = null;
						process1 = runtime1.exec(cmd1);
						while (!new File(CopieFile).exists()) ;
						// suppression
						new File(filePath + fileNewName).delete();
						
						//insertion dans la bdd
						metier.updateNomFileDate(idRef, idUsr, CopieFile, date);
					} else {
						//insertion dans la bdd
						metier.updateNomFileDate(idRef, idUsr, filePath+fileNewName, date);
					}
					
					String mailUsr = metier.getMailUsr(idUsr);
					String sender = prop.getProperty("mailFrom");
					String getter = mailUsr;
					String host = prop.getProperty("mailHost");
					String hostServer = prop.getProperty("HostServer");
					String messageText = prop.getProperty("envoieTextMassageDepotEffectuer").toString()
						+"\n "+  nomRef + " " + prenomRef + "\n " + adresseMail;
					String subject = prop.getProperty("envoiesubjectMassageDepotEffectuer").toString();
					MyMail.sendMail(sender, getter, host, hostServer, messageText, subject);
					
					
					msg = prop.getProperty("fileUploaded");
					metier.deconnexion();
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("telechargement.jsp").forward(request, response);
					
					
				} 
			}
//			out.println("</body>");
//			out.println("</html>");
		} catch (Exception ex) {
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		doPost(request, response);
	}

}
