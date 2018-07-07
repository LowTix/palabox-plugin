package fr.lowtix.palabox.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.Locations;
import fr.lowtix.palabox.events.UserJoinEvent;
import fr.lowtix.palabox.users.GameUser;

public class InOutListeners implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		
		Player player = event.getPlayer();
		
		player.sendMessage("§8[§6§l!§8] §7Vous avez rejoint le serveur §cPalaBox§7...");
		
		GameUser user = Main.getInstance().getGameUser(player);
		user.setInSpawn(false);
		
		player.teleport(Main.getInstance().getLocationsConfiguration().getSavedLocation(Locations.SPAWN_LOCATION));
		
	}
	
	@EventHandler
	public void onUserJoin(UserJoinEvent event) {
		
		GameUser user = event.getUser();
		Player player = user.getPlayer();
		
		System.out.println(player.getName() + " / RANK:" + user.getRank().name());
		
		player.sendMessage("§8[§2✔§8] §aSuccès! §7Votre compte a été correctement chargé.");
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		
		Player player = event.getPlayer();
		GameUser user = Main.getInstance().getGameUser(player);
		
		System.out.println(player.getName() + " / RANK:" + user.getRank().name());
		
		user.deleteUser();
	}

}
