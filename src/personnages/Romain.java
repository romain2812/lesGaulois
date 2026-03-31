package personnages;

import java.security.PrivateKey;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] tabEquipement;
	private int nbEquipement = 0;
	

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
		tabEquipement = new Equipement[2];
		
		
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		
	    
		
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
		if (force >=0) {
			return true;
		}
		return false;
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup>=0;
		int temp = this.force;
		this.force = this.force - forceCoup;
		if (this.force < 1) {
			parler("j'abandonne!");
		} 
		else {
			parler("Aie");
		}
		assert isInvariantVerified(force);
		assert temp>this.force;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2: {
			System.out.println("Le soldat" +nom+ "est déjà bien protégé !");
			break;
		}
		case 1:{
			if(tabEquipement[0]==equipement) {
				System.out.println("Le soldat "+ nom +" possède déjà un "+equipement+ "!");
			}
			else {
				tabEquipement[1]=equipement;
				System.out.println("Le soldat "+nom+" s’équipe avec un "+equipement+".");
				nbEquipement++;
			}
			break;
		}
		case 0:{
			tabEquipement[0]=equipement;
			System.out.println("Le soldat "+nom+" s’équipe avec un "+equipement+".");
			nbEquipement++;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.nbEquipement);
		}
	}
}
