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

		System.out.println("Je suis dans la methode get de SupprimerAnnonce");
		
		int idAnnonce = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<Annonce> annonces = Dao.getAllAnnonce();
		
		System.out.println(idAnnonce);
		
//		for (int i = 0; i < annonces.size(); i++) {
//			if (annonces.get(i).getIdAnnonce() == idAnnonce) {
//				Dao.deleteAnnonce(annonces.get(i));
//				}
//		}
		for (Annonce annonce : annonces) {
			if (annonce.getIdAnnonce() == idAnnonce) Dao.deleteAnnonce(annonce);
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