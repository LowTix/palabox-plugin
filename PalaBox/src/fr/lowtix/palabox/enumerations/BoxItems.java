package fr.lowtix.palabox.enumerations;

public enum BoxItems {
	
	URANIUM(4096), BLOCK_OF_URANIUM(165), URANIUM_HELMET(4097), URANIUM_CHESTPLATE(4098), URANIUM_LEGGINGS(4099), URANIUM_BOOTS(4100), URANIUM_SWORD(4101), URANIUM_PICKAXE(4102), URANIUM_APPLE(4103);
	
	private int id;

	private BoxItems(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
