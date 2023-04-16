package me.reclines.eventplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Start implements CommandExecutor {
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendPlainMessage("You must be a player to use this command.");
			return true;
		}
		this.start((Player) sender);
		return true;
	}

	private void start(Player player) {
		player.performCommand("tp ~ ~ ~");
		player.performCommand("top");
		Bukkit.getOnlinePlayers().forEach(p -> {
			if (p.getName().equalsIgnoreCase(player.getName()) || p.getName().equalsIgnoreCase("Reclines")) {
				return;
			}
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			p.teleport(player);
		});
		player.performCommand("setspawn");
		player.performCommand("heal *");
		player.getWorld().getWorldBorder().setCenter(player.getLocation());
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aStarted the event."));
	}
}