package fr.albapretiosa.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import AppException.Exception_Zak;
import fr.albapretiosa.metier.alain.Admin;
import fr.albapretiosa.metier.alain.Commentaire;
import fr.albapretiosa.metier.alain.Notification;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.metier.zak.Annonces;
import fr.albapretiosa.metier.zak.Options;
import fr.albapretiosa.metier.zak.Ville;
import fr.albapretiosa.util.UtilAlain;

public class Dao  {

	public static Annonces annonces		 = getAllAnnonce();
	public static ArrayList<Notification> notification = initNotif();
	public static ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();
	public static ArrayList<Abonne> abonnesBan = new ArrayList<Abonne>();



	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver" ;
	private static final String BDD = "schemaalba";
	private static final String USER = "albauser";
	private static final String PASSWD = "Password1";
	private static final String DBURL ="jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" +
			"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	/**
	 * Methode pour récupérer toute les annonces
	 * @return annonces de type Annonces
	 */
	public static Annonces getAllAnnonce() {
		Annonces annonces = new Annonces();

		try {
			Class.forName(strNomDriver);

			//Créer une connexion et l'ouvrir
			System.out.println("Connexion");
			Connection con = DriverManager.getConnection(DBURL, USER, PASSWD); 			// Objet qui créer de la connection avec la BD
			System.out.println("Connexion Ok");
			//Ecrire la requete
			String rqSQL = ConstRequest.GETALLANNONCE;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(rqSQL);

			while(rs.next()) {
				int idAnnonce 			= rs.getInt("idAnnonce");
				String titreAnnonce 	= rs.getString("titreAnnonce");
				int surfaceAnnonce 		= rs.getInt("surfaceAnnonce");
				String creneauDebut1 	= rs.getString("creneau_debut");
				String creneauFin1 		= rs.getString("creneau_fin");
				String description 		= rs.getString("description");
				int idAbo				= rs.getInt("idAbo");
				int idVille				= rs.getInt("idVille");

				Ville ville = new Ville(idVille); 
				Abonne abo = getAboById(idAbo);
				//convert String to LocalDate
				LocalDate creneauDebut = LocalDate.parse(creneauDebut1);
				LocalDate creneauFin   = LocalDate.parse(creneauFin1);


				annonces.add(new Annonce(idAnnonce, titreAnnonce, surfaceAnnonce, creneauDebut, creneauFin, description, abo, ville));

			}
			rs.close();
			con.close();


		} catch(ClassNotFoundException e){ 	
			System.err.println("GET ALL ANNONCE - CLASSNOTFOUND : " + e); 
		} catch (SQLException s){ 		
			s.printStackTrace();
			System.err.println("GET ALL ANNONCE - SQLEXCEPTION : " 
					+ " SQLException: " 	+ s.getMessage()
					+ " SQLState: " 		+ s.getSQLState()
					+ " VendorError: " 	+ s.getErrorCode());

		}


		return annonces;

	}
	
