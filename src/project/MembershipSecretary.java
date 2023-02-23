package project;

import java.io.Serializable;
/**
 * This class will outline the membership secretary role as an administrative type
 * 
 * They hold no personal information and oversee the creation and addition, removal, changing of coach/player information
 *  
 * @author Keir
 * @since 14/04/21
 */
public class MembershipSecretary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 	Unique ID's start from 1 then increment by 1
	 */
	private static int count = 1;
	private int loginID = 0;
	private String password;
	
	/*
 		Use TwinContainer to hold the login values of each coach
	 */
	private TwinContainer<Integer, String> loginCombo;
	
	/*
	 	Membership Secretary's only take passwords as a constructor parameter, loginID is assigned automatically
	 */
	public MembershipSecretary(String password) {
		this.loginID = count++;
		this.password = password;
		loginCombo = new TwinContainer<Integer, String>(this.loginID, password);
	}
	
	/*
 		Return the login combo using TwinContainer
	 */
	public TwinContainer<Integer, String> getLoginCombo() {
		return loginCombo;
	}
	
	/*
	 	Getters and setters
	 */
	public String getPass() {
		return password;
	}
	
	public int getID() {
		return loginID;
	}
	
}
