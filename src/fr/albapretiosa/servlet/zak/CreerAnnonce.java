
package fr.albapretiosa.servlet.zak;

import java.io.IOException;

import java.time.LocalDate;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.*;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.metier.zak.Photo;

/**
 * Servlet implementation class CreerAnnonce
 */
@WebServlet("/CreerAnnonce")
public class CreerAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doPost de CreerAnnonce");
		
		
		HttpSession session = request.getSession(true);
		Abonne a = (Abonne)session.getAttribute("Abonne");	
		
		String titre 			= request.getParameter("titre").strip();
		int surface 			= Integer.parseInt(request.getParameter("surface").strip());
		String pays				= request.getParameter("pays").strip();
		String ville 			= request.getParameter("ville").strip();
		LocalDate creneau_debut = LocalDate.parse((request.getParameter("creneau_debut").strip()));
		LocalDate creneau_fin   = LocalDate.parse(request.getParameter("creneau_fin").strip());
		String description 		= request.getParameter("description").strip();
		boolean piscine 		= Boolean.valueOf(request.getParameter("piscine")) ;
		boolean spa  			= Boolean.valueOf(request.getParameter("spa"));
		boolean golf 			= Boolean.valueOf(request.getParameter("golf"));
		boolean tennis 			= Boolean.valueOf(request.getParameter("tennis"));
//		Photo photo_1 			= request.getParameter("img_1");
//		Photo photo_2 			= request.getParameter("img_2");
//		Photo photo_3 			= request.getParameter("img_3");
//		Photo photo_4 			= request.getParameter("img_4");
		
		try {
			System.out.println("Je rentre dans le try de doPost de CréerAnnonce");
			Annonce annonce = new Annonce();
			System.out.println("Pas 0");
		    annonce.setIdAbonne(a.getIdAbonne());
			System.out.println("Pas 1");
			annonce.setIdAnnonce(Annonce.genereIdAnnonce());
			System.out.println("Pas 2");
			annonce.setTitre(titre);
			System.out.println("Pas 3");
			annonce.setSurface(surface);
			System.out.println("Pas 4");
			annonce.setPays(pays);
			System.out.println("Pas 5");
			annonce.setVille(ville);
			System.out.println("Pas 6");
			annonce.setCreneau_debut(creneau_debut);
			System.out.println("Pas 7");
			annonce.setCreneau_fin(creneau_fin);
			System.out.println("Pas 8");
			annonce.setDescription(description);
			System.out.println("Pas 9");
			annonce.setPiscine(piscine);
			System.out.println("Pas 10");
			annonce.setSpa(spa);
			System.out.println("Pas 11");
			annonce.setGolf(golf);
			System.out.println("Pas 12");
			annonce.setTennis(tennis);
			System.out.println("Pas 13");
			
			Dao.annonces.add(annonce);
			System.out.println("Pas 14");
			response.sendRedirect("vue/Formulaire_Annonce.jsp");
			System.out.println("Je sors du doPost de CréerAnnonce");
		}catch (NullPointerException npe) {
			
			request.setAttribute("message", "Votre annonce ne correspond pas à nos critères");
			
			String chemin = this.getServletContext().getInitParameter("pageErreur");
			
			RequestDispatcher disp = request.getRequestDispatcher(chemin);
			disp.forward(request, response);
			
		}
	}
}
