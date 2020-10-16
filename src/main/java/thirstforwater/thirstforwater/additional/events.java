package thirstforwater.thirstforwater.additional;

import com.google.common.base.Strings;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import thirstforwater.thirstforwater.Thirstforwater;

import java.util.*;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;

public class events implements Listener {
	private Thirstforwater plugin = Thirstforwater.getPlugin(Thirstforwater.class);
	public static HashMap<UUID, Integer> list = new HashMap<>();
	public static int idt;
	public static int idt2;
	public static int idt3;
	public static int idt4;
	public static int idt5;
	public static int idt6;
	public static int idt7;

public void thirst() {
	int time = plugin.getConfig().getInt("Decrease rate") * 20;
	idt = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if ((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst"))) {
						if (plugin.getConfig().getBoolean("Nether")) {
							if (!p.getLocation().getWorld().getName().endsWith("_nether")) {
								if (list.get(p.getUniqueId()) > 0) {
									int wt = list.get(p.getUniqueId()) - 1;
									list.replace(p.getUniqueId(), wt);
									if (plugin.getConfig().getBoolean("debug") && p.isOp()) {
										p.sendMessage("world thirst Nether ON");
									}
								}
							}
						} else {
							if (list.get(p.getUniqueId()) > 0) {
								int wt = list.get(p.getUniqueId()) - 1;
								list.replace(p.getUniqueId(), wt);
								if (plugin.getConfig().getBoolean("debug") && p.isOp()) {
									p.sendMessage("world thirst Nether OFF");
								}
							}
						}
				}
			}
		}
	}, 0L, time);
}

public void thirst_nether() {
	int time = plugin.getConfig().getInt("Nether decrease rate") * 20;
	idt5 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst"))) && p.getLocation().getWorld().getName().endsWith("_nether")) {
					if (list.get(p.getUniqueId()) > 0) {
						int wt = list.get(p.getUniqueId()) - 1;
						list.replace(p.getUniqueId(), wt);
						if (plugin.getConfig().getBoolean("debug") && p.isOp()) {
							p.sendMessage("Nether thirst");
						}
					}
				}
			}
		}
	}, 0L, time);
}

public void message() {
	idt6 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if ((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst"))) {
						if (!plugin.getConfig().getBoolean("Actionbar") && plugin.getConfig().getBoolean("Messages")) {
							if (list.get(p.getUniqueId()) < 20) {
								p.sendMessage(ChatColor.RED + plugin.getConfig().getString("LowWaterMessage"));
							} else if (list.get(p.getUniqueId()) < 110 && list.get(p.getUniqueId()) > 100) {
								p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("HighWaterMessage"));
							}
						}
				}
			}
		}
	}, 0L, 1200L);
}

public void sprint() {
	int spr = plugin.getConfig().getInt("Sprint rate") * 20;
	idt4 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				 if (plugin.getConfig().getBoolean("Nether")) {
					 if ((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst")) && !p.getLocation().getWorld().getName().endsWith("_nether")) {
						 if (p.isSprinting()) {
							 if (list.get(p.getUniqueId()) > 0) {
								 int wt = list.get(p.getUniqueId()) - 1;
								 list.replace(p.getUniqueId(), wt);
								 if (plugin.getConfig().getBoolean("debug") && p.isOp()) {
									 p.sendMessage("world sprint Nether ON");
								 }
							 }
						 }
					 }
				 } else {
					 if ((p.getGameMode() == GameMode.SURVIVAL) || (p.getGameMode() == GameMode.ADVENTURE)) {
						 if (p.isSprinting()) {
							 if (list.get(p.getUniqueId()) > 0) {
								 int wt = list.get(p.getUniqueId()) - 1;
								 list.replace(p.getUniqueId(), wt);
								 if (plugin.getConfig().getBoolean("debug") && p.isOp()) {
									 p.sendMessage("world sprint Nether OFF");
								 }
							 }

						 }
					 }
				 }
			}
		}
	}, 0L, spr);
}

public void sprint_nether() {
	int spr = plugin.getConfig().getInt("Nether sprint rate") * 20;
	idt7 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if ((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst")) && p.getLocation().getWorld().getName().endsWith("_nether")) {
					if (p.isOnline() && p.isSprinting()) {
						if (list.get(p.getUniqueId()) > 0) {
							int wt = list.get(p.getUniqueId()) - 1;
							list.replace(p.getUniqueId(), wt);
							if (plugin.getConfig().getBoolean("debug") && p.isOp()) {
								p.sendMessage("nether sprint");
							}
						}
					}
				}
			}
		}
	}, 0L, spr);
}

public void damage(){
	idt3 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if ((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst"))) {
						if (list.get(p.getUniqueId()) <= 0) {
							if (p.getHealth() > 0 && list.get(p.getUniqueId()) <= 0) {
								p.damage(plugin.getConfig().getInt("Damage"));
							}
						}
					}
				}
			}
	}, 0L, 20L);
}

