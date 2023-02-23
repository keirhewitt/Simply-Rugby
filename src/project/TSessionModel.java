package project;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 * This model will break up the code a bit to make it more readable and writeable
 * This will handle TrainingSession data
 * 
 * This class will help spread out the code so that the Model and Controller are not too crowded
 * 
 * @author Keir
 * @since 31/03/21
 * 
 */
public class TSessionModel {

	private ArrayList<TrainingSession> tSessions = new ArrayList<TrainingSession>();
	private String[] COLUMNS = {"Date", "Squad", "Activities"};
	
	// Constructor
	public TSessionModel() {
		tSessions = new ArrayList<TrainingSession>();
	}
	
	/**
	 *  Used by the CoachMainScreen
	 *  -- Table created with each entry of the tSessions arraylist
	 *  -- tSessions holds all created TrainingSession objects
	 *  -- This table holds a max of 5 
	 *  
	 * @return DefaultTableModel
	 */
	public DefaultTableModel createTable(Squad squad) {
			
		// Create table with 5 rows, 3 columns
		DefaultTableModel tsTable = new DefaultTableModel(COLUMNS, 5);
		
		String thedate = "";
		String thesquad = "";
		String theactivity = "";
		
			for (int i = 0; i < 5; i++) {
				
				// Breaks the loop if the program runs into a null value
				// If less than 5 TrainingSession objects have been created, this loop will end early
				if(tSessions.isEmpty()) {
					break;
				}
				
				try {
					
					/*
					 	For each element, store the date, squad and activity
					 */
					thedate = tSessions.get(i).getDate();
					thesquad = tSessions.get(i).getSquad();
					theactivity = tSessions.get(i).getActivities();
					
					/*
				 		Set the values in the relevant table columns
					 */
					tsTable.setValueAt(thedate, i, 0);
					tsTable.setValueAt(thesquad, i, 1);
					tsTable.setValueAt(theactivity, i, 2);
				
				/*
				 	Incase the loop tries to access a null element, catch and break the loop
				 */
				} catch (IndexOutOfBoundsException e) {
					
					break;
				}
			
				
			}
		
			/*
			 	Return the table created
			 */
		return tsTable;
	}
	
	/**
	 * Take the elements of the defaultlistmodel and create an arraylist with them
	 * 
	 * @param DefaultListModel li
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> recreateArrayListPlayers(@SuppressWarnings("rawtypes") DefaultListModel li) {
		ArrayList<Player> play = new ArrayList<Player>();
		for (int i = 0; i < li.getSize(); i++) {
			if(li.get(i) != null) {
				play.add((Player) li.get(i));
			}
		}
		return play;
	}
	
	/**
	 * Take the elements of the defaultlistmodel and create an arraylist with them
	 * 
	 * @param DefaultListModel li
	 * @return ArrayList<String>
	 */
	public ArrayList<String> recreateArrayListActivities(@SuppressWarnings("rawtypes") DefaultListModel li) {
		ArrayList<String> act = new ArrayList<String>();
		for (int i = 0; i < li.getSize(); i++) {
			if(li.get(i) != null) {
				act.add((String) li.get(i));
			}
		}
		return act;
	}
	
	
	/**
	 * User will invoke this to create a training session
	 * 
	 * Object added to tSessions also
	 *
	 * @param String date
	 * @param Squad s
	 */
	public void createTrainingSession(String date, Squad s) {
		TrainingSession t = new TrainingSession(date, s);
		tSessions.add(t);
	}
	
	/**
	 * Overloaded version of above function ^
	 * 
	 * @param String date
	 * @param Squad s
	 * @param ArrayList<Player> p
	 * @param ArrayList<String> a
	 */
	public void createTrainingSessionOverloaded(String date, Squad s, ArrayList<Player> p, ArrayList<String> a) {
		TrainingSession t = new TrainingSession(date, s, p, a);
		tSessions.add(t);
	}
	

	/**
	 * Call this to see if object exists in tSessions array
	 * 
	 * @param  int index
	 * @return boolean
	 */
	public boolean tSessionExists(int index) {
		boolean exists = true;
		try {
			tSessions.get(index);
		} catch (NullPointerException e) {
			exists = false;
		}
		return exists;
	}
	
	/**
	 * Returns a defaultlistmodel populated with an existing TrainingSession object's activities
	 * 
	 * @param index
	 * @return DefaultListModel
	 *
	 */
	public DefaultListModel<String> getTrainingSessionActivityModel(int index) {
		
		// Instantiate the TrainingSession object
		TrainingSession t = null;
		
		/*
		 	The list which will be returned
		 */
		DefaultListModel<String> li = new DefaultListModel<>();
		
		/*
			For less jumbled code, this is just to store the ArrayList of activities from the exisiting Object
		*/
		ArrayList<String> acts = new ArrayList<String>();
		
		/*
			Make the TrainingSession object the one we wish to edit
		*/
		t = tSessions.get(index);
		
		acts = t.returnActList();
		
		/*
			Cycle through existing activities and add them to the list we want to return
		*/
		for (int i = 0; i < acts.size(); i++) {
			li.addElement(acts.get(i));
		}
		
		/*
		 	Return the list of existing activities to repopulate the fields when the user wants to edit an existing training session
		 */
		return li;
		
	}
	
	
	/**
	 * 
	 * Acts the same as the above function except it returns a defaultlistmodel populated with the existing TSession Players list (participants)
	 *
	 * @param int index
	 * @return DefaultListModel<Player> 
	 */
	public DefaultListModel<Player> getTrainingSessionParticipantModel(int index) {
		
		TrainingSession t = null;
		
		DefaultListModel<Player> li = new DefaultListModel<>();
		ArrayList<Player> participants = new ArrayList<Player>();
		
		t = tSessions.get(index);
		
		participants = t.returnParticipantList();
		
		for (int i = 0; i < participants.size(); i++) {
			li.addElement(participants.get(i));
		}
		
		return li;
		
	}
	
	
	/**
	 * Get a specific TrainingSession at an [index]
	 * 
	 * @return TrainingSession
	 */
	public TrainingSession getTrainingSession(int index) {
		return tSessions.get(index);
	}
	
	
	/**
	 * Remove a TrainingSession object from the arraylist
	 */
	public void removeTSession(int index) {
		tSessions.remove(index);
	}
	
	
	
	/**
	 * Returns the whole arraylist object of TrainingSessions
	 * 
	 * @return ArrayList<TrainingSession>
	 */
	public ArrayList<TrainingSession> returnTSessions() {
		return tSessions;
	}
	
	/**
	 * Assign the tSessions array as a new array
	 * 
	 * @param ArrayList<TrainingSession> arr
	 */
	public void setTSessions(ArrayList<TrainingSession> arr) {
		tSessions = arr;
	}
	
}
