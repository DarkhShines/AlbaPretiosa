package fr.albapretiosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import AppException.ExceptionAlain;
import AppException.Exception_Zak;

import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.util.UtilAlain;

import fr.albapretiosa.metier.alain.*;

public class Dao  {
	public static ArrayList<Abonne> abonnes = initAbo();
	public static ArrayList<Admin> admins = initAdmin();
	public static ArrayList<Annonce> annonces = initAnnonce();
	public static ArrayList<Notification> notification = initNotif();
	public static ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();
	public static ArrayList<Abonne> abonnesBan = new ArrayList<Abonne>();
	
	
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver" ;
	private static final String BDD = "schemaalba";
	private static final String USER = "albauser";
	private static final String PASSWD = "Password1";
	private static final String DBURL ="jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" +
			"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	 
	

	

	// Alain : Listera les commentaires d'une annonce (si commentaires il y a) 
	// Affiche des commentaires en dur actuellement, doit être MAJ suivant les classes des autres.
	public static String listCom() {
		String comm ="<div class=\"col-xl-5 col-lg-5 col-md-5 col-sm-12 commEntier\"> ";
		for (Commentaire commentaire : commentaires) {
			comm = "<div class=\"infocomm\">" + 
					"							<p>Le " + UtilAlain.formatDateFr(commentaire.getDateCom())+ ", <span class=\"pseudoSession\">"+ commentaire.getExpediteur() +"</span> a écrit :</p><a class=\"aleft\" href=\"<%=request.getContextPath()%>/modifcomm?idAnnonce=<%= ann.getIdAnnonce()%>\"><i class=\"fas fa-pen imgleft\"></i></a><a href=\"<%=request.getContextPath()%>/suppcomm?idAnnonce=<%= ann.getIdAnnonce()%>\"><i class=\"far fa-trash-alt imgright\"></i></a><br>" + 
					"						</div>" + 
					"						<div class=\"lecomm\">" + 
					"							<p> " + commentaire.getCommentaire() + "</p>" + 
					"						</div>";
		}
		comm +="</div>";
		return comm;
	}

	/**
	 * Méthode qui créer un carrousel et y affiche les 3 annonces présentes en dur dans Dao
	 * @return carousel 
	 * @author Alain, Nico Zak
	 */
	public static String CreateCar() {

		String carrousel = "<div id=\"carouselExampleIndicators\" class=\"carousel slide\""
				+ "		data-ride=\"carousel\"> "
				+ "		<ol class=\"carousel-indicators\"> "
				+ "			<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" "
				+ "				class=\"active\"></li> "
				+ "			<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li> "
				+ "			<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li> "
				+ "		</ol> "
				+ "		<div class=\\\"carousel-inner\\\"> ";


		String car = "";
		String slide = "";
		String act = "active";
		int loop   = 1;

		for(Annonce ann : Dao.annonces){
			if(loop == 1) {
				car = "carrousel1";
				slide = "Premier slide";

				carrousel += 	 "	<div class=\"carousel-item " + act + "  \">"
						+ "					<img class=\"d-block w-100\" src=\"../assets/images/poudlard.jpg\" "
						+ "						alt=\""+ slide + "\"> "
						+ "					<div class=\"" + car + " \">"
						+ "					 <h5><a href=\"/AlbaPretiosa/vue/consulter.jsp?idAnnonce=" + ann.getIdAnnonce() + "\"id=\"white\">"  
						+ 						ann.getTitre() +  "</a></h5>"
						+ "					</div>"
						+ "          </div>";

			}
			else if (loop ==2) {
				car = "carrousel2";
				slide = "Second slide";
				carrousel += 	 "	<div class=\"carousel-item \">"
						+ "					<img class=\"d-block w-100\" src=\"../assets/images/poudlard.jpg\" "
						+ "						alt=\" "+ slide +" \"> "
						+ "					<div class=\"" + car + " \">"
						+ "					  <h5 id=\"white\"><a href=\"/AlbaPretiosa/vue/consulter.jsp?idAnnonce=" + ann.getIdAnnonce() + "\"id=\"white\">"  
						+						 ann.getTitre() +   "</a></h5>"
						+ "					</div>"
						+ "          </div>";

			}
			else {
				car = "carrousel3";
				slide = "Troisième slide";
				carrousel += 	 "	<div class=\"carousel-item \">"
						+ "					<img class=\"d-block w-100\" src=\"../assets/images/poudlard.jpg\" "
						+ "						alt=\" "+ slide +" \"> "
						+ "					<div class=\"" + car + " \">"
						+ "					  <h5 id=\"white\"><a href=\"/AlbaPretiosa/vue/consulter.jsp?idAnnonce=" + ann.getIdAnnonce() +  "\"id=\"white\">"  
						+						 ann.getTitre() +   "</a></h5>"
						+ "					</div>"
						+ "          </div>";
			}
			loop++;
		}
		carrousel +=  "</div> "
				+ "		<a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" "
				+ "			role=\"button\" data-slide=\"prev\"> <span "
				+ "			class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span> <span "
				+ "			class=\"sr-only\">Previous</span> "
				+ "		</a> <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" "
				+ "			role=\"button\" data-slide=\"next\"> <span "
				+ "			class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span> <span "
				+ "			class=\"sr-only\">Next</span> "
				+ "		</a> "
				+ "	</div>";
		return carrousel;
	}


