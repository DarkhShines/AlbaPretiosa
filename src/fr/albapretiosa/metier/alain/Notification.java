package fr.albapretiosa.metier.alain;

import java.time.LocalDate;

import AppException.ExceptionAlain;
import fr.albapretiosa.util.UtilAlain;

/**
 * 
 * @author Alain
 * @implNote Classe des Notifications. Permet leurs création et leur recherche grace à son Identifiant
 *
 */
public class Notification {
	public static int increment = 0;
	private String idNotif;
	private String exepditeur;
	private int idExpediteur;
	private String objet;
	private String texteNotif;
	private LocalDate dateNotif = LocalDate.now();
	private boolean lu = false; 
	
	/**
	 * CONSTRUCTEUR UNIQUE
	 * @param increment Sert à généré l'ID du commentaire de manière automatique
	 * @param expediteur Récupère l'alias du membre postant le commentaire
	 * @param idNotif identifiant de la notification. Unique et Obligatoire.
	 * @param idExpediteur Identifiant de l'ADMIN postant la notification ( Seul un admin peut créé une notification ) 
	 * @param texteNotif Le corps du message
	 * @param dateNotif Date de création de la notif. Elle est créée quand elle est instanciée donc c'est toujours "maintenant" 
	 * @param lu Permet de savoir si la notification a été lue.
	 * @throws ExceptionAlain 
	 * @see package fr.albapretiosa.servlet.zak/PublierNotif.java 
	 * @see WebContent/vue/notification.jsp 
	 */
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


	public void setObjet(String objet) throws ExceptionAlain {
		this.objet = UtilAlain.isEmpty(objet);
	}


	public String getTexteNotif() {
		return texteNotif;
	}


	public void setTexteNotif(String texteNotif) throws ExceptionAlain {
		this.texteNotif = UtilAlain.isEmpty(texteNotif);
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
