package fr.albapretiosa.dao;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;

import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import AppException.ExceptionAlain;
import AppException.Exception_Zak;

import AppException.Exception_Nico;

import fr.albapretiosa.dao.ConstRequest;
import fr.albapretiosa.dao.Dao;
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


	public static Annonce getAnnonceById(int idAnnonce){
		Annonce trouve = null;
		try {
			Class.forName(strNomDriver);
			String rqSQL = ConstRequest.GETANNONCE;

			//Créer une connexion et l'ouvrir
			Connection con = DriverManager.getConnection(DBURL, USER, PASSWD); 

			//Ecrire la requete
			PreparedStatement pstmt = con.prepareStatement(rqSQL);

			pstmt.setInt(1,  idAnnonce);

			//Executer le statement
			ResultSet rs   = pstmt.executeQuery();

			System.out.println("Dao PreparedStatement : " + pstmt + "");


			if(rs.next()) {
				int idAnnonce1 = rs.getInt("idAnnonce");

				//Reconstruire les objets
				Annonce ann = new Annonce();
				ann.setIdAnnonce(idAnnonce1);
				//Le mettre dans trouve
				trouve = ann;
			}

			rs.close();
			con.close();

		} catch(Exception_Zak e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver non trouvé" + e.getMessage());
		} catch(SQLException e) {
			System.err.println("Erreur 2 : " 
					+ " SQLException: " 	+ e.getMessage()
					+ " SQLState: " 		+ e.getSQLState()
					+ " VendorError: " 	+ e.getErrorCode());
		}




		return trouve;

	}








	// Alain : Listera les commentaires d'une annonce (si commentaires il y a) 
	// Affiche des commentaires en dur actuellement, doit être MAJ suivant les classes des autres.
	public static String listCom(int idAnnonce) {
		ArrayList<Commentaire> commentaires = getAllComm();
		String comm ="";
		for (Commentaire commentaire : commentaires) {
			if(idAnnonce == commentaire.getIdAnnonce()) {
				System.out.println(1);
				comm += "<div class=\"infocomm\">" + 
						"<p>Le " + UtilAlain.formatDateFr(commentaire.getDateCom())+ ", <span class=\"pseudoSession\">"+ commentaire.getExpediteur() +"</span> a écrit :</p><a class=\"aleft\" href=\"<%=request.getContextPath()%>/modifcomm?idAnnonce=<%= ann.getIdAnnonce()%>\"><i class=\"fas fa-pen imgleft\"></i></a><a href=\"<%=request.getContextPath()%>/suppcomm?idAnnonce=<%= ann.getIdAnnonce()%>\"><i class=\"far fa-trash-alt imgright\"></i></a><br>" + 
						"<p> " + commentaire.getCommentaire() + "</p>" + 
						"</div>";
			}
		}
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
	public static Abonne getAbonne(String alias, String mdp) {

		Abonne trouve = null;

		try {

			// verifier la config 
			Class.forName(strNomDriver);

			// creer une connexion et l'ouvrir
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);

			// ecrire la requete
			String recupAbo = ConstRequest.GET_ABO;

			// creer le statement ou preparestatement
			PreparedStatement pstmt = conn.prepareStatement(recupAbo);

			// renseigner le prepare statement 
			pstmt.setString(1, alias);
			pstmt.setString(2, mdp);

			// excuter le statement 
			ResultSet rs = pstmt.executeQuery();

			// recuperer les donnees avec result set 
			if(rs.next()) {
				String aliasAbo 		= rs.getString("alias");
				String nomAbo			= rs.getString("nomAbo");
				String prenomAbo		= rs.getString("prenomAbo");
				String telFixe			= rs.getString("telFixe");
				String telMobile		= rs.getString("telMobile");
				String parrainage		= rs.getString("code_parrainage");
				String email			= rs.getString("email");
				int    idAbo			= rs.getInt("idAbo");
				int    diff 			= 1;

				// reconstruire l'objet
				Abonne abonne = new Abonne(nomAbo, prenomAbo, aliasAbo, email, telMobile, telFixe, parrainage, diff);
				abonne.setIdAbonne(idAbo);
				trouve = abonne;
			}
			rs.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}
		catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}
		return trouve;
	}
	public static String getAbonneMdp(String alias) {

		String trouve = null;

		try {

			// verifier la config 
			Class.forName(strNomDriver);

			// creer une connexion et l'ouvrir
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);

			// ecrire la requete
			String recupAbo = ConstRequest.GET_ABO_MDP;

			// creer le statement ou preparestatement
			PreparedStatement pstmt = conn.prepareStatement(recupAbo);

			// renseigner le prepare statement 
			pstmt.setString(1, alias);

			// excuter le statement 
			ResultSet rs = pstmt.executeQuery();

			// recuperer les donnees avec result set 
			if(rs.next()) {

				String mdp				= rs.getString("mdp");

				trouve = mdp;
			}
			rs.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}
		catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}
		return trouve;
	}
	public static String getAdminMdp(String alias) {

		String trouve = null;

		try {

			// verifier la config 
			Class.forName(strNomDriver);

			// creer une connexion et l'ouvrir
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);

			// ecrire la requete
			String recupAdmin = ConstRequest.GET_ADMIN_MDP;

			// creer le statement ou preparestatement
			PreparedStatement pstmt = conn.prepareStatement(recupAdmin);

			// renseigner le prepare statement 
			pstmt.setString(1, alias);

			// excuter le statement 
			ResultSet rs = pstmt.executeQuery();

			// recuperer les donnees avec result set 
			if(rs.next()) {
				String mdp	= rs.getString("mdp");
				trouve 		= mdp;
			}
			rs.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}
		catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}
		return trouve;
	}
	public static Abonne creerAbonne(Abonne abonne) throws Exception_Nico{
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			String creerAbonne = ConstRequest.CREATE_ABO;

			PreparedStatement pstmt 	= conn.prepareStatement(creerAbonne);


			pstmt.setInt	(1,  abonne.getIdAbonne());
			pstmt.setString	(2,  abonne.getNom());
			pstmt.setString	(3,  abonne.getPrenom());
			pstmt.setString	(4,  abonne.getAlias());
			pstmt.setString	(5,  abonne.getEmail());
			pstmt.setString	(6,  abonne.getTelPortable());
			pstmt.setString	(7,  abonne.getTelFixe());
			pstmt.setBoolean(8,  abonne.isPlatinum());
			pstmt.setString	(9,  abonne.getMdp());
			pstmt.setString	(10, abonne.getParrainage());
			pstmt.setBoolean(11, abonne.isBan());

			pstmt.executeUpdate();

			pstmt.close();

			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}catch(SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1062) {
				throw new Exception_Nico("Cet abonne existe déjà");
			}
		}catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}

		return abonne;
	}
	public static Abonne modifAbonne(Abonne abonne) throws Exception_Nico{
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			
			String modifAbonne = ConstRequest.MODIF_ABO;
			PreparedStatement pstmt 	= conn.prepareStatement(modifAbonne);

			pstmt.setString	(1,  abonne.getNom());
			pstmt.setString	(2,  abonne.getPrenom());
			pstmt.setString	(3,  abonne.getEmail());
			pstmt.setString	(4,  abonne.getTelPortable());
			pstmt.setString	(5,  abonne.getTelFixe());
			if(abonne.getMdp() != null)pstmt.setString (6,  abonne.getMdp());
			pstmt.setString	(7,	 abonne.getParrainage());
			pstmt.setString	(8,	 abonne.getAlias());
			System.out.println("Affichage du statement"+pstmt);
			pstmt.executeUpdate();

			pstmt.close();

			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}catch(SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1062) {
				throw new Exception_Nico("Cet abonne existe déjà");
			}
		}catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}

		return abonne;
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
	public static Admin getAdmin(String alias, String mdp) {

		Admin trouve = null;

		try {

			// verifier la config 
			Class.forName(strNomDriver);

			// creer une connexion et l'ouvrir
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);

			// ecrire la requete
			String recupAdmin = ConstRequest.GET_ADMIN;

			// creer le statement ou preparestatement
			PreparedStatement pstmt = conn.prepareStatement(recupAdmin);

			// renseigner le prepare statement 
			pstmt.setString(1, alias);
			pstmt.setString(2, mdp);

			// excuter le statement 
			ResultSet rs = pstmt.executeQuery();

			// recuperer les donnees avec result set 
			if(rs.next()) {
				String aliasAdmin 		= rs.getString("alias");
				String nomAdmin			= rs.getString("nomAdmin");
				String prenomAdmin		= rs.getString("prenomAdmin");
				String telFixe			= rs.getString("telFixe");
				String telMobile		= rs.getString("telMobile");
				String parrainage		= rs.getString("parrainage");
				String email			= rs.getString("email");
				int    idAdmin			= rs.getInt("idAdmin");
				int	   diff				= 1;
				// reconstruire l'objet
				Admin admin = new Admin(nomAdmin, prenomAdmin, aliasAdmin, email, telMobile, telFixe, parrainage, diff );
				admin.setIdAbonne(idAdmin);
				trouve = admin;
			}
			rs.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}
		catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}
		return trouve;
	}
	public static Admin modifAdmin(Admin admin) throws Exception_Nico{
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			String modifAdmin = ConstRequest.MODIF_ADMIN;

			PreparedStatement pstmt 	= conn.prepareStatement(modifAdmin);

			pstmt.setString	(1,  admin.getNom());
			pstmt.setString	(2,  admin.getPrenom());
			pstmt.setString	(3,  admin.getEmail());
			pstmt.setString	(4,  admin.getTelPortable());
			pstmt.setString	(5,  admin.getTelFixe());
			pstmt.setString	(6,  admin.getMdp());
			pstmt.setString	(7,	 admin.getParrainage());
			pstmt.setString	(8,	 admin.getAlias());

			pstmt.executeUpdate();

			pstmt.close();

			conn.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Erreur : " + e);
		}catch(SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1062) {
				throw new Exception_Nico("Cet abonne existe déjà");
			}
		}catch(SQLException s) {
			System.err.println("Erreur 2 Appel2Connexion : " + s.getSQLState() + " , " + " (" + s + ")");
		}

		return admin;
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
		ArrayList<Notification> notifs = getAllNotif();
		String listNotif = "";
		for (Notification notification : notifs) {
			listNotif += "<div class=\"notification-div\"> " + 
					"	<span class=\"objetNotif\">"+notification.getObjet()+"</span> " + 
					"	<br> " + 
					"	<p>De : "+notification.getExepditeur()+"<br><br> " + 
					"	   Le : "+  UtilAlain.formatDateFr(notification.getDateNotif()) + "</p><br><br> " + 
					"	<p>"+notification.getTexteNotif()+"</p> " + 
					"</div>";
		}

		return listNotif;
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
	public static ArrayList<Admin> getAllAdmin() {
		ArrayList<Admin> admins = new ArrayList<Admin>();
		try {
			Class.forName(strNomDriver);

			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			String reqSql = ConstRequest.GET_ALL_ADMIN;
			Statement stmt = conn.createStatement();
			ResultSet adminList = stmt.executeQuery(reqSql);

			while(adminList.next()) {
				String nom 		= adminList.getString("nomAdmin");
				int id 			= adminList.getInt("idAdmin");
				String prenom 	= adminList.getString("prenomAdmin");
				String mail 	= adminList.getString("email");
				String alias 	= adminList.getString("alias");
				String mobile 	= adminList.getString("telMobile");
				String fixe 	= adminList.getString("telFixe");
				boolean plat 	= adminList.getBoolean("platinium");

				Admin admin = new Admin();

				admin.setNom(nom);
				admin.setIdAbonne(id);
				admin.setPrenom(prenom);
				admin.setEmail(mail);
				admin.setAlias(alias);
				admin.setTelPortable(mobile);
				admin.setTelFixe(fixe);
				admin.setPlatinum(plat);
				System.out.println("Nom recup : " + nom + " GetnomAdmin : " + admin.getNom());
				admins.add(admin);
			}
			adminList.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admins;
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

	public static void ajoutComm(Commentaire comm, Abonne abonne) {
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			String reqSql = ConstRequest.ADD_COMMENTAIRE;
			
			PreparedStatement pstmt = conn.prepareStatement(reqSql);
			pstmt.setString(1, comm.getCommentaire());
			pstmt.setInt(2, abonne.getIdAbonne());
			pstmt.setInt(3, comm.getIdAnnonce());
			pstmt.setInt(4, comm.getIdCom());
			
			pstmt.setString(5, comm.getDateCom().toString());
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
	public static void publierNotif( Notification notif, Admin admin) {
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			String reqSql = ConstRequest.PUBLIER_NOTIF;
			
			PreparedStatement pstmt = conn.prepareStatement(reqSql);
			pstmt.setString(1, notif.getIdNotif());
			pstmt.setString(2, notif.getObjet());
			pstmt.setString(3, notif.getTexteNotif());
			pstmt.setString(4, notif.getDateNotif().toString());
			pstmt.setInt(5, notif.getIdExpediteur());
			
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
	public static ArrayList<Notification> getAllNotif() {
		ArrayList<Notification> notifs = new ArrayList<Notification>();
		
			try {
				Class.forName(strNomDriver);
				Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
				String reqSql = ConstRequest.GET_ALL_NOTIF;
				Statement stmt = conn.createStatement();
				ResultSet notifList = stmt.executeQuery(reqSql);
				while (notifList.next()) {
					
					//String idNotif = notifList.getString("idNotif"); Pas besoin de l'ID pour l'affiché. 
					String objetNotif = notifList.getString("objetNotif");
					String textNotif = notifList.getString("textNotif");
					LocalDate date = LocalDate.parse(notifList.getString("dateNotif"));
					int idAdmin = notifList.getInt("idAdmin");
					String expediteur = getAliasFromIdAdmin(idAdmin);
					Notification notif = new Notification(expediteur, idAdmin, objetNotif, textNotif);
					notifs.add(notif);
				}
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return notifs;
}
		

	public static ArrayList<Commentaire> getAllComm() {
			ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();
			
				try {
					Class.forName(strNomDriver);
					Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
					String reqSql = ConstRequest.GET_ALL_COMM;
					Statement stmt = conn.createStatement();
					ResultSet comList = stmt.executeQuery(reqSql);
					while (comList.next()) {
						
						String comm = comList.getString("com");
						String dateComm = comList.getString("dateCom");
						LocalDate date = LocalDate.parse(dateComm);
						int idAbo = comList.getInt("idAbo");
						String expediteur = getAliasFromId(idAbo);
						int idAnnonce = comList.getInt("idAnnonce");
						Commentaire commentaire = new Commentaire(expediteur, comm, date, idAnnonce);
						commentaires.add(commentaire);
					}
					conn.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return commentaires;
	}
	private static String getAliasFromId(int idAbo) {
		ArrayList<Abonne> abonnes = getAllAbonnes();
		String expediteur = "";
		for (Abonne abonne : abonnes) {
			if(idAbo == abonne.getIdAbonne()) expediteur = abonne.getAlias();
		}
		return expediteur;
	}
	private static String getAliasFromIdAdmin(int idAdmin) {
		ArrayList<Admin> admins = getAllAdmin();
		String expediteur = "";
		for (Admin admin : admins) {
			if(idAdmin == admin.getIdAbonne()) expediteur = admin.getAlias();
		}
		return expediteur;
	}
}
