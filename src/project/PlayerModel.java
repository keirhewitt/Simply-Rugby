package project;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;

/**
 * Model class for handling all data related to players
 * 
 * This data will be accessed via the Controller->Model->this
 * 
 * This class will help spread out the code so that the Model and Controller are not too crowded
 *  
 * @author Keir
 * @since 04/04/21
 * 
 */
public class PlayerModel {
	
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	/**
	 * Initialised in the Model, the playerList will be created
	 */
	public PlayerModel() {
		playerList = new ArrayList<Player>();
	}
	
	/**
	 * Takes the squad passed through as a parameter and returns an array of Player object who match the squad
	 * 
	 * @param Squad
	 * @return Player[]
	 *  
	 */
	public Player[] getPlayers(Squad squad) {
		
		// Init the players array of length (getPlayersLength) -- with the current squad passed through
		Player[] players = new Player[getPlayersLength(squad)];
		
		int index = 0;
		
		/*
		 	Implement try catch, to catch the error if the array tries to add a null value if the num of players < 28
		 */
		try {
			Iterator<Player> it = playerList.iterator();
			
			while (it.hasNext() == true) {
				Player p = it.next();
				
				if (p != null) {
					
					/*
					 	If the squad names are equal, add to the array at the index mark
					 */
					if(p.getSquad().getName().equals(squad.getName()))
					{
						/*
						 	Do not include the N/A option - who's age will always be 0
						 */
						if (p.getAge() != 0) {
							/*
						 		Add to array, increment the index + 1
							 */
								players[index] = p;
								index += 1;
						}
						
					}
				}
				
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return players;
		
	}
	
	/**
	 * Gets the length of the playerList of a particular Squad
	 * 
	 * @param Squad
	 * 
	 * @return int value of number of Player obj in playerList who's squad is the same as the param.
	 */
	public int getPlayersLength(Squad squad) {
		int length = 0;
		
		if (playerList.isEmpty()) {
			length = 0;
		} else {
			
			for (Player p: playerList) {
				if (p.getSquad().getName().equals(squad.getName())) {
					length += 1;
				}
			}
			
		}
		return length;
	}
	
	/**
	 * This method takes an arraylist of String elements and converts them to a DefaultListModel<String>
	 * 
	 * @param issues
	 * @return DefaultListModel<String>
	 */
	public DefaultListModel<String> transferHealthIssues(ArrayList<String> issues) {
		
		/*
		 	Init a new DefaultListModel<String>
		 */
		DefaultListModel<String> li = new DefaultListModel<String>();
		
		/*
		 	Iterate over parameter ArrayList
		 */
		Iterator<String> it = issues.iterator();
				
			while (it.hasNext() == true) {
				
				String i = it.next();
				
				/*
				 	Add all non-null String elems from the issues ArrayList
				 */
				if (i != null) {
					li.addElement(i);
				}
			}
			
		return li;
	}
	
	/**
	 * Returns all Skill objects within a Player obj
	 * 
	 * @param Player
	 * @return Skill[]
	 */
	public Skill[] returnPlayerSkills(Player p) {
		Skill[] skills = new Skill[p.getSkillList().size()];
		
		for (int i = 0; i < p.getSkillList().size(); i++) {
			if (p.getSkillList().get(i) != null) {
				skills[i] = p.getSkillList().get(i);
			}
		}
		
		return skills;
	}
	
	/**
	 * When creating a DevelopmentPlan, this function ensures that targets chosen for Skills are of larger value than the Players current rating
	 * 
	 * i.e. The Player will not want to set a target that they have already achieved or is lower than their skill rating
	 * 
	 * @param Player p
	 * @param Skill s
	 * @param int rating
	 * @return boolean
	 */
	public boolean validatePlanSkillRating(Player p, Skill s, int rating) {
		boolean valid = true;
		
		/*
		 	Loop through each Skill element in the Players skill_list
		 */
		for (Skill skill: p.getSkillList()) {
			
			/*
			 	If the application finds the same Skill, check if the rating is less than or equal to the target
			 */
			if (skill.getName().equals(s.getName())) {
				
				if (rating <= skill.getRating()) {
					valid = false;
				}
			}
		}
		
		return valid;
	}
	
	/**
	 * Add player to the playerList
	 * 
	 * @param Player p
	 */
	public void addPlayer(Player p) {
		playerList.add(p);
	}
	
	/**
	 * Return the arraylist of Players
	 * 
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> getPlayers() {
		return playerList;
	}
	
	/**
	 * Set the playerList as a new arraylist
	 * 
	 * @param ArrayList<Player> arr
	 */
	public void setPlayerList(ArrayList<Player> arr) {
		playerList = arr;
	}
	
	/**
	 * Remove given Player from the playerList if SRU's match (Unqiue)
	 * 
	 * @param Player p
	 */
	public void removePlayer(Player p) {
		
		for (int i = 0; i < playerList.size(); i++) {

			if (playerList.get(i).getSRU().equals(p.getSRU())) {
				playerList.remove(i);
			}
		}
		
	}
	
	/**
	 * Returns a boolean value depending on whether the given parameter is contained within the playerList
	 * 
	 * @param Player p
	 * @return boolean value, if 'play' element's SRU == 'p' parameter's SRU, exist will return true since SRU is a unique value
	 */
	public boolean playerExists(Player p) {
		boolean exist = false;
		for (Player play: playerList) {
			if (play.getSRU() == p.getSRU()) {
				exist = true;
			}
		}
		return exist;
	}
}
