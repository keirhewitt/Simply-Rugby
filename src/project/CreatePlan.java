package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class CreatePlan extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Controller cont;
	private Player pl;
	private int user;
	
	private Skill skills[];
	
	private JComboBox<Skill> comboBoxSkill1 = new JComboBox<>();
	private JComboBox<Skill> comboBoxSkill2 = new JComboBox<>();
	private JComboBox<Skill> comboBoxSkill3 = new JComboBox<>();
	
	private ArrayList<JRadioButton> group1 = new ArrayList<JRadioButton>();
	private ArrayList<JRadioButton> group2 = new ArrayList<JRadioButton>();
	private ArrayList<JRadioButton> group3 = new ArrayList<JRadioButton>();
	
	private ButtonGroup firstGroup = new ButtonGroup();
	private ButtonGroup secondGroup = new ButtonGroup();
	private ButtonGroup thirdGroup = new ButtonGroup();
	
	private JFormattedTextField txtProjectedDate;
	
	private HashMap<Skill, Integer> dPlanSet = new HashMap<Skill, Integer>();
	
	private ImageIcon background_img = new ImageIcon();
	
	public CreatePlan(Controller control, int coachID, Player player) {
		
		cont = control;
		pl = player;
		user = coachID;
		
		populateSkillsList(pl);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBorder(UIManager.getBorder("Tree.editorBorder"));
		panel.setBounds(64, 120, 735, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*
		 * 
		 *  skills
		 * 
		 */
		if (skills.length >0) {
			comboBoxSkill1 = new JComboBox<Skill>(skills);
		}
		
		comboBoxSkill1.setFont(new Font("Dialog", Font.BOLD, 13));
		/*
		   Put buttons in arrayList so they can be manipulated in large selections
		 */
		group1 = new ArrayList<JRadioButton>();
		firstGroup = new ButtonGroup();
						
		JRadioButton rBtnSkill1_1 = new JRadioButton("1");
		rBtnSkill1_1.setBackground(new Color(255, 250, 205));
		rBtnSkill1_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_1.setBounds(34, 79, 41, 23);
		panel.add(rBtnSkill1_1);
		
		JRadioButton rBtnSkill1_2 = new JRadioButton("2");
		rBtnSkill1_2.setBackground(new Color(255, 250, 205));
		rBtnSkill1_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_2.setBounds(77, 79, 41, 23);
		panel.add(rBtnSkill1_2);
		
		JRadioButton rBtnSkill1_3 = new JRadioButton("3");
		rBtnSkill1_3.setBackground(new Color(255, 250, 205));
		rBtnSkill1_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_3.setBounds(120, 79, 41, 23);
		panel.add(rBtnSkill1_3);
		
		JRadioButton rBtnSkill1_4 = new JRadioButton("4");
		rBtnSkill1_4.setBackground(new Color(255, 250, 205));
		rBtnSkill1_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_4.setBounds(163, 79, 41, 23);
		panel.add(rBtnSkill1_4);
		
		JRadioButton rBtnSkill1_5 = new JRadioButton("5");
		rBtnSkill1_5.setBackground(new Color(255, 250, 205));
		rBtnSkill1_5.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_5.setBounds(206, 79, 41, 23);
		panel.add(rBtnSkill1_5);
		
		JRadioButton rBtnSkill1_6 = new JRadioButton("6");
		rBtnSkill1_6.setBackground(new Color(255, 250, 205));
		rBtnSkill1_6.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_6.setBounds(249, 79, 41, 23);
		panel.add(rBtnSkill1_6);

		
		JRadioButton rBtnSkill1_7 = new JRadioButton("7");
		rBtnSkill1_7.setBackground(new Color(255, 250, 205));
		rBtnSkill1_7.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_7.setBounds(292, 79, 41, 23);
		panel.add(rBtnSkill1_7);

		
		JRadioButton rBtnSkill1_8 = new JRadioButton("8");
		rBtnSkill1_8.setBackground(new Color(255, 250, 205));
		rBtnSkill1_8.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_8.setBounds(335, 79, 41, 23);
		panel.add(rBtnSkill1_8);

		
		JRadioButton rBtnSkill1_9 = new JRadioButton("9");
		rBtnSkill1_9.setBackground(new Color(255, 250, 205));
		rBtnSkill1_9.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_9.setBounds(378, 79, 41, 23);
		panel.add(rBtnSkill1_9);

		
		JRadioButton rBtnSkill1_10 = new JRadioButton("10");
		rBtnSkill1_10.setBackground(new Color(255, 250, 205));
		rBtnSkill1_10.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill1_10.setBounds(421, 79, 41, 23);
		panel.add(rBtnSkill1_10);
		rBtnSkill1_10.setEnabled(true);
		
		/*
		 	Add all buttons to the groups
		 */
		group1.add(rBtnSkill1_10);
		group1.add(rBtnSkill1_9);
		group1.add(rBtnSkill1_8);
		group1.add(rBtnSkill1_7);
		group1.add(rBtnSkill1_6);
		group1.add(rBtnSkill1_5);
		group1.add(rBtnSkill1_4);
		group1.add(rBtnSkill1_3);
		group1.add(rBtnSkill1_2);
		group1.add(rBtnSkill1_1);
		
		/*
		 	Add to a button group to ensure only one radio button can be selected at a time
		 */
		firstGroup.add(rBtnSkill1_10);
		firstGroup.add(rBtnSkill1_9);
		firstGroup.add(rBtnSkill1_8);
		firstGroup.add(rBtnSkill1_7);
		firstGroup.add(rBtnSkill1_6);
		firstGroup.add(rBtnSkill1_5);
		firstGroup.add(rBtnSkill1_4);
		firstGroup.add(rBtnSkill1_3);
		firstGroup.add(rBtnSkill1_2);
		firstGroup.add(rBtnSkill1_1);
	
		comboBoxSkill1.setBounds(34, 37, 185, 22);
		panel.add(comboBoxSkill1);
		
		if (skills.length >0) {
			comboBoxSkill2 = new JComboBox<Skill>(skills);
		}
		comboBoxSkill2.setFont(new Font("Dialog", Font.BOLD, 13));
		group2 = new ArrayList<JRadioButton>();
		secondGroup = new ButtonGroup();
		
		
		JRadioButton rBtnSkill2_1 = new JRadioButton("1");
		rBtnSkill2_1.setBackground(new Color(255, 250, 205));
		rBtnSkill2_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_1.setBounds(34, 161, 41, 23);
		panel.add(rBtnSkill2_1);
		
		JRadioButton rBtnSkill2_2 = new JRadioButton("2");
		rBtnSkill2_2.setBackground(new Color(255, 250, 205));
		rBtnSkill2_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_2.setBounds(77, 161, 41, 23);
		panel.add(rBtnSkill2_2);
		
		JRadioButton rBtnSkill2_3 = new JRadioButton("3");
		rBtnSkill2_3.setBackground(new Color(255, 250, 205));
		rBtnSkill2_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_3.setBounds(120, 161, 41, 23);
		panel.add(rBtnSkill2_3);
		
		JRadioButton rBtnSkill2_4 = new JRadioButton("4");
		rBtnSkill2_4.setBackground(new Color(255, 250, 205));
		rBtnSkill2_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_4.setBounds(163, 161, 41, 23);
		panel.add(rBtnSkill2_4);
		
		JRadioButton rBtnSkill2_5 = new JRadioButton("5");
		rBtnSkill2_5.setBackground(new Color(255, 250, 205));
		rBtnSkill2_5.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_5.setBounds(206, 161, 41, 23);
		panel.add(rBtnSkill2_5);
		
		JRadioButton rBtnSkill2_6 = new JRadioButton("6");
		rBtnSkill2_6.setBackground(new Color(255, 250, 205));
		rBtnSkill2_6.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_6.setBounds(249, 161, 41, 23);
		panel.add(rBtnSkill2_6);
		
		JRadioButton rBtnSkill2_7 = new JRadioButton("7");
		rBtnSkill2_7.setBackground(new Color(255, 250, 205));
		rBtnSkill2_7.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_7.setBounds(292, 161, 41, 23);
		panel.add(rBtnSkill2_7);
		
		JRadioButton rBtnSkill2_8 = new JRadioButton("8");
		rBtnSkill2_8.setBackground(new Color(255, 250, 205));
		rBtnSkill2_8.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_8.setBounds(335, 161, 41, 23);
		panel.add(rBtnSkill2_8);
		
		JRadioButton rBtnSkill2_9 = new JRadioButton("9");
		rBtnSkill2_9.setBackground(new Color(255, 250, 205));
		rBtnSkill2_9.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_9.setBounds(378, 161, 41, 23);
		panel.add(rBtnSkill2_9);
		
		JRadioButton rBtnSkill2_10 = new JRadioButton("10");
		rBtnSkill2_10.setBackground(new Color(255, 250, 205));
		rBtnSkill2_10.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill2_10.setBounds(421, 161, 41, 23);
		panel.add(rBtnSkill2_10);
		
		group2.add(rBtnSkill2_1);
		group2.add(rBtnSkill2_2);
		group2.add(rBtnSkill2_3);
		group2.add(rBtnSkill2_4);
		group2.add(rBtnSkill2_5);
		group2.add(rBtnSkill2_6);
		group2.add(rBtnSkill2_7);
		group2.add(rBtnSkill2_8);
		group2.add(rBtnSkill2_9);
		group2.add(rBtnSkill2_10);
		
		secondGroup.add(rBtnSkill2_1);
		secondGroup.add(rBtnSkill2_2);
		secondGroup.add(rBtnSkill2_3);
		secondGroup.add(rBtnSkill2_4);
		secondGroup.add(rBtnSkill2_5);
		secondGroup.add(rBtnSkill2_6);
		secondGroup.add(rBtnSkill2_7);
		secondGroup.add(rBtnSkill2_8);
		secondGroup.add(rBtnSkill2_9);
		secondGroup.add(rBtnSkill2_10);
				
		comboBoxSkill2.setBounds(34, 121, 185, 22);
		panel.add(comboBoxSkill2);
		
		if (skills.length >0) {
			comboBoxSkill3 = new JComboBox<Skill>(skills);
		}
		comboBoxSkill3.setFont(new Font("Dialog", Font.BOLD, 13));
		group3 = new ArrayList<JRadioButton>();
		thirdGroup = new ButtonGroup();
		
		JRadioButton rBtnSkill3_1 = new JRadioButton("1");
		rBtnSkill3_1.setBackground(new Color(255, 250, 205));
		rBtnSkill3_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_1.setBounds(34, 243, 41, 23);
		panel.add(rBtnSkill3_1);
		
		JRadioButton rBtnSkill3_2 = new JRadioButton("2");
		rBtnSkill3_2.setBackground(new Color(255, 250, 205));
		rBtnSkill3_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_2.setBounds(77, 243, 41, 23);
		panel.add(rBtnSkill3_2);
		
		JRadioButton rBtnSkill3_3 = new JRadioButton("3");
		rBtnSkill3_3.setBackground(new Color(255, 250, 205));
		rBtnSkill3_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_3.setBounds(120, 243, 41, 23);
		panel.add(rBtnSkill3_3);
		
		JRadioButton rBtnSkill3_4 = new JRadioButton("4");
		rBtnSkill3_4.setBackground(new Color(255, 250, 205));
		rBtnSkill3_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_4.setBounds(163, 243, 41, 23);
		panel.add(rBtnSkill3_4);
		
		JRadioButton rBtnSkill3_5 = new JRadioButton("5");
		rBtnSkill3_5.setBackground(new Color(255, 250, 205));
		rBtnSkill3_5.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_5.setBounds(206, 243, 41, 23);
		panel.add(rBtnSkill3_5);
		
		JRadioButton rBtnSkill3_6 = new JRadioButton("6");
		rBtnSkill3_6.setBackground(new Color(255, 250, 205));
		rBtnSkill3_6.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_6.setBounds(249, 243, 41, 23);
		panel.add(rBtnSkill3_6);
		
		JRadioButton rBtnSkill3_7 = new JRadioButton("7");
		rBtnSkill3_7.setBackground(new Color(255, 250, 205));
		rBtnSkill3_7.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_7.setBounds(292, 243, 41, 23);
		panel.add(rBtnSkill3_7);
		
		JRadioButton rBtnSkill3_8 = new JRadioButton("8");
		rBtnSkill3_8.setBackground(new Color(255, 250, 205));
		rBtnSkill3_8.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_8.setBounds(335, 243, 41, 23);
		panel.add(rBtnSkill3_8);
		
		JRadioButton rBtnSkill3_9 = new JRadioButton("9");
		rBtnSkill3_9.setBackground(new Color(255, 250, 205));
		rBtnSkill3_9.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_9.setBounds(378, 243, 41, 23);
		panel.add(rBtnSkill3_9);
		
		JRadioButton rBtnSkill3_10 = new JRadioButton("10");
		rBtnSkill3_10.setBackground(new Color(255, 250, 205));
		rBtnSkill3_10.setFont(new Font("Dialog", Font.PLAIN, 11));
		rBtnSkill3_10.setBounds(421, 243, 41, 23);
		panel.add(rBtnSkill3_10);
		
		group3.add(rBtnSkill3_1);
		group3.add(rBtnSkill3_2);
		group3.add(rBtnSkill3_3);
		group3.add(rBtnSkill3_4);
		group3.add(rBtnSkill3_5);
		group3.add(rBtnSkill3_6);
		group3.add(rBtnSkill3_7);
		group3.add(rBtnSkill3_8);
		group3.add(rBtnSkill3_9);
		group3.add(rBtnSkill3_10);
		
		thirdGroup.add(rBtnSkill3_1);
		thirdGroup.add(rBtnSkill3_2);
		thirdGroup.add(rBtnSkill3_3);
		thirdGroup.add(rBtnSkill3_4);
		thirdGroup.add(rBtnSkill3_5);
		thirdGroup.add(rBtnSkill3_6);
		thirdGroup.add(rBtnSkill3_7);
		thirdGroup.add(rBtnSkill3_8);
		thirdGroup.add(rBtnSkill3_9);
		thirdGroup.add(rBtnSkill3_10);

		comboBoxSkill3.setBounds(34, 205, 185, 22);
		panel.add(comboBoxSkill3);
		
		
		/*
		 * 
		 *  labels ----------------------------------------¬
		 * 
		 */
		
		JLabel lblPlayerName = new JLabel(player.getFname() + " " + pl.getSurname());
		lblPlayerName.setForeground(new Color(240, 248, 255));
		lblPlayerName.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPlayerName.setBounds(64, 22, 369, 38);
		contentPane.add(lblPlayerName);
		
		JLabel lblPlayerSquad = new JLabel(player.getSquad().getName());
		lblPlayerSquad.setForeground(new Color(240, 248, 255));
		lblPlayerSquad.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerSquad.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblPlayerSquad.setBounds(64, 71, 342, 21);
		contentPane.add(lblPlayerSquad);
		
		
		/*
		 * 
		 *  buttons ---------------------------------------¬
		
		 * 
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				EditUser EU = new EditUser(pl, user, cont);
				EU.setLocationRelativeTo(null);
				EU.setVisible(true);
				
			}
			
		});
		btnBack.setBounds(64, 418, 114, 32);
		contentPane.add(btnBack);
		
		
		// Save button sets the skills and targets
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSkills();	
			}
		});
		btnSave.setBounds(685, 418, 114, 32);
		contentPane.add(btnSave);
		
		// ------------------------------------------------¬
		
		
		DateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
		DateFormatter formatter = new DateFormatter(format);
		txtProjectedDate = new JFormattedTextField(formatter);
		txtProjectedDate.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtProjectedDate.setBounds(573, 62, 226, 32);
		txtProjectedDate.setValue(new Date());
		contentPane.add(txtProjectedDate);
		txtProjectedDate.setColumns(10);
	
		
		
		JLabel lblNewLabel = new JLabel("Target Date: ");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(434, 63, 129, 29);
		contentPane.add(lblNewLabel);
		
		background_img = new ImageIcon("createplanbackground.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(884, 461,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		JLabel lblCreatePlanBackground = new JLabel("", background_img, JLabel.CENTER);
		lblCreatePlanBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatePlanBackground.setBounds(0, 0, 884, 461);
		contentPane.add(lblCreatePlanBackground);
	}
	
	
	/**
	 * Populate the skills array with Player skill objects
	 * @param Player 'p'
	 */
	public void populateSkillsList(Player p) {
		skills = new Skill[p.getSkillList().size()];
		skills = cont.getModel().getpsmodel().returnPlayerSkills(p);
	}
	
	/**
	 * Takes the inputs from the users - ComboBox selections and radio button targets
	 * Sorts the data -- if the selection was 0th index, do not count the skill
	 * Otherwise, add the SKill and the corresponding target to the DevelopmentPlan
	 * -- NO return value
	 */
	public void setSkills() {
		
		/*
		 	Initialise variables to be used - Date, 3 Skills and values
		 */
		boolean valid = true;
		ArrayList<Skill> planSkill = new ArrayList<Skill>();
		
		String date = "";
		
		Skill skill1 = null;
		Skill skill2 = null;
		Skill skill3 = null;
		
		int val1 = 0;
		int val2 = 0;
		int val3 = 0;
		
		/*
		 	Create a HashMap to hold the : (Skill) skill , (Integer) rating
		 */
		dPlanSet = new HashMap<Skill, Integer>();
		// Get each skill and it's target
		
		// -- SKILL 1 --
		// If the comboBox does not have 'N/A' selected
	
		
		/*
		 	If a target has been set in the group..
		 */
		if (cont.getModel().getDPModel().targetSet(group1)) {
			
			/*
			 	Convert the text value of the radio button into an integer - for the target value
			 */
			val1 = cont.getModel().getDPModel().setSkillTarget1(group1);
			skill1 = comboBoxSkill1.getModel().getElementAt(comboBoxSkill1.getSelectedIndex());
			
			/*
			 	Check to make sure the target rating is larger than the Players current rating
			 */
			if (cont.getModel().getpsmodel().validatePlanSkillRating(pl, skill1, val1) == false) {
				valid = false;
				displayMessage(skill1.getName() + " target is smaller than or equal to Players current rating!");
			}
			
			planSkill.add(skill1);
			dPlanSet.put(skill1, val1);

		/*	
		 	If a skill has been set and a target has not, then display message to user and set valid to false
		 */
		} else {
			valid = false;
			displayMessage("You need to enter a value for skill 1!");
		}
	 
	
		// -- SKILL 2 --
	

		
		if (cont.getModel().getDPModel().targetSet(group2)) {
			val2 = cont.getModel().getDPModel().setSkillTarget1(group2);
			skill2 = comboBoxSkill2.getModel().getElementAt(comboBoxSkill2.getSelectedIndex());
			
			/*
		 		Check to make sure the target rating is larger than the Players current rating
			 */
			if (cont.getModel().getpsmodel().validatePlanSkillRating(pl, skill2, val2) == false) {
				valid = false;
				displayMessage(skill2.getName() + " target is smaller than or equal to Players current rating!");
			}
			
			planSkill.add(skill2);
			dPlanSet.put(skill2, val2);
	
		} else {
			valid = false;
			displayMessage("You need to enter a value for skill 2!");
		}
	
		// -- SKILL 3 --
	
		if (cont.getModel().getDPModel().targetSet(group3)) {
			val3 = cont.getModel().getDPModel().setSkillTarget1(group3);
			skill3 = comboBoxSkill3.getModel().getElementAt(comboBoxSkill3.getSelectedIndex());
			
			/*
	 			Check to make sure the target rating is larger than the Players current rating
			 */
			if (cont.getModel().getpsmodel().validatePlanSkillRating(pl, skill3, val3) == false) {
				valid = false;
				displayMessage(skill3.getName() + " target is smaller than or equal to Players current rating!");
			}
			
			planSkill.add(skill3);
			dPlanSet.put(skill3, val3);
	
		} else {
			valid = false;
			displayMessage("You need to enter a value for skill 3!");
		} 

		
		if (cont.conflictingSkills(planSkill) == true) {
			valid = false;
			displayMessage("You cannot have more than one of the same skill!");
		}
		
		/*
		 	Get the date from the projectedDate text box
		 */
		date = txtProjectedDate.getText();
		
		/*
		  	Use the controller method to create the DevelopmentPlan if valid has not been set to false
		 */
		if (valid == true) {
			
			if (cont.createDevelopmentPlan(pl, dPlanSet, date) == true) {
				
				displayMessage("Development Plan Created!");
				
				/*
				 	Return to the EditUser screen
				 */
				dispose();
				EditUser EU = new EditUser(pl, user, cont);
				EU.setLocationRelativeTo(null);
				EU.setVisible(true);
				
			} else {
				displayMessage("Player already has development plan!");
			}
		}
	}
	
	/*
	 	DisplayMessage is always a useful popup dialog function
	 */
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
