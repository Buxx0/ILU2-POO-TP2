package controleur;

import villagegaulois.Etal;


public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public Etal isVendeur(String nomVendeur) {
		Etal etal = null;
		etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal;
	}
	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'�tal est occup� [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantit� de produit � vendre au d�but du march� [4] :
	 *         quantit� de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		String[] donneesEtal = null;
		Etal etal = null;
		etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null) {
			donneesEtal = etal.etatEtal();
		}
		return donneesEtal;
	}

}