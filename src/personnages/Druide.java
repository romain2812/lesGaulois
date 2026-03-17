package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;

	public Druide(String nom, int force) {
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
		return "le Druide " + this.nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		this.chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concocté"+ quantite + "doses de potion magique. Elle a une force de "+ forcePotion+".");
		
	}
	public void booster(Gaulois gaulois) {
		boolean contientPotion = this.chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		if(contientPotion) {
			if(nomGaulois == "Obélix") {
				this.parler("Non, "+nomGaulois+"Non!...Et tu le sais tres bien !");
			}
			else {
				int forcePotion = this.chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				this.parler("Tiens "+ nomGaulois+" un peu de potion magique.");
			}
		}
		else {
			this.parler("Desole "+nomGaulois+  " il n'y a plus une seuke goutte de potion.");
		}
		
		
	}
	

}
