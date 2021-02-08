package fr.albapretiosa.servlet.zak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.albapretiosa.dao.dao;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans la methode post de SupprimerAnnonce");
		
		Annonce a = (Annonce) request.getAttribute("annonce");
		Annonce ab = null;

		for (Annonce annonce : dao.initAnnonce()) {
			if (a.getIdAnnonce() == (annonce.getIdAnnonce())) {
				dao.initAnnonce().remove(a);

				annonce = ab;
			}
		}

		String page = "/vue/ListerAnnnonce.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(page);

		disp.forward(request, response);

	}

}
