package thirstforwater.thirstforwater.additional;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import thirstforwater.thirstforwater.Thirstforwater;

public class Commands implements CommandExecutor {
private Thirstforwater plugin = Thirstforwater.getPlugin(Thirstforwater.class);
private events pl = new events();

@Override
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	GUICreator GUIcreator = new GUICreator();
	if (sender instanceof Player) {
		if (args.length == 0 || args[0].equals("help")) {
			sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "--------------\n" + ChatColor.GOLD + "/tfw help - help\n/tfw reload - reload plugin\n/tfw settings - GUI config settings" + ChatColor.AQUA + "" + ChatColor.BOLD + "\n--------------");
			return true;
		} else if (args[0].equals("reload")) {
			if (sender.isOp() || sender.hasPermission("Thirstforwater.tfw.reload")) {
				plugin.reloadConfig();
				plugin.getServer().getPluginManager().disablePlugin(plugin);
				plugin.getServer().getPluginManager().enablePlugin(plugin);
				sender.sendMessage(ChatColor.GOLD + "[ThirstForWater]: Plugin reloaded");
			} else {
				String txt = net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Nopermission"));
				sender.sendMessage(txt);
			}
			return true;
		} else if (args[0].equals("settings")) {
			if (sender.isOp() || sender.hasPermission("Thirstforwater.tfw.settings")) {
				GUIcreator.open(((Player) sender).getPlayer());
			} else {
				String txt = net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Nopermission"));
				sender.sendMessage(txt);
			}
			return true;
		} else if (args[0].equals("disable")) {
			if (sender.isOp() || sender.hasPermission("Thirstforwater.tfw.settings")) {
				plugin.getConfig().set("Plugin", false);
				pl.savehashmap();
				plugin.getServer().getPluginManager().disablePlugin(plugin);
				plugin.getServer().getPluginManager().enablePlugin(plugin);
				sender.sendMessage(ChatColor.RED + "ThirstForWater disabled");
			} else {
				String txt = net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Nopermission"));
				sender.sendMessage(txt);
			}
		} else if (args[0].equals("enable")) {
			if (sender.isOp() || sender.hasPermission("Thirstforwater.tfw.settings")) {
				plugin.getConfig().set("Plugin", true);
				pl.savehashmap();
				plugin.getServer().getPluginManager().disablePlugin(plugin);
				plugin.getServer().getPluginManager().enablePlugin(plugin);
				sender.sendMessage(ChatColor.RED + "ThirstForWater enabled");
			} else {
				String txt = net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Nopermission"));
				sender.sendMessage(txt);
			}
		} else {
			sender.sendMessage(ChatColor.RED + "[ThirstForWater]: What?!");
			return true;
		}
	}
	return true;
}

}
