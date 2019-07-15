package nl.evolutiecraft.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import nl.evolutiecraft.core.utils.Common;

public class PlaceEvent implements Listener{

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {

		final Player player = e.getPlayer();
		final String pre = "&f[&9EC&f] ";

		if (!player.hasPermission("ec.core.plaats")) {
			Common.tell(player, pre + "&cJe hebt de permission ec.core.plaats niet!");
			e.setCancelled(true);
		}


	}

}
