package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion=1;
	private int effetPotionMax;
	private int effetPotionMin;
	
	public Druide(String nom, int effetPotionMax, int effetPotionMin) {
		this.nom = nom;
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
	}

	
	public void preparerPotion() {
		Random random = new Random();
		int forcePotionPrepared=random.nextInt(effetPotionMax);
		if (forcePotionPrepared>7) {
			System.out.println("J'ai préparer une super potion de force :"+ " "+forcePotionPrepared);
		}
		else {
			System.out.println("Je n'ai pas trouvé tous les ingrédients ma potion est seulement de force :"+ " "+forcePotionPrepared);
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
