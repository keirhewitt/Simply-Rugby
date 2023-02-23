package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Model class contains the data logic for the program
 * 
 * This will perform the arithmetic and logic, often calling on contained Model classes
 * 
 * Model classes contained are: PlayerModel, DPlanModel, TSessionModel, TeamSelectionModel
 * 
 * @author Keir
 * @since 19/03/21
 * 
 */
public class Model {
	
	// ArrayLists for Coach, MembershipSecretary and Squad
	private ArrayList<Coach> coachList = new ArrayList<Coach>();
	private ArrayList<MembershipSecretary> membershipSecretaryList = new ArrayList<MembershipSecretary>();
	private ArrayList<Squad> squadList = new ArrayList<Squad>();

	// Models
	private TSessionModel tsModel;
	private PlayerModel psModel;
	private DPlanModel dpModel;
	private TeamSelectionModel teamsmodel;
	
	// Coach data pre-population
	private Coach tempCoach;
	private Coach tempCoach2;
	private MembershipSecretary tempMember;


	private SquadJunior mightyDucks = new SquadJunior("The Mighty Ducks");
	private Squad redDevils = new Squad("The Red Devils");

	// TrainingSession data pre-population
	
	private ArrayList<Player> playertestSenior = new ArrayList<Player>();
	private ArrayList<Player> playertestJunior = new ArrayList<Player>();
	
	private ArrayList<String> activitytestSenior = new ArrayList<String>();
	private ArrayList<String> activitytestJunior = new ArrayList<String>();
	
	
   
	/**
	 * Default constructor
	 * 
	 * Creates instances of all models
	 * 
	 * Performs deserialization if files have been found
	 */
	public Model() {
		tsModel = new TSessionModel();
		psModel = new PlayerModel();
		dpModel = new DPlanModel();
		teamsmodel = new TeamSelectionModel();
		
		squadList = new ArrayList<Squad>();
		membershipSecretaryList = new ArrayList<MembershipSecretary>();
		coachList = new ArrayList<Coach>();
		
		File p = new File("players.ser");
		File t = new File("tsessions.ser");
		File m = new File("members.ser");
		File s = new File("squads.ser");
		File c = new File("coaches.ser");
		
		if (s.exists() && !s.isDirectory()) {
			deserializeSquads();
		} else {
			initSquads();
		}
		
		if (p.exists() && !p.isDirectory()) {
			deserializePlayers();
		} else {
			initPlayers();
		}
		
		if (c.exists() && !c.isDirectory()) {
			deserializeCoaches();
		} else {
			initCoaches();
		}
		
		if (m.exists() && !m.isDirectory()) {
			deserializeMembershipSecretary();
		} else {
			initMembers();
		}
		
		if (t.exists() && !t.isDirectory()) {
			deserializeTrainingSessions();
		} else {
			initTrainingSessions();
		}
		
	}
	
	public void initSquads() {
		
		mightyDucks = new SquadJunior("The Mighty Ducks");
		redDevils = new Squad("The Red Devils");
		
	}
	

