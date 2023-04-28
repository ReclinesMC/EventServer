package me.reclines.eventplugin.commands;

import me.reclines.eventplugin.EventPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Build implements CommandExecutor {
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		boolean build;
		if (!(sender instanceof Player)) {
			sender.sendPlainMessage("You must be a player to use this command.");
			return true;
		}
		if (args.length == 0) {
			sender.sendPlainMessage(ChatColor.RED + "Usage: /build on/off");
			return true;
		}
		build = args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("off");
		if (!build) {
			sender.sendPlainMessage(ChatColor.RED + "Usage: /build on/off");
			return true;
		}
		Player player = (Player) sender;
		player.performCommand("rg flag __global__ passthrough " + EventPlugin.getState(args[0]));
		return true;
	}
}