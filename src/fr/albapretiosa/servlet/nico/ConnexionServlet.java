package fr.albapretiosa.servlet.nico;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.util.UtilAlain;


/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnexionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do post connexion servlet");
		String context = request.getContextPath();
		String alias = request.getParameter("alias");
		String mdp = request.getParameter("mdp");
		boolean connectionOk = false;



		boolean adminOk		 = false;
		Abonne abonne = new Abonne();
		Admin  admin  = new Admin();

		try {

			abonne 		 = Dao.getAbonne(alias, mdp);
			connectionOk = abonne.getAlias() != null;

		}catch(NullPointerException npe) {
			admin = Dao.getAdmin(alias, mdp);
			adminOk 	= admin.getAlias() != null;

		}


		if(connectionOk) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Abonne", abonne);
			response.sendRedirect(context+"/vue/accueil.jsp");
		}
		else if(adminOk) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Abonne", admin);
			response.sendRedirect(context+"/vue/accueil.jsp");
		}
		else{
			request.setAttribute("message", "Identifiants ou mot de passe incorrect.");
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
		}
	}
<<<<<<< HEAD
}
=======
}

>>>>>>> refs/remotes/origin/Zakarya_1
