package me.momo.tgz.life.util;

public class Messages {
	// Main
	public static String PREFIX = "�aLife�2>�r ";
	
	
	//Job
	public static String JOB_ERR_COMMAND = PREFIX + "�cUnknown command. Type \"/job\" for help!";
	
	public static String JOB_CREATE_DESC = "Creates a job region from the two points you have set.";
	public static String JOB_CREATE_ERR_NOPOINTS = PREFIX + "�cPlease select points with a wand first!";
	public static String JOB_CREATE_ERR_EXISTS = PREFIX + "�cThat job already exists!";
	public static String JOB_CREATE_SUCCESS = PREFIX + "�aJob created!";
	public static String JOB_CREATE_ERR_TYPE = PREFIX + "�cUnknown type of job! Do /job for help.";
	public static String JOB_CREATE_ERR_POINTS_NOTSAMEWORLD = PREFIX + "�cYour points are not in the same world!";
	public static String JOB_CREATE_ERR_POINTS_EXIST = PREFIX + "�cPlease select two points with your wand first!";
	public static String JOB_CREATE_ERR_EXIST = PREFIX + "�cThis region already exists.";
	
	public static String JOB_DELETE_DESC = "Deletes a job you have set.";
	
	public static String JOB_WAND_DESC = "Gives you a wand to set the two points for a job region.";
	public static String JOB_WAND_RECIEVE_SUCCESS = PREFIX + "�6 You recieved a �lJob Wand�r�6.";
	
	public static String JOB_SETSPAWN_DESC = "Sets the spawn of a job.";
	
}