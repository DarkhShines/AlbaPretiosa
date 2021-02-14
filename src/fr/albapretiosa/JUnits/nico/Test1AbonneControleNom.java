package fr.albapretiosa.JUnits.nico;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import AppException.Exception_Nico;
import fr.albapretiosa.metier.nico.Abonne;

class Test1AbonneControleNom {


	// test controle du nom < 2 caracteres
	@DisplayName("Nom inférieur a 2 caractère")
	@Test
	void testControleCourt() {
		Abonne abonne =new Abonne("Muscat", "Nicolas", "user1", "user1@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
		assertThrows(Exception_Nico.class, ()->{ abonne.setNom("M");});
	}
	//test controle du nom > 15 caracteres
	@DisplayName("Nom supérieur a 15 caractères")
	@Test
	void testControleLong() {
		Abonne abonne =new Abonne("Muscat", "Nicolas", "user1", "user1@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
		assertThrows(Exception_Nico.class, ()->{ abonne.setNom("Mmmmmmmmmmmmmmmm");});
	}
	//test controle du nom est null
	@DisplayName("Nom est null")
	@Test
	void testControleNull() {
		Abonne abonne =new Abonne("Muscat", "Nicolas", "user1", "user1@gmail.com", "0607717273","0442056322", "password", "DJB-264" );
		assertThrows(Exception_Nico.class, ()->{ abonne.setNom(null);});
	}
}
