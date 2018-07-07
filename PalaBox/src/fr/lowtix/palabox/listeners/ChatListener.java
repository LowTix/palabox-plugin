package fr.lowtix.palabox.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.users.GameUser;

public class ChatListener implements Listener {
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		GameUser user = Main.getInstance().getGameUser(player);
		
		if(!event.isCancelled()) {
			event.setCancelled(true);
			
			Bukkit.broadcastMessage(user.getRank().getPrefixColor() + user.getRank().getPrefix() + " " + player.getName() + " §8» "+user.getRank().getChatColor() + event.getMessage());
			
		}
		
	}

}
