package nl.evolutiecraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class HealCommand extends PlayerCommand{

	public HealCommand() {
		super("heal");
		setDescription("Heal jezelf of andere weer.");
	}

	@Override
	protected void run(Player player, String[] args) {

		if (!player.hasPermission("ec.core.heal")) {
			Common.tell(player, pre + "Je hebt de permission &cec.core.heal &fniet!");
			return;
		}

		if (args.length == 0) {
			player.setHealth(20);
			player.setFoodLevel(20);
			Common.tell(player, pre + "Je bent weer helemaal gezond.");

		}

		final Player p = Bukkit.getPlayer(args[0]);

		if (args.length == 1) {

			if (!player.hasPermission("ec.core.heal.ander")) {
				Common.tell(player, pre + "Je hebt de permission &cec.core.heal &fniet!");
				return;
			}

			if (p == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline.");
				return;
			}

			p.setHealth(20);
			p.setFoodLevel(20);
			Common.tell(player, "Je bent weer helemaal gezond gemaakt door &6" + player.getName());
			Common.tell(player, "&fJe hebt &6" + p.getName() + " &fweer helemaal gezond gemaakt.");

		}

	}

}