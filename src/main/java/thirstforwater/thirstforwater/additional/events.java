package thirstforwater.thirstforwater.additional;

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

public void thirst(Player p) {
	int time = plugin.getConfig().getInt("Decrease rate") * 20;
	idt = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
				if ((p.getGameMode() == GameMode.SURVIVAL) || (p.getGameMode() == GameMode.ADVENTURE)) {
					if (p.isOnline()) {
						if (list.get(p.getUniqueId()) > 0) {
							int wt = list.get(p.getUniqueId()) - 7;
							list.replace(p.getUniqueId(), wt);
							if (!plugin.getConfig().getBoolean("Actionbar")) {
								if (list.get(p.getUniqueId()) < 20) {
									p.sendMessage(ChatColor.RED + plugin.getConfig().getString("LowWaterMessage"));
								} else if (list.get(p.getUniqueId()) < 110 && list.get(p.getUniqueId()) > 100) {
									p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("HighWaterMessage"));
								}
							}
						} else {
							damage(p);
						}
					} else {
						getServer().getScheduler().cancelTask(idt);
					}
				}
		}
	}, 0L, time);
}

public void sprint(Player p) {
	int spr = plugin.getConfig().getInt("Sprint rate") * 20;
	idt4 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			if ((p.getGameMode() == GameMode.SURVIVAL) || (p.getGameMode() == GameMode.ADVENTURE)) {
				if (p.isOnline()) {
					if (list.get(p.getUniqueId()) > 0) {
						int wt = list.get(p.getUniqueId()) - 1;
						list.replace(p.getUniqueId(), wt);
					} else {
						damage(p);
					}
				} else {
					getServer().getScheduler().cancelTask(idt4);
				}
			}
		}
	}, 0L, spr);
}


public void damage(Player p){
	idt3 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
				if ((p.getGameMode() == GameMode.SURVIVAL) || (p.getGameMode() == GameMode.ADVENTURE)) {
					if (p.isOnline()) {
						if (list.get(p.getUniqueId()) <= 0) {
							if (p.getHealth() > 0 && list.get(p.getUniqueId()) <= 0) {
								p.damage(plugin.getConfig().getInt("Damage"));
							} else {
								getServer().getScheduler().cancelTask(idt3);
							}
						} else {
							getServer().getScheduler().cancelTask(idt3);
						}
					}
				}
		}
	}, 0L, 20L);
}

public void messag(Player p, String message) {
	p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
}

public void monitor(Player p) {
	idt2 = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		@Override
		public void run() {
			if ((p.getGameMode() == GameMode.SURVIVAL) || (p.getGameMode() == GameMode.ADVENTURE)) {
				if (p.isOnline()) {
					if (plugin.getConfig().getBoolean("Actionbar")) {
						if (!plugin.getConfig().getBoolean("Minimalismbar")) {
							if (list.get(p.getUniqueId()) <= 0) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + "---------------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 100) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "####################" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 95) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "###################" + ChatColor.DARK_GRAY + "-" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 90) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "##################" + ChatColor.DARK_GRAY + "--" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 85) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "#################" + ChatColor.DARK_GRAY + "---" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 80) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "################" + ChatColor.DARK_GRAY + "----" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 75) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "###############" + ChatColor.DARK_GRAY + "-----" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 70) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "##############" + ChatColor.DARK_GRAY + "------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 65) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "#############" + ChatColor.DARK_GRAY + "-------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 60) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "############" + ChatColor.DARK_GRAY + "--------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 55) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "###########" + ChatColor.DARK_GRAY + "---------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 50) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "##########" + ChatColor.DARK_GRAY + "----------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 45) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "#########" + ChatColor.DARK_GRAY + "-----------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 40) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "########" + ChatColor.DARK_GRAY + "------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 35) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "#######" + ChatColor.DARK_GRAY + "-------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 30) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "######" + ChatColor.DARK_GRAY + "--------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 25) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "#####" + ChatColor.DARK_GRAY + "---------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 20) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_BLUE + "####" + ChatColor.DARK_GRAY + "----------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 15) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.RED + "###" + ChatColor.DARK_GRAY + "-----------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 10) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.RED + "##" + ChatColor.DARK_GRAY + "------------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) > 0) {
								String message = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.RED + "#" + ChatColor.DARK_GRAY + "-------------------" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
								messag(p, message);
							}
						} else {
							if (list.get(p.getUniqueId()) <= 0) {
								String message = ChatColor.DARK_RED + "--------------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 100) {
								String message = ChatColor.DARK_BLUE + "--------------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 95) {
								String message = ChatColor.DARK_BLUE + "-------------------" + ChatColor.DARK_GRAY + "-";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 90) {
								String message = ChatColor.DARK_BLUE + "------------------" + ChatColor.DARK_GRAY + "--";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 85) {
								String message = ChatColor.DARK_BLUE + "-----------------" + ChatColor.DARK_GRAY + "---";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 80) {
								String message = ChatColor.DARK_BLUE + "----------------" + ChatColor.DARK_GRAY + "----";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 75) {
								String message = ChatColor.DARK_BLUE + "---------------" + ChatColor.DARK_GRAY + "-----";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 70) {
								String message = ChatColor.DARK_BLUE + "--------------" + ChatColor.DARK_GRAY + "------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 65) {
								String message = ChatColor.DARK_BLUE + "-------------" + ChatColor.DARK_GRAY + "-------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 60) {
								String message = ChatColor.DARK_BLUE + "------------" + ChatColor.DARK_GRAY + "--------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 55) {
								String message = ChatColor.DARK_BLUE + "-----------" + ChatColor.DARK_GRAY + "---------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 50) {
								String message = ChatColor.DARK_BLUE + "----------" + ChatColor.DARK_GRAY + "----------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 45) {
								String message = ChatColor.DARK_BLUE + "---------" + ChatColor.DARK_GRAY + "-----------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 40) {
								String message = ChatColor.DARK_BLUE + "--------" + ChatColor.DARK_GRAY + "------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 35) {
								String message = ChatColor.DARK_BLUE + "-------" + ChatColor.DARK_GRAY + "-------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 30) {
								String message = ChatColor.DARK_BLUE + "------" + ChatColor.DARK_GRAY + "--------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 25) {
								String message = ChatColor.DARK_BLUE + "-----" + ChatColor.DARK_GRAY + "---------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 20) {
								String message = ChatColor.DARK_BLUE + "----" + ChatColor.DARK_GRAY + "----------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 15) {
								String message = ChatColor.RED + "---" + ChatColor.DARK_GRAY + "-----------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) >= 10) {
								String message = ChatColor.RED + "--" + ChatColor.DARK_GRAY + "------------------";
								messag(p, message);
							} else if (list.get(p.getUniqueId()) > 0) {
								String message = ChatColor.RED + "-" + ChatColor.DARK_GRAY + "-------------------";
								messag(p, message);
							}
						}
					}
				} else {
					getServer().getScheduler().cancelTask(idt2);
				}
			}
		}
	}, 0L, 5L);
}

