package fr.lowtix.palabox.users;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.Kits;
import fr.lowtix.palabox.enumerations.Ranks;
import fr.lowtix.palabox.events.UserJoinEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class GameUser {
	
	private Player player;
	private boolean inSpawn;
	private PermissionUser pexUser;
	
	private Ranks rank;
	
	private GameStatistics stats;
	private Kits kit;

	public GameUser(Player player) {
		this.player = player;
		this.inSpawn = true;
		this.pexUser = PermissionsEx.getUser(player);
		this.stats = new GameStatistics(this);
		
		this.rank = Ranks.PLAYER;
		this.kit = Kits.DEFENSE;
		
		loadUser();
		
		Main.getInstance().addGameUser(this);
		Bukkit.getPluginManager().callEvent(new UserJoinEvent(this));
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isInSpawn() {
		return inSpawn;
	}

	public void setInSpawn(boolean inSpawn) {
		this.inSpawn = inSpawn;
	}

	public PermissionUser getPexUser() {
		return pexUser;
	}

	public void setPexUser(PermissionUser pexUser) {
		this.pexUser = pexUser;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}

	public GameStatistics getStats() {
		return stats;
	}

	public void setStats(GameStatistics stats) {
		this.stats = stats;
	}
	
	public Kits getKit() {
		return kit;
	}

	public void setKit(Kits kit) {
		this.kit = kit;
	}

	public void loadUser() {
		Main.getInstance().getSQLProfile().loadGameUser(this);
	}

	public void saveUser() {
		Main.getInstance().getSQLProfile().saveGameUser(this);
	}
	
	public void deleteUser() {
		saveUser();
		Main.getInstance().deleteGameUser(getPlayer().getUniqueId());
	}
	
}
