package royal.backpack;

import org.bukkit.plugin.java.JavaPlugin;

import royal.backpack.cmds.CMDBackpack;
import royal.backpack.listeners.Listeners;
import royal.backpack.utils.Config;
import royal.backpack.utils.Manager;
import royal.backpack.utils.Utils;

public class Main extends JavaPlugin{
	public static Main plugin;
	public String name = Utils.colorize("&bBackpack");
	public void onEnable() {
		plugin = this;
		Config.makeCfg();
		Manager.iniChest();
		getCommand("backpack").setExecutor(new CMDBackpack());
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	public void onDisable() {
		
	}
}
