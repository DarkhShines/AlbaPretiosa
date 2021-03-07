package fr.albapretiosa.servlet.alain;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.nico.Abonne;

/**
 * Servlet implementation class Bannisement
 */
@WebServlet("/bannissement")
public class Bannissement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author Alain
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAbo = Integer.parseInt(request.getParameter("abo"));
		System.out.println(idAbo);
		Dao.banAbo(idAbo);
		response.sendRedirect(request.getContextPath()+"/vue/vueAdmin.jsp");
	}

}

