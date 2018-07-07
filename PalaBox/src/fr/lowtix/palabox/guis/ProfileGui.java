package fr.lowtix.palabox.guis;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.BoxItems;
import fr.lowtix.palabox.users.GameStatistics;
import fr.lowtix.palabox.users.GameUser;
import fr.lowtix.palabox.utils.Gui;
import fr.lowtix.palabox.utils.ItemBuilder;

public class ProfileGui extends Gui {

	private GameUser user;
	
	public ProfileGui(Player player) {
		super("§eVotre profil:", 4, player);
		user = Main.getInstance().getGameUser(getPlayer());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void drawScreen() {
		
		setItem(13, new ItemBuilder(Material.SKULL_ITEM).setName("§7Profil de §e" + user.getKit().getName()).setLore(new String[] {"§7Grade: §f"+user.getRank().getPrefix()}).build());
		
		GameStatistics stats = user.getStats();
		
		setItem(19, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_SWORD.getId())).setName("§7Joueur(s) éliminé(s): §a" + stats.getKills()).build());
		setItem(21, new ItemBuilder(Material.BAKED_POTATO).setName("§7Mort(s): §c" + stats.getDeaths()).build());
		setItem(23, new ItemBuilder(Material.LEASH).setName("§7Meilleur KillStreak: §b" + stats.getMaxStreak()).build());
		setItem(25, new ItemBuilder(Material.EXP_BOTTLE).setName("§7Niveau/Exp: §e" + stats.getLevel() +"§f/§b"+stats.getExp()).build());
		
	}

}
