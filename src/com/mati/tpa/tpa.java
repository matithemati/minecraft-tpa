package com.mati.tpa;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;


public class tpa implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {

			Player player = (Player) sender;
			Player target = (Bukkit.getServer().getPlayer(args[0]));
			if (target == null) {
				sender.sendMessage(ChatColor.BLUE + "[TPA] " + ChatColor.RED + args[0] + " jest offline!");
				return false;
			}

			else {
				Location loc = target.getLocation();
				player.sendMessage(ChatColor.BLUE + "[TPA] " + ChatColor.GREEN + "Pomy�lnie przeteleportowano do "
						+ ChatColor.YELLOW + target.getName());
				player.teleport(loc);
				target.sendMessage(ChatColor.BLUE + "[TPA] " + ChatColor.YELLOW + player.getName() + ChatColor.GREEN
						+ " w�a�nie si� do Ciebie przeteleportowa�!");
			}

		}

		else {
			System.out.println("Nie mo�esz u�y� tej komendy z poziomu konsoli!");
		}
		return false;
	}

}
