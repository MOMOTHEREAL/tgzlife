package me.momo.tgz.life.job;

import java.util.ArrayList;
import java.util.List;

public class WorkerManager {
	private static List<Worker> workers = new ArrayList<Worker>();

	public static List<Worker> getWorkers() {
		return workers;
	}

	public static void setWorkers(List<Worker> workers) {
		WorkerManager.workers = workers;
	}
	
	public static Worker getJob(String name) {
		for (Worker worker : getWorkers()) {
			if (worker.getName().equalsIgnoreCase(name)) {
				return worker;
			}
		}
		return null;
	}
	
}
