package me.momo.tgz.life;

import me.momo.tgz.life.events.InteractListener;
import me.momo.tgz.life.job.JobCommand;
import me.momo.tgz.life.time.JobTime;

import org.bukkit.plugin.java.JavaPlugin;

public class Life extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new InteractListener(), this);
		getCommand("job").setExecutor(new JobCommand());
		JobTime jobtime = new JobTime(this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
	
}
