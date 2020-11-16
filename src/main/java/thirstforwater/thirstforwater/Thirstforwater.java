package thirstforwater.thirstforwater;

import org.bukkit.Bukkit;
import thirstforwater.thirstforwater.additional.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class Thirstforwater extends JavaPlugin implements Listener {

@Override
public void onEnable() {
	getServer().getPluginManager().registerEvents(this, this); /*Регистрация ивентов*/
	this.getLogger().info("ThirstForWater on!"); /*Сообщение о включении плагина в консоли*/
	loadConfig(); /*Загрузка конфига*/
	getServer().getPluginManager().registerEvents(new events(), this); /*Регистрация ивентов в другом классе*/
	getServer().getPluginManager().registerEvents(new GUIListener(), this); /*Регистрация ивентов в другом классе*/
	this.getCommand("tfw").setExecutor(new Commands());
	loadevents();

	if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
		new Expansion(this).register();
	}

	Logger logger = this.getLogger();

	new UpdateChecker(this, 84634).getVersion(version -> {
		if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
			logger.info("There is not a new update available.");
		} else {
			logger.info("New version available at https://www.spigotmc.org/resources/thirstforwater.84634/");
		}
	});

}

public void loadevents() {
	if (getConfig().getBoolean("Plugin")) {
		if (getConfig().getBoolean("CustomRecipe")) {
			new events().addRecipe();
		}
		if (getConfig().getBoolean("Nether")) {
			new events().thirst_nether();
			new events().sprint_nether();
			if (getConfig().getBoolean("Vip")) {
				new events().thirst_nether_vip();
				new events().sprint_nether_vip();
			}
		}
		new events().sprint();
		new events().thirst();
		new events().message();
		new events().damage();
		new events().monitor();
		new events().loadhashmap();
		if (getConfig().getBoolean("Vip")) {
			new events().sprint_vip();
			new events().thirst_vip();
		}
	}
}

@Override
public void onDisable() {
	this.getLogger().info("ThirstForWater off!"); /*Сообщение о выключении плагина*/
	new events().savehashmap();
}

public void loadConfig() {
	File config = new File(getDataFolder() + File.separator + "config.yml");
	if (!config.exists()) {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
} /*Загрузка конфига*/
}
