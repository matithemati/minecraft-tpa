package com.mati.tpa;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("TPA plugin enabled!");
		getCommand("tpa").setExecutor(new tpa());
	}

}
