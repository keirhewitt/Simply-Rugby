package project;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 * The Controller leverages the GUI side of the program as well as the Model - which handles the data
 * This will get logic/data from the Model and instruct the GUI to display the results
 * 
 * @author Keir
 * @since 16/03/21
 */
public class Controller {
	
	private Model myModel;
	private ChooseLogin initialScreen;
	
	/**
	 * Default Constructor -- Initialises the Model and creates the InitialScreen to start the application on the GUI side
	 */
	public Controller() {
		myModel = new Model();
		initialScreen = new ChooseLogin(this);
		initialScreen.setLocationRelativeTo(null);
		initialScreen.setVisible(true);
	}

	/**
	 * performs a login when requested
	 * this function now asks the Model to validate the login
	 * 
	 * @param ID (int)
	 * @param password (String)
	 * @return boolean - if login values match
	 */
	public boolean validateCoachLogin(int ID, String password) {
		
		boolean retval = myModel.validateCoachLogin((Integer)ID, password);

		if(retval == true) {
			initialScreen.setVisible(false);
			CoachUserScreen user = new CoachUserScreen(ID, this);
			user.setLocationRelativeTo(null);
			user.setVisible(true);
		}

		return retval;
	}
	
	/**
	 * performs a login when requested
	 * Model does the cheking for equality and returns a true or false
	 * if true, create a MainMember screen
	 * When this goes back to the MemberLogin, if true, MemberLogin disposes itself.
	 * 
	 * @param ID
	 * @param password
	 * @return
	 */
	public boolean validateMemberLogin(int ID, String password) {
		
		boolean retval = myModel.validateMemberLogin((Integer)ID, password);

		if(retval == true) {
			/*
			 	Insert member main screen
			 */
			initialScreen.setVisible(false);
			MemberMain MM = new MemberMain(this);
			MM.setLocationRelativeTo(null);
			MM.setVisible(true);
		}

		return retval;
		
	}
	
	/**
	 * Leverages the Models to create a DevelopmentPlan using the parameters
	 * 
	 * @param p (Player)
	 * @param planSet (HashMap)
	 * @param date (String)
	 * @return boolean value - depending on whether application could create the Plan or not
	 */
	public boolean createDevelopmentPlan(Player p, HashMap<Skill, Integer> planSet, String date) {
		boolean plan = false;
		
		if (myModel.getDPModel().createPlan(p, planSet, date) == true) {
			plan = true;
		}
		return plan;
		
	}
	/*
	 *  ==============================================================================
	 	------------------- >>>>CoachUserScreen methods<<<< --------------------------
	 	==============================================================================
	 */
	
	/**
	 * Takes the current user skill rating and their development plan target and displays a helpful String showing their progress
	 * 
	 * @param int value
	 * @param int target
	 * @return String 
	 */
	public String displayDevelopmentPlanValues(int value, int target) {
		String s = "";
		
		for (int i = 1; i < 11; i++) {
			
			/*
			 	For if the user has reached their target
			 */
			if (i == value && i == target) {
				s += ("*" + i + "*  ");
			}
			
			/*
			 	For where the users rating is currently at
			 */
			if (i == value) {
				s += ("[ " + i + " ]  ");
				
			/*
			 	For the target number
			 */
			} else if(i == target) {
				s+= (">" + i + "<  ");
				
			/*
			 	For every other number
			 */
			} else {
				s+=(i + "   ");
			}
		}
		
		return s;
	}
	
	/*
	 *  ==============================================================================
	 	------------------------------------------------------------------------------
	 	==============================================================================
	 */
	
	/**
	 * Takes an existing activity model and repopulates it, then returns it
	 * 
	 * @param li - DefaultListModel<String> [existing]
	 * @param TSIndex - int [index of TSession in arraylist]
	 * @return DefaultListModel<String> [altered]
	 */
	public DefaultListModel<String> recreateActivityModel(DefaultListModel<String> li, int TSIndex) {
		
		/*
		 	Access main model to get TSessionModel to repopulate existing activity model and return it
		 */
		li = myModel.gettsmodel().getTrainingSessionActivityModel(TSIndex);
		return li;
	}
	
	/**
	 * 	 * Takes an existing participant model and repopulates it, then returns it
	 * 
	 * @param li - DefaultListModel<Player> [existing]
	 * @param TSIndex - int [index of TSession in arraylist]
	 * @return DefaultListModel<Player> [altered]
	 */
	public DefaultListModel<Player> recreateParticipantModel(DefaultListModel<Player> li, int TSIndex) {
		
		/*
		 	Access main model to get TSModel and repopulate existing participant model and return it
		 */
		li = myModel.gettsmodel().getTrainingSessionParticipantModel(TSIndex);
		return li;
	}
	
