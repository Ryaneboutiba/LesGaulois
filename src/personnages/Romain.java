package personnages;


public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte+">>");
	}
	
	private String prendreParole() {
		return "Le Romain" + nom + ":";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie...");
		}
		else {
			parler("J'abondonne...");
		}
	}
	
	public static void main(String[] args) {
		Romain minus=new Romain("minus",3);
		minus.parler("Hello World");
		System.out.println(minus.prendreParole());
		minus.recevoirCoup(9);
	}

}
