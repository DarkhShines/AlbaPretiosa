package fr.albapretiosa.servlet.zak;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppException.Exception_Zak;
import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.dao.Dao2;
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
		
		int idAnnonce = Integer.parseInt(request.getParameter("id")); 
		
		
		String titre 			= request.getParameter("titre");	
		
		int surface 			= Integer.parseInt(request.getParameter("surface").strip());
		
		LocalDate creneauDebut  = LocalDate.parse(request.getParameter("datedebut"));
		
		LocalDate creneauFin    = LocalDate.parse(request.getParameter("datefin"));
		
		String description		= request.getParameter("description"); 
		
		

		
		for (Annonce ann : Dao.getAllAnnonce()) {
			if ( idAnnonce == ann.getIdAnnonce()) {
				ann.setTitre(titre);
				ann.setSurface(surface);
				ann.setCreneauDebut(creneauDebut);
				ann.setCreneauFin(creneauFin);
				ann.setDescription(description);
				Dao.updateAnnonce(ann);
				}
		}

		String chemin = "vue/ListerAnnonce.jsp";
		
		RequestDispatcher disp1 = request.getRequestDispatcher(chemin);
		disp1.forward(request, response);
	}

}
