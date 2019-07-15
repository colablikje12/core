package nl.evolutiecraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class FlyCommand extends PlayerCommand {

	public FlyCommand() {
		super("fly");
		setDescription("Fly, toggle fly voor jezelf of iemand anders.");
	}

	@Override
	protected void run(Player player, String[] args) {

		if (args.length == 0) {
			if (!player.hasPermission("ec.core.fly")) {
				Common.tell(player, pre + "Je hebt de permission &cec.core.fly &fniet!");
				return;
			}

			if (player.getAllowFlight() == true) {
				player.setAllowFlight(false);
				Common.tell(player, pre + "&fJe fly mode is &cuit &fgezet.");
			} else if (player.getAllowFlight() == false) {
				player.setAllowFlight(true);
				Common.tell(player, pre + "Je fly mode is &aan &fgezet.");
			} else {
				Common.tell(player, pre + "&fEr is iets &4niet &fgoed gegaan, contacteer een &cstafflid&f!");
			}

		}

		if (args.length == 1) {

			if (!player.hasPermission("ec.core.fly.ander")) {
				Common.tell(player, pre + "Je hebt de permission &cec.core.fly.ander &fniet!");
				return;
			}

			final Player p = Bukkit.getServer().getPlayer(args[0]);
			if (p == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline.");
				return;
			}

			if (p.getAllowFlight() == true) {
				p.setAllowFlight(false);
				Common.tell(player, pre + "Je hebt fly mode &cuit &fgezet bij &6" + p.getName() + "&f.");
				Common.tell(p, pre + "Je fly mode is &cuit &fgezet door &6" + player.getName() + "&f.");
			} else if (p.getAllowFlight() == false) {
				p.setAllowFlight(true);
				Common.tell(player, pre + "&fJe hebt fly mode &aaan &fgezet bij &6" + p.getName() + "&f.");
				Common.tell(p, pre + "&aJe fly mode is aan gezet door " + player.getName() + ".");
			} else {
				Common.tell(player, pre + "&fEr is iets &4niet &fgoed gegaan, contacteer een &cstafflid!");
			}


		}

	}

}
