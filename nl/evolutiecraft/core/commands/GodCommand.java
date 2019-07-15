package nl.evolutiecraft.core.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import nl.evolutiecraft.core.utils.Common;

public class GodCommand extends PlayerCommand implements Listener{

	private static List<Player> GOD = new ArrayList<>();

	public GodCommand() {
		super("god");
		setDescription("Godmode, toggle god voor jezelf of andere.");
	}

	@Override
	protected void run(Player player, String[] args) {

		if (args.length == 0) {
			if (!player.hasPermission("ec.core.god")) {
				Common.tell(player, pre + "Je hebt de permission &cec.core.god &fniet!");
				return;
			}

			if (GOD.contains(player)) {
				Common.tell(player, pre + "Je hebt godmode &cuit &fgezet.");
				GOD.remove(player);
				player.setHealth(20);
				player.setFoodLevel(20);
			} else {
				Common.tell(player, pre + "Je hebt godmode &aaan &fgezet.");
				GOD.add(player);
				player.setHealth(20);
				player.setFoodLevel(20);
			}
		}

		if (args.length == 1) {
			final Player p = Bukkit.getPlayer(args[0]);
			if (p == null) {
				Common.tell(player, pre + "Deze speler is &cniet &fonline.");
				return;
			}

			if (!player.hasPermission("ec.core.god.ander")) {
				Common.tell(player, pre + "Je hebt de permission &cec.core.god.ander &fniet!");
				return;
			}

			if (GOD.contains(p)) {
				GOD.remove(p);
				p.setHealth(20);
				p.setFoodLevel(20);

				Common.tell(p, pre + "Godmode is &cuit &fgezet door &6" + player.getName());
				Common.tell(player, pre + "Je hebt godmode &cuit &fgezet bij &6" + p.getName());
			} else {
				GOD.add(p);
				player.setHealth(20);
				player.setFoodLevel(20);

				Common.tell(p, pre + "Godmode is &aaan &fgezet door &6" + player.getName());
				Common.tell(player, pre + "Je hebt gemode &aaan &fgezet bij &6" + p.getName());
			}


		}

	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && GOD.contains(e.getEntity())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player && GOD.contains(e.getEntity())) {
			e.setCancelled(true);
		}
	}


}
