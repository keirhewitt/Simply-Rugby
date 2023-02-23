package project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * The DevelopmentPlan is a collection of skills put together into a cohesive plan
 * These plans include:
 * 	-- start date - 'dateApplied'
 *  -- end date - 'projectedDate'
 *  -- skill list = 'skills'
 *  
 *  These objects will be created and assigned to individual Player objects
 *  
 * @author Keir
 * @since 18/04/21
 */
public class DevelopmentPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Skill> skills = new ArrayList<Skill>();
	
	// Code for formatting the dates neatly .. 
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    Date date = new Date();  
    String dateToday = formatter.format(date);  
	
    // Dates for when the plan was created (today) and when it should conclude
	private String dateApplied;
	private String projectedDate;
	
	/**
	 * Overloaded constructor - dateApplied auto completes on initialisation, skills arraylist begins empty
	 * 
	 * @param String (projectedDate)
	 */
	public DevelopmentPlan(String projectedDate) {
		skills = new ArrayList<Skill>();
		this.dateApplied = dateToday;
		this.projectedDate = projectedDate;
	}
	
	// Getters and Setters
	/**
	 * Add a skill and a target value / 100
	 * 
	 * @param Skill s
	 * @param int target
	 */
	public void addSkill(Skill s, int target) {
		if(skills.size() > 2) {
			System.out.println("Plan already has the maximum amount of skills!");
		} else {
			s.setTarget(target);
			skills.add(s);
		}
	}
	
	/**
	 * Boolean response to whether specific index check on skills list returns element or not
	 * 
	 * @param index
	 * @return boolean 'has'
	 */ 
	public boolean hasSkill(int index) {
		boolean has = false;
		
		// Implement try catch for indexOutOfBounds so that if the exception appears, it means that there is no 
		// ... element to access at that index, so set 'has' to false
		try {
			
			// If program can access the index and isn't null, set has to true
			if(skills.get(index) != null) {
				has = true;
			}
			
		// When the function catches indexOutOfBounds exc. - set 'has' to false, since there is no element to retrieve
		} catch (IndexOutOfBoundsException e) {
			has = false;
		}
		return has;
	}
	
	/**
	 * Get the skill target for a specific index
	 * 
	 * @param int (index) -- to get the specific skill
	 * @return int (target)
	 */
	public int getSkillTarget(int index) {
		return skills.get(index).getTarget();
	}
	
	/**
	 * Uses the Skill class to set the target for a skill within this DevelopmentPlan
	 * 
	 * @param Skill 's'
	 * @param int -- val, get the specified Skill objects value
	 */
	public void setSkillTarget(Skill s, int val) {
		
		Iterator<Skill> it = skills.iterator();
		
		while(it.hasNext() == true) {
			Skill currSkill = it.next();
			
			/*
			 	If the iterator obj matches the parameter, set the target as the 'val' parameter
			 */
			if (currSkill == s) {
				currSkill.setTarget(val);
			}
		}
	}
	
	/**
	 * Returns the skill from a certain index
	 * 
	 * @param index -- get the skill using index
	 * @return Skill - returns the Skill object to the user
	 */
	public Skill getSkillIndex(int index) {
		Skill s = null;
		try  {
			s = skills.get(index);
		} catch (NullPointerException e) {
			System.out.println("Cannot get the skill from the list.");
		}
		return s;
	}
	
	/**
	 * Removes a skill from the arraylist using an iterator method
	 * 
	 * @param Skill 's'
	 */
	public void removeSkill(Skill s) {
		
		/*
		 	Init variable to check if skill exists in list
		 */
		boolean skillFound = false;
		
		Iterator<Skill> it = skills.iterator();
		
		while (it.hasNext() == true) {
			
			Skill currSkill = it.next();
			
			/*
			 	If the current iterator obj is equal to the parameter, remove it
			 */
			if (currSkill == s) {
				
				skillFound = true;
				it.remove();
				System.out.println(s.getName() + " skill removed.");
			}	
		}
		
		/*
		 	Print message if not in list
		 */
		if(skillFound == false) {
			System.out.println("Skill not found in development plan.");
		}
	}
	
	/**
	 * Displays all skills in the development plan skills arraylist
	 */
	public void getSkills() {
	
		/*
		 	If there are skills in the plan, display their names
		 */
		if(!skills.isEmpty()) {
		
			System.out.println("This development plan contains: ");
			
			Iterator<Skill> it = skills.iterator();
			
			
			while (it.hasNext() == true) {
				Skill currSkill = it.next();
				
				if (currSkill != null) {
					
					/*
					 	Print out each skill name to the console
					 */
					System.out.println(currSkill.getName());
					
				}
			}
			
		/*
		 	If not.. 	
		 */
		} else {
			System.out.println("This development plan is currently empty.");
		}
	}
	
	/**
	 * ALWAYS call this method before creating the overloaded constructor
	 * Makes sure that there are only 3 skills inside the list
	 * Then the user may pass their skill list through the constructor and create an object
	 * 
	 * @param Skill[] -- array of the Skill objects
	 * @return boolean
	 */
	public boolean applicableSkillSet(Skill skill[]) {
		boolean applicable = false;
		if (skill.length < 4) {
			applicable = true;
		}
		return applicable;
	}
	
	// Getters and setters for dates
	public String getDateStarted() {
		return dateApplied;
	}
	
	/**
	 * Returns the date which the DevelopmentPlan has been scheduled to conclude
	 * 
	 * @return String
	 */
	public String getDateEnd() {
		return projectedDate;
	}
	
	/**
	 * Set the end date for the plan
	 * 
	 * @param String (date)
	 */
	public void setDateEnd(String date) {
		projectedDate = date;
	}
	
	
}

