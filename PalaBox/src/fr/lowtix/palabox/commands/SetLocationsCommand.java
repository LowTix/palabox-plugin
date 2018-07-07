package fr.lowtix.palabox.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.BasicMessages;
import fr.lowtix.palabox.enumerations.Locations;
import fr.lowtix.palabox.enumerations.Ranks;
import fr.lowtix.palabox.users.GameUser;

public class SetLocationsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player =(Player) sender;
			GameUser user = Main.getInstance().getGameUser(player);
			
			if(user.getRank().isEquals(Ranks.RESPONSABLE) || user.getRank().isBetter(Ranks.RESPONSABLE)) {
				
				if(args.length == 0 || (args.length >= 1 && args[0].equalsIgnoreCase("help"))) {
					player.sendMessage(BasicMessages.LINE.getMessage());
					player.sendMessage("§8❯ §7Commandes:");
					player.sendMessage("  §8• §b/location list §7§oliste des positions");
					player.sendMessage("  §8• §b/location set <nom> §7§oset une position");
					player.sendMessage("  §8• §b/location tp <nom> §7§otéléporte a la position");
					player.sendMessage(BasicMessages.LINE.getMessage());
					
					return true;
				} else if(args.length >= 1 && args[0].equalsIgnoreCase("list")) {
					
					player.sendMessage(BasicMessages.LINE.getMessage());
					player.sendMessage("§8❯ §7Liste des positions:");
					
					for(Locations locs : Locations.values()) {
						
						if(Main.getInstance().getLocationsConfiguration().locationExist(locs)) {
							player.sendMessage("  §8• §7ID: §f"+locs.name()+" §8(§aPlacé§8)");
						} else {
							player.sendMessage("  §8• §7ID: §f"+locs.name()+" §8(§cNon Placé§8)");
						}
						
					}
					
					player.sendMessage(BasicMessages.LINE.getMessage());
					return true;
				} else if(args.length == 2 && args[0].equalsIgnoreCase("set")) {
					
					String name = args[1];
					Locations locs = Locations.valueOf(name);
					
					if(locs == null) {
						player.sendMessage("§8[§4✕§8] §7La position n'est pas connue, faites: §e/location list§7.");
						return true;
					} else {
						player.sendMessage("§8[§2✔§8] §7La position §e"+ locs.name() +" §7a été définie ici.");
						Main.getInstance().getLocationsConfiguration().saveLocation(locs, player.getLocation());
						return true;
					}
					
				} else if(args.length == 2 && args[0].equalsIgnoreCase("tp")) {
					String name = args[1];
					Locations locs = Locations.valueOf(name);
					
					if(locs == null) {
						player.sendMessage("§8[§4✕§8] §7La position n'est pas connue, faites: §e/location list§7.");
						return true;
					} else {
						player.sendMessage("§8[§2✔§8] §7Téléportation vers §e"+ locs.name() +"§7...");
						player.teleport(Main.getInstance().getLocationsConfiguration().getSavedLocation(locs));
						return true;
					}
				}
				
			} else {
				
				player.sendMessage(BasicMessages.NOT_PERMISSION.getMessage());
				
			}
			
			
		}
		
		return true;
	}

}