	// Alain : Lors du lancement du serveur des annonces, des abonnés et des Newsletter seront créé en dur
	// Afin de ne pas avoir de site vide.
	public static ArrayList<Abonne> initAbo() {
		// parrainage = initale de Nom Prenom Alias en majuscule - 3 chiffres aléatoires

		// abonne 1,2 et 3 utilise le constructeur sans telFixe, le 4 et le 5 l'utilise

		Abonne abonne1 = new Abonne("user1", "user1", "user1", "user1@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
		Abonne abonne2 = new Abonne("user2", "user2", "user2", "user2@gmail.com", "0634764903","0442053242", "password", "SES-812" );
		Abonne abonne3 = new Abonne("user3", "user3", "user3", "user3@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
		Abonne abonne6 = new Abonne("user4", "user4", "user4", "sarkeric@gmail.com", "0634764903","0442053242", "password", "SES-812" );
		Abonne abonne4 = new Abonne("DupontPremium", "Jack", "Bigboss", "bigboss@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
		Abonne abonne5 = new Abonne("Sarkozy", "Eric", "Sarkeric", "sarkeric@gmail.com", "0634764903","0442053242", "password", "SES-812" );
		ArrayList<Abonne> abonnes = new ArrayList<Abonne>();

		abonnes.add(abonne1);
		abonnes.add(abonne2);
		abonnes.add(abonne3);
		abonnes.add(abonne4);
		abonnes.add(abonne5);
		abonnes.add(abonne6);
		return abonnes;
	}
	public static ArrayList<Admin> initAdmin() {
		// parrainage = initale de Nom Prenom Alias en majuscule - 3 chiffres aléatoires

		Admin Muller = new Admin("Muller", "Dominique", "Muller", "muller@gmail.com", "0607080910", "password", "MDM-123" );
		Admin Dayuum = new Admin("Muscat", "Nicolas", "Dayuum", "dayuum@gmail.com", "0607080910", "password", "NMD-123" );
		Admin DarkhShines = new Admin("Dardot", "Alain", "Darkhshines", "darkhshines@gmail.com", "0607030210", "password", "DAD-456" );
		Admin Zed = new Admin("Bahou", "Zak", "Kirby", "kirby@gmail.com", "0601101112", "password", "IZK-789" );
		ArrayList<Admin> admins = new ArrayList<Admin>();
		admins.add(DarkhShines);
		admins.add(Dayuum);
		admins.add(Zed);
		admins.add(Muller);
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


	/**
	 * Méthode d'instanciation de l'arraylist des annonces
	 * qui contient ann ann1 et ann2 en dur afin d'avoir de la matière à manipuler pour les servlets
	 * @return ArrayListe annonces 
	 */
	public static ArrayList<Annonce> initAnnonce() {
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		ArrayList<String> messages = new ArrayList<String>();
		Annonce ann = null;
		ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		Annonce ann1 = null;
		ann1 = new Annonce("Casa Vivaldi", 1200, "France", "Marseille", LocalDate.of(2018,12,12), LocalDate.of(2022,12,12), "Blablabla", true, false, false, true);
		Annonce ann2 = null;
		ann2 = new Annonce("Chateau Mont Perret", 1200, "France", "Bordeaux", LocalDate.of(2019,12,12), LocalDate.of(2021,12,12), "Blablabla", true, true, false, false);
		annonces.add(ann);
		annonces.add(ann1);
		annonces.add(ann2);
		return annonces;
	}

	public static String listNotif() {
		String listNotif = "";
		for (Notification notification : notification) {
			listNotif += "<div class=\"notification-div\"> " + 
					"	<span class=\"objetNotif\">"+notification.getObjet()+"</span> " + 
					"	<br> " + 
					"	<p>De : "+notification.getExepditeur()+"<br><br> " + 
					"	   Le : notification.getDate()</p><br><br> " + 
					"	<p>"+notification.getTexteNotif()+"</p> " + 
					"</div>";
		}

		return listNotif;
	}
	public static ArrayList<Commentaire> initComm() throws ExceptionAlain {
		Commentaire commentaire1 = new Commentaire("Sarkeric", "Ceci est un commentaire, qui se doit d'être asser long pour passer certains test, ça prend de la place", LocalDate.now(), 1);
		Commentaire commentaire2 = new Commentaire("Sarkeric", "Ceci est un commentaire, asser court", LocalDate.now(), 1);
		Commentaire commentaire3 = new Commentaire("Sarkeric", "Ceci est un commentaire, qui se doit d'être injurieux pour tester ma méthode de filtrage, alors désolé pour ce qui suit : con CoN pute PUTE s a l o p e ", LocalDate.now(), 1);
		ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();
		return commentaires;
	}
	public static String selectAbo() {
		ArrayList<Abonne> abonnes = getAllAbonnes();
		String select = "<label for=\"abo\">Choisir un abonné : </label>" + 
						"<select name=\"abo\" id=\"abo\">";
		for(Abonne abonne : abonnes) {
			select +="    <option value="+abonne.getIdAbonne()+">"+ abonne.getNom()+" , " + abonne.getPrenom() +"</option>\r\n";
		}
		select += "</select>";
		return select;
	}
	
	public static String listAbo() {
		ArrayList<Abonne> abonnes = getAllAbonnes();
		String table = "<table style=\"width:100%\">" + 
				"  <tr>" + 
				"    <th>Id Abonne</th>" + 
				"    <th>Nom</th>" + 
				"    <th>Prenom</th>" + 
				"    <th>Alias</th>" + 
				"  </tr>\r\n";
		for(Abonne abonne : abonnes) {
			table += "  <tr>\r\n" + 
				"    <td>" + abonne.getIdAbonne() + "</td>" + 
				"    <td>" + abonne.getNom()+ "</td>" + 
				"    <td>" + abonne.getPrenom()+ "</td>" + 
				"    <td>" + abonne.getAlias()+ "</td>" ;
			 
		}
				
				table += "</table>";
		
		
		return table;
	}
	
	/* ALAIN ALAIN ALAIN ALAIN ALAIN ALAIN ALAIN ALAIN */
	public static ArrayList<Abonne> getAllAbonnes() {
		ArrayList<Abonne> abonnes = new ArrayList<Abonne>();
		try {
			Class.forName(strNomDriver);
		 
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			String reqSql = ConstRequest.GET_ALL_ABONNES;
			Statement stmt = conn.createStatement();
			ResultSet aboList = stmt.executeQuery(reqSql);
			
			while(aboList.next()) {
				String nom = aboList.getString("nomAbo");
				int id = aboList.getInt("idAbo");
				String prenom = aboList.getString("prenomAbo");
				String mail = aboList.getString("email");
				String alias = aboList.getString("alias");
				String mobile = aboList.getString("telMobile");
				String fixe = aboList.getString("telFixe");
				boolean plat = aboList.getBoolean("platinium");
				


				Abonne abonne = new Abonne();
				
				abonne.setNom(nom);
				abonne.setIdAbonne(id);
				abonne.setPrenom(prenom);
				abonne.setEmail(mail);
				abonne.setAlias(alias);
				abonne.setTelPortable(mobile);
				abonne.setTelFixe(fixe);
				abonne.setPlatinum(plat);
				System.out.println("Nom recup : " + nom + " GetnomAbo : " + abonne.getNom());
				abonnes.add(abonne);
			}
		aboList.close();
		conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return abonnes;
	}
	
	public static void banAbo(int id) {
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
		String reqSql = ConstRequest.BAN_ABO;
		PreparedStatement pstmt = conn.prepareStatement(reqSql);
		pstmt.setInt(1, id);
		pstmt.execute();
		conn.close();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
}
