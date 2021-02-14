package jUnit;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import AppException.Exception_Zak;
import fr.albapretiosa.metier.zak.Annonce;

class TestCaseZak2 {


	@DisplayName("Test de la méthode controleSurface() si la surface est inferieur à 100.")
	@Test
	void testControleSurfaceC1() {
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		assertThrows(Exception_Zak.class, ()->{ ann.setSurface(10);});
	}
	
	@DisplayName("Test de la méthode controleSurface() si la surface est supperieur à 112100.")
	@Test
	void testControleSurfaceC2() {
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		assertThrows(Exception_Zak.class, ()->{ ann.setSurface(202100);});
	}
	
	@SuppressWarnings("null")
	@DisplayName("Test de la méthode controleSurface() si la surface est null.")
	@Test
	void testControleSurfaceC3() {
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		assertThrows(Exception_Zak.class, ()->{ ann.setSurface((Integer)null);});
	}
	
	
}
