package royal.backpack.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;

import royal.backpack.Main;

public class Utils {
	Main core = new Main();
	
	public static void tell(CommandSender sender, String message) {
		sender.sendMessage(colorize(message));
	}

	public static boolean invCanFit(Inventory i) {
		return i.getContents().length < 36;
	}

	public static void tell(CommandSender sender, String... messages) {
		for (final String message : messages)
			sender.sendMessage(colorize(message));
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static void log(String message) {
		tell(Bukkit.getConsoleSender(), "[RoyalCore] " + message);
	}
}
