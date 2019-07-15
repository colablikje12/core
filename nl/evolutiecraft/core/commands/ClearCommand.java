package nl.evolutiecraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class ClearCommand extends PlayerCommand{

	public ClearCommand() {
		super("clear");
		setDescription("Clear de chat");
	}

	@Override
	public void run (Player player, String[] args) {

		if (!player.hasPermission("ec.core.clear")) {
			Common.tell(player, "&fJe hebt de permission &cec.core.clear &fniet!");
			return;
		}

		for (int counter=1; counter<100; counter++) {
			Bukkit.broadcastMessage("");
		}
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', pre + "De chat is gecleared door een stafflid"));

	}

}
