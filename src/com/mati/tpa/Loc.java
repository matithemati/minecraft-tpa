package com.mati.tpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Loc implements CommandExecutor {

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
				Location loc_target = target.getLocation();
				Location loc_sender = player.getLocation();

				if (loc_target.getWorld().getName() != loc_sender.getWorld().getName()) {

					String world = loc_target.getWorld().getName().toString();

					switch (world) {

					case "world_nether":
						world = "Piek³o";
						break;

					case "world_the_end":
						world = "Œwiat koñcowy";
						break;
						
					default:
						world = "Normalny œwiat";

					}

					sender.sendMessage(ChatColor.BLUE + "[TPA] " + ChatColor.RED + "Gracz jest na innej mapie - "+ ChatColor.YELLOW + world);
					return false;
				}

				int target_x = (int) loc_target.getBlockX();
				int target_y = (int) loc_target.getBlockY();
				int target_z = (int) loc_target.getBlockZ();

				int sender_x = (int) loc_sender.getBlockX();
				int sender_y = (int) loc_sender.getBlockY();
				int sender_z = (int) loc_sender.getBlockZ();

				int distance = (int) Math.sqrt(Math.pow((target_z - sender_z), 2) + Math.pow((target_y - sender_y), 2)
						+ Math.pow((target_x - sender_x), 2));

				sender.sendMessage(ChatColor.BLUE + "[TPA] " + ChatColor.GREEN + "Wspó³rzêdne " + ChatColor.YELLOW
						+ args[0] + ChatColor.GREEN + " to: " + ChatColor.YELLOW + target_x + ", " + target_y + ", "
						+ target_z + ChatColor.GREEN + ", czyli " + ChatColor.YELLOW + distance + ChatColor.GREEN
						+ " klocków od Ciebie.");

				return false;
			}

		}

		else {
			System.out.println("Nie mo¿esz u¿yæ tej komendy z poziomu konsoli!");
		}
		return false;
	}

}
