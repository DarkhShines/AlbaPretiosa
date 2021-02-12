package fr.albapretiosa.metier.alain;

import java.time.LocalDate;

public class Commentaire {
	
	// Alain : Mise en place des variables d'instances..
	public static int increment = 0;
	private String expediteur;
	private int idCom;
	private String commentaire;
	private LocalDate dateCom;
	private int idAnnonce;
	
	
	// Alain : Cr�ation du constructeur et donc le constructeur classique disparait. ( Je n'en ai pas l'utilit� )
	// Utilisation des setters pour �tre certain de pass� par les controles
	/**
	 * CONSTRUCTEUR UNIQUE
	 * @param increment Sert � g�n�r� l'ID du commentaire de mani�re automatique
	 * @param expediteur R�cup�re l'alias du membre postant le commentaire
	 * @param idCom identifiant du commentaire. Unique et Obligatoire.
	 * @param commentaire Le corps du message
	 * @param dateCom Date de cr�ation du commentaire. Il est cr�� quand il est instanci� donc c'est toujours "maintenant" 
	 * @param idAnnonce Permet de savoir quels commentaire appartient a quelle annonce
	 * @see package fr.albapretiosa.servlet.zak/AjoutComm.java 
	 * @see package fr.albapretiosa.servlet.zak/ModifComm.java	 
	 * @see package fr.albapretiosa.servlet.zak/SupprComm.java 
	 * @see WebContent/vue/consulter.jsp 
	 */
	public Commentaire(String expediteur,  String commentaire, LocalDate dateCom, int idAnnonce) {
		super();
		setExpediteur(expediteur);
		idCom = generateIdComm();
		setCommentaire(commentaire);
		setDateCom(dateCom);
		this.idAnnonce = idAnnonce;
	}
	
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public int getIdCom() {
		return idCom;
	}
	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public LocalDate getDateCom() {
		return dateCom;
	}
	public void setDateCom(LocalDate dateCom) {
		this.dateCom = dateCom;
	}
	public int getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	private int generateIdComm() {
		increment++;
		int id = increment;
		return id;
	}
	
	
	// Alain : Pas de gros mots sur Alba&Pretiosa ! 
	public String filtreLangage(){
		return null;
	}
	
	

}
