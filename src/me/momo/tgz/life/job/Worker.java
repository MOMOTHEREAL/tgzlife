package me.momo.tgz.life.job;

public class Worker {
	private String name;
	private Job job;
	private boolean worked = false;
	
	public Worker(String name, Job job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public boolean hasWorked() {
		return worked;
	}
	
	public void setWorked(boolean worked) {
		this.worked = worked;
	}
	
	
	
	
	
}
