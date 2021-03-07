package fr.albapretiosa.metier.zak;

import java.util.ArrayList;

import fr.albapretiosa.metier.zak.Annonce;

public class Annonces extends ArrayList<Annonce> {

	public Annonces() {
	}
	
	public Annonces(ArrayList<Annonce> annonces) {
		this.addAll(annonces);
	}




	private static final long serialVersionUID = 1L;



}