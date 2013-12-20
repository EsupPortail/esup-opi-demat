package com.tg_mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tg_mvc.metier.Metier;
import com.tg_mvc.tools.LoadProperties;

/**
 * 
 * @author root
 *
 */
public class FichiersAAffiche_servlet extends AbstractServlets{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		HttpSession session = request.getSession(false);
		
		
		//lister les fichiers choisis
		String codeNomFichiers = "";
		if(request.getParameterValues("fichier" ) != null){
			String[] res = request.getParameterValues("fichier" );
			for (int i = 0; i < res.length; ++i)
				codeNomFichiers += res[i]+";";
		}
		
		String login = session.getAttribute("login").toString();
		String idCmi = request.getParameter("idCmi");
		String idSession = session.getId();
		Date sessionStartTime = new Date(session.getCreationTime());
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sessionStartTimeSimpleFormat = sdf.format(sessionStartTime);
		
		//inserer dans la base, mise a jour si deja insere
		if(!metier.existeDansUPDConsul(login, idSession, idCmi))
			metier.insertFichiersAAffiche(idSession, login, codeNomFichiers, idCmi, sessionStartTimeSimpleFormat);
		else
			metier.updateFichiersAAffiche(idSession, login, codeNomFichiers, idCmi, sessionStartTimeSimpleFormat);
		
		metier.deconnexion();
		request.getRequestDispatcher("interface").forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}
