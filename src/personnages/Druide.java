package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion=1;
	private int effetPotionMax;
	private int effetPotionMin;
	
	public int getEffetPotionMax() {
		return effetPotionMax;
	}


	public int getEffetPotionMin() {
		return effetPotionMin;
	}


	public Druide(String nom, int effetPotionMax, int effetPotionMin) {
		this.nom = nom;
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
	}

	
	public void preparerPotion() {
		Random random = new Random();
		int forcePotionPrepared=random.nextInt(effetPotionMax);
		if (forcePotionPrepared>7) {
			System.out.println("J'ai pr�parer une super potion de force :"+ " "+forcePotionPrepared);
			forcePotion=forcePotionPrepared;
		}
		else {
			System.out.println("Je n'ai pas trouv� tous les ingr�dients ma potion est seulement de force :"+ " "+forcePotionPrepared);
			forcePotion=forcePotionPrepared;
		}
	}
	
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom()=="Obélix") {
			System.out.println("Non Obélix!...Tu n'auras pas de potion");
		}
		else {
			gaulois.boirePotion(forcePotion);
		}
		
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte+">>");
	}

	private String prendreParole() {
		return "Le Druide" + nom + ":";
	}
	
	public static void main(String[] args) {
		Druide panoramix=new Druide("panoramix",10,5);
		panoramix.preparerPotion();
		
	}
}
