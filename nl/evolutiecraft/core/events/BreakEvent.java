package nl.evolutiecraft.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import nl.evolutiecraft.core.utils.Common;

public class BreakEvent implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {

		final Player player = e.getPlayer();
		final String pre = "&f[&9EC&f] ";

		if (!player.hasPermission("ec.core.breek")) {
			Common.tell(player, pre + "&cJe hebt de permission ec.core.breek niet!");
			e.setCancelled(true);
		}


	}

}
