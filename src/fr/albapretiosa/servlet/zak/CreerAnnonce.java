
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
	 * Méthode de contrôle du titre saisi.
	 * @param titre
	 * @throws Exception
	 */
	public static void controleTitre( String titre ) throws Exception_Zak {
		if( titre == null || titre.trim() == "") {
			throw new Exception_Zak( "Le titre n'est pas renseigné" );
		}
		else if(titre != null) {
			if (titre.trim().length() < 10 ) {
				throw new Exception_Zak( "Le titre doit contenir au moins 10 caractères." );
			}
			if (titre.trim().length() < 100 ) {
				throw new Exception_Zak( "Le titre ne peut contenir plus de 100 caractères." );
			}
		}
	}


	/**
	 * Méthode de controle de la surface
	 * @param surface
	 * @throws Exception
	 */

	public void controleSurface(int surface) throws Exception_Zak{
		if( surface == 0 ) {
			throw new Exception_Zak( "La surface ne peut être égale à 0 ");
		}
		if( surface < 0) {
			throw new Exception_Zak( "La surface ne peut être négative");
		}
		if( surface > 112100 ) {
			throw new Exception_Zak( "La surface ne peut être superieur à 112100m² ");
		}
	}

	/**
	 * Méthode de controle du pays
	 * @param pays
	 * @throws Exception_Zak
	 */
	public void controlePays(String pays) throws Exception_Zak {
		if( pays == null || pays.trim() == "") {
			throw new Exception_Zak( "Le pays n'est pas renseigné" );
		}
		else if(pays != null) {
			if(pays.trim().toLowerCase() != "france" || pays.trim() != "angleterre" || pays.trim() != "italie") {
				throw new Exception_Zak("Nous ne proposons pas ce pays dans nos services");
			}
			if(pays.trim().length() > 40) {
				throw new Exception_Zak("Le nom du pays est trop long");
			}
		}
	}

	/**
	 * @param ville
	 * @throws Exception_Zak
	 */
	public void controleVille(String ville) throws Exception_Zak{
		if( ville == null || ville.trim() == "") {
			throw new Exception_Zak( "Le pays n'est pas renseigné" );
		}
		else if(ville != null) {
			if(ville.trim().toLowerCase() != "marseille" || ville.trim().toLowerCase() != "paris" || ville.trim().toLowerCase() != "bordeaux") {
				throw new Exception_Zak("Nous ne proposons pas cette ville dans nos services");
			}
			if(ville.trim().length() > 40) {
				throw new Exception_Zak("Le nom de la ville est trop long");
			}
		}
	}

	/**
	 * @param creneau_debut
	 * @param creneau_fin
	 * @throws Exception_Zak
	 */
	public void controleDate(LocalDate creneau_debut, LocalDate creneau_fin) throws Exception_Zak{

		if(creneau_debut == null) {
			throw new Exception_Zak("La date de début de location n'est pas renseigné");
		}
		if(creneau_fin == null) {
			throw new Exception_Zak("La date de fin de location n'est pas renseigné");
		}
		else if(creneau_debut != null && creneau_fin != null) {
			if (creneau_debut.isBefore(LocalDate.now())) {
				throw new Exception_Zak("La date de début de location de peut être antérieur à aujourd'hui");
			}
			if(creneau_fin.isBefore(LocalDate.now())) {
				throw new Exception_Zak("La date de fin de location de peut être antérieur à aujourd'hui");
			}
			if(creneau_debut.isAfter(creneau_fin)) {
				throw new Exception_Zak("La date de fin de location de peut être anterieur à la date de début");
			}
		}
	}
	
	/**
	 * @param description
	 * @throws Exception_Zak
	 */
	public void controleDescription(String description) throws Exception_Zak {
		if(description != null) {
			if(description.trim().length() > 250) {
				throw new Exception_Zak("La description est trop longue");
			}
			if(description.trim().length() < 5)
				throw new Exception_Zak("La description est trop courte");
			
		}
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



		/*CONTROLE DES DONNEES*/
		ArrayList<String> messages = new ArrayList<String>();
		try {
			controleTitre(titre);

		}catch(Exception_Zak e){
			messages.add(e.getMessage());
		} 
		try {
			controleSurface(surface);

		}catch(Exception_Zak e){
			messages.add(e.getMessage());
		} 
		try {
			controlePays(pays);
		}catch(Exception_Zak e){
			messages.add(e.getMessage());
		}
		try {
			controleVille(ville);
		}catch(Exception_Zak e){
			messages.add(e.getMessage());
		}
		try {
			controleDate(creneau_debut, creneau_fin);
		}catch(Exception_Zak e){
			messages.add(e.getMessage());
		}
		try {
			controleDescription(description);
		}catch(Exception_Zak e) {
			messages.add(e.getMessage());
		}

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

			request.setAttribute("message", "Il y a eu erreur de saisie, consulter liste erreur");
			request.setAttribute("messages", messages);
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
			System.out.println("Erreur Formulaire");

		}


	}
}
