package fr.albapretiosa.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.metier.alain.*;

public class Dao {
	public static ArrayList<Abonne> abonnes = initAbo();
	public static ArrayList<Admin> admins = initAdmin();
	public static ArrayList<Annonce> annonces = initAnnonce();
	public static ArrayList<Notification> notification = initNotif();
	public static ArrayList<Commentaire> commentaires = initComm();
	
	
	// Alain : Listera les commentaires d'une annonce (si commentaires il y a) 
	// Affiche des commentaires en dur actuellement, doit être MAJ suivant les classes des autres.
		public String listCom() {
			String comm ="<div class=\"col-xl-5 col-lg-5 col-md-5 col-sm-12 listcom\">\r\n";
					for (Commentaire commentaire : commentaires) {
						comm = "le 01/01, <span class=\"pseudoSession\">DarkhShines</span> a écrit :<br>\r\n"
								+ "						<div class=\"commentaire\">Commentaire 1<a class=\"aleft\" href=\"#\"><i class=\"fas fa-pen imgleft\"></i></a><a href=\"#\"><i class=\"far fa-trash-alt imgright\"></i></a></div><br>\r\n"
								+ "						<hr>\r\n"
								+ "						Hier, <span class=\"peuso\">Dayuum</span> a écrit :<br>\r\n"
								+ "						<div class=\"commentaire\">Commentaire 2<a href=\"#\"></a></div><br>\r\n"
								+ "						<hr>\r\n"
								+ "						11h37, <span class=\"peuso\">Zed</span> a écrit :<br>\r\n"
								+ "						<div class=\"commentaire\">Commentaire 3<a href=\"#\"></a></div><br>\r\n"
								+ "						<hr>";
					}
					comm +="</div>";
			return null;
		}
		
		
		// Alain : Lors du lancement du serveur des annonces, des abonnés et des Newsletter seront créé en dur
		// Afin de ne pas avoir de site vide.
		public static ArrayList<Abonne> initAbo() {
			// parrainage = initale de Nom Prenom Alias en majuscule - 3 chiffres aléatoires
			
			// abonne 1,2 et 3 utilise le constructeur sans telFixe, le 4 et le 5 l'utilise
			
			Abonne abonne4 = new Abonne("DupontPremium", "Jack", "Bigboss", "bigboss@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
			Abonne abonne5 = new Abonne("Sarkozy", "Eric", "Sarkeric", "sarkeric@gmail.com", "0634764903","0442053242", "password", "SES-812" );
			ArrayList<Abonne> abonnes = new ArrayList<Abonne>();
			
			abonnes.add(abonne4);
			abonnes.add(abonne5);
			return abonnes;
		}
		public static ArrayList<Admin> initAdmin() {
			// parrainage = initale de Nom Prenom Alias en majuscule - 3 chiffres aléatoires
			
			// abonne 1,2 et 3 utilise le constructeur sans telFixe, le 4 et le 5 l'utilise
			Admin Dayuum = new Admin("Muscat", "Nicolas", "Dayuum", "dayuum@gmail.com", "0607080910", "password", "NMD-123" );
			Admin DarkhShines = new Admin("Dardot", "Alain", "Darkhshines", "darkhshines@gmail.com", "0607030210", "password", "DAD-456" );
			Admin Zed = new Admin("Bahou", "Zak", "Kirby", "kirby@gmail.com", "0601101112", "password", "IZK-789" );
			ArrayList<Admin> admins = new ArrayList<Admin>();
			admins.add(DarkhShines);
			admins.add(Dayuum);
			admins.add(Zed);
			return admins;
		}
		
		public static ArrayList<Notification> initNotif() {
			Notification notif1 = new Notification("DarkhShines", 1, "Ouverture de poudlard", "Bla bla kljucoiheahj  aflij a ealcvkhv poiuz lkhrz ;,jnsd lsdihj dspoiuj ");
			Notification notif2 = new Notification("DarkhShines", 2, "Ouverture de numéro 2", "Bla bla kljucoiheahj  aflij a ealcvkhv poiuz lkhrz ;,jnsd lsdihj dspoiuj ");
			Notification notif3 = new Notification("DarkhShines", 3, "Ouverture de numéro 3", "Bla bla kljucoiheahj  aflij a ealcvkhv poiuz lkhrz ;,jnsd lsdihj dspoiuj ");
			ArrayList<Notification> notification = new ArrayList<Notification>();
			notification.add(notif1);
			notification.add(notif2);
			notification.add(notif3);
			return notification;
		}
		
		public static ArrayList<Annonce> initAnnonce() {
			ArrayList<Annonce> annonces = new ArrayList<Annonce>();
			Annonce ann = new Annonce("Manoir DeCruz", 1200, "France", "Hyers", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
			Annonce ann1 = new Annonce("Casa Vivaldi", 1200, "France", "Marseille", LocalDate.of(2018,12,12), LocalDate.of(2022,12,12), "Blablabla", true, false, false, true);
			Annonce ann2 = new Annonce("Chateau Mont Perret", 1200, "France", "Bourg-en-Champagne", LocalDate.of(2019,12,12), LocalDate.of(2021,12,12), "Blablabla", true, true, false, false);
			return annonces;
		}
		
		public static String listNotif() {
			String listNotif = "";
			for (Notification notification : notification) {
				listNotif += "<div class=\"notification-div\">\r\n" + 
						"	<span class=\"objetNotif\">"+notification.getObjet()+"</span>\r\n" + 
						"	<br>\r\n" + 
						"	<p>De : "+notification.getExepditeur()+"<br><br>\r\n" + 
						"	   Le : notification.getDate()</p><br><br>\r\n" + 
						"	<p>"+notification.getTexteNotif()+"</p>\r\n" + 
						"</div>";
			}
			
			return listNotif;
		}
		
		public static String listAnnonces() {
			String annonces = "<ul>";
			for(Annonce ann : Dao.annonces){
			annonces += "<li><a href=\"<%= request.getContextPath() +\"/consulter.jsp?ID=" + ann.getIdAnnonce() + ">" +ann.getTitre() + "</a></li>";
			 } 
			annonces += "</ul>";
			return annonces;
		}
		public static ArrayList<Commentaire> initComm() {
			Commentaire commentaire1 = new Commentaire("Sarkeric", "Ceci est un commentaire, qui se doit d'être asser long pour passer certains test, ça prend de la place", LocalDate.now(), 1);
			Commentaire commentaire2 = new Commentaire("Sarkeric", "Ceci est un commentaire, asser court", LocalDate.now(), 1);
			Commentaire commentaire3 = new Commentaire("Sarkeric", "Ceci est un commentaire, qui se doit d'être injurieux pour tester ma méthode de filtrage, alors désolé pour ce qui suit : con CoN pute PUTE s a l o p e ", LocalDate.now(), 1);
			ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();
			return commentaires;
		}
}
