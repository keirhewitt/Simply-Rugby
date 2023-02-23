package project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * This Screen gets the User to enter a: Date, Activities and Players
 * 
 * An TrainingSession object will be created using this data
 * 
 * @author Keir
 * @since 29/03/21
 */
public class CreateTrainingSessionScreen extends JFrame {

	private CoachUserScreen CUS;
	private int coachID;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Player players[];
	private Coach thisCoach;
	
	private JPanel contentPane;
	private Controller myController;
	private JTextField dateField;
	private JList<String> jListActivities = new JList<String>();
	private JList<Player> jListParticipants = new JList<Player>();
	private DefaultListModel<String> activityModel = new DefaultListModel<>();
	private DefaultListModel<Player> participantModel = new DefaultListModel<>();
	private JDialog addPlayerDialog = new JDialog();
	private JComboBox<Player> playeroptions = new JComboBox<Player>();
	
	private ImageIcon background_img = new ImageIcon();

	public CreateTrainingSessionScreen(int user, Controller cont) {
		
		myController = cont;
		thisCoach = cont.getCoachObj(user);
		coachID = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrainingSessionHeader = new JLabel("Create Training Session");
		lblTrainingSessionHeader.setBounds(10, 4, 378, 33);
		lblTrainingSessionHeader.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblTrainingSessionHeader);
		
		JLabel lblSquad = new JLabel("Squad: " + thisCoach.getSquad());
		lblSquad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblSquad.setBounds(10, 35, 144, 33);
		contentPane.add(lblSquad);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDate.setBounds(10, 79, 57, 30);
		contentPane.add(lblDate);
		
		dateField = new JTextField();
		dateField.setFont(new Font("Dialog", Font.PLAIN, 18));
		dateField.setBounds(77, 80, 195, 30);
		
		
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		/**
		 * 
		 * ========= ACTIVITIES ===============================================
		 * 
		 */
		
		JLabel lblActivities = new JLabel("Activities");
		lblActivities.setFont(new Font("Dialog", Font.BOLD, 18));
		lblActivities.setBounds(10, 168, 162, 30);
		contentPane.add(lblActivities);
		
