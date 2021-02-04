package fr.albapretiosa.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.metier.nico.Abonne;

/**
 * Alba & Pretiosa 
 * Controleur principal
 * Tache : Empecher toute personne non autorisée l'accès à certaines parties du site
 * Et met en place l'organisation des URLs du site
 */
@WebServlet("/accueil")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher 	disp; // Pour ne pas avoir à l'instancier dans chacunes de mes méthodes.
       
   

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); // Je r�cup ma session
		Abonne abonne = new Abonne();
		String login = ""; // Cr�ation de l'abonne ( vide ) et du login ( vide ) afin de ne pas provoqu� de NPE
		if((Abonne) session.getAttribute("Abonne") != null) {
			abonne = (Abonne) session.getAttribute("Abonne");
			//login =  abonne.getNom();
			System.out.println(login);
			// Si l'abonn� en session existe, il devient abonne et le login prend la valeur du nom de l'abo.
		} else {
			// Si mon abonné est nul, aucun accès au site n'est autorisé, il est donc renvoyer vers l'accueil d'ou il pourra
			// se connecter ou créé un compte
			goIndex(request, response);
		}
		
		String path = request.getPathInfo();
		String chemin = request.getContextPath();
		System.out.println("path : "+ path);
		System.out.println("chemin : "+ chemin);
		if (path == null || path.equals("/")) goAccueil(request, response);
//		else if (path.endsWith("/emprunt")) goEmprunt(request, response);
		else if (path.endsWith("/connexion")) goEspaceAbo(request, response);
//		else if (path.endsWith("/test/*")) goTest(request, response);
		else if (path.endsWith("/vueAdmin")) {
			if(login.equals("root"))goAdmin(request, response); // Je profite du controleur pour filtr� la page Admin
			else {
				request.setAttribute("message", "Vous n'avez pas la permission d'acc�der � cette page. Veuillez vous connecter.");
//				RequestDispatcher disp = request.getRequestDispatcher(Erreur.getErrorLocation());
				disp.forward(request, response);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void goAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Accueil");
		disp = request.getRequestDispatcher("/indexconnec.jsp");
		disp.forward(request,response);	
	}
	protected void goEspaceAbo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Espace Abo");
	}
	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go index");
		disp = request.getRequestDispatcher("/indexconnec.jsp");
		disp.forward(request,response);	
	}
	protected void goAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Admin");
		disp = request.getRequestDispatcher("/vueAdmin.jsp");
		disp.forward(request,response);	
	}

}
