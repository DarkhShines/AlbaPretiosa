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
		Abonne abo = new Abonne();
		System.out.println(idAbo);
		ArrayList<Abonne> abos = Dao.abonnes;
		for(Abonne abonne : abos) {
			System.out.println(abonne.getIdAbonne() + " " + abonne.getAlias());
			  if(idAbo == abonne.getIdAbonne()) {
				abo = abonne;
//				// Alain : Je ne supprime pas l'abo, je le mets simplement dans une autre liste qui ne peut etre utilisée pour se connecter. 
//				// Mais qui permet de garder les informations de ce compte au cas ou.
			}
		}
		System.out.println("avant remove");
		Dao.abonnes.remove(abo);
		System.out.println("après remove");
		Dao.abonnesBan.add(abo);
		System.out.println("après add");
		response.sendRedirect(request.getContextPath()+"/vue/vueAdmin.jsp");
	}

}

