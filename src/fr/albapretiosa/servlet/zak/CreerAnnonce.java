package fr.albapretiosa.servlet.zak;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.dao;
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
		
		HttpSession session = request.getSession(false);
		Abonne a = (Abonne)session.getAttribute("Abonne");	

		
		try {
			String titre = request.getParameter("titre");
			int surface = request.getParameter("surface");
			LocalDate creneau_debut = request.getParameter("creneau_debut");
			LocalDate creneau_fin   = request.getParameter("creneau_fin");
			String description = request.getParameter("description");
			boolean piscine = request.getParameter("piscine");
			boolean spa  = request.getParameter("spa");
			boolean golf = request.getParameter("golf");
			boolean tennis = request.getParameter("tennis");
			Photo photo_1 = request.getParameter("img_1");
			Photo photo_2 = request.getParameter("img_2");
			Photo photo_3 = request.getParameter("img_3");
			Photo photo_4 = request.getParameter("img_4");
			
			
			Annonce annonce = new Annonce();
			annonce.setTitre(titre);
			annonce.setSurface(surface);
			annonce.setCreneau_debut(creneau_debut);
			annonce.setCreneau_fin(creneau_fin);
			annonce.setDescription(description);
			annonce.setPiscine(piscine);
			annonce.setSpa(spa);
			annonce.setGolf(golf);
			annonce.setTennis(tennis);
			
			dao.annonces.add(annonce);

			
			
		}catch (NullPointerException npe) {
			
		}
	}

}
