package fr.lowtix.palabox.users.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.lowtix.palabox.enumerations.Ranks;
import fr.lowtix.palabox.users.GameStatistics;
import fr.lowtix.palabox.users.GameUser;
import fr.lowtix.palabox.utils.MySQL;

public class SQLProfile {

	private final String TABLE_NAME = "users";
	private final String COLUMN_ID = "uuid";
	private final String COLUMN_RANK = "rank";
	private final String COLUMN_SOULS = "souls";
	private final String COLUMN_LEVEL = "level";
	private final String COLUMN_EXPERIENCE = "experience";
	private final String COLUMN_KILLS = "kills";
	private final String COLUMN_DEATHS = "deaths";
	private final String COLUMN_MAX_KS = "max_ks";
	
	public void createTable() {
		MySQL.prepareStatement("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+COLUMN_ID+" VARCHAR(50), "+COLUMN_RANK+" VARCHAR(50), "+COLUMN_SOULS+" INT(50), "+COLUMN_LEVEL+" INT(4), "+COLUMN_EXPERIENCE+" DECIMAL(65), "+COLUMN_KILLS+" INT(25), "+COLUMN_DEATHS+" INT(25), "+COLUMN_MAX_KS+" INT(25))");
	}
	
	public void saveGameUser(GameUser user) {
		MySQL.connect();
		
		try {
			
			if(MySQL.contains(TABLE_NAME, COLUMN_ID, user.getPlayer().getUniqueId().toString(), false, false)){
				
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE "+TABLE_NAME+" SET "+COLUMN_RANK+" = ?, "+COLUMN_SOULS+" = ?, "+COLUMN_LEVEL+" = ?, "+COLUMN_EXPERIENCE+" = ?, "+COLUMN_KILLS+" = ?, "+COLUMN_DEATHS+" = ?, "+COLUMN_MAX_KS+" = ? WHERE "+COLUMN_ID+" = ?");
				
				GameStatistics stats = user.getStats();
				
				ps.setString(1, user.getRank().name());
				ps.setInt(2, stats.getSouls());
				ps.setInt(3, stats.getLevel());
				ps.setDouble(4, stats.getExp());
				ps.setInt(5, stats.getKills());
				ps.setInt(6, stats.getDeaths());
				ps.setInt(7, stats.getMaxStreak());
				
				ps.setString(8, user.getPlayer().getUniqueId().toString());
				
				ps.execute();
				ps.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQL.disconnect();
		}
	}
	
	public void loadGameUser(GameUser user) {
		MySQL.connect();
		try {
			
			if(!MySQL.contains(TABLE_NAME, COLUMN_ID, user.getPlayer().getUniqueId().toString(), false, false)){
				
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO "+TABLE_NAME+" values(?, ?, ?, ?, ?, ?, ?, ?)");
				
				ps.setString(1, user.getPlayer().getUniqueId().toString());
				ps.setString(2, user.getRank().name());
				ps.setInt(3, user.getStats().getSouls());
				ps.setInt(4, user.getStats().getLevel());
				ps.setDouble(5, user.getStats().getExp());
				ps.setInt(6, user.getStats().getKills());
				ps.setInt(7, user.getStats().getDeaths());
				ps.setInt(8, user.getStats().getMaxStreak());
				
				ps.execute();
				ps.close();
			}
			
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+" = ?");
			ps.setString(1, user.getPlayer().getUniqueId().toString());
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				
				Ranks rank = Ranks.getRankFromString(result.getString(COLUMN_RANK));
				int souls = result.getInt(COLUMN_SOULS);
				int level = result.getInt(COLUMN_LEVEL);
				double experience = result.getDouble(COLUMN_EXPERIENCE);
				int kills = result.getInt(COLUMN_KILLS);
				int deaths = result.getInt(COLUMN_DEATHS);
				int maxKS = result.getInt(COLUMN_MAX_KS);
				
				GameStatistics stats = user.getStats();
				
				user.setRank(rank);
				stats.setSouls(souls);
				stats.setLevel(level);
				stats.setExp(experience);
				stats.setKills(kills);
				stats.setDeaths(deaths);
				stats.setMaxStreak(maxKS);
				
			}
			
			result.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQL.disconnect();
		}
	}
	
	
	
}
