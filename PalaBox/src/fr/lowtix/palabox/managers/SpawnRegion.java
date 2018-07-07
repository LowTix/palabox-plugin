package fr.lowtix.palabox.managers;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.configuration.LocationsConfig;
import fr.lowtix.palabox.enumerations.Locations;
import fr.lowtix.palabox.utils.Cuboid;

public class SpawnRegion {
	
	private Cuboid region;
	
	public SpawnRegion(Locations path_max, Locations path_min) {
		
		LocationsConfig config = Main.getInstance().getLocationsConfiguration();
		
		if(config.locationExist(path_max) && config.locationExist(path_min) && config.getSavedLocation(path_min) != null && config.getSavedLocation(path_max) != null) {
			
			System.out.println("REGION: YES");
			
			region = new Cuboid(config.getSavedLocation(path_min), config.getSavedLocation(path_max));
			
		} else {
			
			System.out.println("REGION: NO");
			
		}
		
	}
	
	public Cuboid getRegion() {
		return region;
	}

}
