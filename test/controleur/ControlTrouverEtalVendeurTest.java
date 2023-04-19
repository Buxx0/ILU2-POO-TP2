package controleur;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef chef;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("Village des irreductibles", 10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur);
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertEquals(village.rechercherEtal(bonemine), controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
	}

}
