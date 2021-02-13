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
		else if (path.equals("/abonne/creer"))			doAbonneCreer(request, response);
		else if (path.equals("/abonne/modifier"))		doAbonneModifier(request, response);
		else if (path.equals("/abonne/supprimer"))		doAbonneSupprimer(request, response);
		else {
			request.setAttribute("msgErreur", "Gestion : Vous avez tripatouill&eacute; l'url!!! ");
			disp = request.getRequestDispatcher("/"); 
			disp.forward(request,response);
		}
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		disp = request.getRequestDispatcher("/WEB-INF/vue/gestion/gestion.jsp"); 
		disp.forward(request,response);
	}
	
	private void doAbonneAfficheFormulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		disp = request.getRequestDispatcher("/WEB-INF/vue/gestion/formAbonne.jsp"); 
		disp.forward(request,response);
	}
	private void doAbonneCreer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("message", "Creation OK");
		disp = request.getRequestDispatcher("/WEB-INF/vue/gestion/formAbonne.jsp"); 
		disp.forward(request,response);
	}
	private void doAbonneModifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("message", "Modification OK");
		disp = request.getRequestDispatcher("/WEB-INF/vue/gestion/formAbonne.jsp"); 
		disp.forward(request,response);
	}
	private void doAbonneSupprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("message", "Suppression OK");
		disp = request.getRequestDispatcher("/WEB-INF/vue/gestion/formAbonne.jsp"); 
		disp.forward(request,response);
	}


}
