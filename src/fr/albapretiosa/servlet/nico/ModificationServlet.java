package fr.albapretiosa.servlet.nico;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppException.Exception_Nico;
import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.util.UtilAlain;
import fr.albapretiosa.dao.Dao;

@WebServlet("/ModificationServlet")
public class ModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context 			= request.getContextPath();
		String alias 			= request.getParameter("alias");
		String mdp 				= request.getParameter("mdp");
		System.out.println(mdp);
		String newMdp 			= request.getParameter("newPassword");
		String mdpConfirm 		= request.getParameter("passwordConfirm");
		String nom 				= request.getParameter("nom");
		String prenom 			= request.getParameter("prenom");
		String email 			= request.getParameter("email");
		String telPortable 		= request.getParameter("phone");
		String telFixe 			= request.getParameter("phone-fixe");
		String parrainage 		= request.getParameter("parrainage");
		boolean modificationOk 	= false;
		ArrayList<Abonne> abonnes = Dao.getAllAbonnes();
		ArrayList<Admin> admins   = Dao.getAllAdmin();
		String aboMdp = Dao.getAbonneMdp(alias);
		String adminMdp = Dao.getAdminMdp(alias);

		try {
			for (Abonne abonne : abonnes) {
				if(alias.equals(abonne.getAlias())) {
					abonne.setEmail(email);
					abonne.setNom(nom);
					abonne.setPrenom(prenom);
					abonne.setParrainage(parrainage);
					abonne.setTelFixe(telFixe);
					abonne.setTelPortable(telPortable);
					if(mdp == null || mdp.trim().equals("")) {
						System.out.println("je suis dans le else de la modif servlet");
						
						Dao.modifAbonne(abonne, false);
						modificationOk = true;
						
					}
					else if (mdp != null) {
						if(aboMdp.equals(mdp) && newMdp.equals(mdpConfirm)) {
							abonne.setMdp(newMdp); 
							System.out.println("je suis ici");
						}
						Dao.modifAbonne(abonne, true);
						modificationOk = true;
					}
				}
			}
			for (Admin admin : admins) {
				if(alias.equals(admin.getAlias())) {
					admin.setEmail(email);
					admin.setNom(nom);
					admin.setPrenom(prenom);
					admin.setParrainage(parrainage);
					admin.setTelFixe(telFixe);
					admin.setTelPortable(telPortable);
					if(adminMdp.equals(mdp) && newMdp.equals(mdpConfirm)) {
						admin.setMdp(newMdp); 
					}
					Dao.modifAdmin(admin);
					modificationOk = true;
				}
			}
			if(modificationOk) {
				response.sendRedirect(context+"/vue/infosPersonnelles.jsp");
			}else {
				throw new Exception_Nico();
			}
		}catch(Exception_Nico en ) {
			request.setAttribute("message", en.getMessage());
			RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
			disp.forward(request, response);
		}
	}

}
