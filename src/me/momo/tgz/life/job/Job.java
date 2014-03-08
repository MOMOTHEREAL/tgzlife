package me.momo.tgz.life.job;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class Job {
	private JobType type;
	private String name;
	private String creator;
	private int minLevel;
	private Location p1;
	private Location p2;
	private Location spawn;
	private String description;
	
	public Job(String name, JobType type, String creator, int minLevel, Location p1, Location p2, Location spawn, String description){
		this.name = name;
		this.type = type;
		this.creator = creator;
		this.minLevel = minLevel;
		this.p1 = p1;
		this.p2 = p2;
		this.spawn = spawn;
		this.description = description;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}
	
	public Location getP1() {
		return p1;
	}

	public void setP1(Location p1) {
		this.p1 = p1;
	}

	public Location getP2() {
		return p2;
	}

	public void setP2(Location p2) {
		this.p2 = p2;
	}

	public Location getSpawn() {
		return spawn;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
}
