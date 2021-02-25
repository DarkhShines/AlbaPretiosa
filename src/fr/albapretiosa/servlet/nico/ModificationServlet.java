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

import com.mysql.cj.Session;

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
		String context 				= request.getContextPath();
		Abonne abonneSession 		= null;
		String alias 				= request.getParameter("alias");
		String mdp 					= request.getParameter("mdp");
		String newMdp 				= request.getParameter("newPassword");
		String mdpConfirm 			= request.getParameter("passwordConfirm");
		String nom 					= request.getParameter("nom");
		String prenom 				= request.getParameter("prenom");
		String email 				= request.getParameter("email");
		String telPortable 			= request.getParameter("phone");
		String telFixe 				= request.getParameter("phone-fixe");
		String parrainage 			= request.getParameter("parrainage");
		boolean modificationOk 		= false;
		ArrayList<Abonne> abonnes 	= Dao.getAllAbonnes();
		ArrayList<Admin> admins   	= Dao.getAllAdmin();
		String aboMdp 				= Dao.getAbonneMdp(alias);
		String adminMdp 			= Dao.getAdminMdp(alias);

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
						Dao.modifAbonne(abonne, false);
						modificationOk = true;
						abonneSession  = abonne;

					}
					else if (mdp != null) {
						if(aboMdp.equals(mdp) && newMdp.equals(mdpConfirm)) {
							abonne.setMdp(newMdp); 
							Dao.modifAbonne(abonne, true);
							modificationOk = true;
							abonneSession  = abonne;
						}else {
							throw new Exception_Nico("Les mots de passe sont incorrects");
						}

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
					if(mdp == null || mdp.trim().equals("")) {
						Dao.modifAdmin(admin, false);
						modificationOk = true;
						abonneSession  = admin;
					}
					else if (mdp != null) {
						if(adminMdp.equals(mdp) && newMdp.equals(mdpConfirm)) {
							admin.setMdp(newMdp); 
							Dao.modifAdmin(admin, true);
							modificationOk = true;
							abonneSession  = admin;
						}else {
							throw new Exception_Nico("Les mots de passe sont incorrects");
						}
					}
				}
			}
			if(modificationOk) {
				HttpSession session = (HttpSession) request.getSession(true);
				session.setAttribute("Abonne", abonneSession);
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
