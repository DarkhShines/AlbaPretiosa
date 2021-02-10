package fr.albapretiosa.metier.alain;

import java.time.LocalDate;

public class Notification {
	public static int increment = 0;
	private String idNotif;
	private String exepditeur;
	private int idExpediteur;
	private String objet;
	private String texteNotif;
	private LocalDate dateNotif = LocalDate.now();
	private boolean lu = false; 
	
	
	public Notification(String exepditeur, int idExpediteur, String objet, String texteNotif) {
		idNotif = generateIdNotif();
		setExepditeur(exepditeur);
		setIdExpediteur(idExpediteur);
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


	public int getIdExpediteur() {
		return idExpediteur;
	}


	public void setIdExpediteur(int idExpediteur) {
		this.idExpediteur = idExpediteur;
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


	public LocalDate getDateNotif() {
		return dateNotif;
	}


	public void setDateNotif(LocalDate dateNotif) {
		this.dateNotif = dateNotif;
	}


	public boolean isLu() {
		return lu;
	}


	public void setLu(boolean lu) {
		this.lu = lu;
	}
	
	private String generateIdNotif() {
		increment++;
		String id = ""+increment;
		return id;
	}
	
}
