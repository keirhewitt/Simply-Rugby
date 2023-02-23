package project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Junior player is the subclass for Player and implements no new data
 * 
 * This class only serves to establish the age difference between the two Player types
 * 
 * @author Keir
 * @since 01/04/21
 *
 */
public class JuniorPlayer extends Player implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int ageMax = 15;

	public JuniorPlayer(String fname, String sname, int age, String email, String position, String DOB, Squad squad, String postcode, String address, String phone_number, String SRU, String next_of_kin, 
			String next_of_kin_telephone, String doctor, String doctor_telephone, ArrayList<String> health_issues) {
		super(fname, sname, age, email, position, DOB, squad, postcode, address, phone_number, SRU, next_of_kin, next_of_kin_telephone, doctor, doctor_telephone, health_issues);
		super.setFname(fname);
		super.setSurname(sname);
		super.setAge(age);
		if (age > 15) {
			age = ageMax;
		}
		super.setDOB(DOB);
		super.setEmail(email);
		super.setPosition(position);
		super.setSquad(squad);
		super.setAddress(address);
		super.setDoctor(doctor);
		super.setDoctorTele(doctor_telephone);
		super.setNextOfKin(next_of_kin);
		super.setNextOfKinTele(next_of_kin_telephone);
		super.setPostcode(postcode);
		super.setSRU(SRU);
		super.setPhoneNumber(phone_number);
		super.setHealthIssues(health_issues);
	}

	
}