	/**
	 * 	 * Calls on the training session model to return a DefaultTableModel table populated with TrainingSession data
	 * 
	 * @param coach
	 * @return DefaultTableModel of the training sessions of the coache's squad
	 */
	public DefaultTableModel createTable(Coach coach) {
		Squad squad = null;
		squad = coach.getSquad();
		DefaultTableModel model = myModel.gettsmodel().createTable(squad);
		return model;
	}
	
	
	/*
	 *  ==============================================================================
	 	------------------- >>>>SelectTeam methods<<<< -------------------------------
	 	==============================================================================
	 */
	
	/**
	 * Sends 2 arrays to TeamSelectionModel to check for duplicates between 2 arrays
	 * 
	 * @param arr1 (ArrayList<Player>)
	 * @param arr2 (ArrayList<Player>)
	 * @return boolean
	 */
	public boolean checkOverlap(ArrayList<Player> arr1, ArrayList<Player> arr2) {
		return myModel.getteamsmodel().checkForOverlap(arr1, arr2);
	}
	
	/**
	 * Takes an arraylist of players and passes it to the TeamSelectionModel to check for duplicate elements
	 * 
	 * @param arr -- (ArrayList<Player>)
	 * @return boolean
	 */
	public boolean checkForDuplicates(ArrayList<Player> arr) {
		return myModel.getteamsmodel().checkForDuplicates(arr);
	}
	
	/**
	 * Clears the Coach's team so that a new team lineup can be overwritten
	 * 
	 * @param coach
	 */
	public void clearTeam(Coach coach) {
		myModel.getteamsmodel().clearTeam(coach);
	}
	
	/**
	 * Once 2 previous checks ^^ have been completed, assign the Players to the Coach's Team object
	 * 
	 * @param coach
	 * @param start
	 * @param bench
	 */
	public void addTeam(Coach coach, ArrayList<Player> start, ArrayList<Player> bench) {
		myModel.getteamsmodel().addTeam(coach, start, bench);
	}
	
	/**
	 * Take the arraylist of ComboBox elements, extract the Player objects and return an arraylist of said Player objects
	 * -- For starting team
	 * 
	 * @param initArr (ArrayList<JComboBox>)
	 * @return ArrayList<Player>
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<Player> convertBench(ArrayList<JComboBox> initArr) {
		return myModel.getteamsmodel().convertBenchToPlayerList(initArr);
	}
	
	/**
	 * Take the arraylist of ComboBox elements, extract the Player objects and return an arraylist of said Player objects
	 * -- For bench team
	 * 
	 * @param initArr (ArrayList<JComboBox>)
	 * @return ArrayList<Player>
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<Player> convertStart(ArrayList<JComboBox> initArr) {
		return myModel.getteamsmodel().convertStartToPlayerList(initArr);
	}
	
	/**
	 * Assign the players array to a length of: the number of elements in the player array in the PlayerModel
	 * 
	 * -- Then populate it with the elements from THAT array
	 * -- Populate with the array
	 * 
	 * @param Coach
	 * @return Player[] 
	 */
	public Player[] populatePlayers(Coach coach) {
		Player[] players = null;
		
		/*
		 	Insert try/catch incase there are no players to extract from the PlayerModel method
		 */
		try {
			
			/*
			 	Assign the length of the Array
			 */
			players = new Player[myModel.getpsmodel().getPlayersLength(coach.getSquad())+1];
			
			/*
			 	Populate with the PlayerModel method which returns an array of Player objects
			 */
			players = myModel.getpsmodel().getPlayers(coach.getSquad());
			
		/*
		 	Catch if there are no elements to assign, or get length of
		 */
		} catch (NullPointerException e) {
			System.out.println("No players to add to list.");
		}
		return players;
	}
	
	/*
	 *  ==============================================================================
	 	------------------- >>>>MemberMain methods<<<< -------------------------------
	 	==============================================================================
	 */
	
	/**
	 * Accesses the playerModel and transfers the health issues arraylist of a Player object into a DefaultListModel<String>
	 * @param Player 'p'
	 * @return DefaultListModel<String>
	 */
	public DefaultListModel<String> transferHealthIssues(Player p) {
		return myModel.getpsmodel().transferHealthIssues(p.getHealthIssues());
	}
	
