package personnages;

import java.security.PublicKey;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equip;
	private int nbequip=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equip=new Equipement[2];
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
    
	public void ajouterequip(Equipement equipement) {
		equip[nbequip]=equipement;
		nbequip+=1;
	}
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbequip) {
		
		case 0:{
			ajouterequip(equipement);
			System.out.println("Le soldat "+getNom()+" s'équipe d'un "+equipement);
		}
		
		case 1:{
			if (equip[0].equals(equipement)) {
				System.out.println("Le soldat "+getNom()+"possède déjà un "+equipement);
			}
			else {
				extracted(equipement);
			}
			break;
		}
		 case 2: {
			  System.out.println("Le soldat "+getNom()+" est déjà bien équipé.");
			  break;	
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nbequip);
		} 
			
	}

	private void extracted(Equipement equipement) {
		ajouterequip(equipement);
		System.out.println("Le soldat "+getNom()+" s'équipe d'un "+equipement);
	}
		
	
	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int force_début=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie...");
		}
		else {
			parler("J'abondonne...");
		int force_fin=force;
		assert force_fin<force_début;
		}
		
	
		
		
	}
	
	public static void main(String[] args) {
		for(Equipement equip : Equipement.values()) {
			System.out.println(equip);
		}
		Romain minus=new Romain("minus",8);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
		assert minus.getForce()>0;
		minus.parler("Hello World");
		System.out.println(minus.prendreParole());
		minus.recevoirCoup(9);
	}

}
