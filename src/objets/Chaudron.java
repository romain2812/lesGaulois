package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.forcePotion = forcePotion;
		this.quantitePotion = quantite;
		
		
	}

	public boolean resterPotion() {
		return this.quantitePotion >0;
		
	}
	
	
	public int prendreLouche() {
		return 2;
		
	}
	
	
}
