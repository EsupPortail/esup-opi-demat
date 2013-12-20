package com.de_mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;
import com.de_mvc.tools.MyMail;
import com.de_mvc.tools.PasswordGenerator;

/**
 * 
 * @author root
 * @version 1.0
 */
public class EnvoieLiens_servlet extends AbstractServlets {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException{
		
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		
		/**********************recuperation des parametres******************************/
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		HttpSession session = request.getSession(false);
		String idUsr = session.getAttribute("idUsr").toString();
		String nomUsr = new String(request.getSession(false).getAttribute("nomUsr").toString().getBytes("utf-8"), "iso-8859-1");
		
		String mail1 = request.getParameter("mail1");
		String mail2 = request.getParameter("mail2");
		String mail3 = request.getParameter("mail3");
		String nbMailRecommandation = request.getParameter("nbMailRecommandation");
		
		
		ArrayList<String> liste = new ArrayList<String>();
		liste.add(mail1);
		liste.add(mail2);
		liste.add(mail3);
		
		// libCmis : list des formations choisis par le candidat
		String[] idLinks = metier.getTabIdLinks(idUsr);
		ArrayList<String> trtCmis = metier.getListIdTrtCmi(idLinks);
		ArrayList<String> libCmis = metier.getListLibCmis(trtCmis);
		String formationsChoisis = "";
		for(String lib : libCmis) {
			formationsChoisis += "\n      "+lib;
		}
		
		/*********************************************************************************/
		/*********************verifier si tous la mails sont pas vides*****************/
		int cpt = 0;
		for(String mail : liste){
			if( mail != null){
				mail = mail.trim().toLowerCase();
				if(mail.equals("")){
					cpt++;
				}
			}
		}
		if((cpt+"").equals(nbMailRecommandation)){
			metier.deconnexion();
			request.getRequestDispatcher("noMail.jsp").forward(request, response);
			return;
		}
		
		
		/********************verifications et envoie*****************************/
		String resultat = "";
		for(String mail : liste){
			if(mail != null){
				if(MyMail.isMail(mail)){
					ArrayList<String> listMailRefs  = metier.getMailRefs();
					String lien = prop.getProperty("lienIdentifRef");
					if(!listMailRefs.contains(mail)){
						ArrayList<String> listMailRefsForUsr  = metier.getMailRefsForUsr(idUsr);
						if(!listMailRefsForUsr.contains(mail)){
							
							
							
							String pwd = "";
							
							pwd = PasswordGenerator.generatePassword(8);
							
							String sender = prop.getProperty("mailFrom");
							String getter = mail;
							String host = prop.getProperty("mailHost");
							String hostServer = prop.getProperty("HostServer");
							//String messageText = new String(prop.getProperty("PremierMessageReferent2").toString().getBytes("iso-8859-1"), "utf-8")+"\n\n";
							String messageText = metier.getMailContent("DEP_LET_RECO") + "\n\n";
							messageText += "\n Lien : "+lien;
							messageText += "\n adresse mail : "+mail;
							messageText += "\n mot de passe : "+pwd;
							messageText += "\n Nom de l'étudiant : "+nomUsr;
							messageText += "\n "+prop.getProperty("messageCandidaturesEtudiant")+formationsChoisis;
							//String subject = new String(prop.getProperty("PremierSujetMessageReferent").toString().getBytes("iso-8859-1"), "utf-8");
							String subject = metier.getMailSubject("DEP_LET_RECO");

							if (MyMail.sendMail(sender, getter, host,
									hostServer, messageText, subject)) {
								
								metier.insertNewRef(mail, pwd);
								String idRef = metier.getIdRef(mail);
								metier.insertNewRefForUsr(idRef, idUsr);
								resultat += prop.getProperty("mailEnvoye")
										+ "<br> " + mail + "<br><br>";
							} else {
								resultat += prop.getProperty("problemeMail")
										+ "<br> " + mail + "<br><br>";
							}
							
						}
					} else {
						ArrayList<String> listMailRefsForUsr  = metier.getMailRefsForUsr(idUsr);
						if(!listMailRefsForUsr.contains(mail)){
							String sender = prop.getProperty("mailFrom");
							String getter = mail;
							String host = prop.getProperty("mailHost");
							String hostServer = prop.getProperty("HostServer");
							//String subject = new String(prop.getProperty( "DeuxiemeSujetMessageReferent").toString().getBytes("iso-8859-1"), "utf-8");
							String subject = metier.getMailSubject("DEP_LET_RECO");
							String pwd = metier.getPasswordRef(mail);
							
							//String messageText = new String(prop.getProperty("DeuxiemeMessageReferent2").toString().getBytes("iso-8859-1"), "utf-8")+ "\n\n";
							String messageText = metier.getMailContent("DEP_LET_RECO") + "\n\n";
							messageText += "\n Lien : " + lien;
							messageText += "\n adresse mail : " + mail;
							messageText += "\n mot de passe : " + pwd;
							messageText += "\n Nom de l'étudiant : " + nomUsr;
							messageText += "\n "
									+ prop.getProperty("messageCandidaturesEtudiant")
									+ formationsChoisis;
								
							if (MyMail.sendMail(sender, getter, host, hostServer, messageText, subject)) {
								
								String idRef = metier.getIdRef(mail);
								metier.insertNewRefForUsr(idRef, idUsr);
								resultat += prop.getProperty("mailEnvoye")
										+"<br> "+mail+"<br><br>";
							} else {
								resultat += prop.getProperty("problemeMail")
										+"<br> "+mail+"<br><br>";
							}
							
						} else {
							resultat += prop.getProperty("reindiqueReferent")
									+"<br> "+mail+"<br><br>";
						}
					}
				} else {
					if(!mail.equals(""))
						resultat += prop.getProperty("invalideMail")+mail+"<br><br>";
				}
			}
		}
		
		metier.deconnexion();
		request.setAttribute("resultat", resultat);
		request.getRequestDispatcher("resultatEnvoieMail.jsp").forward(request, response);
		
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}