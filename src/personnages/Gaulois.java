package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village = null;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendrearole() + "\"" + texte + "\"");
	}

	private String prendrearole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la machoire de " + nomRomain);
		romain.recevoirCoup((this.force * this.effetPotion) / 3);
		if (effetPotion > 1) {
			effetPotion--;
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;

	}
	
	public void setVillage(Village village) {
		this.village = village;		
		
	}
	
	public void sePresenter() {
		
		
		
	}

	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);

	}

}
