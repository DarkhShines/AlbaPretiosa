package fr.albapretiosa.metier.alain;

public class Newsletter {
	private String exepditeur;
	private String destinataire;
	private String objet;
	private String texteNews;
	
	
	public Newsletter(String exepditeur, String destinataire, String objet, String texteNews) {
		super();
		setExepditeur(exepditeur);
		setDestinataire(destinataire);
		setObjet(objet);
		setTexteNews(texteNews);
	}


	public String getExepditeur() {
		return exepditeur;
	}


	public void setExepditeur(String exepditeur) {
		this.exepditeur = exepditeur;
	}


	public String getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public String getTexteNews() {
		return texteNews;
	}


	public void setTexteNews(String texteNews) {
		this.texteNews = texteNews;
	}
	
	
}