	public void initCoaches() {
		
		tempCoach = null;
		tempCoach2 = null;
		
		// Login: 1, Rugby12
		tempCoach = new Coach(mightyDucks, "rugby12", "07865659345", "john.a1@hotmail.com", "13 elderview way", "KE2 4HV", "John", "Anderson");
		mightyDucks.setCoach(tempCoach);
		tempCoach.setSquad(mightyDucks);
		
		// Login: 2, test
		tempCoach2 = new Coach(redDevils, "test", "078454444533", "rugbyJDolton@live.co.uk", "7 Marston Drive", "KE2 4HV", "James", "Dolton");
		redDevils.setCoach(tempCoach2);
		tempCoach2.setSquad(redDevils);
		
		coachList.add(tempCoach);
		coachList.add(tempCoach2);
		
		squadList.add(mightyDucks);
		squadList.add(redDevils);
		
	}
	

	
	public void initMembers() {
		
		tempMember = null;
		
		// Login: 1, admin
		tempMember = new MembershipSecretary("admin");
		
		membershipSecretaryList.add(tempMember);
		
	}
	
	
	public void initPlayers() {

				
		ArrayList<String> senior_1_health = new ArrayList<String>();
		ArrayList<String> senior_2_health = new ArrayList<String>(); senior_2_health.add("Peanut Allergy"); senior_2_health.add("High Blood Pressure");
		ArrayList<String> senior_3_health = new ArrayList<String>();
		ArrayList<String> senior_4_health = new ArrayList<String>(); 
		ArrayList<String> senior_5_health = new ArrayList<String>(); senior_5_health.add("Diabetes");
		ArrayList<String> senior_6_health = new ArrayList<String>();
		ArrayList<String> senior_7_health = new ArrayList<String>();
		ArrayList<String> senior_8_health = new ArrayList<String>(); senior_8_health.add("Cotton Allergy");
		
		
		Player senior_1 = new Player("Keir", "Hewitt", calculateAge("10-10-1999"), "testEmail@email.com", "Flanker", "10-10-1999", redDevils, "KY1 4LG", "11 St. Mary's Terrace", "07854663232", "01000", "David Hewitt", "0755443457", "Dr Fordyce", "01592 123353", senior_1_health);
		Player senior_2 = new Player("Jimmy", "Mulgrew", calculateAge("25-12-2001"), "testEmail@email.com", "Number 8",  "25-12-2001", redDevils, "KY1 8DS", "3 Milton Av.", "0788897755", "01001", "Helen Mulgrew", "0755845485", "Dr Melanie Dyce", "01592 450455", senior_2_health);
		Player senior_3 = new Player("Alan", "Drewson", calculateAge("03-11-2002"), "testEmail@email.com", "Inside-Center",  "03-11-2002", redDevils, "K3D 2LB", "46 Munkford Drive", "0788549594", "01002", "Kenneth Drewson", "0765865865", "Dr Caren Feath", "03343 954054", senior_3_health);
		Player senior_4 = new Player("Robbie", "Clay", calculateAge("30-04-2001"), "testEmail@email.com", "Loosehead",  "30-04-2001", redDevils, "KR4 4OO", "1 Redford Terrace", "07432374232", "01003", "Lauren Clay", "0754854836", "Dr Newton", "01443 200433", senior_4_health);
		Player senior_5 = new Player("John", "Adams", calculateAge("28-03-2003"), "testEmail@email.com", "LetfWing",  "28-03-2003", redDevils, "KY8 5YY", "34 Arfield Crescent", "0788559544", "01004", "Margaret Adams", "0799659212", "Dr Mott", "01344 902000", senior_5_health);
		Player senior_6 = new Player("Mark", "Davids", calculateAge("22-09-2004"), "testEmail@email.com", "Tighthead",  "22-09-2004",redDevils, "LN14 5XP", "24-B Loom Apts.", "04492 912232", "01005", "James Davids", "0734012003", "Dr Alan Fogwell", "04492 100203", senior_6_health);
		Player senior_7 = new Player("James", "Lid", calculateAge("12-01-2003"), "testEmail@email.com", "Outside-Center",  "12-01-2003", redDevils, "KI9 3LL", "3 St. Johns Avenue", "0743589247", "01006", "Anabelle Lid", "0744338443", "Dr Michael Rye", "01994 923934", senior_7_health);
		Player senior_8 = new Player("Alan", "Smith", calculateAge("10-03-2002"), "testEmail@email.com", "Number 8",  "10-03-2002", redDevils, "PL0 5KH", "45B Flatside Apts.", "0785543595", "01007", "Tommy Smith", "076598689", "Dr John Motson", "01243 434341", senior_8_health);
		Player senior_9 = new Player("Andrew", "Jackson", calculateAge("10-09-2003"), "testEmail@email.com", "Hooker",  "10-09-2003", redDevils, "KY1 5LL", "13 Myreside Crescent", "0754385843", "01008", "Janey Jackson", "0756653905", "Dr Roland", "01233 321331", senior_8_health);
		
		Player senior_10 = new Player("Harrison", "Fisher", calculateAge("11-08-1999"), "testEmail@email.com", "Scrum Half",  "11-08-1999", redDevils, "KY1 3EG", "7 St. Mary's Terrace", "0785444232", "01009", "David Fisher", "0755443457", "Dr Fordyce", "01592 123353", senior_1_health);
		
		
		ArrayList<String> junior_1_health = new ArrayList<String>(); 
		ArrayList<String> junior_2_health = new ArrayList<String>();
		ArrayList<String> junior_3_health = new ArrayList<String>();
		ArrayList<String> junior_4_health = new ArrayList<String>();
		
		JuniorPlayer junior_1 = new JuniorPlayer("Lenny", "Kuill", calculateAge("10-03-2007"), "testEmail@email.com", "Scrum Half",  "10-03-2007", mightyDucks, "KY1 5OL", "3B Nicol Street", "0786657475", "01441", "Jenny Kuill", "0709425845", "Dr Elwyn Tanner", "01592 450455", junior_1_health);
		JuniorPlayer junior_2 = new JuniorPlayer("Michael", "Richton", calculateAge("30-04-2007"), "testEmail@email.com", "Outside-Center",  "30-04-2006", mightyDucks, "KY3 3SS", "13 Castle Crescent", "079000594", "01490", "Tammy Richton", "0744543834", "Dr Julie Connet", "01556 800500", junior_2_health);
		JuniorPlayer junior_3 = new JuniorPlayer("Robert", "Lid", calculateAge("24-08-2007"), "testEmail@email.com", "Fly-Half",  "24-08-2007", mightyDucks, "KI9 3LL", "3 St. Johns Avenue", "0743546344", "01168", "Anabelle Lid", "0744338443", "Dr Michael Rye", "01994 923934", junior_3_health);
		JuniorPlayer junior_4 = new JuniorPlayer("Keiron", "Calgin", calculateAge("06-05-2007"), "testEmail@email.com", "Flanker",  "06-05-2007", mightyDucks, "EW1 9OP", "85 Allen Terrace", "0766483944", "01589", "Mark Andrews", "0766588566", "Dr Emery Collades", "08890 455943", junior_4_health);
		JuniorPlayer junior_5 = new JuniorPlayer("Jack", "Stoner", calculateAge("10-03-2007"), "testEmail@email.com", "Number 8",  "10-03-2007", mightyDucks, "KY1 5OL", "3B Nicol Street", "0786657475", "01441", "Jenny Kuill", "0709425845", "Dr Elwyn Tanner", "01592 450455", junior_1_health);
		JuniorPlayer junior_6 = new JuniorPlayer("Richard", "Dunn", calculateAge("30-04-2006"), "testEmail@email.com", "Tighthead",  "30-04-2006", mightyDucks, "KY3 3SS", "13 Castle Crescent", "079000594", "01490", "Tammy Richton", "0744543834", "Dr Julie Connet", "01556 800500", junior_2_health);
		JuniorPlayer junior_7 = new JuniorPlayer("Sammy", "Fotheringham", calculateAge("24-08-2007"), "testEmail@email.com", "Fullback",  "24-08-2007", mightyDucks, "KI9 3LL", "3 St. Johns Avenue", "0743546344", "01168", "Anabelle Lid", "0744338443", "Dr Michael Rye", "01994 923934", junior_3_health);
		JuniorPlayer junior_8 = new JuniorPlayer("Justin", "Featherton", calculateAge("06-05-2008"), "testEmail@email.com", "Inside-Center",  "06-05-2007", mightyDucks, "EW1 9OP", "85 Allen Terrace", "0766483944", "01589", "Mark Andrews", "0766588566", "Dr Emery Collades", "08890 455943", junior_4_health);
		JuniorPlayer junior_9 = new JuniorPlayer("Quinton", "Bowen", calculateAge("10-03-2007"), "testEmail@email.com", "LetfWing",  "10-03-2007", mightyDucks, "KY1 5OL", "3B Nicol Street", "0786657475", "01441", "Jenny Kuill", "0709425845", "Dr Elwyn Tanner", "01592 450455", junior_1_health);
		JuniorPlayer junior_10 = new JuniorPlayer("Ryan", "Brown", calculateAge("30-04-2008"), "testEmail@email.com", "Loosehead",  "30-04-2006", mightyDucks, "KY3 3SS", "13 Castle Crescent", "079000594", "01490", "Tammy Richton", "0744543834", "Dr Julie Connet", "01556 800500", junior_2_health);
		
		psModel.addPlayer(senior_1);
		psModel.addPlayer(senior_2);
		psModel.addPlayer(senior_3);
		psModel.addPlayer(senior_4);
		psModel.addPlayer(senior_5);
		psModel.addPlayer(senior_6);
		psModel.addPlayer(senior_7);
		psModel.addPlayer(senior_8);
		psModel.addPlayer(senior_9);
		psModel.addPlayer(senior_10);
	
		
		psModel.addPlayer(junior_1);
		psModel.addPlayer(junior_2);
		psModel.addPlayer(junior_3);
		psModel.addPlayer(junior_4);
		psModel.addPlayer(junior_5);
		psModel.addPlayer(junior_6);
		psModel.addPlayer(junior_7);
		psModel.addPlayer(junior_8);
		psModel.addPlayer(junior_9);
		psModel.addPlayer(junior_10);

		
		playertestSenior.add(senior_1);
		playertestSenior.add(senior_2);
		playertestSenior.add(senior_3);
		playertestSenior.add(senior_4);
		playertestSenior.add(senior_5);
		playertestSenior.add(senior_6);
		playertestSenior.add(senior_7);
		playertestSenior.add(senior_8);
		playertestSenior.add(senior_9);
		playertestSenior.add(senior_10);
		
		
		String act1junior = "Teamwork exercises";
		String act2junior = "Catching";
		
		String act1senior = "Running";
		String act2senior = "Tackling drills";
		String act3senior = "Scrum work";
		
		activitytestSenior.add(act3senior);
		activitytestSenior.add(act2senior);
		activitytestSenior.add(act1senior);
		
		activitytestJunior.add(act1junior);
		activitytestJunior.add(act2junior);
	

	}

