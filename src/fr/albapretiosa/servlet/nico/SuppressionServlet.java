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
		int idAbo = Integer.parseInt(request.getParameter("idAbonne"));
		ArrayList<Abonne> abonnes = Dao.abonnes;
		boolean supprOk = false;
		System.out.println(idAbo);
		
		for (Abonne abonne : abonnes) {
			if(idAbo == abonne.getIdAbonne()) {
				System.out.println("je suis dans le if ");
				abonne.setTelFixe("");
				supprOk = true;
				response.sendRedirect(context+"/vue/infosPersonnelles.jsp");
			}
		}
		if (supprOk) {
			System.out.println("je suis dans le if supprOk");
			response.sendRedirect(context+"/vue/infosPersonnelles.jsp");
			
		}
	}

}
