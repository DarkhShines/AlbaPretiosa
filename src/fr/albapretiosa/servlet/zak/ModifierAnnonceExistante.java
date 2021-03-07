package fr.albapretiosa.servlet.zak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.zak.Annonce;

/**
 * Servlet implementation class ModifierAnnonceExistante
 */
@WebServlet("/ModifierAnnonceExistante")
public class ModifierAnnonceExistante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierAnnonceExistante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Je suis dans le doGet de la servlet ModifAnnonceExistante");
		
		HttpSession session = request.getSession(true);
		
		Annonce an = new Annonce();
		
		String id = request.getParameter("id");
		
		int idAnnonce = Integer.parseInt(id);
		
		for(Annonce annonce : Dao.getAllAnnonce()){
			if(idAnnonce == annonce.getIdAnnonce()){
				an = annonce;
			}
		}
		request.setAttribute("an", an);
		
		String chemin = "vue/consulterUpdate.jsp";
		
		RequestDispatcher disp1 = request.getRequestDispatcher(chemin);
		disp1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
