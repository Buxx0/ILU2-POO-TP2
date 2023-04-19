package controleur;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void setup() {
		village = new Village("Village des irreductibles", 10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal);
	}
	
	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois bonemine = new Gaulois("Bonemine", 15);
		Gaulois asterix = new Gaulois("Asterix", 15);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertNotNull(controlLibererEtal.isVendeur("Bonemine"));
		assertNull(controlLibererEtal.isVendeur("Asterix"));
	}

	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois asterix = new Gaulois("Asterix", 15);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 15);
		assertArrayEquals(village.rechercherEtal(asterix).etatEtal(),controlLibererEtal.libererEtal("Asterix"));
	}
}
