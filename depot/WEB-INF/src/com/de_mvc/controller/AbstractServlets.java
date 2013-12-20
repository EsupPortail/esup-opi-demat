

package com.de_mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * classe abstraite, implementé par tous les servlets
 * @author root
 * @version 1.0
 */
public abstract class AbstractServlets extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException ;
}
