package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *  The Player objects will be held in Squad objects and PlayerModel
 *  
 *  toString method shows name and squad
 *  
 *  Overloaded constructor used for creation
 * 
 * @author Keir
 * @since 30/03/21
 */

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int age;
	private String firstname;
	private String surname;
	private String address;
	private String phone_number;
	private String email;
	private String postcode;
	private String DOB;
	private String position;
	private String SRU;
	private String next_of_kin;
	private String doctor;
	private String net_of_kin_telephone;
	private String doctor_telephone;
	private ArrayList<String> health_issues = new ArrayList<String>();
	private ArrayList<Skill> skill_list = new ArrayList<Skill>();
	private boolean starting_team;
	private boolean bench;
	private DevelopmentPlan developmentPlan;
	private Squad squad;
	
	
	/**
	 * *  Overloaded Constructor for Player
	 * 
	 *  -- Sets no development plan
	 *  -- calls initSkills() method to create and add skills to skill_list
	 *  -- Adds them to the Squad they have been assigned
	 *  
	 * @param fname
	 * @param sname
	 * @param age
	 * @param email
	 * @param position
	 * @param DOB
	 * @param squad
	 * @param postcode
	 * @param address
	 * @param phone_number
	 * @param SRU
	 * @param next_of_kin
	 * @param next_of_kin_telephone
	 * @param doctor
	 * @param doctor_telephone
	 * @param health_issues
	 */
	public Player(String fname, String sname, int age, String email, String position, String DOB, Squad squad, String postcode, String address, String phone_number, String SRU, String next_of_kin, 
			String next_of_kin_telephone, String doctor, String doctor_telephone, ArrayList<String> health_issues) {
		this.firstname = fname;
		this.surname = sname;
		this.age = age;
		this.squad = squad;
		this.squad.addPlayer(this);
		this.DOB = DOB;
		this.starting_team = false;
		this.bench = false;
		this.address = address;
		this.postcode = postcode;
		this.phone_number = phone_number;
		this.email = email;
		this.position = position;
		this.SRU = SRU;
		this.next_of_kin = next_of_kin;
		this.net_of_kin_telephone = next_of_kin_telephone;
		this.doctor = doctor;
		this.doctor_telephone = doctor_telephone;
		this.health_issues = health_issues;
		developmentPlan = null;
		initSkills();
	}
	
	/**
	 * 
	 * -- Getters
	 * 
	 */
	public String getFname() {
		return firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public int getAge() {
		return age;
	}
	
	public ArrayList<String> getHealthIssues() {
		return health_issues;
	}
	
	// Return DOB in the format "dd/MM/yyy"
	public String getDOB() {
		return DOB;
	}
	
	// Returns null value if no development plan
	public DevelopmentPlan getDevelopmentPlan() {
		return developmentPlan;
	}
	
	// Returns boolean value whether development plan is present or not
	public boolean hasDevelopmentPlan() {
		boolean plan = false;
		if (developmentPlan != null) {
			plan = true;
		}
		return plan;
	}
	
	public String getNext_of_kin_telephone() {
		return net_of_kin_telephone;
	}

	// Gets each skill from the players' skill list and displays the name and rating accordingly
	public void getSkills() {
		
		Iterator<Skill> it = skill_list.iterator();
		
		while (it.hasNext() == true) {
			Skill currSkill = it.next();
			
			if (currSkill != null) {
				System.out.println(currSkill.getName() + ": " + currSkill.getRating());
			}
			
		}
		
	}
	
	public ArrayList<Skill> getSkillList() {
		return skill_list;
	}
	
	public Squad getSquad() {
		return squad;
	}
	
	public String getNext_of_kin() {
		return next_of_kin;
	}

	public boolean inStartingTeam() {
		return starting_team;
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public String getSRU() {
		return SRU;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getDoctor_telephone() {
		return doctor_telephone;
	}

	public boolean on_bench() {
		return bench;
	}
	
	/**
	 * 
	 * -- Setters
	 * 
	 */
	public void setFname(String fname) {
		this.firstname = fname;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setDOB(String date) {
		this.DOB = date;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phone) {
		this.phone_number = phone;
	}
	
	public void setDevelopmentPlan(DevelopmentPlan plan) {
		this.developmentPlan = plan;
	}
	
	public void setSquad(Squad squad) {
		this.squad = squad;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setHealthIssues(ArrayList<String> issues) {
		this.health_issues = issues;
	}
	
	public void setNextOfKin(String NOK) {
		this.next_of_kin = NOK;
	}
	
	public void setNextOfKinTele(String tele) {
		this.net_of_kin_telephone = tele;
	}
	
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public void setDoctorTele(String doctor_tele) {
		this.doctor_telephone = doctor_tele;
	}
	
	public void setSRU(String SRU) {
		this.SRU = SRU;
	}
	
	public void setStartingTeam() {
		if (this.bench) {
			this.bench = false;
		}
		this.starting_team = true;
	}
	
	public void setBench() {
		if (this.starting_team) {
			this.starting_team = false;
		}
		this.bench = true;
	}
	
	public void removeFromTeam() {
		this.starting_team = false;
		this.bench = false;
	}
	
	public void addHealthIssue(String issue) {
		health_issues.add(issue);
	}
	
	/**
	 * 
	 * -- Methods
	 * 
	 */
	// Creates all the skills and adds them to the players' skill_list
	private void initSkills() {
		
		Skill strength;
		Skill sprintSpeed;
		Skill stamina;
		Skill tackling;
		Skill passing;
		Skill kicking;
		Skill decisionMaking;
		Skill catching;
		Skill positioning;
		Skill mauls;
		Skill teamwork;
		
		strength = new Skill("Strength", 0);
		sprintSpeed = new Skill("Sprint Speed", 0);
		stamina = new Skill("Stamina", 0);
		tackling = new Skill("Tackling", 0);
		passing = new Skill("Passing", 0);
		kicking = new Skill("Kicking", 0);
		decisionMaking = new Skill("Decision Making", 0);
		catching = new Skill("Catching", 0);
		positioning = new Skill("Positioning", 0);
		mauls = new Skill("Mauls", 0);
		teamwork = new Skill("Teamwork", 0);
		
		skill_list.add(teamwork);
		skill_list.add(strength);
		skill_list.add(sprintSpeed);
		skill_list.add(stamina);
		skill_list.add(tackling);
		skill_list.add(passing);
		skill_list.add(kicking);
		skill_list.add(decisionMaking);
		skill_list.add(catching);
		skill_list.add(positioning);
		skill_list.add(mauls);
		
	}
	
	public String toString() {
		return firstname + " " + surname;
	}
}
