/**
 * 
 */
package fr.albapretiosa.metier;

import java.time.LocalDate;

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
	private String[]  options;
	
	
	/*		LES CONSTRUCTEURS		 */

/* CONSTRUCTEUR PRICIPALE */
	public Annonce(String titre, int surface, LocalDate creneau_debut, LocalDate creneau_fin, String description,
			String[] photos, String[] options) {
		super();
		this.titre = titre;
		this.surface = surface;
		this.creneau_debut = creneau_debut;
		this.creneau_fin = creneau_fin;
		this.description = description;
		this.photos = photos;
		this.options = options;
	}

/* CONSTRUCTEUR PAR DEFAUT*/
	public Annonce() {}

	/*		LES METHODES OVERRIDE		 */
	public void init() {}
	
	
	@Override 
	public String toString() {
		// TODO Auto-generated method stub
		return "";
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
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	/*		LES GETTER ET SETTER		 */

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
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
	 * @return the options
	 */
	public String[] getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
	public void setOptions(String[] options) {
		this.options = options;
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


}