	public void initTrainingSessions() {
		tsModel.createTrainingSessionOverloaded("12-April-2021", redDevils, playertestSenior, activitytestSenior);
		tsModel.createTrainingSessionOverloaded("09-May-2021", mightyDucks, playertestJunior, activitytestJunior);
	} 
	

	
	
	/**
	 * Returns true if it finds an iterator where the ID and Password match the user input
	 * 
	 * @param int ID
	 * @param String password
	 * @return boolean
	 */
	public boolean validateCoachLogin(int ID, String password) {
		boolean result = false;
		
		Iterator<Coach> it = coachList.iterator();
		
		while (it.hasNext() == true) {
			Coach currentCoach = it.next();
			
			if (currentCoach != null) {
				
				if(currentCoach.getLoginCombo().getFirstObject() == ID)
				{
					if(currentCoach.getLoginCombo().getSecondObject().equals(password)) {
						// login matches!
						result = true;
						break;
					}
				}
			}
			
		}
		
		return result;
	}
	
	/**
	 * Returns true if it finds an iterator where the ID and Password match the user input
	 * 
	 * @param int ID
	 * @param String password
	 * @return boolean
	 */
	public boolean validateMemberLogin(int ID, String password) {
		boolean result = false;
		
		Iterator<MembershipSecretary> it = membershipSecretaryList.iterator();
		
		while (it.hasNext() == true) {
			MembershipSecretary currentMember = it.next();
			
			if (currentMember != null) {
				
				if(currentMember.getLoginCombo().getFirstObject() == ID)
				{
					if(currentMember.getLoginCombo().getSecondObject().equals(password)) {
						// login matches!
						result = true;
						break;
					}
				}
			}
			
		}
		
		return result;
	}

