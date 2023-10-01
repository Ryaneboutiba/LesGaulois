package personnages;

public enum Equipement {
	Casque("casque"),Bouclier("bouclier");
	private String nom;


	private Equipement(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

}