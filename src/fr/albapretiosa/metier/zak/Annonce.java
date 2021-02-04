/**
 * 
 */
package fr.albapretiosa.metier.zak;

import java.time.LocalDate;





/**
 * @author linki
 *
 */
public class Annonce {
	
	/*		LISTE DES VARIABLES D'INSTANCES		 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int 	  idAnnonce;
	private String    titre;
	private int 	  surface;
	private LocalDate creneau_debut;
	private LocalDate creneau_fin;
	private String	  description;
	private boolean   piscine;
	private boolean   spa;
	private boolean   golf;
	private boolean   tennis;
	Photo photo     = new Photo();
	
	
					/*		LES CONSTRUCTEURS		 */
	
	/* CONSTRUCTEUR PRICIPAL */
	
	/**
	 * @param idAnnonce
	 * @param titre
	 * @param surface
	 * @param creneau_debut
	 * @param creneau_fin
	 * @param description
	 * @param piscine
	 * @param spa
	 * @param golf
	 * @param tennis
	 * @param photo
	 */
	public Annonce(String titre, int surface, LocalDate creneau_debut, LocalDate creneau_fin,
			String description, boolean piscine, boolean spa, boolean golf, boolean tennis, Photo photo) {
		
		setIdAnnonce(idAnnonce);
		setTitre(titre);
		setSurface(surface);
		setCreneau_debut(creneau_debut);
		setCreneau_fin(creneau_fin);
		setDescription(description);
		setPiscine(piscine);
		setSpa(spa);
		setGolf(golf);
		setTennis(tennis);
		setPhoto(photo);
	}

	public Annonce() {}

	/*		LES METHODES OVERRIDE		 */
	public void init() {}


	/*		LES GETTER ET SETTER		 */

	/**
	 * @return le titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre le titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the surface
	 */
	public int getSurface() {
		return surface;
	}
	/**
	 * @param surface the surface to set
	 */
	public void setSurface(int surface) {
		this.surface = surface;
	}
	/**
	 * @return the creneau_debut
	 */
	public LocalDate getCreneau_debut() {
		return creneau_debut;
	}
	/**
	 * @param creneau_debut the creneau_debut to set
	 */
	public void setCreneau_debut(LocalDate creneau_debut) {
		this.creneau_debut = creneau_debut;
	}
	/**
	 * @return the creneau_fin
	 */
	public LocalDate getCreneau_fin() {
		return creneau_fin;
	}
	/**
	 * @param creneau_fin the creneau_fin to set
	 */
	public void setCreneau_fin(LocalDate creneau_fin) {
		this.creneau_fin = creneau_fin;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the idAnnonce
	 */
	public int getIdAnnonce() {
		return idAnnonce;
	}

	/**
	 * @param idAnnonce the idAnnonce to set
	 */
	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	/**
	 * @return the piscine
	 */
	public boolean isPiscine() {
		return piscine;
	}

	/**
	 * @param piscine the piscine to set
	 */
	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

	/**
	 * @return the spa
	 */
	public boolean isSpa() {
		return spa;
	}

	/**
	 * @param spa the spa to set
	 */
	public void setSpa(boolean spa) {
		this.spa = spa;
	}

	/**
	 * @return the golf
	 */
	public boolean isGolf() {
		return golf;
	}

	/**
	 * @param golf the golf to set
	 */
	public void setGolf(boolean golf) {
		this.golf = golf;
	}

	/**
	 * @return the tennis
	 */
	public boolean isTennis() {
		return tennis;
	}

	/**
	 * @param tennis the tennis to set
	 */
	public void setTennis(boolean tennis) {
		this.tennis = tennis;
	}

	/**
	 * @return the photo
	 */
	public Photo getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	

}
