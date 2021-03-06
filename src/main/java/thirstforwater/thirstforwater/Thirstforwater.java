package thirstforwater.thirstforwater;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import thirstforwater.thirstforwater.additional.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.concurrent.Callable;
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
	metrcs();
	if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
		new Expansion(this).register();
		this.getLogger().info("Placeholders registered.");
	}
	Logger logger = this.getLogger();
	new UpdateChecker(this, 84634).getVersion(version -> {
		if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
			logger.info("There is not a new update available.");
		} else {
			logger.info("New version " + version + " available at https://www.spigotmc.org/resources/thirstforwater.84634/");
		}
	});
}

public void metrcs(){
	int pluginId = 9655;
	Metrics metrics = new Metrics(this, pluginId);
	metrics.addCustomChart(new Metrics.SingleLineChart("players", new Callable<Integer>() {
		@Override
		public Integer call() throws Exception {
			return Bukkit.getOnlinePlayers().size();
		}
	}));
	metrics.addCustomChart(new Metrics.SingleLineChart("servers", new Callable<Integer>() {
		@Override
		public Integer call() throws Exception {
			return 1;
		}
	}));
}


public void loadevents() {
	if (getConfig().getBoolean("Plugin")) {
		if (getConfig().getBoolean("CustomRecipe")) {
			new events().addRecipe();
		}
		new events().thirst();
		new events().monitor();
		new events().loadhashmap();
		new events().loadWorlds();
		new events().loadWorlds_sprint();
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
