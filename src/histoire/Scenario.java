package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix=new Gaulois("asterix",8);
		Gaulois obelix=new Gaulois("Obélix",25);
		Druide panoramix=new Druide("panoramix",10,5);
		Romain minus=new Romain("minus",6);
		panoramix.parler("Bonjour, je suis le druide "+panoramix.getNom()+" et ma potion peut aller d'une force de "+panoramix.getEffetPotionMin()+" Ã  "+panoramix.getEffetPotionMax()+" .");
		panoramix.parler("Je vais aller preparer ma potion .");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bablanos, ce n'est pas juste!");
		panoramix.booster(asterix);
		asterix.parler("Bonjour !");
		minus.parler("UN GAU...GAUGAU...");
		do {
		asterix.frapper(minus);
	}while (minus.getForce()>0);
	}
	
}
