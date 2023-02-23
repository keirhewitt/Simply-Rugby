package project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * This class will have two tabbed panes:
 * 
 * 1: Creating Player objects using user input
 * 2: Creating Coach objects using user input
 * 
 * @author Keir
 * @since 08/05/21
 *
 */
public class MemberAddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPFirstname;
	private JTextField textPSurname;
	private JTextField textPDOB;
	private JTextField textPAddress;
	private JTextField textPPostcode;
	private JTextField textPPhone;
	private JTextField textPEmail;
	private JTextField textPPosition;
	private JTextField textPSRU;
	private JTextField textPNOK;
	private JTextField textPNOKContact;
	private JTextField textPDoctor;
	private JTextField textPDoctorContact;
	private JTextField textCoachSurname;
	private JTextField textCoachPostcode;
	private JTextField textCoachFirstname;
	private JTextField textCoachAddress;
	private JTextField textCoachEmail;
	private JTextField textCoachPhone;
	
	private JComboBox<Squad>comboBoxCoachSquadSelector = new JComboBox<Squad>();
	private Controller myController;
	
	private JComboBox<String> comboBoxJuniorSenior = new JComboBox<String>();
	
	private Squad[] squads;
	private JTextField textPasswordCoach;
	private DefaultListModel<String> healthModel = new DefaultListModel<String>();
	private JList<String> jListPlayerHealth = new JList<String>();
	private JComboBox<Squad> comboBoxPlayerSelectSquad = new JComboBox<Squad>();


	public MemberAddUser(Controller cont) {
		
		myController = cont;
		
		/*
		 	Populate the squads array with all squads using the Controller and Model
		 */
		squads = new Squad[myController.getModel().getSquads().length];
		squads = myController.getModel().getSquads();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBackground(new Color(60, 179, 113));
		tabbedPane.addTab("Player", null, panelPlayer, null);
		tabbedPane.setBackgroundAt(0, new Color(60, 179, 113));
		panelPlayer.setLayout(null);
		
		textPFirstname = new JTextField();
		textPFirstname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPFirstname.setBounds(31, 55, 246, 28);
		panelPlayer.add(textPFirstname);
		textPFirstname.setColumns(10);
		
		textPSurname = new JTextField();
		textPSurname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPSurname.setColumns(10);
		textPSurname.setBounds(31, 110, 246, 28);
		panelPlayer.add(textPSurname);
		
		textPDOB = new JTextField();
		textPDOB.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPDOB.setColumns(10);
		textPDOB.setBounds(31, 167, 246, 28);
		panelPlayer.add(textPDOB);
		
		textPAddress = new JTextField();
		textPAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPAddress.setColumns(10);
		textPAddress.setBounds(31, 227, 246, 28);
		panelPlayer.add(textPAddress);
		
		textPPostcode = new JTextField();
		textPPostcode.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPPostcode.setColumns(10);
		textPPostcode.setBounds(31, 291, 246, 28);
		panelPlayer.add(textPPostcode);
		
		textPPhone = new JTextField();
		textPPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPPhone.setColumns(10);
		textPPhone.setBounds(31, 355, 246, 28);
		panelPlayer.add(textPPhone);
		
		textPEmail = new JTextField();
		textPEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPEmail.setColumns(10);
		textPEmail.setBounds(354, 55, 246, 28);
		panelPlayer.add(textPEmail);
		
		textPPosition = new JTextField();
		textPPosition.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPPosition.setColumns(10);
		textPPosition.setBounds(354, 110, 246, 28);
		panelPlayer.add(textPPosition);
		
		textPSRU = new JTextField();
		textPSRU.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPSRU.setColumns(10);
		textPSRU.setBounds(354, 167, 246, 28);
		panelPlayer.add(textPSRU);
		
		textPNOK = new JTextField();
		textPNOK.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPNOK.setColumns(10);
		textPNOK.setBounds(676, 55, 246, 28);
		panelPlayer.add(textPNOK);
		
		textPNOKContact = new JTextField();
		textPNOKContact.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPNOKContact.setColumns(10);
		textPNOKContact.setBounds(676, 110, 246, 28);
		panelPlayer.add(textPNOKContact);
		
		textPDoctor = new JTextField();
		textPDoctor.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPDoctor.setColumns(10);
		textPDoctor.setBounds(676, 167, 246, 28);
		panelPlayer.add(textPDoctor);
		
		textPDoctorContact = new JTextField();
		textPDoctorContact.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPDoctorContact.setColumns(10);
		textPDoctorContact.setBounds(676, 227, 246, 28);
		panelPlayer.add(textPDoctorContact);
		
		JPanel panelHealth = new JPanel();
		panelHealth.setBounds(676, 295, 246, 86);
		panelPlayer.add(panelHealth);
		panelHealth.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelHealth.add(scrollPane);
		
		healthModel = new DefaultListModel<String>();
		jListPlayerHealth = new JList<String>(healthModel);
		jListPlayerHealth.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setViewportView(jListPlayerHealth);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 949, 451);
		panelPlayer.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 21, 99, 24);
		panel.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSurname.setBounds(21, 75, 99, 24);
		panel.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDateOfBirth.setBounds(21, 134, 99, 24);
		panel.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(21, 192, 99, 24);
		panel.add(lblAddress);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPostcode.setBounds(21, 257, 99, 24);
		panel.add(lblPostcode);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhoneNumber.setBounds(21, 322, 118, 24);
		panel.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(343, 21, 99, 24);
		panel.add(lblEmail);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPosition.setBounds(343, 75, 99, 24);
		panel.add(lblPosition);
		
		JLabel lblSru = new JLabel("SRU");
		lblSru.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSru.setBounds(343, 134, 99, 24);
		panel.add(lblSru);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDoctor.setBounds(666, 134, 99, 24);
		panel.add(lblDoctor);
		
		JLabel lblNextOfKin_1 = new JLabel("Next Of Kin Contact Number");
		lblNextOfKin_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNextOfKin_1.setBounds(666, 75, 232, 24);
		panel.add(lblNextOfKin_1);
		
		JLabel lblNextOfKin = new JLabel("Next Of Kin");
		lblNextOfKin.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNextOfKin.setBounds(666, 21, 99, 24);
		panel.add(lblNextOfKin);
		
		JLabel lblDoctorContactNumber = new JLabel("Doctor Contact Number");
		lblDoctorContactNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDoctorContactNumber.setBounds(666, 192, 201, 24);
		panel.add(lblDoctorContactNumber);
		
		JLabel lblHealthIssues = new JLabel("Health Issues");
		lblHealthIssues.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHealthIssues.setBounds(666, 257, 104, 24);
		panel.add(lblHealthIssues);
		
		/*
		 * This button triggers the removeHealthIssues() function which allows the user to remove a String value from the Health Issues JList
		 */
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(843, 260, 70, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeHealthIssue();
				
			}
			
		});
		panel.add(btnNewButton);
		
		/**
		 * This button triggers the addHealthIssue() function which allows the user to add a String value to the Health Issues JList
		 */
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addHealthIssue();
			}
		});
		btnAdd.setBounds(779, 260, 61, 23);
		panel.add(btnAdd);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createPlayer();
				
			}
		});
		btnCreate.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCreate.setBounds(795, 404, 118, 36);
		panel.add(btnCreate);
		
		/**
		 * Takes user back to MemberMain Screen
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MemberMain MM = new MemberMain(cont);
				MM.setLocationRelativeTo(null);
				MM.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack.setBounds(21, 404, 118, 36);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(316, 213, 302, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		comboBoxPlayerSelectSquad = new JComboBox<Squad>(squads); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< squads
		comboBoxPlayerSelectSquad.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBoxPlayerSelectSquad.setBounds(20, 46, 255, 24);
		panel_1.add(comboBoxPlayerSelectSquad);
		
		JLabel lblNewLabel_2 = new JLabel("Select Squad");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 11, 136, 24);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1.setBounds(316, 322, 302, 100);
		panel.add(panel_1_1);
		
		comboBoxJuniorSenior = new JComboBox<String>();
		comboBoxJuniorSenior.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBoxJuniorSenior.setBounds(20, 46, 255, 24);
		comboBoxJuniorSenior.addItem("Junior");
		comboBoxJuniorSenior.addItem("Senior");
		panel_1_1.add(comboBoxJuniorSenior);
		
		JLabel lblNewLabel_2_1 = new JLabel("Select Player Type");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(10, 11, 173, 24);
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panelCoach = new JPanel();
		panelCoach.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Coach", null, panelCoach, null);
		tabbedPane.setBackgroundAt(1, new Color(233, 150, 122));
		panelCoach.setLayout(null);
		
		textCoachSurname = new JTextField();
		textCoachSurname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textCoachSurname.setColumns(10);
		textCoachSurname.setBounds(343, 114, 246, 28);
		panelCoach.add(textCoachSurname);
		
		textCoachPostcode = new JTextField();
		textCoachPostcode.setFont(new Font("Dialog", Font.PLAIN, 16));
		textCoachPostcode.setColumns(10);
		textCoachPostcode.setBounds(343, 256, 246, 28);
		panelCoach.add(textCoachPostcode);
		
		textCoachFirstname = new JTextField();
		textCoachFirstname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textCoachFirstname.setColumns(10);
		textCoachFirstname.setBounds(343, 43, 246, 28);
		panelCoach.add(textCoachFirstname);
		
		textCoachAddress = new JTextField();
		textCoachAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		textCoachAddress.setColumns(10);
		textCoachAddress.setBounds(343, 185, 246, 28);
		panelCoach.add(textCoachAddress);
		
		textCoachEmail = new JTextField();
		textCoachEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
		textCoachEmail.setColumns(10);
		textCoachEmail.setBounds(343, 327, 246, 28);
		panelCoach.add(textCoachEmail);
		
		textCoachPhone = new JTextField();
		textCoachPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		textCoachPhone.setColumns(10);
		textCoachPhone.setBounds(343, 398, 246, 28);
		panelCoach.add(textCoachPhone);
		
		comboBoxCoachSquadSelector = new JComboBox<Squad>(squads); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< squad
		comboBoxCoachSquadSelector.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBoxCoachSquadSelector.setBounds(37, 43, 246, 27);
		panelCoach.add(comboBoxCoachSquadSelector);
		
		JLabel lblNewLabel_1 = new JLabel("Firstname");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(343, 23, 113, 20);
		panelCoach.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Surname");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(343, 96, 113, 20);
		panelCoach.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(343, 166, 113, 20);
		panelCoach.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Postcode");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(343, 237, 113, 20);
		panelCoach.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(343, 307, 113, 20);
		panelCoach.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone Number");
		lblNewLabel_1_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(343, 378, 113, 20);
		panelCoach.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Select Squad");
		lblNewLabel_1_6.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(37, 23, 113, 20);
		panelCoach.add(lblNewLabel_1_6);
		
		/**
		 * Takes the user back to MemberMain
		 */
		JButton btnBack2 = new JButton("Back");
		btnBack2.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack2.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberMain MM = new MemberMain(myController);
				MM.setLocationRelativeTo(null);
				MM.setVisible(true);
				
			}
			
		});
		btnBack2.setBounds(10, 434, 113, 28);
		panelCoach.add(btnBack2);
		
		/**
		 * Triggers the createCoach() function
		 */
		JButton btnCreateCoach = new JButton("Create");
		btnCreateCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createCoach();
			}
		});
		btnCreateCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCreateCoach.setBounds(846, 422, 113, 35);
		panelCoach.add(btnCreateCoach);
		
		textPasswordCoach = new JTextField();
		textPasswordCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPasswordCoach.setColumns(10);
		textPasswordCoach.setBounds(682, 185, 246, 28);
		panelCoach.add(textPasswordCoach);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Enter Password");
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(682, 166, 113, 20);
		panelCoach.add(lblNewLabel_1_2_1);
	}
	
	/**
	 * Extracts the values of the textboxe's and puts them into variables, gets the Squad object from the Combo Box
	 * 
	 * Sends information to Controller to be checked and executed
	 * 
	 * Controller sends back message to inform the user of any errors/success
	 */
	public void createCoach() {
		
		String firstname = textCoachFirstname.getText();
		String surname = textCoachSurname.getText();
		String address = textCoachAddress.getText();
		String postcode = textCoachPostcode.getText();
		String number = textCoachPhone.getText();
		String email = textCoachEmail.getText();
		String password = textPasswordCoach.getText();
		
		Squad s = (Squad) comboBoxCoachSquadSelector.getSelectedItem();
		String message = myController.addNewCoach(password, firstname, surname, address, postcode, number, email, s);
		
		displayMessage(message);
		
		if (message.equals("Coach created.")) {
			// Get the coach by accessing the last element in the coachList in the Model, store it in 'c'
			Coach c = myController.getModel().getCoachList().get(myController.getModel().getCoachList().size() - 1);
			
			// Tells the user their Coach login details
			String mess = "LoginID: " + c.getLoginID() + ", Password: " + c.getPass();
			
			displayMessage(mess);
		}
	}
	
	/**
	 * Stores all of the text field values in variables and passes them to the Controller to be validated
	 * 
	 * Stores the message of the return value from the Controller function and displays the relevant String
	 */
	public void createPlayer() {
		
		String message = "";
		Squad s = null;
		
		String firstname = textPFirstname.getText();
		String surname = textPSurname.getText();
		String address = textPAddress.getText();
		String postcode = textPPostcode.getText();
		String number = textPPhone.getText();
		String email = textPEmail.getText();
		String DOB = textPDOB.getText();
		String position = textPPosition.getText();
		String SRU = textPSRU.getText();
		String NOK = textPNOK.getText();
		String NOKContact = textPNOKContact.getText();
		String doctor = textPDoctor.getText();
		String doctorContact = textPDoctorContact.getText();
		
		ArrayList<String> health = new ArrayList<String>();
		
		for (int i = 0; i < healthModel.size(); i++) {
			health.add(healthModel.get(i));
		}
		
		String playerType = (String) comboBoxJuniorSenior.getModel().getSelectedItem();
		
		try {
			s = (SquadJunior) comboBoxPlayerSelectSquad.getModel().getSelectedItem();
		} catch (ClassCastException e) {
			s = (Squad) comboBoxPlayerSelectSquad.getModel().getSelectedItem();
		}
		
		if (s.getType() == "Junior") {
			s = (SquadJunior) s;
		}
			
		// Store the string return value in this variable to be shown to the user
		// This will let the User know what the result of the validation was
		message = myController.addNewPlayer(playerType, health, s, firstname, surname, number, email, position, DOB, address, postcode, SRU, NOK, NOKContact, doctor, doctorContact);
	 
		displayMessage(message);
	}
	 
	/**
	 * Brings up a JOption pane and dialog so the user can enter a String value
	 * The value is then passed to the HealthIssues JList
	 */
	public void addHealthIssue() {
		
		String newIssue = JOptionPane.showInputDialog("Enter a health issue: ");
		healthModel.addElement(newIssue);
	
	}
	
	/**
	 * Stores the selected items index in a variable
	 * Removes the item at that index if index != -1 - since that is the default value (none selected)
	 */
	public void removeHealthIssue() {
		int index = jListPlayerHealth.getSelectedIndex();
		if (index != -1) {
			healthModel.remove(index);
		}
	}
	
	// Making messages to user for accessible
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
