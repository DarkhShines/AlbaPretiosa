package fr.albapretiosa.servlet.zak;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;

/**
 * Servlet implementation class SupprimerAnnonce
 */
@WebServlet("/SupprimerAnnonce")
public class SupprimerAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans la methode get de SupprimerAnnonce");
		int idAnnonce = Integer.parseInt(request.getParameter("ID"));
		ArrayList<Annonce> annonces = Dao.annonces;
		System.out.println(idAnnonce);
		
		for (int i = 0; i < annonces.size(); i++) {
			if (annonces.get(i).getIdAnnonce() == idAnnonce) {
				Dao.annonces.remove(annonces.get(i));
				}
		}
		
		response.sendRedirect("vue/ListerAnnonce.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
