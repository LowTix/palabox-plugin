package fr.lowtix.palabox.users;

public class GameStatistics {
	
	private GameUser user;
	
	private int kills;
	private int deaths;
	private int maxStreak;
	private int currentStreak;
	
	private int souls;
	
	private int level;
	private double exp;
	
	public GameStatistics(GameUser user) {
		this.user = user;
		
		this.kills = 0;
		this.deaths = 0;
		this.maxStreak = 0;
		this.currentStreak = 0;
		
		this.souls = 0;
		
		this.level = 1;
		this.exp = 0;
	}

	public GameUser getUser() {
		return user;
	}

	public void setUser(GameUser user) {
		this.user = user;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getMaxStreak() {
		return maxStreak;
	}

	public void setMaxStreak(int maxStreak) {
		this.maxStreak = maxStreak;
	}

	public int getCurrentStreak() {
		return currentStreak;
	}

	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
	}

	public int getSouls() {
		return souls;
	}

	public void setSouls(int souls) {
		this.souls = souls;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}
	
}
