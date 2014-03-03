package me.momo.tgz.life.job;

public enum JobType {
	NORMAL,
	CRIMINAL,
	COP;
	
	public static boolean contains(String test) {

	    for (JobType c : JobType.values()) {
	        if (c.name().equals(test)) {
	            return true;
	        }
	    }

	    return false;
	}
}