@EventHandler
public void onPlayerJoin(PlayerJoinEvent player) {
	if (!list.containsKey(player.getPlayer().getUniqueId())) {
		list.put(player.getPlayer().getUniqueId(), 111);
	} else {
		int gg = list.get(player.getPlayer().getUniqueId()) + 2;
		list.replace(player.getPlayer().getUniqueId(), gg);
	}
	thirst(player.getPlayer());
	monitor(player.getPlayer());
	if (player.getPlayer().isOp()) {
		new UpdateChecker(plugin, 84634).getVersion(version -> { /*!!!!!!!!!Вставить id!!!!!!!!!*/
			if (!plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
				player.getPlayer().sendMessage(ChatColor.GOLD + "[ThirstForWater]: New version available at https://www.spigotmc.org/resources/thristforwater.84634/");
			}
		});
	}
}

@EventHandler
public void sprint(PlayerToggleSprintEvent event) {
	if (event.getPlayer().isSprinting() && list.get(event.getPlayer().getUniqueId()) <= 30 && plugin.getConfig().getBoolean("Sprint")) {
		event.setCancelled(true);
		event.getPlayer().setSprinting(false);
	} else {
		if (event.isSprinting()) {
			sprint(event.getPlayer());
		} else {
			getServer().getScheduler().cancelTask(idt4);
		}
	}
}

@EventHandler
public void onPlayerRespawn(PlayerRespawnEvent player){
	list.replace(player.getPlayer().getUniqueId(), 110);
}

@EventHandler
public void onPlayerEvent(PlayerItemConsumeEvent event) {
	if (event.getItem().getType() == Material.POTION && event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasDisplayName() && event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().contains(ChatColor.AQUA + plugin.getConfig().getString("WaterLore")) && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + plugin.getConfig().getString("WaterName"))) {
		if ((list.get(event.getPlayer().getUniqueId()) + 35) <= 110) {
			int gg = list.get(event.getPlayer().getUniqueId()) + 35;
			list.replace(event.getPlayer().getUniqueId(), gg);
		} else {
			list.replace(event.getPlayer().getUniqueId(), 110);
		}
	} else if (event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta() instanceof PotionMeta) {
		PotionType potionType = ((PotionMeta) event.getItem().getItemMeta()).getBasePotionData().getType();
		if (potionType == PotionType.WATER) {
				Random r = new Random();
				int ran = r.nextInt(101);
				if (ran <= plugin.getConfig().getInt("Poisoning bottle chance")) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, (plugin.getConfig().getInt("Poisoning duration") * 20 ), 1));
				}
				if ((list.get(event.getPlayer().getUniqueId()) + 35) <= 110) {
					int gg = list.get(event.getPlayer().getUniqueId()) + 35;
					list.replace(event.getPlayer().getUniqueId(), gg);
				} else {
					list.replace(event.getPlayer().getUniqueId(), 110);
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
				}
				if ((list.get(event.getPlayer().getUniqueId()) + 5) <= 23) {
					int gg = list.get(event.getPlayer().getUniqueId()) + 5;
					list.replace(event.getPlayer().getUniqueId(), gg);
				} else {
					list.replace(event.getPlayer().getUniqueId(), 23);
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
	}
}

public void savehashmap(){
	List<String> hashmapData = new ArrayList<String>();
	for(UUID uuid : list.keySet()) {

		String data = uuid.toString() + ":" + list.get(uuid);
		hashmapData.add(data);

	}
	plugin.getConfig().set("data", hashmapData);
	plugin.saveConfig();
}
}
