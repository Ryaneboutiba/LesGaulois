package personnages;

public class Gaulois {
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
	private String nom;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}
    public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		System.out.println("Merci druide je sens que ma force est"+ " "+effetPotion+" "+"decuple!");
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte+">>");
	}
	
//	private String prendreParole() {
//		return "Le Gaulois" +" " + nom + ":";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mochoire de : " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	    Equipement trophees[] = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbtrophees++) {
		this.trophees[nbtrophees] = trophees[i];
		}
		}

	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force  + "]" ;
		
	}
	
    public static void main(String[] args) {
		Gaulois asterix=new Gaulois("asterix",8);
		Romain minus=new Romain("minus",3);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Hello World");
		asterix.frapper(minus);
		asterix.boirePotion(8);
	}
    

}