	/**
	 * Methode pour récupérer toute les annonces
	 * @return annonces de type Annonces
	 */
	public static Annonces getAllAnnonceById(Abonne abonne) {
		Annonces annonces = new Annonces();
		
		
		try {
			Class.forName(strNomDriver);
			
			//Créer une connexion et l'ouvrir
			System.out.println("Connexion");
			Connection con = DriverManager.getConnection(DBURL, USER, PASSWD); 			// Objet qui créer de la connection avec la BD
			System.out.println("Connexion Ok");
			//Ecrire la requete
			String rqSQL = ConstRequest.GETALLANNONCEBYID;
			
			PreparedStatement pstmt = con.prepareStatement(rqSQL);
			
			pstmt.setInt(1, abonne.getIdAbonne());
			
			ResultSet rs = pstmt.executeQuery();
			


			while(rs.next()) {
				int idAnnonce 			= rs.getInt("idAnnonce");
				String titreAnnonce 	= rs.getString("titreAnnonce");
				int surfaceAnnonce 		= rs.getInt("surfaceAnnonce");
				String creneauDebut1 	= rs.getString("creneau_debut");
				String creneauFin1 		= rs.getString("creneau_fin");
				String description 		= rs.getString("description");
				int idAbo				= rs.getInt("idAbo");
				int idVille				= rs.getInt("idVille");

				Ville ville = new Ville(idVille); 
				Abonne abo = getAboById(idAbo);
				//convert String to LocalDate
				LocalDate creneauDebut = LocalDate.parse(creneauDebut1);
				LocalDate creneauFin   = LocalDate.parse(creneauFin1);


				annonces.add(new Annonce(idAnnonce, titreAnnonce, surfaceAnnonce, creneauDebut, creneauFin, description, abo, ville));

			}
			rs.close();
			con.close();
			pstmt.close();


		} catch(ClassNotFoundException e){ 	
			System.err.println("GET ALL ANNONCE - CLASSNOTFOUND : " + e); 
		} catch (SQLException s){ 		
			s.printStackTrace();
			System.err.println("GET ALL ANNONCE - SQLEXCEPTION : " 
					+ " SQLException: " 	+ s.getMessage()
					+ " SQLState: " 		+ s.getSQLState()
					+ " VendorError: " 	+ s.getErrorCode());

		}


		return annonces;

	}



	public static Annonce createAnnonce(Annonce annonce) throws Exception_Zak{

		try {
			Objects.requireNonNull(annonce);
			Class.forName(strNomDriver);
			//Créer une connexion et l'ouvrir
			System.out.println("Connexion");
			Connection con = DriverManager.getConnection(DBURL, USER, PASSWD); 			// Objet qui créer de la connection avec la BD
			System.out.println("Connexion Ok");
			PreparedStatement pstmt = null;

			//Ecrire la requete
			String rqSQL = ConstRequest.CREATEANNONCE;
			pstmt = con.prepareStatement(rqSQL);
			//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/YYYY");

			Integer idAnnonce = (annonce.getIdAnnonce() != 0) ? annonce.getIdAnnonce() : null;
			String titreAnnonce = (annonce.getTitre() != null) ? annonce.getTitre() : null;
			System.out.println("Dao1 - CreateAnnonce - Pas 1 " + annonce);
			Abonne abonne	 	= annonce.getAbonne()  ;
			System.out.println("Dao1 - CreateAnnonce - Pas 2 " + annonce);
			int surfaceAnnonce = (annonce.getSurface() != 0) ? annonce.getSurface() : null;
			System.out.println("Dao1 - CreateAnnonce - Pas 3 " + annonce);
			String description = (annonce.getDescription() != null) ? annonce.getDescription() : null;
			System.out.println("Dao1 - CreateAnnonce - Pas 4 " + annonce);
			Ville ville			= annonce.getVille() ;
			System.out.println("Dao1 - CreateAnnonce - Pas 5 " + annonce);
			Options options = annonce.getOptions();
			int idVille = ville.getIdVille();
			//	idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille
			pstmt.setInt(1, idAnnonce);
			System.out.println("Dao1 - CreateAnnonce - Pas 6 ");
			pstmt.setString(2, titreAnnonce);
			System.out.println("Dao1 - CreateAnnonce - Pas 7 ");
			pstmt.setInt(3, surfaceAnnonce);
			System.out.println("Dao1 - CreateAnnonce - Pas 8 ");
			UtilAlain.setDateToPreparedStatement(pstmt, 4, annonce.getCreneauDebut());
			System.out.println("Dao1 - CreateAnnonce - Pas 9 ");
			UtilAlain.setDateToPreparedStatement(pstmt, 5, annonce.getCreneauFin());
			System.out.println("Dao1 - CreateAnnonce - Pas 10 ");
			pstmt.setString(6, description);
			System.out.println("Dao1 - CreateAnnonce - Pas 11 ");
			pstmt.setInt(7, abonne.getIdAbonne());
			System.out.println("Dao1 - CreateAnnonce - Pas 12 ");
			//			pstmt.setObject(8, options);
			pstmt.setInt(8, idVille);
			//pstmt.setObject(9, options);

			System.out.println(pstmt);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		}  catch(NullPointerException e) {
			String erreur = "*** Application - createAnnonce - ERROR - NullPointerException" 
					+ "Erreur : " + e.getMessage()
					+ "Cause : " + e.getCause();

			System.out.println(erreur);
			e.printStackTrace();
		} catch (SQLException e) {
			String erreur = "*** Application - createAnnonce - ERROR - SQLException"
					+ "Erreur : " + e.getMessage()
					+ "State : " + e.getSQLState()
					+ "Code Erreur : " + e.getErrorCode()
					+ "Cause : " + e.getCause();

			System.out.println(erreur);


		} catch(ClassNotFoundException e)  {
			System.err.println("*** Application - createAnnonce - ClassNotFoundException "  + e.getMessage() ); 
		}
		return annonce ;

	}



