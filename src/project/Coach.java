package project;

import java.io.Serializable;

/**
 * Coaches oversee Squad and player decisions, ultimately not participating in the adding, editing or removal of key information
 * 
 * They oversee TrainingSession creation/editing, TeamSelection, DevelopmentPlan creation/editing and various management duties
 * 
 * @author Keir
 * @since 12/04/21
 */
public class Coach implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 	login ID will be auto-assigned
	 	[ Unique ID's start from 1 then increment by 1]
	 */
	private static int count = 1;
	private int ID = 0;
	private String password;
	private String firstname;
	private String surname;
	private String telephone;
	private String email;
	private String address;
	private String postcode;
	private Squad squad;
	
	/*
	 	Use Generic class to hold the login values of each coach
	 */
	private TwinContainer<Integer, String> loginCombo;
	
	/*
	 	Constructor will take a password and assign the next unique ID number, also assigning personal details
	 	ID will be the static variable 'count' incremented each time
	 */
	public Coach(Squad squad, String password, String telephone, String email, String address, String postcode, String firstname, String surname) {
		this.setSquad(squad);
		this.ID = count++;
		this.password = password;
		this.firstname = firstname;
		this.surname = surname;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.postcode = postcode;
		loginCombo = new TwinContainer<Integer, String>(this.ID, password);
	}
	
	/*
	 	Return the login combo using TwinContainer
	 */
	public TwinContainer<Integer, String> getLoginCombo() {
		return loginCombo;
	}
	
	/*
	 	Getters and Setters
	 */
	public int getLoginID() {
		return ID;
	}

	public String getPass() {
		return password;
	}
	
	public Squad getSquad() {
		return squad;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPostcode() {
		return postcode;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getPhone() {
		return telephone;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void setSquad(Squad squad) {
		if (squad != null) {
			squad.setCoach(this);
		}
		this.squad = squad;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * Overridden toString method
	 * 
	 * @return String 
	 */
	public String toString() {
		return firstname + " " + surname;
	}
	
}
