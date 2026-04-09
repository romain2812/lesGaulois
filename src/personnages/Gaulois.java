package personnages;

import village_gaulois.Musee;
import village_gaulois.Village;

import objets.Equipement;

public class Gaulois {
	private String nom;

	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	private Village village;
	private String etat;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesLocal = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; tropheesLocal != null && i < tropheesLocal.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesLocal[i];
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;

	}

	public void setVillage(Village village) {
		this.village = village;
		if (village.getChef() == this) {
			this.etat = "chef";
		} else {
			this.etat = "villagois";
		}

	}

	public void sePresenter() {
		String texte = "Bonjour, je m'appelle ";
		if (village == null) {
			parler(texte + nom + ". Je voyage de villages en villages.");
		} else {
			if (etat!= null && etat.equals("villagois")) {
				parler(texte + nom + " J'habite le village :" + village.getNom());
			} else {
				parler(texte + nom + "Je suis le chef le village :" + village.getNom());
			}

		}

	}
	
	
	public void faireUneDonnation(Musee musee){
		if (nbTrophees != 0) {
			parler("Je donne au musee tous mes trophees:");
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				System.out.println(trophees[i]);
			}
			nbTrophees = 0;
		}
		
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);

	}

}
