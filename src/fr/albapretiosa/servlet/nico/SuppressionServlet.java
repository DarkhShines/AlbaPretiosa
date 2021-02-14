package fr.albapretiosa.servlet.nico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AppException.Exception_Nico;
import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.util.UtilAlain;

/**
 * Servlet implementation class SuppressionServlet
 */
@WebServlet("/SuppressionServlet")
public class SuppressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SuppressionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cela devrait directement passer dans post car c'est une suppression
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String alias = request.getParameter("alias");
		boolean supprOk = false;

		try {
			for (Abonne abonne : Dao.abonnes) {
				if(alias.equals(abonne.getAlias())) {
					abonne.setTelFixe("");
					supprOk = true;
				}

			}
			for (Admin admin : Dao.admins) {
				if(alias.equals(admin.getAlias())) {
					admin.setTelFixe("");
					supprOk = true;
				}

			}
			if(supprOk) {
			response.sendRedirect(context+"/vue/infosPersonnelles.jsp");
			}
			else {
				throw new Exception_Nico();
			}
		}catch(Exception_Nico en) {
			request.setAttribute("message", "Suppression Incorrecte");
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
		}
	}

}
