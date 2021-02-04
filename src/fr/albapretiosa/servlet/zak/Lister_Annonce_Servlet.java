package fr.albapretiosa.servlet.zak;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.dao;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;

/**
 * Servlet implementation class Lister_Annonce_Servlet
 */
@WebServlet("/Lister_Annonce_Servlet")
public class Lister_Annonce_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lister_Annonce_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doGet de Lister_Annonce");
		HttpSession session = request.getSession(false);
		Abonne a = (Abonne)session.getAttribute("Abonne");
		ArrayList<Annonce> annonce_liste = new ArrayList<Annonce>();
		RequestDispatcher disp = request.getRequestDispatcher("");	
		
		if(a != null) {
			for(Annonce an : dao.annonces) {
				if(an.getIdAnnonce() == a.getIdAbonne() ) {
					annonce_liste.add(an);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
