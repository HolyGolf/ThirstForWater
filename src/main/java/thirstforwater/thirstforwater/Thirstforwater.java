package thirstforwater.thirstforwater;

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
	new events().loadhashmap();
	getServer().getPluginManager().registerEvents(new events(), this); /*Регистрация ивентов в другом классе*/
	new events().addRecipe();
	Logger logger = this.getLogger();

	new UpdateChecker(this, 84634).getVersion(version -> { /*!!!!!!!!!Вставить id!!!!!!!!!*/
		if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
			logger.info("There is not a new update available.");
		} else {
			logger.info("New version available at https://www.spigotmc.org/resources/thristforwater.84634/"); /*!!!!!!!Вставить ссылку!!!!!!!*/
		}
	});

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
