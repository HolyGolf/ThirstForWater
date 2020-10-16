package thirstforwater.thirstforwater.additional;
import com.google.common.base.Strings;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import thirstforwater.thirstforwater.Thirstforwater;

/**
 * This class will automatically register as a placeholder expansion
 * when a jar including this class is added to the directory
 * {@code /plugins/PlaceholderAPI/expansions} on your server.
 * <br>
 * <br>If you create such a class inside your own plugin, you have to
 * register it manually in your plugins {@code onEnable()} by using
 * {@code new YourExpansionClass().register();}
 */
public class Expansion extends PlaceholderExpansion {
private Thirstforwater plugin;

public Expansion(Thirstforwater plugin){
	this.plugin = plugin;
}

@Override
public boolean canRegister(){
	return true;
}

@Override
public String getAuthor(){
	return "HolyGolf";
}


@Override
public String getIdentifier(){
	return "thirst";
}


@Override
public String getVersion(){
	return "1.7";
}

@Override
public String onPlaceholderRequest(Player player, String identifier){

	if(player == null){
		return "";
	}
	if(identifier.equals("percents")){
		if (events.list.get(player.getUniqueId()) > 100) {
			return "100";
		} else if (events.list.get(player.getUniqueId()) <= 0) {
			return "0";
		} else {
			return events.list.get(player.getUniqueId()).toString();
		}
	}
	if(identifier.equals("status")) {
		if (events.list.get(player.getUniqueId()) >= 100) {
			return "You are not thirsty";
		} else if (events.list.get(player.getUniqueId()) < 100 && events.list.get(player.getUniqueId()) >= 70) {
			return "Light thirst";
		} else if (events.list.get(player.getUniqueId()) < 70 && events.list.get(player.getUniqueId()) >= 40) {
			return "You are thirsty";
		} else if (events.list.get(player.getUniqueId()) < 40 && events.list.get(player.getUniqueId()) >= 10) {
			return "Intense thirst";
		} else if (events.list.get(player.getUniqueId()) < 10) {
			return "Drink urgently!";
		}
	}
	if(identifier.equals("indicator1")) {
		if (events.list.get(player.getUniqueId()) > 100) {
			return ChatColor.BLUE + "--------------------";
		} else if (events.list.get(player.getUniqueId()) <= 0) {
			return ChatColor.DARK_RED + "--------------------";
		} else if (events.list.get(player.getUniqueId()) <= 19) {
			return getProgressBar(events.list.get(player.getUniqueId()), 100, 20, '-', '-', ChatColor.RED, ChatColor.DARK_GRAY);
		} else {
			return getProgressBar(events.list.get(player.getUniqueId()), 100, 20, '-', '-', ChatColor.AQUA, ChatColor.DARK_GRAY);
		}
	}
	if(identifier.equals("indicator2")) {
		if (events.list.get(player.getUniqueId()) > 100) {
			return ChatColor.BLUE + "####################";
		} else if (events.list.get(player.getUniqueId()) <= 0) {
			return ChatColor.DARK_RED + "--------------------";
		} else if (events.list.get(player.getUniqueId()) <= 19) {
			return getProgressBar(events.list.get(player.getUniqueId()), 100, 20, '#', '-', ChatColor.RED, ChatColor.DARK_GRAY);
		} else {
			return getProgressBar(events.list.get(player.getUniqueId()), 100, 20, '#', '-', ChatColor.AQUA, ChatColor.DARK_GRAY);
		}
	}

	return null;
}
public String getProgressBar(int current, int max, int totalBars, char symbol1, char symbol2, ChatColor completedColor,
							 ChatColor notCompletedColor) {
	float percent = (float) current / max;
	int progressBars = (int) (totalBars * percent);

	return Strings.repeat("" + completedColor + symbol1, progressBars)
			+ Strings.repeat("" + notCompletedColor + symbol2, totalBars - progressBars);
}
}