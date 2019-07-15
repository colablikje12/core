package nl.evolutiecraft.core.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class BroadcastCommand extends PlayerCommand{

	public BroadcastCommand() {
		super("broadcast");
		setDescription("Stuur een bericht door de hele server.");
		setAliases(Arrays.asList("bc"));
	}

	@Override
	public void run (Player player, String[] args) {

		if (!player.hasPermission("ec.core.broadcast")) {
			Common.tell(player, pre + "Je hebt de permission &cec.core.broadcast &fniet!");
			return;
		}

		if (args.length == 0) {
			Common.tell(player, pre + "");
			return;
		}

		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			builder.append(args[i] + " ");
		}

		final String msg = builder.toString();

		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', pre + msg));

	}

}
