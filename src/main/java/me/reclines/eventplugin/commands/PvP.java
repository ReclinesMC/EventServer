package me.reclines.eventplugin.commands;

import me.reclines.eventplugin.EventPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PvP implements CommandExecutor {
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendPlainMessage("You must be a player to use this command.");
			return true;
		}
		if (args.length == 0) {
			sender.sendPlainMessage(ChatColor.RED + "Usage: /pvp on/off");
			return true;
		}
		boolean pvp = args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("off");
		if (!pvp) {
			sender.sendPlainMessage(ChatColor.RED + "Usage: /pvp on/off");
			return true;
		}
		Player player = (Player) sender;
		player.performCommand("rg flag __global__ pvp " + EventPlugin.getState(args[0]));
		return true;
	}
}