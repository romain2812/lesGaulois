package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
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
}
