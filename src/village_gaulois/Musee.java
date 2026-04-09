package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {

	private Trophee[] tabTrophee = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);

		if (nbTrophee < 200) {
			tabTrophee[nbTrophee] = trophee;
			nbTrophee++;

		}

	}

	public String extraireInstructionsOCaml() {
		StringBuilder texte = new StringBuilder("let musee = [\n");
		for (int i = 0; i < nbTrophee; i++) {
			texte.append("\" ");
			texte.append(tabTrophee[i].getGaulois());
			texte.append("\", \"");
			texte.append(tabTrophee[i].getEquipement());
			texte.append("\" \n");

		}
		texte.append("]");
		return texte.toString();

	}

}
