//package histoire;
//
//import personnages.Druide;
//import personnages.Gaulois;
//import personnages.Romain;
//
//public class Scenario {
//	public static void main(String[] args) {
//		Gaulois asterix=new Gaulois("asterix",8);
//		Gaulois obélix=new Gaulois("Obélix",25);
//		Druide panoramix=new Druide("panoramix",10,5);
//		Romain minus=new Romain("minus",6);
//		panoramix.parler("Bonjour, je suis le druide "+panoramix.getNom()+" et ma potion peut aller d'une force de "+panoramix.getEffetPotionMin()+" à "+panoramix.getEffetPotionMax()+" .");
//		panoramix.parler("Je vais aller préparer ma potion .");
//		panoramix.preparerPotion();
//		panoramix.booster(obélix);
//		obélix.parler("Par Bélénos, ce n'est pas juste!");
//		panoramix.booster(asterix);
//		asterix.parler("Bonjour !");
//		minus.parler("UN GAU...GAUGAU...");
//		do {
//		asterix.frapper(minus);
//	}while (minus.getForce()>0);
//	}
//	
//}

package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
		milexcus.sEquiper(Equipement.Casque);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}