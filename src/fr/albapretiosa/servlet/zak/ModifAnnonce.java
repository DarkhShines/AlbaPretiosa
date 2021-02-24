package fr.albapretiosa.servlet.zak;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppException.Exception_Zak;
import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;

/**
 * Servlet implementation class ModifAnnonce
 */
@WebServlet("/ModifAnnonce")
public class ModifAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans le doPost de la servlet ModifAnnonce");
		
		HttpSession session = request.getSession(true);
		
		Abonne a = (Abonne)session.getAttribute("Abonne"); 
		
		
		String titre 			= request.getParameter("titre");		
		int surface 			= Integer.parseInt(request.getParameter("surface").strip());
		int idAnnonce = Integer.parseInt(request.getParameter("id"));
		ArrayList<String> messages = new ArrayList<String>();
		
		for (Annonce ann : Dao.getAllAnnonce()) {
			if (ann.getIdAnnonce() == idAnnonce) {
				ann.setTitre(titre);
				ann.setSurface(surface);
				}
		}
		
		response.sendRedirect("vue/ListerAnnonce.jsp");
	}

}
