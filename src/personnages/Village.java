package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom , int nbVillageoixmaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoixmaximum];
	}
	
	
	public void setChef(Chef chef) {
		this.chef = chef;
		}

	public Gaulois trouverHabitant(int numéro) {
		return villageois[numéro];
	}
	
	public void afficherVillageois(Chef chef) {
		System.out.println("Dans le village de "+chef.getNom()+" il y a :\n ");
		for(int i=0; i<nbVillageois; i++) {
			System.out.println("-"+trouverHabitant(i).getNom()+"\n"); 
		}
	}
	
	public void ajouterHabitants(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois+=1;
	}

	public String getNom() {
		return nom;
	}
    
	public static void main(String[] args) {
		Village village=new Village("Village des Irréductible",30);
//		Gaulois gaulois=village.trouverHabitant(30);
//		On obtient l'execption préceedente car on demande à avoir accèes à un élément en dehors du tableau car les élements du tableau vont de 0 à 29 tandis que 30 est la taille du tableau et donc ne peut pas être un indice de ce dernier
//		Chef abaracourcix = new Chef("abaracourcix",6,village);
//		village.setChef(abaracourcix);
//		Gaulois astérix=new Gaulois("astérix",8);
//		village.ajouterHabitants(astérix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		On obtient null car asterix sera à l'indice 0 et non pas 1
		Chef abaracourcix = new Chef("abaracourcix",6,village);
		Gaulois astérix=new Gaulois("astérix",8);
		village.ajouterHabitants(astérix);
		Gaulois obélix=new Gaulois("obelix",25);
     	village.ajouterHabitants(obélix);
     	village.afficherVillageois(abaracourcix);		
	}
	
}
