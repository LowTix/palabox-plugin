package fr.lowtix.palabox.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.Locations;
import fr.lowtix.palabox.events.UserEnterSpawnEvent;
import fr.lowtix.palabox.events.UserExitSpawnEvent;
import fr.lowtix.palabox.guis.KitsGui;
import fr.lowtix.palabox.guis.ProfileGui;
import fr.lowtix.palabox.users.GameUser;
import fr.lowtix.palabox.utils.GuiManager;

public class SpawnListeners implements Listener {
	
	@EventHandler
	public void onEnter(UserEnterSpawnEvent event) {
		
		GameUser user = event.getUser();
		Player player = user.getPlayer();
		
		player.teleport(Main.getInstance().getLocationsConfiguration().getSavedLocation(Locations.SPAWN_LOCATION));
		
		player.setGameMode(GameMode.ADVENTURE);
		player.setMaxHealth(2.0);
		player.setHealth(2.0);
		
		
		Main.getInstance().getInventoryManager().clearPlayer(player);
		Main.getInstance().getInventoryManager().giveSpawnItems(player.getInventory());
		
	}
	
	@EventHandler
	public void onExit(UserExitSpawnEvent event) {
		
		GameUser user = event.getUser();
		Player player = user.getPlayer();
		
		player.setGameMode(GameMode.SURVIVAL);
		player.setMaxHealth(20.0);
		player.setHealth(20.0);
		
		player.setNoDamageTicks(40);
		
		Main.getInstance().getInventoryManager().clearPlayer(player);
		Main.getInstance().getInventoryManager().giveArenaItems(player.getInventory(), user.getKit());
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		if(event.getItem() == null || event.getAction() == null) {
			return;
		}
		
		Player player = event.getPlayer();
		
		if(Main.getInstance().getSpawn_region().getRegion().inCuboid(player.getLocation())) {
			
			ItemStack item = event.getItem();
			
			if(item.getType().equals(Material.BOOK)) {
				
				GuiManager.openGui(new KitsGui(player));
				
			} else if(item.getType().equals(Material.BED)) {
				
				// TODO: Téléportation vers le Lobby de Paladium
				
				player.sendMessage("§8[§e§lDEBUG§8] §fSpawnListeners.java > TODO: Téléportation vers Lobby");
				
			} else if(item.getType().equals(Material.SKULL_ITEM)) {
				GuiManager.openGui(new ProfileGui(player));
			}
			
		}
		
	}
	

}