public void messag(Player p, String message) {
	p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
}

public void monitor() {
	idt2 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if ((p.getGameMode() != GameMode.CREATIVE) && (p.getGameMode() != GameMode.SPECTATOR) && (!p.hasPermission("Thirstforwater.noThirst"))) {
						if (plugin.getConfig().getBoolean("Actionbar")) {
							if (!plugin.getConfig().getBoolean("Minimalismbar")) {
								if (list.get(p.getUniqueId()) <= 0) {
									String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + "---------------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
									messag(p, message);
								} else if (list.get(p.getUniqueId()) > 100) {
									String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "####################" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
									messag(p, message);
								} else if (list.get(p.getUniqueId()) >=20) {
									messag(p, ChatColor.GOLD + "" + ChatColor.BOLD + "[" + getProgressBar(list.get(p.getUniqueId()), 100, 20, '#', '-', ChatColor.DARK_BLUE, ChatColor.DARK_GRAY) + ChatColor.GOLD + "" + ChatColor.BOLD + "]");
								} else if (list.get(p.getUniqueId()) <= 19) {
									messag(p, ChatColor.GOLD + "" + ChatColor.BOLD + "[" + getProgressBar(list.get(p.getUniqueId()), 100, 20, '#', '-', ChatColor.RED, ChatColor.DARK_GRAY) + ChatColor.GOLD + "" + ChatColor.BOLD + "]");
								} else if (list.get(p.getUniqueId()) > 0) {
									String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.RED + "#" + ChatColor.DARK_GRAY + "-------------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
									messag(p, message);
								}
							} else {
								if (list.get(p.getUniqueId()) > 100) {
									messag(p, ChatColor.DARK_BLUE + "--------------------");
								} else if (list.get(p.getUniqueId()) >= 20) {
									messag(p, getProgressBar(list.get(p.getUniqueId()), 100, 20, '-', '-', ChatColor.DARK_BLUE, ChatColor.DARK_GRAY));
								} else if (list.get(p.getUniqueId()) <= 19) {
									messag(p, getProgressBar(list.get(p.getUniqueId()), 100, 20, '-', '-', ChatColor.RED, ChatColor.DARK_GRAY));
								} else if (list.get(p.getUniqueId()) <= 0) {
									String message = ChatColor.DARK_RED + "--------------------";
									messag(p, message);
								}
							}
						}
				}
			}
		}
	}, 0L, 5L);
}

public String getProgressBar(int current, int max, int totalBars, char symbol1, char symbol2, ChatColor completedColor, ChatColor notCompletedColor) {
	float percent = (float) current / max;
	int progressBars = (int) (totalBars * percent);
	return Strings.repeat("" + completedColor + symbol1, progressBars) + Strings.repeat("" + notCompletedColor + symbol2, totalBars - progressBars);
}

@EventHandler
public void onPlayerJoin(PlayerJoinEvent player) {
	if (!list.containsKey(player.getPlayer().getUniqueId())) {
		list.put(player.getPlayer().getUniqueId(), 110);
	}
	if (player.getPlayer().isOp()) {
		new UpdateChecker(plugin, 84634).getVersion(version -> { /*!!!!!!!!!Вставить id!!!!!!!!!*/
			if (!plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
				player.getPlayer().sendMessage(ChatColor.GOLD + "[ThirstForWater]: New version available at https://www.spigotmc.org/resources/thirstforwater.84634/");
			}
		});
	}
}

@EventHandler
public void sprint(PlayerMoveEvent event) {
	if (event.getPlayer().isSprinting() && list.get(event.getPlayer().getUniqueId()) <= 19 && plugin.getConfig().getBoolean("Sprint")) {
		event.setCancelled(true);
		event.getPlayer().setSprinting(false);
	}
}

@EventHandler
public void onClose(InventoryCloseEvent e){
	Player player = (Player) e.getPlayer();
	UUID playerUUID = player.getUniqueId();

	GUI.openInventories.remove(playerUUID);
}

@EventHandler
public void onQuit(PlayerQuitEvent e){
	Player player = e.getPlayer();
	UUID playerUUID = player.getUniqueId();

	GUI.openInventories.remove(playerUUID);
}

@EventHandler
public void onPlayerRespawn(PlayerRespawnEvent player){
	list.replace(player.getPlayer().getUniqueId(), 110);
	if (plugin.getConfig().getBoolean("debug") && player.getPlayer().isOp()) {
		player.getPlayer().sendMessage("Water restored");
	}
}

