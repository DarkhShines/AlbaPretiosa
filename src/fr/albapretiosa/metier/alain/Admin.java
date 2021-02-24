package fr.albapretiosa.metier.alain;

import fr.albapretiosa.metier.nico.Abonne;
/**
 * 
 * @author Alain
 *
 */
public class Admin extends Abonne {

	
	public Admin() {
		
	}
	public Admin(String nom, String prenom, String alias, String email, String telPortable, String telFixe, String mdp,
			String parrainage) {
		super(nom, prenom, alias, email, telPortable, telFixe, mdp, parrainage);
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom, String prenom, String alias, String email, String telPortable, String mdp,
			String parrainage) {
		super(nom, prenom, alias, email, telPortable, mdp, parrainage);
		// TODO Auto-generated constructor stub
	}
	public Admin(String alias, String nom, String prenom) {
		super(nom, prenom, alias);
		// TODO Auto-generated constructor stub
	}
	
}
