package fr.albapretiosa.metier.zak;


public class Catalogue {

	
	private String villa;
	private String appartement;
	private String loft;
	private String chateau;


	public Catalogue(String villa, String appartement, String loft, String chateau) {
		this.villa = villa;
		this.appartement = appartement;
		this.loft = loft;
		this.chateau = chateau;
	}

	public Catalogue() {
	}

	@Override
	public String toString() {
		return "Catalogue []";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/**
	 * @return the villa
	 */
	public String getVilla() {
		return villa;
	}

	/**
	 * @param villa the villa to set
	 */
	public void setVilla(String villa) {
		this.villa = villa;
	}

	/**
	 * @return the appartement
	 */
	public String getAppartement() {
		return appartement;
	}

	/**
	 * @param appartement the appartement to set
	 */
	public void setAppartement(String appartement) {
		this.appartement = appartement;
	}

	/**
	 * @return the loft
	 */
	public String getLoft() {
		return loft;
	}

	/**
	 * @param loft the loft to set
	 */
	public void setLoft(String loft) {
		this.loft = loft;
	}

	/**
	 * @return the chateau
	 */
	public String getChateau() {
		return chateau;
	}

	/**
	 * @param chateau the chateau to set
	 */
	public void setChateau(String chateau) {
		this.chateau = chateau;
	}


}
