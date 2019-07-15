package nl.evolutiecraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class FeedCommand extends PlayerCommand{

	public FeedCommand() {
		super("feed");
		setDescription("Geef jezelf weer al 100% voedsel.");
	}

	@Override
	protected void run(Player player, String[] args) {

		if (!player.hasPermission("ec.core.feed")) {
			Common.tell(player, pre + "Je hebt de permission &cec.core.feed &fniet!");
			return;
		}

		if (args.length == 0) {
			player.setHealth(20);
			player.setFoodLevel(20);
			Common.tell(player, pre + "Je buik is weer gevuld.");

		}

		final Player p = Bukkit.getPlayer(args[0]);

		if (args.length == 1) {

			if (!player.hasPermission("ec.core.feed.ander")) {
				Common.tell(player, pre + "Je hebt de permission &cec.core.feed.ander &fniet!");
				return;
			}

			if (p == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline.");
				return;
			}

			p.setHealth(20);
			p.setFoodLevel(20);
			Common.tell(player, "Je buik is weer gevuld door &6" + player.getName());
			Common.tell(player, "Je hebt de buik van &6" + p.getName() + " &fweer gevuld.");

		}

	}

}