	/**
	 * Methode pour récupérer une annonce par son ID
	 * A utiliser dans la liste des annonces
	 * @param idAnnonce / Parametre qui me sert à recuperer une annonce
	 * @return
	 * @throws Exception_Zak
	 * @author Zakarya D. Bahou
	 */


	public static Annonce getAnnonceById(int idAnnonce) throws Exception_Zak{

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

			pstmt.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			String erreur = "*** Application - getAnnonceById - ERROR - SQLIntegrityConstraintViolationException"
					+ " Erreur : " + e.getMessage()
					+ " State : " + e.getSQLState()
					+ " Code Erreur : " + e.getErrorCode()
					+ " Cause : " + e.getCause();

			System.out.println(erreur);	

			if		(e.getErrorCode() == 1062) throw new Exception_Zak(9901," Erreur : Annonce dupliqué ");
			else if (e.getErrorCode() == 1452) throw new Exception_Zak(9902, " Le numero abonné non existant ");
			else if (e.getErrorCode() == 1048) {
				if(e.getMessage().contains("idAnnonce")) 		 throw new Exception_Zak(9903, " ID annonce est obligatoire ");
				else if (e.getMessage().contains("idAbonne")) 	 throw new Exception_Zak(9904, " Abonne obligatoire ");
			}
		} catch (SQLException e) {
			System.out.println("*** Application - getAnnonceById - ERROR - SQLException"
					+ " Erreur : " 		+ e.getMessage()
					+ " State : "		+ e.getSQLState()
					+ " Code Erreur : " + e.getErrorCode()
					+ " Cause : " 		+ e.getCause());


		} catch(Exception_Zak e) {

		} catch (ClassNotFoundException e) {
			System.out.println( "*** Application - getAnnonceById - ERROR - ClassNotFoundException"
					+ " Erreur : " + e.getMessage()
					+ " Cause : " + e.getCause());
		} finally {
			System.out.println("Sortie du getAnnonceById");
		}




