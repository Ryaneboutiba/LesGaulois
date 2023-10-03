package personnages;

public class Romain {
	private String texte;
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
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
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + getNom() + " s'equipe d'un " + equipement);
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {

		case 0: {
			ajouterequip(equipement);
			break;
		}

		case 1: {
			if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat " + getNom() + " possede deja  un " + equipement);
			} else {
				ajouterequip(equipement);
			}
			break;
		}
		case 2: {
			System.out.println("Le soldat " + getNom() + " est deja  bien equipe.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
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
