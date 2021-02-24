package fr.albapretiosa.metier.nico;

import java.util.concurrent.atomic.AtomicInteger;

import AppException.Exception_Nico;
import fr.albapretiosa.servlet.nico.InscriptionServlet;

/**
 * @author Nico
 *
 */
public class Abonne {
	// PROPRIETE DE CLASSE
	protected static AtomicInteger genId = new AtomicInteger(1);

	// PROPRIETE D'INSTANCE
	private String 	nom;
	private int 	idAbonne;
	private String 	prenom;
	private String 	alias;
	private String 	email;
	private String 	telPortable;
	private String 	telFixe;
	private boolean platinum;
	private String	mdp;
	private String 	parrainage;
	private boolean isBan;

	// CONSTRUCTEUR 
	/**
	 * @param nom nom de l'abonné
	 * @param prenom prenom de l'abonné
	 * @param alias alias de l'abonné
	 * @param email email de l'abonné
	 * @param telPortable téléphone portable de l'abonné
	 * @param mdp mot de passe de l'abonné
	 * @param parrainage code parrainage de l'abonné
	 */
	public Abonne(String nom, String prenom, String alias, String email, String telPortable, String mdp, String parrainage) {
		super();
		setNom(nom);
		setIdAbonne(genId.getAndIncrement()); 
		setPrenom(prenom);
		setAlias(alias);
		setEmail(email);
		setTelPortable(telPortable);
		setMdp(mdp);
		setParrainage(parrainage);
	}
	/**
	 * @param telFixe téléphone fixe de l'abonné
	 */
	public Abonne(String nom, String prenom, String alias, String email, String telPortable,
			String telFixe, String mdp, String parrainage){
		super();
		setNom(nom);
		setIdAbonne(genId.getAndIncrement()); 
		setPrenom(prenom);
		setAlias(alias);
		setEmail(email);
		setTelPortable(telPortable);
		setTelFixe(telFixe);
		setMdp(mdp);
		setParrainage(parrainage);
		setBan(false);
	}
	
	public Abonne(String alias,String nom, String prenom){
		super();
		setIdAbonne(genId.getAndIncrement()); 
		setAlias(alias);
		setNom(nom);
		setPrenom(prenom);
	}
	
	public Abonne() {
		super();
	}

	// GETTER
	public String getNom() {
		return nom;
	}
	public int getIdAbonne() {
		return idAbonne;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAlias() {
		return alias;
	}
	public String getEmail() {
		return email;
	}
	public String getTelPortable() {
		return telPortable;
	}
	public String getTelFixe() {
		return telFixe;
	}
	public boolean isPlatinum() {
		return platinum;
	}
	public String getMdp() {
		return mdp;
	}
	public String getParrainage() {
		return parrainage;
	}
	public boolean isBan() {
		return isBan;
	}

	// SETTER
	public void setNom(String nom) {
		controleNom(nom);
		this.nom = nom;
	}
	public void setIdAbonne(int idAbonne) {
		if(idAbonne != 0) {
			this.idAbonne = idAbonne;
		}
	}
	public void setPrenom(String prenom) {
		controlePrenom(prenom);
		this.prenom = prenom;
	}
	public void setAlias(String alias) {
		controleAlias(alias);
		this.alias = alias;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelPortable(String telPortable) {
		controleTelPortable(telPortable);
		this.telPortable = telPortable;
	}
	public void setTelFixe(String telFixe) {
		controleTelFixe(telFixe);
		this.telFixe = telFixe;
	}
	public void setPlatinum(boolean platinum) {
		this.platinum = platinum;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public void setParrainage(String parrainage) {
		this.parrainage = parrainage;
	}
	public void setBan(boolean isBan) {
		this.isBan = isBan;
	}
	// METHODE 
	@Override
	public String toString() {
		return "Abonne [nom=" + nom + ", idAbonne=" + idAbonne + ", prenom=" + prenom + ", alias=" + alias + ", email="
				+ email + ", telPortable=" + telPortable + ", telFixe=" + telFixe + ", platinum=" + platinum + ", mdp="
				+ mdp + ", parrainage=" + parrainage + "]";
	}

	// METHODE CONTROLE SAISIE
	                                       // IMPORTANT
	// WORK IN PROGRESS
	// J'ai pas reussi a recup le message de mon exception qui est catch dans ma servlet d'inscription, je n'ai que le message
	// que j'ai mis quand mon response.setAttribute qui est "Inscription Echouée"
	// je n'ai pas eu le temps de le mettre au poins 
	// L'exception Exception_Nico extends NullPointerException, car impossible de catch dans le doPost autrement !
	
	                                       // IMPORTANT
	
	/**
	 * @param nom a rentré en param dans le Setters
	 * @throws Exception_Nico elle extends NullPointerException
	 */
	public void controleNom(String nom ) throws Exception_Nico {
		if( nom == null || nom.trim() == "") {
			throw new Exception_Nico( "Le nom n'est pas renseigné" );
		}
		if ( nom != null && nom.trim().length() < 2 ) {
			throw new Exception_Nico( "Le nom doit contenir au moins 2 caractères." );
		}
		if ( nom != null && nom.trim().length() > 15 ) {
			throw new Exception_Nico( "Le nom ne peut contenir plus de 15 caractères." );
		}
	}
	/**
	 * @param prenom a rentré en param dans le Setters
	 * @throws Exception_Nico elle extends NullPointerException
	 */
	public void controlePrenom(String prenom ) throws Exception_Nico {
		if( prenom == null || prenom.trim() == "") {
			throw new Exception_Nico( "Le prenom n'est pas renseigné" );
		}
		if ( prenom != null && prenom.trim().length() < 2 ) {
			throw new Exception_Nico( "Le prenom doit contenir au moins 2 caractères." );
		}
		if ( prenom != null && prenom.trim().length() > 15 ) {
			throw new Exception_Nico( "Le prenom ne peut contenir plus de 15 caractères." );
		}
	}
	/**
	 * @param alias a rentré en param dans le Setters
	 * @throws Exception_Nico elle extends NullPointerException
	 */
	public void controleAlias(String alias ) throws Exception_Nico {
		if ( alias == null || alias.trim() == "") {
			throw new Exception_Nico( "L'alias n'est pas renseigné" );
		}
		if ( alias != null && alias.trim().length() < 2 ) {
			throw new Exception_Nico( "L'alias doit contenir au moins 2 caractères." );
		}
		if ( alias != null && alias.trim().length() > 15 ) {
			throw new Exception_Nico( "L'alias ne peut contenir plus de 15 caractères." );
		}
	}
	/**
	 * @param telPortable a rentré en param dans le Setters
	 * @throws Exception_Nico elle extends NullPointerException
	 */
	public void controleTelPortable(String telPortable ) throws Exception_Nico {
		if( telPortable == null || telPortable.trim() == "") {
			throw new Exception_Nico( "Le téléphone Portable n'est pas renseigné" );
		}
		if ( telPortable != null && telPortable.trim().length() != 10 ) {
			throw new Exception_Nico( "Le téléphone Portable doit contenir 10 caractères." );
		}
	}
	/**
	 * @param telFixe a rentré en param dans le Setters
	 * @throws Exception_Nico elle extends NullPointerException
	 */
	public void controleTelFixe(String telFixe ) throws Exception_Nico {
		if ( telFixe != null && telFixe.trim() != "" && telFixe.trim().length() != 10 ) {
			throw new Exception_Nico( "Le téléphone Fixe doit contenir 10 caractères." );
		}
	}
}