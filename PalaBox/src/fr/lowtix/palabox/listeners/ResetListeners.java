package fr.lowtix.palabox.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import fr.lowtix.palabox.Main;

public class ResetListeners implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		
		if(event.getEntity() instanceof Player) {
			if(!((Player)event.getEntity()).getGameMode().equals(GameMode.SURVIVAL)) {
				event.setCancelled(true);
			}
		}
		
		if(event.getCause().equals(DamageCause.FIRE) || event.getCause().equals(DamageCause.FALL) || Main.getInstance().getSpawn_region().getRegion().inCuboid(event.getEntity().getLocation())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(PlayerDropItemEvent event) {
		
		if(Main.getInstance().getSpawn_region().getRegion().inCuboid(event.getPlayer().getLocation())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
}
