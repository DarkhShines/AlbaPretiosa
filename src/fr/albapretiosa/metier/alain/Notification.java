package fr.albapretiosa.metier.alain;

public class Notification {
	private String exepditeur;
	private String objet;
	private String texteNotif;
	private boolean lu = false; 
	
	
	public Notification(String exepditeur, String objet, String texteNotif) {
		setExepditeur(exepditeur);
		setObjet(objet);
		setTexteNotif(texteNotif);
	}


	public String getExepditeur() {
		return exepditeur;
	}


	public void setExepditeur(String exepditeur) {
		this.exepditeur = exepditeur;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public String getTexteNotif() {
		return texteNotif;
	}


	public void setTexteNotif(String texteNotif) {
		this.texteNotif = texteNotif;
	}


	public boolean isLu() {
		return lu;
	}


	public void setLu(boolean lu) {
		this.lu = lu;
	}
	
	
}
