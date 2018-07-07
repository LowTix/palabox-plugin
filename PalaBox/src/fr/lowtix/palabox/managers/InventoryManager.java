package fr.lowtix.palabox.managers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import fr.lowtix.palabox.enumerations.BoxItems;
import fr.lowtix.palabox.enumerations.Kits;
import fr.lowtix.palabox.utils.ItemBuilder;

public class InventoryManager {
	
	public void clearPlayer(Player player) {
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		
		player.getActivePotionEffects().clear();
		
	}
	
	public void giveSpawnItems(PlayerInventory inv) {
		
		inv.setItem(0, new ItemBuilder(Material.SKULL_ITEM).setName("§e§lProfil §8• §7§oClic droit").build());
		inv.setItem(4, new ItemBuilder(Material.BOOK).setName("§e§lChanger sa classe §8• §7§oClic droit").build());
		inv.setItem(8, new ItemBuilder(Material.BED).setName("§c§lLobby Paladium §8• §7§oClic droit").build());
		
	}
	
	@SuppressWarnings("deprecation")
	public void giveArenaItems(PlayerInventory inv, Kits kit) {
		
		if(kit.equals(Kits.DEFENSE)) {
			
			inv.setHelmet(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_HELMET.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setChestplate(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_CHESTPLATE.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setLeggings(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_LEGGINGS.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setBoots(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_BOOTS.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchant(Enchantment.DURABILITY, 4).build());
			
			inv.setItem(0, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_SWORD.getId())).addEnchant(Enchantment.DAMAGE_ALL, 1).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setItem(1, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_APPLE.getId())).setAmount(4).build());
			
		} else if(kit.equals(Kits.OFFENSE)) {
			
			inv.setHelmet(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_HELMET.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setChestplate(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_CHESTPLATE.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setLeggings(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_LEGGINGS.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setBoots(new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_BOOTS.getId())).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchant(Enchantment.DURABILITY, 4).build());
			
			inv.setItem(0, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_SWORD.getId())).addEnchant(Enchantment.DAMAGE_ALL, 2).addEnchant(Enchantment.DURABILITY, 4).build());
			inv.setItem(1, new ItemBuilder(Material.getMaterial(BoxItems.URANIUM_APPLE.getId())).setAmount(4).build());
		}
		
	}

}
