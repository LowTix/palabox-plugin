package fr.lowtix.palabox.enumerations;

import org.bukkit.ChatColor;

public enum Ranks {
	
	ADMINISTRATOR("Administrateur", ChatColor.RED, ChatColor.WHITE, 999),
	RESPONSABLE("Administrateur", ChatColor.RED, ChatColor.WHITE, 998),
	MODERATOR("Modérateur", ChatColor.GOLD, ChatColor.WHITE, 20),
	PLAYER("", ChatColor.GRAY, ChatColor.WHITE, 10);
	
	private String prefix;
	private ChatColor prefixColor, chatColor;
	private int power;
	
	private Ranks(String prefix, ChatColor prefixColor, ChatColor chatColor, int power) {
		this.prefix = prefix;
		this.prefixColor = prefixColor;
		this.chatColor = chatColor;
		this.power = power;
	}

	public String getPrefix() {
		return prefix;
	}

	public ChatColor getPrefixColor() {
		return prefixColor;
	}

	public ChatColor getChatColor() {
		return chatColor;
	}

	public int getPower() {
		return power;
	}
	
	public boolean isEquals(Ranks rank) {
		return getPower() == rank.getPower();
	}
	
	public boolean isBetter(Ranks rank) {
		return getPower() > rank.getPower();
	}
	
	public boolean isLower(Ranks rank) {
		return getPower() < rank.getPower();
	}
	
	public static Ranks getRankFromString(String s) {
		
		Ranks rank = PLAYER;
		
		for(Ranks ranks: values()) {
			if(ranks.name().equals(s)) {
				rank = ranks;
				break;
			}
		}
		
		return rank;
		
	}
	
}
