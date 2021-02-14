package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import AppException.Exception_Zak;
import fr.albapretiosa.metier.zak.Annonce;
import org.junit.jupiter.api.Test;

class TestCaseZak {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@DisplayName("")
	void testAnnonceComplete() throws Exception_Zak{
		Annonce a = new Annonce("Titre", 1200, "France", "Marseille",  LocalDate.of(2018,12,12),  LocalDate.of(2022,12,12), "Blabla", true, false, true, false);
	}
}
