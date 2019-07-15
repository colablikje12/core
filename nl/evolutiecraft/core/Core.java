package nl.evolutiecraft.core;

import org.bukkit.plugin.java.JavaPlugin;

import nl.evolutiecraft.core.commands.BroadcastCommand;
import nl.evolutiecraft.core.commands.ClearCommand;
import nl.evolutiecraft.core.commands.FeedCommand;
import nl.evolutiecraft.core.commands.FlyCommand;
import nl.evolutiecraft.core.commands.GamemodeCommand;
import nl.evolutiecraft.core.commands.GodCommand;
import nl.evolutiecraft.core.commands.HealCommand;
import nl.evolutiecraft.core.commands.RenameCommand;
import nl.evolutiecraft.core.commands.TeleportCommand;
import nl.evolutiecraft.core.events.BreakEvent;
import nl.evolutiecraft.core.events.PlaceEvent;
import nl.evolutiecraft.core.utils.Common;

public class Core extends JavaPlugin{

	private static Core instance;

    @Override
	public void onEnable() {

    	instance = this;

    	//console shit
    	Common.log("[EC] De core plugin is aangezet!");
    	Common.log("[EC] Deze plugin is gemaakt door colablikje12");

    	// commands
    	Common.registerCommand(new GamemodeCommand());
    	Common.registerCommand(new FlyCommand());
    	Common.registerCommand(new GodCommand());
    	Common.registerCommand(new HealCommand());
    	Common.registerCommand(new FeedCommand());
    	Common.registerCommand(new ClearCommand());
    	Common.registerCommand(new RenameCommand());
    	Common.registerCommand(new BroadcastCommand());
    	Common.registerCommand(new TeleportCommand());

    	// Events
    	getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
    	getServer().getPluginManager().registerEvents(new BreakEvent(), this);
    	getServer().getPluginManager().registerEvents(new GodCommand(), this);
    }

    @Override
	public void onDisable() {

    	instance = null;

    }

	public static Core getInstance() {
		return instance;
	}
}
