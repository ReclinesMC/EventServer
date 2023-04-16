package me.reclines.eventplugin;

import me.reclines.eventplugin.commands.Build;
import me.reclines.eventplugin.commands.PvP;
import me.reclines.eventplugin.commands.SetBorder;
import me.reclines.eventplugin.commands.Start;
import me.reclines.eventplugin.commands.tab.TabComplete;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventPlugin extends JavaPlugin {

	public static String getState(final String state) {
		return state.equalsIgnoreCase("on") ? "allow" : "deny";
	}

	@Override
	public void onEnable() {
		super.getLogger().info("EventPlugin has been enabled.");

		final PluginCommand build = super.getCommand("build");
		build.setExecutor(new Build());
		build.setTabCompleter(new TabComplete());

		final PluginCommand pvp = super.getCommand("pvp");
		pvp.setExecutor(new PvP());
		pvp.setTabCompleter(new TabComplete());

		final PluginCommand setborder = super.getCommand("setborder");
		setborder.setExecutor(new SetBorder());
		setborder.setTabCompleter(new TabComplete());

		super.getCommand("start").setExecutor(new Start());
	}

	@Override
	public void onDisable() {
		super.getLogger().info("EventPlugin has been disabled.");
	}
}