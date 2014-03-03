package me.momo.tgz.life.job;

import org.bukkit.Location;

public class Job {
	private JobType type;
	private String name;
	private String creator;
	private int minLevel;
	private Location p1;
	private Location p2;
	
	public Job(String name, JobType type, String creator, int minLevel, Location p1, Location p2){
		this.name = name;
		this.type = type;
		this.creator = creator;
		this.minLevel = minLevel;
		this.p1 = p1;
		this.p2 = p2;
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
	
	
	
	
	
	
}
