package fr.albapretiosa.metier.zak;

public class Option {

	private int 	idOption;
	private String  libelle;
	
	
	public Option(int idOption, String libelle) {
		setIdOption(idOption);
		setLibelle(libelle);
	}
	
	public Option(int idOption) {
		setIdOption(idOption);
	}
	
	public Option() {}

	

	public Option(boolean option) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Option [idOption=" + idOption + ", libelle=" + libelle + "]";
	}

	/**
	 * @return the idOption
	 */
	public int getIdOption() {
		return idOption;
	}


	/**
	 * @param idOption the idOption to set
	 */
	public void setIdOption(int idOption) {
		this.idOption = idOption;
	}


	/**
	 * @return the lib_option
	 */
	public String getLibelle() {
		return libelle;
	}


	/**
	 * @param lib_option the lib_option to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
}
