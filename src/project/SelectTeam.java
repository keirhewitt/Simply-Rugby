package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;


/**
 * SelectTeam is the GUI screen which allows for Coach users to select a starting team and bench 
 * 
 * @author Keir
 * @since 29/03/21
 */
public class SelectTeam extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Player[] players;
	private Coach thisCoach;
	private Controller myController;
	private int coachUser;
	
	@SuppressWarnings("rawtypes")
	private ArrayList<JComboBox> startingTeam = new ArrayList<JComboBox>();
	@SuppressWarnings("rawtypes")
	private ArrayList<JComboBox> benchTeam = new ArrayList<JComboBox>();
	
	// All of the starting positions
	private JComboBox<Player>comboBoxFullback = new JComboBox<Player>();
	private JComboBox<Player>comboBoxRightWing = new JComboBox<Player>();
	private JComboBox<Player>comboBoxLeftWing = new JComboBox<Player>();
	private JComboBox<Player>comboBoxOutsideC = new JComboBox<Player>();
	private JComboBox<Player>comboBoxInsideC = new JComboBox<Player>();
	private JComboBox<Player>comboBoxFlyHalf = new JComboBox<Player>();
	private JComboBox<Player>comboBoxScrumHalf = new JComboBox<Player>();
	private JComboBox<Player>comboBoxNumber8 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxOpenside = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBlindside = new JComboBox<Player>();
	private JComboBox<Player>comboBoxNumber5 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxTighthead = new JComboBox<Player>();
	private JComboBox<Player>comboBoxNumber4 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxLoosehead = new JComboBox<Player>();
	private JComboBox<Player>comboBoxHooker = new JComboBox<Player>();
	
	// Models for starting positions
	// modFB = 'model FullBack' etc..
	private DefaultComboBoxModel<Player> modFB = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modRW = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modLW = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modOC = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modIC = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modFH = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modSH = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modN8 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modOS = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modBS = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modN5 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modTH = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modN4 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modLH = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modH = new DefaultComboBoxModel<Player>();
	
	// All of the bench positions
	private JComboBox<Player>comboBoxBench1 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench2 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench3 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench4 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench5 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench6 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench7 = new JComboBox<Player>();
	private JComboBox<Player>comboBoxBench8 = new JComboBox<Player>();
	
	// Models for bench positions
	private DefaultComboBoxModel<Player> modB1 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB2 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB3 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB4 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB5 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB6 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB7 = new DefaultComboBoxModel<Player>();
	private DefaultComboBoxModel<Player> modB8 = new DefaultComboBoxModel<Player>();
	
	// Images
	private ImageIcon background_img = new ImageIcon();
	private JLabel background = new JLabel();
	
	
	
	@SuppressWarnings("rawtypes")
	public SelectTeam(int user, Controller cont) {
		
		coachUser = user;
		myController = cont;
		
		startingTeam = new ArrayList<JComboBox>();
		benchTeam = new ArrayList<JComboBox>();
		
		/*
		 	Store coach in type 'Coach'
		 */
		thisCoach = cont.getCoachObj(user);
		
		/*
		 	Populate the players array
		 */
		players = myController.populatePlayers(thisCoach);
		
		/*
		 	DefaultComboBoxModels for each player ComboBox
		 	Starting Team
		 */
		modFB = new DefaultComboBoxModel<Player>(players);
		modRW = new DefaultComboBoxModel<Player>(players);
		modLW = new DefaultComboBoxModel<Player>(players);
		modOC = new DefaultComboBoxModel<Player>(players);
		modIC = new DefaultComboBoxModel<Player>(players);
		modFH = new DefaultComboBoxModel<Player>(players);
		modSH = new DefaultComboBoxModel<Player>(players);
		modN8 = new DefaultComboBoxModel<Player>(players);
		modOS = new DefaultComboBoxModel<Player>(players);
		modBS = new DefaultComboBoxModel<Player>(players);
		modN5 = new DefaultComboBoxModel<Player>(players);
		modTH = new DefaultComboBoxModel<Player>(players);
		modN4 = new DefaultComboBoxModel<Player>(players);
		modLH = new DefaultComboBoxModel<Player>(players);
		modH = new DefaultComboBoxModel<Player>(players);
		
		/*
		 	Bench Team
		 */
		modB1 = new DefaultComboBoxModel<Player>(players);
		modB2 = new DefaultComboBoxModel<Player>(players);
		modB3 = new DefaultComboBoxModel<Player>(players);
		modB4 = new DefaultComboBoxModel<Player>(players);
		modB5 = new DefaultComboBoxModel<Player>(players);
		modB6 = new DefaultComboBoxModel<Player>(players);
		modB7 = new DefaultComboBoxModel<Player>(players);
		modB8 = new DefaultComboBoxModel<Player>(players);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 830);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		
		/**
		 * Set the back button ActionListener to dispose this screen and create an instance of CoachUserScreen then set visible
		 */
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CoachUserScreen CUS = new CoachUserScreen(coachUser, myController);
				CUS.setLocationRelativeTo(null);
				CUS.setVisible(true);
				
			}
			
		});
		
		JPanel jPanelTitle = new JPanel();
		jPanelTitle.setForeground(Color.BLACK);
		jPanelTitle.setBackground(new Color(213, 134, 145, 123));
		jPanelTitle.setBounds(362, 0, 465, 50);
		contentPane.add(jPanelTitle);
		btnBack.setBounds(1022, 753, 102, 27);
		contentPane.add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmTeam();
			}
			
		});
		btnSave.setBounds(899, 753, 102, 27);
		contentPane.add(btnSave);
		
		JPanel jPanelTeam = new JPanel();
		jPanelTeam.setBackground(new Color(213, 134, 145, 123));
		jPanelTeam.setBounds(45, 50, 1079, 562);
		contentPane.add(jPanelTeam);
		jPanelTeam.setLayout(null);
		
		///
				// Combo Box Positions [ Starting Team ]
			///
		
		comboBoxFullback = new JComboBox<Player>(modFB);
		comboBoxFullback.setBounds(30, 260, 124, 22);
		jPanelTeam.add(comboBoxFullback);
		
		comboBoxRightWing = new JComboBox<Player>(modRW);
		comboBoxRightWing.setBounds(150, 487, 124, 22);
		jPanelTeam.add(comboBoxRightWing);
		
		comboBoxLeftWing = new JComboBox<Player>(modLW);
		comboBoxLeftWing.setBounds(150, 47, 124, 22);
		jPanelTeam.add(comboBoxLeftWing);
		
		comboBoxOutsideC = new JComboBox<Player>(modOC);
		comboBoxOutsideC.setBounds(222, 414, 124, 22);
		jPanelTeam.add(comboBoxOutsideC);
		
		comboBoxInsideC = new JComboBox<Player>(modIC);
		comboBoxInsideC.setBounds(292, 334, 124, 22);
		jPanelTeam.add(comboBoxInsideC);
		
		comboBoxFlyHalf = new JComboBox<Player>(modFH);
		comboBoxFlyHalf.setBounds(360, 260, 124, 22);
		jPanelTeam.add(comboBoxFlyHalf);
		
		comboBoxScrumHalf = new JComboBox<Player>(modSH);
		comboBoxScrumHalf.setBounds(505, 260, 124, 22);
		jPanelTeam.add(comboBoxScrumHalf);
		
		comboBoxNumber8 = new JComboBox<Player>(modN8);
		comboBoxNumber8.setBounds(639, 260, 124, 22);
		jPanelTeam.add(comboBoxNumber8);
		
		comboBoxOpenside = new JComboBox<Player>(modOS);
		comboBoxOpenside.setBounds(639, 487, 124, 22);
		jPanelTeam.add(comboBoxOpenside);
		
		comboBoxBlindside = new JComboBox<Player>(modBS);
		comboBoxBlindside.setBounds(639, 47, 124, 22);
		jPanelTeam.add(comboBoxBlindside);
		
	    comboBoxNumber5 = new JComboBox<Player>(modN5);
		comboBoxNumber5.setBounds(806, 378, 124, 22);
		jPanelTeam.add(comboBoxNumber5);
		
		comboBoxTighthead = new JComboBox<Player>(modTH);
		comboBoxTighthead.setBounds(922, 487, 124, 22);
		jPanelTeam.add(comboBoxTighthead);
		
		comboBoxNumber4 = new JComboBox<Player>(modN4);
		comboBoxNumber4.setBounds(806, 155, 124, 22);
		jPanelTeam.add(comboBoxNumber4);
		
		comboBoxLoosehead = new JComboBox<Player>(modLH);
		comboBoxLoosehead.setBounds(922, 47, 124, 22);
		jPanelTeam.add(comboBoxLoosehead);
		
		comboBoxHooker = new JComboBox<Player>(modH);
		comboBoxHooker.setBounds(922, 260, 124, 22);
		jPanelTeam.add(comboBoxHooker);
		
		/*
		 	Add all starting team positions to an arraylist of JComboBox's
		 */
		startingTeam.add(comboBoxBlindside);
		startingTeam.add(comboBoxInsideC);
		startingTeam.add(comboBoxOutsideC);
		startingTeam.add(comboBoxHooker);
		startingTeam.add(comboBoxTighthead);
		startingTeam.add(comboBoxNumber4);
		startingTeam.add(comboBoxLoosehead);
		startingTeam.add(comboBoxOpenside);
		startingTeam.add(comboBoxNumber8);
		startingTeam.add(comboBoxScrumHalf);
		startingTeam.add(comboBoxFlyHalf);
		startingTeam.add(comboBoxNumber5);
		startingTeam.add(comboBoxLeftWing);
		startingTeam.add(comboBoxRightWing);
		startingTeam.add(comboBoxFullback);
		
		
		JLabel lblNewLabel = new JLabel("Fullback");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setBounds(30, 242, 68, 14);
		jPanelTeam.add(lblNewLabel);
		
		JLabel lblRightwing = new JLabel("Right-wing");
		lblRightwing.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRightwing.setBounds(150, 470, 68, 14);
		jPanelTeam.add(lblRightwing);
		
		JLabel lblLeftwing = new JLabel("Left-wing");
		lblLeftwing.setFont(new Font("Dialog", Font.BOLD, 13));
		lblLeftwing.setBounds(150, 31, 68, 14);
		jPanelTeam.add(lblLeftwing);
		
		JLabel lblOutsidecenter = new JLabel("Outside-Center");
		lblOutsidecenter.setFont(new Font("Dialog", Font.BOLD, 13));
		lblOutsidecenter.setBounds(222, 399, 94, 14);
		jPanelTeam.add(lblOutsidecenter);
		
		JLabel lblInsidecenter = new JLabel("Inside-Center");
		lblInsidecenter.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInsidecenter.setBounds(292, 318, 94, 14);
		jPanelTeam.add(lblInsidecenter);
		
		JLabel lblFlyhalf = new JLabel("Fly-half");
		lblFlyhalf.setFont(new Font("Dialog", Font.BOLD, 13));
		lblFlyhalf.setBounds(360, 243, 68, 14);
		jPanelTeam.add(lblFlyhalf);
		
		JLabel lblScrumhalf = new JLabel("Scrum-half");
		lblScrumhalf.setFont(new Font("Dialog", Font.BOLD, 13));
		lblScrumhalf.setBounds(505, 243, 82, 14);
		jPanelTeam.add(lblScrumhalf);
		
		JLabel lblNumber = new JLabel("Number 8");
		lblNumber.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNumber.setBounds(639, 243, 68, 14);
		jPanelTeam.add(lblNumber);
		
		JLabel lblOpensideflanker = new JLabel("Openside-Flanker");
		lblOpensideflanker.setFont(new Font("Dialog", Font.BOLD, 13));
		lblOpensideflanker.setBounds(639, 471, 112, 14);
		jPanelTeam.add(lblOpensideflanker);
		
		JLabel lblBlindsideflanker = new JLabel("Blindside-Flanker");
		lblBlindsideflanker.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBlindsideflanker.setBounds(639, 32, 112, 14);
		jPanelTeam.add(lblBlindsideflanker);
		
		JLabel lblNumberLock = new JLabel("Number-4 Lock");
		lblNumberLock.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNumberLock.setBounds(806, 139, 112, 14);
		jPanelTeam.add(lblNumberLock);
		
		JLabel lblNumberLock_1 = new JLabel("Number-5 Lock");
		lblNumberLock_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNumberLock_1.setBounds(806, 363, 112, 14);
		jPanelTeam.add(lblNumberLock_1);
		
		JLabel lblHooker = new JLabel("Hooker");
		lblHooker.setFont(new Font("Dialog", Font.BOLD, 13));
		lblHooker.setBounds(922, 243, 68, 14);
		jPanelTeam.add(lblHooker);
		
		JLabel lblLooseheadProp = new JLabel("Loosehead Prop");
		lblLooseheadProp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblLooseheadProp.setBounds(922, 32, 104, 14);
		jPanelTeam.add(lblLooseheadProp);
		
		JLabel lblTightheadProp = new JLabel("Tighthead Prop");
		lblTightheadProp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTightheadProp.setBounds(922, 471, 104, 14);
		jPanelTeam.add(lblTightheadProp);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setBounds(0, 0, 138, 36);
		jPanelTeam.add(lblTeam);
		lblTeam.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		
		JPanel jPanelBench = new JPanel();
		jPanelBench.setBackground(new Color(213, 134, 145, 123));
		jPanelBench.setBounds(45, 623, 844, 157);
		contentPane.add(jPanelBench);
		jPanelBench.setLayout(null);
		
		JLabel lblBench = new JLabel("Bench");
		lblBench.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		lblBench.setBounds(0, 0, 85, 40);
		jPanelBench.add(lblBench);
		
		
		///
				// Combo Box Positions [ Bench ]
			///
		
		comboBoxBench1 = new JComboBox<Player>(modB1);
		comboBoxBench1.setBounds(52, 51, 141, 22);
		jPanelBench.add(comboBoxBench1);
		
		comboBoxBench2 = new JComboBox<Player>(modB2);
		comboBoxBench2.setBounds(241, 51, 141, 22);
		jPanelBench.add(comboBoxBench2);
		
		comboBoxBench3 = new JComboBox<Player>(modB3);
		comboBoxBench3.setBounds(438, 51, 141, 22);
		jPanelBench.add(comboBoxBench3);
		
		comboBoxBench4 = new JComboBox<Player>(modB4);
		comboBoxBench4.setBounds(630, 51, 141, 22);
		jPanelBench.add(comboBoxBench4);
		
		comboBoxBench5 = new JComboBox<Player>(modB5);
		comboBoxBench5.setBounds(52, 107, 141, 22);
		jPanelBench.add(comboBoxBench5);
		
		comboBoxBench6 = new JComboBox<Player>(modB6);
		comboBoxBench6.setBounds(241, 107, 141, 22);
		jPanelBench.add(comboBoxBench6);
		
		comboBoxBench7 = new JComboBox<Player>(modB7);
		comboBoxBench7.setBounds(438, 107, 141, 22);
		jPanelBench.add(comboBoxBench7);
		
		comboBoxBench8 = new JComboBox<Player>(modB8);
		comboBoxBench8.setBounds(630, 107, 141, 22);
		jPanelBench.add(comboBoxBench8);
	
		/*
		 	Add all Bench positions to an arraylist of JComboBox's
		 */
		benchTeam.add(comboBoxBench1);
		benchTeam.add(comboBoxBench2);
		benchTeam.add(comboBoxBench3);
		benchTeam.add(comboBoxBench4);
		benchTeam.add(comboBoxBench5);
		benchTeam.add(comboBoxBench6);
		benchTeam.add(comboBoxBench7);
		benchTeam.add(comboBoxBench8);
		
		JLabel lblNewLabel_1 = new JLabel(thisCoach.getSquad().getName());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(45, 11, 1079, 28);
		contentPane.add(lblNewLabel_1);
		
		/**
		 * Set the background image
		 */
		background_img = new ImageIcon("rugbyfield.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(1150, 791,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		background = new JLabel("", background_img , JLabel.CENTER);
		background.setVisible(true);
		background.setBounds(0, 0, 1150, 791);
		contentPane.add(background);
		
	}
	
	/**
	 * Checks if there are any null combobox entries before confirming the team
	 * 
	 * @param ArrayList<JComboBox> start
	 * @param ArrayList<JComboBox> bench
	 * @return boolean
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean checkComboBoxObjects(ArrayList<JComboBox> start, ArrayList<JComboBox> bench) {
		boolean valid = true;
		
		/*
		 	Loop through and check if the index model object is null
		 */
		for (JComboBox<Player> J: start) {
			if (J.getModel().getSelectedItem() == null) {
				valid = false;
			}
		}
		
		for (JComboBox<Player> J: bench) {
			if (J.getModel().getSelectedItem() == null) {
				valid = false;
			}
		}
		
		return valid;
	}
	
	/**
	 * Gets the Coach object's team and adds all of the players to it
	 */
	public void confirmTeam() {
		
		if (checkComboBoxObjects(startingTeam, benchTeam) == true) {
		
			ArrayList<Player> theStartingTeam = new ArrayList<Player>();
			theStartingTeam = myController.convertStart(startingTeam);
			
			ArrayList<Player> theBenchTeam = new ArrayList<Player>();
			theBenchTeam = myController.convertBench(benchTeam);
			
			/*
		 		Make sure sizes are correct for team sizes, no duplicates in arrays
			 */
			if (theStartingTeam.size() != 15) {
				displayMessage("You need to select 15 players for the starting team!");
			} else if(theBenchTeam.size() != 8) {
				displayMessage("You need to select 8 players for the bench!");
			} else if (myController.checkForDuplicates(theStartingTeam) == true) {
				displayMessage("There are duplicate players in the starting team!");
			} else if (myController.checkForDuplicates(theBenchTeam) == true) {
				displayMessage("There are duplicate players on the bench!");
			} 
			
			Player p = (Player)comboBoxFullback.getSelectedItem();
			p.setPosition("Fullback");
			Player q = (Player)comboBoxRightWing.getSelectedItem();
			q.setPosition("Right Wing");
			Player r = (Player)comboBoxLeftWing.getSelectedItem();
			r.setPosition("Left Wing");
			Player s = (Player)comboBoxInsideC.getSelectedItem();
			s.setPosition("Inside-Center");
			Player t = (Player)comboBoxOutsideC.getSelectedItem();
			t.setPosition("Outside-Center");
			Player u = (Player)comboBoxFlyHalf.getSelectedItem();
			u.setPosition("Fly-Half");
			Player v = (Player)comboBoxScrumHalf.getSelectedItem();
			v.setPosition("Scrum-Half");
			Player w = (Player)comboBoxNumber8.getSelectedItem();
			w.setPosition("Number 8");
			Player x = (Player)comboBoxOpenside.getSelectedItem();
			x.setPosition("Openside");
			Player y = (Player)comboBoxBlindside.getSelectedItem();
			y.setPosition("Blindside");
			Player z = (Player)comboBoxNumber5.getSelectedItem();
			z.setPosition("Number 5");
			Player a = (Player)comboBoxTighthead.getSelectedItem();
			a.setPosition("Tighthead");
			Player b = (Player)comboBoxNumber4.getSelectedItem();
			b.setPosition("Number 4");
			Player c = (Player)comboBoxLoosehead.getSelectedItem();
			c.setPosition("Loosehead");
			Player d = (Player)comboBoxHooker.getSelectedItem();
			d.setPosition("Hooker");	
				
			/*
			 	Make sure there are no duplicates BETWEEN arrays -- i.e. if an element appears in both
			 */
			if (myController.checkOverlap(theStartingTeam, theBenchTeam) == false) {
				
				/*
				 	If the duplicate check returns false, add the Teams to the Coach object's Team object
				 */
				myController.clearTeam(thisCoach);
				myController.addTeam(thisCoach, theStartingTeam, theBenchTeam);
				displayMessage("Team saved.");
				
			} else {
				
				/*
				 	Display the relevant message for this error
				 */
				displayMessage("A player cannot appear more than once in the team!");
				
			}
		
		} else {
			displayMessage("Each position must have a player");
		}
			
	
	}
	
	// displays the supplied message
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
