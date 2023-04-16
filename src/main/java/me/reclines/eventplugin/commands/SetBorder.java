package me.reclines.eventplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetBorder
		implements CommandExecutor {
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		boolean borderRadius;
		if (!(sender instanceof Player)) {
			sender.sendPlainMessage("You must be a player to use this command.");
			return true;
		}
		if (args.length == 0) {
			sender.sendPlainMessage(ChatColor.RED + "Usage: /setborder <radius> [seconds]");
			return true;
		}
		int seconds = 0;
		if (args.length == 2) {
			if (args[1].matches("[0-9]+")) {
				seconds = Integer.parseInt(args[1]);
			} else {
				sender.sendPlainMessage(ChatColor.RED + "Usage: /setborder <radius> [seconds]");
				return true;
			}
		}
		borderRadius = args[0].matches("[0-9]+");
		if (!(borderRadius)) {
			sender.sendPlainMessage(ChatColor.RED + "Usage: /setborder <radius> [seconds]");
			return true;
		}
		Player player = (Player) sender;
		player.getWorld().getWorldBorder().setSize(Integer.parseInt(args[0]), seconds);
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format("&aSet the world border radius to %s%s", args[0], args.length == 2 ? String.format(" in %s seconds.", seconds) : ".")));
		return true;
	}
}