package fr.albapretiosa.metier.zak;

public class Pays {
	private int idPays;
	private String libPays;
	
	public Pays(int idPays, String libPays) {
		setIdPays(idPays);
		setLibPays(libPays);
	}
	public Pays() {}

	/**
	 * @return the idPays
	 */
	public int getIdPays() {
		return idPays;
	}

	/**
	 * @param idPays the idPays to set
	 */
	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	/**
	 * @return the libPays
	 */
	public String getLibPays() {
		return libPays;
	}

	/**
	 * @param libPays the libPays to set
	 */
	public void setLibPays(String libPays) {
		this.libPays = libPays;
	}

	
	
	
	
}
