package fr.albapretiosa.servlet.nico;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.dao.Dao;


/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		ArrayList<Abonne> abonnes = Dao.abonnes;
		Abonne abonneOk = new Abonne();
		PrintWriter out = response.getWriter();
		String alias = request.getParameter("alias");
		String mdp = request.getParameter("mdp");
		boolean connectionOk = false;

		for (Abonne abonne : abonnes) {
			if(alias.equals(abonne.getAlias()) && mdp.equals(abonne.getMdp())) {
				connectionOk = true;
				abonneOk = abonne;
			}
		}
		if(connectionOk) {
			out.println("Connection réussie "+alias);
			HttpSession session = request.getSession(true);
			session.setAttribute("Abonne", abonneOk);
			response.sendRedirect(context+"/vue/infosPersonnelles.jsp");
		}
		else{
			//		request.setAttribute("message", "Identifiants ou mot de passe incorrect.");
			//		RequestDispatcher disp = request.getRequestDispatcher(Erreur.getErrorLocation());
			//		disp.forward(request, response);
			System.out.println("connexion echouée");
		}
	}
}
