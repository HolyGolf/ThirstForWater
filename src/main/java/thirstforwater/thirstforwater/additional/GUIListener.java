package thirstforwater.thirstforwater.additional;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class GUIListener implements Listener {

@EventHandler
public void onClick(InventoryClickEvent e){
	if (!(e.getWhoClicked() instanceof Player)){
		return;
	}
	Player player = (Player) e.getWhoClicked();
	UUID playerUUID = player.getUniqueId();

	UUID inventoryUUID = GUI.openInventories.get(playerUUID);
	if (inventoryUUID != null){
		e.setCancelled(true);
		GUI gui = GUI.getInventoriesByUUID().get(inventoryUUID);
		GUI.GUIAction action = gui.getActions().get(e.getSlot());

		if (action != null){
			action.click(player);
		}
	}
}

}