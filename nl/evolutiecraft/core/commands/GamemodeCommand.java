package nl.evolutiecraft.core.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class GamemodeCommand extends PlayerCommand{

	public GamemodeCommand() {
		super("gamemode");
		setDescription("Gamemode, wijzig je eigen gamemode of die van andere spelers.");
		setAliases(Arrays.asList("gm"));
	}

	@Override
	protected void run(Player player, String[] args) {

		if (args.length == 0) {
			Common.tell(player, pre + "Er is iets niet goed gegaan, probeer:");
			Common.tell(player, pre + "&c/gm <creative; survival; advanture; spectator> [speler]");
		}

		// eigen gamemode wisselen
		if (args.length == 1) {
			// switch naar survival
			if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {

				// perm
				if (!player.hasPermission("ec.core.gamemode.survival")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.survival &fniet!");
					return;
				}


				// survival check
				if (player.getGameMode() == GameMode.SURVIVAL) {
					Common.tell(player, pre + "Je staat al in gamemode &csurvival&f.");
					return;
				}


				player.setGameMode(GameMode.SURVIVAL);
				Common.tell(player, pre + "Je gamemode is veranderd naar &asurvival&f.");

			}

			// switch naar creative
			if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {

				//perm
				if (!player.hasPermission("ec.core.gamemode.creative")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.creative &fniet!");
					return;
				}


				// creative check
				if (player.getGameMode() == GameMode.CREATIVE) {
					Common.tell(player, pre + "Je staat al in gamemode &ccreative&f.");
					return;
				}


				player.setGameMode(GameMode.CREATIVE);
				Common.tell(player, pre + "Je gamemode is veranderd naar &acreative&f.");

			}

			// switch naar adventure
			if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {

				// perm check
				if (!player.hasPermission("ec.core.gamemode.adventure")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.adventure &fniet!");
					return;
				}

				// adventure check
				if (player.getGameMode() == GameMode.ADVENTURE) {
					Common.tell(player, pre + "Je staat al in gamemode &cadventure&f.");
					return;
				}

				player.setGameMode(GameMode.ADVENTURE);
				Common.tell(player, pre + "Je gamemode is veranderd naar &aadventure&f.");

			}

			// switch naar spectator
			if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {

				// perm check
				if (!player.hasPermission("ec.core.gamemode.spectator")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.spectator &fniet!");
					return;
				}

				// specator check
				if (player.getGameMode() == GameMode.SPECTATOR) {
					Common.tell(player, pre + "Je staat al in gamemode &cspectator&f.");
					return;
				}

				player.setGameMode(GameMode.SPECTATOR);
				Common.tell(player, pre + "fJe gamemode is veranderd naar &aspecator&f.");

			}

		}


		// andersmans gamemode wisselen
		if (args.length == 2 ) {

			final Player p = Bukkit.getServer().getPlayer(args[1]);
			if (p == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline!");
				return;
			}

			// switch naar survival
			if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {

				// perm check
				if (!player.hasPermission("ec.core.gamemode.survival.ander")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.survival.ander &fniet!");
					return;
				}

				// surivival check
				if (p.getGameMode() == GameMode.SURVIVAL) {
					Common.tell(player, pre + "&6" + p.getName() + " &fstaat al in gamemode &csurvival&f.");
					return;
				}

				p.setGameMode(GameMode.SURVIVAL);
				Common.tell(player, pre + "De gamemode van &6" + p.getName() + " &fis gewijzigd naar &asurvival&f.");
				Common.tell(p, pre + "Je gamemode is gewijzigd naar &asurvival &fdoor &6" + player.getName() + "&f.");
			}

			// switch naar creative
			if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {

				// perm check
				if (!player.hasPermission("ec.core.gamemode.creative.ander")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.creative.ander &fniet!");
					return;
				}

				// surivival check
				if (p.getGameMode() == GameMode.CREATIVE) {
					Common.tell(player, pre + "&6" + p.getName() + " &fstaat al in gamemode &ccreative&f.");
					return;
				}

				p.setGameMode(GameMode.CREATIVE);
				Common.tell(player, pre + "De gamemode van &6" + p.getName() + " &fis gewijzigd naar &acreative&f.");
				Common.tell(p, pre + "Je gamemode is gewijzigd naar &acreative &fdoor &6" + player.getName() + "&f.");
			}

			// switch naar adventure
			if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {

				// perm check
				if (!player.hasPermission("ec.core.gamemode.adventure.ander")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.adventure.ander &fniet!");
					return;
				}

				// surivival check
				if (p.getGameMode() == GameMode.ADVENTURE) {
					Common.tell(player, pre + "&6" + p.getName() + " &fstaat al in gamemode &cadventure&f.");
					return;
				}

				p.setGameMode(GameMode.ADVENTURE);
				Common.tell(player, pre + "De gamemode van &6" + p.getName() + " &fis gewijzigd naar &aadventure&f.");
				Common.tell(p, pre + "Je gamemode is gewijzigd naar &aadventure &fdoor &6" + player.getName() + "&f.");
			}

			// switch naar spectator
			if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {

				// perm check
				if (!player.hasPermission("ec.core.gamemode.spectator.ander")) {
					Common.tell(player, pre + "Je hebt de permission &cec.core.gamemode.spectator.ander &fniet!");
					return;
				}

				// surivival check
				if (p.getGameMode() == GameMode.SPECTATOR) {
					Common.tell(player, pre + "&6" + p.getName() + " staat al in gamemode &cspectator&f.");
					return;
				}

				p.setGameMode(GameMode.SPECTATOR);
				Common.tell(player, pre + "De gamemode van &6" + p.getName() + " &fis gewijzigd naar &aspectator&f.");
				Common.tell(p, pre + "Je gamemode is gewijzigd naar &aspectator &fdoor &6" + player.getName() + "&f.");
			}



		}



	}

}
