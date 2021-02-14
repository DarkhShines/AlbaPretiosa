package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import AppException.Exception_Zak;
import fr.albapretiosa.metier.zak.Annonce;
import org.junit.jupiter.api.Test;

class TestCaseZak {


	@DisplayName("Test de la méthode controleTitre() si le titre est plus cours que 10 caractères.")
	@Test
	void testControleTitreC1() {
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		assertThrows(Exception_Zak.class, ()->{ ann.setTitre("Z");});
	}
	
	@DisplayName("Test de la méthode controleTitre() si le titre est plus long que 100 caractères.")
	@Test
	void testControleTitreC2() {
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		assertThrows(Exception_Zak.class, ()->{ann.setTitre("Annonce ann = new Annonce(\"Manoir DeCruz\", 1200, \"France\", \"Hyers\", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), \"Blablabla\", true, true, false, true);Annonce	ann = new Annonce(\"Manoir DeCruz\", 1200, \"France\", \"Hyers\", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), \"Blablabla\", true, true, false, true);");});	
	}
	
	@DisplayName("Test de la méthode controleTitre() si le titre est null ")
	@Test
	void testControleTitreC3() {
		Annonce	ann = new Annonce("Manoir DeCruz", 1200, "France", "Paris", LocalDate.of(2019,12,12), LocalDate.of(2022,12,12), "Blablabla", true, true, false, true);
		assertThrows(Exception_Zak.class, ()->{ann.setTitre(null);});
	}
}
