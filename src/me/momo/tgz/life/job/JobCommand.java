package me.momo.tgz.life.job;

import me.momo.tgz.life.util.Messages;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JobCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

		if (!(args.length > 0)) {
			s.sendMessage(Messages.PREFIX + "§3§lJob Help");
			s.sendMessage("§8§l>§r§e /job create §3<name> <cop:normal:criminal> <level> §4-§6 " + Messages.JOB_CREATE_DESC);
			s.sendMessage("§8§l>§r§e /job delete §3<name> §4-§6 " + Messages.JOB_DELETE_DESC);
			s.sendMessage("§8§l>§r§e /job info §3<name> §4-§6 " + Messages.JOB_INFO_DESC);
			s.sendMessage("§8§l>§r§e /job wand §4-§6 " + Messages.JOB_WAND_DESC);
			s.sendMessage("§8§l>§r§e /job list §4-§6 " + Messages.JOB_LIST_DESC);
			s.sendMessage("§8§l>§r§e /job setspawn §3<name> §4-§6 " + Messages.JOB_SETSPAWN_DESC);
		} else {
			String c = args[0];
			if (c.equalsIgnoreCase("create")) {
				if (args.length >= 4) {
					String name = args[1];
					String type = args[2];
					int level = Integer.parseInt(args[3]);
					Player p = (Player)s;
					Job job = JobManager.getJob(name);
					if (job == null) {
						if (JobManager.getWandStorage().containsKey(s.getName())) {
							JobWandLocation wand = JobManager.getWandStorage().get(s.getName());
							if (wand.getP1() != null && wand.getP2() != null) {
								if (wand.getP1().getWorld().getName() == wand.getP2().getWorld().getName()) {
									if (JobType.contains(type.toUpperCase())) {
										Job jb = new Job(name, JobType.valueOf(type.toUpperCase()), s.getName(), level, wand.getP1(), wand.getP2(), p.getLocation());
										JobManager.getJobs().add(jb);
										s.sendMessage(Messages.JOB_CREATE_SUCCESS);
									} else {
										s.sendMessage(Messages.JOB_CREATE_ERR_TYPE);
									}
								} else {
									s.sendMessage(Messages.JOB_CREATE_ERR_POINTS_NOTSAMEWORLD);
								}
							} else {
								s.sendMessage(Messages.JOB_CREATE_ERR_POINTS_EXIST);
							}
						} else {
							s.sendMessage(Messages.JOB_CREATE_ERR_POINTS_EXIST);
						}
					} else {
						s.sendMessage(Messages.JOB_CREATE_ERR_EXISTS);
					}

				} else {
					s.sendMessage(Messages.JOB_CREATE_ERR_FORMAT);
				}
			} else if (c.equalsIgnoreCase("delete")) {
				
			} else if (c.equalsIgnoreCase("wand")) {
				ItemStack item = new ItemStack(Material.GOLD_AXE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§r§6Job Wand");
				item.setItemMeta(meta);
				Player p = (Player) s;
				p.getInventory().addItem(item);
				s.sendMessage(Messages.JOB_WAND_RECIEVE_SUCCESS);
			}
			else if (c.equalsIgnoreCase("info")) {
				
			}
			else if (c.equalsIgnoreCase("list")) {
				
			}
			else if (c.equalsIgnoreCase("setspawn")) {
				
			}

			else {
				s.sendMessage(Messages.JOB_ERR_COMMAND);
			}
		}

		return false;
	}

}
