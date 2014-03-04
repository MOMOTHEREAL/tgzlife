package me.momo.tgz.life.events;

import me.momo.tgz.life.job.JobManager;
import me.momo.tgz.life.job.JobWandLocation;
import me.momo.tgz.life.util.Messages;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractListener implements Listener {
	
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
