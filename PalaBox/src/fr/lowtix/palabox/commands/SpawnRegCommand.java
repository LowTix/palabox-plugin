package fr.lowtix.palabox.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lowtix.palabox.Main;

public class SpawnRegCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if (sender instanceof Player) {

			Player player = (Player) sender;
			
			if(Main.getInstance().getSpawn_region().getRegion().inCuboid(player.getLocation())) {
				player.sendMessage("OUI");
			} else {
				player.sendMessage("NON");
			}
			
		}
		return true;
	}
}