package jUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.albapretiosa.dao.Dao;
import fr.albapretiosa.metier.zak.Annonce;
import fr.albapretiosa.metier.zak.Annonces;


class TestCaseZak {

	@DisplayName("Test1 equals dans Annonce - cas nominal")
	@Test
	void test1() {
		Annonce anTest = new Annonce(1);
		assertTrue(anTest.equals(Dao.getAllAnnonce().get(1)));
	}
	@DisplayName("Test1a equals dans Annonce - alternatif")
	@Test
	void test1a() {
		Annonce anTest = new Annonce(1);
		assertFalse(anTest.equals(Dao.getAllAnnonce().get(10)));
	}
	
	@DisplayName("Test2 methode getAnnonceById dans Dao")
	@Test
	void test2() {
		Annonce anTest = new Annonce(1);
		assertEquals(anTest, Dao.getAnnonceById(1));
	}
	
	@DisplayName("Test3 equals dans Annonce")
	@Test
	void test3() {
		Annonce anTest = new Annonce(1);
		assertTrue(anTest.equals(new Annonce(1)));
	}
	
	
	@DisplayName("Test4 methode getAllAnnonce dans Dao")
	@Test
	void test4() {
		Annonces anTest = new Annonces();
		assertEquals(anTest, Dao.getAllAnnonce());
	}

	@DisplayName("Test5 methode getAbonne(String idAbonne) dans Dao avec idAbonne inexistant")
	@Test
	void test6() {
		assertEquals(null, Dao.getAnnonceById(99));
	}
}


