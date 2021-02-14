package fr.albapretiosa.servlet.nico;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.dao.Dao;
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
		String context = request.getContextPath();
		ArrayList<Abonne> abonnes = Dao.abonnes;
		ArrayList<Admin> admins = Dao.admins;
		Abonne abonneOk = new Abonne();
		String alias = request.getParameter("alias");
		String mdp = request.getParameter("mdp");
		boolean connectionOk = false;
		
		for(Annonce annonce : Dao.annonces){
			System.out.println(annonce.getDescription()); 
		}
		for (Abonne abonne : abonnes) {
			if(alias.equals(abonne.getAlias()) && mdp.equals(abonne.getMdp())) {
				connectionOk = true;
				abonneOk = abonne;
			}
		}
		for (Admin admin : admins) {
			if(alias.equals(admin.getAlias()) && mdp.equals(admin.getMdp())) {
				connectionOk = true;
				abonneOk = admin;
			}
		}
		if(connectionOk) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Abonne", abonneOk);
			response.sendRedirect(context+"/vue/accueil.jsp");
		}
		else{
			request.setAttribute("message", "Identifiants ou mot de passe incorrect.");
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
		}
	}
}
