package fr.albapretiosa.metier.alain;

public class Notification {
	public static int increment = 0;
	private String idNotif;
	private String exepditeur;
	private String objet;
	private String texteNotif;
	private boolean lu = false; 
	
	
	public Notification(String exepditeur, String objet, String texteNotif) {
		idNotif = generateIdNotif();
		setExepditeur(exepditeur);
		setObjet(objet);
		setTexteNotif(texteNotif);
	}


	public static int getIncrement() {
		return increment;
	}


	public static void setIncrement(int increment) {
		Notification.increment = increment;
	}


	public String getIdNotif() {
		return idNotif;
	}


	public void setIdNotif(String idNotif) {
		this.idNotif = idNotif;
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
	
	private String generateIdNotif() {
		increment++;
		String id = "N" + increment;
		return id;
	}
	
}
