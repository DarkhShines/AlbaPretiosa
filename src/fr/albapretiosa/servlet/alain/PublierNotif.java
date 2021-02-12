package fr.albapretiosa.servlet.alain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.alain.Notification;

/**
 * Servlet implementation class PublierNotif
 * Auteur : Alain
 */
@WebServlet("/PublierNotif")
public class PublierNotif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doGet PublierNotif et j'ai rien à y faire");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doPost Publier Notif");
		HttpSession session = request.getSession(true);
		Admin admin = (Admin) session.getAttribute("Abonne");
		String objet = request.getParameter("objet");
		String message = request.getParameter("message");
		
		Notification notif = new Notification(admin.getAlias(), admin.getIdAbonne(), objet, message);
		Dao.notification.add(notif);
		response.sendRedirect(request.getContextPath()+"/vue/vueAdmin.jsp");
		
		
		System.out.println("Je quitte doPost Publier Notif");
	}

}