	/**
	 * If coach exists and userID matches, return the coach object
	 * 
	 * @param userID
	 * @return Coach
	 */
	public Coach getCoachObj(int userID) {
		Coach retval = null;
		
		Iterator<Coach> it = coachList.iterator();
		
		while (it.hasNext() == true) {
			Coach currentCoach = it.next();
			
			if (currentCoach != null) {
				
				if(currentCoach.getLoginCombo().getFirstObject() == userID)
				{
					retval = currentCoach;
				}
			}
			
		}
		
		return retval;
	}
	
	// getter
	public ArrayList<Coach> getCoachList(){
		return coachList;
	}
	
	public ArrayList<Squad> getSquadList() {
		return squadList;
	}
	
	public ArrayList<MembershipSecretary> getMembersList() {
		return membershipSecretaryList;
	}
	
	/**
	 * This function makes the format accessible for JComboBox use
	 * This will return an array of objects -- containing the ones in the squadList
	 * 
	 * @return Squad[]
	 */
	public Squad[] getSquads() {
		
		/*
		  	Init the Squad array to size - 2, junior and senior. 
		 */
		Squad[] squads = new Squad[squadList.size()];
		
		/*
		 	Implement try catch, to catch the error if the array tries to add a null value
		 */
		for (int i = 0; i < squads.length; i++) {
			
			if (squadList.get(i) != null) {
				
				squads[i] = squadList.get(i);
			}
		}
		
		return squads;
	}
	

	
	/**
	 * Convert coach arraylist into array of objects then return it
	 * 
	 * @return Coach[]
	 */
	public Coach[] returnCoachList() {
		
		/*
		 	Init a new array of size coachList
		 */
		Coach[] coachlist = new Coach[coachList.size()];
		
		/*
		 	Iterate over coachList arraylist
		 */
		for (int i = 0; i < coachList.size(); i++) {
			
			/*
			 	If index isn't null, assign to new array
			 */
			if (coachList.get(i) != null) {
				
				coachlist[i] = coachList.get(i);
			}
		}
		
		return coachlist;
	}
	
	
	/**
	 * Creates a date format and tries to parse the given date parameter with it.
	 * 
	 * @param String date
	 * @return Boolean
	 */
	public boolean getDatePattern(String date) {
		
		/*
		 	Init boolean value
		 */
		boolean valid = true;
		
		/*
		 	Create the format using SimpleDateFormat
		 */
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		/*
		 	Try/catch to attempt the parse on the String date
		 */
		try {
			format.parse(date);
		} catch (ParseException e) {
			
			/*
			 	When caught, set valid to false
			 */
			valid = false;
		}
		
		return valid;
	}
	
