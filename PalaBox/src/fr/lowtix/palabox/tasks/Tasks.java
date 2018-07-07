package fr.lowtix.palabox.tasks;

import fr.lowtix.palabox.Main;

public class Tasks {

	public void init() {
		
		new RegionTask().runTaskTimerAsynchronously(Main.getInstance(), 20, 20);
		
	}

}
