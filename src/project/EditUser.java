package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 *  This page will show basic player information: Squad, age, phone number, email
 *  
 *  It will also display a section for showing a Development Plan if available
 *  
 *  There is a section displaying their skills - The name, the rating and two buttons per skill for increasing/decreasing the rating manually
 *  The user may also create and edit a skill plan from this page using the buttons provided
 *  
 * @author Keir
 * @since 18/04/21
 * 
 */
public class EditUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CoachUserScreen CUS;
	
	private Controller cont;
	private Player pl;
	private int theCoachID;
	
	private JButton btnSkill1Plus = new JButton();
	private JButton btnSkill2Plus = new JButton();
	private JButton btnSkill3Plus = new JButton();
	private JButton btnSkill4Plus = new JButton();
	private JButton btnSkill5Plus = new JButton();
	private JButton btnSkill6Plus = new JButton();
	private JButton btnSkill7Plus = new JButton();
	private JButton btnSkill8Plus = new JButton();
	private JButton btnSkill9Plus = new JButton();
	private JButton btnSkill10Plus = new JButton();
	private JButton btnSkill11Plus = new JButton();
	
	private JButton btnSkill1Minus = new JButton();
	private JButton btnSkill2Minus = new JButton();
	private JButton btnSkill3Minus = new JButton();
	private JButton btnSkill4Minus = new JButton();
	private JButton btnSkill5Minus = new JButton();
	private JButton btnSkill6Minus = new JButton();
	private JButton btnSkill7Minus = new JButton();
	private JButton btnSkill8Minus = new JButton();
	private JButton btnSkill9Minus = new JButton();
	private JButton btnSkill10Minus = new JButton();
	private JButton btnSkill11Minus = new JButton();
	
	private JLabel Skill1rating = new JLabel();
	private JLabel Skill2rating = new JLabel();
	private JLabel Skill3rating = new JLabel();
	private JLabel Skill4rating = new JLabel();
	private JLabel Skill5rating = new JLabel();
	private JLabel Skill6rating = new JLabel();
	private JLabel Skill7rating = new JLabel();
	private JLabel Skill8rating = new JLabel();
	private JLabel Skill9rating = new JLabel();
	private JLabel Skill10rating = new JLabel();
	private JLabel Skill11rating = new JLabel();

	private ArrayList<JButton> addButtons = new ArrayList<JButton>();
	private ArrayList<JButton> minusButtons = new ArrayList<JButton>();
	
	private JLabel lblSkill1 = new JLabel();
	private JLabel lblSkill2 = new JLabel();
	private JLabel lblSkill3 = new JLabel();
	
	private ImageIcon background_img = new ImageIcon();
	
	public EditUser(Player player, int coachID, Controller control) {
		
		cont = control;
		pl = player;
		theCoachID = coachID;
		
		addButtons = new ArrayList<JButton>();
		minusButtons = new ArrayList<JButton>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
	 		Create label by getting Name from Player object
		 */
		JLabel lblPlayerName = new JLabel(pl.getFname() + " " + pl.getSurname());
		lblPlayerName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPlayerName.setBounds(30, 16, 173, 19);
		contentPane.add(lblPlayerName);
		
		/*
	 		Create label by getting Age from Player object
		 */
		JLabel lblPlayerAge = new JLabel("Age: " + pl.getAge());
		lblPlayerAge.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPlayerAge.setBounds(30, 61, 220, 19);
		contentPane.add(lblPlayerAge);
		
		/*
	 		Create label by getting Squad from Player object
		 */
		JLabel lblPlayerSquad = new JLabel("Squad: " + pl.getSquad());
		lblPlayerSquad.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPlayerSquad.setBounds(30, 46, 220, 19);
		contentPane.add(lblPlayerSquad);
		
		/*
		 	Create label by getting PhoneNumber from Player object
		 */
		JLabel lblPlayerPhoneNumber = new JLabel("Phone Number: " + pl.getPhoneNumber());
		lblPlayerPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPlayerPhoneNumber.setBounds(30, 76, 220, 19);
		contentPane.add(lblPlayerPhoneNumber);
		
		/*
	 		Create label by getting Email from Player object
		 */
		JLabel lblPlayerEmail = new JLabel("Email: " + pl.getEmail());
		lblPlayerEmail.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPlayerEmail.setBounds(30, 91, 220, 19);
		contentPane.add(lblPlayerEmail);
		
		/*
		 	Label for Player skill plan (DevelopmentPlan)
		 */
		JLabel lblSkillPlan = new JLabel("Current Skill Development Plan");
		lblSkillPlan.setHorizontalAlignment(SwingConstants.LEFT);
		lblSkillPlan.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblSkillPlan.setBounds(30, 130, 662, 40);
		contentPane.add(lblSkillPlan);
		
	
		/*
		 * Triggers the removeSkillPlan() function to handle removing the Player objects DevelopmentPlan
		 */
		JButton btnRemovePlan = new JButton("Remove Skill Plan");
		btnRemovePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				removeSkillPlan();
				
			}
		});
		btnRemovePlan.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRemovePlan.setBounds(539, 460, 153, 40);
		contentPane.add(btnRemovePlan);
		
		// Disable the removePlan button if the Player object does not have a DevelopmentPlan
		if (!pl.hasDevelopmentPlan()) {
			btnRemovePlan.setEnabled(false);
		}
		
		/*
		 * Takes the User to the CreatePlan Screen
		 */
		JButton btnCreatePlan_1 = new JButton("Create Skill Plan");
		btnCreatePlan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreatePlan CP = new CreatePlan(cont, coachID, pl);
				CP.setLocationRelativeTo(null);
				CP.setVisible(true);
			}
		});
		btnCreatePlan_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCreatePlan_1.setBounds(360, 460, 153, 40);
		contentPane.add(btnCreatePlan_1);
		
		/*
		 * ====================================================================================================================
		 * ------------------------------------ >>> Skill Profile Section <<<--------------------------------------------------
		 * ====================================================================================================================
		 */
		
		/*
		 	Label for this whole section
		 */
		JLabel lblSkillProfile = new JLabel("Skill Profile");
		lblSkillProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblSkillProfile.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSkillProfile.setBounds(717, 31, 216, 34);
		contentPane.add(lblSkillProfile);
		
		/*
		 	Container for this whole section
		 */
		JPanel panelSkillProfile = new JPanel();
		panelSkillProfile.setBounds(717, 61, 357, 439);
		contentPane.add(panelSkillProfile);
		panelSkillProfile.setLayout(null);
		
		JPanel panelSkillContainer = new JPanel();
		panelSkillContainer.setBackground(Color.LIGHT_GRAY);
		panelSkillContainer.setBounds(0, 0, 357, 439);
		panelSkillProfile.add(panelSkillContainer);
		panelSkillContainer.setLayout(null);
		
		/*
		 	Create individual panels for each Skill
		 	(Repeated for each Skill)
		 */
		JPanel panelSkill1 = new JPanel();
		panelSkill1.setBounds(10, 11, 337, 28);
		panelSkillContainer.add(panelSkill1);
		panelSkill1.setLayout(null);
		
		/*
		 	Get the skill name from indexing the Player object's skill list
		 	(Repeated for each Skill)
		 */
		JLabel lblSkill1Name = new JLabel(pl.getSkillList().get(0).getName());
		lblSkill1Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill1Name.setBounds(0, 0, 193, 28);
		panelSkill1.add(lblSkill1Name);
		
		/*
	 		Get the skill rating from indexing the Player object's skill list - convert to String value
	 		(Repeated for each Skill)
		 */
		Skill1rating = new JLabel(Integer.toString(pl.getSkillList().get(0).getRating()));
		Skill1rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill1rating.setBounds(213, 0, 32, 28);
		panelSkill1.add(Skill1rating);
		
		/*
		 	Create the addition button next to the skill information
		 	(Repeated for each Skill)
		 */
		btnSkill1Plus = new JButton("+");
		btnSkill1Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill1Plus.setBounds(290, 0, 47, 29);
		panelSkill1.add(btnSkill1Plus);
		
		/*
		 	Create the subtraction button next to the addition button
		 	(Repeated for each Skill)
		 */
		btnSkill1Minus = new JButton("-");
		btnSkill1Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill1Minus.setBounds(246, 0, 47, 29);
		panelSkill1.add(btnSkill1Minus);
		
		/*
		 	Skill Panel
		 */
		
		JPanel panelSkill2 = new JPanel();
		panelSkill2.setBounds(10, 50, 337, 28);
		panelSkillContainer.add(panelSkill2);
		panelSkill2.setLayout(null);
		
		JLabel lblSkill2Name = new JLabel(pl.getSkillList().get(1).getName());
		lblSkill2Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill2Name.setBounds(0, 0, 208, 28);
		panelSkill2.add(lblSkill2Name);
		
		Skill2rating = new JLabel(Integer.toString(pl.getSkillList().get(1).getRating()));
		Skill2rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill2rating.setBounds(213, 0, 32, 28);
		panelSkill2.add(Skill2rating);
		
		btnSkill2Minus = new JButton("-");
		btnSkill2Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill2Minus.setBounds(246, 0, 47, 29);
		panelSkill2.add(btnSkill2Minus);
		
		btnSkill2Plus = new JButton("+");
		btnSkill2Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill2Plus.setBounds(290, 0, 47, 29);
		panelSkill2.add(btnSkill2Plus);
		
		JPanel panelSkill3 = new JPanel();
		panelSkill3.setBounds(10, 89, 337, 28);
		panelSkillContainer.add(panelSkill3);
		panelSkill3.setLayout(null);
		
		JLabel lblSkill3Name = new JLabel(pl.getSkillList().get(2).getName());
		lblSkill3Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill3Name.setBounds(0, 0, 216, 28);
		panelSkill3.add(lblSkill3Name);
		
		Skill3rating = new JLabel(Integer.toString(pl.getSkillList().get(2).getRating()));
		Skill3rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill3rating.setBounds(213, 0, 32, 28);
		panelSkill3.add(Skill3rating);
		
		btnSkill3Minus = new JButton("-");
		btnSkill3Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill3Minus.setBounds(246, 0, 47, 29);
		panelSkill3.add(btnSkill3Minus);
		
		btnSkill3Plus = new JButton("+");
		btnSkill3Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill3Plus.setBounds(290, 0, 47, 29);
		panelSkill3.add(btnSkill3Plus);
		
		JPanel panelSkill4 = new JPanel();
		panelSkill4.setBounds(10, 128, 337, 28);
		panelSkillContainer.add(panelSkill4);
		panelSkill4.setLayout(null);
		
		JLabel lblSkill4Name = new JLabel(pl.getSkillList().get(3).getName());
		lblSkill4Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill4Name.setBounds(0, 0, 216, 28);
		panelSkill4.add(lblSkill4Name);
		
		Skill4rating = new JLabel(Integer.toString(pl.getSkillList().get(3).getRating()));
		Skill4rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill4rating.setBounds(213, 0, 32, 28);
		panelSkill4.add(Skill4rating);
		
		btnSkill4Minus = new JButton("-");
		btnSkill4Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill4Minus.setBounds(246, 0, 47, 29);
		panelSkill4.add(btnSkill4Minus);
		
		btnSkill4Plus = new JButton("+");
		btnSkill4Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill4Plus.setBounds(290, 0, 47, 29);
		panelSkill4.add(btnSkill4Plus);
		
		JPanel panelSkill5 = new JPanel();
		panelSkill5.setBounds(10, 167, 337, 28);
		panelSkillContainer.add(panelSkill5);
		panelSkill5.setLayout(null);
		
		JLabel lblSkill5Name = new JLabel(pl.getSkillList().get(4).getName());
		lblSkill5Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill5Name.setBounds(0, 0, 216, 28);
		panelSkill5.add(lblSkill5Name);
		
		Skill5rating = new JLabel(Integer.toString(pl.getSkillList().get(4).getRating()));
		Skill5rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill5rating.setBounds(214, 0, 32, 28);
		panelSkill5.add(Skill5rating);
		
		btnSkill5Minus = new JButton("-");
		btnSkill5Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill5Minus.setBounds(246, 0, 47, 29);
		panelSkill5.add(btnSkill5Minus);
		
		btnSkill5Plus = new JButton("+");
		btnSkill5Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill5Plus.setBounds(290, 0, 47, 29);
		panelSkill5.add(btnSkill5Plus);
		
		JPanel panelSkill6 = new JPanel();
		panelSkill6.setBounds(10, 206, 337, 28);
		panelSkillContainer.add(panelSkill6);
		panelSkill6.setLayout(null);
		
		JLabel lblSkill6Name = new JLabel(pl.getSkillList().get(5).getName());
		lblSkill6Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill6Name.setBounds(0, 0, 216, 28);
		panelSkill6.add(lblSkill6Name);
		
		Skill6rating = new JLabel(Integer.toString(pl.getSkillList().get(5).getRating()));
		Skill6rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill6rating.setBounds(214, 0, 32, 28);
		panelSkill6.add(Skill6rating);
		
		btnSkill6Minus = new JButton("-");
		btnSkill6Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill6Minus.setBounds(246, 0, 47, 29);
		panelSkill6.add(btnSkill6Minus);
		
		btnSkill6Plus = new JButton("+");
		btnSkill6Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill6Plus.setBounds(290, 0, 47, 29);
		panelSkill6.add(btnSkill6Plus);
		
		JPanel panelSkill7 = new JPanel();
		panelSkill7.setBounds(10, 245, 337, 28);
		panelSkillContainer.add(panelSkill7);
		panelSkill7.setLayout(null);
		
		JLabel lblSkill7Name = new JLabel(pl.getSkillList().get(6).getName());
		lblSkill7Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill7Name.setBounds(0, 0, 216, 28);
		panelSkill7.add(lblSkill7Name);
		
		Skill7rating = new JLabel(Integer.toString(pl.getSkillList().get(6).getRating()));
		Skill7rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill7rating.setBounds(214, 0, 32, 28);
		panelSkill7.add(Skill7rating);
		
		btnSkill7Minus = new JButton("-");
		btnSkill7Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill7Minus.setBounds(246, 0, 47, 29);
		panelSkill7.add(btnSkill7Minus);
		
		btnSkill7Plus = new JButton("+");
		btnSkill7Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill7Plus.setBounds(290, 0, 47, 29);
		panelSkill7.add(btnSkill7Plus);
		
		JPanel panelSkill8 = new JPanel();
		panelSkill8.setBounds(10, 284, 337, 28);
		panelSkillContainer.add(panelSkill8);
		panelSkill8.setLayout(null);
		
		JLabel lblSkill8Name = new JLabel(pl.getSkillList().get(7).getName());
		lblSkill8Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill8Name.setBounds(0, 0, 216, 28);
		panelSkill8.add(lblSkill8Name);
		
		Skill8rating = new JLabel(Integer.toString(pl.getSkillList().get(7).getRating()));
		Skill8rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill8rating.setBounds(215, 0, 32, 28);
		panelSkill8.add(Skill8rating);
		
		btnSkill8Minus = new JButton("-");
		btnSkill8Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill8Minus.setBounds(246, 0, 47, 29);
		panelSkill8.add(btnSkill8Minus);
		
		btnSkill8Plus = new JButton("+");
		btnSkill8Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill8Plus.setBounds(290, 0, 47, 29);
		panelSkill8.add(btnSkill8Plus);
		
		JPanel panelSkill9 = new JPanel();
		panelSkill9.setBounds(10, 323, 337, 28);
		panelSkillContainer.add(panelSkill9);
		panelSkill9.setLayout(null);
		
		JLabel lblSkill9Name = new JLabel(pl.getSkillList().get(8).getName());
		lblSkill9Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill9Name.setBounds(0, 0, 216, 28);
		panelSkill9.add(lblSkill9Name);
		
		Skill9rating = new JLabel(Integer.toString(pl.getSkillList().get(8).getRating()));
		Skill9rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill9rating.setBounds(215, 0, 32, 28);
		panelSkill9.add(Skill9rating);
		
		btnSkill9Minus = new JButton("-");
		btnSkill9Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill9Minus.setBounds(246, -1, 47, 29);
		panelSkill9.add(btnSkill9Minus);
		
		btnSkill9Plus = new JButton("+");
		btnSkill9Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill9Plus.setBounds(290, -1, 47, 29);
		panelSkill9.add(btnSkill9Plus);
		
		JPanel panelSkill10 = new JPanel();
		panelSkill10.setBounds(10, 362, 337, 28);
		panelSkillContainer.add(panelSkill10);
		panelSkill10.setLayout(null);
		
		JLabel lblSkill10Name = new JLabel(pl.getSkillList().get(9).getName());
		lblSkill10Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill10Name.setBounds(0, 0, 216, 28);
		panelSkill10.add(lblSkill10Name);
		
		Skill10rating = new JLabel(Integer.toString(pl.getSkillList().get(9).getRating()));
		Skill10rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill10rating.setBounds(215, 0, 32, 28);
		panelSkill10.add(Skill10rating);
		
		btnSkill10Minus = new JButton("-");
		btnSkill10Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill10Minus.setBounds(246, 0, 47, 29);
		panelSkill10.add(btnSkill10Minus);
		
		btnSkill10Plus = new JButton("+");
		btnSkill10Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill10Plus.setBounds(290, 0, 47, 29);
		panelSkill10.add(btnSkill10Plus);
		
		JPanel panelSkill11 = new JPanel();
		panelSkill11.setBounds(10, 401, 337, 28);
		panelSkillContainer.add(panelSkill11);
		panelSkill11.setLayout(null);
		
		JLabel lblSkill11Name = new JLabel(pl.getSkillList().get(10).getName());
		lblSkill11Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSkill11Name.setBounds(0, 0, 216, 28);
		panelSkill11.add(lblSkill11Name);
		
		Skill11rating = new JLabel(Integer.toString(pl.getSkillList().get(10).getRating()));
		Skill11rating.setFont(new Font("Dialog", Font.BOLD, 18));
		Skill11rating.setBounds(215, 0, 32, 28);
		panelSkill11.add(Skill11rating);
		
		btnSkill11Minus = new JButton("-");
		btnSkill11Minus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill11Minus.setBounds(246, 0, 47, 29);
		panelSkill11.add(btnSkill11Minus);
		
		btnSkill11Plus = new JButton("+");
		btnSkill11Plus.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSkill11Plus.setBounds(290, 0, 47, 29);
		panelSkill11.add(btnSkill11Plus);
		
		/*
		 	Add all addition buttons to the addButtons arraylist
		 */
		addButtons.add(btnSkill1Plus);
		addButtons.add(btnSkill2Plus);
		addButtons.add(btnSkill3Plus);
		addButtons.add(btnSkill4Plus);
		addButtons.add(btnSkill5Plus);
		addButtons.add(btnSkill6Plus);
		addButtons.add(btnSkill7Plus);
		addButtons.add(btnSkill8Plus);
		addButtons.add(btnSkill9Plus);
		addButtons.add(btnSkill10Plus);
		addButtons.add(btnSkill11Plus);
		
		/*
	 		Add all minus buttons to the minusButtons arraylist
		 */
		minusButtons.add(btnSkill1Minus);
		minusButtons.add(btnSkill2Minus);
		minusButtons.add(btnSkill3Minus);
		minusButtons.add(btnSkill4Minus);
		minusButtons.add(btnSkill5Minus);
		minusButtons.add(btnSkill6Minus);
		minusButtons.add(btnSkill7Minus);
		minusButtons.add(btnSkill8Minus);
		minusButtons.add(btnSkill9Minus);
		minusButtons.add(btnSkill10Minus);
		minusButtons.add(btnSkill11Minus);
		
		/*
		 	Add the ActionListener methods to the Addition and Minus buttons
		 */
		buttonListenerAddition();
		buttonListenerMinus();
		
		
		
		// Dispose this screen and create main screen, set visible
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(30, 463, 151, 34);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				CUS = new CoachUserScreen(coachID, cont);
				CUS.setLocationRelativeTo(null);
				CUS.setVisible(true);
				
			}
		});
		
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		
	
		/*
		 * Panel for the Skill Plan
		 */
		JPanel panelSkillPlan = new JPanel();
		panelSkillPlan.setBackground(new Color(192, 192, 192));
		panelSkillPlan.setBounds(30, 168, 662, 281);
		contentPane.add(panelSkillPlan);
		panelSkillPlan.setLayout(null);
		
		JLabel lblSkillPlanInfo = new JLabel("'[ ]' = Player's current rating");
		lblSkillPlanInfo.setBackground(Color.YELLOW);
		lblSkillPlanInfo.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblSkillPlanInfo.setBounds(0, 267, 159, 14);
		panelSkillPlan.add(lblSkillPlanInfo);
		
		JLabel lblSkillPlanInfo_1 = new JLabel("'> <' = target rating");
		lblSkillPlanInfo_1.setBackground(Color.YELLOW);
		lblSkillPlanInfo_1.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblSkillPlanInfo_1.setBounds(160, 267, 134, 15);
		panelSkillPlan.add(lblSkillPlanInfo_1);
		
		JLabel lblSkillPlanInfo_1_1 = new JLabel("'* *' = target achieved");
		lblSkillPlanInfo_1_1.setBackground(Color.YELLOW);
		lblSkillPlanInfo_1_1.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblSkillPlanInfo_1_1.setBounds(290, 267, 150, 15);
		panelSkillPlan.add(lblSkillPlanInfo_1_1);
		
		JLabel lblRatingsHelp = new JLabel("Manually adjust player ratings");
		lblRatingsHelp.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblRatingsHelp.setBounds(934, 33, 150, 14);
		contentPane.add(lblRatingsHelp);
		
		JLabel lblNewLabel_1 = new JLabel("v             v");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(992, 49, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		background_img = new ImageIcon("rugbyskills.jpeg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(1084, 511,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		JLabel lblEditPBackground = new JLabel("", background_img, JLabel.CENTER);
		lblEditPBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditPBackground.setBounds(0, 0, 1084, 511);
		contentPane.add(lblEditPBackground);
		
		// If player has a development plan available
		// Then create theses components accordingly
		if(pl.hasDevelopmentPlan()) {
			
			// Check if each index of the skill list of the plan exists
			// If so, create the relevant component in this screen and show progress
				// Progress = current skill rating / target set by the development plan
			if(pl.getDevelopmentPlan().hasSkill(0)) {
				
				JLabel lblSkill1 = new JLabel(pl.getDevelopmentPlan().getSkillIndex(0).getName());
				lblSkill1.setFont(new Font("Dialog", Font.ITALIC, 14));
				lblSkill1.setBounds(10, 11, 224, 24);
				panelSkillPlan.add(lblSkill1);
			}
			
			
			if(pl.getDevelopmentPlan().hasSkill(1)) {

				JLabel lblSkill2 = new JLabel(pl.getDevelopmentPlan().getSkillIndex(1).getName());
				lblSkill2.setFont(new Font("Dialog", Font.ITALIC, 14));
				lblSkill2.setBounds(10, 82, 224, 24);
				panelSkillPlan.add(lblSkill2);
			
			}
			
			if(pl.getDevelopmentPlan().hasSkill(2)) {
			
				JLabel lblSkill3 = new JLabel(pl.getDevelopmentPlan().getSkillIndex(2).getName());
				lblSkill3.setFont(new Font("Dialog", Font.ITALIC, 14));
				lblSkill3.setBounds(10, 158, 224, 24);
				panelSkillPlan.add(lblSkill3);
			
			}
			
			/*
			 	Try/catch to validate skill data
			 */
			try {
				
				/*
				 	If the Skill index is available
				 */
				
				if(pl.getDevelopmentPlan().hasSkill(0)) {
					
					/*
					 	Create a progress bar, where the starting value is the current rating and the end value is the target rating - repeat for 3 skills
					 */
					lblSkill1 = new JLabel(cont.displayDevelopmentPlanValues(pl.getDevelopmentPlan().getSkillIndex(0).getRating(), pl.getDevelopmentPlan().getSkillIndex(0).getTarget()));
					lblSkill1.setBounds(20, 46, 464, 25);
					lblSkill1.setFont(new Font("Arial Black", Font.BOLD, 20));
					panelSkillPlan.add(lblSkill1);
				}
				
				if(pl.getDevelopmentPlan().hasSkill(1)) {
					
					lblSkill2 = new JLabel(cont.displayDevelopmentPlanValues(pl.getDevelopmentPlan().getSkillIndex(1).getRating(), pl.getDevelopmentPlan().getSkillIndex(1).getTarget()));
					lblSkill2.setBounds(20, 122, 464, 25);
					lblSkill2.setFont(new Font("Arial Black", Font.BOLD, 20));
					panelSkillPlan.add(lblSkill2);
				}
				
				if(pl.getDevelopmentPlan().hasSkill(2)) {
					
					lblSkill3 = new JLabel(cont.displayDevelopmentPlanValues(pl.getDevelopmentPlan().getSkillIndex(2).getRating(), pl.getDevelopmentPlan().getSkillIndex(2).getTarget()));
					lblSkill3.setBounds(20, 193, 464, 25);
					lblSkill3.setFont(new Font("Arial Black", Font.BOLD, 20));
					panelSkillPlan.add(lblSkill3);					
				}
			
			/*
			 	If the program takes an illegal argument i.e. less than 0, or more than 10 - disable the Edit Plan button
			 */
			} catch (IllegalArgumentException e) {
				System.out.println("Error getting plan info");
				btnRemovePlan.setEnabled(false);
			}
			
		/*
		 	If the player does not have a skill plan, display label with message
		 */
		} else {
			
			JLabel lblNewLabel = new JLabel("[ No Skill Plan Available ]");
			lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 16));
			lblNewLabel.setBounds(168, 99, 189, 36);
			panelSkillPlan.add(lblNewLabel);
			
		}
		
	}
	
	/**
	 * Function to consolidate the action listener methods for the Skill Rating addition buttons
	 */
	public void buttonListenerAddition() {
		
		ActionListener addListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 	Determine which addition button has been pressed
				 */
				if (e.getSource() == btnSkill1Plus) {
					
					/*
					 	Get the players skill list, get the equivalent index and increase rating by 1
					 */
					pl.getSkillList().get(0).increaseRating(1);
					
					/*
					 	Parse the rating label as an integer, Increase it by 1, then re-parse result as String and set the label to the new value
					 */
					int skill1 = Integer.parseInt(Skill1rating.getText());
					skill1 += 1;
					if (skill1 > 10) {
						skill1 = 10;
					}
					Skill1rating.setText(Integer.toString(skill1));
					
				} else if (e.getSource() == btnSkill2Plus) {
					
					pl.getSkillList().get(1).increaseRating(1);
					
					int skill2 = Integer.parseInt(Skill2rating.getText());
					skill2 += 1;
					if (skill2 > 10) {
						skill2 = 10;
					}
					Skill2rating.setText(Integer.toString(skill2));
					
				} else if (e.getSource() == btnSkill3Plus) {
					
					pl.getSkillList().get(2).increaseRating(1);
					
					int skill3 = Integer.parseInt(Skill3rating.getText());
					skill3 += 1;
					if (skill3 > 10) {
						skill3 = 10;
					}
					Skill3rating.setText(Integer.toString(skill3));
					
				} else if (e.getSource() == btnSkill4Plus) {
					
					pl.getSkillList().get(3).increaseRating(1);
					
					int skill4 = Integer.parseInt(Skill4rating.getText());
					skill4 += 1;
					if (skill4 > 10) {
						skill4 = 10;
					}
					Skill4rating.setText(Integer.toString(skill4));
					
				} else if (e.getSource() == btnSkill5Plus) {
					
					pl.getSkillList().get(4).increaseRating(1);
					
					int skill5 = Integer.parseInt(Skill5rating.getText());
					skill5 += 1;
					if (skill5 > 10) {
						skill5 = 10;
					}
					Skill5rating.setText(Integer.toString(skill5));
					
				} else if (e.getSource() == btnSkill6Plus) {
					
					pl.getSkillList().get(5).increaseRating(1);
					
					int skill6 = Integer.parseInt(Skill6rating.getText());
					skill6 += 1;
					if (skill6 > 10) {
						skill6 = 10;
					}
					Skill6rating.setText(Integer.toString(skill6));
					
				} else if (e.getSource() == btnSkill7Plus) {
					
					pl.getSkillList().get(6).increaseRating(1);
					
					int skill7 = Integer.parseInt(Skill7rating.getText());
					skill7 += 1;
					if (skill7 > 10) {
						skill7 = 10;
					}
					Skill7rating.setText(Integer.toString(skill7));
					
				} else if (e.getSource() == btnSkill8Plus) {
					
					pl.getSkillList().get(7).increaseRating(1);
					
					int skill8 = Integer.parseInt(Skill8rating.getText());
					skill8 += 1;
					if (skill8 > 10) {
						skill8 = 10;
					}
					Skill8rating.setText(Integer.toString(skill8));
					
				} else if (e.getSource() == btnSkill9Plus) {
					
					pl.getSkillList().get(8).increaseRating(1);
					
					int skill9 = Integer.parseInt(Skill9rating.getText());
					skill9 += 1;
					if (skill9 > 10) {
						skill9 = 10;
					}
					Skill9rating.setText(Integer.toString(skill9));
					
				} else if (e.getSource() == btnSkill10Plus) {
					
					pl.getSkillList().get(9).increaseRating(1);
					
					int skill10 = Integer.parseInt(Skill10rating.getText());
					skill10 += 1;
					if (skill10 > 10) {
						skill10 = 10;
					}
					Skill10rating.setText(Integer.toString(skill10));
					
				} else if (e.getSource() == btnSkill11Plus) {
					
					pl.getSkillList().get(10).increaseRating(1);
					
					int skill11 = Integer.parseInt(Skill11rating.getText());
					skill11 += 1;
					if (skill11 > 10) {
						skill11 = 10;
					}
					Skill11rating.setText(Integer.toString(skill11));
					
				}
				
			}
			
		};
		
		/*
		 	Add action listeners to all the Add buttons of this instance of ActionListener and subsequently this method
		 */
		for (JButton j: addButtons) {
			j.addActionListener(addListener);
		}
	}
	
	/**
	 * Function to consolidate the action listener methods for the Skill Rating minus buttons
	 */
	public void buttonListenerMinus() {
		
		ActionListener minusListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 	Determine which minus button has been pressed
				 */
				if (e.getSource() == btnSkill1Minus) {
					
					/*
					 	Get the players skill list, get the equivalent index and decrease rating by 1
					 */
					pl.getSkillList().get(0).decreaseRating(1);
					
					/*
					 	Parse the rating label as an integer, Decrease it by 1, then re-parse result as String and set the label to the new value
					 */
					int skill1 = Integer.parseInt(Skill1rating.getText());
					skill1 -= 1;
					if (skill1 < 0) {
						skill1 = 0;
					}
					Skill1rating.setText(Integer.toString(skill1));
					
				} else if (e.getSource() == btnSkill2Minus) {
					
					pl.getSkillList().get(1).decreaseRating(1);
					
					int skill2 = Integer.parseInt(Skill2rating.getText());
					skill2 -= 1;
					if (skill2 < 0) {
						skill2 = 0;
					}
					Skill2rating.setText(Integer.toString(skill2));
					
				} else if (e.getSource() == btnSkill3Minus) {
					
					pl.getSkillList().get(2).decreaseRating(1);
					
					int skill3 = Integer.parseInt(Skill3rating.getText());
					skill3 -= 1;
					if (skill3 < 0) {
						skill3 = 0;
					}
					Skill3rating.setText(Integer.toString(skill3));
					
				} else if (e.getSource() == btnSkill4Minus) {
					
					pl.getSkillList().get(3).decreaseRating(1);
					
					int skill4 = Integer.parseInt(Skill4rating.getText());
					skill4 -= 1;
					if (skill4 < 0) {
						skill4 = 0;
					}
					Skill4rating.setText(Integer.toString(skill4));
					
				} else if (e.getSource() == btnSkill5Minus) {
					
					pl.getSkillList().get(4).decreaseRating(1);
					
					int skill5 = Integer.parseInt(Skill5rating.getText());
					skill5 -= 1;
					if (skill5 < 0) {
						skill5 = 0;
					}
					Skill5rating.setText(Integer.toString(skill5));
					
				} else if (e.getSource() == btnSkill6Minus) {
					
					pl.getSkillList().get(5).decreaseRating(1);
					
					int skill6 = Integer.parseInt(Skill6rating.getText());
					skill6 -= 1;
					if (skill6 < 0) {
						skill6 = 0;
					}
					Skill6rating.setText(Integer.toString(skill6));
					
				} else if (e.getSource() == btnSkill7Minus) {
					
					pl.getSkillList().get(6).decreaseRating(1);
					
					int skill7 = Integer.parseInt(Skill7rating.getText());
					skill7 -= 1;
					if (skill7 < 0) {
						skill7 = 0;
					}
					Skill7rating.setText(Integer.toString(skill7));
					
				} else if (e.getSource() == btnSkill8Minus) {
					
					pl.getSkillList().get(7).decreaseRating(1);
					
					int skill8 = Integer.parseInt(Skill8rating.getText());
					skill8 -= 1;
					if (skill8 < 0) {
						skill8 = 0;
					}
					Skill8rating.setText(Integer.toString(skill8));
					
				} else if (e.getSource() == btnSkill9Minus) {
					
					pl.getSkillList().get(8).decreaseRating(1);
					
					int skill9 = Integer.parseInt(Skill9rating.getText());
					skill9 -= 1;
					if (skill9 < 0) {
						skill9 = 0;
					}
					Skill9rating.setText(Integer.toString(skill9));
					
				} else if (e.getSource() == btnSkill10Minus) {
					
					pl.getSkillList().get(9).decreaseRating(1);
					
					int skill10 = Integer.parseInt(Skill10rating.getText());
					skill10 -= 1;
					if (skill10 < 0) {
						skill10 = 0;
					}
					Skill10rating.setText(Integer.toString(skill10));
					
				} else if (e.getSource() == btnSkill11Minus) {
					
					pl.getSkillList().get(10).decreaseRating(1);
					
					int skill11 = Integer.parseInt(Skill11rating.getText());
					skill11 -= 1;
					if (skill11 < 0) {
						skill11 = 0;
					}
					Skill11rating.setText(Integer.toString(skill11));
					
				}
				
			}
			
		};
		
		/*
	 	Add action listeners to all the Add buttons of this instance of ActionListener and subsequently this method
		 */
		for (JButton j: minusButtons) {
			j.addActionListener(minusListener);
		}
	}
	
	/**
	 * Set the Player DevelopmentPlan = null
	 */
	public void removeSkillPlan() {
		
		pl.setDevelopmentPlan(null);
		
		/*
		 	Checks if User doesn't have a development plan
		 */
		if (!pl.hasDevelopmentPlan()) {
			
			/*
			 	If so, show message confirmation and re-load screen
			 */
			displayMessage("Development Plan removed!");
			
			dispose();
			EditUser EU = new EditUser(pl, theCoachID, cont);
			EU.setLocationRelativeTo(null);
			EU.setVisible(true);
			
		} else {
			
			displayMessage("User has no plan to remove");
			
		}
	}
	
	// Making messages to user for accessible
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
