package fr.albapretiosa.dao;

import java.util.ArrayList;

import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.alain.*;

public class dao {
	public static ArrayList<Abonne> abonnes;
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
			return abonnes;
		}
		
		public static ArrayList<Newsletter> initNews() {
			return newsletter;
		}
		
		public static ArrayList<String> initAnnonce() {
			return annonces;
		}
}
