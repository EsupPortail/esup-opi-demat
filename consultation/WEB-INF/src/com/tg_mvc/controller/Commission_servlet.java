package com.tg_mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tg_mvc.metier.Metier;
import com.tg_mvc.tools.LoadProperties;

/**
 * servlet de redirection vers commissions.jsp avec les parametres
 * @author root
 * @version 1.0
 */
public class Commission_servlet extends AbstractServlets{


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
		
		String login = session.getAttribute("login").toString();
		String idUsr = metier.getIdUsr(login);

		String dispName = metier.getDispName(login);
		String idProfile = metier.getIdProfile(idUsr);
		
		session.setAttribute("idUsr", idUsr);
		session.setAttribute("dispName", dispName);
		session.setAttribute("idProfile", idProfile);
		
		//idCmis, libCmis et codeCmis
		ArrayList<String> listIdCmis = metier.getIdCmis(idUsr, idProfile);
		if(listIdCmis.size() == 0) {
			listIdCmis = metier.getIdCmisFromRightOnCmi(idUsr, idProfile);
			if(listIdCmis.size() == 0)
				listIdCmis = metier.getAllIdCmis(idUsr, idProfile);
		}
		//out.println("listIdCmis : "+listIdCmis);
		ArrayList<String> listIdCmiEnService = metier.getlistIdCmiEnService();
		//out.println("listIdCmiEnService : "+listIdCmiEnService);
		ArrayList<String> listIdCmisEnServicePourLeIdUsr = metier.getlistIdCmisEnServicePourLeIdUsr(listIdCmis, listIdCmiEnService);
		//out.println("listIdCmisEnServicePourLeIdUsr : "+listIdCmisEnServicePourLeIdUsr);
		
		listIdCmisEnServicePourLeIdUsr = metier.trierCommisionParOrdreAlphabetique(listIdCmisEnServicePourLeIdUsr);
		
		ArrayList<String>  listLibCmis = metier.getLibCmis(listIdCmisEnServicePourLeIdUsr);
		ArrayList<String> listCodeCmis = metier.getCodeCmis(listIdCmisEnServicePourLeIdUsr);
		
		
		metier.deconnexion();
		request.setAttribute("listIdCmisEnServicePourLeIdUsr", listIdCmisEnServicePourLeIdUsr);
		request.setAttribute("listCodeCmis", listCodeCmis);
		request.setAttribute("listLibCmis", listLibCmis);
		
		
		if(listIdCmisEnServicePourLeIdUsr.size() == 0)
			request.getRequestDispatcher("noCommission.jsp").forward(request, response);
		else
			request.getRequestDispatcher("commission.jsp").forward(request, response);
		
	}
	
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}
