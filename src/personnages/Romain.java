package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] tabEquipement;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		tabEquipement = new Equipement[2];
		assert isInvariantVerified(force);

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "le romain " + this.nom + " : ";
	}

	private boolean isInvariantVerified(int force) {
		if (force >= 0) {
			return true;
		}
		return false;
	}
//
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup >= 0;
//		int temp = this.force;
//		this.force = this.force - forceCoup;
//		if (this.force < 1) {
//			parler("j'abandonne!");
//		} else {
//			parler("Aie");
//		}
//		assert isInvariantVerified(force);
//		assert temp > this.force;
//	}

	
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force == 0) {
			parler("Aïe");
			break;
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
		}
		
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	
	
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2: {
			System.out.println("Le soldat" + nom + "est déjà bien protégé !");
			break;
		}
		case 1: {
			if (tabEquipement[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + "!");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		}
		case 0: {
			ajouterEquipement(equipement);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.nbEquipement);
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		tabEquipement[nbEquipement] = equipement;
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement + ".");
		nbEquipement++;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);

	}
}
