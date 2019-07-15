package nl.evolutiecraft.core.commands;

import org.bukkit.entity.Player;

import nl.evolutiecraft.core.utils.Common;

public class CoreCommand extends PlayerCommand{

	public CoreCommand() {
		super ("core");
		setDescription("krijg de main core plugin");
	}


	@Override
	protected void run(Player player, String[] args) {
		Common.tell(player, "&9&m-----------------&r[Evolutiecraft]&9&m-----------------");
		Common.tell(player, "");

	}
}