	/**
	 * If postcode is not of length 8, return false
	 * 
	 * @param String postcode
	 * @return boolean
	 */
	public boolean getPostcodePattern(String postcode) {
		boolean valid = false;
		
		if (postcode.length() != 8) {
			valid = true;
		}
		
		return valid;
	}
	
	/**
	 * Checks if phone contains the char's given below and is 11 digits long
	 * 
	 * @param String phone
	 * @return Boolean
	 */
	public boolean phoneIsNumber(String phone) {
		boolean isNumber = false;
		
		if (phone.matches("[0-9]+") && phone.length() == 11) {
			isNumber = true;
		}
		
		return isNumber;
	}
	
	/**
	 * Iterates over Player arraylist in the PlayerModel
	 * 
	 * @param String SRU
	 * @return Boolean
	 */
	public boolean duplicateSRU(String SRU) {
		boolean duplicate = false;
		
		for (Player p: getpsmodel().getPlayers()) {
			
			/*
			 	Check for SRU equality
			 */
			if (p.getSRU().equals(SRU)) {
				duplicate = true;
			}
		}
		
		
		return duplicate;
	}
	
	/**
	 * Returns boolean value depending on whether the parameter string contains the '@' symbol
	 * 
	 * @param String email
	 * @return Boolean
	 */
	public boolean isEmail(String email) {
		boolean valid = false;
		
		if (email.contains("@")) {
			valid = true;
		}
		
		return valid;
	}
	
