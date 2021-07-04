package com.github.professorSam.labySam.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.professorSam.labySam.main.Main;
import com.github.professorSam.labySam.utils.Utils;

public class LabyReload implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("labysam.reload")) {
				Main.getPlugin().reloadConfig();
				player.sendMessage(Utils.reloadSucess);
			}
			else
				player.sendMessage(Utils.noPerms);
		}
		return false;
	}
}
