package fr.albapretiosa.servlet.alain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Commentaire;
import fr.albapretiosa.metier.nico.Abonne;

/**
 * Servlet implementation class ModifComm
 */
@WebServlet("/modifcomm")
public class ModifComm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifComm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Get de ModifComm");
		HttpSession session = request.getSession(true);
		int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
		Abonne abonne = (Abonne) session.getAttribute("Abonne"); // Je récupère l'abonné en session
		String comm = request.getParameter("commentaire"); // La modification du corp du commentaire, qui est la seule variable modifiable suite à l'envoi
		int idComm = Integer.parseInt(request.getParameter("idComm"));
		for(Commentaire commentaire : Dao.commentaires) {
			if(commentaire.getIdCom() == idComm) { // Je cherche dans tout les commentaires lequel à l'ID que je récupère via l'url 
				commentaire.setCommentaire(comm);
			}
		}
		
		System.out.println("Do Get de ModifComm fin");
		response.sendRedirect("vue/consulter.jsp?idAnnonce="+idAnnonce+"");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
