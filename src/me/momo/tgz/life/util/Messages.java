package me.momo.tgz.life.util;

public class Messages {
	// Main
	public static String PREFIX = "§aLife§2>§r  ";
	
	
	//Job
	public static String JOB_ERR_COMMAND = PREFIX + "§cUnknown command. Type \"/job\" for help!";
	
	public static String JOB_CREATE_DESC = "Creates a job from the two points you have set.";
	public static String JOB_CREATE_ERR_NOPOINTS = PREFIX + "§cPlease select points with a wand first!";
	public static String JOB_CREATE_ERR_EXISTS = PREFIX + "§cThat job already exists!";
	public static String JOB_CREATE_SUCCESS = PREFIX + "§aJob created!";
	public static String JOB_CREATE_ERR_TYPE = PREFIX + "§cUnknown type of job! Do /job for help.";
	public static String JOB_CREATE_ERR_POINTS_NOTSAMEWORLD = PREFIX + "§cYour points are not in the same world!";
	public static String JOB_CREATE_ERR_POINTS_EXIST = PREFIX + "§cPlease select two points with your wand first!";
	public static String JOB_CREATE_ERR_FORMAT = PREFIX + "§cWrong format usage. Type \"/job\" for help.";
	
	public static String JOB_DELETE_DESC = "Deletes a job you have set.";
	public static String JOB_DELETE_SUCCESS = PREFIX + "§aDeleted job.";
	public static String JOB_DELETE_ERR_NONAME = PREFIX + "§cWrong format usage. Type \"/job\" for help.";
	public static String JOB_DELETE_ERR_EXIST = PREFIX + "§cThat job does not exist.";
	
	public static String JOB_WAND_DESC = "Gives you a wand to set the two points for a job.";
	public static String JOB_WAND_RECIEVE_SUCCESS = PREFIX + "§6 You recieved a §lJob Wand§r§6.";
	
	public static String JOB_SETSPAWN_DESC = "Sets the spawn of a job.";
	public static String JOB_SETSPAWN_SUCCESS = PREFIX + "§aChanged spawn location.";
	public static String JOB_SETSPAWN_ERR_NONAME = PREFIX + "§cWrong format usage. Type \"/job\" for help.";
	public static String JOB_SETSPAWN_ERR_EXIST = PREFIX + "§cThat job does not exist.";
	
	public static String JOB_LIST_DESC = "Lists all created jobs.";
	public static String JOB_LIST_ERR_NOJOB = PREFIX + "§cNo jobs available.";
	
	public static String JOB_INFO_DESC = "Shows info about a job.";
	public static String JOB_INFO_ERR_FORMAT = PREFIX + "§cWrong format usage. Type \"/job\" for help.";
	public static String JOB_INFO_ERR_EXIST = PREFIX + "§cThat job does not exist.";
	
	public static String JOB_JOIN_INFO_WORK = PREFIX + "§aA new day has come, time to go work!";
	public static String JOB_JOIN_INFO_CHANGE = PREFIX + "§aYou changed your job!";
	public static String JOB_JOIN_ERR_WORKED = PREFIX + "§cYou can only go work once a day!";
	public static String JOB_JOIN_ERR_EXIST = PREFIX + "§cThat job does not exist!";
	
	
	public static String JOB_REGION_POS1 = PREFIX + "§6Position 1 set.";
	public static String JOB_REGION_POS2 = PREFIX + "§6Position 2 set.";
	
}