	/**
	 * Passes in the String Date Of Birth value and uses the LocalDate library to calculate the time in years from then til now
	 * 
	 * @param String DOB
	 * @return int
	 */
	public int calculateAge(String DOB) {
		
		/*
		 	Init the age value
		 */
		int age = 0;
		
		String[] dobValues = new String[3];
		dobValues = DOB.split("-");
		
		LocalDate l;
		
		/*
		 *  								*****  >> Uses the LocalDate library << **********
		 *  
		 *	Implement exceptions to deal with (1): being unable to split into 3 sections and access these indexes
		 *									  (2): being unable to format the number properly
		 *									  
		 *									  For both of these ^ assign 'l' to 2020-01-01
		 */
		try {
			l = LocalDate.of(Integer.parseInt(dobValues[2]), 
							Integer.parseInt(dobValues[1]), 
							Integer.parseInt(dobValues[0]));
		} catch (ArrayIndexOutOfBoundsException e) {
			l = LocalDate.of(2020, 01, 01);
		} catch (NumberFormatException e) {
			l = LocalDate.of(2020, 01, 01);
		}
		
		/*
		 	Gather the person's age by finding the difference between the given DOB and the time now 
		 */
		LocalDate now = LocalDate.now();
		Period diff = Period.between(l, now);
		age = diff.getYears();
		
		return age;
	}
	
	/**
	 * Set the coachList as a new arraylist
	 * 
	 * @param ArrayList<Coach> coachList
	 */
	public void setUserList(ArrayList<Coach> coachList) {
		this.coachList = coachList;
	}

	/**
	 * Adds a Coach object to the coachList
	 * 
	 * @param  Coach tempCoach
	 */
	public void addCoach(Coach tempCoach) {
		this.coachList.add(tempCoach);
	}
	
	/**
	 * Adds a MembershipSecretary to the membershipSecretaryList
	 * 
	 * @param MembershipSecretary MS
	 */
	public void addMember(MembershipSecretary MS) {
		this.membershipSecretaryList.add(MS);
	}
	
	
	/**
	 * Return the TSessionModel
	 * 
	 * @return TSessionModel
	 */
	public TSessionModel gettsmodel() {
		return tsModel;
	}
	
	/**
	 * Return the PlayerModel
	 * 
	 * @return PlayerModel
	 */
	public PlayerModel getpsmodel() {
		return psModel;
	}
	
	/**
	 * Return the TeamSelectionModel
	 * 
	 * @return TeamSelectionModel
	 */
	public TeamSelectionModel getteamsmodel() {
		return teamsmodel;
	}
	
	/**
	 * Return the DPlanModel
	 * 
	 * @return DPlanModel
	 */
	public DPlanModel getDPModel() {
		return dpModel;
	}
	
	
	/**
	 * Deserialize the arraylist 
	 */
	@SuppressWarnings("unchecked")
	public void deserializePlayers() {
		try {
			FileInputStream fIs = new FileInputStream("players.ser");
			ObjectInputStream objIn = new ObjectInputStream(fIs);
			
			// Set the arraylist in PlayerModel to the readObject()
			getpsmodel().setPlayerList( (ArrayList<Player>) objIn.readObject());
			objIn.close();
			fIs.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing players");
			e.printStackTrace();
		}
	}
	
