package fr.lowtix.palabox.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.lowtix.palabox.Main;

public class Listeners {
	
	public void init() {
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new InOutListeners(), Main.getInstance());
		pm.registerEvents(new SpawnListeners(), Main.getInstance());
		pm.registerEvents(new ResetListeners(), Main.getInstance());
		pm.registerEvents(new DeathListener(), Main.getInstance());
		pm.registerEvents(new ChatListener(), Main.getInstance());
	}

}
