package project;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 * This is the main page for the Coach users
 * 
 * It gives them various options:
 * 		Edit a Player which is selected in the comboBox
 * 		Edit a TrainingSession which may be selected using the JTable
 * 		Create a TrainingSession
 * 		Select a Team lineup
 * 
 * @author Keir
 * @since 01/04/21
 */
public class CoachUserScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Player players[];
	private int coachID;
	private Coach thisCoach;
	private JPanel contentPane;
	private JTable trainingSessionsTable;
	
	private int index;
	private Controller cont;
	
	private ImageIcon background_img = new ImageIcon();
	
	private JComboBox<Player> playersComboBox = new JComboBox<Player>();
	
	/**
	 * Create the frame.
	 */
	public CoachUserScreen(int user, Controller control) {
		
		// Initialise as -1 so that it can be used for determining if an element in the JTable has been selected
		// .. i.e. if index == -1 then no element has been selected
		index = -1;
		
		coachID = user;
		cont = control;
		thisCoach = cont.getCoachObj(coachID);
		
		/*
		 	Populate the players array using the Controller method
		 */
		players = cont.populatePlayers(thisCoach);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Gets the currently selected player from the combo box and passes it through the contstructor for the EditUser GUI
		JButton btnEditPlayer = new JButton("Edit Player");
		btnEditPlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnEditPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				/*
				 	Implement try/catch incase the user tries to trigger this without a Player object selected
				 */
				try {
					
					/*
				 		Store the player selected from the playersComboBox, pass it through the EditUser constructor
					 */
					Player selected = (Player)playersComboBox.getModel().getSelectedItem();
					EditUser EU = new EditUser(selected, coachID, cont);
					EU.setLocationRelativeTo(null);
					EU.setVisible(true);
					
				} catch (NullPointerException np) {
					
					displayMessage("No player selected!");
				}
			}
		});
		
		
		/*
		 	Create the comboBox using the player array, initialised at the start of the constructor
		 */
		playersComboBox = new JComboBox<Player>(players);  // <<<<<<<<<<<<<<<<<<<<<<<<<< players
		playersComboBox.setFont(new Font("Dialog", Font.BOLD, 16));
		playersComboBox.setBounds(687, 62, 333, 37);
		
		// Creates a constructor for CreateTrainingSessionScreen
		// Dispose this screen, make new screen visible
		JButton btnCreateTrainingSession = new JButton("Create Training Session");
		btnCreateTrainingSession.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCreateTrainingSession.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateTrainingSessionScreen CTSS = new CreateTrainingSessionScreen(coachID, cont);
				CTSS.setLocationRelativeTo(null);
				CTSS.setVisible(true);
			}
			
		});
		btnCreateTrainingSession.setBounds(822, 462, 237, 37);
		btnEditPlayer.setBounds(837, 110, 183, 37);
		
		JLabel lblNewLabel = new JLabel("Training Sessions");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 237, 170, 26);
		
		/*
		 	This button navigates to the SelectTeam screen
		 */
		JButton btnSelectTeam = new JButton("Select Team");
		btnSelectTeam.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSelectTeam.setBounds(822, 226, 237, 37);
		btnSelectTeam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectTeam ST = new SelectTeam(coachID, cont);
				ST.setLocationRelativeTo(null);
				ST.setVisible(true);
				
			}
			
		});
		
		/*
		 	Stores the index of the row selected and passes it through to the editTrainingSession() function
		 */
		JButton btnEditTrainingSession = new JButton("Edit Training Session");
		btnEditTrainingSession.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnEditTrainingSession.setBounds(569, 462, 237, 37);
		btnEditTrainingSession.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				index = trainingSessionsTable.getSelectedRow();
				
				editTrainingSession(index);
			}
			
		});
		
	
		contentPane.setLayout(null);
		contentPane.add(btnEditPlayer);
		contentPane.add(playersComboBox);
		contentPane.add(btnSelectTeam);
		contentPane.add(btnCreateTrainingSession);
		contentPane.add(btnEditTrainingSession);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChooseLogin CL = new ChooseLogin(cont);
				CL.setLocationRelativeTo(null);
				CL.setVisible(true);
				
			}
			
		});
		btnBack.setBounds(10, 462, 127, 37);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 274, 1044, 177);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		// Calls on the controller to create the table and populate it with the training sessions currently housed
		// ... within the TSessionModel arraylist
		// Whenever this class is created, it will update this table by recreating it
		trainingSessionsTable = new JTable(cont.createTable(thisCoach));
		scrollPane.setViewportView(trainingSessionsTable);
		trainingSessionsTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		trainingSessionsTable.setBackground(new Color(255, 255, 255));
		trainingSessionsTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		trainingSessionsTable.setForeground(new Color(25, 25, 112));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(664, 37, 395, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEditThePlayer = new JLabel("Edit the Player in the drop down box");
		lblEditThePlayer.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblEditThePlayer.setBounds(181, 119, 204, 14);
		panel_1.add(lblEditThePlayer);
		
		/*
		 	Create the background image
		 	Scale it to the right size
		 */
		background_img = new ImageIcon("coachmainbackground.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(1084, 511,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		JPanel panelHeading = new JPanel();
		panelHeading.setBackground(Color.LIGHT_GRAY);
		panelHeading.setBounds(20, 37, 604, 133);
		contentPane.add(panelHeading);
		panelHeading.setLayout(null);
		
		JLabel lblWelcomeCoach = new JLabel("Welcome: " + thisCoach.getFirstname() + " " + thisCoach.getSurname());
		lblWelcomeCoach.setBounds(10, 11, 314, 37);
		panelHeading.add(lblWelcomeCoach);
		lblWelcomeCoach.setForeground(Color.WHITE);
		lblWelcomeCoach.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JLabel lblSquadLabel = new JLabel("Squad: " + thisCoach.getSquad());
		lblSquadLabel.setBounds(10, 59, 273, 31);
		panelHeading.add(lblSquadLabel);
		lblSquadLabel.setForeground(Color.WHITE);
		lblSquadLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblTSessionHelp = new JLabel("Select a session from the table *");
		lblTSessionHelp.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblTSessionHelp.setBounds(387, 486, 172, 14);
		contentPane.add(lblTSessionHelp);
		
		JLabel lblMainBackground = new JLabel("", background_img, JLabel.CENTER);
		lblMainBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainBackground.setBounds(0, 0, 1084, 511);
		contentPane.add(lblMainBackground);
		
		/*
		 	Change the row height to make it look better
		 */
		for (int i = 0; i < trainingSessionsTable.getRowCount(); i++) {
			trainingSessionsTable.setRowHeight(i, 35);
		}
	}
	
	/**
	 * Takes the index parameter of what row the user has selected from the JTable
	 * Creates an instance of EditTrainingSession with the index
	 * Catches the out of bounds error if the user selects a row which is null
	 * @param index
	 */
	public void editTrainingSession(int index) {
		
		String s = "";
		
		try {
			s = (String)trainingSessionsTable.getModel().getValueAt(index, 1);
			
		/*
		 	If it catches the error, set 's' to empty and the displayMessage will take care of it
		 */
		} catch (ArrayIndexOutOfBoundsException e) {
			s = "";
		}
		/*
		 	Check the user has selected a valid row
		 */
		if (s == null || s.isEmpty() ) {
			displayMessage("Please select a valid item from the list");
		}
		
		if (thisCoach.getSquad().getName().equals(s)) {
			
			/*
			 	Init the try/catch to catch the IndexOutOfBounds error
			 */
			try {
				
				/*
				 	Index by default is -1, make sure that it is a valid number before dealing with the request
				 */
				if (index >= 0) {
					
					/*
					 	Create the EditTrainingSession instance
					 */
					dispose();
					EditTrainingSession ETS = new EditTrainingSession(coachID, cont, index);
					ETS.setLocationRelativeTo(null);
					ETS.setVisible(true);
					
				/*
				 	If it's not a valid number i.e. no row has been selected, display message
				 */
				} else {
					displayMessage("Please select a training session from the table below.");
				}
				
			/*
			 	Deal with the exception
			 */
			} catch (ArrayIndexOutOfBoundsException e) {
				displayMessage("Please select a valid training session");
			}
			
		} else {
			displayMessage("You do not have access to this squad.");
		}
		
	}
	
	// Making messages to user for accessible
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
