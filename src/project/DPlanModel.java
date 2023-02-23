package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JRadioButton;

/**
 * This class is useful for handling DevelopmentPlan related data
 * 
 * It will perform the arithmetic logic for getting target data when the user is creating a development plan
 * It will also consolidate all the necessary data for creating a DevelopmentPlan, then create one
 * 
 * @author Keir
 * @since 14/04/21
 */
public class DPlanModel {
	
	/**
	 * Returns true or false depending on if a radio button has been selected in a group
	 * 
	 * @param ArrayList<JRadioButton> JRB
	 * @return boolean
	 */
	public boolean targetSet(ArrayList<JRadioButton> JRB) {
		
		boolean set = false;
		
		int count = JRB.size();
		
		for(int i = 0; i < count; i++) {
			
			/*
			 	If an index in the arraylist has been selected
			 */
			if (JRB.get(i).isSelected()) {
				set = true;
			}
		}
		return set;
	}
	
	/**
	 * Gets the radio button from the group, parses the text as an integer, returns it
	 * 
	 * @param JRB (ArrayList<JRadioButton>)
	 * @return integer
	 */
	public int setSkillTarget1(ArrayList<JRadioButton> JRB) {
		
		int val1 = 0;
		
		int count  = JRB.size();
		
		for (int i = 0; i < count; i++) {
			if (JRB.get(i).isSelected()) {
				val1 = Integer.parseInt(JRB.get(i).getText());
			}
		}
		
		return val1;
	}
	
	/**
	 * Takes the hashmap input and adds the Skill/rating pairs to the newly created DevelopmentPlan for the 'p' Player
	 * The date parameter is used for the DevelopmentPlan constructor
	 * Checks Player object for a plan -- if the plan is found, return true, false if not.
	 * 
	 * @param p - Player
	 * @param skills - HashMap
	 * @param date - String
	 * @return boolean 
	 */
	public boolean createPlan(Player p, HashMap<Skill, Integer> skills, String date) {
		boolean createdPlan = false;
		
		/*
		 	Create the DevelopmentPlan
		 */
		DevelopmentPlan DP = new DevelopmentPlan(date);
		
		/*
		  	Iterate over hashmap of skills and targets and add to the DP object
		 */
		Iterator<Entry<Skill, Integer>> it = skills.entrySet().iterator();
		while(it.hasNext()) {
			
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)it.next();
			DP.addSkill((Skill)pair.getKey(), (Integer)pair.getValue());
			
		}
		
		/*
		 	Checks if user has development plan created
		 */
		if (p.hasDevelopmentPlan()) {
			
			createdPlan = false;
		} else {
			p.setDevelopmentPlan(DP);
			createdPlan = true;
		}
		
		return createdPlan;
	}
	
	/**
	 * Get a Skill from a Player object
	 * 
	 * @param Skill s
	 * @param Player p
	 * @return Skill
	 */
	public Skill getSkillFromPlayerObj(Skill s, Player p) {
		
		int index = 0;
		
		Iterator<Skill> sk = p.getSkillList().iterator();
		
		while (sk.hasNext() == true) {
			if (sk == s) {
				index = p.getSkillList().indexOf((Skill)sk);
			}
		}
		
		return  p.getSkillList().get(index);	
	}
}


