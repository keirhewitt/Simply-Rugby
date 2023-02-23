package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * The main page for the membership secretary, contains all of the functionality available to those users
 * 
 * Uses a tabbed pane for navigation
 * 
 * @author Keir
 * @since 01/05/21
 * 
 */
public class MemberMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private Controller myController;
	/*
	 *  Main content pane
	 */
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel jpanelPlayers = new JPanel();
	private JPanel jpanelSquad = new JPanel();
	private JPanel jpanelCoach = new JPanel();
	
	/*
	 * Players panel
	 */
	private JComboBox<Squad> comboBoxSquad = new JComboBox<Squad>();
	private JList<Player> list = new JList<Player>();
	private JPanel panel_1 = new JPanel();
	private JPanel panelPlayerInfo = new JPanel();
	private DefaultListModel<Player> playersModel = new DefaultListModel<Player>();
	private Squad[] squad;
	private JScrollPane SquadScrollPane = new JScrollPane();
	private JTextField textFirstname;
	private JTextField textSurname;
	private JTextField textAddress;
	private JTextField textPostcode;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textNOK;
	private JTextField textNOKcontact;
	private JTextField textDoctor;
	private JTextField textDoctorContact;
	private JTextField textSquad;
	private JTextField textPosition;
	private JTextField textDOB;
	private JTextField textSRU;
	
	/*
	 * Player Info Panel
	 */
	private DefaultListModel<String> healthIssues = new DefaultListModel<String>();
	private JList<String> jListHealthIssues = new JList<String>();
	private MouseListener playerInformation;
	private JTextField textFirstnameCoach;
	private JTextField textSurnameCoach;
	private JTextField textPhoneCoach;
	private JTextField textAddressCoach;
	private JTextField textPostcodeCoach;
	
	/*
	 * Coach Panel
	 */
	private JComboBox<Coach> comboBoxCoachSelection = new JComboBox<Coach>();
	private Coach[] coachlist;
	private JLabel lblCoachSquad = new JLabel();
	private JTextField textSquadsSquadName;
	private JTextField textSquadsCoach;
	
	/*
	 * Squads Panel
	 */
	private JComboBox<Squad> comboBoxSquads = new JComboBox<Squad>();
	private JLabel lblSquadNameHeader = new JLabel(); 
	private JTextField textEmailCoach;
	
	/*
	 * Member Panel
	 */
	private JTextField textPassMember;
	private ImageIcon background_img = new ImageIcon();
	
	MemberMain(Controller cont) {
		
		myController = cont;
		
		/*
		 	Get the arrays ready to be used for populating ComboBoxes
		 */
		
		populateLists();
		
		/*
	 		This mouse listener will be triggered when an item in the playerJlist is double clicked
	 		Calls on the function to display Player information
		 */
		playerInformation = new MouseAdapter() {
	
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					
					displayPlayerInfo();
					
				}
			}
		};
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/**
		 * Takes the user back to the login screen
		 */
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberLoginScreen MM = new MemberLoginScreen(cont);
				MM.setLocationRelativeTo(null);
				MM.setVisible(true);	
			}
			
		});
		btnLogout.setBounds(10, 469, 142, 31);
		contentPane.add(btnLogout);
		
		/**
		 *  -- BUTTONS
		 * 
		 * When each button event is activated, the tabbed pan selects the relevant index
		 * These buttons change the tab so that the screen changes
		 */
		JButton btnPlayer = new JButton("Players");
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 	Select the index of the tabbed pane
				 */
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnPlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnPlayer.setBounds(10, 11, 142, 36);
		contentPane.add(btnPlayer);
		
		/*
		 	Button to change to the Squad tab
		 */
		JButton btnSquad = new JButton("Squads");
		btnSquad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
			 		Select the index of the tabbed pane
				 */
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnSquad.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSquad.setBounds(10, 64, 142, 36);
		contentPane.add(btnSquad);
		
		/*
		 	Button the change to the Coaches tab
		 */
		JButton btnCoach = new JButton("Coaches");
		btnCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
			 		Select the index of the tabbed pane
				 */
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCoach.setBounds(10, 117, 142, 36);
		contentPane.add(btnCoach);
		
		/**
		 *  -- PANELS
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 165, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*
		 	Shows the MembershipSecretary tab
		 */
		JButton btnMember = new JButton("Membership S.");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(3);
				
			}
		});
		btnMember.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnMember.setBounds(10, 170, 142, 36);
		panel.add(btnMember);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(162, -23, 922, 534);
		contentPane.add(tabbedPane);
		
		/**
		 * ============================================================================================================================
		 *	Players JPanel + Scroll pane
		 * ============================================================================================================================
		 */
		jpanelPlayers = new JPanel();
		jpanelPlayers.setBackground(new Color(143, 188, 143));
		tabbedPane.addTab("Tab0", null, jpanelPlayers, null);
		jpanelPlayers.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 238, 144));
		panel_1.setBounds(10, 32, 233, 463);
		jpanelPlayers.add(panel_1);
		
		/*
	 		DefaultListModel to populate the JList
		 */
		playersModel = new DefaultListModel<Player>();
		panel_1.setLayout(new BorderLayout(0, 0));
			
		SquadScrollPane = new JScrollPane();
		panel_1.add(SquadScrollPane, BorderLayout.CENTER);
		
		/*
		 	Populate jList with the playersModel
		 */
		list = new JList<>(playersModel);
		list.addMouseListener(playerInformation);
		
		SquadScrollPane.setViewportView(list);
		list.setForeground(Color.WHITE);
		list.setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		/*
		 * ==========================================
		 	Combo Box with Squad and player selection
		 * ==========================================
		 */
		comboBoxSquad = new JComboBox<Squad>(squad); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< squad
		comboBoxSquad.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBoxSquad.addItemListener(new ItemListener() {

			/*
			 	Implement item listener for the combo box
			 */
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				/*
				 	If the state change of the combo box is that an item has been selected
				 */
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					Squad s = (Squad) comboBoxSquad.getModel().getSelectedItem();
					
					addPlayers(s);
				}
				
			}
			
		});
		panel_1.add(comboBoxSquad, BorderLayout.NORTH);
		
		/**
		 * Opens the MemberAddUser Screen
		 */
		JButton btnCreatePlayer = new JButton("Create Player");
		btnCreatePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MemberAddUser MAU = new MemberAddUser(myController);
				MAU.setLocationRelativeTo(null);
				MAU.setVisible(true);
			}
			
		});
		btnCreatePlayer.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnCreatePlayer, BorderLayout.SOUTH);
		
		
		
		/**
		 * =============================================================================================================================================
		 * Player Info JPanel
		 * =============================================================================================================================================
		 */
		
		
		
		panelPlayerInfo = new JPanel();
		panelPlayerInfo.setBackground(new Color(60, 179, 113));
		panelPlayerInfo.setBounds(253, 11, 654, 484);
		jpanelPlayers.add(panelPlayerInfo);
		panelPlayerInfo.setLayout(null);
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstname.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFirstname.setBounds(10, 11, 87, 21);
		panelPlayerInfo.add(lblFirstname);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSurname.setBounds(10, 51, 87, 21);
		panelPlayerInfo.add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddress.setBounds(10, 94, 87, 21);
		panelPlayerInfo.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEmail.setBounds(10, 195, 87, 21);
		panelPlayerInfo.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhone.setBounds(10, 236, 87, 21);
		panelPlayerInfo.add(lblPhone);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostcode.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPostcode.setBounds(10, 145, 87, 21);
		panelPlayerInfo.add(lblPostcode);
		
		JLabel lblNextOfKin = new JLabel("Next of Kin");
		lblNextOfKin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNextOfKin.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNextOfKin.setBounds(290, 19, 158, 21);
		panelPlayerInfo.add(lblNextOfKin);
		
		JLabel lblNextOfKinTele = new JLabel("Next of Kin Contact");
		lblNextOfKinTele.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNextOfKinTele.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNextOfKinTele.setBounds(290, 63, 158, 21);
		panelPlayerInfo.add(lblNextOfKinTele);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctor.setBounds(290, 107, 158, 21);
		panelPlayerInfo.add(lblDoctor);
		
		JLabel lblDoctorTele = new JLabel("Doctor Contact");
		lblDoctorTele.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoctorTele.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctorTele.setBounds(290, 145, 158, 21);
		panelPlayerInfo.add(lblDoctorTele);
		
		textFirstname = new JTextField();
		textFirstname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFirstname.setBounds(107, 11, 170, 23);
		panelPlayerInfo.add(textFirstname);
		textFirstname.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textSurname.setColumns(10);
		textSurname.setBounds(107, 51, 170, 23);
		panelPlayerInfo.add(textSurname);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		textAddress.setColumns(10);
		textAddress.setBounds(107, 94, 170, 23);
		panelPlayerInfo.add(textAddress);
		
		textPostcode = new JTextField();
		textPostcode.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPostcode.setColumns(10);
		textPostcode.setBounds(107, 145, 170, 23);
		panelPlayerInfo.add(textPostcode);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(107, 193, 170, 23);
		panelPlayerInfo.add(textEmail);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPhone.setColumns(10);
		textPhone.setBounds(107, 236, 170, 23);
		panelPlayerInfo.add(textPhone);
		
		textNOK = new JTextField();
		textNOK.setFont(new Font("Dialog", Font.PLAIN, 16));
		textNOK.setColumns(10);
		textNOK.setBounds(474, 19, 170, 23);
		panelPlayerInfo.add(textNOK);
		
		textNOKcontact = new JTextField();
		textNOKcontact.setFont(new Font("Dialog", Font.PLAIN, 16));
		textNOKcontact.setColumns(10);
		textNOKcontact.setBounds(474, 63, 170, 23);
		panelPlayerInfo.add(textNOKcontact);
		
		textDoctor = new JTextField();
		textDoctor.setFont(new Font("Dialog", Font.PLAIN, 16));
		textDoctor.setColumns(10);
		textDoctor.setBounds(474, 107, 170, 23);
		panelPlayerInfo.add(textDoctor);
		
		textDoctorContact = new JTextField();
		textDoctorContact.setFont(new Font("Dialog", Font.PLAIN, 16));
		textDoctorContact.setColumns(10);
		textDoctorContact.setBounds(474, 145, 170, 23);
		panelPlayerInfo.add(textDoctorContact);
		
		JPanel panelHealth = new JPanel();
		panelHealth.setBounds(357, 293, 287, 142);
		panelPlayerInfo.add(panelHealth);
		panelHealth.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelHealth.add(scrollPane, BorderLayout.CENTER);
		jListHealthIssues = new JList<String>(healthIssues);
		scrollPane.setViewportView(jListHealthIssues);
		jListHealthIssues.setForeground(Color.WHITE);
		jListHealthIssues.setBackground(Color.DARK_GRAY);
		jListHealthIssues.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblHealthIssues = new JLabel("Health Issues");
		lblHealthIssues.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealthIssues.setBounds(444, 223, 112, 21);
		panelPlayerInfo.add(lblHealthIssues);
		
		textDOB = new JTextField();
		textDOB.setBounds(107, 282, 98, 23);
		panelPlayerInfo.add(textDOB);
		textDOB.setFont(new Font("Dialog", Font.PLAIN, 16));
		textDOB.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(53, 283, 44, 21);
		panelPlayerInfo.add(lblDob);
		lblDob.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSquad = new JLabel("Squad");
		lblSquad.setBounds(20, 364, 56, 21);
		panelPlayerInfo.add(lblSquad);
		lblSquad.setFont(new Font("Dialog", Font.BOLD, 16));
		
		textSquad = new JTextField();
		textSquad.setBounds(108, 363, 158, 23);
		panelPlayerInfo.add(textSquad);
		textSquad.setFont(new Font("Dialog", Font.PLAIN, 16));
		textSquad.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(30, 400, 70, 21);
		panelPlayerInfo.add(lblPosition);
		lblPosition.setFont(new Font("Dialog", Font.BOLD, 16));
		
		textPosition = new JTextField();
		textPosition.setBounds(107, 397, 158, 23);
		panelPlayerInfo.add(textPosition);
		textPosition.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPosition.setColumns(10);
		
		JLabel lblSru = new JLabel("SRU");
		lblSru.setBounds(53, 324, 44, 21);
		panelPlayerInfo.add(lblSru);
		lblSru.setFont(new Font("Dialog", Font.BOLD, 16));
		
		textSRU = new JTextField();
		textSRU.setFont(new Font("Dialog", Font.PLAIN, 16));
		textSRU.setColumns(10);
		textSRU.setBounds(107, 324, 112, 23);
		panelPlayerInfo.add(textSRU);
		
		/*
		 	This will trigger the function to delete a player
		 */
		JButton btnDeletePlayer = new JButton("Delete Player");
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Init a try/catch incase application tries to assign 'p' a null value
				try {
					Player p = list.getSelectedValue();
					
					removePlayer(p);	
				} catch (NullPointerException np) {
					displayMessage("You have not selected a player");
				}
			}
		});
		btnDeletePlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDeletePlayer.setBounds(512, 446, 132, 29);
		panelPlayerInfo.add(btnDeletePlayer);
		
		/*
		 	This will trigger the function to overwrite player values
		 */
		JButton btnSaveChangesPlayer = new JButton("Save Changes");
		btnSaveChangesPlayer.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSaveChangesPlayer.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Init a try/catch incase application tries to assign 'p' a null value
				Player p = null;
				
				try {
					p = list.getSelectedValue();
					saveChangesPlayer(p);
				} catch (NullPointerException np) {
					displayMessage("No player selected!");
				}
				
				
			}
			
		});
		btnSaveChangesPlayer.setBounds(357, 446, 142, 29);
		panelPlayerInfo.add(btnSaveChangesPlayer);
		
		JButton btnAddHealthIssue = new JButton("Add");
		btnAddHealthIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addHealthIssue();
			}
		});
		btnAddHealthIssue.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAddHealthIssue.setBounds(357, 255, 142, 29);
		panelPlayerInfo.add(btnAddHealthIssue);
		
		JButton btnRemoveHealthIssue = new JButton("Remove");
		btnRemoveHealthIssue.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRemoveHealthIssue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				removeHealthIssue();
			}
			
		});
		btnRemoveHealthIssue.setBounds(502, 255, 142, 29);
		panelPlayerInfo.add(btnRemoveHealthIssue);
		
		/**
		 * Triggers the changeSquad() function and passes through the Player object if the try/catch does not produce an error
		 */
		JButton btnChangeSquad = new JButton("Change Squad");
		btnChangeSquad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Player p = null;
				
				try {
					p = list.getSelectedValue();
					changeSquad(p); 
				} catch (NullPointerException np) {
					displayMessage("Please select a player first.");
				}
				
			}
		});
		btnChangeSquad.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnChangeSquad.setBounds(10, 447, 142, 27);
		panelPlayerInfo.add(btnChangeSquad);
		
		JLabel lblNewLabel_1 = new JLabel("Double click on a player for access");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 11, 233, 24);
		jpanelPlayers.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Choose a Squad to reveal the players");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblNewLabel_1_1.setBounds(10, -3, 233, 24);
		jpanelPlayers.add(lblNewLabel_1_1);
		
		panelPlayerInfo.setVisible(false);
		
		
		/**
		 * =============================================================================================================================================
		 * Squad JPanel
		 * =============================================================================================================================================
		 */
		
		
		jpanelSquad = new JPanel();
		jpanelSquad.setBackground(new Color(250, 128, 114));
		tabbedPane.addTab("Tab1", null, jpanelSquad, null);
		jpanelSquad.setLayout(null);
		
		JPanel jPanelSquadSelection = new JPanel();
		jPanelSquadSelection.setBounds(10, 11, 233, 484);
		jpanelSquad.add(jPanelSquadSelection);
		jPanelSquadSelection.setLayout(new BorderLayout(0, 0));
		
		/*
		 	ComboBox has an ActionListener which will trigger the function to display Squad information
		 */
		comboBoxSquads = new JComboBox<Squad>(squad); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< squad
		comboBoxSquads.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Squad s = (Squad)comboBoxSquads.getModel().getSelectedItem();
				displaySquadInfo(s);
				
			}
			
		});
		comboBoxSquads.setFont(new Font("Dialog", Font.PLAIN, 16));
		jPanelSquadSelection.add(comboBoxSquads, BorderLayout.NORTH);
		
		/*
		 	Button which triggers the function to create a new squad
		 */
		JButton btnCreateSquad = new JButton("Create Squad");
		btnCreateSquad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createSquad();
				
			}
		});
		jPanelSquadSelection.add(btnCreateSquad, BorderLayout.SOUTH);
		btnCreateSquad.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JPanel jPanelSquadsMain = new JPanel();
		jPanelSquadsMain.setBounds(253, 11, 654, 484);
		jpanelSquad.add(jPanelSquadsMain);
		jPanelSquadsMain.setLayout(null);
		
		JPanel panelSquadsHeader = new JPanel();
		panelSquadsHeader.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSquadsHeader.setBackground(new Color(211, 211, 211));
		panelSquadsHeader.setBounds(10, 11, 634, 58);
		jPanelSquadsMain.add(panelSquadsHeader);
		panelSquadsHeader.setLayout(null);
		
		lblSquadNameHeader = new JLabel("Squad Name");
		lblSquadNameHeader.setFont(new Font("Modern No. 20", Font.BOLD, 27));
		lblSquadNameHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblSquadNameHeader.setBounds(10, 5, 614, 42);
		panelSquadsHeader.add(lblSquadNameHeader);
		
		textSquadsSquadName = new JTextField();
		textSquadsSquadName.setFont(new Font("Dialog", Font.PLAIN, 16));
		textSquadsSquadName.setBounds(192, 126, 255, 32);
		jPanelSquadsMain.add(textSquadsSquadName);
		textSquadsSquadName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Squad Name");
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 16));
		lblNewLabel.setBounds(192, 108, 255, 20);
		jPanelSquadsMain.add(lblNewLabel);
		
		textSquadsCoach = new JTextField();
		textSquadsCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textSquadsCoach.setColumns(10);
		textSquadsCoach.setBounds(192, 232, 255, 32);
		jPanelSquadsMain.add(textSquadsCoach);
		
		JLabel lblSquadCoachs = new JLabel("Squad Coach(s)");
		lblSquadCoachs.setFont(new Font("Dialog", Font.ITALIC, 16));
		lblSquadCoachs.setBounds(192, 213, 255, 20);
		jPanelSquadsMain.add(lblSquadCoachs);
		
		/**
		 *	This button contains an ActionListener which will keep any changes made by the user and re-load the page
		 */
		JButton btnSquadsSave = new JButton("Save Changes");
		btnSquadsSave.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSquadsSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Squad s = (Squad)comboBoxSquads.getModel().getSelectedItem();
				
				saveChanges(s);
				
			}
			
		});
		btnSquadsSave.setBounds(478, 441, 166, 32);
		jPanelSquadsMain.add(btnSquadsSave);
		
		/**
		 * Takes the Squad object from the comboBox and passes it through the changeCoach() function
		 */
		JButton btnChangeCoach = new JButton("Change Coach");
		btnChangeCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Squad s = (Squad)comboBoxSquads.getModel().getSelectedItem();
				changeCoach(s);
				
			}
		});
		btnChangeCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnChangeCoach.setBounds(236, 275, 166, 32);
		jPanelSquadsMain.add(btnChangeCoach);
		
		/**
		 * =============================================================================================================================================
		 * ---------------------------------------------------------------------------------------------------------------------------------------------
		 * =============================================================================================================================================
		 */
		
		
		
		
		/**
		 * =============================================================================================================================================
		 * Coach JPanel
		 * =============================================================================================================================================
		 */
		jpanelCoach = new JPanel();
		jpanelCoach.setBackground(new Color(250, 235, 215));
		tabbedPane.addTab("Tab2", null, jpanelCoach, null);
		jpanelCoach.setLayout(null);
		
		JPanel jPanelCoachSelection = new JPanel();
		jPanelCoachSelection.setBackground(Color.LIGHT_GRAY);
		jPanelCoachSelection.setBounds(10, 11, 233, 484);
		jpanelCoach.add(jPanelCoachSelection);
		jPanelCoachSelection.setLayout(new BorderLayout(0, 0));
		
		/*
		 	Create an action listener for the Coach comboBox to run the displayCoachInfo() function for each item selection
		 */
		comboBoxCoachSelection = new JComboBox<Coach>(coachlist); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< coachlist
		comboBoxCoachSelection.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBoxCoachSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				displayCoachInfo();
				
			}
			
		});
		jPanelCoachSelection.add(comboBoxCoachSelection, BorderLayout.NORTH);
		
		/**
		 * Opens the MemberAddUser Screen
		 */
		JButton btnCreateCoach = new JButton("Create Coach");
		btnCreateCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MemberAddUser MAU = new MemberAddUser(myController);
				MAU.setLocationRelativeTo(null);
				MAU.setVisible(true);
				
			}
		});
		btnCreateCoach.setFont(new Font("Dialog", Font.BOLD, 16));
		jPanelCoachSelection.add(btnCreateCoach, BorderLayout.SOUTH);
		
		JPanel panelCoachInfo = new JPanel();
		panelCoachInfo.setBounds(254, 11, 653, 484);
		jpanelCoach.add(panelCoachInfo);
		panelCoachInfo.setLayout(null);
		
		textFirstnameCoach = new JTextField();
		textFirstnameCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFirstnameCoach.setBounds(211, 49, 229, 28);
		panelCoachInfo.add(textFirstnameCoach);
		textFirstnameCoach.setColumns(10);
		
		textSurnameCoach = new JTextField();
		textSurnameCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textSurnameCoach.setColumns(10);
		textSurnameCoach.setBounds(211, 126, 229, 28);
		panelCoachInfo.add(textSurnameCoach);
		
		textPhoneCoach = new JTextField();
		textPhoneCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPhoneCoach.setColumns(10);
		textPhoneCoach.setBounds(211, 203, 229, 28);
		panelCoachInfo.add(textPhoneCoach);
		
		textAddressCoach = new JTextField();
		textAddressCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textAddressCoach.setColumns(10);
		textAddressCoach.setBounds(211, 280, 229, 28);
		panelCoachInfo.add(textAddressCoach);
		
		textPostcodeCoach = new JTextField();
		textPostcodeCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPostcodeCoach.setColumns(10);
		textPostcodeCoach.setBounds(211, 434, 229, 28);
		panelCoachInfo.add(textPostcodeCoach);
		
		lblCoachSquad = new JLabel("Squad:");
		lblCoachSquad.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCoachSquad.setBounds(10, 11, 151, 36);
		panelCoachInfo.add(lblCoachSquad);
		
		JLabel lblfnamecoach = new JLabel("Firstname");
		lblfnamecoach.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblfnamecoach.setBounds(211, 13, 172, 23);
		panelCoachInfo.add(lblfnamecoach);
		
		JLabel lblSurnameCoach = new JLabel("Surname");
		lblSurnameCoach.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblSurnameCoach.setBounds(211, 90, 172, 23);
		panelCoachInfo.add(lblSurnameCoach);
		
		JLabel lblPhoneNumberCoach = new JLabel("Phone Number");
		lblPhoneNumberCoach.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblPhoneNumberCoach.setBounds(211, 167, 172, 23);
		panelCoachInfo.add(lblPhoneNumberCoach);
		
		JLabel lblAddressCoach = new JLabel("Address");
		lblAddressCoach.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblAddressCoach.setBounds(211, 244, 172, 23);
		panelCoachInfo.add(lblAddressCoach);
		
		JLabel lblPostcodeCoach = new JLabel("Postcode");
		lblPostcodeCoach.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblPostcodeCoach.setBounds(211, 398, 172, 23);
		panelCoachInfo.add(lblPostcodeCoach);
		
		/**
		 * This button calls on the deleteCoach() method, passing through the Coach object which was obtained from the comboBox
		 */
		JButton btnDeleteCoach = new JButton("Delete Coach");
		btnDeleteCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDeleteCoach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Coach c = (Coach) comboBoxCoachSelection.getModel().getSelectedItem();
				
				deleteCoach(c);
			}
			
		});
		btnDeleteCoach.setBounds(503, 12, 140, 36);
		panelCoachInfo.add(btnDeleteCoach);
		
		/**
		 * This button calls on the saveCoachChanges() method
		 */
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSaveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coach c = (Coach) comboBoxCoachSelection.getModel().getSelectedItem();
				
				saveCoachChanges(c);
				
			}
			
		});
		btnSaveChanges.setBounds(503, 437, 140, 36);
		panelCoachInfo.add(btnSaveChanges);
		
		textEmailCoach = new JTextField();
		textEmailCoach.setFont(new Font("Dialog", Font.PLAIN, 16));
		textEmailCoach.setColumns(10);
		textEmailCoach.setBounds(211, 357, 229, 28);
		panelCoachInfo.add(textEmailCoach);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblEmail_1.setBounds(211, 321, 172, 23);
		panelCoachInfo.add(lblEmail_1);
		
		JPanel jPanelMembers = new JPanel();
		jPanelMembers.setBackground(new Color(143, 188, 143));
		tabbedPane.addTab("New tab", null, jPanelMembers, null);
		jPanelMembers.setLayout(null);
		
		textPassMember = new JTextField();
		textPassMember.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPassMember.setBounds(551, 221, 282, 34);
		jPanelMembers.add(textPassMember);
		textPassMember.setColumns(10);
		
		JLabel lblMemberPass = new JLabel("Enter a password:");
		lblMemberPass.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMemberPass.setBounds(551, 195, 171, 25);
		jPanelMembers.add(lblMemberPass);
		
		background_img = new ImageIcon("membericon.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(457, 506,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		JLabel lblMemberAdd = new JLabel("", background_img, JLabel.CENTER);
		lblMemberAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberAdd.setBounds(0, 0, 457, 506);
		jPanelMembers.add(lblMemberAdd);
		
		JButton btnNewButton = new JButton("Create Member");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createMember();
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnNewButton.setBounds(551, 283, 154, 34);
		jPanelMembers.add(btnNewButton);
		
		JPanel panelMemberTitle = new JPanel();
		panelMemberTitle.setBackground(new Color(85, 107, 47));
		panelMemberTitle.setBounds(482, 11, 425, 105);
		jPanelMembers.add(panelMemberTitle);
		panelMemberTitle.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Create A New Admin");
		lblNewLabel_2.setForeground(new Color(255, 235, 205));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel_2.setBounds(0, 11, 425, 83);
		panelMemberTitle.add(lblNewLabel_2);
		
		/**
		 * =============================================================================================================================================
		 * ------------------------------------- END OF CONSTRUCTOR ------------------------------------------------------------------------------------
		 * =============================================================================================================================================
		 */
		
		
	}
	
	/**
	 * Called by the mouseListener playerInformation
	 * Uses the Player element selected from the list to display their information
	 */
	public void displayPlayerInfo() {
		
		/*
		 	Clear health issues every time or it will stack
		 */
		healthIssues.clear();
		
		/*
		 	Set the panel to visible
		 */
		panelPlayerInfo.setVisible(true);
		
		/*
		 	Assign the selected Player object to 'p'
		 */
		Player p = list.getSelectedValue();
		
		/*
		 	Set all of the text fields to the Player object variables
		 */
		textFirstname.setText(p.getFname());
		textSurname.setText(p.getSurname());
		textAddress.setText(p.getAddress());
		textPostcode.setText(p.getPostcode());
		textPosition.setText(p.getPosition());
		textPhone.setText(p.getPhoneNumber());
		textSRU.setText(p.getSRU());
		textDoctor.setText(p.getDoctor());
		textDoctorContact.setText(p.getDoctor_telephone());
		textNOK.setText(p.getNext_of_kin());
		textNOKcontact.setText(p.getNext_of_kin_telephone());
		textDOB.setText(p.getDOB());
		textSquad.setText(p.getSquad().getName());
		textEmail.setText(p.getEmail());
		
		/*
		 	Get the Player's health issues arrayList and add all elements
		 */
		for (int i = 0; i < p.getHealthIssues().size(); i++) {
			healthIssues.addElement(p.getHealthIssues().get(i));
		}
	}
	
	/**
	 * Called by the ActionListener for the comboBoxCoachSelection
	 */
	public void displayCoachInfo() {
		
		/*
		 	Init the Coach object as the Item selected in the comboBox
		 */
		Coach c = (Coach)comboBoxCoachSelection.getModel().getSelectedItem();
		
		/*
		 	Assign all of the Coach variables to the text box's
		 */
		textFirstnameCoach.setText(c.getFirstname());
		textSurnameCoach.setText(c.getSurname());
		textPhoneCoach.setText(c.getPhone());
		textAddressCoach.setText(c.getAddress());
		textPostcodeCoach.setText(c.getPostcode());
		textEmailCoach.setText(c.getEmail());
		
		/*
	 		Implement try/catch incase a Squad has not been assigned to a Coach
		 */
		try {
			
			lblCoachSquad.setText(c.getSquad().getName());
			
		} catch (NullPointerException e) {
			
			/*
			 	Set the contents of the lblCoachSquad to this if the error was caught
			 */
			lblCoachSquad.setText("<No Squad>");
		}
	}

	/*
	 * Called by the ActionListener on comboBoxSquads 
	 * Displays the relevant information of the Squad object selected, fills the fields
	 */
	public void displaySquadInfo(Squad s) {
		
		lblSquadNameHeader.setText(s.getName());
		textSquadsSquadName.setText(s.getName());
		
		/*
		 	Implement try/catch incase a Coach has not been assigned to a Squad
		 */
		try {
			textSquadsCoach.setText(s.getCoach().getFirstname() + " " + s.getCoach().getSurname());
			
			/*
			 	Set to non-editable since the user cannot manually type in a coach
			 */
			textSquadsCoach.setEditable(false);
			
		} catch (NullPointerException e) {
			
			/*
			 	Set the contents of the textSquadsCoach textbox to this if the error was caught
			 */
			textSquadsCoach.setText("<No Coach>");
		}
		
	}
	
	/**
	 * Add a health issue to the JList
	 */
	public void addHealthIssue() {
		
		String newIssue = JOptionPane.showInputDialog("Enter a health issue: ");
		healthIssues.addElement(newIssue);
		
	}
	
	/**
	 * Remove a selected index from the healthIssues JList
	 */
	public void removeHealthIssue() {
		int index = jListHealthIssues.getSelectedIndex();
		if (index != -1) {
			healthIssues.remove(index);
		}
	}
	
	/**
	 * Gets the Coach and Squad lists and populates them with Objects using the Controller and Model
	 */
	public void populateLists() {
		
		coachlist = new Coach[myController.getModel().returnCoachList().length]; 
		coachlist = myController.getModel().returnCoachList(); 
		
		comboBoxCoachSelection = new JComboBox<Coach>(coachlist); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< coachlist
		
		squad = new Squad[myController.getModel().getSquads().length];
		squad = myController.getModel().getSquads();
		
		comboBoxSquads = new JComboBox<Squad>(squad); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< squad
	}

	/**
	 * Clears the playerModel which populates the JPanel in the Players Panel, then populates it with all Senior Players 
	 */
	public void addPlayers(Squad s) {
		
		int index = myController.getModel().getSquadList().indexOf(s);
		
		playersModel.clear();
		for (int i = 0; i < myController.getModel().getSquadList().get(index).getPlayerList().size(); i++) {
			playersModel.addElement(myController.getModel().getSquadList().get(index).getPlayerList().get(i));
		}
	}
	
	/**
	 * Opens a JDialog where the player can select a Coach object from a ComboBox to and invoke the setCoach(Coach c) method in 'Team' to replace/set the Coach
	 * -- Changes the Coach of a given Squad 's'
	 * 
	 * @param Squad s
	 */
	public void changeCoach(Squad s) {
		
		/*
		 	Init the JPanel
		 */
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Border panborder = BorderFactory.createTitledBorder("Change Coach");
		pan.setBorder(panborder);
		
		/*
		 	ComboBox populated with the array of Coach objects
		 */
		JComboBox<Coach> coachOptions = new JComboBox<Coach>(coachlist); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< coachlist
		coachOptions.setBounds(200, 140, 200, 25);

		/*
		 	Create the dialog
		 */
		JDialog changeTheCoach = new JDialog();
		changeTheCoach.setLocationRelativeTo(null);
		
		
		/*
		 	This button will trigger the setting of the Coach
		 */
		JButton assignCoach = new JButton("Assign Coach");
		assignCoach.setBounds(200, 175, 130, 25);
		assignCoach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean valid = true;
				
				Coach c = null;
				
				
				try {
					
					/*
				 		Try and store the selected ComboBox item as a Coach object
					 */
					c = (Coach)coachOptions.getModel().getSelectedItem();
					
					/*
				 		Set the Coach to the Squad 's'
					 */
					s.setCoach(c);
					
					if (s.getCoach() == c) {
						displayMessage("Coach Added!");
						
						changeTheCoach.dispose();
						
						refreshScreen();
					}
					
				} catch (NullPointerException n) {
					
					/*
					 	If trying to set coach variable to null pointer, set valid to false
					 */
					valid = false;
					displayMessage("You have not selected a coach!");
				}
				
				
				/*
				 	If valid ends false, display a message to user
				 */
				if (valid == false) {
					displayMessage("Failed to add coach");
				}
			}
			
		});

		changeTheCoach.getContentPane().add(assignCoach);
		pan.add(coachOptions);
		
		changeTheCoach.getContentPane().add(pan);
		changeTheCoach.setSize(400, 170);
		changeTheCoach.setTitle("Change Coach");
		
		changeTheCoach.setVisible(true);
		
	}
	
	/**
	 *	Creates a MembershipSecretary Object with the Password value given by the User
	 */
	public void createMember() {
		
		String memberPass = textPassMember.getText();
		
		/*
		 	Check if Password value is empty
		 */
		if (!memberPass.isEmpty()) {
			myController.createMembershipSecretary(memberPass);
			displayMessage("Member Created!");
			
			/*
			 	Display message with the ID and Password
			 */
			displayMessage("ID: " + myController.getModel().getMembersList().get(myController.getModel().getMembersList().size()- 1).getID() + ", Password: " + myController.getModel().getMembersList().get(myController.getModel().getMembersList().size()- 1).getPass() );
		}
		
		refreshScreen();
	}
	
	/**
	 * Opens a JDialog where the user can enter a String name into the text box and create a Squad object with that name value
	 */
	public void createSquad() {
		
		/*
		 	Create the panel
		 */
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Border panborder = BorderFactory.createTitledBorder("Create a new squad");
		pan.setBorder(panborder);
		
		/*
		 	Create a JComboBox where the user can choose "Junior" or "Senior"
		 */
		JComboBox<String> squadOptions = new JComboBox<String>();
		squadOptions.addItem("Senior");
		squadOptions.addItem("Junior");
		squadOptions.setBounds(200, 90, 150, 25);

		/*
		 	Create the dialog
		 */
		JDialog createSquad = new JDialog();
		createSquad.setLocationRelativeTo(null);
		
		/*
		 	Create the button which will trigger the event
		 */
		JButton createthesquad = new JButton("Create Squad");
		createthesquad.setBounds(200, 175, 150, 25);
		
		JLabel lblNewSquadName = new JLabel("Enter squad name: ");
		lblNewSquadName.setBounds(200, 120, 150, 20);
		
		JTextField squadName = new JTextField();
		squadName.setBounds(200, 145, 300, 30);
		
		createSquad.getContentPane().add(createthesquad);
		pan.add(squadOptions);
		pan.add(squadName);
		pan.add(lblNewSquadName);
		
		createSquad.getContentPane().add(pan);
		createSquad.setSize(800, 430);
		createSquad.setTitle("Create Squad");

		/*
		 	Assign an ActionListener to the button
		 */
		createthesquad.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				/*
				 	Get the ComboBox selection choice and store it in a String
				 */
				String type = (String) squadOptions.getModel().getSelectedItem();
				String name = squadName.getText();
				
				/*
				 	Use the controller method to create the squad and return the outcome in the state of numbers
				 	1 = empty string
				 	2 = success
				 	0 = Error
				 */
				int retVal = (myController.createSquad(type, name));
				
				if (retVal == 1) {
					displayMessage("Please enter a squad name!");
				} else if (retVal == 2) {
					displayMessage("Squad successfully created");
					
					createSquad.dispose();
					
					refreshScreen();
					
				} else {
					displayMessage("Error creating squad!");
				}
				
				
			}
		});
		
		createSquad.setVisible(true);
		
	}
	
	/**
	 * Saves the Squad name if changed then re-populates the lists to refresh the ComboBox's
	 */
	public void saveChanges(Squad squad) {
		
		/*
		 	Set the Squad name as the one provided in the textbox
		 */
		String s = textSquadsSquadName.getText();
		
		squad.setName(s);
		
		displayMessage("Squad Renamed.");
		
		refreshScreen();
	}
	
	/**
	 * Assigns all of the text field values to varaibles and calls on the Controller to validate them
	 * 
	 * If validation is okay, set the Coach objects values to these ones
	 * 
	 * @param Coach c
	 */
	public void saveCoachChanges(Coach c) {
		
		String firstname = textFirstnameCoach.getText();
		String surname = textSurnameCoach.getText();
		String phone = textPhoneCoach.getText();
		String address = textAddressCoach.getText();
		String postcode = textPostcodeCoach.getText();
		String email = textEmailCoach.getText();
	
		/*
		 	Store the return value of the function which determines what outcome to perform
		 */
		int val = myController.checkCoachDetails(firstname, surname, address, postcode, phone, email);
		
		if (val == 6) {
			c.setFirstname(firstname);
			c.setSurname(surname);
			c.setTelephone(phone);
			c.setAddress(address);
			c.setPostcode(postcode);
			c.setEmail(email);
			
			displayMessage("Changes saved.");
			
		} else {
			
			displayMessage("There are some field errors, please try again");
		}
		
	}
	
	/**
	 * Gets the values from the text fields and overwrites the previous Player obj values
	 * 
	 * @param Player p
	 */
	public void saveChangesPlayer(Player p) {
		
		String firstname = textFirstname.getText();
		String surname = textSurname.getText();
		String phone = textPhone.getText();
		String address = textAddress.getText();
		String postcode = textPostcode.getText();
		String email = textEmail.getText();
		String position = textPosition.getText();
		String NOK = textNOK.getText();
		String NOKContact = textNOKcontact.getText();
		String doctor = textDoctor.getText();
		String doctorContact = textDoctorContact.getText();
		String DOB = textDOB.getText();
		
		ArrayList<String> health = new ArrayList<String>();
		
		for (int i = 0; i < healthIssues.size(); i++) {
			health.add(healthIssues.get(i));
		}
		
		int age = myController.getModel().calculateAge(DOB);
		
		p.setAddress(address);
		p.setSurname(surname);
		p.setPhoneNumber(phone);
		p.setPostcode(postcode);
		p.setPosition(position);
		p.setEmail(email);
		p.setFname(firstname);
		p.setNextOfKin(NOK);
		p.setNextOfKinTele(NOKContact);
		p.setDoctor(doctor);
		p.setDoctorTele(doctorContact);
		p.setDOB(DOB);
		p.setAge(age);
		
		p.setHealthIssues(health);
		
		displayMessage("Changes saved.");
		
		refreshScreen();
		
	}
	
	/**
	 * Move Player to different Squad
	 * 
	 * @param Player p
	 */
	public void changeSquad(Player p) {
		
		Player thePlayer = p;
		/*
		 	Create the panel
		 */
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Border panborder = BorderFactory.createTitledBorder("Change Squad");
		pan.setBorder(panborder);
		
		/*
		 	Create a JComboBox where the user can choose "Junior" or "Senior"
		 */
		JComboBox<Squad> squadOptions = new JComboBox<Squad>(squad);
		squadOptions.setBounds(200, 120, 200, 25);
	
		/*
		 	Create the dialog
		 */
		JDialog changeSquad = new JDialog();
		changeSquad.setLocationRelativeTo(null);
		
		/*
		 	Create the button which will trigger the event
		 */
		JButton exeChangeSquad = new JButton("Apply Changes");
		exeChangeSquad.setBounds(200, 175, 110, 25);
		
		
		changeSquad.getContentPane().add(exeChangeSquad);
		pan.add(squadOptions);
		
		changeSquad.getContentPane().add(pan);
		changeSquad.setSize(800, 430);
		changeSquad.setTitle("Change Squad");
	
		/*
		 	Assign an ActionListener to the button
		 */
		exeChangeSquad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 	Store the return value of the function in this
				 */
				String retMessage = "";
				
				/*
				 	Store the Squad value as the ComboBox selected element
				 */
				Squad s = (Squad) squadOptions.getModel().getSelectedItem();
				
				/*
				 	If the squad isn't null, pass it through the Controller method
				 */
				if (s == null) {
					displayMessage("Please select a valid Squad");
				} else {
					retMessage = myController.changeSquad(thePlayer, s);
					displayMessage(retMessage);
					changeSquad.dispose();
				}
				
			}
			
		});
		
		changeSquad.setVisible(true);
	}
	
	/**
	 * Takes the parameter, sets the squad and squads coach to null, then removes the object from the coachList in Model
	 * 
	 * re-populate lists
	 * 
	 * @param Coach c
	 */
	public void deleteCoach(Coach c) {
		
		if (c != null) {
			
			c.getSquad().setCoach(null);
			c.setSquad(null);
			myController.getModel().getCoachList().remove(c);
			displayMessage("Coach deleted.");
			
			refreshScreen();
		} else {
			displayMessage("No coach selected!");
		}
		
		
	}
	
	/**
	 * Stores the combo box selection as Player 'p'
	 * 
	 * Gets that object from the Player's squad and removes it from the squad
	 * Also removes it from the PlayerModel arraylist
	 * 
	 * re-populate lists
	 * 
	 * @param Player p
	 */
	public void removePlayer(Player p) {
		
		Player play = p;
		
		myController.getModel().getpsmodel().removePlayer(play);
		play.getSquad().removePlayer(play);
		
		displayMessage("Player removed.");
		
		refreshScreen();
		
	}
	
	/**
	 * Re-creates the screen to refresh the fields
	 */
	public void refreshScreen() {
		dispose();
		myController.createMemberMainScreen(myController);
	}
	
	// Making messages to user for accessible
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
