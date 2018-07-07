package fr.lowtix.palabox.configuration;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.lowtix.palabox.Main;

public class ConfigurationManager {

	private static File settingsFile;
	private static FileConfiguration settingsConfig;
	private File locationsFile;
	private FileConfiguration locationsConfig;

	public void init() {
		try {
			if (!Main.getInstance().getDataFolder().exists()) {
				Main.getInstance().getDataFolder().mkdir();
			}
			
			/*
			 * FICHIER DE PARAMETRES
			 */
			
			settingsFile = new File(Main.getInstance().getDataFolder().getPath() + "/settings.yml");
			if (!settingsFile.exists()) {
				Main.getInstance().saveResource("settings.yml", false);
			}
			settingsConfig = YamlConfiguration.loadConfiguration(settingsFile);
			
			/*
			 * FICHIER DES LOCATIONS
			 */
			
			locationsFile = new File(Main.getInstance().getDataFolder().getPath() + "/locations.yml");
			if(!locationsFile.exists()){
				locationsFile.createNewFile();
			}
			locationsConfig = YamlConfiguration.loadConfiguration(locationsFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FileConfiguration getSettingsConfig() {
		return settingsConfig;
	}
	
	public FileConfiguration getLocationsConfig(){
		return locationsConfig;
	}
	
	public void saveLocationConfig(){
		try {
			locationsConfig.save(locationsFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
