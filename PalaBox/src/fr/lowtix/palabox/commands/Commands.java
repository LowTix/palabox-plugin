package fr.lowtix.palabox.commands;

import fr.lowtix.palabox.Main;

public class Commands {

	public void init() {
		Main.getInstance().getCommand("location").setExecutor(new SetLocationsCommand());
		Main.getInstance().getCommand("setrank").setExecutor(new SetRankCommand());
		Main.getInstance().getCommand("spawnreg").setExecutor(new SpawnRegCommand());
	}

}
