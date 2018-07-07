package fr.lowtix.palabox.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.Locations;
import fr.lowtix.palabox.users.GameUser;

public class DeathListener implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		GameUser user = Main.getInstance().getGameUser(player);
		
		user.getStats().setDeaths(user.getStats().getDeaths() + 1);
		user.getStats().setCurrentStreak(0);
		
		if(player.getKiller() == null) {
			
			player.sendMessage("§8[§6§l!§8] §7Vous vous êtes suicidé.");
			
			playerDeath(player);
			
		} else {
			
			Player killer = player.getKiller();
			GameUser killerUser = Main.getInstance().getGameUser(killer);
			
			killerUser.getStats().setKills(killerUser.getStats().getDeaths() + 1);
			killerUser.getStats().setCurrentStreak(killerUser.getStats().getCurrentStreak() + 1);
			
			if(killerUser.getStats().getMaxStreak() < killerUser.getStats().getCurrentStreak()) {
				killerUser.getStats().setMaxStreak(killerUser.getStats().getCurrentStreak());
			}
			
			player.sendMessage("§8[§6§l!§8] §f" + killerUser.getRank().getPrefixColor() + killerUser.getRank().getPrefix() + " "+killer.getName()+" §7vous a tué.");
			killer.sendMessage("§8[§6§l!§8] §7Elimination de §f" + user.getRank().getPrefixColor() + user.getRank().getPrefix() + " "+player.getName());
			
			playerDeath(player);
		}
		
	}
	
	private void playerDeath(Player player) {
		
		player.spigot().respawn();
		player.setBedSpawnLocation(Main.getInstance().getLocationsConfiguration().getSavedLocation(Locations.SPAWN_LOCATION));
		player.teleport(Main.getInstance().getLocationsConfiguration().getSavedLocation(Locations.SPAWN_LOCATION));
		
	}

}
