package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void intiialiserSituation() {
		village = new Village("Village des irreductibles", 10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
		Gaulois bonemine =new Gaulois("Bonemine", 10);
		Gaulois asterix = new Gaulois("Asterix", 10);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "boucliers", 10);
		village.installerVendeur(bonemine, "fleurs", 20);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche);
	}
	
	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertArrayEquals(controlAfficherMarche.donnerInfosMarche(), village.donnerEtatMarche());
	}

}
