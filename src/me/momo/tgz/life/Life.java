package me.momo.tgz.life;

import me.momo.tgz.life.job.JobCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Life extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("job").setExecutor(new JobCommand());
	}
	
	@Override
	public void onDisable() {
		
	}
}
