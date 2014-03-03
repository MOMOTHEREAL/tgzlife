package me.momo.tgz.life.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobManager {
	private static List<Job> jobs = new ArrayList<Job>();
	private static Map<String, JobWandLocation> wandStorage = new HashMap<String, JobWandLocation>();
	

	public static List<Job> getJobs() {
		return jobs;
	}

	public static void setJobs(List<Job> jobs) {
		JobManager.jobs = jobs;
	}

	public static Job getJob(String name) {
		for (Job job : getJobs()) {
			if (job.getName().equalsIgnoreCase(name)) {
				return job;
			}
		}
		return null;
	}

	public static Map<String, JobWandLocation> getWandStorage() {
		return wandStorage;
	}

	public static void setWandStorage(Map<String, JobWandLocation> wandStorage) {
		JobManager.wandStorage = wandStorage;
	}
	
	
}
