package me.momo.tgz.life.time;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.momo.tgz.life.Life;
import me.momo.tgz.life.job.Worker;
import me.momo.tgz.life.job.WorkerManager;
import me.momo.tgz.life.util.Messages;

public class JobTime {
	private Life plugin;

	public JobTime(Life plugin) {
		this.plugin = plugin;
	}

	public void startTimer() {
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				for (World w : Bukkit.getServer().getWorlds()) {

					long time = w.getTime();
					if (time == 6000L) {
						for (Worker wo : WorkerManager.getWorkers()) {
							if (wo.hasWorked()) {
								wo.setWorked(false);
								if (Bukkit.getPlayer(wo.getName()) != null) {
									Player p = Bukkit.getPlayer(wo.getName());
									p.sendMessage(Messages.JOB_JOIN_INFO_WORK);
								}
							}
						}
					}

				}
			}
		}, 0L, 1L);
	}

}
