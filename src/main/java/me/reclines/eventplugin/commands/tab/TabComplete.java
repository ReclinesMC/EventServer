package me.reclines.eventplugin.commands.tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabComplete
		implements TabCompleter {
	@Nullable
	public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (command.getName().equalsIgnoreCase("pvp") || command.getName().equalsIgnoreCase("build")) {
			if (args.length == 1) {
				return Arrays.asList("on", "off");
			}
		} else if (command.getName().equalsIgnoreCase("setborder") && (args.length == 1 || args.length == 2)) {
			return new ArrayList<>();
		}
		return new ArrayList<>();
	}
}