	/**
	 *  Serialize the squadList
	 */
	public void serializeSquads() {
		try {
			FileOutputStream fOut = new FileOutputStream("squads.ser");
				ObjectOutputStream out2 = new ObjectOutputStream(fOut);
				
				// write out the squadList to the file
				out2.writeObject(squadList);
				out2.close();
				fOut.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
	}
	
	/**
	 * Deserialize the squadList
	 */
	@SuppressWarnings("unchecked")
	public void deserializeSquads() {
		try {
			FileInputStream fIs = new FileInputStream("squads.ser");
			ObjectInputStream objIn = new ObjectInputStream(fIs);
			
			// assign squadList the readObject() value
			squadList = (ArrayList<Squad>) objIn.readObject();
			
			objIn.close();
			fIs.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing Squads");
			e.printStackTrace();
		}
	}
	
	/**
	 * Serialize the arraylist in the PlayerModel
	 */
	public void serializePlayers() {
		try {
			FileOutputStream fOut = new FileOutputStream("players.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(fOut);
			
			// write the arraylist out to the file
			out2.writeObject(getpsmodel().getPlayers());
			out2.close();
			fOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	/*
	 	Serialize the arraylist of TrainingSession
	 */
	public void serializeTrainingSessions() {
		try {
			FileOutputStream fOut = new FileOutputStream("tsessions.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(fOut);
			
			// Write the arraylist in the TSessionModel to the file
			out2.writeObject(gettsmodel().returnTSessions());
			out2.close();
			fOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	/**
	 * Deserialize the TrainingSession arraylist in the TSessionModel
	 */
	@SuppressWarnings("unchecked")
	public void deserializeTrainingSessions() {
		try {
			FileInputStream fIs = new FileInputStream("tsessions.ser");
			ObjectInputStream objIn = new ObjectInputStream(fIs);
			
			// Set the Arraylist to the readObject() value
			gettsmodel().setTSessions( (ArrayList<TrainingSession>) objIn.readObject());
			
			objIn.close();
			fIs.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing training sessions");
			e.printStackTrace();
		}
	}
	
	/**
	 * Serialize the coachList arraylist
	 */
	public void serializeCoaches() {
		try {
			FileOutputStream fOut = new FileOutputStream("coaches.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(fOut);
			
			// write out coachList
			out2.writeObject(coachList);
			out2.close();
			fOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	/**
	 * Deserialize the coachList arraylist
	 */
	@SuppressWarnings("unchecked")
	public void deserializeCoaches(){
		try {
			FileInputStream fIs = new FileInputStream("coaches.ser");
			ObjectInputStream objIn = new ObjectInputStream(fIs);
			
			// assign coachList as the readObject() value
			coachList = (ArrayList<Coach>) objIn.readObject();
			
			objIn.close();
			fIs.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing Coaches");
			e.printStackTrace();
		}
	}
	
	/**
	 * Serialize the membershipSecretaryList arraylist
	 */
	public void serializeMembershipSecretary() {
		try {
			FileOutputStream fOut = new FileOutputStream("members.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(fOut);

			// Write out the object to the file
			out2.writeObject(membershipSecretaryList);
			out2.close();
			fOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	/**
	 * Deserialize the membershipSecretaryList
	 */
	@SuppressWarnings("unchecked")
	public void deserializeMembershipSecretary() {
		try {
			FileInputStream fIs = new FileInputStream("members.ser");
			ObjectInputStream objIn = new ObjectInputStream(fIs);
			
			// Set the membershipSecretaryList as the readObject() value
			membershipSecretaryList = (ArrayList<MembershipSecretary>) objIn.readObject();
			
			objIn.close();
			fIs.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing Membership Secretaries");
			e.printStackTrace();
		}
	}
	
	
}
