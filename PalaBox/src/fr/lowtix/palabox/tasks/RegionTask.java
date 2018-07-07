package fr.lowtix.palabox.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.events.UserEnterSpawnEvent;
import fr.lowtix.palabox.events.UserExitSpawnEvent;
import fr.lowtix.palabox.users.GameUser;

public class RegionTask extends BukkitRunnable {

	/*
	 * Asynchronous Task
	 */
	
	@Override
	public void run() {
		
		for(GameUser users : Main.getInstance().getGameUsers().values()) {
			
			Player player = users.getPlayer();
			
			if(Main.getInstance().getSpawn_region().getRegion().inCuboid(player.getLocation().subtract(0, 1, 0))) {
				
				if(!users.isInSpawn()) {
					Bukkit.getPluginManager().callEvent(new UserEnterSpawnEvent(users));
					users.setInSpawn(true);
				}
				
			} else {
				
				if(users.isInSpawn()) {
					Bukkit.getPluginManager().callEvent(new UserExitSpawnEvent(users));
					users.setInSpawn(false);
				}
				
			}
			
		}
		
	}

}
