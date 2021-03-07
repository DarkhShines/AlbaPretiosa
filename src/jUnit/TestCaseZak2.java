package jUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import AppException.Exception_Zak;
import fr.albapretiosa.metier.nico.Abonne;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.metier.zak.Ville;

class TestCaseZak2 {


	@DisplayName("Test de la méthode controleSurface() si la surface est inferieur à 100.")
	@Test
	void testControleSurfaceC1() {
		Abonne ab = new Abonne();
		Ville ville = new Ville();
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", ab, ville );
		assertThrows(Exception_Zak.class, ()->{ ann.setSurface(10);});
	}
	
	@DisplayName("Test de la méthode controleSurface() si la surface est supperieur à 112100.")
	@Test
	void testControleSurfaceC2() {
		Abonne ab = new Abonne();
		Ville ville = new Ville();
		Annonce	ann = new Annonce("Manoir DeCruz", 1200,LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", ab, ville);
		assertThrows(Exception_Zak.class, ()->{ ann.setSurface(202100);});
	}
	
	@SuppressWarnings("null")
	@DisplayName("Test de la méthode controleSurface() si la surface est null.")
	@Test
	void testControleSurfaceC3() {
		Abonne ab = new Abonne();
		Ville ville = new Ville();
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", ab, ville);
		assertThrows(Exception_Zak.class, ()->{ ann.setSurface((Integer)null);});
	}
	
	
}
