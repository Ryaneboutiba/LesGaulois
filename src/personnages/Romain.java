package personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements=new Equipement[2];
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
		equipements[nbEquipement]=equipement;
		nbEquipement+=1;
	}
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		
		case 0:{
			ajouterequip(equipement);
			System.out.println("Le soldat "+getNom()+" s'équipe d'un "+equipement);
			break;
		}
		
		case 1:{
			if (equipements[0].equals(equipement)) {
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
			throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		} 
			
	}

	private void extracted(Equipement equipement) {
		ajouterequip(equipement);
		System.out.println("Le soldat "+getNom()+" s'équipe d'un "+equipement);
	}
		
	
//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int force_début=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie...");
//		}
//		else {
//			parler("J'abondonne...");
//		int force_fin=force;
//		assert force_fin<force_début;
//		}
		
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
		 parler("Aïe");
		 } else {
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 }
//		switch (force) {
//		case 0:
//		parler("Aïe");
//		break;
//		default:
//		equipementEjecte = ejecterEquipement();
//		parler("J'abandonne...");
//		break;
//		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	
	
	private int calculResistanceEquipement(int forceCoup) {
  String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;i++) {
		if ((equipements[i] != null && equipements[i].equals(Equipement.Bouclier)) ) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}


	
	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] != null) {
		equipementEjecte[nbEquipementEjecte] =
		equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
		}
		return equipementEjecte;
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
