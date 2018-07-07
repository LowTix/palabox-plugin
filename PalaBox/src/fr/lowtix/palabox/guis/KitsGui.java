package fr.lowtix.palabox.guis;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import fr.lowtix.palabox.Main;
import fr.lowtix.palabox.enumerations.BoxItems;
import fr.lowtix.palabox.enumerations.Kits;
import fr.lowtix.palabox.users.GameUser;
import fr.lowtix.palabox.utils.Gui;
import fr.lowtix.palabox.utils.GuiManager;
import fr.lowtix.palabox.utils.ItemBuilder;

public class KitsGui extends Gui {

	private GameUser user;
	
	public KitsGui(Player player) {
		super("§eChoix de classe:", 3, player);
		user = Main.getInstance().getGameUser(getPlayer());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void drawScreen() {
		
		setItem(4, new ItemBuilder(Material.PAPER).setName("§7Vous êtes actuellement en §a" + user.getKit().getName()).build());
		
		setItem(11, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_CHESTPLATE.getId())).setName("§7§oClasse §a§l" + Kits.DEFENSE.getName()).build());
		setItem(15, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_SWORD.getId())).setName("§7§oClasse §a§l" + Kits.OFFENSE.getName()).build());
		
	}
	
	@Override
	public void onClick(int position, ItemStack item, ClickType click) {
		
		if(position == 11) {
			
			GuiManager.closePlayer(player);
			user.setKit(Kits.DEFENSE);
			
			player.sendMessage("§8[§a§l?§8] §7Votre classe a été changée. Vous êtes maintenant en §a"+Kits.DEFENSE.getName()+"§7.");
			
		} else if(position == 15) {
			
			GuiManager.closePlayer(player);
			user.setKit(Kits.OFFENSE);
			
			player.sendMessage("§8[§a§l?§8] §7Votre classe a été changée. Vous êtes maintenant en §a"+Kits.OFFENSE.getName()+"§7.");
			
		}
		
	}

}
