package fr.albapretiosa.servlet.alain;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.alain.Notification;
import fr.albapretiosa.util.UtilAlain;

/**
 * Servlet implementation class PublierNotif
 * Auteur : Alain
 */
@WebServlet("/PublierNotif")
public class PublierNotif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doGet PublierNotif et j'ai rien � y faire");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Je suis dans doPost Publier Notif");
			HttpSession session = request.getSession(true);
			Admin admin = (Admin) session.getAttribute("Abonne");
			String objet = request.getParameter("objet");
			String message = request.getParameter("message");
			/* Une notification n'a que peut de param�tre � entr� lors de sa cr�ation. L'ID et la date se cr�ant automatiquement pour chaque nouvelle Notification */ 
			Notification notif = new Notification(admin.getAlias(), admin.getIdAbonne(), objet, message);
			Dao.notification.add(notif);
			response.sendRedirect(request.getContextPath()+"/vue/vueAdmin.jsp");
		} catch (Exception e) {
			request.setAttribute("message", "Un champ est vide");
            RequestDispatcher disp = request.getRequestDispatcher(UtilAlain.getErrorLocation());
            disp.forward(request, response);
		}
		
		
		
		System.out.println("Je quitte doPost Publier Notif");
	}

}
