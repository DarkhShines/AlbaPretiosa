package fr.albapretiosa.metier.alain;

import java.time.LocalDate;

public class Commentaire {
	
	// Alain : Mise en place des variables d'instances..
	public static int increment = 0;
	private String expediteur;
	private String idCom;
	private String commentaire;
	private LocalDate dateCom;
	
	
	// Alain : Création du constructeur et donc le constructeur classique disparait. ( Je n'en ai pas l'utilité )
	// Utilisation des setters pour être certain de passé par les controles
	public Commentaire(String expediteur,  String commentaire, LocalDate dateCom) {
		super();
		setExpediteur(expediteur);
		idCom = generateIdComm();
		setCommentaire(commentaire);
		setDateCom(dateCom);
	}
	
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getIdCom() {
		return idCom;
	}
	public void setIdCom(String idCom) {
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
	private String generateIdComm() {
		increment++;
		String id = ""+increment;
		return id;
	}
	
	
	// Alain : Pas de gros mots sur Alba&Pretiosa ! 
	public String filtreLangage(){
		return null;
	}
	
	

}
