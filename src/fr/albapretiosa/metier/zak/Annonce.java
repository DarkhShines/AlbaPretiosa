/**
 * 
 */
package fr.albapretiosa.metier.zak;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;

import AppException.Exception_Zak;
import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.util.UtilAlain;

/**
 * @author Zakarya D. Bahou
 *
 */

public class Annonce {

	/*		LISTE DES VARIABLES DE CLASSE		 */
	private static int	incrementIdAnnonce = 105;

	/*		LISTE DES VARIABLES D'INSTANCES		 */
	private int 	  idAnnonce;
	private Abonne	  abonne;
	private String    titre;
	private int		  surface;                                        
	private LocalDate creneauDebut;
	private LocalDate creneauFin;
	private String	  description;
	private Options	  options;
	private Ville	  ville;



	/*		LES CONSTRUCTEURS		 */
	/**
	 * CONSTRUCTEUR PRICIPAL
	 * @param idAnnonce Identifiant unique de l'annonce
	 * @param titre Titre de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param surface Surface de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param creneauDebut Date de mise en location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param creneauFin Date de fin de location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param description Description de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo1 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo2 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo3 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo4 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @throws Exception_Zak 
	 * @see package fr.albapretiosa.servlet.zak/CreerAnnonce.java 
	 * @see WebContent/vue/Formulaire_Annonce.jsp
	 */
	public Annonce(String titre, int surface, LocalDate creneauDebut, LocalDate creneauFin,
			String description, Photo photo1, Photo photo2, Photo photo3, Photo photo4) throws Exception_Zak {

		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);

	}


	/**
	 * CONSTRUCTEUR SECONDAIRE SANS LES PHOTOS
	 * @param idAnnonce Identifiant unique de l'annonce
	 * @param titre Titre de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param surface Surface de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param creneauDebut Date de mise en location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param creneauFin Date de fin de location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param description Description de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @throws Exception_Zak 
	 * @see package fr.albapretiosa.servlet.zak/CreerAnnonce.java 
	 * @see WebContent/vue/Formulaire_Annonce.jsp
	 */
	public Annonce(String titre, int surface, Ville ville, LocalDate creneauDebut, LocalDate creneauFin, String description, Options options) {


		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
		setVille(ville);
		setOptions(options);
	}


	public Annonce(int idAnnonce, String titreAnnonce, int surfaceAnnonce, LocalDate creneauDebut,
			LocalDate creneauFin, String description, Abonne abonne, Ville ville) {
		setIdAnnonce(idAnnonce);
		setTitre(titreAnnonce);
		setSurface(surfaceAnnonce);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
		setVille(ville);
		setAbonne(abonne);
	}




	public Annonce(String titre, int surface,  LocalDate creneauDebut,
			LocalDate creneauFin, String description, Abonne abonne, Ville ville, Options options) {
		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
		setVille(ville);
		setAbonne(abonne);
	}


	public Annonce(String titre, int surface, String libelle, LocalDate creneauDebut, LocalDate creneauFin,
			String description, Options options) {
		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
	}


	public Annonce() {
		// TODO Auto-generated constructor stub
	}


	public Annonce(String titre2, int surface2, LocalDate creneauDebut, LocalDate creneauFin, String description,
			Abonne abonne, String alias, String libelle, Options options2) {
		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
		setAbonne(abonne);
		
	}


	public Annonce(String titre, int surface, LocalDate creneauDebut, LocalDate creneauFin, String description,
			Abonne a, Ville ville2) {
		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
		setAbonne(a);
		setVille(ville2);
	}




	public Annonce(String titre, int surface, Date dateDebut, Date dateFin, String description) {
		// TODO Auto-generated constructor stub
		setTitre(titre);
		setSurface(surface);
		setCreneauDebut(creneauDebut);
		setCreneauFin(creneauFin);
		setDescription(description);
	}


	public Annonce(int idAnnonce) {
		setIdAnnonce(idAnnonce);
	}


	/**
	 * M�thode de contr�le du titre saisi.
	 * @param titre
	 * @throws Exception_Zak
	 */
	public static void controleTitre( String titre ) throws Exception_Zak {
		if( titre == null || titre.trim() == "") {
			throw new Exception_Zak( "Le titre n'est pas renseign�" );
		}
		else if(titre != null) {
			if (titre.trim().length() < 10 ) {
				throw new Exception_Zak( "Le titre doit contenir au moins 10 caract�res." );
			}
			if (titre.trim().length() > 100 ) {
				throw new Exception_Zak( "Le titre ne peut contenir plus de 100 caract�res." );
			}
		}
	}

	/**
	 * M�thode de controle de la surface
	 * @param surface
	 * @throws Exception_Zak
	 */

	public static void controleSurface(int surface) throws Exception_Zak{
		if( surface == 0 ) {
			throw new Exception_Zak( "La surface ne peut �tre �gale � 0 ");
		}
		if( surface < 0) {
			throw new Exception_Zak( "La surface ne peut �tre n�gative");
		}
		if( surface > 112100 ) {
			throw new Exception_Zak( "La surface ne peut �tre superieur � 112100m� ");
		}
	}

	/**
	 * M�thode de controle du pays
	 * @param pays
	 * @throws Exception_Zak
	 */
	public static void controlePays(String pays) throws Exception_Zak {
		if( pays == null || pays.trim() == "") {
			throw new Exception_Zak( "Le pays n'est pas renseign�" );
		}
		else if(pays != null) {
			if(!pays.trim().equals("France") && !pays.trim().equals("Angleterre" ) && !pays.trim().equals("Italie")) {
				throw new Exception_Zak("Nous ne proposons pas ce pays dans nos services");
			}
			if(pays.trim().length() > 40) {
				throw new Exception_Zak("Le nom du pays est trop long");
			}
		}
	}

	/**
	 * @param ville
	 * @throws Exception_Zak
	 */
	public static void controleVille(String ville) throws Exception_Zak{
		if( ville == null || ville.trim() == "") {
			throw new Exception_Zak( "Le pays n'est pas renseign�" );
		}
		else if(ville != null) {
			if(!ville.trim().equals("Marseille") && !ville.trim().equals("Paris") && !ville.trim().equals("Bordeaux")) {
				throw new Exception_Zak("Nous ne proposons pas cette ville dans nos services");
			}
			if(ville.trim().length() > 40) {
				throw new Exception_Zak("Le nom de la ville est trop long");
			}
		}
	}

	/**
	 * M�thode de contr�le des dates.
	 * @param creneauDebut
	 * @param creneauFin
	 * @throws Exception_Zak
	 */
	public static void controleDate(LocalDate creneauDebut, LocalDate creneauFin) throws Exception_Zak{

		if(creneauDebut == null) {
			throw new Exception_Zak("La date de d�but de location n'est pas renseign�");
		}
		if(creneauFin == null) {
			throw new Exception_Zak("La date de fin de location n'est pas renseign�");
		}
		else if(creneauDebut != null && creneauFin != null) {
			if (creneauDebut.isBefore(LocalDate.now())) {
				throw new Exception_Zak("La date de d�but de location de peut �tre ant�rieur � aujourd'hui");
			}
			if(creneauFin.isBefore(LocalDate.now())) {
				throw new Exception_Zak("La date de fin de location de peut �tre ant�rieur � aujourd'hui");
			}
			if(creneauDebut.isAfter(creneauFin)) {
				throw new Exception_Zak("La date de fin de location de peut �tre anterieur � la date de d�but");
			}
		}
	}
	
	/**
	 * M�thode de contr�le de la description
	 * @param description
	 * @throws Exception_Zak
	 */
	public static void controleDescription(String description) throws Exception_Zak {
		if(description != null) {
			if(description.trim().length() > 250) {
				throw new Exception_Zak("La description est trop longue");
			}
			if(description.trim().length() < 5)
				throw new Exception_Zak("La description est trop courte");
			
		}
	}
	
	

	@Override
	public String toString() {
		return "Annonce [idAnnonce =" + idAnnonce + ", Abonne =" + abonne + ", titre =" + titre + ", surface =" + surface
				+ ", creneauDebut =" + creneauDebut + ", creneauFin =" + creneauFin + ", description =" + description
				+ ", options =" + options + ", ville=" + ville + "]";
	}


	/**
	 * METHODE POUR GENERE UN ID ANNONCE AUTO_INCREMENTE COMME REFERENCE UNIQUE
	 * @return idAnnonce + 1
	 */
	public static int genereIdAnnonce(){
		try {
			incrementIdAnnonce ++;
			for (int i = 0; i < Dao.getAllAnnonce().size(); i++) {
				Annonce an = new Annonce();
				if(incrementIdAnnonce == an.getIdAnnonce()) {
					incrementIdAnnonce ++;
				}
			}
		} catch (Exception_Zak a ) {
			System.out.println("Erreur Formulaire" + a.getMessage() + a.getCause());
			a.printStackTrace();
		}

		return incrementIdAnnonce;
	}


	/*		LES GETTER ET SETTER		 */

	/**
	 * @return titre = Le titre de la propri�t�
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre = Le titre � set
	 * @throws Exception_Zak 
	 */
	public void setTitre(String titre){
		controleTitre(titre);
		this.titre = titre;
	}
	/**
	 * @return surface = La surface de la propri�t�
	 */
	public int getSurface() {
		return surface;
	}
	/**
	 * @param surface = La surface � set
	 * @throws Exception_Zak 
	 */
	public void setSurface(int surface){
		controleSurface(surface);
		this.surface = surface;
	}

	/**
	 * @return creneauDebut = Le cr�neau de mise en location de la propri�t�
	 */
	public LocalDate getCreneauDebut() {
		return creneauDebut;
	}
	/**
	 * @param creneauDebut = Le creneauDebut � set
	 */
	public void setCreneauDebut(LocalDate creneauDebut) {
		this.creneauDebut = creneauDebut;
	}
	/**
	 * @return creneauFin = Le cr�neau de fin de location de la propri�t�
	 */
	public LocalDate getCreneauFin() {
		return creneauFin;
	}
	/**
	 * @param creneauFin = le creneauFin � set
	 */
	public void setCreneauFin(LocalDate creneauFin) {
		this.creneauFin = creneauFin;
	}
	/**
	 * @return description = Description de la propri�t�
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description = La description � set
	 */
	public void setDescription(String description) {
		controleDescription(description);
		this.description = description;
	}

	/**
	 * @return idAnnonce = L'identifiant de l'annonce
	 */
	public int getIdAnnonce() {
		return idAnnonce;
	}

	/**
	 * @param idAnnonce = L'identifiant idAnnonce � set
	 */
	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	

	/**
	 * @return the abonne
	 */
	public Abonne getAbonne() {
		return abonne;
	}


	/**
	 * @param abonne the abonne to set
	 */
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}


	/**
	 * @return the options
	 */
	public Options getOptions() {
		return options;
	}


	/**
	 * @param options the options to set
	 */
	public void setOptions(Options options) {
		this.options = options;
	}


	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
	public String getAliasAbonne() {
		return abonne.getAlias();
	}


}