	/**
	 * Dictates whether to create a senior or junior squad
	 * Returns an integer based on the outcome of the function
	 * -- 1: The name was empty
	 * -- 2: Success
	 * 
	 * @param String name
	 * @return int
	 */
	public int createSquad(String type, String name) {
		
		/*
		 	Init the name, type and return variables
		 */
		String thename = name;
		String thetype = type;
		int val = 0;
		
		/*
		 	Check for empty name, set val = 1
		 */
		if (thename.equals("")) {
			val = 1;
			
		/*
		 	If the name isn't empty and the type = 'Senior', create Senior Squad
		 */
		} else if (thetype.equals("Senior")) {
			Squad newSquad = new Squad(name);
			myModel.getSquadList().add(newSquad);
			
			/*
			 	If the application can successfully locate the newly created Squad, set val = 2
			 */
			if (myModel.getSquadList().contains(newSquad)) {
				val = 2;
			}
			
		/*
		 	If the name isn't empty and the type = 'Junior', create Junior Squad
		 */
		} else if(thetype.equals("Junior")) {
			SquadJunior newSquad = new SquadJunior(name);
			myModel.getSquadList().add(newSquad);
			
			if (myModel.getSquadList().contains(newSquad)) {
				val = 2;
			}
		}
	
		/*
		 	Return the val variable, communicating the outcome
		 */
		return val;
	}
	
	/**
	 * Takes a Player and a Squad and checks their compatibility i.e. age and if the squad is full
	 * 
	 * Returns the message to be displayed in the View
	 * 
	 * @param Player p
	 * @param Squad s
	 * @return String
	 */
	public String changeSquad(Player p, Squad s) {
		
		String message = "";
		
		Player thePlayer = p;
		Squad theSquad = s;
		
		if (thePlayer.getAge() < 16 && theSquad instanceof Squad) {
			message = "Player too young to be in a Senior Squad!";
		} else if (thePlayer.getAge() >= 16 && theSquad instanceof SquadJunior) {
			message = "Player too old to be in a Junior Squad!";
		} else if (theSquad.isFull()) {
			message = "The squad is full!";
		} else if (theSquad.getName().equals(thePlayer.getSquad().getName())) {
			message = "Cannot move player to the same squad!";
		} else {
			theSquad.addPlayer(thePlayer);
			message = thePlayer.getFname() + thePlayer.getSurname() + " successfully swapped over to " + theSquad.getName();
		}
		
		return message;
	}
	
	/*
	 *  ==============================================================================
	 	------------------- >>>>MemberAddUser methods<<<< ----------------------------
	 	==============================================================================
	 */
	
	/**
	 * Create instance of MemberMain and set visible
	 * 
	 * @param  Controller cont
	 */
	public void createMemberMainScreen(Controller cont) {
		MemberMain MM = new MemberMain(cont);
		MM.setLocationRelativeTo(null);
		MM.setVisible(true);
	}
	
	/**
	 * Makes sure given values for Coach objects are valid
	 * 
	 * Returns an int which will translate the outcome of these checks
	 * 
	 * @param fname
	 * @param sname
	 * @param add
	 * @param pcode
	 * @param num
	 * @param mail
	 * 
	 * @return int
	 */
	public int checkCoachDetails(String fname, String sname, String add, String pcode, String num, String mail) {
		int val = 0;
		
		/*
		 	Init all values to be used
		 */
		String firstname = fname;
		String surname = sname;
		String address = add;
		String postcode = pcode;
		String phone = num;
		String email = mail;
		
		/*
		 	Perform the various checks on key fields
		 */
		if ( firstname.equals("") || surname.equals("") || address.equals("") || postcode.equals("") || phone.equals("") || email.equals("") ) {
			val = 1; // Empty strings
		} else if (postcode.length() != 7) {
			val = 2; // Postcode length error
		} else if (myModel.phoneIsNumber(phone) == false || phone.length() != 11) {
			val = 3; // PhoneNumber is NaN
		} else if (myModel.isEmail(email) == false) {
			val = 4; // Email does not contain @ symbol
		} else {
			
			/*
			 	If all checks pass set val = 6
			 */
			val = 6;
		}
		
		return val;
	}
	
	
	/**
	 * This function creates a Coach object, if all checks pass
	 * 
	 * Takes all of the relevant fields given by the user and passes them into this function which checks their validity
	 * 
	 * An int value 'val' determines which message will be sent back to the user for information
	 * The String variable is then returned
	 * 
	 * @param String pass
	 * @param String fname
	 * @param String sname
	 * @param String add
	 * @param String pcode
	 * @param String num
	 * @param String mail
	 * @param Squad s
	 * 
	 * @return String
	 */
	public String addNewCoach(String pass, String fname, String sname, String add, String pcode, String num, String mail, Squad s)  {
		int val = 0;
		
		String message = "";
		/*
		 	Init all values to be used
		 */
		String firstname = fname;
		String surname = sname;
		String address = add;
		String postcode = pcode;
		String phone = num;
		String email = mail;
		String password = pass;
		
		Squad theSquad = s;
		
		val = checkCoachDetails(firstname, surname, address, postcode, phone, email);
		
		if (password.equals("")) {
			val = 1;
		} else if (theSquad == null) {
			val = 5;
		}
		
		if (val == 6) {
			Coach newCoach = new Coach(s, password, phone, email, address, postcode, firstname, surname);
			myModel.getCoachList().add(newCoach);
		}
		
		/*
		 	Determine the message depending on what 'val' ended up being assigned to
		 */
		if (val == 1) {
			message = "You need to fill in all of the fields!";
		} else if (val == 2) {
			message = "Postcode needs to have a length of 7";
		} else if (val == 3) {
			message = "Phone number can only contain numbers and needs to be 11 characters long!";
		} else if (val == 4) {
			message = "Please enter a valid email address";
		} else if (val == 5) {
			message = "No squad given!";
		} else if (val == 6 ) {
			message = "Coach created.";
		}
		
		/*
		 	Return the message to the user
		 */
		return message;
		
	}
	
