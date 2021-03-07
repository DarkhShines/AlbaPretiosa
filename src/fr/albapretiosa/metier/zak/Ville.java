package fr.albapretiosa.metier.zak;

public class Ville {
	private  int idVille;
	private String libelle;
	private Pays pays;

	public Ville() {
	}
	
	public Ville(int idVille, String libelle) {
		setIdVille(idVille);
		setLibelle(libelle);
	}
	public Ville(int idVille, String libelle, Pays pays) {
		this(idVille, libelle);
		setPays(pays);
	}
	

	public Ville(int idVille) {
		setIdVille(idVille);
	}

	public Ville(String ville) {
		setLibelle(ville);
	}

	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", libelle=" + libelle + ", pays=" + pays + "]";
	}

	/**
	 * @return the idVille
	 */
	public int getIdVille() {
		return idVille;
	}

	/**
	 * @param idVille the idVille to set
	 */
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	
}
