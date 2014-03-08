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
			s.sendMessage("§8§l>§r§e /job create §3<name> <type cop:criminal:normal> <level (over 0)> <description> §4-§6 " + Messages.JOB_CREATE_DESC);
			s.sendMessage("§8§l>§r§e /job delete §3<name> §4-§6 " + Messages.JOB_DELETE_DESC);
			s.sendMessage("§8§l>§r§e /job info §3<name> §4-§6 " + Messages.JOB_INFO_DESC);
			s.sendMessage("§8§l>§r§e /job wand §4-§6 " + Messages.JOB_WAND_DESC);
			s.sendMessage("§8§l>§r§e /job list §4-§6 " + Messages.JOB_LIST_DESC);
			s.sendMessage("§8§l>§r§e /job setspawn §3<name> §4-§6 " + Messages.JOB_SETSPAWN_DESC);
		} else {
			String c = args[0];
			if (c.equalsIgnoreCase("create")) {
				if (args.length >= 5) {
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
										String description = "";
										int i = 0;
										for (String st : args) {
											if (i >= 4) {
												description = description + args[i] + " ";
											}
											i++;
										}
										Job jb = new Job(name, JobType.valueOf(type.toUpperCase()), s.getName(), level, wand.getP1(), wand.getP2(), p.getLocation(), description);
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
				if (args.length == 2) {
					String name = args[1];

					Job jb = JobManager.getJob(name);
					if (jb != null) {
						
						JobManager.getJobs().remove(jb);
						s.sendMessage(Messages.JOB_DELETE_SUCCESS);
						
					}
					else{
						s.sendMessage(Messages.JOB_DELETE_ERR_EXIST);
					}

				} else {
					s.sendMessage(Messages.JOB_DELETE_ERR_NONAME);
				}
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
				if (args.length == 2) {
					String n = args[1];
					Job jb = JobManager.getJob(n);
					if (jb != null) {
						String name = jb.getName();
						String type = "" + jb.getType();
						String level = "" + jb.getMinLevel();
						String p1 = "" + jb.getP1().getBlockX() + "," + jb.getP1().getBlockY() + "," + jb.getP1().getBlockZ() + ", world \"" + jb.getP1().getWorld().getName() + "\"";
						String p2 = "" + jb.getP2().getBlockX() + "," + jb.getP2().getBlockY() + "," + jb.getP2().getBlockZ() + ", world \"" + jb.getP2().getWorld().getName() + "\"";
						String creator = jb.getCreator();
						String spawn = "" + jb.getSpawn().getBlockX() + "," + jb.getSpawn().getBlockY() + "," + jb.getSpawn().getBlockZ() + ", world \"" + jb.getSpawn().getWorld().getName() + "\"";
						String description = jb.getDescription();
						
						s.sendMessage(Messages.PREFIX + "§3§lJob Information");
						s.sendMessage("§8§l>§r§e Name:  §b" + name);
						s.sendMessage("§8§l>§r§e Type:  §b" + type);
						s.sendMessage("§8§l>§r§e Min. Level:  §b" + level);
						s.sendMessage("§8§l>§r§e Coord #1:  §b" + p1);
						s.sendMessage("§8§l>§r§e Coord #2:  §b" + p2);
						s.sendMessage("§8§l>§r§e Creator:  §b" + creator);
						s.sendMessage("§8§l>§r§e Description:  §b" + description);
						s.sendMessage("§8§l>§r§e Spawnpoint:  §b" + spawn);
					}else{
						s.sendMessage(Messages.JOB_INFO_ERR_EXIST);
					}
				}else{
					s.sendMessage(Messages.JOB_INFO_ERR_FORMAT);
				}
			}
			else if (c.equalsIgnoreCase("list")) {
				if (JobManager.getJobs().size() > 0) {
					s.sendMessage(Messages.PREFIX + "§3§lJob List");
					for (Job jb : JobManager.getJobs()) {
						String name = jb.getName();
						s.sendMessage("§8§l>§r§e " + name);
					}
				}else{
					s.sendMessage(Messages.JOB_LIST_ERR_NOJOB);
				}
				
			}
			else if (c.equalsIgnoreCase("setspawn")) {
				if (args.length == 2) {
					Player p = (Player)s;
					String name = args[1];

					Job jb = JobManager.getJob(name);
					if (jb != null) {
						
						jb.setSpawn(p.getLocation());
						s.sendMessage(Messages.JOB_SETSPAWN_SUCCESS);
						
					}
					else{
						s.sendMessage(Messages.JOB_SETSPAWN_ERR_EXIST);
					}

				} else {
					s.sendMessage(Messages.JOB_SETSPAWN_ERR_NONAME);
				}
			}

			else {
				s.sendMessage(Messages.JOB_ERR_COMMAND);
			}
		}

		return false;
	}

}
