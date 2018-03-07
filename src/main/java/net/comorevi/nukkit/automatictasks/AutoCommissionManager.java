package net.comorevi.nukkit.automatictasks;

import cn.nukkit.Player;
import net.comorevi.moneyapi.MoneySAPI;

import java.util.ArrayList;

public class AutoCommissionManager {

	private AutomaticTasks automaticTasks;
	private MoneySAPI moneySAPI;
	
	public AutoCommissionManager(AutomaticTasks plugin) {
		this.automaticTasks = plugin;
		this.moneySAPI = new MoneySAPI();
	}
	
	public void ManageCommission() {
		if(!isLastDayOfTheMonth()) return;
		
		ArrayList<String> playerList = (ArrayList<String>) moneySAPI.getSQL().getPlayerListHoldOverCertainAmount(1000);
		if(playerList != null) {
			playerList.forEach(
					s -> {
						Player p = automaticTasks.getServer().getPlayer(s);
						int playerMoney = moneySAPI.getMoney(p);
						moneySAPI.reduceMoney(p.getName(), (int) (playerMoney * 0.25));
					}
			);
		}
	}
	
	public boolean isLastDayOfTheMonth() {
		int dayOfTheMonth = automaticTasks.getTime().getDayOfTheMonth();
		int lastDayOfTheMonth = automaticTasks.getTime().getLastDayOfMonth();
		
		if(dayOfTheMonth == lastDayOfTheMonth) return true;
		return false;
	}
}
