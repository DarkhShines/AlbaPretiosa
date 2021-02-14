/**
 * 
 */
package fr.albapretiosa.metier.zak;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import AppException.Exception_Zak;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.servlet.zak.CreerAnnonce;

/**
 * @author Zakarya D. Bahou
 *
 */

public class Annonce {
	
	private static final long serialVersionUID = 1L;

	/*		LISTE DES VARIABLES DE CLASSE		 */
	private static int	incrementIdAnnonce;

	/*		LISTE DES VARIABLES D'INSTANCES		 */
	private int 	  idAnnonce;
	private int	      idAbonne;
	private String    titre;
	private int		  surface;                                        
	private String	  pays;
	private String 	  ville;
	private LocalDate creneau_debut;
	private LocalDate creneau_fin;
	private String	  description;
	private boolean   piscine;
	private boolean   spa;
	private boolean   golf;
	private boolean   tennis;
	private ArrayList<Integer> idCommList = new ArrayList<Integer>();

	Photo photo1     = new Photo();
	Photo photo2     = new Photo();
	Photo photo3     = new Photo();
	Photo photo4     = new Photo();


	/*		LES CONSTRUCTEURS		 */
	/**
	 * CONSTRUCTEUR PRICIPAL
	 * @param idAnnonce Identifiant unique de l'annonce
	 * @param titre Titre de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param surface Surface de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param creneau_debut Date de mise en location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param creneau_fin Date de fin de location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param description Description de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param piscine Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param spa Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param golf Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param tennis Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo1 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo2 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo3 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param photo4 Photo de la propri�t� de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @throws Exception_Zak 
	 * @see package fr.albapretiosa.servlet.zak/CreerAnnonce.java 
	 * @see WebContent/vue/Formulaire_Annonce.jsp
	 */
	public Annonce(String titre, int surface, String pays, String ville, LocalDate creneau_debut, LocalDate creneau_fin,
			String description, boolean piscine, boolean spa, boolean golf, boolean tennis, Photo photo1, Photo photo2, Photo photo3, Photo photo4) throws Exception_Zak {

		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setPays(pays);
		setVille(ville);
		setCreneau_debut(creneau_debut);
		setCreneau_fin(creneau_fin);
		setDescription(description);
		setPiscine(piscine);
		setSpa(spa);
		setGolf(golf);
		setTennis(tennis);
		setPhoto1(photo1);
		setPhoto2(photo2);
		setPhoto3(photo3);
		setPhoto4(photo4);
	}


	/**
	 * CONSTRUCTEUR SECONDAIRE SANS LES PHOTOS
	 * @param idAnnonce Identifiant unique de l'annonce
	 * @param titre Titre de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param surface Surface de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param creneau_debut Date de mise en location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param creneau_fin Date de fin de location de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param description Description de la propri�t� de l'annonce, r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param piscine Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param spa Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce
	 * @param golf Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @param tennis Option de l'annonce r�cup�r� dans le formulaire de cr�ation d'annonce 
	 * @throws Exception_Zak 
	 * @see package fr.albapretiosa.servlet.zak/CreerAnnonce.java 
	 * @see WebContent/vue/Formulaire_Annonce.jsp
	 */
	public Annonce(String titre, int surface, String pays, String ville, LocalDate creneau_debut, LocalDate creneau_fin, String description, boolean piscine, boolean spa, boolean golf, boolean tennis) {


		setIdAnnonce(genereIdAnnonce());
		setTitre(titre);
		setSurface(surface);
		setPays(pays);
		setVille(ville);
		setCreneau_debut(creneau_debut);
		setCreneau_fin(creneau_fin);
		setDescription(description);
		setPiscine(piscine);
		setSpa(spa);
		setGolf(golf);
		setTennis(tennis);
	}

	/**
	 * CONSTRUCTEUR PAR DEFAUT
	 */
	public Annonce() {}


