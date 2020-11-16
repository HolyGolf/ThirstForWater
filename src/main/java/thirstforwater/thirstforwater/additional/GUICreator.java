package thirstforwater.thirstforwater.additional;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import thirstforwater.thirstforwater.Thirstforwater;

public class GUICreator extends GUI {
private Thirstforwater plugin = Thirstforwater.getPlugin(Thirstforwater.class);

public GUICreator() {
	super(54, "Settings");

	setItem(53, new ItemStack(Material.BARRIER), ChatColor.RED + "Apply & Exit", player -> {
		plugin.reloadConfig();
		plugin.getServer().getPluginManager().disablePlugin(plugin);
		plugin.getServer().getPluginManager().enablePlugin(plugin);
		player.closeInventory();
	});
	setItem(0, new ItemStack(Material.EMERALD), ChatColor.GOLD + "Decrease rate (+): " + plugin.getConfig().getInt("Decrease rate"), player -> {
		if (plugin.getConfig().getInt("Decrease rate") <= 99) {
			plugin.getConfig().set("Decrease rate", (plugin.getConfig().getInt("Decrease rate") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(9, new ItemStack(Material.EMERALD), ChatColor.GOLD + "Decrease rate (-): " + plugin.getConfig().getInt("Decrease rate"), player -> {
		if (plugin.getConfig().getInt("Decrease rate") >= 2) {
			plugin.getConfig().set("Decrease rate", (plugin.getConfig().getInt("Decrease rate") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(1, new ItemStack(Material.EMERALD), ChatColor.GOLD + "Sprint rate (+): " + plugin.getConfig().getInt("Sprint rate"), player -> {
		if (plugin.getConfig().getInt("Sprint rate") <= 99) {
			plugin.getConfig().set("Sprint rate", (plugin.getConfig().getInt("Sprint rate") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(10, new ItemStack(Material.EMERALD), ChatColor.GOLD + "Sprint rate (-): " + plugin.getConfig().getInt("Sprint rate"), player -> {
		if (plugin.getConfig().getInt("Sprint rate") >= 2) {
			plugin.getConfig().set("Sprint rate", (plugin.getConfig().getInt("Sprint rate") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(30, new ItemStack(Material.NETHERRACK), ChatColor.GOLD + "Nether: " + plugin.getConfig().getString("Nether"), player -> {
		if (plugin.getConfig().getBoolean("Nether")) {
			plugin.getConfig().set("Nether", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("Nether")) {
			plugin.getConfig().set("Nether", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(2, new ItemStack(Material.NETHER_BRICK), ChatColor.GOLD + "Nether decrease rate (+): " + plugin.getConfig().getInt("Nether decrease rate"), player -> {
		if (plugin.getConfig().getInt("Nether decrease rate") <= 99) {
			plugin.getConfig().set("Nether decrease rate", (plugin.getConfig().getInt("Nether decrease rate") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(11, new ItemStack(Material.NETHER_BRICK), ChatColor.GOLD + "Nether decrease rate (-): " + plugin.getConfig().getInt("Nether decrease rate"), player -> {
		if (plugin.getConfig().getInt("Nether decrease rate") >= 2) {
			plugin.getConfig().set("Nether decrease rate", (plugin.getConfig().getInt("Nether decrease rate") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(3, new ItemStack(Material.NETHER_BRICK), ChatColor.GOLD + "Nether sprint rate (+): " + plugin.getConfig().getInt("Nether sprint rate"), player -> {
		if (plugin.getConfig().getInt("Nether sprint rate") <= 99) {
			plugin.getConfig().set("Nether sprint rate", (plugin.getConfig().getInt("Nether sprint rate") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(12, new ItemStack(Material.NETHER_BRICK), ChatColor.GOLD + "Nether sprint rate (-): " + plugin.getConfig().getInt("Nether sprint rate"), player -> {
		if (plugin.getConfig().getInt("Nether sprint rate") >= 2) {
			plugin.getConfig().set("Nether sprint rate", (plugin.getConfig().getInt("Nether sprint rate") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});



	setItem(4, new ItemStack(Material.GLASS_BOTTLE), ChatColor.GOLD + "Poisoning bottle chance (+): " + plugin.getConfig().getInt("Poisoning bottle chance"), player -> {
		if (plugin.getConfig().getInt("Poisoning bottle chance") <= 99) {
			plugin.getConfig().set("Poisoning bottle chance", (plugin.getConfig().getInt("Poisoning bottle chance") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(13, new ItemStack(Material.GLASS_BOTTLE), ChatColor.GOLD + "Poisoning bottle chance (-): " + plugin.getConfig().getInt("Poisoning bottle chance"), player -> {
		if (plugin.getConfig().getInt("Poisoning bottle chance") >= 1) {
			plugin.getConfig().set("Poisoning bottle chance", (plugin.getConfig().getInt("Poisoning bottle chance") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(5, new ItemStack(Material.WATER_BUCKET), ChatColor.GOLD + "Poisoning water chance (+): " + plugin.getConfig().getInt("Poisoning water chance"), player -> {
		if (plugin.getConfig().getInt("Poisoning water chance") <= 99) {
			plugin.getConfig().set("Poisoning water chance", (plugin.getConfig().getInt("Poisoning water chance") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(14, new ItemStack(Material.WATER_BUCKET), ChatColor.GOLD + "Poisoning water chance (-): " + plugin.getConfig().getInt("Poisoning water chance"), player -> {
		if (plugin.getConfig().getInt("Poisoning water chance") >= 1) {
			plugin.getConfig().set("Poisoning water chance", (plugin.getConfig().getInt("Poisoning water chance") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(6, new ItemStack(Material.ROTTEN_FLESH), ChatColor.GOLD + "Poisoning duration (+): " + plugin.getConfig().getInt("Poisoning duration"), player -> {
		if (plugin.getConfig().getInt("Poisoning duration") <= 99) {
			plugin.getConfig().set("Poisoning duration", (plugin.getConfig().getInt("Poisoning duration") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(15, new ItemStack(Material.ROTTEN_FLESH), ChatColor.GOLD + "Poisoning duration (-): " + plugin.getConfig().getInt("Poisoning duration"), player -> {
		if (plugin.getConfig().getInt("Poisoning duration") >= 2) {
			plugin.getConfig().set("Poisoning duration", (plugin.getConfig().getInt("Poisoning duration") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem( 7, new ItemStack(Material.DIAMOND_SWORD), ChatColor.GOLD + "Damage at 0 thirst (+): " + plugin.getConfig().getInt("Damage"), player -> {
		if (plugin.getConfig().getInt("Damage") <= 99) {
			plugin.getConfig().set("Damage", (plugin.getConfig().getInt("Damage") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(16, new ItemStack(Material.DIAMOND_SWORD), ChatColor.GOLD + "Damage at 0 thirst (-): " + plugin.getConfig().getInt("Damage"), player -> {
		if (plugin.getConfig().getInt("Damage") >= 1) {
			plugin.getConfig().set("Damage", (plugin.getConfig().getInt("Damage") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem( 8, new ItemStack(Material.GLASS_BOTTLE), ChatColor.GOLD + "WaterRecoveryBottle (+): " + plugin.getConfig().getInt("WaterRecoveryBottle"), player -> {
		if (plugin.getConfig().getInt("WaterRecoveryBottle") <= 99) {
			plugin.getConfig().set("WaterRecoveryBottle", (plugin.getConfig().getInt("WaterRecoveryBottle") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(17, new ItemStack(Material.GLASS_BOTTLE), ChatColor.GOLD + "WaterRecoveryBottle (-): " + plugin.getConfig().getInt("WaterRecoveryBottle"), player -> {
		if (plugin.getConfig().getInt("WaterRecoveryBottle") >= 1) {
			plugin.getConfig().set("WaterRecoveryBottle", (plugin.getConfig().getInt("WaterRecoveryBottle") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem( 27, new ItemStack(Material.POTION), ChatColor.GOLD + "WaterRecoveryClearWater (+): " + plugin.getConfig().getInt("WaterRecoveryClearWater"), player -> {
		if (plugin.getConfig().getInt("WaterRecoveryClearWater") <= 99) {
			plugin.getConfig().set("WaterRecoveryClearWater", (plugin.getConfig().getInt("WaterRecoveryClearWater") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(36, new ItemStack(Material.POTION), ChatColor.GOLD + "WaterRecoveryClearWater (-): " + plugin.getConfig().getInt("WaterRecoveryClearWater"), player -> {
		if (plugin.getConfig().getInt("WaterRecoveryClearWater") >= 1) {
			plugin.getConfig().set("WaterRecoveryClearWater", (plugin.getConfig().getInt("WaterRecoveryClearWater") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem( 28, new ItemStack(Material.WATER_BUCKET), ChatColor.GOLD + "WaterRecoveryWater (+): " + plugin.getConfig().getInt("WaterRecoveryWater"), player -> {
		if (plugin.getConfig().getInt("WaterRecoveryWater") <= 99) {
			plugin.getConfig().set("WaterRecoveryWater", (plugin.getConfig().getInt("WaterRecoveryWater") + 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(37, new ItemStack(Material.WATER_BUCKET), ChatColor.GOLD + "WaterRecoveryWater (-): " + plugin.getConfig().getInt("WaterRecoveryWater"), player -> {
		if (plugin.getConfig().getInt("WaterRecoveryWater") >= 1) {
			plugin.getConfig().set("WaterRecoveryWater", (plugin.getConfig().getInt("WaterRecoveryWater") - 1));
		}
		plugin.saveConfig();
		plugin.reloadConfig();
		new GUICreator().open(player);
	});
	setItem(31, new ItemStack(Material.IRON_BOOTS), ChatColor.GOLD + "Disabling sprint when <20 thirst: " + plugin.getConfig().getString("Sprint"), player -> {
		if (plugin.getConfig().getBoolean("Sprint")) {
			plugin.getConfig().set("Sprint", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("Sprint")) {
			plugin.getConfig().set("Sprint", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(32, new ItemStack(Material.FURNACE), ChatColor.GOLD + "CustomRecipe: " + plugin.getConfig().getString("CustomRecipe"), player -> {
		if (plugin.getConfig().getBoolean("CustomRecipe")) {
			plugin.getConfig().set("CustomRecipe", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("CustomRecipe")) {
			plugin.getConfig().set("CustomRecipe", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(33, new ItemStack(Material.BLACK_WOOL), ChatColor.GOLD + "Water indicator above the toolbar: " + plugin.getConfig().getString("Actionbar"), player -> {
		if (plugin.getConfig().getBoolean("Actionbar")) {
			plugin.getConfig().set("Actionbar", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("Actionbar")) {
			plugin.getConfig().set("Actionbar", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(34, new ItemStack(Material.WHITE_WOOL), ChatColor.GOLD + "Minimalismbar: " + plugin.getConfig().getString("Minimalismbar"), player -> {
		if (plugin.getConfig().getBoolean("Minimalismbar")) {
			plugin.getConfig().set("Minimalismbar", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("Minimalismbar")) {
			plugin.getConfig().set("Minimalismbar", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(35, new ItemStack(Material.OAK_SIGN), ChatColor.GOLD + "Messages if the water indicator is off: " + plugin.getConfig().getString("Messages"), player -> {
		if (plugin.getConfig().getBoolean("Messages")) {
			plugin.getConfig().set("Messages", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("Messages")) {
			plugin.getConfig().set("Messages", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(38, new ItemStack(Material.GOLD_INGOT), ChatColor.GOLD + "Vip permission: " + plugin.getConfig().getString("Vip"), player -> {
		if (plugin.getConfig().getBoolean("Vip")) {
			plugin.getConfig().set("Vip", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("Vip")) {
			plugin.getConfig().set("Vip", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
	setItem(51, new ItemStack(Material.COMMAND_BLOCK), ChatColor.GOLD + "debug: " + plugin.getConfig().getString("debug"), player -> {
		if (plugin.getConfig().getBoolean("debug")) {
			plugin.getConfig().set("debug", false);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		} else if (!plugin.getConfig().getBoolean("debug")) {
			plugin.getConfig().set("debug", true);
			plugin.saveConfig();
			plugin.reloadConfig();
			new GUICreator().open(player);
		}
	});
}
}
