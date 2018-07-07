package fr.lowtix.palabox.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.BasicMessages;
import fr.lowtix.palabox.enumerations.Ranks;
import fr.lowtix.palabox.users.GameUser;

public class SetRankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if (sender instanceof Player) {

			Player player = (Player) sender;
			GameUser user = Main.getInstance().getGameUser(player);

			if (user.getRank().isEquals(Ranks.RESPONSABLE) || user.getRank().isBetter(Ranks.RESPONSABLE) || player.isOp()) {

				if (args.length == 0 || (args.length >= 1 && args[0].equalsIgnoreCase("help"))) {
					player.sendMessage(BasicMessages.LINE.getMessage());
					player.sendMessage("§8❯ §7Commandes:");
					player.sendMessage("  §8• §b/setrank list §7§oliste les rangs");
					player.sendMessage("  §8• §b/setrank <joueur> <nom> §7§oset un rang");
					player.sendMessage(BasicMessages.LINE.getMessage());

					return true;
				} else if (args.length == 1 && args[0].equalsIgnoreCase("list")) {

					player.sendMessage(BasicMessages.LINE.getMessage());
					player.sendMessage("§8❯ §7Liste des rangs:");

					for (Ranks ranks : Ranks.values()) {

						player.sendMessage("  §8• §7ID: §f" + ranks.name() + " §8(§e" + ranks.getPrefixColor() + ranks.getPrefix() + "§8)");

					}

					player.sendMessage(BasicMessages.LINE.getMessage());
					return true;

				} else if(args.length == 2 && Bukkit.getPlayer(args[0]) != null && Bukkit.getPlayer(args[0]).isOnline()){
					
					Player target = Bukkit.getPlayer(args[0]);
					GameUser targetUser = Main.getInstance().getGameUser(target);
					
					Ranks rank = Ranks.getRankFromString(args[1]);
					targetUser.setRank(rank);
					
					player.sendMessage("§8[§2✔§8] §7Le rang de §e"+target.getName()+" §7a été changé en §f"+rank.getPrefixColor() + rank.name()+"§7.");
					target.sendMessage("§8[§6§l!§8] §eVotre rang a été modifié. Reconnectez vous afin de l'appliquer !");
					return true;
				}

			}

		}

		return true;

	}
}
