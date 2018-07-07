package fr.lowtix.palabox.enumerations;

public enum BasicMessages {
	
	LINE("§8§m-----------------------------------------"),
	NOT_PERMISSION("§8[§4✖§8] §cVous n'avez pas les pouvoirs nécéssaires."),
	CANNOT_DO_THAT("§8[§4✖§8] §7Vous ne pouvez pas faire cela.");
	
	private String message;

	private BasicMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
