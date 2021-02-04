package fr.albapretiosa.metier.zak;

import fr.albapretiosa.metier.zak.*;

public class Catalogue {

	
	private boolean villa;
	private boolean appartement;
	private boolean loft;
	private boolean chateau;


	public Catalogue(boolean villa, boolean appartement, boolean loft, boolean chateau) {
		setVilla(villa);
		setLoft(loft);
		setAppartement(appartement);
		setChateau(chateau);
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
	public boolean getVilla() {
		return villa;
	}

	/**
	 * @param villa the villa to set
	 */
	public void setVilla(boolean villa) {
		this.villa = villa;
	}

	/**
	 * @return the appartement
	 */
	public boolean getAppartement() {
		return appartement;
	}

	/**
	 * @param appartement the appartement to set
	 */
	public void setAppartement(boolean appartement) {
		this.appartement = appartement;
	}

	/**
	 * @return the loft
	 */
	public boolean getLoft() {
		return loft;
	}

	/**
	 * @param loft the loft to set
	 */
	public void setLoft(boolean loft) {
		this.loft = loft;
	}

	/**
	 * @return the chateau
	 */
	public boolean getChateau() {
		return chateau;
	}

	/**
	 * @param chateau the chateau to set
	 */
	public void setChateau(boolean chateau) {
		this.chateau = chateau;
	}


}
