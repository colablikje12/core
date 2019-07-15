package nl.evolutiecraft.core.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class TeleportCommand extends PlayerCommand{

	public TeleportCommand() {
		super ("teleport");
		setDescription("teleport een speler");
		setAliases(Arrays.asList("tp"));
	}

	@Override
	public void run(Player player, String[] args) {

		if (args.length == 0) {
			Common.tell(player, pre + "Fout, type /teleport [speler] <speler>");
			return;
		}

		if (args.length == 1) {

			if (!player.hasPermission("ec.core.teleport")) {
				Common.tell(player, "Je hebt de permission &cec.core.teleport &fniet!");
				return;
			}

			final Player speler = Bukkit.getPlayer(args[0]);

			if (speler == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline!");
				return;
			}


			final Location loc = speler.getLocation();
			player.teleport(loc);

			if (speler.hasPermission("ec.core.teleport.bericht")) {
				Common.tell(speler, "&6" + player.getName() + "&f is naar je geteleporteerd!");
			}
			Common.tell(player, pre + "Je bent naar &6" + speler.getName() + " &fGeteleporteerd!");

		}

		if (!player.hasPermission("ec.core.teleport.ander")) {
			Common.tell(player, "Je hebt de permission &cec.core.teleport &fniet!");
			return;
		}

		if (args.length == 2) {
			final Player speler1 = Bukkit.getPlayer(args[0]);
			final Player speler2 = Bukkit.getPlayer(args[1]);

			if (speler1 == null || speler2 == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline!");
				return;
			}

			final Location loc = speler2.getLocation();
			speler1.teleport(loc);
		}

		if (args.length == 3) {


		}

	}

}
