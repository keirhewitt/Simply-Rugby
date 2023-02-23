package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Squad holds as many players as is set by the User
 * 
 * It has a 'team' arraylist inside it for storing those who have been chosen as a starting team member in the SelectTeam screen
 * 
 * @author Keir
 * @since 20/03/21 
 *
 */
public class Squad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Player> team = new ArrayList<Player>(); // The starting team, selected manually by Coach
	private String type;
	private String name; // Name identifier of the Squad
	private int limit;
	private Coach coach;
	private ArrayList<Player> player_list = new ArrayList<Player>(); // All players inside the Squad
	
	
	/**
	 * Overloaded constructor with name
	 * 
	 * Cannot create squad without a name
	 *  
	 * @param name
	 */
	public Squad(String name) {
		this.name = name;
		this.setLimit(28);
		this.coach = null;
		this.type = "Senior";
		player_list = new ArrayList<Player>();
	}
	
	/**
	 * Overloaded Constructor with option to add coach on initialisation
	 * 
	 *  This auto sets the coach
	 * 
	 * @param String 
	 * @param Coach 
	 */
	public Squad(String name, Coach coach) {
		this.name = name;
		this.coach = coach;
		this.setLimit(23);
		this.type = "Senior";
		player_list = new ArrayList<Player>();
	}
	
	// Getters and setters
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Add a player to the squad as long as it has not reached the limit
	 * 
	 * @param Player
	 */
	public void addPlayer(Player player) {
		if (player_list.size() < limit) {
			player_list.add(player);
		} else {
			System.out.println("Squad is full!");
		}
		
	}
	
	/**
	 * Set the coach variable to the parameter value
	 * 
	 * @param Coach c
	 */
	public void setCoach(Coach c) {
		this.coach = c;
	}
	
	/**
	 * Iterates over squad_list to find an element which matches the parameter object
	 * 
	 * -- If it finds it, removes it 
	 * -- If not, print message to user
	 * -- If squad is empty, print message
	 * 
	 * @param p (Player)
	 */
	public void removePlayer(Player p) {
		
		if (isEmpty() == false) {
			
			// Init variable to check if player exists in squadlist
			boolean playerFound = false;
			
			Iterator<Player> it = player_list.iterator();
			
			while (it.hasNext() == true) {
				Player player = it.next();
				
				if (player.getSRU().equals(p.getSRU())) {
					playerFound = true;
					it.remove();
					System.out.println(p.getFname() + " " + p.getSurname() + " removed from " + name + ".");
				}	
			}
			
			// Print message if not in list
			if(playerFound == false) {
				System.out.println("Player does not exist in " + name + ".");
			}
			
		} else {
			System.out.println("There are no players no remove!");
		}
	}
	
	/**
	 * Set max num of players for player_list
	 * 
	 * @param int limit
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	/**
	 * Set the type e.g. 'Squad', 'Junior Squad' etc
	 * 
	 * @param String type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	/**
	 * Remove all players from team, used when coach selects a team and saves it
	 * 
	 * Clear the team first, then add all of the new players
	 */
	public void clearTeam() {
		player_list.clear();
	}
	
	/**
	 * If the playerlist is not empty, list all players - calls on toString method of Player class
	 * 
	 *  -- Else print message to user
	 */
	public void listPlayers() {
		if (!isEmpty()) {
			
			Iterator<Player> it = player_list.iterator();
			
			while (it.hasNext() == true) {
				Player player = it.next();
				System.out.println(player);
			}
				
		} else {
			System.out.println("There are no players in the " + type + "!");
		}
	}
	
	/**
	 * returns an instance of Player from the player_list
	 * 
	 * @param Player 'p'
	 * @return Player
	 */
	public Player getPlayer(Player p) {
		
		Player thePlayer = null;
		
		if (!isEmpty()) {
			
			// Init variable to check if player exists in squadlist
			boolean playerFound = false;
			
			Iterator<Player> it = player_list.iterator();
			
			while (it.hasNext() == true) {
				Player player = it.next();
				
				if (player == p) {
					playerFound = true;
					thePlayer = player;
				}	
			}
			
			// Print message if not in list
			if(playerFound == false) {
				System.out.println("Player does not exist in " + type + ".");
			}
			
		} else {
			System.out.println("There are no players no remove!");
		}
		
		return thePlayer;
	}
	
	/**
	 * Return the Coach object
	 * 
	 * @return Coach
	 */
	public Coach getCoach() {
		return coach;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Return the arraylist of Team members
	 * 
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> returnTeam() {
		return team;
	}
	
	/**
	 * Quick boolean return method to check if player_list is full (28 elems)
	 * 
	 * @return Boolean
	 */
	public boolean isFull() {
		boolean full = false;
		
		if(player_list.size() == limit) {
			full = true;
		}
		return full;
	}
	
	/**
	 * Quick boolean return method to check if player_list is empty
	 * 
	 * @return Boolean
	 */
	public boolean isEmpty() {
		boolean empty = false;
		
		if(player_list.size() == 0) {
			empty = true;
		}
		return empty;
	}
	
	/**
	 * Return the entire ArrayList of Players
	 * 
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> getPlayerList() {
		return player_list;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return name;
	}
	
}
