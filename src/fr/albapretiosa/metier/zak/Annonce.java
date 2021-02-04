/**
 * 
 */
package fr.albapretiosa.metier.zak;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author linki
 *
 */
public class Annonce {
	
	/*		LISTE DES VARIABLES D'INSTANCES		 */
	
	private String	  idAnnonce;
	private String    titre;
	private int 	  surface;
	private LocalDate creneau_debut;
	private LocalDate creneau_fin;
	private String	  description;
	private String[]  photos;
	private boolean   piscine;
	private boolean   spa;
	private boolean   golf;
	private boolean   tennis;
	
	
	/*		LES CONSTRUCTEURS		 */

/**
	
	/* CONSTRUCTEUR PRICIPALE */
	
/* CONSTRUCTEUR PAR DEFAUT*/
	public Annonce() {}

	/**
	 * @param idAnnonce
	 * @param titre
	 * @param surface
	 * @param creneau_debut
	 * @param creneau_fin
	 * @param description
	 * @param photos
	 * @param piscine
	 * @param spa
	 * @param golf
	 * @param tennis
	 */
	public Annonce(String idAnnonce, String titre, int surface, LocalDate creneau_debut, LocalDate creneau_fin,
			String description, String[] photos, boolean piscine, boolean spa, boolean golf, boolean tennis) {

		setIdAnnonce(idAnnonce);;
		setTitre(titre);
		setSurface(surface);
		setCreneau_debut(creneau_debut);
		setCreneau_fin(creneau_fin);
		setDescription(description);
		setPhotos(photos);
		setPiscine(piscine);
		setSpa(spa);
		setGolf(golf);;
		setTennis(tennis);
	}

	/*		LES METHODES OVERRIDE		 */
	public void init() {}
	
	

	
	@Override
	public String toString() {
		return "Annonce [idAnnonce=" + idAnnonce + ", titre=" + titre + ", surface=" + surface + ", creneau_debut="
				+ creneau_debut + ", creneau_fin=" + creneau_fin + ", description=" + description + ", photos="
				+ Arrays.toString(photos) + ", piscine=" + piscine + ", spa=" + spa + ", golf=" + golf + ", tennis="
				+ tennis + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

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
	 * @return the photos
	 */
	public String[] getPhotos() {
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(String[] photos) {
		this.photos = photos;
	}

	
	/**
	 * @return the idAnnonce
	 */
	public String getIdAnnonce() {
		return idAnnonce;
	}

	/**
	 * @param idAnnonce the idAnnonce to set
	 */
	public void setIdAnnonce(String idAnnonce) {
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

	

}
