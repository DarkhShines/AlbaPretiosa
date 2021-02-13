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

import AppException.Exception_Nico;
import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.util.UtilAlain;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		ArrayList<Abonne> abonnes = Dao.abonnes;
		PrintWriter out = response.getWriter();
		String alias = request.getParameter("alias");
		String mdp = request.getParameter("mdp");
		String mdpConfirm = request.getParameter("mdpConfirm");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telPortable = request.getParameter("phone");
		String parrainage = request.getParameter("parrainage");
		boolean inscriptionOk = false;
		boolean pwOk = false;
		
		
		for (Abonne abonne : abonnes) {
			if(!alias.equals(abonne.getAlias()) &&  !email.equals(abonne.getEmail())) {
				inscriptionOk = true;
			}
		}
		if(mdp.equals(mdpConfirm)) {
			pwOk = true;
		}
		if(inscriptionOk && pwOk) {
			out.println("Connection réussie "+alias);
			Abonne abonneOk = new Abonne(nom, prenom, alias, email, telPortable, mdp, parrainage);
			Dao.abonnes.add(abonneOk);
			response.sendRedirect(context+"/index.jsp");
		}
		else{
			request.setAttribute("message", "Inscription échouée");
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
		}
	}
	
	

}
