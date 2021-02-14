package fr.albapretiosa.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.util.UtilAlain;

/**
 * Alba & Pretiosa 
 * Controleur principal
 * Tache : Empecher toute personne non autorisée l'accès à certaines parties du site
 * Et met en place l'organisation des URLs du site
 * @author ALAIN
 */
@WebServlet("/")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher 	disp; // Pour ne pas avoir à l'instancier dans chacunes de mes méthodes.
       
   

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); // Je récup ma session
		Abonne abonne = new Abonne();
		Admin admin = new Admin();
		String alias = ""; // Création de l'abonne ( vide ) et du alias ( vide ) afin de ne pas provoqué de NPE
		if((Abonne) session.getAttribute("Abonne") != null) {
			abonne = (Abonne) session.getAttribute("Abonne");
			alias =  abonne.getAlias();
			System.out.println(alias);
			// Si l'abonné en session existe, il devient abonne et l'alias prend la valeur du Alias de l'abo.
		}else if(session.getAttribute("Abonne") instanceof Admin) {
			admin = (Admin) session.getAttribute("Abonne");
		}else {
			// Si mon abonné est nul, aucun accès au site n'est autorisé, il est donc renvoyer vers l'accueil d'ou il pourra
			// se connecter ou créé un compte
			goIndex(request, response);
		}
		
		String path = request.getPathInfo();
		String chemin = request.getContextPath();
		System.out.println("path : "+ path);
		System.out.println("chemin : "+ chemin);
		if (path == null || path.equals("/")) goIndex(request, response);
		else if (path.endsWith("/accueil")) goAccueil(request, response);
		else if (path.endsWith("/consulter")) goConsulter(request, response);
		else if (path.endsWith("/deposer")) goDeposer(request, response);
		else if (path.endsWith("/apropos")) goApropos(request, response);
		else if (path.endsWith("/connexion")) goEspaceAbo(request, response);
		else if (path.endsWith("/notification")) goNotif(request, response);
		else if (path.endsWith("/deconnexion")) goDeco(request, response);
		else if (path.endsWith("/vueAdmin")) {
			if(admin.getAlias() != null)goAdmin(request, response); // Je profite du controleur pour filtré la page Admin
			else {
				request.setAttribute("message", "Vous n'avez pas la permission d'accèder à cette page. Veuillez vous connecter.");
				RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
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
		disp = request.getRequestDispatcher("/vue/accueil.jsp");
		disp.forward(request,response);	
	}
	protected void goEspaceAbo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Espace Abo");
		disp = request.getRequestDispatcher("/vue/infosPersonnelles.jsp");
		disp.forward(request,response);	
	}
	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go index");
		disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request,response);	
	}
	private void goConsulter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go consulter");
		disp = request.getRequestDispatcher("/vue/consulter.jsp");
		disp.forward(request,response);	
	}
	private void goApropos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go A propos");
		disp = request.getRequestDispatcher("/vue/apropos.jsp");
		disp.forward(request,response);	
	}
	protected void goNotif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Notif");
		disp = request.getRequestDispatcher("/vue/notification.jsp");
		disp.forward(request,response);	
	}
	protected void goDeposer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Deposer");
		disp = request.getRequestDispatcher("/vue/Formulaire_Annonce.jsp");
		disp.forward(request,response);	
	}
	protected void goDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Deco");
		disp = request.getRequestDispatcher("/deconnexion");
		disp.forward(request,response);	
	}
	protected void goAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Go Admin");
		disp = request.getRequestDispatcher("/vue/vueAdmin.jsp");
		disp.forward(request,response);	
	}

}
