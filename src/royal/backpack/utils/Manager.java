package royal.backpack.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import royal.backpack.utils.Config;

public class Manager {
	public static void openChest(Player player) {
	    Inventory inventory = Bukkit.createInventory(null, 54, Utils.colorize("&c" + player.getName() + "'s &bBackpack"));
	    if (Config.db.getString("Users." + player.getUniqueId()) != null) {
	      for (String i : Config.db.getConfigurationSection("BackPack." + player.getUniqueId()).getKeys(false)) {
	        inventory.setItem(Integer.parseInt(i), Config.db.getConfigurationSection("Users." + player.getUniqueId()).getItemStack(i));
	      }
	    }
	    player.openInventory(inventory);
	  }
	  
	  public static void saveChest(InventoryView e, Player p) {
	    if (e.getTitle().contains(Utils.colorize("&bBackpack"))) {
	      Config.db.createSection("Users." + p.getUniqueId());
	      Config.loadCfg();
	      for (int i = 0; i < 54; i++) {
	        ItemStack is = e.getTopInventory().getItem(i);
	        Config.db.set("BackPack." + p.getUniqueId() + "." + i, is);
	        Config.loadCfg();
	      } 
	    } 
	  }
	  
	  public static void iniChest() {
	    ItemStack ink = new ItemStack(Material.INK_SAC);
	    ItemMeta meta = ink.getItemMeta();
	    meta.setDisplayName(Utils.colorize("&bBackpack"));
	    meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
	    ink.setItemMeta(meta);
	    @SuppressWarnings("deprecation")
		ShapedRecipe BackPack = new ShapedRecipe(ink);
	    BackPack.shape(new String[] { "OOO", "OIO", "OCO" }).setIngredient('C', Material.CHEST).setIngredient('I', Material.INK_SAC);
	    Bukkit.getServer().addRecipe(BackPack);
	  }
}
