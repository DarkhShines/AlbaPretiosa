package fr.albapretiosa.dao;

import java.util.ArrayList;

import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.alain.*;

public class dao {
	public static ArrayList<Abonne> abonnes = initAbo();
	public static ArrayList<String> annonces;
	public static ArrayList<Newsletter> newsletter;
	public static ArrayList<Commentaire> commentaires;
	
	
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
			Abonne abonne1 = new Abonne("Muscat", "Nicolas", "Dayuum", "dayuum@gmail.com", "0607080910", true, "password", "NMD-123" );
			Abonne abonne2 = new Abonne("Dardot", "Alain", "Darkhshines", "darkhshines@gmail.com", "0607030210", false, "password", "DAD-456" );
			Abonne abonne3 = new Abonne("IronmanPremium", "Zack", "Kirby", "kirby@gmail.com", "0601101112", true, "password", "IZK-789" );
			Abonne abonne4 = new Abonne("DupontPremium", "Jack", "Bigboss", "bigboss@gmail.com", "0607717273","0442056322", true, "password", "DJB-264" );
			Abonne abonne5 = new Abonne("Sarkozy", "Eric", "Sarkeric", "sarkeric@gmail.com", "0634764903","0442053242", false, "password", "SES-812" );
			ArrayList<Abonne> abonnes = new ArrayList<Abonne>();
			abonnes.add(abonne1);
			abonnes.add(abonne2);
			abonnes.add(abonne3);
			abonnes.add(abonne4);
			abonnes.add(abonne5);
			return abonnes;
		}
		
		public static ArrayList<Newsletter> initNews() {
			return newsletter;
		}
		
		public static ArrayList<String> initAnnonce() {
			return annonces;
		}
}
