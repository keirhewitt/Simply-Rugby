package project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Identical to the CreateTrainingSession screen layout
 * Pre-populates fields with given TrainingSession object and when the save changes button is pressed, their values overwrite
 * 
 * @author Keir
 * @since 18/04/21
 */
public class EditTrainingSession extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CoachUserScreen CUS;

	private Player players[];
	private Coach thisCoach;
	
	private JTextField dateField;
	private JList<String> jListActivities = new JList<String>();
	private JList<Player> jListParticipants = new JList<Player>();
	DefaultListModel<String> activityModel = new DefaultListModel<>();
	DefaultListModel<Player> participantModel = new DefaultListModel<>();
	JDialog addPlayerDialog = new JDialog();
	JComboBox<Player> playeroptions = new JComboBox<Player>();
	
	private Controller myController;
	private int coachID;
	private int tSessionIndex;
	
	private ImageIcon background_img = new ImageIcon();
	
	public EditTrainingSession(int user, Controller cont, int TSIndex) {
		
		coachID = user;
		tSessionIndex = TSIndex;
		myController = cont;
		thisCoach = cont.getCoachObj(user);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrainingSessionHeader = new JLabel("Edit Training Session");
		lblTrainingSessionHeader.setForeground(Color.WHITE);
		lblTrainingSessionHeader.setBounds(384, 11, 309, 28);
		lblTrainingSessionHeader.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblTrainingSessionHeader);
		
		// Recreates the squad label using the TSessionModel to get the squad of the existing TrainingSession object
		JLabel lblSquad = new JLabel("Squad: " + cont.getModel().gettsmodel().returnTSessions().get(tSessionIndex).getSquad());
		lblSquad.setForeground(Color.WHITE);
		lblSquad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblSquad.setBounds(10, 35, 176, 28);
		contentPane.add(lblSquad);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDate.setBounds(10, 95, 89, 23);
		contentPane.add(lblDate);
		
		dateField = new JTextField();
		dateField.setFont(new Font("Dialog", Font.PLAIN, 18));
		dateField.setBounds(79, 92, 319, 34);	
		dateField.setText((cont.getModel().gettsmodel().returnTSessions().get(tSessionIndex).getDate()));
		
		
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		/**
		 * 
		 * ========= ACTIVITIES ===============================================
		 * 
		 */
		
		JLabel lblActivities = new JLabel("Activities");
		lblActivities.setForeground(Color.WHITE);
		lblActivities.setFont(new Font("Dialog", Font.BOLD, 20));
		lblActivities.setBounds(10, 172, 163, 34);
		contentPane.add(lblActivities);
		
		/*
			Uses the same add function as the CreateTrainingSession screen
		*/
		JButton btnAddActivity = new JButton("Add Activity");
		btnAddActivity.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAddActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActivity();
			}
		});
		btnAddActivity.setBounds(384, 172, 155, 34);
		contentPane.add(btnAddActivity);
		
		/*
			Uses the same remove function as the CreateTrainingSession screen
		*/
		JButton btnRemoveActivity = new JButton("Remove Activity");
		btnRemoveActivity.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRemoveActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeActivity();
			}
		});
		btnRemoveActivity.setBounds(554, 172, 155, 34);
		contentPane.add(btnRemoveActivity);
		
		
		/* 
		 	-- JPanel
		 */
		
		// Activity model is replaced with the existing training session object's activity model
		activityModel = cont.recreateActivityModel(activityModel, TSIndex);
		
		JPanel jPanelActivities = new JPanel();
		jPanelActivities.setBounds(10, 218, 699, 237);
		contentPane.add(jPanelActivities);
		jPanelActivities.setLayout(new BorderLayout(0, 0));
		jListActivities = new JList<>(activityModel);
		jPanelActivities.add(jListActivities, BorderLayout.CENTER);
		jListActivities.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		
		
		
		/**
		 * 
		 * ========= PARTICIPANTS ============================================
		 * 
		 */
		
		// Participant model is replaced with the existing training session object's participant model
		participantModel = cont.recreateParticipantModel(participantModel, TSIndex);
		
		JPanel jPanelParticipants = new JPanel();
		jPanelParticipants.setBounds(735, 107, 339, 348);
		contentPane.add(jPanelParticipants);
		jPanelParticipants.setLayout(new BorderLayout(0, 0));
		jListParticipants = new JList<>(participantModel);
		jPanelParticipants.add(jListParticipants, BorderLayout.CENTER);
		jListParticipants.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		
		// This screen employs the same add function as the CreateTrainingSession screen
		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAddPlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				addPlayer();
				
			}
			
		});
		btnAddPlayer.setBounds(735, 62, 150, 34);
		contentPane.add(btnAddPlayer);
		
		// This screen employs the same remove function as the CreateTrainingSession screen
		JButton btnRemovePlayer = new JButton("Remove Player");
		btnRemovePlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRemovePlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removePlayer();
			}
			
		});
		btnRemovePlayer.setBounds(924, 62, 150, 34);
		contentPane.add(btnRemovePlayer);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setForeground(Color.WHITE);
		lblPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayers.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPlayers.setBounds(735, 23, 339, 34);
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
				/*
				 	Disposes this screen, creates a new object of CoachUserScreen, sets it to visible
				 */
				dispose();
				CUS = new CoachUserScreen(coachID, cont);
				CUS.setLocationRelativeTo(null);
				CUS.setVisible(true);
			}
			
		});
		lblBack.setBounds(10, 466, 104, 34);
		contentPane.add(lblBack);
		
		/**
		 * Uses the GUI data to save a new TrainingSession and replace the element that the user has selected in the JTable in the prev. screen
		 */
		JButton lblSave = new JButton("Save Session");
		lblSave.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
					Gets the index from the table which will be the same as the arraylist index in TSessionModel
					Replaces the index with the newly created TrainingSession from the editTSession() function
				*/
				cont.getModel().gettsmodel().returnTSessions().set(TSIndex, editTSession(cont));
				
			}
			
		});
		lblSave.setBounds(924, 466, 150, 34);
		contentPane.add(lblSave);
		
		background_img = new ImageIcon("edittsessionback.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(1084, 511,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		JLabel lblEditTSessionBackground = new JLabel("", background_img, JLabel.CENTER);
		lblEditTSessionBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditTSessionBackground.setBounds(0, 0, 1084, 511);
		contentPane.add(lblEditTSessionBackground);
			
	}
	
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
	 * JDialog contains an 'Add' button for adding the selected item to the participants model from the combo box
	 * 
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
				Player selected = (Player) playeroptions.getModel().getSelectedItem();
				participantModel.addElement(selected);
				addPlayerDialog.dispose();
			}
		});
		addPlayerDialog.setVisible(true);
	}
	
	// Removes the currently selected value in the jList which shows the scheduled training session participants
	private void removePlayer() {
		
		/*
			If getting the selected jList value doesn't return null
			-- Remove the selected value from the model used with the jList
		*/
		if (jListParticipants.getSelectedValue() != null) {
			participantModel.removeElement(jListParticipants.getSelectedValue());
		}
	}
	
	// Adds players to the combo box in the JDialog which opens when adding a player to a training session
	private void populatePlayersList() {
		try {
			players = myController.populatePlayers(thisCoach);
			
			/*
				Catch if there are no elements to assign, or get length of
			*/
		} catch (NullPointerException e) {
			
			System.out.println("No players to add to list.");
		}
	}
	
	
		
	/**
	 * 
	 * @param Controller
	 * @return TrainingSession object
	 * 
	 * Creates a trainingsession object from the data passed through the GUI
	 *  Prompts user with error message if date is not filled in
	 *	--	If not empty, create the object and recreate the arraylists from the listmodels for activities and players lists
	 *	--	Use the TSessionModel to recreate those arraylists
	 */
	private TrainingSession editTSession(Controller cont) {
		
		TrainingSession TS = null;
		
		String date = dateField.getText();
		/*
		  	Will not allow user to create a TrainingSession object with a blank date
		 */
		if (cont.getModel().getDatePattern(date) == false) {
			displayMessage("The date needs to be in the format dd-MM-yyyy");
		} else {
			
			/*
				Use controller to access TSessionModel and create the training session
			*/
			TS = new TrainingSession(dateField.getText(), cont.getCoachObj(coachID).getSquad());
			
			/*
				Create arraylists from the return values
			*/
			ArrayList<String> actList = cont.getModel().gettsmodel().recreateArrayListActivities(activityModel);
			ArrayList<Player> playList = cont.getModel().gettsmodel().recreateArrayListPlayers(participantModel);
			
			/*
				Use the model to access TSessionModel and return the arraylist of TrainingSessions
				Then access the last element in that list which will be the object created above ^^
				Set the activities and participants using the setter methods
			*/
			TS.setActivities(actList);
			TS.setParticipants(playList);
		
			displayMessage("Saved changes.");
			
		}
		
		/*
		 	Return the created TrainingSession object
		 */
		return TS;
	}
	

	// Creates a dialog for a custom message
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	

}
