package project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JComboBox;

/**
 * This model takes care of the team selection by the coach
 *  
 * Once the coach saves the team on the SelectTeam GUI, the player arraylists are passed through this model, to the Team class for allocation
 * Default constructor will be made by the compiler, no manual initialisation necessary
 * 
 * This class will help spread out the code so that the Model and Controller are not too crowded
 * 
 * @author Keir
 * @since 29/04/21
 *
 */

public class TeamSelectionModel {

	
	/**
	 * Iterates over the team arraylist in the Coach's Squad and adds each player from the parameter arraylists
	 * 
	 * Also sets the Player startingTeam and benchTeam boolean values
	 * 
	 * @param Coach coach
	 * @param ArrayList<Player> start
	 * @param ArrayList<Player> bench
	 */
	public void addTeam(Coach coach, ArrayList<Player> start, ArrayList<Player> bench) {
		for (Player p: start) {
			p.setStartingTeam();
			coach.getSquad().returnTeam().add(p);
		}
		
		for (Player p: bench) {
			p.setBench();
			coach.getSquad().returnTeam().add(p);
		}
	}
	
	/**
	 * empty the contents of the team arraylist of a Coach's squad
	 * 
	 * @param Coach coach
	 */
	public void clearTeam(Coach coach) {
		coach.getSquad().returnTeam().clear();
	}
	
	
	/**
	 * Checks 2 player arrays (StartingTeam and Bench) and checks if there are duplicate elements between the 2 - i.e. If a player appears in both arrays
	 * 
	 * @param ArrayList<Player> (Starting Team)
	 * @param ArrayList<Player> (Bench Team)
	 * @return boolean
	 */
	public boolean checkForOverlap(ArrayList<Player> arr1, ArrayList<Player> arr2) {
		boolean overlap = false;
		
		/*
		 	Create a hashset of type Player
		 */
		HashSet<Player> playArr = new HashSet<Player>();
		
		/*
		 	Add all elements of first arraylist
		 */
		for (Player p: arr1) {
			playArr.add(p);
		}
		
		/*
		 	Iterate over the 2nd arraylist, if any of the elements are contained within the array already, set overlap to true
		 */
		for (Player q: arr2) {
			
			if (playArr.contains(q)) {
				overlap = true;
			}
		}
		
		return overlap;
	}
	/**
	 * Takes an array of combo box elements and extracts the Player element from the models, assigns them to an instantiation of Player in the method
	 * 
	 * For each player it finds, assign the Player objects SRU number to an array of Strings
	 * Loop through the array of Strings and check for duplicates since the values are unique
	 * 
	 * @param theArr (ArrayList<JComboBox>)
	 * @return boolean
	 */
	public boolean checkForDuplicates(ArrayList<Player> theArr) {
		boolean duplicates = false;
		
		/*
		 	Initialise Player and count
		 */
		Player p = null;
		int count = 0;
		
		/*
		 	Init a new array of Strings to hold all player SRUs
		 */
		String[] sru = new String[theArr.size()];
		
		/*
		 	Begin iterator loop over the arrayList in the parameter
		 */
		Iterator<Player> it = theArr.iterator();
				
		/*
		 	While the array has a next element
		 */
			while (it.hasNext() == true) {
				
				if (it != null) {
					
					/*
					 	Assign the current JComboBox element's selected item as the Player 'p' variable
					 */
					p = it.next();
					
					/*
					 	At the current count value index, add the current Player object SRU then increment the count
					 */
					sru[count] = p.getSRU();
					count++;
					
				}
				
			}
		
		/*
		 	Loop through each element of the SRU array
		 */
		for (int i = 0; i < sru.length; i++) {
			
			/*
			 	From each index, perform a second loop to continue forward and check for equality of all proceeding elements
			 */
			for (int j = i+1; j < sru.length - i; j++) {
				
				if (sru[i] != null && sru[j] != null) {
					
					if (sru[i] == sru[j]) {
						
						/*
						 	If a duplicate is found, set duplicates to true
						 */
						duplicates = true;
					}
				}
				
			}
		}
		return duplicates;
	}
	
	/**
	 * Takes the ArrayList of ComboBox<Player> and returns their selected index's in an arrayList
	 * 
	 * @return ArrayList<Player>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<Player> convertStartToPlayerList(ArrayList<JComboBox> initArr) {
		
		/*
		 	Initiate an arraylist of Player
		 */
		ArrayList<Player> startTeam = new ArrayList<Player>();
		
		/*
		 	Iterate over the arraylist of ComboBox
		 */
		Iterator<JComboBox> it = initArr.iterator();
		
		while (it.hasNext() == true) {
			
			JComboBox<Player> combo = it.next();
			
			/*
			 	Add all non-null selected items from the ComboBox's to the startTeam arraylist
			 */
			if (combo != null) {
				startTeam.add((Player)combo.getSelectedItem());
			}
		}
		
		return startTeam;
	}
	
	/**
	 * Same function as above, but for the bench
	 * 
	 * @return arraylist of Player 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<Player> convertBenchToPlayerList(ArrayList<JComboBox> initArr) {
			
		/*
		 	Initiate an arraylist of Player for the bench
		 */
		ArrayList<Player> theBenchTeam = new ArrayList<Player>();
		
		/*
		 	Iterate over the arraylist of ComboBox
		 */
		Iterator<JComboBox> it = initArr.iterator();
		
		while (it.hasNext() == true) {
			
			JComboBox<Player> combo = it.next();
			
			/*
			 	Add all non-null selected items from the ComboBox's to the theBenchTeam arraylist
			 */
			if (combo != null) {
				theBenchTeam.add((Player)combo.getSelectedItem());
			}
		}
		
		return theBenchTeam;
	}

}
