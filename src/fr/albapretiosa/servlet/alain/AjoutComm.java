package fr.albapretiosa.servlet.alain;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Commentaire;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;

/**
 * Servlet implementation class ajouteComm
 */
@WebServlet("/ajouteComm")
public class AjoutComm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutComm() {
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
		System.out.println("Do Post de AjoutComm");
		HttpSession session = request.getSession(true);
		Abonne abonne = (Abonne) session.getAttribute("Abonne");
		String comm = request.getParameter("commentaire");
		int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
		Commentaire commentaire = new Commentaire(abonne.getAlias(), comm , LocalDate.now());
		for(Annonce ann : Dao.annonces) {
			if(ann.getIdAnnonce() == idAnnonce ) {
				ann.addComm(commentaire.getIdCom());
			}
		}
		Dao.commentaires.add(commentaire);
		System.out.println("Do Post de AjoutComm départ");
	}

}
