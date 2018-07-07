package fr.lowtix.palabox.enumerations;

public enum Kits {

	DEFENSE("Défense"), OFFENSE("Attaque");
	
	public String name;

	private Kits(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