		return trouve;

	}
	
	/**
	 * Méthode qui modifie une annonce
	 * @param annonce
	 * @return
	 */
	public static Annonce updateAnnonce(Annonce annonce) {
		Annonce trouve = null;

		//Recherche dans le BD
		try {
			//Vérifier la configuration
			Class.forName(strNomDriver);

			String rqSQL = ConstRequest.UPDATEANNONCE;

			//Créer une connexion et l'ouvrir
			Connection con = DriverManager.getConnection(DBURL, USER, PASSWD); 			// Objet qui créer de la connection avec la BD

			//Ecrire la requete
			PreparedStatement test = con.prepareStatement(rqSQL);


			test.setString(1, annonce.getTitre());
			test.setInt(2, annonce.getSurface());
			test.setString(3, annonce.getCreneauDebut().toString());
			test.setString(4, annonce.getCreneauFin().toString());
			test.setString(5, annonce.getDescription());
			
			test.setInt(6, annonce.getIdAnnonce());


			//Executer le statement
			test.execute();

			System.out.println("Dao statement : " + test);

			test.close();
			con.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver non trouvé");
		}
		// Objet qui créer la requête : (C’est elle qui sera envoyée vers le SGBD). 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur SQL");
		}

		return trouve;
	}
	
	public static void deleteAnnonce(Annonce annonce) {
		
		//Recherche dans le BD
				try {
					//Vérifier la configuration
					Class.forName(strNomDriver);

					String rqSQL = ConstRequest.DELETEANNONCE;

					//Créer une connexion et l'ouvrir
					Connection con = DriverManager.getConnection(DBURL, USER, PASSWD); 			// Objet qui créer de la connection avec la BD

					//Ecrire la requete
					PreparedStatement pstmt = con.prepareStatement(rqSQL);
					
					pstmt.setInt(1, annonce.getIdAnnonce());
					
					pstmt.execute();
					
					pstmt.close();
					con.close();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Driver non trouvé");
				}
				// Objet qui créer la requête : (C’est elle qui sera envoyée vers le SGBD). 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Erreur SQL");
				}
		
	}


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
	 * Méthode qui génére la galerie d'annonce
	 * En affichant le titre et l'alias de l'abonné
	 * @return galerie
	 * @author Zakarya
	 */
	public static String galerieAnnonce() {

		String galerie = "<div class=\"site-section\">"
				+ "		<div class=\"container\">\r\n"
				+ "			<div class=\"row\">\r\n";



		for(Annonce an : Dao.getAllAnnonce()) {

			String titre 		= an.getTitre();
			String aliasAbonne 	= an.getAliasAbonne();
			int id 				= an.getIdAnnonce();

			galerie +="				<div class=\"col-lg-4 col-md-6 mb-4\">"
					+ "					<div class=\"post-entry-1 h-100\">"
					+ "						<img src=\"../assets/images/non_dispo.png\""
					+ "							alt=\"Image\" class=\"img-fluid\">"
					+ "						<div class=\"post-entry-1-contents\">\r\n"
					+ "							<h2><a href=\"/AlbaPretiosa/vue/consulter.jsp?idAnnonce=" + id +   "\"id=\"white\">" + titre + "</a></h2>"
					+ "							<span class=\"meta d-inline-block mb-3\"> <span class=\"mx-2\">proposé"
					+ "									par</span>" + aliasAbonne +  "</span>"
					+ "						</div>"
					+ "						</div>"
					+"					</div>";
		}

		galerie += "					</div>"
				+  "				</div>"
				+  "			</div>";


		return galerie;

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

		for(Annonce ann : Dao.getAllAnnonce()){
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
				int    idAbo			= rs.getInt("idAbo");

				// reconstruire l'objet
				Abonne abonne = new Abonne(aliasAbo, nomAbo, prenomAbo);
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
				int    idAdmin			= rs.getInt("idAdmin");

				// reconstruire l'objet
				Admin admin = new Admin(aliasAdmin, nomAdmin, prenomAdmin);
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


	//	/**
	//	 * Méthode d'instanciation de l'arraylist des annonces
	//	 * qui contient ann ann1 et ann2 en dur afin d'avoir de la matière à manipuler pour les servlets
	//	 * @return ArrayListe annonces 
	//	 */
	//	public static ArrayList<Annonce> initAnnonce() {
	//		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
	//		ArrayList<String> messages = new ArrayList<String>();
	//		Annonce ann = null;
	//		ann = new Annonce(3, "Manoir DeCruz", 1200, LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", 03, 01);
	//		Annonce ann1 = null;
	//		ann1 = new Annonce(1, "Casa Vivaldi", 1200, LocalDate.of(2018,12,12), LocalDate.of(2022,12,12), "Blablabla", 01, 01);
	//		Annonce ann2 = null;
	//		ann2 = new Annonce(2, "Chateau Mont Perret", 1200, LocalDate.of(2019,12,12), LocalDate.of(2021,12,12), "Blablabla", 02, 01);
	//		annonces.add(ann);
	//		annonces.add(ann1);
	//		annonces.add(ann2);
	//		return annonces;
	//	}

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

	private static Abonne getAboById(int idAbo) {
        ArrayList<Abonne> abonnes = getAllAbonnes();
        Abonne expediteur = new Abonne();
        for (Abonne abonne : abonnes) {
            if(idAbo == abonne.getIdAbonne()) expediteur = abonne;
        }
        return expediteur;
    }



}
