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
	new events().addRecipe();
	new events().thirst();
	new events().message();
	new events().damage();
	new events().monitor();
	new events().sprint();
	new events().loadhashmap();
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
