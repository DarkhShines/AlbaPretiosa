
package fr.albapretiosa.servlet.zak;

import java.io.IOException;
import fr.albapretiosa.util.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import AppException.Exception_Zak;
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

		PrintWriter out = response.getWriter();
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
		boolean creationOk = false;


		try {
			System.out.println("Je rentre dans le try de doPost de CréerAnnonce");
				for(Annonce ann : Dao.annonces) {
					if(!titre.equals(ann.getTitre())) {
						creationOk = true;
					}
				}
				if(creationOk) {
			Annonce annonce = new Annonce(titre, surface, pays, ville, creneau_debut, creneau_fin, description, piscine, spa, tennis, golf);
			Dao.annonces.add(annonce);
			response.sendRedirect("vue/Formulaire_Annonce.jsp");
			System.out.println("Je sors du doPost de CréerAnnonce");
				}
				else {
					throw new Exception_Zak("Le titre existe déja");
				}
		}catch (Exception_Zak npe) {

			request.setAttribute("message", "Création de l'annonce non éffectué");
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
			System.out.println("Erreur Formulaire");

		}


	}
}
