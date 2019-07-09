package royal.backpack.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import royal.backpack.utils.Manager;
import royal.backpack.utils.Utils;

public class CMDBackpack implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("royal.backpack")) {
				Manager.openChest(p);
			}else {
				p.sendMessage(Utils.colorize("&c» &7You do not have permission for this command,"));
			}
		}else {
			sender.sendMessage("You can't open a backpack :(");
		}
		return false;
	}
}
