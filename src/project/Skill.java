package project;

import java.io.Serializable;

/**
 * This class creates Skill object which will be added to all instances of Player class created
 * These objects will also be contained within DevelopmentPlan creations - to a lesser extent (up to 3) - which will be assigned to Players also
 * 
 * @author Keir
 * @since 16/03/21
 * 
 */
public class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int rating;
	private int maxRating = 10;
	private int target;
	
	
	/**
	 * Default constructor -- sets the skill name
	 * @param String (name)
	 */
	public Skill(String name) {
		this.name = name;
	}
	
	/**
	 * Overloaded constructor -- if the User wishes to assign a rating with the skill
	 * @param String (name)
	 * @param int (rating)
	 */
	public Skill(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}
	
	// Getters and Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void setTarget(int target) {
		this.target = target;
	}
	
	/**
	 * Increase players' skill rating (max 10.0)
	 * 
	 * @param int value
	 */
	public void increaseRating(int value) {
		this.rating += value;
		
		// If the added value exceeds the max rating, take it back to max rating
		if (this.rating > 10) {
			this.rating = 10;
		}
	}
	
	/**
	 * Decrease players' skill rating (min 0.0)
	 * 
	 * @param int value
	 */
	public void decreaseRating(int value) {
		this.rating -= value;
		
		// If the added value goes below the min rating, take it back to min rating
		if (this.rating < 0) {
			this.rating = 0;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getRating() {
		return rating;
	}
	
	public int getTarget() {
		return target;
	}
	
	/**
	 * Returns current players assigned skill object rating out of the maximum
	 * 
	 * @return String
	 */
	public String getProgress() {
		return rating + "/" + maxRating;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return getName();
	}
}
