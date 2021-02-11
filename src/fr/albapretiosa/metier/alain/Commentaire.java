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
	
	
	// Alain : Création du constructeur et donc le constructeur classique disparait. ( Je n'en ai pas l'utilité )
	// Utilisation des setters pour être certain de passé par les controles
	/**
	 * CONSTRUCTEUR UNIQUE
	 * @param increment Sert à généré l'ID du commentaire de manière automatique
	 * @param expediteur Récupère l'alias du membre postant le commentaire
	 * @param idCom identifiant du commentaire. Unique et Obligatoire.
	 * @param commentaire Le corps du message
	 * @param dateCom Date de création du commentaire. Il est créé quand il est instancié donc c'est toujours "maintenant" 
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
