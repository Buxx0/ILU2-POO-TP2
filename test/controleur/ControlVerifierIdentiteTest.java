package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("Village des irreductibles", 10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois obelix = new Gaulois("Obelix", 15);
		village.ajouterHabitant(obelix);
		assertTrue(controlVerifierIdentite.verifierIdentite("Obelix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Bonemine"));	
	}

}