	/**
	 * This will take information given through the GUI and check for invalid inputs
	 * It will store any invalid checks as an int variable - depending on the variable and appropriate message will be displayed to the user
	 * 
	 * This method throws ArrayIndexOutOfBoundsException incase when trying to parse the Date given by the user, it cannot split the String into 3 parts and access each index
	 * 
	 * If all checks pass, the Player object is created and added to the given squad, then added to the PlayerModel playerList.
	 * 
	 * The returned message from this function is dealt with in -- MemberAddUser
	 * 
	 * @param ArrayList<String> health
	 * @param Squad s
	 * @param String fname
	 * @param String sname
	 * @param String num
	 * @param String mail
	 * @param String pos
	 * @param String birth
	 * @param String add
	 * @param String post
	 * @param String rugbynum
	 * @param String kin
	 * @param String kinPhone
	 * @param String doc
	 * @param String docPhone
	 * @return String message
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public String addNewPlayer(String playerType, ArrayList<String> health, Squad s, String fname, String sname, String num, String mail, String pos, String birth, String add, String post, String rugbynum, String kin, String kinPhone, String doc, String docPhone) throws ArrayIndexOutOfBoundsException {
		
		int val = 0;
		String message = "";
		
		String type = playerType;
		Squad thesquad = s;
		
		ArrayList<String> healthIssues = new ArrayList<String>();
		healthIssues = health;
		
		String firstname = fname;
		String surname = sname;
		String phone = num;
		String email = mail;
		String position = pos;
		String DOB = birth;
		String address = add;
		String postcode = post;
		String SRU = rugbynum;
		String NOK = kin;
		String NOKContact = kinPhone;
		String doctor = doc;
		String doctorContact = docPhone;
				
		/*
		 	Determine whether to cast as Squad or SquadJunior
		 */
		
		int age = getModel().calculateAge(DOB);
		
