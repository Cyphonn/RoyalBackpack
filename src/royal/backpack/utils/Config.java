package royal.backpack.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import royal.backpack.Main;

public class Config {
	  public static File data = new File("plugins//" + Main.plugin.getDescription().getName() + "//data.yml");
	  public static FileConfiguration db = YamlConfiguration.loadConfiguration(data);
	  
	  public static void makeCfg() {
		  if(!data.exists()) {
			  db.createSection("Users");
		  }
	  }
	  public static void loadCfg() {
		  try {
			  db.save(data);
			  db.load(data);
		  }catch(IOException|org.bukkit.configuration.InvalidConfigurationException e) {
			  e.printStackTrace();
		  }
	  }
}
