package fr.albapretiosa.servlet.nico;

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
 * Servlet implementation class SuppressionServlet
 */
@WebServlet("/SuppressionServlet")
public class SuppressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SuppressionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String alias = request.getParameter("alias");
//		ArrayList<Abonne> abonnes = Dao.abonnes;

		
		for (Abonne abonne : Dao.abonnes) {
			if(alias.equals(abonne.getAlias())) {
				System.out.println("je suis dans le if ");
				abonne.setTelFixe("");
			}
		response.sendRedirect(context+"/vue/infosPersonnelles.jsp");
		System.out.println(Dao.abonnes);
		}
	}

}
