package fr.albapretiosa.servlet.alain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Commentaire;
import fr.albapretiosa.metier.nico.Abonne;

/**
 * Servlet implementation class SuppComm
 * @author Alain Dardot
 */
@WebServlet("/suppcomm")
public class SuppComm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Get de SuppComm");
		HttpSession session = request.getSession(true);
		Abonne abonne = (Abonne) session.getAttribute("Abonne"); // Alain :  Je récupère l'abonné en session
		int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
		int idComm = Integer.parseInt(request.getParameter("idComm"));
		for(Commentaire commentaire : Dao.commentaires) {
			if(commentaire.getIdCom() == idComm) { // Alain : Je cherche dans tout les commentaires lequel à l'ID que je récupère via l'url 
				Dao.commentaires.remove(idComm);
			}
		}
		
		System.out.println("Do Get de SuppComm fin");
		response.sendRedirect("vue/consulter.jsp?idAnnonce="+idAnnonce+""); // Alain : Je renvoi sur consulter.jsp avec l'ID de l'annonce pour charger la bonne page
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