		/*
		 	Perform all of the necessary checks
		 */
		if ( position.equals("") || firstname.equals("") || surname.equals("") 
				|| address.equals("") || postcode.equals("") || phone.equals("") 
				|| email.equals("") || DOB.equals("") || SRU.equals("") || NOK.equals("") 
				|| NOKContact.equals("") || doctor.equals("") || doctorContact.equals("") ) {
			val = 1; // Empty strings present
		} else if (postcode.length() != 7) {
			val = 2; // Postcode length error
		} else if (myModel.phoneIsNumber(phone) == false || myModel.phoneIsNumber(doctorContact) == false 
				|| myModel.phoneIsNumber(NOKContact) == false) {
			val = 3; // PhoneNumber is NaN
		} else if (myModel.isEmail(email) == false) {
			val = 4; // Email does not contain @ symbol
		} else if (myModel.duplicateSRU(SRU)) {
			val = 6; // SRU is a duplicate - has to be unique
		} else if (myModel.getDatePattern(DOB) == false) {
			val = 7; // Date needs to be in format dd-MM-yyy
		} else if (age >= 16 && type.equals("Junior")) {
			val = 8; // Player is too old to be a Junior
		} else if ((age < 16) && type.equals("Senior")) {
			val = 9; // Player is too young to be Senior
		} else if (age >= 16 && thesquad.getClass().getName().equals(SquadJunior.class.getName())) {
			val = 10; // Player is too old to be in a JuniorSquad
		} else if ((age < 16) && thesquad.getClass().getName().equals(Squad.class.getName())) {
			val = 11; // Player is too young to be in Senior squad
		} else if (s.isFull()) {
			val = 12; // Squad is too full to add another player
		} else {
			
			val = 13;

			/*
			 	Determine whether player is Senior or Junior
			  	Create the player and add them to the relevant lists
			 */
			if (type.equals("Senior")) {
				Player newp = new Player(firstname, surname, age, email, position, DOB, 
					thesquad, postcode, address, phone, SRU, NOK, NOKContact, doctor,
					doctorContact, healthIssues );
				
				/*
				 	Add them to the PlayerModel arraylist of Players
				 */
				myModel.getpsmodel().addPlayer(newp);
				
			} else {
				
				JuniorPlayer newpJunior = new JuniorPlayer(firstname, surname, age, email, position, DOB, 
					thesquad, postcode, address, phone, SRU, NOK, NOKContact, doctor,
					doctorContact, healthIssues );
				
				myModel.getpsmodel().addPlayer(newpJunior);
			}
			
		}
		
		/*
	 		Determine the message depending on what 'val' ended up being assigned to
		 */
		if (val == 1) {
			message = "You need to fill in all of the fields!";
		} else if (val == 2) {
			message = "Postcode needs to have a length of 7.";
		} else if (val == 3) {
			message = "Phone numbers can only contain numbers and needs to be 11 characters long - check all phone numbers.";
		} else if (val == 4) {
			message = "Please enter a valid email address.";
		} else if (val == 5) {
			message = "No squad given!";
		} else if (val == 6 ) {
			message = "That SRU has already been registered!";
		} else if (val == 7) {
			message = "Date needs to be in the format dd-MM-yyyy.";
		} else if (val == 8) {
			message = "Player is too old to be a Junior!";
		} else if (val == 9) {
			message = "Player is too young to be a Senior!";
		} else if (val == 10) {
			message = "Player is too old to be in a Junior Squad!";
		} else if (val == 11) {
			message = "Player is too young to be in a Senior Squad!";
		} else if (val == 12) {
			message = "Squad is too full! Cannot create player in this Squad.";
		} else if (val == 13) {
			message = "Player added!";		
		}
		
		/*
		 	Finally, return the message to be shown with by MemberAddUser
		 */
		return message;
	}
	
	/**
	 * Creates the MembershipSecretary object then passes it to the Model
	 * 
	 * @param String pass
	 */
	public void createMembershipSecretary(String pass) {
		
		MembershipSecretary MS = new MembershipSecretary(pass);
		getModel().addMember(MS);
		
	}
	
	
	/*
	 *  ==============================================================================
	 	--------------------- >>>>CreatePlan methods<<<< -----------------------------
	 	==============================================================================
	 */
	
	/**
	 * Takes the arraylist of skills given by CreatePlan and checks for duplicate values, return true if so.
	 * 
	 * @param ArrayList<Skill>
	 * @return boolean
	 */
	public boolean conflictingSkills(ArrayList<Skill> arr) {
		boolean conflicting = false;
		
		if (arr.get(0) == arr.get(1) || arr.get(1) == arr.get(2) || arr.get(0) == arr.get(2)) {
			conflicting = true;
		}
		
		return conflicting;
	}
	
	
	/*
	 *  ==============================================================================
	 	------------------------- >>>> GETTERS <<<< ----------------------------------
	 	==============================================================================
	 */
	
	/**
	 * Uses the Coach's unique ID to return the Coach object
	 * 
	 * @param ID (int)
	 * @return Coach
	 */
	public Coach getCoachObj(int ID) {
		return myModel.getCoachObj(ID);
	}
	
	/**
	 * Method for returning the model so it can be accessed
	 * 
	 * @return Model
	 */
	public Model getModel() {
		return myModel;
	}
	
	/**
	 * handles a window closed event from the type of window designated by the string
	 * If the window is one of those provided, the ChooseLogin screen is shown
	 * 
	 * @param windowID
	 */
	public void handleWindowClosed(String windowID) {
		
		if(windowID.equals("CoachUserScreen") || windowID.equals("MemberMain")) {
			initialScreen = new ChooseLogin(this);
			initialScreen.setLocationRelativeTo(null);
			initialScreen.setVisible(true);
		}
		
	}
}
