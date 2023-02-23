package project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class will be define the Training Sessions which the Coach users can organise
 * 
 * These objects will contain the list of Players participating, the squad and the date it will take place.
 * 
 * @author Keir
 * @since 29/03/21
 */
public class TrainingSession implements Serializable {

	private static final long serialVersionUID = 1L;

	// ArrayList will hold the players scheduled into the session
	private ArrayList<Player> participants = new ArrayList<Player>();
	
	// ArrayList holding the activities which the coach inputs
	private ArrayList<String> activities = new ArrayList<String>();
	
	private String date;
	private Squad squad;
	
	
	/**
	 * Default constructor 
	 * 
	 * @param String date
	 * @param Squad s
	 */
	public TrainingSession(String date, Squad s) {
		participants = new ArrayList<Player>();
		activities = new ArrayList<String>();
		this.date = date;
		this.squad = s;
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param String date
	 * @param Squad s
	 * @param ArrayList<Player> p
	 * @param ArrayList<Player> a
	 */
	public TrainingSession(String date, Squad s, ArrayList<Player> p, ArrayList<String> a) {
		this.date = date;
		participants = p;
		activities = a;
		this.squad = s;
	}
		
	
	// Getters and Setters
	public void addToSession(Player player) {
		participants.add(player);
	}
	
	/**
	 * Prints all participants
	 */
	public void getParticipants() {
		
		System.out.println();
		
		// Prints out each player - overrides toString method
		for (Player p: participants) {
			System.out.println(p);
		}
	}
	
	/**
	 * Prints out each String elem in activities consecutively (For JTable use)
	 * 
	 * @return String 
	 */
	public String getActivities() {
		String activitieslist = "";
		
		for (String a: activities) {
			activitieslist += a + ", ";
		}
		
		return activitieslist;
		
	}
	
	public ArrayList<String> returnActList() {
		return activities;
	}
	
	public ArrayList<Player> returnParticipantList() {
		return participants;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getSquad() {
		return squad.getName();
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Set the activities if user already has ArrayList
	 * 
	 * @param ArrayList<String>
	 */
	public void setActivities(ArrayList<String> act) {
		this.activities = act;
	}
	
	/**
	 * Set the participants if user already has ArrayList
	 * 
	 * @param ArrayList<Player>
	 */
	public void setParticipants(ArrayList<Player> play) {
		this.participants = play;
	}
}
