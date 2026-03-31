package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private int nbVillageoisMax;
	private Gaulois[] tabVilage;


	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		this.nbVillageoisMax = nbVillageoisMax;
		tabVilage = new Gaulois [nbVillageoisMax];
	}
	
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		village.trouverVillagois(30);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillagois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillagois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolémix = new Gaulois("Doublepolémix ", 4);
		asterix.sePresenter();
		abraracourcix.sePresenter();
		doublepolémix.sePresenter();
	}


	public String getNom() {
		return nom;
	}
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		tabVilage[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	
	
	public Gaulois trouverVillagois(int numVillageois) {
		numVillageois--;
		if (nbVillageois>numVillageois) {
			return tabVilage[numVillageois];
		}
		else {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		}
		
	}
	public void afficherVillageois() {
		System.out.println("Dans le village \""+nom+"\" du chef "+chef.getNom());
		System.out.println("vivent les légendaires gaulois :");
		for (Gaulois gaulois : tabVilage) {
			if (gaulois != null) {
				System.out.println("- "+gaulois.getNom());
			}
		}
		
	}

}