	/**
	 * METHODE POUR GENERE UN ID ANNONCE AUTO_INCREMENTE COMME REFERENCE UNIQUE
	 * @return idAnnonce + 1
	 */
	public static int genereIdAnnonce(){
		incrementIdAnnonce ++;
		return incrementIdAnnonce;
	}

	/**
	 * @param id
	 */
	public void addComm(int id) {
		this.idCommList.add(id);
	}

	/**
	 * @param id
	 */
	public void deleteComm(int id) {
		this.idCommList.remove(id);
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
		this.surface = surface;
	}



	/**
	 * @return pays = Le pays de la propri�t�
	 */
	public String getPays() {
		return pays;
	}


	/**
	 * @param pays = Le pays � set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}


	/**
	 * @return ville = La ville de la propri�t�
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * @param ville = La ville � set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	/**
	 * @return creneau_debut = Le cr�neau de mise en location de la propri�t�
	 */
	public LocalDate getCreneau_debut() {
		return creneau_debut;
	}
	/**
	 * @param creneau_debut = Le creneau_debut � set
	 */
	public void setCreneau_debut(LocalDate creneau_debut) {
		this.creneau_debut = creneau_debut;
	}
	/**
	 * @return creneau_fin = Le cr�neau de fin de location de la propri�t�
	 */
	public LocalDate getCreneau_fin() {
		return creneau_fin;
	}
	/**
	 * @param creneau_fin = le creneau_fin � set
	 */
	public void setCreneau_fin(LocalDate creneau_fin) {
		this.creneau_fin = creneau_fin;
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
	 * @return piscine = Option piscine de la propri�t�
	 */
	public boolean isPiscine() {
		return piscine;
	}

	/**
	 * @param piscine = L'option piscine � set
	 */
	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

	/**
	 * @return spa = L'option spa de la propri�t�
	 */
	public boolean isSpa() {
		return spa;
	}

	/**
	 * @param spa = L'option spa � set
	 */
	public void setSpa(boolean spa) {
		this.spa = spa;
	}

	/**
	 * @return golf = L'option golf de la propri�t�
	 */
	public boolean isGolf() {
		return golf;
	}

	/**
	 * @param golf = L'option golf � set
	 */
	public void setGolf(boolean golf) {
		this.golf = golf;
	}

	/**
	 * @return tennis = L'option tennis de la propri�t�
	 */
	public boolean isTennis() {
		return tennis;
	}

	/**
	 * @param tennis = L'option tennis � set
	 */
	public void setTennis(boolean tennis) {
		this.tennis = tennis;
	}

	/**
	 * @return photo1 = 1er photo de la propri�t�
	 */
	public Photo getPhoto1() {
		return photo1;
	}

	/**
	 * @param photo1 = La photo 1 � set
	 */
	public void setPhoto1(Photo photo1) {
		this.photo1 = photo1;
	}

	/**
	 * @return photo2 = La 2nd photo de la propri�t�
	 */
	public Photo getPhoto2() {
		return photo2;
	}

	/**
	 * @param photo2 = La photo 2 � set
	 */
	public void setPhoto2(Photo photo2) {
		this.photo2 = photo2;
	}

	/**
	 * @return photo3 = La 3�me photo de la propri�t�
	 */
	public Photo getPhoto3() {
		return photo3;
	}

	/**
	 * @param photo3 = La photo 3 � set
	 */
	public void setPhoto3(Photo photo3) {
		this.photo3 = photo3;
	}

	/**
	 * @return photo4 = La 4�me photo de la propri�t�
	 */
	public Photo getPhoto4() {
		return photo4;
	}

	/**
	 * @param photo4 = La photo 4 � set
	 */
	public void setPhoto4(Photo photo4) {
		this.photo4 = photo4;
	}


	/**
	 * @return idAbonne = Identifiant de l'abonn� qui cr�er l'annonce
	 */
	public int getIdAbonne() {
		return idAbonne;
	}


	/**
	 * @param idAbonne = L'identifiant de l'abonne � set
	 */
	public void setIdAbonne(int idAbonne) {
		this.idAbonne = idAbonne;
	}




}