		/**
		 * Button for adding activities -- calls the addAcitivty() function
		 */
		JButton btnAddActivity = new JButton("Add");
		btnAddActivity.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAddActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActivity();
			}
		});
		btnAddActivity.setBounds(377, 168, 114, 30);
		contentPane.add(btnAddActivity);
		
		/**
		 * Button for removing acitvities -- calls the removeActivity() function
		 */
		JButton btnRemoveActivity = new JButton("Remove");
		btnRemoveActivity.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRemoveActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeActivity();
			}
		});
		btnRemoveActivity.setBounds(521, 168, 114, 30);
		contentPane.add(btnRemoveActivity);
		
		JPanel jPanelActivities = new JPanel();
		jPanelActivities.setBounds(10, 209, 625, 234);
		contentPane.add(jPanelActivities);
		jPanelActivities.setLayout(new BorderLayout(0, 0));
		
		// JList for holding variables of type String
		// Assign the activityModel to the JList
		activityModel = new DefaultListModel<String>();
		jListActivities = new JList<>(activityModel);
		jListActivities.setFont(new Font("Dialog", Font.PLAIN, 16));
		jPanelActivities.add(jListActivities);
		
		/**
		 * 
		 * ========= PARTICIPANTS ============================================
		 * 
		 */
		
		JPanel jPanelParticipants = new JPanel();
		jPanelParticipants.setBounds(657, 89, 317, 354);
		contentPane.add(jPanelParticipants);
		jPanelParticipants.setLayout(new BorderLayout(0, 0));
		
		// JList for holding variables of type Player
		participantModel = new DefaultListModel<Player>();
		jListParticipants = new JList<>(participantModel);
		jListParticipants.setFont(new Font("Dialog", Font.PLAIN, 16));
		jPanelParticipants.add(jListParticipants);
		
		/**
		 * Button for adding Players -- calls the addPlayer() function
		 * Opens a dialog with a comboBox for selecting Player objects
		 */
		JButton btnAddPlayer = new JButton("Add ");
		btnAddPlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAddPlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				addPlayer();
				
			}
			
		});
		btnAddPlayer.setBounds(657, 43, 133, 35);
		contentPane.add(btnAddPlayer);
		
		/**
		 * Button for removing Player's -- calls on the removePlayer() function
		 * Removes the selected Item in the JList if one has been selected
		 */
		JButton btnRemovePlayer = new JButton("Remove");
		btnRemovePlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRemovePlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removePlayer();
			}
			
		});
		btnRemovePlayer.setBounds(841, 43, 133, 35);
		contentPane.add(btnRemovePlayer);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayers.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPlayers.setBounds(657, 4, 317, 45);
		contentPane.add(lblPlayers);
		
		/**
		 * 
		 * ========= NAVIGATION ============================================
		 * 
		 */
		
		/**
		 * Go back to the CoachUserScreen
		 */
		JButton lblBack = new JButton("Back");
		lblBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CUS = new CoachUserScreen(coachID, cont);
				CUS.setLocationRelativeTo(null);
				CUS.setVisible(true);
			}
			
		});
		lblBack.setBounds(10, 465, 133, 35);
		contentPane.add(lblBack);
		
		// Create the TrainingSession object from the data provided
		// Calls the createTrainingSession() function
		JButton lblCreateTS = new JButton("Create");
		lblCreateTS.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblCreateTS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createTrainingSession(cont);
			}
			
		});
		lblCreateTS.setBounds(841, 465, 133, 35);
		contentPane.add(lblCreateTS);
		
		background_img = new ImageIcon("rugbytraining.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(984, 511,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		JLabel lblCreateTSBackground = new JLabel("", background_img, JLabel.CENTER);
		lblCreateTSBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateTSBackground.setBounds(0, 0, 984, 511);
		contentPane.add(lblCreateTSBackground);
			
	}
	
	// +--------------===============================-----------------------+
	// +--------------------------------------------------------------------+
	// |--------------\\\\\\ End of Constructor //////----------------------|
	// +--------------------------------------------------------------------+
	// +--------------===============================-----------------------+
	
	/**
	 * 
	 * ========= METHODS ============================================
	 * 
	 */
	
	/**
	 * Add a String activity to the JList which holds the activities
	 */
	private void addActivity() {
		String newActivity = JOptionPane.showInputDialog("Enter an activity name: ");
		activityModel.addElement(newActivity);
	}
	
	/**
	 * Removes the index of the jListActivities element selected, if the check on one being selected doesn't return null
	 */
	private void removeActivity() {
		int index = jListActivities.getSelectedIndex();
		if(index != -1) {
			activityModel.remove(index);
		}
	}
	

	/**
	 * Opens a JDialog where the player can select a player from a combo box
	 * 
	 * JDialog contains an 'Add' button for adding the selected item to the participants model from the combo box
	 */
	private void addPlayer() {
		
		// Calls method to add players to combo box
		populatePlayersList();
		
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Border panborder = BorderFactory.createTitledBorder("Add a player to the training list");
		pan.setBorder(panborder);
		
		playeroptions = new JComboBox<Player>(players);
		playeroptions.setBounds(50, 90, 300, 25);

		addPlayerDialog = new JDialog();
		JButton addplayer = new JButton("Add Player");
		addplayer.setBounds(50, 135, 100, 25);
		
		addPlayerDialog.getContentPane().add(addplayer);
		pan.add(playeroptions);
		
		addPlayerDialog.getContentPane().add(pan);
		addPlayerDialog.setSize(400, 280);
		addPlayerDialog.setTitle("Add Player");
		
		addplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 	Assign selected as the Player element selected in the ComboBox
				 */
				Player selected = (Player) playeroptions.getModel().getSelectedItem();
				
				/*
				 	Check to avoid duplicate entries
				 */
				if (participantModel.contains(selected)) {
					displayMessage("Cannot add a player more than once!");
				} else {
					participantModel.addElement(selected);
					addPlayerDialog.dispose();
				}
			}
		});
		
		addPlayerDialog.setLocationRelativeTo(null);
		addPlayerDialog.setVisible(true);
	}
	
	/**
	 * Removes the currently selected value in the jList which shows the scheduled training session participants
	 */
	private void removePlayer() {
		
		// If getting the selected jList value doesn't return null
		// -- Remove the selected value from the model used with the jList
		if (jListParticipants.getSelectedValue() != null) {
			participantModel.removeElement(jListParticipants.getSelectedValue());
		}
	}
	
	/**
	 * Adds players to the combo box in the JDialog which opens when adding a player to a training session
	 */
	private void populatePlayersList() {
		try {
			players = myController.populatePlayers(thisCoach);
			
		// Catch if there are no elements to assign, or get length of
			
		} catch (NullPointerException e) {
			System.out.println("No players to add to list.");
		}
	}
	

	/**
	 * 	Creates a trainingsession object from the data passed through the GUI
	 *	Prompts user with error message if date is not filled in
	 *		If not empty, create the object and recreate the arraylists from the listmodels for activities and players lists
	 * 		Use the TSessionModel to recreate those arraylists
	 * 
	 * @param Controller cont
	 */
	private void createTrainingSession(Controller cont) {
		
		if (cont.getModel().getDatePattern(dateField.getText()) == false) {
			displayMessage("The date needs to be in the format dd-MM-yyyy");
		} else {
			
			// Use controller to access TSessionModel and create the training session
			// This allows it to be added to the training session arraylist which can then be accessed by the main page
			// ... and then displayed by the training session table
			cont.getModel().gettsmodel().createTrainingSession(dateField.getText(), cont.getCoachObj(coachID).getSquad());
			
			// Create arraylists from the return values
			ArrayList<String> actList = cont.getModel().gettsmodel().recreateArrayListActivities(activityModel);
			ArrayList<Player> playList = cont.getModel().gettsmodel().recreateArrayListPlayers(participantModel);
			
			// Use the model to access TSessionModel and return the arraylist of TrainingSessions
			// Then access the last element in that list which will be the object created above ^^
			// Set the activities and participants using the setter methods
			cont.getModel().gettsmodel().returnTSessions().get( cont.getModel().gettsmodel().returnTSessions().size()- 1 ).setActivities(actList);
			cont.getModel().gettsmodel().returnTSessions().get( cont.getModel().gettsmodel().returnTSessions().size()- 1 ).setParticipants(playList);
		
			displayMessage("Training Session created");
			
			// Dispose screen and return to coach user screen
			dispose();
			CUS = new CoachUserScreen(coachID, cont);
			CUS.setLocationRelativeTo(null);
			CUS.setVisible(true);
		}
	}
	
	/**
	 * Creates a dialog for a custom message
	 * 
	 * @param String message
	 */
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	
}
