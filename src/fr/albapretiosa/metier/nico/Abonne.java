package fr.albapretiosa.metier.nico;

import java.util.concurrent.atomic.AtomicInteger;

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
	
	// CONSTRUCTEUR 
	public Abonne(String nom, String prenom, String alias, String email, String telPortable,
			boolean platinum, String mdp, String parrainage) {
		super();
		setNom(nom);
		setIdAbonne(genId.getAndIncrement()); 
		setPrenom(prenom);
	    setAlias(alias);
	    setEmail(email);
	    setTelPortable(telPortable);
	    setPlatinum(platinum);
	    setMdp(mdp);
	    setParrainage(parrainage);
	}
	public Abonne(String nom, String prenom, String alias, String email, String telPortable,
			String telFixe, boolean platinum, String mdp, String parrainage) {
		super();
		setNom(nom);
		setIdAbonne(genId.getAndIncrement()); 
		setPrenom(prenom);
	    setAlias(alias);
	    setEmail(email);
	    setTelPortable(telPortable);
	    setTelFixe(telFixe);
	    setPlatinum(platinum);
	    setMdp(mdp);
	    setParrainage(parrainage);
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
	
	// SETTER
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setIdAbonne(int idAbonne) {
		if(idAbonne != 0) {
			this.idAbonne = idAbonne;
		}
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}
	public void setTelFixe(String telFixe) {
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
	
	// METHODE 
	@Override
	public String toString() {
		return "Abonne [nom=" + nom + ", idAbonne=" + idAbonne + ", prenom=" + prenom + ", alias=" + alias + ", email="
				+ email + ", telPortable=" + telPortable + ", telFixe=" + telFixe + ", platinum=" + platinum + ", mdp="
				+ mdp + ", parrainage=" + parrainage + "]";
	}
	
	
	
	
	
}