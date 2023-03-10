package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Bienvenu druide " + nomVisiteur + ".\n");
		questionForce.append("Quelle est votre force?\n");
		int forceDruide = Clavier.entrerEntier(questionForce.toString());
		StringBuilder questionPotionMin = new StringBuilder();
		questionPotionMin.append("Quelle est la force de la potion la plus faible?\n");
		StringBuilder questionPotionMax = new StringBuilder();
		questionPotionMax.append("Quelle est la force de la potion la plus forte?\n");
		int forcePotionMin=-1;
		int forcePotionMax=-1;
		do {
			forcePotionMin = Clavier.entrerEntier(questionPotionMin.toString());
			forcePotionMax = Clavier.entrerEntier(questionPotionMax.toString());
			if (forcePotionMin < forcePotionMax) break;
			System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum!");
		} while (forcePotionMin > forcePotionMax);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, forcePotionMin, forcePotionMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder questionGaulois = new StringBuilder();
		questionGaulois.append("Bienvenu gaulois " + nomVisiteur + ".\n");
		questionGaulois.append("Quelle est votre force?\n");
		int forceGaulois = Clavier.entrerEntier(questionGaulois.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
	}
}
