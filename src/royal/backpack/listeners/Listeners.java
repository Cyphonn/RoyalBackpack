package royal.backpack.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryView;

import royal.backpack.utils.Manager;
import royal.backpack.utils.Utils;

public class Listeners   implements Listener
{
	  @EventHandler
	  public void onInventoryClose(InventoryView event) {
		  Manager.saveChest(event, (Player)event.getPlayer()); 
		}


	  
	@SuppressWarnings("deprecation")
	@EventHandler
	  public void onInteract(PlayerInteractEvent event) {
	    if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && 
	      event.getPlayer().getInventory().getItemInMainHand() != null && 
	      event.getPlayer().getInventory().getItemInMainHand().getType() == Material.INK_SAC && 
	      event.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null && 
	      event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Utils.colorize("&bBackpack")) &&  event.getPlayer().hasPermission("royal.backpack")){
	          Manager.openChest(event.getPlayer());
	      }
	  }



	  
	  @EventHandler
	  public void onInventoryBuild(InventoryClickEvent event) {
	    if (event.getInventory().getType() == InventoryType.WORKBENCH && event.getCurrentItem() != null && 
	      event.getCurrentItem().getType() == Material.INK_SAC && 
	      event.getCurrentItem().getItemMeta().getDisplayName() != null && 
	      event.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.colorize("&bBackpack")) && 
	      !event.getWhoClicked().hasPermission("backpack"))
	      event.setCancelled(true); 
	  }
}
