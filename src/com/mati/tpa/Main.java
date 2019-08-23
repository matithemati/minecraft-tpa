package com.mati.tpa;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getCommand("tpa").setExecutor(new Tpa());
		getCommand("tpal").setExecutor(new Loc());

	}
}
