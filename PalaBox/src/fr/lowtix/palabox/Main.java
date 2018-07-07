package fr.lowtix.palabox;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.lowtix.palabox.commands.Commands;
import fr.lowtix.palabox.configuration.ConfigurationManager;
import fr.lowtix.palabox.configuration.LocationsConfig;
import fr.lowtix.palabox.enumerations.Locations;
import fr.lowtix.palabox.listeners.Listeners;
import fr.lowtix.palabox.managers.InventoryManager;
import fr.lowtix.palabox.managers.SpawnRegion;
import fr.lowtix.palabox.tasks.Tasks;
import fr.lowtix.palabox.users.GameUser;
import fr.lowtix.palabox.users.storage.SQLProfile;

public class Main extends JavaPlugin {
	
	/*
	 * Plugin name: PalaBox
	 * Author: LowTix_
	 * At: 02/07/2018
	 */
	
	private static Main instance;
	
	private HashMap<UUID, GameUser> users = new HashMap<UUID, GameUser>();
	
	private ConfigurationManager configurationManager;
	private LocationsConfig locationsConfiguration;
	private Listeners listeners;
	private SpawnRegion spawn_region;
	private InventoryManager inventoryManager;
	
	private SQLProfile sqlProfile;
	
	@Override
	public void onEnable() {
		instance = this;
		
		configurationManager = new ConfigurationManager();
		getConfigurationManager().init();
		
		locationsConfiguration = new LocationsConfig();
		
		listeners = new Listeners();
		listeners.init();
		
		sqlProfile = new SQLProfile();
		sqlProfile.createTable();
		
		inventoryManager = new InventoryManager();
		
		new Commands().init();
		new Tasks().init();
		
		spawn_region = new SpawnRegion(Locations.REGION_SPAWN_MAXIMUM, Locations.REGION_SPAWN_MINIMUM);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public ConfigurationManager getConfigurationManager() {
		return configurationManager;
	}
	
	public LocationsConfig getLocationsConfiguration() {
		return locationsConfiguration;
	}
	
	public Listeners getListeners() {
		return listeners;
	}
	
	public SpawnRegion getSpawn_region() {
		return spawn_region;
	}
	
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	
	/*
	 * SQL STORAGE
	 */
	
	public SQLProfile getSQLProfile() {
		return sqlProfile;
	}
	
	/*
	 * USERS
	 */
	
	public boolean containsGameUser(UUID uuid) {
		return this.users.containsKey(uuid);
	}
	
	public void addGameUser(GameUser user) {
		this.users.put(user.getPlayer().getUniqueId(), user);
	}
	
	public void deleteGameUser(UUID uuid) {
		if(containsGameUser(uuid)) {
			this.users.remove(uuid);
		}
	}
	
	public GameUser getGameUser(UUID uuid) {
		if(containsGameUser(uuid)) {
			return this.users.get(uuid);
		}
		
		return new GameUser(Bukkit.getPlayer(uuid));
	}
	
	public GameUser getGameUser(Player player) {
		return getGameUser(player.getUniqueId());
	}
	
	public HashMap<UUID, GameUser> getGameUsers(){
		return this.users;
	}

}
