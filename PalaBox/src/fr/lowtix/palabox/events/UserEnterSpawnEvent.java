package fr.lowtix.palabox.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import fr.lowtix.palabox.users.GameUser;

public class UserEnterSpawnEvent extends Event {

	public static final HandlerList handlers = new HandlerList();
	
	private GameUser user;
	
	public UserEnterSpawnEvent(GameUser user) {
		this.user = user;
	}
	
	public GameUser getUser() {
		return user;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}

}
