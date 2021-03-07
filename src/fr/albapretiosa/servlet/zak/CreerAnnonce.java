
package fr.albapretiosa.servlet.zak;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppException.Exception_Zak;
import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.metier.zak.Option;
import fr.albapretiosa.metier.zak.Options;
import fr.albapretiosa.metier.zak.Pays;
import fr.albapretiosa.metier.zak.Ville;
import fr.albapretiosa.util.UtilAlain;

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
	
	public Ville methodeVille(String libelle) {
		Ville ville = new Ville();
		Pays pays = new Pays();
		
		if(libelle.equals("Marseille") ) {
			ville.setIdVille(1);
			ville.setLibelle("Marseille");
			ville.setPays(pays);
		} 
		else if (libelle.equals("Paris")) {
			ville.setIdVille(2);
			ville.setLibelle("Paris");
			ville.setPays(pays);
		} 
		else if (libelle.equals("Bordeaux")) {
			ville.setIdVille(3);
			ville.setLibelle("Marseille");
			ville.setPays(pays);
		}
		
		
		return ville;
		
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
		
		Abonne a 				= (Abonne)session.getAttribute("Abonne");

		String titre 			= request.getParameter("titre").strip();

		int surface 			= Integer.parseInt(request.getParameter("surface").strip());

		String ville1 			= request.getParameter("ville").strip();

		LocalDate creneauDebut  = LocalDate.parse((request.getParameter("creneau_debut").strip()));

		LocalDate creneauFin    = LocalDate.parse(request.getParameter("creneau_fin").strip());

		String description 		= request.getParameter("description").strip();
		
		
		
		boolean piscine 		= false; 
		if(request.getParameter("piscine") != null) piscine = true;
		
		boolean spa  			= false;
		if(request.getParameter("spa") != null) spa = true;
		
		boolean golf 			= false;
		if(request.getParameter("golf") != null) golf = true;
		
		boolean tennis 			= false;
		if(request.getParameter("tennis") != null) tennis = true;
		
		Boolean[] listeOption = {piscine, spa, golf, tennis};
		
		Options options = new Options();
		
		for (int i = 0; i < listeOption.length; i++) {
			Option option = new Option();
			
			if(listeOption[i]) {
				option = new Option(listeOption[i]);
				options.add(listeOption[i]);
			}
		}
		

		Ville ville = methodeVille(ville1);
		boolean creationOk = false;
		// (idAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille, titreAnnonce)

		try {
			System.out.println("Je rentre dans le try de doPost de CréerAnnonce");
			for(Annonce ann : Dao.getAllAnnonce()) {
				if(!titre.equals(ann.getTitre())) {
					creationOk = true;
				}
			}
			if(creationOk) {
				//(idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille, )
				Annonce annonce = new Annonce(titre, surface, creneauDebut, creneauFin, description, a, ville, options );
				System.out.println(annonce);
				Dao.createAnnonce(annonce);
				response.sendRedirect("vue/Formulaire_Annonce.jsp");
				System.out.println("Je sors du doPost de CréerAnnonce");
			}
		}catch (Exception_Zak npe) {

			request.setAttribute("message", "Création de l'annonce non éffectué");
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
			System.out.println("Erreur Formulaire" + npe.getMessage() + npe.getCause());
			npe.printStackTrace();

		}


	}
}
