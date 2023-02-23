package project;

import java.io.Serializable;

/**
 * This class extends the Squad class and has no unique data, it is used to establish the difference between Junior and Senior players
 * 
 * @author Keir
 * @since 01/05/21
 */
public class SquadJunior extends Squad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Overloaded Constructor - inherited
	 * 
	 * @param name
	 */
	public SquadJunior(String name) {
		super(name);
		super.setName(name);
		super.setLimit(28);
		super.setType("Junior");
	}
	
	/**
	 * 2nd Overloaded Constructor - inherited
	 * 
	 * @param name
	 */
	public SquadJunior(String name, Coach coach) {
		super(name, coach);
		super.setName(name);
		super.setLimit(28);
		super.setType("Junior");
	}

}
