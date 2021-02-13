package AppException;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlGestion
 * 
 * Controleur pour la gestion 
 * creation/Modification/Suppression
 */
@WebServlet(
		name = "ControlGestion", 
		description = "Controleur Gestion", 
		urlPatterns = {"/action/gestion/*"}
		)
public class ControleCreation_Modif_Suppr extends HttpServlet {
	
	private static final long 	serialVersionUID = 1L;
	private RequestDispatcher 	disp;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recuperation du choix
		String path = request.getPathInfo();
		System.out.println("1================  dans ControleurGestion path = " + path );
		
		if (path == null || path.equals("/")) 			doAccueil(request, response);
		else if (path.equals("/abonne/affiche"))		doAbonneAfficheFormulaire(request, response);
		else {
			request.setAttribute("message", "Gestion : Veuillez ne pas toucher l'URL ");
			disp = request.getRequestDispatcher("/"); 
			disp.forward(request,response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation du choix
		String path = request.getPathInfo();
		System.out.println("1================  dans ControleurGestion path=" + path );
		
		if (path == null || path.equals("/")) 			doAccueil(request, response);
		else if (path.equals("/abonne/creer"))			doCreerAnnonce(request, response);
		else if (path.equals("/abonne/modifier"))		doModifAnnonce(request, response);
		else if (path.equals("/abonne/supprimer"))		doSupprimerAnnonce(request, response);
		else {
			request.setAttribute("message", "Gestion : Veuillez ne pas modifer l'URL, merci.. ");
			disp = request.getRequestDispatcher("/"); 
			disp.forward(request,response);
		}
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		disp = request.getRequestDispatcher("/WebContent/vue/Formulaire_Annonce.jsp");  
		disp.forward(request,response);
	}
	
	private void doAbonneAfficheFormulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		disp = request.getRequestDispatcher("/WebContent/vue/ListerAnnonce.jsp");  
		disp.forward(request,response);
	}
	private void doCreerAnnonce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("message", "Creation OK");
		disp = request.getRequestDispatcher("/WebContent/vue/Formulaire_Annonce.jsp"); 
		disp.forward(request,response);
	}
	private void doModifAnnonce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("message", "Modification OK");
		disp = request.getRequestDispatcher("/WebContent/vue/ListerAnnonce.jsp"); 
		disp.forward(request,response);
	}
	private void doSupprimerAnnonce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("message", "Suppression OK");
		disp = request.getRequestDispatcher("/WebContent/vue/ListerAnnonce.jsp"); 
		disp.forward(request,response);
	}


}
