package me.momo.tgz.life.events;

import me.momo.tgz.life.job.Job;
import me.momo.tgz.life.job.JobManager;
import me.momo.tgz.life.job.JobWandLocation;
import me.momo.tgz.life.job.Worker;
import me.momo.tgz.life.job.WorkerManager;
import me.momo.tgz.life.util.Messages;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		Action a = e.getAction();
		Player p = e.getPlayer();
		if (a == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (b.getState() instanceof Sign) {
				Sign s = (Sign) b.getState();
				if (s.getLine(0).contains("§lJob")) {
					if (JobManager.getJob(s.getLine(1)) != null) {
						Job j = JobManager.getJob(s.getLine(1));
						if (WorkerManager.getWorker(p.getName()) != null) {
							Worker w = WorkerManager.getWorker(p.getName());
							if (w.getJob().getName() == j.getName()) {
								if (!w.hasWorked()) {
									p.teleport(j.getSpawn());
									w.setWorked(true);
								}else{
									p.sendMessage(Messages.JOB_JOIN_ERR_WORKED);
								}
							}else{
								//Changed job
								if (!w.hasWorked()) {
									p.sendMessage(Messages.JOB_JOIN_INFO_CHANGE);
									w.setJob(j);
									p.teleport(j.getSpawn());
									w.setWorked(true);
								}else{
									p.sendMessage(Messages.JOB_JOIN_ERR_WORKED);
								}
								
							}
						}else{
							
							Worker wo = new Worker(p.getName(), j);
							wo.setWorked(true);
							WorkerManager.getWorkers().add(wo);
							p.teleport(wo.getJob().getSpawn());
							
						}
					}else{
						p.sendMessage(Messages.JOB_JOIN_ERR_EXIST);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void signJobCreate(SignChangeEvent e) {
		Player p = e.getPlayer();
		Sign s = (Sign)e.getBlock().getState();
		
		e.getBlock().getState().update();
		s.update();
		if (e.getLine(0).contains("[JobSign]")){
			if (JobManager.getJob(e.getLine(1)) != null) {
				e.setLine(0, null);
				e.setLine(0, "§lJob");
				e.setLine(3, "Click to join");
				e.getBlock().getState().update();
			}else{
				p.sendMessage(Messages.JOB_JOIN_ERR_EXIST);
			}
		}
		
		
	}
	
	@EventHandler
	public void onJobWandClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if (a == Action.LEFT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (p.getItemInHand() != null) {
				ItemStack i = p.getItemInHand();
				ItemMeta m = i.getItemMeta();
				if (i.getType() == Material.GOLD_AXE) {
					if (m.getDisplayName().contains("Job Wand")) {
						if (!JobManager.getWandStorage().containsKey(p.getName())){
							JobManager.getWandStorage().put(p.getName(), new JobWandLocation(null, null));
							
						}
						
						JobManager.getWandStorage().get(p.getName()).setP1(b.getLocation());
						e.setCancelled(true);
						p.sendMessage(Messages.JOB_REGION_POS1);
					}
				}
			}
		}
		if (a == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (p.getItemInHand() != null) {
				ItemStack i = p.getItemInHand();
				ItemMeta m = i.getItemMeta();
				if (i.getType() == Material.GOLD_AXE) {
					if (m.getDisplayName().contains("Job Wand")) {
						if (!JobManager.getWandStorage().containsKey(p.getName())){
							JobManager.getWandStorage().put(p.getName(), new JobWandLocation(null, null));
							
						}
						
						JobManager.getWandStorage().get(p.getName()).setP2(b.getLocation());
						e.setCancelled(true);
						p.sendMessage(Messages.JOB_REGION_POS2);
					}
				}
			}
		}
	}
	
}
