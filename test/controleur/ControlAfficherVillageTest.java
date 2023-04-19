package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("Village des irreductibles", 10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
		village.ajouterHabitant(new Gaulois("Bonemine", 10));
		village.ajouterHabitant(new Gaulois("Asterix", 15));
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertTrue(controlAfficherVillage.donnerNomVillage().equals("Village des irreductibles"));
		assertFalse(controlAfficherVillage.donnerNomVillage().equals("Pas le nom du village"));
	}
	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(),  1);
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), village.donnerVillageois());
	}
}