@EventHandler
public void onPlayerEvent(PlayerItemConsumeEvent event) {
	if (event.getItem().getType() == Material.POTION && event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasDisplayName() && event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().contains(ChatColor.AQUA + plugin.getConfig().getString("WaterLore")) && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + plugin.getConfig().getString("WaterName"))) {
		if ((list.get(event.getPlayer().getUniqueId()) + plugin.getConfig().getInt("WaterRecoveryClearWater")) <= 110) {
			int gg = list.get(event.getPlayer().getUniqueId()) + plugin.getConfig().getInt("WaterRecoveryClearWater");
			list.replace(event.getPlayer().getUniqueId(), gg);
			if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
				event.getPlayer().sendMessage("Added water, clear water");
			}
		} else {
			list.replace(event.getPlayer().getUniqueId(), 110);
			if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
				event.getPlayer().sendMessage("Added water, full, clear water");
			}
		}
	} else if (event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta() instanceof PotionMeta) {
		PotionType potionType = ((PotionMeta) event.getItem().getItemMeta()).getBasePotionData().getType();
		if (potionType == PotionType.WATER) {
				Random r = new Random();
				int ran = r.nextInt(101);
				if (ran <= plugin.getConfig().getInt("Poisoning bottle chance")) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, (plugin.getConfig().getInt("Poisoning duration") * 20 ), 1));
					if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
						event.getPlayer().sendMessage("Poisoning");
					}
				}
				if ((list.get(event.getPlayer().getUniqueId()) + plugin.getConfig().getInt("WaterRecoveryBottle")) <= 110) {
					int gg = list.get(event.getPlayer().getUniqueId()) + plugin.getConfig().getInt("WaterRecoveryBottle");
					list.replace(event.getPlayer().getUniqueId(), gg);
					if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
						event.getPlayer().sendMessage("Added water, bottle");
					}
				} else {
					list.replace(event.getPlayer().getUniqueId(), 110);
					if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
						event.getPlayer().sendMessage("Added water, full, bottle");
					}
				}
		}
	}
}

public void addRecipe() {
	ItemStack water = new ItemStack(Material.POTION, 1, (byte)0);
	Material wat = water.getType();
	ItemMeta meta = water.getItemMeta();

	ArrayList<String> lore = new ArrayList<String>();

	lore.add(" ");
	lore.add(ChatColor.AQUA + plugin.getConfig().getString("WaterLore"));
	lore.add(" ");
	meta.setLore(lore);
	meta.setDisplayName(ChatColor.AQUA + plugin.getConfig().getString("WaterName"));
	water.setItemMeta(meta);

	FurnaceRecipe waters = new FurnaceRecipe(water, wat);
	Bukkit.getServer().addRecipe(waters);
}

@EventHandler
public void onInteract(PlayerInteractEvent event) {

	Action action = event.getAction();
	Player player = event.getPlayer();
	if (event.getItem() == null && (action.equals(Action.RIGHT_CLICK_BLOCK) || event.getAction() == RIGHT_CLICK_AIR) && player.isSneaking()) {
		List<Block> lineOfSight = event.getPlayer().getLineOfSight(null, 5);
		for (Block b : lineOfSight) {
			if (b.getType() == Material.WATER) {
				Random r = new Random();
				int ran = r.nextInt(101);
				if (ran <= plugin.getConfig().getInt("Poisoning water chance")) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, (plugin.getConfig().getInt("Poisoning duration") * 20), 1));
					if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
						event.getPlayer().sendMessage("Poisoning");
					}
				}
				if ((list.get(event.getPlayer().getUniqueId()) + (plugin.getConfig().getInt("WaterRecoveryWater"))/2) <= 110) {
					int gg = list.get(event.getPlayer().getUniqueId()) + (plugin.getConfig().getInt("WaterRecoveryWater")/2);
					list.replace(event.getPlayer().getUniqueId(), gg);
					if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
						event.getPlayer().sendMessage("Added water, water");
					}
				} else {
					list.replace(event.getPlayer().getUniqueId(), 110);
					if (plugin.getConfig().getBoolean("debug") && event.getPlayer().isOp()) {
						event.getPlayer().sendMessage("Added water, full, water");
					}
				}
				break;
			}
		}
	}
}

public void loadhashmap(){
	if (plugin.getConfig().getStringList("data").isEmpty()) {
		return;
	} else {
		for (String rawData : plugin.getConfig().getStringList("data")) {
			String[] raw = rawData.split(":");
			list.put(UUID.fromString(raw[0]), Integer.valueOf(raw[1]));
		}
		if (plugin.getConfig().getBoolean("debug")) {
			Bukkit.broadcastMessage("Hashmap loaded");
		}
	}
}

public void savehashmap(){
	List<String> hashmapData = new ArrayList<String>();
	for(UUID uuid : list.keySet()) {
		String data = uuid.toString() + ":" + list.get(uuid);
		hashmapData.add(data);
	}
	if (plugin.getConfig().getBoolean("debug")) {
		Bukkit.broadcastMessage("Hashmap saved");
	}
	plugin.reloadConfig();
	plugin.getConfig().set("data", hashmapData);
	plugin.saveConfig();
}
}
