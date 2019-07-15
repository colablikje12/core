package nl.evolutiecraft.core.commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nl.evolutiecraft.core.utils.Common;

public class RenameCommand extends PlayerCommand{

	public RenameCommand() {
		super("rename");
		setDescription("Rename het item wat je in je hand hebt.");
	}

	@Override
	protected void run(Player player, String[] args) {

		if (!player.hasPermission("ec.core.rename")) {
			Common.tell(player, pre + "Je hebt de permission &cec.core.rename &fniet!");
			return;
		}

		if (args.length == 0) {
			Common.tell(player, pre + "Type: &c/rename [naam]");
			return;
		}

		final ItemStack i = player.getInventory().getItemInMainHand();
		final ItemMeta meta = i.getItemMeta();

		final StringBuilder builder = new StringBuilder();
		for (int bu = 0; bu < args.length; bu++) {
			builder.append(args[bu] + " ");
		}

		final String name = builder.toString();
		final String naam = name.replace("&", "§");

		meta.setDisplayName(naam);
		i.setItemMeta(meta);

		Common.tell(player, pre + "Het item in je hand heeft nu de naam " + naam);

	}

}
