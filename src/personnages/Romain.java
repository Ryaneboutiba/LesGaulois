package personnages;

<<<<<<< HEAD

=======
>>>>>>> ccd595be2230358b9a5f8dfbe16b6300dfd12fcd
public class Romain {
	private String texte;
	private String nom;
	private int force;
	private Equipement[] equipements;
<<<<<<< HEAD
	private int nbEquipement=0;
	
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements=new Equipement[2];
=======
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
>>>>>>> ccd595be2230358b9a5f8dfbe16b6300dfd12fcd
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le Romain" + nom + ":";
	}

	public void ajouterequip(Equipement equipement) {
<<<<<<< HEAD
		equipements[nbEquipement]=equipement;
		nbEquipement+=1;
=======
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + getNom() + " s'equipe d'un " + equipement);
>>>>>>> ccd595be2230358b9a5f8dfbe16b6300dfd12fcd
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
<<<<<<< HEAD
		
		case 0:{
			ajouterequip(equipement);
			System.out.println("Le soldat "+getNom()+" s'Ã©quipe d'un "+equipement);
			break;
		}
		
		case 1:{
			if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat "+getNom()+"possÃ¨de dÃ©jÃ  un "+equipement);
			}
			else {
				extracted(equipement);
=======

		case 0: {
			ajouterequip(equipement);
			break;
		}

		case 1: {
			if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat " + getNom() + " possede deja  un " + equipement);
			} else {
				ajouterequip(equipement);
>>>>>>> ccd595be2230358b9a5f8dfbe16b6300dfd12fcd
			}
			break;
		}
		case 2: {
			System.out.println("Le soldat " + getNom() + " est deja  bien equipe.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
<<<<<<< HEAD
		} 
			
	}

	private void extracted(Equipement equipement) {
		ajouterequip(equipement);
		System.out.println("Le soldat "+getNom()+" s'Ã©quipe d'un "+equipement);
	}
		
	
//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int force_dÃ©but=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie...");
//		}
//		else {
//			parler("J'abondonne...");
//		int force_fin=force;
//		assert force_fin<force_dÃ©but;
//		}
		
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// prÃ©condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
		 parler("AÃ¯e");
		 } else {
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 }
//		switch (force) {
//		case 0:
//		parler("AÃ¯e");
//		break;
//		default:
//		equipementEjecte = ejecterEquipement();
//		parler("J'abandonne...");
//		break;
//		}
		// post condition la force a diminuÃ©e
		assert force < oldForce;
		return equipementEjecte;
		}
	
	
	private int calculResistanceEquipement(int forceCoup) {
  String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace Ã  mon Ã©quipement sa force est diminuÃ© de ";
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
		System.out.println("L'Ã©quipement de " + nom.toString() + "s'envole sous la force du coup.");
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


	
=======
		}

	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forcedebut = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie...");
//		} else {
//			parler("J'abondonne...");
//			int forcefin = force;
//			assert forcefin < forcedebut;
//		}
//
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force==0) {
		parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
			}
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.Bouclier)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
				} else {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
				}
				return equipementEjecte;
				}

		


>>>>>>> ccd595be2230358b9a5f8dfbe16b6300dfd12fcd
	public static void main(String[] args) {
		for (Equipement equip : Equipement.values()) {
			System.out.println(equip);
		}
		Romain minus = new Romain("minus", 8);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
		assert minus.getForce() > 0;
		minus.parler("Hello World");
		System.out.println(minus.prendreParole());
		minus.recevoirCoup(9);
	}

}
