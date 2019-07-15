package nl.evolutiecraft.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand extends Command {

	public String pre = "&f[&9EC&f] ";

	protected PlayerCommand(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {

		run((Player) sender, args);
		return true;
	}

	protected abstract void run(Player player, String[] args);

}